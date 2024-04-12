import { Component } from '@angular/core';
import { ProblemComponent } from '../problem/problem.component';
import { SolutionService } from '../../control/solution.service';
import { Problem } from '../../model/problem';
import { Solution } from '../../model/solution';
import { SolutionStep } from '../../model/solutionStep';

@Component({
  selector: 'app-solve-problem',
  standalone: true,
  imports: [
    ProblemComponent
  ],
  templateUrl: './solve-problem.component.html',
  styleUrl: './solve-problem.component.scss'
})
export class SolveProblemComponent {
  constructor(private solutionService: SolutionService) {
    this.problem = {
      dimension: 3,
      description: [0, 0, 0, 0, 0, 0, 0, 0, 0] // Example default description
    };

    this.solution = {
      steps_nr: 1,
    };

    this.solutionStep = {
      description: [ 0, 0, 0, 0, 0, 0, 0, 0, 0],
      steps_ix: 1,
    }
  }

  private problem: Problem;
  private solution: Solution;
  private solutionStep : SolutionStep;

  getSolutionToProblem() {
    if (this.problem && this.problem.id) {
      this.solutionService.getSolutionToProblem(this.problem.id).subscribe((response: any) => {
        console.log(response);
      });
    } else {
      console.error("Problem ID is not defined.");
    }
  }

}
