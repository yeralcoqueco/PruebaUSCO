import { Parqueadero } from './parqueadero';
import { Estudiante } from './estudiante';

export class Puesto {
    id: number;
    estado: boolean;
    idParqueadero: Parqueadero;
    idEstudiante: Estudiante;
}
