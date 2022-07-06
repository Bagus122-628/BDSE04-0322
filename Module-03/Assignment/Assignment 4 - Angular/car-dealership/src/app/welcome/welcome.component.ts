import { Component, OnInit } from '@angular/core';
import { SPONSORS } from '../sponsor';
import { FEATURED } from '../mock-cars';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css'],
})
export class WelcomeComponent implements OnInit {
  sponsors = SPONSORS;
  featured = FEATURED;

  constructor() {}

  ngOnInit(): void {}
}
