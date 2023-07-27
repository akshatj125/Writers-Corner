import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { BlogpageComponent } from './blogpage/blogpage.component';
import { BlogUploadComponent } from './blog-upload/blog-upload.component';
import { BlogsComponent } from './blogs/blogs.component';
import { MyprofileComponent } from './myprofile/myprofile.component';

const routes: Routes = [

  {path:"", redirectTo:"/home",pathMatch:"full"},
  {path:"home", component:HomeComponent,},
  {path:"login", component:LoginComponent},
  {path:"signup", component:SignupComponent},
  {path:"blog/:id",component:BlogpageComponent},
  {path:"blog-upload",component:BlogUploadComponent},
  {path:"myprofile", component:MyprofileComponent}

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
  BlogpageComponent,
  BlogUploadComponent,
  MyprofileComponent
]