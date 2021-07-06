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

  /** 委託ApiService.getHello()取得內容 */
  getHello() {
    this.apiService.getHello(this.account).subscribe(
      value => this.success(value)
    );
  }


  getpost(){
    this.apiService.login(
      "admin",
      "admin"
      ).subscribe(
      a =>console.log(a)
    );
  }



  /** API呼叫成功的處理 */
  success(value: HelloData) {
    this.id = value.id;
    this.name = value.name;
    this.account = value.account
    this.account2 = value.account
  }

  /** 清除頁面{{hello}}內容 */
  clear() {
    this.id = '';
    this.name = '';
  }

}
