import { Component, Input } from '@angular/core';
import { Problem } from '../../model/problem';

@Component({
  selector: 'app-problem',
  standalone: true,
  imports: [],
  templateUrl: './problem.component.html',
  styleUrl: './problem.component.scss'
})
export class ProblemComponent {


  @Input() dimension!: number;
  @Input() description!: number[];

  toggleCell(ix: number): void {
    if (this.description[ix] === 0) {
      this.description[ix] = 1;
    } else {
      this.description[ix] = 0;
    }
  }

  
}
