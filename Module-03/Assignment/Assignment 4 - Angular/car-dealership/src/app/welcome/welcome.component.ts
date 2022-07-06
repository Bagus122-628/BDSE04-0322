import { Component, OnInit } from '@angular/core';
import { CARS } from '../cars';
import { SPONSORS } from '../sponsor';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css'],
})
export class WelcomeComponent implements OnInit {
  sponsors = SPONSORS;
  cars = CARS;

  constructor() {}

  ngOnInit(): void {}
}
