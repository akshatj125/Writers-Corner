import { Component } from '@angular/core';

@Component({
  selector: 'app-blogs',
  templateUrl: './blogs.component.html',
  styleUrls: ['./blogs.component.css']
})
export class BlogsComponent {

  public blogs=[
    {"id":1,"title":"Title1" , "desc":"Description.."},
    {"id":2,"title":"Title2" , "desc":"Description.."},
    {"id":3,"title":"Title3" , "desc":"Description.."},
    {"id":4,"title":"Title4" , "desc":"Description.."},

  ]

}
