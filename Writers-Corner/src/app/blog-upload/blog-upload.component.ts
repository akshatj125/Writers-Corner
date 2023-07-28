import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-blog-upload',
  templateUrl: './blog-upload.component.html',
  styleUrls: ['./blog-upload.component.css']
})
export class BlogUploadComponent {
  
  title: string 
  content: string

  private url = "http://localhost:8080/createBlog";

  constructor(private http: HttpClient, private router:Router){ }
 
  
  

  onSubmit() {
    var token=String(localStorage.getItem('token'))
    var headers={
      headers:new HttpHeaders({
        'Content-Type':'application/json',
        'Authorization':token
      })
    }
    var data={
      "userName":localStorage.getItem("username"),
      "title":this.title,
      "content":this.content
    }

    this.http.post(this.url, data, headers).subscribe(data=>{})
    // Now you can process the data, for example, send it to a server or store it locally

    this.router.navigate(["/home"])
}
}
