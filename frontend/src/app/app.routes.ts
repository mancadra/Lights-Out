import { Routes } from '@angular/router';
import { NewProblemComponent } from './components/new-problem/new-problem.component';
import { ProblemListComponent } from './components/problem-list/problem-list.component';
import { SolveProblemComponent } from './components/solve-problem/solve-problem.component';


export const routes: Routes = [
   // { path: '', component: ViewAllComponent}
   { path: 'new-problem', component: NewProblemComponent},
   { path: 'problems', component: ProblemListComponent},
   { path: 'problem/:id', component: SolveProblemComponent}
];
