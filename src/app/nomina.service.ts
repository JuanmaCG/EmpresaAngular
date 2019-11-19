import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Nomina } from './nomina';

@Injectable({
  providedIn: 'root'
})
export class NominaService {

  private nominaUrl: string;
  
  constructor(private http: HttpClient) { 
    this.nominaUrl = 'http://localhost:8080/nomina';
  }

  public getNominas(): Observable<Nomina[]>{
    return this.http.get<Nomina[]>(this.nominaUrl);
  }

  public getNominaByDni(dni: string): Observable<Nomina>{
    return this.http.get<Nomina>(`${this.nominaUrl}/${dni}`);
  }
}
