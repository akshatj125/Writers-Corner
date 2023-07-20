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
    const u=localStorage.getItem("username");
    
    if(u!=null)
    {
      this.username=u
      console.log(this.username)
    }
    if (this.username!=="")
    {
      this.EnableLogin=false
      this.LoggedIn = true;
    }


  }
  LogOut(){
    localStorage.clear()
    this.router.navigate(['/home'])
  }
  Login()
  {
    localStorage.setItem("redirectUrl",this.router.url)
    this.router.navigate(["/login"])
  }
  toggleDrop(){
    document.getElementById("dropdown")?.classList.toggle("show")
  }

}
