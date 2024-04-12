import { TestBed } from '@angular/core/testing';
import { HttpClientModule } from '@angular/common/http'; // Import HttpClientModule
import { ProblemService } from './problem.service';

describe('ProblemService', () => {
  let service: ProblemService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientModule], // Add HttpClientModule to imports
    });
    service = TestBed.inject(ProblemService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
