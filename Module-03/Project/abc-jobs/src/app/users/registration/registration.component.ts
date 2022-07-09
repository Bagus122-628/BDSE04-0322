import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
})
export class RegistrationComponent implements OnInit {
  element = false;
  firstValidate = false;

  registerNext() {
    return (this.element = true);
  }
  constructor() {}

  ngOnInit(): void {}
}
