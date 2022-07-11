import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
})
export class RegistrationComponent implements OnInit {
  forms: any = {};
  formSubmitData = {};

  constructor(private router: Router) {}
  ngOnInit(): void {}

  onSubmit() {
    this.formSubmitData = JSON.stringify(this.forms);
    this.router.navigate(['/registration-confirmation']);
  }
}
