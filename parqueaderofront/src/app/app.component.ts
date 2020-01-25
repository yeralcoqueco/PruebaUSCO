import { Component } from '@angular/core';
import { ParqueaderoService } from './Service/parqueadero.service';
import { Parqueadero } from './Model/parqueadero';
import { PuestoService } from './Service/puesto.service';
import { Puesto } from './Model/puesto';
import { EstudianteSService } from './Service/estudiante-s.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Parqueadero Bicy';
  listaParqueadero: Parqueadero[] = [];
  listaPuestos: Puesto[] = [];
  puestoSeleccionado: Puesto = new Puesto();
  mostrarPuesto: boolean = false;
  mostrarIngresarBici: boolean = false;

  nombreIngreso:string = "";
  codigoIngreso:string = "";
  cuposDisponibles:number = 0;


  constructor(
    private serviceParqueadero: ParqueaderoService,
    private servicePuesto: PuestoService,
    private serviceEstudiante: EstudianteSService
  ) {
  }

    ngOnInit() {
      this.serviceParqueadero.listar().subscribe(rta => {
      this.listaParqueadero = rta;
      });
    }

    consultarPuestos(parqueadero: Parqueadero){

    this.servicePuesto.listarPuestosParqueadero(parqueadero.id).subscribe(rta =>{
      let cantidadRegistros: number = rta.length;
      if(cantidadRegistros != 0){
        this.listaPuestos  = rta;       
      }else{
        this.guardarPuesto(parqueadero);
        this.servicePuesto.listarPuestosParqueadero(parqueadero.id).subscribe(rta =>{
          this.listaPuestos = rta;
        });
      }
      this.cuposDisponibles = 0;
      this.listaPuestos.forEach(element => {
        if(!element.estado){
          this.cuposDisponibles++;
        }
      });

      console.log(this.listaPuestos);
    });
    }

    guardarPuesto(parqueadero: Parqueadero){
      let puesto: Puesto = new Puesto();
      puesto.estado = false;
      puesto.idEstudiante = null;
      puesto.idParqueadero = parqueadero;      

      for (let i = 0; i < parqueadero.numPuestos; i++) {        
        this.servicePuesto.guardar(puesto).subscribe(rta =>{
          console.log("Ok");
        });
      }
    }

    seleccionarPuesto(puesto:Puesto,accion: string){
      this.puestoSeleccionado = puesto;
      if(accion == "ver"){
        this.mostrarPuesto = true;
      }
      if(accion == "ingresarBici"){        
        this.mostrarIngresarBici = true;
      }
      if(accion == "liberar"){                
        this.liberar();
      }

    }

    ocuparPuesto(){
      this.serviceEstudiante.asignarEstudiante(this.nombreIngreso,this.codigoIngreso,this.puestoSeleccionado.id).subscribe(res =>{
        this.servicePuesto.listarPuestosParqueadero(this.puestoSeleccionado.idParqueadero.id).subscribe(rta =>{
          this.listaPuestos = rta;
          this.cuposDisponibles = 0;
          this.listaPuestos.forEach(element => {
            if(!element.estado){
              this.cuposDisponibles++;
            }
          });
        });
      });
    }

    liberar(){
      this.servicePuesto.liberar(this.puestoSeleccionado.id).subscribe(rta=>{
        this.servicePuesto.listarPuestosParqueadero(this.puestoSeleccionado.idParqueadero.id).subscribe(rta =>{
          this.listaPuestos = rta;
          this.cuposDisponibles = 0;
          this.listaPuestos.forEach(element => {
            if(!element.estado){
              this.cuposDisponibles++;
            }
          });
        });
      });        
    }

  


}
