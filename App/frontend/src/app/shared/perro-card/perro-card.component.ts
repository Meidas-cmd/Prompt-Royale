import { Component, Input } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Perro } from '../../core/models/nexocanino.models';

@Component({
  selector: 'app-perro-card',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './perro-card.component.html',
})
export class PerroCardComponent {
  @Input({ required: true }) perro!: Perro;
}
