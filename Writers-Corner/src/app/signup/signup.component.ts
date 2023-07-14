import { JsonPipe } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  userdata =new User("","","","")

  signup(){
    console.log(this.userdata)
  }
}

class User{
  constructor(public name:string,public username:string,public email:string,public password:string) {
    
  }
}

