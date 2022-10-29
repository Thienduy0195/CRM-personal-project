import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HeaderComponent} from './common-components/header/header.component';
import {LoginComponent} from './login/login.component';
import {HomePageComponent} from './home-page/home-page.component';
import {NotFoundComponent} from './common-components/not-found/not-found.component';


const routes: Routes = [{
  path: 'header', component: HeaderComponent
},
  {
    path: 'login', component: LoginComponent
  },
  {
    path: 'home', component: HomePageComponent
  },
  {
    path: 'not-found', component: NotFoundComponent
  },
  {
    path: '', component: HomePageComponent
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
