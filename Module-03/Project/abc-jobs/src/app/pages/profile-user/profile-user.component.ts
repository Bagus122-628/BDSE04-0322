import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from 'src/app/user';
import { UserAccountsService } from 'src/app/user-accounts.service';

@Component({
  selector: 'app-profile-user',
  templateUrl: './profile-user.component.html',
  styleUrls: ['./profile-user.component.css'],
})
export class ProfileUserComponent implements OnInit {
  userProfileData: User | any;
  dummyUser: User[] = [];

  constructor(
    private route: ActivatedRoute,
    private userService: UserAccountsService
  ) {}

  ngOnInit(): void {
    this.getUsers();
    this.getUser();
    const filteredUser = this.dummyUser.filter(
      (user) => user.email != this.userProfileData.email
    );
    this.dummyUser = filteredUser;
  }

  getUsers(): void {
    this.userService.getUsers().subscribe((users) => (this.dummyUser = users));
  }

  getUser(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.userService
      .getUserID(id)
      .subscribe((id) => (this.userProfileData = id));
  }
}
