import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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
    private apiService: ApiService,
    private router:Router,

  ) { }

  ngOnInit() {

  }
  doLogin(){
    this.apiService.login(this.account,this.password).subscribe(aa =>{
      console.log(aa);

      if(aa.status){
        console.log(aa.account);
        sessionStorage.setItem('user', aa.account);
        sessionStorage.setItem('id', aa.id);
        this.router.navigate(['member']);

      }else{
        console.log("密碼錯誤");
      }
    },
    err=>{
      console.log(err);

    }
    )



  }

}
