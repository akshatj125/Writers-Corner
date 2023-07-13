import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-blogpage',
  templateUrl: './blogpage.component.html',
  styleUrls: ['./blogpage.component.css']
})
export class BlogpageComponent implements OnInit {
  constructor(private route:ActivatedRoute){}
  id=0
  ngOnInit(): void {
    this.id= parseInt(this.route.snapshot.paramMap.get("id") as string)
  }
  
}
