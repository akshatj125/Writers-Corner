import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route } from '@angular/router';

@Component({
  selector: 'app-myprofile',
  templateUrl: './myprofile.component.html',
  styleUrls: ['./myprofile.component.css']
})
export class MyprofileComponent implements OnInit {
  user:User
  blogs:any
  showBlogs=false
  constructor(private http:HttpClient, private route:ActivatedRoute){}

  headers={
    headers:new HttpHeaders({
      'Content-type':'application/json'
    })
  }

  async ngOnInit(): Promise<void> {
    var username= this.route.snapshot.paramMap.get("username") as string
    await this.http.get<User>("http://localhost:8080/u/"+username,this.headers).subscribe(data=>{
      this.user=data
      console.log(this.user)
    })

    this.http.get("http://localhost:8080/userBlogs/"+username,this.headers).subscribe(data=>{
      this.blogs=data
      this.showBlogs=true
      console.log(this.blogs)
    })

  } 

}

class User{
  constructor(public username:string,public name:string,public emailId:string){}
}
class Blogs{
  constructor(public blogId:number,public title:string,public content:string,public username:string,public datetime:string,public views:number){}
}