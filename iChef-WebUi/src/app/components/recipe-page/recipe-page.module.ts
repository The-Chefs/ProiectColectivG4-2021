import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { MatGridListModule } from '@angular/material/grid-list';
import { MatTableModule } from '@angular/material/table';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { ReactiveFormsModule } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';
import { MatSelectModule } from '@angular/material/select';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatCardModule } from '@angular/material/card';
import { MatSortModule } from '@angular/material/sort';
import { RecipePageComponent } from './recipe-page.component';
import { UploadImageFormModule } from '../upload-image-form/upload-image-form.module';

const routes: Routes = [
    {
        path: '',
        component: RecipePageComponent
    }
];

@NgModule({
    declarations: [
        RecipePageComponent
    ],
    imports: [
        CommonModule,
        RouterModule.forChild(routes),
        MatTableModule,
        MatFormFieldModule,
        MatButtonModule,
        MatInputModule,
        MatProgressSpinnerModule,
        ReactiveFormsModule,
        MatIconModule,
        MatSelectModule,
        MatCardModule,
        MatInputModule,
        MatFormFieldModule,
        MatSortModule,
        MatGridListModule,
        UploadImageFormModule
    ],
    exports: [
        RecipePageComponent
    ]
})
export class RecipePageModule { }
