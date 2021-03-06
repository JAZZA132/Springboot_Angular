import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HelloComponent } from './hello/hello.component';
import { HomeComponent } from './home/home.component';
import { LayoutComponent } from './layout/layout.component';
import { LoginComponent } from './login/login.component';
import { WebsocketComponent } from './websocket/websocket.component';
import { MemberComponent } from './member/member.component';


const routes: Routes = [

  {
    path:'login',
    component: LoginComponent
  },

  {
    path:'',
    component: LayoutComponent,
    children:[
      {
        path:'home',
        component: HomeComponent
      },
      {
        path:'hello',
        component: HelloComponent
      },
    ]
  },

  {
    path:'websocket',
    component: WebsocketComponent
  },

  {
    path:'member',
    component: MemberComponent
  },

  {
    path:'**',
    redirectTo:'login',
    pathMatch:'full'
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    useHash : true,
    // enableTracing: true,
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
