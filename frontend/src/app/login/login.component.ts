import { Component, OnInit } from '@angular/core';
import { ApiService } from '../service/api.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  account:any;
  password:any;
  constructor(
    private apiService: ApiService

  ) { }

  ngOnInit() {
    
  }
  doLogin(){
    this.apiService.login(this.account,this.password).subscribe(aa =>console.log(aa));

   

  }

}
