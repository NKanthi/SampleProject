import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { Http } from '@angular/http';
import { HttpModule } from '@angular/http';
import { AppComponent } from './app.component';
import { ProductComponent } from './product/product.component';
import { ProductService } from './product/product.service';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


@NgModule({
  declarations: [
    AppComponent,
    ProductComponent
  ],
  imports: [
    BrowserModule,
	HttpClientModule,
	HttpModule,
	FormsModule,
	BrowserAnimationsModule
  ],
  bootstrap: [AppComponent],
  providers: [ProductService]
})
export class AppModule { }