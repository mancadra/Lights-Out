import { Injectable } from '@angular/core';
import { WebRequestService } from './web-request.service';
import { Problem } from '../model/problem';
import { Solution } from '../model/solution';

@Injectable({
  providedIn: 'root'
})
export class SolutionService {

  constructor(private webReqService: WebRequestService) { }

  
  getSolutionToProblem(id: number) {
    return this.webReqService.get('solutions/problem/${id}');
  }

  getSolutions() {
    return this.webReqService.get('solutions')
  }

}
