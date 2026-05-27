import { Component, OnInit, computed, signal } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { Perro, Raza } from '../../core/models/nexocanino.models';
import { NexoApiService } from '../../core/services/nexo-api.service';
import { PerroCardComponent } from '../../shared/perro-card/perro-card.component';

@Component({
  selector: 'app-perros',
  standalone: true,
  imports: [FormsModule, RouterLink, PerroCardComponent],
  templateUrl: './perros.component.html',
})
export class PerrosComponent implements OnInit {
  public readonly perros = signal<readonly Perro[]>([]);
  public readonly razas = signal<readonly Raza[]>([]);
  public readonly selectedRaza = signal('todas');
  public readonly selectedTamano = signal('todos');
  public readonly detailId = signal<number | null>(null);

  public readonly filteredPerros = computed(() =>
    this.perros().filter((perro) => {
      const razaMatch = this.selectedRaza() === 'todas' || perro.raza.id === Number(this.selectedRaza());
      const tamanoMatch = this.selectedTamano() === 'todos' || perro.tamano === this.selectedTamano();
      return razaMatch && tamanoMatch;
    }),
  );

  public readonly selectedPerro = computed(() => this.perros().find((perro) => perro.id === this.detailId()) ?? null);

  constructor(
    private readonly api: NexoApiService,
    private readonly route: ActivatedRoute,
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => this.detailId.set(Number(params.get('id')) || null));
    this.api.getPerros().subscribe((perros) => this.perros.set(perros));
    this.api.getRazas().subscribe((razas) => this.razas.set(razas));
  }
}
