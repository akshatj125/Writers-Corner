import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { BlogpageComponent } from './blogpage/blogpage.component';

const routes: Routes = [

  {path:"", redirectTo:"/home",pathMatch:"full"},
  {path:"home", component:HomeComponent,},
  {path:"login", component:LoginComponent},
  {path:"signup", component:SignupComponent},
  {path:"blogs/:id",component:BlogpageComponent}

]

@NgModule({
  imports: [
    RouterModule.forRoot(routes, {enableTracing: true , onSameUrlNavigation: 'reload'})
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents=[
  HomeComponent,
  LoginComponent,
  SignupComponent,
  BlogpageComponent
]