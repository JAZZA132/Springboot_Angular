import { Component, OnInit } from '@angular/core';
import { ApiService } from '../service/api.service'; // 引入ApiService
import { HelloData } from '../data/hello-data'; // 引入HelloData

@Component({
  selector: 'app-hello',
  templateUrl: './hello.component.html',
  styleUrls: ['./hello.component.css']
})
export class HelloComponent implements OnInit {

  id: string ='';
  name: string ='';
  account:string = '';
  account2:string = '';
  post:string = '';
  pasword:string='';

  // 注入ApiService
  constructor(
    private apiService: ApiService
  ) { }

  ngOnInit() {
  }


}
