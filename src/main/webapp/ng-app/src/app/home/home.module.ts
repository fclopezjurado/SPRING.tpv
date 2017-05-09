import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpModule, JsonpModule } from '@angular/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import 'hammerjs';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MaterialModule } from '@angular/material';
import { NgxDatatableModule } from '@swimlane/ngx-datatable';
import { ToastyModule } from 'ng2-toasty';


import { HomeRoutingModule } from './home-routing.module';

import { HomeComponent, OrderTrackingDialog } from './home.component';
import { CartComponent } from './cart/cart.component';
import { CalculatorComponent } from './cart/calculator/calculator.component';
import { DateComponent } from '../shared/date.component';

import { TPVService } from '../shared/tpv.service';
import { LocalStorageService } from '../shared/local-storage.service';
import { ToastService } from '../shared/toast.service';

import { CartModule } from './cart/cart.module';
import { SearchModule } from './search/search.module';
import { PaymentModule } from './payment/payment.module';

@NgModule({
  imports: [
    CommonModule,
    HomeRoutingModule,
    FormsModule,
    HttpModule,
    JsonpModule,
    BrowserAnimationsModule,
    FlexLayoutModule,
    MaterialModule,
    ToastyModule,
    CartModule,
    SearchModule,
    PaymentModule,
    NgxDatatableModule
  ],
  declarations: [
    HomeComponent,
    DateComponent,
    CartComponent,
    OrderTrackingDialog
  ],
  providers: [TPVService, LocalStorageService, ToastService],
  entryComponents: [OrderTrackingDialog]
})
export class HomeModule { }
