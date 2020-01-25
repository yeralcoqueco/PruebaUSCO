import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { url_api } from './api';
import { Parqueadero } from '../Model/parqueadero';

@Injectable({
  providedIn: 'root'
})
export class ParqueaderoService {

  constructor(
    private http: HttpClient
  ) { }

  listar() {
    return this.http.get<Parqueadero[]>(url_api + '/parqueadero/buscar-todo');
  }
}
