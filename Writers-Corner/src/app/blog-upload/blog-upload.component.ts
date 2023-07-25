import { Component } from '@angular/core';

@Component({
  selector: 'app-blog-upload',
  templateUrl: './blog-upload.component.html',
  styleUrls: ['./blog-upload.component.css']
})
export class BlogUploadComponent {
  title: string 
  content: string

  onSubmit() {
    // Now you can process the data, for example, send it to a server or store it locally
    console.log('Title:', this.title);
    console.log('Content:', this.content);
}
}
