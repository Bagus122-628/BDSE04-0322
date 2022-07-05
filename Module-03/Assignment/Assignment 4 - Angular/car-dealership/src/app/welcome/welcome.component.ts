import { Component, OnInit } from '@angular/core';
import { SPONSORS } from '../sponsor';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css'],
})
export class WelcomeComponent implements OnInit {
  sponsors = SPONSORS;

  constructor() {}

  ngOnInit(): void {}
}
