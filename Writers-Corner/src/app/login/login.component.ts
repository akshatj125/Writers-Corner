import { Component, EventEmitter, Output } from '@angular/core';
import { HeaderComponent } from '../header/header.component';
import { HttpClient, HttpHeaders } from '@angular/common/http';
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
      'Content-Type':'application/json',
    })
  }

  login(){
 
      const data = JSON.stringify(this.userdata)
     
      this.http.post<User>(this.url, data, this.headers).subscribe(data=>{
        
        console.log(data);
        localStorage.setItem("username",data.username)
        localStorage.setItem("token","Bearer "+data.password)
        
        var url=localStorage.getItem("redirectUrl")
        if(url==null)
        {
          url="/home"
        }
        localStorage.removeItem("redirectUrl")
        this.router.navigate([url])
      
      },
      error=>{
        alert("Invalid credentials")
      }
      
      )
      
    }

  }

class User{
  constructor(public username:string,public password:string) { 
  }
}