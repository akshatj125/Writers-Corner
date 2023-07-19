import { Component, EventEmitter, Output } from '@angular/core';
import { HeaderComponent } from '../header/header.component';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

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
      const data = JSON.stringify(this.userdata)
     
      this.http.post(this.url, data, this.headers).subscribe(data=>{
        
        console.log(data);
        if (data)
        {
          this.signupEvent.emit(this.userdata.username)
            this.router.navigate(['/home'])
        }
        else{
          alert("Invalid credentials")
        }
  
      })
      
    }

  }

class User{
  constructor(public username:string,public password:string) { 
  }
}