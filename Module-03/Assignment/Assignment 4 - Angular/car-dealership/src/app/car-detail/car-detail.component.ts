import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { CarsService } from '../cars.service';
import { Car } from '../car';

@Component({
  selector: 'app-car-detail',
  templateUrl: './car-detail.component.html',
  styleUrls: ['./car-detail.component.css'],
})
export class CarDetailComponent implements OnInit {
  car: Car | undefined;
  constructor(
    private route: ActivatedRoute,
    private carsService: CarsService
  ) {}

  ngOnInit(): void {
    this.getCar();
  }

  getCar(): void {
    const make = String(this.route.snapshot.paramMap.get('make'));
    this.carsService.getCar(make).subscribe((car) => (this.car = car));
  }
}
