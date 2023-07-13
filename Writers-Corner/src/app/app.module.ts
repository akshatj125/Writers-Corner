import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { HeaderComponent }  from './header/header.component'
import { BlogsComponent } from './blogs/blogs.component';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    BlogsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
