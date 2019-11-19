import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from 'rxjs';
import { Empleado } from './empleado';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {

  private empleadosUrl: string;

  constructor(private http: HttpClient) { 
    this.empleadosUrl = 'http://localhost:8080/empleados';
  }

  public findAll(): Observable<Empleado[]> {
    return this.http.get<Empleado[]>(this.empleadosUrl);
  }

  public findByDni(dni: string): Observable<Empleado> {
    return this.http.get<Empleado>(`${this.empleadosUrl}/${dni}`)
  }

  public create(empleado: Empleado) {
    return this.http.post<Empleado>(this.empleadosUrl, empleado);
  }

  public deleteEmpleado(dni: string) {
    return this.http.delete(`${this.empleadosUrl}/${dni}`)
  }

  public updateEmpleado(empleado: Empleado, dni: string) {
    return this.http.patch(`${this.empleadosUrl}/${dni}`, empleado)
  }

}
