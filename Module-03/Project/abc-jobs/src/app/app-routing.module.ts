import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ForgotPasswordConfirmationComponent } from './pages/forgot-password/forgot-password-confirmation/forgot-password-confirmation.component';
import { ForgotPasswordComponent } from './pages/forgot-password/forgot-password.component';
import { HomeComponent } from './pages/home/home.component';
import { EditProfileComponent } from './pages/profile-user/edit-profile/edit-profile.component';
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
  { path: 'profile/:id/edit-profile', component: EditProfileComponent },
  { path: 'forgot-password', component: ForgotPasswordComponent },
  {
    path: 'forgot-password-confirmation',
    component: ForgotPasswordConfirmationComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
