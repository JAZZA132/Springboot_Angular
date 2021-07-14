import { stringify } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { ApiService } from '../service/api.service';

@Component({
  selector: 'app-member',
  templateUrl: './member.component.html',
  styleUrls: ['./member.component.css']
})
export class MemberComponent implements OnInit {

  constructor(
    private apiService: ApiService,
    private router:Router,
  ) { }

  account:any;
  password:any;
  name:any;
  id:any;
  user:any;
  memberCode:any;
  
  ngOnInit(): void {
    this.user= sessionStorage.getItem('user');
    //要解析出來
    this.user= JSON.parse(this.user);
    console.log(this.user);
    this.name= this.user.name;
    console.log(this.name)
  }

  
  register(){
    this.apiService.register(
      this.account,
      this.password,
      this.name,
      ).subscribe(aa =>{
      console.log(aa);
      }
    )
  }




  update(){
    this.apiService.update(
      this.account,
      this.password,
      this.name,
      this.user.id,
      this.user.memberCode,).subscribe(aa =>{
      console.log(aa);
      }
    )
  }
}
