/**
  * @author Sergio Banegas Cortijo
  * Github: https://github.com/sergiobanegas 
*/
import { Injectable } from '@angular/core';
import { Headers } from '@angular/http';
import { Observable } from 'rxjs';
import { Subject } from 'rxjs/Subject';
import * as moment from 'moment/moment';

import { API_GENERIC_URI, URI_VOUCHERS, URI_INVOICES } from '../../../../../app.config';

import { VoucherCreation } from '../../../../shared/models/voucher-creation.model';
import { Voucher } from '../../../../shared/models/voucher.model';

import { Amount } from '../../../../shared/models/amount.model';
import { HTTPService } from '../../../../../shared/services/http.service';
import { TPVHTTPError } from '../../../../../shared/models/tpv-http-error.model';
import { LocalStorageService } from '../../../../../shared/services/local-storage.service';

@Injectable()
export class PrintService {

  constructor (private httpService: HTTPService) {}

  createVoucher(amount: number, validity: number): Promise<any> {
    return new Promise((resolve: Function, reject: Function) => {
      let expirationDate: Date = moment(new Date()).add(validity, 'M').toDate();
      let voucherWrapper: VoucherCreation = new VoucherCreation(amount, expirationDate);
      let headers = new Headers();
      headers.append('Accept', 'application/pdf');
      this.httpService.post(`${API_GENERIC_URI}${URI_VOUCHERS}`, voucherWrapper, headers).subscribe((response: any) => {
        resolve(response);
      },(error: TPVHTTPError) => {
        reject(error.description);
      });
    });
  }

  createInvoice(ticketId: number): Promise<any> {
    return new Promise((resolve: Function, reject: Function) => {
        resolve(ticketId);
      // let headers = new Headers();
      // headers.append('Accept', 'application/pdf');
      // this.httpService.post(`${API_GENERIC_URI}${URI_INVOICES}`, amountWrapper, headers).subscribe((voucher: Voucher) => {
      //   resolve(voucher);
      // },(error: TPVHTTPError) => {
      //   reject(error.description);
      // });
    });
  }

}