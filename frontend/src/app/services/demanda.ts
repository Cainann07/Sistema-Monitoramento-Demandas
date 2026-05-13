import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class DemandaService {
  private readonly urlAPI = 'http://localhost:8080/demanda'; // URL do Spring Boot

  constructor(private http: HttpClient) { }

  listar(): Observable<any[]> {
    return this.http.get<any[]>(this.urlAPI);
  }

  inserir(demanda: any): Observable<any> {
    return this.http.post<any>(this.urlAPI, demanda);
  }

}