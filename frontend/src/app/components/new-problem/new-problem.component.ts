import { Component } from '@angular/core';
import { ProblemService } from '../../control/problem.service';
import { Problem } from '../../model/problem';
import { ProblemComponent } from '../problem/problem.component';

@Component({
  selector: 'app-new-problem',
  standalone: true,
  imports: [
    ProblemComponent
  ],
  templateUrl: './new-problem.component.html',
  styleUrl: './new-problem.component.scss'
})
export class NewProblemComponent {
  constructor(private problemService: ProblemService) {
    this.problem = {
      dimension: 3,
      description: [0, 0, 0, 0, 0, 0, 0, 0, 0] // Example default description
    };
  }

  private problem: Problem;

  createProblem() {
    this.problemService.createProblem(this.problem).subscribe((response: any) => {
      console.log(response);
    });
  }

  problems: Problem[] = [];

  /*getProblems() {
    this.problemService.getProblems().subscribe((response: any) => {
      console.log(response);
    });
  }*/
}
