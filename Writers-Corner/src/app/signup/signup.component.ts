import { JsonPipe } from '@angular/common';
import { Component, ElementRef, ViewChild } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { NgModel } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  userdata =new User("","","","")

  usernameExists= false

  @ViewChild('username') usernameField:NgModel |undefined ;

  data:any;

  private url = "http://localhost:8080/user";

  constructor(private http: HttpClient, private router:Router){ }
 

  headers={
    headers:new HttpHeaders({
      'Content-Type':'application/json'
    })
  }
  signedUp :any= false;
  signup(){
    // console.log(this.userdata)
    const data = JSON.stringify(this.userdata)
     
    this.http.post(this.url, data, this.headers).subscribe(data=>{
      console.log(data)
      this.signedUp=data
    })
    if (this.signedUp)
    {
        this.router.navigate(['/home'])
    }
    else{
      this.usernameExists=true
      this.usernameField?.control.markAsPristine()
    }
  }

}

class User{
  constructor( public name:string,public username:string,public emailId:string,public password:string) {
    
  }
}



