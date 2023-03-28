import {Component, ViewChild} from '@angular/core';
import * as Highcharts from 'highcharts';
import {DataAccessService} from "../services/data-access.service";
import {IntersectionObserverDirective} from "ngx-intersection-observer";
import {Subject, takeUntil} from "rxjs";

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page{
  Highcharts = Highcharts;
  destroy$ = new Subject<void>();
  chart: Highcharts.Chart[] = [];
  @ViewChild('observedCard', {read: IntersectionObserverDirective}) observedCard!: IntersectionObserverDirective;
  constructor(public dataAccessService: DataAccessService) {  }

  updateChart(chart: Highcharts.Chart) {
    this.chart.push(chart);
  }

  ngAfterViewInit() {
    if (this.observedCard){
      this.observedCard.intersection
        .pipe(
          takeUntil(this.destroy$)
        )
        .subscribe((entry) => {
          if (entry.intersect) {
            this.chart?.forEach(chart => chart.reflow());
          }
      });
    }
  }

  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }
}
