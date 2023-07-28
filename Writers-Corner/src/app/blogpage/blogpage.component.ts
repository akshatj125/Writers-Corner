import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-blogpage',
  templateUrl: './blogpage.component.html',
  styleUrls: ['./blogpage.component.css']
})
export class BlogpageComponent{
  
  public blog:any
  private url = "http://localhost:8080/blogs/";

  constructor(private http: HttpClient, private router:Router, private route: ActivatedRoute) { }

  headers={
  headers:new HttpHeaders({
    'Content-Type':'application/json'
  })
  }

  id=0
  ngOnInit(): void {
    this.id= parseInt(this.route.snapshot.paramMap.get("id") as string)
    this.http.get<Blogs>(this.url + this.id.toString(), this.headers).subscribe(data=>{
      this.blog=data
      console.log(this.blog)
    })
  }
}



class Blogs{
  constructor(public blogId:number,public title:string,public content:string,public username:string,public datetime:string,public views:number){}
}