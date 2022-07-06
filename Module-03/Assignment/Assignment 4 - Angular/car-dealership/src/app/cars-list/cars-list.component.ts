import { Component, OnInit } from '@angular/core';
import { Car } from '../car';
import { CarsService } from '../cars.service';

@Component({
  selector: 'app-cars-list',
  templateUrl: './cars-list.component.html',
  styleUrls: ['./cars-list.component.css'],
})
export class CarsListComponent implements OnInit {
  cars: Car[] = [];

  constructor(private carsService: CarsService) {}

  ngOnInit(): void {
    this.getCars();
  }

  getCars(): void {
    this.carsService.getCars().subscribe((cars) => (this.cars = cars));
  }
}
