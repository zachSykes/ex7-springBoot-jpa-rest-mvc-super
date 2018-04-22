import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';

const REST_URI_messageInJsonObject: string = 'http://localhost:8888/rest/v1/teachers/messageInJsonObject?msg=ILKER_msg';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
  
export class AppComponent implements OnInit {
  title = 'app';
  message: string;
  
  constructor(private http: Http){
  }
  
  ngOnInit(): void {
    this.http.get(REST_URI_messageInJsonObject)
    .subscribe((data: any) => {
      console.log('DATA:', data);
//      debugger;
      let dataJSONParsed = JSON.parse(data._body);
      this.message = dataJSONParsed['message'];
    });
  }
}
