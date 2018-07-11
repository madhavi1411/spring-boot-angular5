import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import { SongListComponent } from './song-list/song-list.component';
import {SongService} from './services/song.service';


export const  routes: Routes = [

  {
    path: 'songs',
    component: SongListComponent,

    // nested navigation
    children: [
      {
        path: 'edit/:id',
        component: SongListComponent
      }
    ]
  }

];
@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  declarations: [SongListComponent],
  providers: [
    SongService
  ]
})
export class SongModule { }
