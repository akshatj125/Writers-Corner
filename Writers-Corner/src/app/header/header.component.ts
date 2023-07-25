import { Component , ElementRef, Input, OnInit} from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
  host: {
    '(document:click)': 'clickOut($event)',
  },
})
export class HeaderComponent implements OnInit{

  constructor(private router:Router, private eref:ElementRef){}
  @Input() 
  public EnableLogin =false;

  @Input()
  public showAddBlog = false;

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

    if(!this.LoggedIn){
      this.showAddBlog = false;
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

  clickOut(event: any)
  {
    if (!event.target.matches('.dropdown') && !event.target.matches('.dropbtn')) {
      var dropdowns = document.getElementsByClassName("dropdown-content");
      var i;
      for (i = 0; i < dropdowns.length; i++) {
        var openDropdown = dropdowns[i];
        if (openDropdown.classList.contains('show')) {
          openDropdown.classList.remove('show');
        }
      }
    }
  }
  
}
