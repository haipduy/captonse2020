import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { BodyComponent } from './body/body.component';
import { CoverComponent } from './body/cover/cover.component';
import { AboutUsComponent } from './body/about-us/about-us.component';
import { OurFeaturesComponent } from './body/our-features/our-features.component';
import { OurTeamComponent } from './body/our-team/our-team.component';
import { OurServiceComponent } from './body/our-service/our-service.component';
import { ContactComponent } from './body/contact/contact.component';
import { SignInComponent } from './body/sign-in/sign-in.component';
import { SignUpComponent } from './body/sign-up/sign-up.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatDialogModule} from '@angular/material/dialog';
import {MatButtonModule} from '@angular/material/button';
import { MainComponent } from './main/main.component';
import { HomeComponent } from './home/home.component';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    BodyComponent,
    CoverComponent,
    AboutUsComponent,
    OurFeaturesComponent,
    OurTeamComponent,
    OurServiceComponent,
    ContactComponent,
    SignInComponent,
    SignUpComponent,
    MainComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatDialogModule,
    MatButtonModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [
  ],
  entryComponents: [
    SignInComponent,
    SignUpComponent
  ]
})
export class AppModule {

}
