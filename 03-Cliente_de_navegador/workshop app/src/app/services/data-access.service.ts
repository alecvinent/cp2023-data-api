import {Injectable} from '@angular/core';
import {map, Observable, of} from "rxjs";
import * as Highcharts from 'highcharts';

@Injectable({
  providedIn: 'root'
})
export class DataAccessService {
  chartData$: Observable<{chartTitle: string; chartOptions: Partial<Highcharts.Options>}[]> = of({
    "giiIndex": {
      "World": {
        "country": "WORLD",
        "data": [{"year": 2002, "value": 0.548}, {"year": 2003, "value": 0.543}, {
          "year": 2004,
          "value": 0.535
        }, {"year": 2005, "value": 0.526}, {"year": 2006, "value": 0.52}, {"year": 2007, "value": 0.514}, {
          "year": 2008,
          "value": 0.511
        }, {"year": 2009, "value": 0.506}, {"year": 2010, "value": 0.504}, {"year": 2011, "value": 0.5}, {
          "year": 2012,
          "value": 0.495
        }, {"year": 2013, "value": 0.49}, {"year": 2014, "value": 0.487}, {"year": 2015, "value": 0.478}, {
          "year": 2016,
          "value": 0.473
        }, {"year": 2017, "value": 0.468}, {"year": 2018, "value": 0.466}, {
          "year": 2019,
          "value": 0.465
        }, {"year": 2020, "value": 0.465}, {"year": 2021, "value": 0.465}]
      },
      "Latam": {
        "country": "LATAM",
        "data": [{"year": 2002, "value": 0.475}, {"year": 2003, "value": 0.465}, {
          "year": 2004,
          "value": 0.461
        }, {"year": 2005, "value": 0.454}, {"year": 2006, "value": 0.452}, {
          "year": 2007,
          "value": 0.448
        }, {"year": 2008, "value": 0.444}, {"year": 2009, "value": 0.441}, {
          "year": 2010,
          "value": 0.437
        }, {"year": 2011, "value": 0.433}, {"year": 2012, "value": 0.427}, {
          "year": 2013,
          "value": 0.422
        }, {"year": 2014, "value": 0.416}, {"year": 2015, "value": 0.41}, {"year": 2016, "value": 0.405}, {
          "year": 2017,
          "value": 0.4
        }, {"year": 2018, "value": 0.393}, {"year": 2019, "value": 0.388}, {
          "year": 2020,
          "value": 0.387
        }, {"year": 2021, "value": 0.381}]
      },
      "Uruguay": {
        "country": "URUGUAY",
        "data": [{"year": 2002, "value": 0.376}, {"year": 2003, "value": 0.365}, {
          "year": 2004,
          "value": 0.364
        }, {"year": 2005, "value": 0.366}, {"year": 2006, "value": 0.359}, {
          "year": 2007,
          "value": 0.348
        }, {"year": 2008, "value": 0.342}, {"year": 2009, "value": 0.334}, {
          "year": 2010,
          "value": 0.321
        }, {"year": 2011, "value": 0.33}, {"year": 2012, "value": 0.329}, {"year": 2013, "value": 0.333}, {
          "year": 2014,
          "value": 0.328
        }, {"year": 2015, "value": 0.297}, {"year": 2016, "value": 0.29}, {"year": 2017, "value": 0.269}, {
          "year": 2018,
          "value": 0.258
        }, {"year": 2019, "value": 0.253}, {"year": 2020, "value": 0.242}, {"year": 2021, "value": 0.235}]
      }
    },
    "gdiIndex": {
      "World": {
        "country": "WORLD",
        "data": [{"year": 2002, "value": 0.92}, {"year": 2003, "value": 0.924}, {
          "year": 2004,
          "value": 0.925
        }, {"year": 2005, "value": 0.928}, {"year": 2006, "value": 0.93}, {"year": 2007, "value": 0.932}, {
          "year": 2008,
          "value": 0.933
        }, {"year": 2009, "value": 0.935}, {"year": 2010, "value": 0.938}, {"year": 2011, "value": 0.94}, {
          "year": 2012,
          "value": 0.944
        }, {"year": 2013, "value": 0.946}, {"year": 2014, "value": 0.949}, {
          "year": 2015,
          "value": 0.949
        }, {"year": 2016, "value": 0.952}, {"year": 2017, "value": 0.953}, {
          "year": 2018,
          "value": 0.955
        }, {"year": 2019, "value": 0.956}, {"year": 2020, "value": 0.957}, {"year": 2021, "value": 0.958}]
      },
      "Latam": {
        "country": "LATAM",
        "data": [{"year": 2002, "value": 0.96}, {"year": 2003, "value": 0.96}, {
          "year": 2004,
          "value": 0.963
        }, {"year": 2005, "value": 0.966}, {"year": 2006, "value": 0.967}, {"year": 2007, "value": 0.97}, {
          "year": 2008,
          "value": 0.972
        }, {"year": 2009, "value": 0.974}, {"year": 2010, "value": 0.976}, {
          "year": 2011,
          "value": 0.975
        }, {"year": 2012, "value": 0.976}, {"year": 2013, "value": 0.976}, {
          "year": 2014,
          "value": 0.976
        }, {"year": 2015, "value": 0.978}, {"year": 2016, "value": 0.979}, {
          "year": 2017,
          "value": 0.978
        }, {"year": 2018, "value": 0.98}, {"year": 2019, "value": 0.982}, {"year": 2020, "value": 0.985}, {
          "year": 2021,
          "value": 0.986
        }]
      },
      "Uruguay": {
        "country": "URUGUAY",
        "data": [{"year": 2002, "value": 1.006}, {"year": 2003, "value": 1.012}, {
          "year": 2004,
          "value": 1.008
        }, {"year": 2005, "value": 1.011}, {"year": 2006, "value": 1.007}, {"year": 2007, "value": 1.01}, {
          "year": 2008,
          "value": 1.01
        }, {"year": 2009, "value": 1.011}, {"year": 2010, "value": 1.014}, {"year": 2011, "value": 1.02}, {
          "year": 2012,
          "value": 1.02
        }, {"year": 2013, "value": 1.017}, {"year": 2014, "value": 1.018}, {
          "year": 2015,
          "value": 1.018
        }, {"year": 2016, "value": 1.021}, {"year": 2017, "value": 1.018}, {
          "year": 2018,
          "value": 1.019
        }, {"year": 2019, "value": 1.02}, {"year": 2020, "value": 1.019}, {"year": 2021, "value": 1.022}]
      }
    }
  }).pipe(
    map((data: {
      [key: string]: {
        [key: string]: { data: { year: number; value: number }[] }
      }
    }) => {
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
