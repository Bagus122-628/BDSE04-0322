import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/user';
import { UserAccountsService } from 'src/app/user-accounts.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  userProfileData: User | any;
  loggedIn = this.userService.loggedIn;

  constructor(private userService: UserAccountsService) {}

  ngOnInit(): void {
    this.getUser();
  }

  logout() {
    this.userService.loggedIn = false;
  }

  getUser(): void {
    const id = this.userService.userLoginID;
    this.userService
      .getUserID(id)
      .subscribe((id) => (this.userProfileData = id));
  }
}
