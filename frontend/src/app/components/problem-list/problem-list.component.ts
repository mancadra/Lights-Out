import { Component } from '@angular/core';
import { ProblemComponent } from '../problem/problem.component';
import { ProblemService } from '../../control/problem.service';
import { Problem } from '../../model/problem';
import { Router } from '@angular/router';


@Component({
  selector: 'app-problem-list',
  standalone: true,
  imports: [
    ProblemComponent
  ],
  templateUrl: './problem-list.component.html',
  styleUrl: './problem-list.component.scss'
})
export class ProblemListComponent {
  constructor(private problemService: ProblemService, private router: Router) {
    this.problem = {
      dimension: 3,
      description: [0, 0, 0, 0, 0, 0, 0, 0, 0] // Example default description
    };
  }

  private problem: Problem;

  problems: Problem[] = [];

  ngOnInit() {
    this.getProblems();
  }

  getProblems() {
    this.problemService.getProblems().subscribe((response: any) => {
      this.problems = response;
      console.log(response);
    });
  }

  viewSolveProblem(problemId?: number) {
    this.router.navigate(['/problem/', problemId]);
  }
}
