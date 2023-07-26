import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-blog-upload',
  templateUrl: './blog-upload.component.html',
  styleUrls: ['./blog-upload.component.css']
})
export class BlogUploadComponent {
  userId:0
  title: string 
  content: string

  private url = "http://localhost:8080/createblog";

  constructor(private http: HttpClient, private router:Router){ }
 
  
  headers={
    headers:new HttpHeaders({
      'Content-Type':'application/json'
    })
  }

  onSubmit() {
    var data={
      userId:this.userId,
      "title":this.title,
      "content":this.content
    }

    this.http.post(this.url, data, this.headers).subscribe(data=>{})
    // Now you can process the data, for example, send it to a server or store it locally
    console.log('userId:', this.userId);
    console.log('Title:', this.title);
    console.log('Content:', this.content);

    this.router.navigate(["/home"])
}
}
