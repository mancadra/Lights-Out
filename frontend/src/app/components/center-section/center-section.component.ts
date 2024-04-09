import { Component } from '@angular/core';
import { ProblemComponent } from '../problem/problem.component';

@Component({
  selector: 'app-center-section',
  standalone: true,
  imports: [
    ProblemComponent
  ],
  templateUrl: './center-section.component.html',
  styleUrl: './center-section.component.scss'
})
export class CenterSectionComponent {

}
