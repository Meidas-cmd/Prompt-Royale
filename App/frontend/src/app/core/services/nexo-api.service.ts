import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, of } from 'rxjs';
import { Perro, Raza, SolicitudDto } from '../models/nexocanino.models';

const API_URL = 'http://localhost:8080/api';

@Injectable({ providedIn: 'root' })
export class NexoApiService {
  constructor(private readonly http: HttpClient) {}

  getPerros(): Observable<readonly Perro[]> {
    return this.http.get<readonly Perro[]>(`${API_URL}/perros`).pipe(catchError(() => of([])));
  }

  getRazas(): Observable<readonly Raza[]> {
    return this.http.get<readonly Raza[]>(`${API_URL}/razas`).pipe(catchError(() => of([])));
  }

  enviarSolicitud(solicitud: SolicitudDto): Observable<SolicitudDto> {
    return this.http.post<SolicitudDto>(`${API_URL}/contacto`, solicitud).pipe(catchError(() => of(solicitud)));
  }
}
