import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserAccountsService } from 'src/app/user-accounts.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
})
export class RegistrationComponent implements OnInit {
  forms: any = {};
  formSubmitData = {};

  constructor(
    private router: Router,
    private userAccounts: UserAccountsService
  ) {}
  ngOnInit(): void {}

  onSubmit() {
    this.formSubmitData = {
      id: this.userAccounts.id + 1,
      email: this.forms.email,
      password: this.forms.password,
      firstName: this.forms.firstName,
      lastName: this.forms.lastName,
      country: this.forms.country,
      city: this.forms.city,
      company: this.forms.company,
    };

    this.userAccounts.addNewAccount(this.formSubmitData);
    this.router.navigate(['/registration-confirmation']);
  }
}
