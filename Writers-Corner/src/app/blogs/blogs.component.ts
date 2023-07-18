import { Component } from '@angular/core';

@Component({
  selector: 'app-blogs',
  templateUrl: './blogs.component.html',
  styleUrls: ['./blogs.component.css']
})
export class BlogsComponent {


  public blogs1=[
    {"id":1,"title":"Title1" , "desc":"Description.."},
    {"id":2,"title":"Title2" , "desc":"Description.."},
    {"id":3,"title":"Title3" , "desc":"Description.."},
    {"id":4,"title":"Title4" , "desc":"Description.."},
    {"id":1,"title":"Title1" , "desc":"Description.."},
    {"id":2,"title":"Title2" , "desc":"Description.."},
    {"id":3,"title":"Title3" , "desc":"Description.."},
    {"id":4,"title":"Title4" , "desc":"Description.."},
    {"id":1,"title":"Title1" , "desc":"Description.."},
    {"id":2,"title":"Title2" , "desc":"Description.."},
    {"id":3,"title":"Title3" , "desc":"Description.."},
    {"id":4,"title":"Title4" , "desc":"Description.."},
    {"id":1,"title":"Title1" , "desc":"Description.."},
    {"id":2,"title":"Title2" , "desc":"Description.."},
    {"id":3,"title":"Title3" , "desc":"Description.."},
    {"id":4,"title":"Title4" , "desc":"Description.."},

  ]
  x=6
  blogs=this.blogs1.slice(0,this.x)
  isMoreAvailable=true

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
