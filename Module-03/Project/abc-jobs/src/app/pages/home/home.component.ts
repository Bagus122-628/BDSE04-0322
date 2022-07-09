import { Component, OnInit } from '@angular/core';
import { PARTNERS } from './partners';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  partners = PARTNERS;
  constructor() {}

  ngOnInit(): void {}
}
