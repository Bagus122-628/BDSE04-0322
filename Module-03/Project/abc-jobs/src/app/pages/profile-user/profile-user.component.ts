import { Component, OnInit } from '@angular/core';

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
  constructor() {}

  ngOnInit(): void {}
}
