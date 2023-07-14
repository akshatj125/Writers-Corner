import { JsonPipe } from '@angular/common';
import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  userdata =new User("","","","")

  data:any;

  private url = "http://localhost:8080/user";

  constructor(private http: HttpClient){ }
 

  headers={
    headers:new HttpHeaders({
      'Content-Type':'application/json'
    })
  }

  signup(){
    // console.log(this.userdata)
    const data = JSON.stringify(this.userdata)
    this.http.post(this.url, data, this.headers).subscribe(data=>{
      console.log(data)
    })
  }

}

class User{
  constructor(public name:string,public username:string,public email:string,public password:string) {
    
  }
}



