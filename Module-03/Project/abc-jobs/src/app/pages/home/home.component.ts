import { Component, OnInit } from '@angular/core';
import { UserAccountsService } from 'src/app/user-accounts.service';

const PARTNERS = [
  {
    logo: '../../../assets/images/Partners/aws.png',
    alt: 'AWS',
  },
  {
    logo: '../../../assets/images/Partners/facebook.png',
    alt: 'Facebook',
  },
  {
    logo: '../../../assets/images/Partners/google.png',
    alt: 'Google',
  },
  {
    logo: '../../../assets/images/Partners/lithan.png',
    alt: 'Lithan',
  },
  {
    logo: '../../../assets/images/Partners/microsoft.png',
    alt: 'Microsoft',
  },
  {
    logo: '../../../assets/images/Partners/samsung.png',
    alt: 'Samsung',
  },
];

const TOPICS = [
  { topic: 'Remote' },
  { topic: 'Internship' },
  { topic: 'Freelancer' },
  { topic: 'Edutation' },
  { topic: 'Full Time' },
  { topic: 'Design' },
];

const FEATUREDJOBS = [
  {
    logo: '../../../assets/images/logo/google.png',
    alt: 'Google',
    jobName: 'Web Developer',
    company: 'Google.com',
    tags: ['Internship', 'Remote'],
  },
  {
    logo: '../../../assets/images/logo/microsoft.png',
    alt: 'Microsoft',
    jobName: 'App Developer',
    company: 'Microsoft.com',
    tags: ['Full Time', 'Senior'],
  },
  {
    logo: '../../../assets/images/logo/facebook.png',
    alt: 'Facebook',
    jobName: 'Web Developer',
    company: 'Facebook.com',
    tags: ['Internship', 'Full Time'],
  },
];

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  partners = PARTNERS;
  topics = TOPICS;
  jobs = FEATUREDJOBS;
  loggedIn = this.userAccounts.loggedIn;

  constructor(private userAccounts: UserAccountsService) {}

  ngOnInit(): void {}
}
