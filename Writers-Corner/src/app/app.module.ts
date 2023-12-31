import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { routingComponents } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'

import { HeaderComponent }  from './header/header.component'
import { BlogsComponent } from './blogs/blogs.component';

import { AppRoutingModule} from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { SignupComponent } from './signup/signup.component';
import { BlogpageComponent } from './blogpage/blogpage.component';
import { FooterComponent } from './footer/footer.component';
import { BlogUploadComponent } from './blog-upload/blog-upload.component';
import { AddBlogComponent } from './add-blog/add-blog.component';
import { MyprofileComponent } from './myprofile/myprofile.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { PrivacyComponent } from './privacy/privacy.component';
import { TermsComponent } from './terms/terms.component';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    BlogsComponent,
    LoginComponent,
    SignupComponent,
    routingComponents,
    BlogpageComponent,
    FooterComponent,
    BlogUploadComponent,
    AddBlogComponent,
    MyprofileComponent,
    AboutUsComponent,
    PrivacyComponent,
    TermsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
  
}
