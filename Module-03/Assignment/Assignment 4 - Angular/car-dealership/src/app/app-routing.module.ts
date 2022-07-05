import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CarsListComponent } from './cars-list/cars-list.component';
import { WelcomeComponent } from './welcome/welcome.component';

const routes: Routes = [
  { path: '', component: WelcomeComponent },
  { path: 'list-of-cars', component: CarsListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
