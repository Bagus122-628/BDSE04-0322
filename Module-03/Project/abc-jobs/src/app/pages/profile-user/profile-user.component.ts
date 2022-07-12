import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from 'src/app/user';
import { UserAccountsService } from 'src/app/user-accounts.service';

const DUMMYUSER = [
  {
    name: 'Ricky',
    country: 'country',
    city: 'city',
    company: 'company',
  },
  {
    name: 'Alex',
    country: 'country',
    city: 'city',
    company: 'company',
  },
  {
    name: 'Molarya',
    country: 'country',
    city: 'city',
    company: 'company',
  },
];

@Component({
  selector: 'app-profile-user',
  templateUrl: './profile-user.component.html',
  styleUrls: ['./profile-user.component.css'],
})
export class ProfileUserComponent implements OnInit {
  dummyUser = DUMMYUSER;
  userData: User | any;

  constructor(
    private route: ActivatedRoute,
    private userService: UserAccountsService
  ) {}

  ngOnInit(): void {
    this.getUser();
  }

  getUser(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.userService.getUserID(id).subscribe((id) => (this.userData = id));
  }
}
