import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { url_api } from './api';

@Injectable({
  providedIn: 'root'
})
export class EstudianteSService {

  constructor(
    private http: HttpClient
  ) { }

  asignarEstudiante(nombre:string, codigo:string, idPuesto:number){
    return this.http.get<void>(url_api+'/estudiante/asignarEstudiante/'+nombre+"/"+codigo+"/"+idPuesto);
  }

}
