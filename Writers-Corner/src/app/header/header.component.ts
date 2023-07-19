import { Component , Input, OnInit} from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit{
  constructor(private router:Router){}
  @Input() 
  public EnableLogin =false;

  @Input() 
  public username ="";
  public LoggedIn = false;

  ngOnInit(): void {
      if(this.username!==""){
        this.LoggedIn = true;
      }
  }
  LogOut(){
    localStorage.clear()
    this.router.navigate(['/home'])
  }

}
