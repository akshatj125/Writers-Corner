import { Component, EventEmitter, Output } from '@angular/core';
import { HeaderComponent } from '../header/header.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
    @Output() public signupEvent= new EventEmitter()

    userdata = new User("","");

    private url = "http://localhost:8080/login";

    constructor(private http: HttpClient, private router:Router) { }

    headers={
    headers:new HttpHeaders({
      'Content-Type':'application/json'
    })
  }

    login(){
      console.log(this.userdata)
    }

  }

class User{
  constructor(public username:string,public password:string) { 
  }
}