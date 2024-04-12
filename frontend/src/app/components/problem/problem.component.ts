import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-problem',
  standalone: true,
  imports: [],
  templateUrl: './problem.component.html',
  styleUrl: './problem.component.scss'
})
export class ProblemComponent {
  dimension = 3;
  description = [0, 0, 1, 0, 0, 0, 0, 0, 0];

  /*@Input() dimension: number;
  @Input() description: number[];*/

  ngOnInit() {
    if (typeof document !== 'undefined') {
      document.addEventListener("click", (event) => {
        const target = event.target as HTMLElement;
        if (target.matches('.cell')) {
          //const currentIx: number = +(target.getAttribute('data-index') ?? '0');
          const dataIndexAttr = target.getAttribute('data-index') ?? '0';
  console.log('Data-index attribute value:', dataIndexAttr);
  console.log('Type of data-index attribute value:', typeof dataIndexAttr);

  const currentIx: number = +dataIndexAttr;
  console.log('Current index:', currentIx);
  console.log('Type of current index:', typeof currentIx);


          const prevVal = this.description[currentIx];
          this.description[currentIx] = prevVal === 0 ? 1 : 0;
          target.id = prevVal === 0 ? 'light-1' : 'light-0';
          console.log('New ID:', target.id);
          console.log(this.description);
          console.log("currentIx: ", currentIx);
        }
      });
    }
  }

  
}
