import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{
  public username=""
  public enableLogin=true

  ngOnInit(): void {
      const u=localStorage.getItem("username");
      
      if(u!=null)
      {
        this.username=u
        console.log(this.username)
      }
      if (this.username!=="")
      {
        this.enableLogin=false
      }
  }

}
