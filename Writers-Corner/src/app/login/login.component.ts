import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
    userdata = new User("","");

    login(){
      console.log(this.userdata)
    }
}

class User{
  constructor(public username:string,public password:string) {
    
  }


}

