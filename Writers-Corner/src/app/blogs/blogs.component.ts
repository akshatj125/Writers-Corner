import { Component } from '@angular/core';

@Component({
  selector: 'app-blogs',
  templateUrl: './blogs.component.html',
  styleUrls: ['./blogs.component.css']
})
export class BlogsComponent {

  public blogs=[
    {"title":"Title1" , "desc":"Description.."},
    {"title":"Title2" , "desc":"Description.."},
    {"title":"Title3" , "desc":"Description.."},
    {"title":"Title4" , "desc":"Description.."},

  ]

}
