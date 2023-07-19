import { Component } from '@angular/core';
import { HeaderComponent } from '../header/header.component';
import { LocalStorage } from 'ngx-webstorage';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
    userdata = new User("","");

    login(){
      console.log(this.userdata)
      localStorage.setItem("username",this.userdata.username,"password")
    }
}

class User{
  constructor(public username:string,public password:string) { 
  }


}

