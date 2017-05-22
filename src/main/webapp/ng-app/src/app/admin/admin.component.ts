/**
 * Created by fran lopez on 11/05/2017.
 */

import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {ToastService} from '../shared/services/toast.service';
import {LocalStorageService} from '../shared/services/local-storage.service';
import {LOCAL_STORAGE_TOKEN_ATTRIBUTE} from '../app.config';

@Component({
    templateUrl: './admin.component.html',
    styleUrls: ['./admin.component.css']
})
export class AdminComponent {
    constructor(private router: Router, private toastService: ToastService,
                private localStorageService: LocalStorageService) {
    }

    logout() {
        this.router.navigate(['/welcome']);
        this.localStorageService.removeItem(LOCAL_STORAGE_TOKEN_ATTRIBUTE);
        this.toastService.info('Goodbye', 'You have logged out');
    }
}