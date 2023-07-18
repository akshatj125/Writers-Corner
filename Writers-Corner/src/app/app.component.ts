import { Component } from '@angular/core';
import { HomeComponent } from './home/home.component';
import { SignupComponent } from './signup/signup.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Writers-Corner';
  username= ""

  onOutletLoaded(component: HomeComponent|SignupComponent) {
    if (component instanceof HomeComponent) {
      component.username = this.username;
    }


    if (component instanceof SignupComponent)
    {
      component.signupEvent.subscribe( data=>{
        this.username=data
        console.log(data)

      })

      }
    }
    
  }

