import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RecipesComponent } from './recipes.component';
import { RecipeCardComponent } from './recipe-card/recipe-card.component';
import { RouterModule, Routes } from '@angular/router';

import { MatTableModule } from '@angular/material/table';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { ReactiveFormsModule } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';
import { MatSelectModule } from '@angular/material/select';
import { MatCardModule } from '@angular/material/card';
import { MatSortModule } from '@angular/material/sort';
import { RecipesService } from 'src/app/services/recipes.service';
import { environment } from 'src/environments/environment';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

const routes: Routes = [
    {
        path: '',
        component: RecipesComponent
    }
];

@NgModule({
    declarations: [
        RecipesComponent,
        RecipeCardComponent
    ],
    imports: [
        CommonModule,
        RouterModule.forChild(routes),
        MatTableModule,
        MatFormFieldModule,
        MatButtonModule,
        MatInputModule,
        ReactiveFormsModule,
        MatIconModule,
        MatSelectModule,
        MatCardModule,
        MatInputModule,
        MatFormFieldModule,
        MatSortModule,
        HttpClientModule,
        FormsModule
    ],
    exports: [
        RecipesComponent,
        RecipeCardComponent
    ],
    providers: [
        { provide: 'BASE_API_URL', useValue: environment.apiUrl },
        RecipesService
    ]
})
export class RecipesModule { }
