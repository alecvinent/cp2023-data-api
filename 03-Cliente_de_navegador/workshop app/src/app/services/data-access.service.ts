import {Injectable} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {map, Observable, of} from "rxjs";
import * as Highcharts from 'highcharts';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DataAccessService {
  constructor(private httpClient: HttpClient) { }
  chartData$: Observable<{ chartTitle: string; chartOptions: Partial<Highcharts.Options> }[]> =
    this.httpClient.get<{ [key: string]: { [key: string]: { data: { year: number; value: number }[]}}}>(`${environment.apiUrl}/v1/demographicData`)
    .pipe(
      map((data:  { [key: string]: { [key: string]: { data: { year: number; value: number }[] }}}) => {
        const dataSeries: any = {};
        Object.keys(data).forEach((key) => {

          // gdiIndex || giiIndex
          dataSeries[key] ??= {};
          const countries: string[] = [];
          const years: any[] = [];

          // World || Latam || Uruguay
          Object.keys(data[key]).forEach((country) => {
            dataSeries[key]['series'] ??= [] as { name: number; data: number[] }[];
            dataSeries[key]['categories'] ??= [];
            dataSeries[key]['categories'].push(country);
            countries.push(country);
            data[key][country].data.forEach((data) => {
              if (!years.includes(data.year)) years.push(data.year);
            });
          });

          years.forEach((year) => {
            const dat: any[] = [];
            countries.forEach((country) => {
              dat.push(data[key][country].data.find((data) => data.year === year)?.value);
            });
            dataSeries[key]['series'].push({
              name: year,
              data: dat,
            })
          });
        });

      return Object.keys(dataSeries).map((key) => ({
        chartTitle: key,
        chartOptions: {
          chart: {
            type: 'column',
          },
          title: {
            text: '',
          },
          xAxis: {
            categories: dataSeries[key].categories,
            title: {
              text: '',
            },
          },
          yAxis: {
            title: {
              text: '',
            },
          },
          series: dataSeries[key].series,
        }
      }));
    }),
  );
}
