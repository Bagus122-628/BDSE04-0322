import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginFormComponent } from './users/login-form/login-form.component';
import { FooterComponent } from './components/footer/footer.component';
import { LoginComponent } from './users/login/login.component';
import { RegistrationComponent } from './users/registration/registration.component';
import { RegistrationConfirmationComponent } from './users/registration/registration-confirmation/registration-confirmation.component';
import { RegistrationConfirmationEmailComponent } from './users/registration/registration-confirmation-email/registration-confirmation-email.component';
import { SearchUsersComponent } from './pages/search-users/search-users.component';
import { ProfileUserComponent } from './pages/profile-user/profile-user.component';
import { UserAccountsService } from './user-accounts.service';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    LoginFormComponent,
    FooterComponent,
    LoginComponent,
    RegistrationComponent,
    RegistrationConfirmationComponent,
    RegistrationConfirmationEmailComponent,
    SearchUsersComponent,
    ProfileUserComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [UserAccountsService],
  bootstrap: [AppComponent],
})
export class AppModule {}
