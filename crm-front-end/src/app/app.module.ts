import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from './common-components/header/header.component';
import {FooterComponent} from './common-components/footer/footer.component';
import {ServerErrorComponent} from './common-components/server-error/server-error.component';
import {NotFoundComponent} from './common-components/not-found/not-found.component';
import {HomePageComponent} from './home-page/home-page.component';
import {LoginComponent} from './login/login.component';
import {ToastrModule} from 'ngx-toastr';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {CustomerRoutingModule} from './customer/customer-routing.module';
import {HttpClientModule} from '@angular/common/http';
import {CustomerModule} from './customer/customer.module';

@NgModule({
  declarations: [
    AppComponent,
    AppComponent,
    HeaderComponent,
    FooterComponent,
    ServerErrorComponent,
    NotFoundComponent,
    LoginComponent,
    HomePageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CustomerModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ToastrModule.forRoot({
      timeOut: 5000,
      closeButton: true,
      positionClass: 'toast-bottom-right',
    }),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
