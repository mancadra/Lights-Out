import { Injectable } from '@angular/core';
import { WebRequestService } from './web-request.service';
import { Problem } from '../model/problem';

@Injectable({
  providedIn: 'root'
})
export class ProblemService {

  constructor(private webReqService: WebRequestService) { }

  createProblem(problem: Problem) {
    return this.webReqService.post(`problems`, problem);
  }

  getProblem(id: number) {
    return this.webReqService.get(`problems/${id}`);
  }

  getProblems() {
    return this.webReqService.get(`problems`);
  }

  
}
