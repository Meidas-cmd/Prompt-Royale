import { CurrencyPipe } from '@angular/common';
import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Producto } from '../../core/models/nexocanino.models';
import { CartService } from '../../core/services/cart.service';

@Component({
  selector: 'app-tienda',
  standalone: true,
  imports: [CurrencyPipe, ReactiveFormsModule],
  templateUrl: './tienda.component.html',
})
export class TiendaComponent {
  private readonly fb = inject(FormBuilder);
  public readonly cart = inject(CartService);

  public readonly productos: readonly Producto[] = [
    { id: 1, nombre: 'Arnes ergonomico', categoria: 'Paseo', precio: 34.9, descripcion: 'Ajuste comodo para salidas de terapia.' },
    { id: 2, nombre: 'Cama descanso', categoria: 'Bienestar', precio: 49.9, descripcion: 'Base lavable para perros medianos y grandes.' },
    { id: 3, nombre: 'Kit cuidado', categoria: 'Salud', precio: 22.5, descripcion: 'Cepillo, toalla y balsamo para patas.' },
  ];

  public readonly checkoutForm = this.fb.nonNullable.group({
    nombre: ['', [Validators.required, Validators.minLength(3)]],
    email: ['', [Validators.required, Validators.email]],
    direccion: ['', [Validators.required, Validators.minLength(8)]],
  });

  public checkoutMessage = '';

  add(producto: Producto): void {
    this.cart.add(producto);
  }

  checkout(): void {
    if (this.checkoutForm.invalid || this.cart.count() === 0) {
      this.checkoutForm.markAllAsTouched();
      this.checkoutMessage = 'Revisa los campos y anade al menos un producto.';
      return;
    }

    this.cart.clear();
    this.checkoutForm.reset();
    this.checkoutMessage = 'Pedido simulado registrado correctamente.';
  }
}
