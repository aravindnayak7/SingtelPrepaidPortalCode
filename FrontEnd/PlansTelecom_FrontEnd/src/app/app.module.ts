import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdmingetallitmsComponent } from './admingetallitms/admingetallitms.component';

import { AdminaddComponent } from './adminadd/adminadd.component';
import {HttpClientModule} from '@angular/common/http';

import { SimPlansComponent } from './sim-plans/sim-plans.component';
import { HeaderComponent } from './header/header.component';
@NgModule({
  declarations: [
    AppComponent,
    AdmingetallitmsComponent,
    AdminaddComponent,
    SimPlansComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
