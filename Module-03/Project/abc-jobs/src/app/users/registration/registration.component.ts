import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { USERS } from 'src/app/mock-user';
import { User } from 'src/app/user';
import { UserAccountsService } from 'src/app/user-accounts.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
})
export class RegistrationComponent implements OnInit {
  forms: any = {};
  users: User[] = [];
  mockUsers = USERS;

  constructor(
    private router: Router,
    private userAccounts: UserAccountsService
  ) {}

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers(): void {
    this.userAccounts.getUsers().subscribe((users) => (this.users = users));
  }

  onSubmit() {
    this.mockUsers.push({
      id: this.users.length + 1,
      email: this.forms.email,
      password: this.forms.password,
      firstName: this.forms.firstName,
      lastName: this.forms.lastName,
      country: this.forms.country,
      city: this.forms.city,
      company: this.forms.company,
    });
    console.log(this.users);

    this.router.navigate(['/registration-confirmation']);
  }
}
