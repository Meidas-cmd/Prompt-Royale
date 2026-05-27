import { Component, OnInit, computed, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Perro, Raza } from '../../core/models/nexocanino.models';
import { NexoApiService } from '../../core/services/nexo-api.service';

@Component({
  selector: 'app-perros',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './perros.component.html',
  styleUrl: './perros.component.css',
})
export class PerrosComponent implements OnInit {
  public readonly perros = signal<readonly Perro[]>([]);
  public readonly razas = signal<readonly Raza[]>([]);
  public readonly selectedRaza = signal('todas');
  public readonly selectedTamano = signal('todos');
  public readonly razaQuery = signal('');

  public readonly filteredPerros = computed(() => {
    const selectedRaza = this.selectedRaza().trim().toLowerCase();
    const selectedTamano = this.selectedTamano();
    const query = this.razaQuery().trim().toLowerCase();

    return this.perros().filter((perro) => {
      const razaTexto = String(perro.raza).trim().toLowerCase();
      const razaMatch = selectedRaza === 'todas' || razaTexto === selectedRaza;
      const tamanoMatch = selectedTamano === 'todos' || perro.tamano === selectedTamano;
      const queryMatch = query.length === 0 || razaTexto.includes(query);

      return razaMatch && tamanoMatch && queryMatch;
    });
  });

  public readonly totalPerros = computed(() => this.perros().length);
  public readonly perrosActivos = computed(() => this.perros().filter((perro) => perro.disponible).length);

  constructor(private readonly api: NexoApiService) {}

  ngOnInit(): void {
    this.api.getPerros().subscribe((perros) => this.perros.set(perros));
    this.api.getRazas().subscribe((razas) => this.razas.set(razas));
  }
}
