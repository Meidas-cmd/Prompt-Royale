import { Component, OnInit, computed, signal } from '@angular/core';
import { RouterLink } from '@angular/router';
import { NexoApiService } from '../../core/services/nexo-api.service';
import { Perro } from '../../core/models/nexocanino.models';
import { PerroCardComponent } from '../../shared/perro-card/perro-card.component';

const fallbackPerros: readonly Perro[] = [
  {
    id: 1,
    nombre: 'Luna',
    edad: 4,
    tamano: 'Mediano',
    descripcion: 'Perra tranquila y carinosa, ideal para visitas a centros educativos.',
    foto: 'https://images.unsplash.com/photo-1552053831-71594a27632d?auto=format&fit=crop&w=900&q=80',
    disponible: true,
    raza: { id: 1, nombre: 'Labrador Retriever', descripcion: 'Sociable y paciente.' },
  },
  {
    id: 2,
    nombre: 'Max',
    edad: 6,
    tamano: 'Grande',
    descripcion: 'Perro paciente y sociable con experiencia en acompanamiento emocional.',
    foto: 'https://images.unsplash.com/photo-1558788353-f76d92427f16?auto=format&fit=crop&w=900&q=80',
    disponible: true,
    raza: { id: 2, nombre: 'Golden Retriever', descripcion: 'Tranquilo y afectuoso.' },
  },
  {
    id: 3,
    nombre: 'Nala',
    edad: 3,
    tamano: 'Mediano',
    descripcion: 'Perra activa, obediente y preparada para dinamicas grupales.',
    foto: 'https://images.unsplash.com/photo-1548199973-03cce0bbc87b?auto=format&fit=crop&w=900&q=80',
    disponible: false,
    raza: { id: 3, nombre: 'Border Collie', descripcion: 'Inteligente y activa.' },
  },
];

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [RouterLink, PerroCardComponent],
  templateUrl: './home.component.html',
})
export class HomeComponent implements OnInit {
  public readonly perros = signal<readonly Perro[]>(fallbackPerros);
  public readonly destacados = computed(() => this.perros().slice(0, 3));
  public readonly disponibles = computed(() => this.perros().filter((perro) => perro.disponible).length);

  constructor(private readonly api: NexoApiService) {}

  ngOnInit(): void {
    this.api.getPerros().subscribe((perros) => {
      if (perros.length > 0) {
        this.perros.set(perros);
      }
    });
  }
}
