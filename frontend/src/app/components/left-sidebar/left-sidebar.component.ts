import { Component } from '@angular/core';
import { ProblemService } from '../../control/problem.service';
import { Problem } from '../../model/problem';
import { Router } from '@angular/router';

@Component({
  selector: 'app-left-sidebar',
  standalone: true,
  imports: [],
  templateUrl: './left-sidebar.component.html',
  styleUrl: './left-sidebar.component.scss'
})
export class LeftSidebarComponent {

  constructor(private problemService: ProblemService, private router: Router) {
    this.problem = {
      dimension: 3,
      description: [0, 0, 0, 0, 0, 0, 0, 0, 0] // Example default description
    };
  }

  private problem: Problem;

  problems: Problem[] = [];

  getProblems() {
    this.problemService.getProblems().subscribe((response: any) => {
      console.log(response);
    });
  }

  viewAllProblems() {
    this.router.navigate(['/problems']);
  }

  viewNewProblem() {
    this.router.navigate(['/new-problem']);
  }

}
