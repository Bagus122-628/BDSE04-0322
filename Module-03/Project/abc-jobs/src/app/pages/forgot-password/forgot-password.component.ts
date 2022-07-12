import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/user';
import { UserAccountsService } from 'src/app/user-accounts.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css'],
})
export class ForgotPasswordComponent implements OnInit {
  userData: User | undefined;
  userInputEmail = '';

  constructor(
    private userService: UserAccountsService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  getUser(): void {
    this.userService
      .getUserEmail(this.userInputEmail)
      .subscribe((user) => (this.userData = user));
  }

  onResetPassword() {
    this.getUser();
    if (this.userData != undefined) {
      this.userData.password = 'password123';
      this.router.navigate(['/forgot-password-confirmation']);
    }
  }
}
