import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class SongService {

  constructor(private http: HttpClient) {

  }

  getSongs() : Observable<any[]> {
    return this.http.get<any[]>('http://localhost:8080/songs');
  }

}
