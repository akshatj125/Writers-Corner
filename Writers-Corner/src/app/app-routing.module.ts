import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { BlogpageComponent } from './blogpage/blogpage.component';
import { BlogUploadComponent } from './blog-upload/blog-upload.component';
import { BlogsComponent } from './blogs/blogs.component';
import { MyprofileComponent } from './myprofile/myprofile.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { PrivacyComponent } from './privacy/privacy.component';
import { TermsComponent } from './terms/terms.component';

const routes: Routes = [

  {path:"", redirectTo:"/home",pathMatch:"full"},
  {path:"home", component:HomeComponent,},
  {path:"login", component:LoginComponent},
  {path:"signup", component:SignupComponent},
  {path:"blog/:id",component:BlogpageComponent},
  {path:"blog-upload",component:BlogUploadComponent},
  {path:"u/:username", component:MyprofileComponent},
  {path:"aboutUs", component:AboutUsComponent},
  {path:"privacy", component:PrivacyComponent},
  {path:"terms", component:TermsComponent}

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
  MyprofileComponent,
  AboutUsComponent,
  PrivacyComponent,
  TermsComponent
]