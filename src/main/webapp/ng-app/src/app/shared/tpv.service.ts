import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import { API_GENERIC_URI } from '../app.config';

@Injectable()
export class TPVService {

	private options:RequestOptions = 
	new RequestOptions({ headers: new Headers({ 'Content-Type': 'application/json' }) }); 

	constructor (private http:Http){}

	requestGet(url:string): Observable<any> {
		return this.http.get(API_GENERIC_URI+url).map(this.extractData).catch(this.handleError);
	}

	requestPost(url:string, data:Object): Observable<any> {
		return this.http.post(API_GENERIC_URI+url, data, this.options).map(this.extractData).catch(this.handleError);
	}

	requestPut(url:string, data:Object): Observable<any> {
		return this.http.put(API_GENERIC_URI+url, data, this.options).map(this.extractData).catch(this.handleError);
	}

	requestDelete(url:string): Observable<any> {
		return this.http.delete(API_GENERIC_URI+url).map(this.extractData).catch(this.handleError);
	}

	private extractData(res: Response) {
		return res.json();
	}
	private handleError (error: Response | any) {
		return Observable.throw(error.message || error);
	}
}