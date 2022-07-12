import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from 'src/app/user';
import { UserAccountsService } from 'src/app/user-accounts.service';

@Component({
  selector: 'app-public-profile',
  templateUrl: './public-profile.component.html',
  styleUrls: ['./public-profile.component.css'],
})
export class PublicProfileComponent implements OnInit {
  userProfileData: User | any;

  constructor(
    private route: ActivatedRoute,
    private userService: UserAccountsService
  ) {}

  ngOnInit(): void {
    this.getUser();
  }

  getUser(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.userService
      .getUserID(id)
      .subscribe((id) => (this.userProfileData = id));
  }
}
