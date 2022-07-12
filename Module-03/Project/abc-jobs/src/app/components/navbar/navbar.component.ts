import { Component, OnInit } from '@angular/core';
import { UserAccountsService } from 'src/app/user-accounts.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  loggedIn = this.userAccounts.loggedIn;

  constructor(private userAccounts: UserAccountsService) {}

  ngOnInit(): void {}
}
