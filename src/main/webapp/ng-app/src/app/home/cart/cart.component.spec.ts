import { TestBed, async, inject } from '@angular/core/testing';
import 'hammerjs';
import { Response, ResponseOptions, BaseRequestOptions, Http } from '@angular/http';
import { MockBackend, MockConnection } from '@angular/http/testing';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from '@angular/material';
import { FlexLayoutModule } from '@angular/flex-layout';
import { NgxDatatableModule } from '@swimlane/ngx-datatable';
import { ToastyService, ToastyConfig, ToastOptions, ToastData } from 'ng2-toasty';

import { CartProduct } from '../shared/models/cart-product';
import { CartComponent } from './cart.component';
import { DateComponent } from '../../shared/directives/date.component';

import { ToastService } from '../../shared/services/toast.service';
import { ShoppingCartService } from '../shared/services/shopping-cart.service';
import { LocalStorageService } from '../../shared/services/local-storage.service';
import { HTTPService } from '../../shared/services/http.service';


export const MockProduct = {
  id: 0,
  code: 'article6',
  description: 'article6',
  retailPrice: 20.00,
  discontinued: false
}

export const MockTicket = {
  ticketReference: '12341234'
}

describe('Component: CartComponent', () => {

  let cart: CartComponent;
  let product_code: string = 'article6';

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [ MaterialModule, FlexLayoutModule, NgxDatatableModule, FormsModule, BrowserAnimationsModule ],
      declarations: [ DateComponent, CartComponent ],
      providers: [
        { provide: Router },
        ToastService,
        ShoppingCartService,
        LocalStorageService,
        HTTPService, 
        MockBackend,
        BaseRequestOptions,
        {
          provide: Http,
          useFactory: (backend, options) => new Http(backend, options),
          deps: [ MockBackend, BaseRequestOptions ]
        },
        ToastyService, ToastyConfig, ToastOptions, ToastData
      ]
    });
    let fixture: any = TestBed.createComponent(CartComponent);
    cart = fixture.componentInstance;
    cart.codeInput = product_code;
  }));

  it(`Should add product to cart when '${product_code}' is submitted`, inject([MockBackend], (mockBackend: MockBackend) => {
    mockBackend.connections.subscribe((conn: MockConnection) => {
      conn.mockRespond(new Response(new ResponseOptions({ body: JSON.stringify(MockProduct) })));
    });
    cart.onSubmit(new Event('testEvent'));
    let found: boolean = false;
    cart.cartProducts.forEach((cartProduct: CartProduct) => {
      if (cartProduct.productCode === product_code) found = true;
    });
    expect(found).toBe(true);
    cart.clearCart();
  }));

  it(`Should remove product with code '${product_code}' of cart`, inject([MockBackend], (mockBackend: MockBackend) => {
    mockBackend.connections.subscribe((conn: MockConnection) => {
      conn.mockRespond(new Response(new ResponseOptions({ body: JSON.stringify(MockProduct) })));
    });
    cart.onSubmit(new Event('testEvent'));
    cart.removeFromCart(new CartProduct(product_code, 'DESCRIPTION1', 12.21));
    let found: boolean = false;
    cart.cartProducts.forEach((cartProduct: CartProduct) => {
      if (cartProduct.productCode === product_code) found = true;
    });
    expect(found).toBe(false);
    cart.clearCart();
  }));

  it(`Should update the product data when 'updateProduct()' method is called`, inject([MockBackend], (mockBackend: MockBackend) => {
    mockBackend.connections.subscribe((conn: MockConnection) => {
      conn.mockRespond(new Response(new ResponseOptions({ body: JSON.stringify(MockProduct) })));
    });
    cart.onSubmit(new Event('testEvent'));
    cart.updateProduct({$$index: 0}, new Event('testEvent'), 'delivered');
    expect(cart.cartProducts[0].delivered).toBe(false);
  }));

  it(`Should clear the cart when 'clearCart()' method is called`, inject([MockBackend], (mockBackend: MockBackend) => {
    mockBackend.connections.subscribe((conn: MockConnection) => {
      conn.mockRespond(new Response(new ResponseOptions({ body: JSON.stringify(MockProduct) })));
    });
    cart.onSubmit(new Event('testEvent'));
    cart.clearCart();
    expect(cart.cartProducts.length).toBe(0);
  }));

});
