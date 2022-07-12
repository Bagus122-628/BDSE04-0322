import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { ProfileUserComponent } from './pages/profile-user/profile-user.component';
import { SearchUsersComponent } from './pages/search-users/search-users.component';
import { LoginComponent } from './users/login/login.component';
import { RegistrationConfirmationEmailComponent } from './users/registration/registration-confirmation-email/registration-confirmation-email.component';
import { RegistrationConfirmationComponent } from './users/registration/registration-confirmation/registration-confirmation.component';
import { RegistrationComponent } from './users/registration/registration.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'registration', component: RegistrationComponent },
  {
    path: 'registration-confirmation',
    component: RegistrationConfirmationComponent,
  },
  {
    path: 'email-confirmation',
    component: RegistrationConfirmationEmailComponent,
  },
  { path: 'search', component: SearchUsersComponent },
  { path: 'profile/:id', component: ProfileUserComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
