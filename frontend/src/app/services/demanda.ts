import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Demanda } from '../model/demanda.model';

@Injectable({
  providedIn: 'root'
})

export class DemandaService {
  private readonly urlAPI = 'http://localhost:8080/demanda'; // URL do Spring Boot

  constructor(private http: HttpClient) { }

  listar(): Observable<Demanda[]> {
    return this.http.get<Demanda[]>(this.urlAPI);
  }

  inserir(demanda: Demanda): Observable<Demanda> {
    return this.http.post<Demanda>(this.urlAPI, demanda);
  }

  atualizar(demanda: Demanda): Observable<Demanda> {
    return this.http.put<Demanda>(`${this.urlAPI}/${demanda.id}`, demanda);
  }

  excluir(id: number): Observable<any> {
    return this.http.delete<any>(`${this.urlAPI}/${id}`);
  }

}