import { Component, OnInit } from '@angular/core';
import { ProblemComponent } from '../problem/problem.component';
import { SolutionService } from '../../control/solution.service';
import { Problem } from '../../model/problem';
import { Solution } from '../../model/solution';
import { SolutionStep } from '../../model/solutionStep';
import { ProblemService } from '../../control/problem.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-solve-problem',
  standalone: true,
  imports: [
    ProblemComponent
  ],
  templateUrl: './solve-problem.component.html',
  styleUrl: './solve-problem.component.scss'
})
export class SolveProblemComponent implements OnInit{
  problem: Problem | null = null;
  copiedProblem: Problem | null = null;

  constructor(private solutionService: SolutionService, private problemService: ProblemService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      const problemId = params.get('id');
      if (problemId) {
        // Fetch the problem data based on the ID
        this.problemService.getProblem(Number(problemId)).subscribe((response: any) => {
          // Check if the response is a Problem object
          if (response && response.dimension && response.description) {
            this.problem = response as Problem;
            this.copiedProblem = JSON.parse(JSON.stringify(this.problem));
          } else {
            console.error('Invalid response from server.');
          }
        });
      }
    });
  }

  getSolutionToProblem() {
    if (this.problem && this.problem.id) {
      this.solutionService.getSolutionToProblem(this.problem.id).subscribe((response: any) => {
        console.log(response);
      });
    } else {
      console.error("Problem ID is not defined.");
    }
  }

  getProblem(id: number) {
    this.problemService.getProblem(id).subscribe((response: any) => {
      this.problem = response;
      this.copiedProblem = JSON.parse(JSON.stringify(this.problem));
      console.log(response);
    });
  }

  resetProblem() {
    if (this.problem) {
      this.copiedProblem = JSON.parse(JSON.stringify(this.problem));
    }
  }

}
