import { Component } from '@angular/core';

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
}
