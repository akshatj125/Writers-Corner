import { Component , Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit{
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

}
