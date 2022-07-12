import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import { USERS } from 'src/app/mock-user';
import { User } from 'src/app/user';
import { UserAccountsService } from 'src/app/user-accounts.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css'],
})
export class LoginFormComponent implements OnInit {
  validEmail = false;
  validPassword = false;
  userInputEmail = '';
  userInputPassword = '';
  emailFounded: User | undefined;

  constructor(
    private router: Router,
    private userAccounts: UserAccountsService
  ) {}

  ngOnInit(): void {}

  findEmail(email: string): Observable<User | undefined> {
    const emailFound = USERS.find((user) => user.email === email);
    this.validEmail = !!emailFound;
    return of(emailFound);
  }

  getFoundedEmail() {
    this.findEmail(this.userInputEmail).subscribe(
      (user) => (this.emailFounded = user)
    );
  }

  validatePassword(password: string) {
    this.getFoundedEmail();
    const passwordFound = this.emailFounded?.password === password;
    this.validPassword = passwordFound;
  }

  onLogin() {
    this.validatePassword(this.userInputPassword);

    if (this.validEmail && this.validPassword) {
      this.userAccounts.loggedIn = true;
      this.userAccounts.userLoginID = this.emailFounded?.id!;
      this.router.navigate([`/profile/${this.emailFounded?.id}`]);
    }
  }
}
