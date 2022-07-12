import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { USERS } from './mock-user';
import { User } from './user';

@Injectable({
  providedIn: 'root',
})
export class UserAccountsService {
  loggedIn = false;
  userLoginID: number = 0;

  constructor() {}

  getUsers(): Observable<User[]> {
    const cars = of(USERS);
    return cars;
  }

  getUserID(id: number): Observable<User> {
    const ID = USERS.find((ID) => ID.id === id)!;
    return of(ID);
  }
}
