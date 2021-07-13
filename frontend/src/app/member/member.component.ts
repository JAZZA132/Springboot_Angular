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
  mname:any;
  id:any;
  user:any;
  membercode:any;
  
  ngOnInit(): void {
    this.user= sessionStorage.getItem('user');
    console.log(this.user);
    this.mname= this.user.name;
  }

  

  update(){
    this.apiService.update(
      this.user.account,
      this.user.password,
      this.user.mname,
      this.user.id,
      this.user.membercode,).subscribe(aa =>{
      console.log(aa);
      }
    )
  }
}
