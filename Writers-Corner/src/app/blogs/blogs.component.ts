import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-blogs',
  templateUrl: './blogs.component.html',
  styleUrls: ['./blogs.component.css']
})
export class BlogsComponent implements OnInit{


  public blogs1:any
  private url = "http://localhost:8080/blogs";

  
 
  
  headers={
    headers:new HttpHeaders({
      'Content-Type':'application/json'
    })
  }
  

  x=3
  blogs:any
  isMoreAvailable=true

  constructor(private http: HttpClient, private router:Router){ }


  ngOnInit(): void {
     this.http.get(this.url,this.headers).subscribe(data=>{
      this.blogs1=data
      console.log(data)
      this.IncX()
     })


  }

  IncX(){
    this.x+=3;
    console.log(this.blogs1.length)
    if(this.blogs1.length<=this.x)
    {
      this.isMoreAvailable=false
    }

    this.blogs=this.blogs1.slice(0,this.x)

  }

}
