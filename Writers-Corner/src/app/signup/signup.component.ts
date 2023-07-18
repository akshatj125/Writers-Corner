import { JsonPipe } from '@angular/common';
import { Component, ElementRef, EventEmitter, Output, ViewChild } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { NgModel } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  @Output() public signupEvent= new EventEmitter()



  userdata =new User("","","","")
  usernameExists= false

  @ViewChild('username') usernameField:NgModel |undefined ;

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
      
      this.signedUp=data
      

      if (this.signedUp)
      {
          this.signupEvent.emit(this.userdata.username)
          this.router.navigate(['/home'])
      }
      else{
        this.usernameExists=true
        this.usernameField?.control.markAsPristine()
      }

    })
  }

}

class User{
  constructor( public name:string,public username:string,public emailId:string,public password:string) {
    
  }
}





