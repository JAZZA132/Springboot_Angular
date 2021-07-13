import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'; // 引入HttpClient
import { HelloData } from '../data/hello-data'; // 引入HelloData
import { Observable } from 'rxjs';


const url = 'http://localhost:8080';
const login= '/login';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  // 注入HttpClient
  constructor(
    private http: HttpClient
  ) { }

  /** 從後端取得資料 */
  getHello(
    account:string
  ) {
    // get回傳Observable<HelloData>物件
    return this.http.get<HelloData>(url + login + account); // 呼叫Spring Boot的DemoController.getHello()
  }


  login(
    account:string,
    password:string
  ): Observable<any>{
    const reqobj = {
      account:account,
     password:password
    };
    {
      return this.http.post(url + login , reqobj); // 呼叫Spring Boot的DemoController.getHello()
    }
  }


  register(
    account:string,
    password:string,
    mname:string,
  ): Observable<any>{
    const reqobj = {
      account:account,
     password:password,
     name:mname
    };
    {
      return this.http.post(url + "/register" , reqobj); // 呼叫Spring Boot的DemoController.getHello()
    }
  }

  update(
    account:string,
    password:string,
    mname:string,
    id:string,
    membercode:string,
  ): Observable<any>{
    const reqobj = {
      account:account,
     password:password,
     name:mname,
     id:id,
     membercode:membercode,
    };
    {
      return this.http.put(url + "/login/${id}" , reqobj); // 呼叫Spring Boot的DemoController.getHello()
    }
  }

}
