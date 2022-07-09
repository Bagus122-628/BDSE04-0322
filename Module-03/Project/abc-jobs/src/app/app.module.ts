import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginFormComponent } from './users/login-form/login-form.component';
import { FooterComponent } from './components/footer/footer.component';
import { LoginComponent } from './users/login/login.component';
import { RegistrationComponent } from './users/registration/registration.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    LoginFormComponent,
    FooterComponent,
    LoginComponent,
    RegistrationComponent,
  ],
  imports: [BrowserModule, AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
