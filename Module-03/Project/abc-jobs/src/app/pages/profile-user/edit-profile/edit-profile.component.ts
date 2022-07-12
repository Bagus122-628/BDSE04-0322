import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/user';
import { UserAccountsService } from 'src/app/user-accounts.service';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css'],
})
export class EditProfileComponent implements OnInit {
  userProfileData: User | any;

  constructor(
    private route: ActivatedRoute,
    private userService: UserAccountsService,
    private router: Router
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

  onSubmit() {
    this.router.navigate([
      `/profile/${this.route.snapshot.paramMap.get('id')}`,
    ]);
  }
}
