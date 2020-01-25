import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { url_api } from './api';
import { Puesto } from '../Model/puesto';

@Injectable({
  providedIn: 'root'
})
export class PuestoService {

  constructor(
    private http: HttpClient
  ) { }

  guardar(puesto: Puesto) {
    return this.http.post(url_api + '/puesto', puesto);
  }

  listarPuestosParqueadero(idParqueadero: number){
    return this.http.get<Puesto[]>(url_api+'/puesto/listarPuestosParqueadero/'+idParqueadero);
  }

  liberar(idPuesto: number){
    return this.http.get<void>(url_api+'/puesto/liberar/'+idPuesto);
  }


}
