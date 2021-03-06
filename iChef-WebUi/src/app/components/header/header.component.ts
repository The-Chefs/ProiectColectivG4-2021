import { Component } from '@angular/core';
import { HEADER_LINKS } from 'src/app/constants/header';
import { BUTTON_STRINGS, LANDING_PAGE_STRINGS } from 'src/app/constants/texts';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { LoginComponent } from '../login/login.component';
import { RegisterComponent } from '../register/register.component';
import { UsersService } from '../../services/users.service';
import { SharedService } from '../../services/shared.service';
import { Router } from '@angular/router';

@Component({
    selector: 'app-header',
    templateUrl: './header.component.html',
    styleUrls: ['./header.component.scss']
})

export class HeaderComponent {
    readonly homeLink = HEADER_LINKS.HOME;
    readonly recipesLink = HEADER_LINKS.RECIPES;
    readonly myAccountLink = HEADER_LINKS.MY_ACCOUNT;
    readonly loginBtn = BUTTON_STRINGS.LOGIN;
    readonly registerBtn = BUTTON_STRINGS.REGISTER;
    readonly logoutBtn = BUTTON_STRINGS.LOGOUT;
    readonly createRecipeBtn = BUTTON_STRINGS.CREATE;
    readonly appTitle = LANDING_PAGE_STRINGS.TITLE;

    constructor(
        private router: Router,
        private dialog: MatDialog,
        private userService: UsersService,
        private sharedService: SharedService) { }

    register(): void {
        const dialogConfig = new MatDialogConfig();
        dialogConfig.autoFocus = true;
        dialogConfig.width = '30%';
        dialogConfig.panelClass = 'dialog';
        this.dialog.open(RegisterComponent, dialogConfig);
    }
    isUserLogged(): boolean {
        return this.sharedService.getIsUserLogged();
    }

    login(): void {
        const dialogConfig = new MatDialogConfig();

        dialogConfig.autoFocus = true;
        dialogConfig.width = '30%';
        dialogConfig.panelClass = 'dialog';
        this.dialog.open(LoginComponent, dialogConfig);
    }

    createRecipe(): void {
        this.router.navigate(['recipes/create']);
    }

    logout(): void {
        this.userService.logout();
    }
}
