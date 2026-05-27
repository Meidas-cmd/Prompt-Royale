import { Component, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

export interface Mascota {
  id: number;
  especialidadId: number;
  nombre: string;
  raza: string;
  edad: number;
  anosExperiencia: number;
  descripcionPersonalidad: string;
  imagenUrl: string;
}

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './app.html',  // <-- Apunta exactamente a tu archivo app.html
  styleUrls: ['./app.css']    // <-- Apunta exactamente a tu archivo app.css
})
export class AppComponent {
  public perrosDestacados = signal<Mascota[]>([
    {
      id: 1,
      especialidadId: 1,
      nombre: 'Luna',
      raza: 'Golden Retriever',
      edad: 5,
      anosExperiencia: 3,
      descripcionPersonalidad: 'Tranquila, paciente y especialmente cuidadosa en entornos hospitalarios.',
      imagenUrl: 'assets/images/perros/luna.jpg'
    },
    {
      id: 2,
      especialidadId: 2,
      nombre: 'Bruno',
      raza: 'Labrador Retriever',
      edad: 4,
      anosExperiencia: 2,
      descripcionPersonalidad: 'Sociable, atento y muy receptivo con personas mayores.',
      imagenUrl: 'assets/images/perros/bruno.jpg'
    },
    {
      id: 3,
      especialidadId: 3,
      nombre: 'Nala',
      raza: 'Border Collie',
      edad: 6,
      anosExperiencia: 4,
      descripcionPersonalidad: 'Activa, inteligente y cercana en sesiones de apoyo emocional.',
      imagenUrl: 'assets/images/perros/nala.jpg'
    }
  ]);
}
