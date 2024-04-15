import { Component, Input } from '@angular/core';
import { Problem } from '../../model/problem';

@Component({
  selector: 'app-problem',
  standalone: true,
  imports: [],
  templateUrl: './problem.component.html',
  styleUrl: './problem.component.scss'
})
export class ProblemComponent {


  @Input() dimension!: number;
  @Input() description!: number[];

  toggleCell(ix: number): void {
    if (this.description[ix] === 0) {
      this.description[ix] = 1;
    } else {
      this.description[ix] = 0;
    }
    
  }

  toggleAdjacentTiles(index: number): void {
    const i = Math.floor(index / this.dimension); 
    const j = index % this.dimension;

    const adjacentIndices = [
      [i - 1, j], // Up
      [i + 1, j], // Down
      [i, j - 1], // Left
      [i, j + 1], // Right
    ];
  
    adjacentIndices.forEach(([row, col]) => {
      if (row >= 0 && row < this.dimension && col >= 0 && col < this.dimension) {
        const adjacentIndex = row * this.dimension + col;
        console.log("Des. size: ", this.dimension*this.dimension, "Index: ", adjacentIndex)
        if (this.description[adjacentIndex] === 0) {
          this.description[adjacentIndex] =1;
        } else {
          this.description[adjacentIndex] =0;
        }
      }
    });
    console.log(this.description);
  }

  
}
