/**
  * @author Sergio Banegas Cortijo
  * Github: https://github.com/sergiobanegas 
*/
import { Injectable } from '@angular/core';
import { URLSearchParams } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Subject } from 'rxjs/Subject';

import { URI_PRODUCTS, URI_CATEGORIES } from '../../../../app.config';

import { CategoriesPage } from '../models/categories-page.model';
import { Product } from '../../../../shared/models/product.model';
import { HTTPService } from '../../../../shared/services/http.service';
import { TPVHTTPError } from '../../../../shared/models/tpv-http-error.model';

@Injectable()
export class SearchService {
  private static pageSize: number = 20;
  private categoriesRoute: number[] = [];
  private categoriesPageSubject: Subject<CategoriesPage> = new Subject<CategoriesPage>();

  constructor (private httpService: HTTPService) {}

  getCategoryContent(id?: number, pageNumber: number = 0): Promise<any> {
    return new Promise((resolve: Function, reject: Function) => {
      if (!id && this.categoriesRoute.length > 0){
        id = this.categoriesRoute[this.categoriesRoute.length - 1];
      }
      id && this.categoriesRoute.indexOf(id) === -1 && this.categoriesRoute.push(id);
      let idString: string = id ? id.toString() : "";
      let params: URLSearchParams = new URLSearchParams();
      params.append('page', pageNumber.toString());
      params.append('id', idString);
      return this.getCategories(params);
    });
  }

  search(name: string, pageNumber: number = 0): Promise<any> {
    this.categoriesRoute = [];
    let params: URLSearchParams = new URLSearchParams();
    params.append('page', pageNumber.toString());
    params.append('name', name);
    return this.getCategories(params);
  }

  goToPreviousCategory(): Promise<any> {
    if (this.categoriesRoute.length > 0) {
      this.categoriesRoute.pop();
      return this.categoriesRoute.length > 0
        ? this.getCategoryContent(this.categoriesRoute[0])
        : this.getCategoryContent();
    } else {
      return new Promise((resolve: Function, reject: Function)=>{
        reject('No previous category');
      });
    }
  }

  private getCategories(params: URLSearchParams): Promise<any> {
    params.append('size', SearchService.pageSize.toString());
    return new Promise((resolve: Function, reject: Function) => {
      this.httpService.get(`${URI_CATEGORIES}/search`, null, params).subscribe((categoriesPage: CategoriesPage) => {
        this.categoriesPageSubject.next(categoriesPage);
        resolve(categoriesPage);
      },(error: TPVHTTPError) => {
        reject(error.description);
      });
    });
  }

  getProductDetails(code: string): Promise<any> {
    return new Promise((resolve: Function, reject: Function) => {
      this.httpService.get(`${URI_PRODUCTS}/${code}`).subscribe((product: Product) => {
        resolve(product);
      },(error: TPVHTTPError) => {
        reject(error.description);
      });
    });
  }

  isRootCategory(): boolean {
    return this.categoriesRoute.length == 0;
  }

  getCategoriesPageObservable(): Observable<CategoriesPage> {
    return this.categoriesPageSubject.asObservable();
  }
 
}