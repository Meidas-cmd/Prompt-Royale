import { Injectable, computed, signal } from '@angular/core';
import { CartItem, Producto } from '../models/nexocanino.models';

const STORAGE_KEY = 'nexocanino-cart';

@Injectable({ providedIn: 'root' })
export class CartService {
  private readonly itemsSignal = signal<readonly CartItem[]>(this.loadItems());

  public readonly items = this.itemsSignal.asReadonly();
  public readonly count = computed(() => this.items().reduce((total, item) => total + item.cantidad, 0));
  public readonly total = computed(() =>
    this.items().reduce((total, item) => total + item.precio * item.cantidad, 0),
  );

  add(producto: Producto): void {
    const current = this.items();
    const existing = current.find((item) => item.id === producto.id);
    const next = existing
      ? current.map((item) => (item.id === producto.id ? { ...item, cantidad: item.cantidad + 1 } : item))
      : [...current, { ...producto, cantidad: 1 }];

    this.save(next);
  }

  clear(): void {
    this.save([]);
  }

  private save(items: readonly CartItem[]): void {
    this.itemsSignal.set(items);
    localStorage.setItem(STORAGE_KEY, JSON.stringify(items));
  }

  private loadItems(): readonly CartItem[] {
    try {
      return JSON.parse(localStorage.getItem(STORAGE_KEY) ?? '[]') as readonly CartItem[];
    } catch {
      return [];
    }
  }
}
