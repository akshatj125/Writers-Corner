import { Component } from '@angular/core';
import { HomeComponent } from './home/home.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Writers-Corner';
  username= ""

  onOutletLoaded(component: HomeComponent|SignupComponent|LoginComponent) {
    if (component instanceof HomeComponent) {
      component.username = this.username;
    }


    if (component instanceof SignupComponent || component instanceof LoginComponent)
    {
      component.signupEvent.subscribe( data=>{
        this.username=data
        console.log(data)

      })

      }
    }
    
  }

