import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { PerrosComponent } from './pages/perros/perros.component';
import { TiendaComponent } from './pages/tienda/tienda.component';
import { NosotrosComponent } from './pages/nosotros/nosotros.component';
import { ContactoComponent } from './pages/contacto/contacto.component';

export const routes: Routes = [
  { path: '', component: HomeComponent, title: 'NexoCanino' },
  { path: 'perros', component: PerrosComponent, title: 'Perros | NexoCanino' },
  { path: 'perros/:id', component: PerrosComponent, title: 'Detalle perro | NexoCanino' },
  { path: 'tienda', component: TiendaComponent, title: 'Tienda | NexoCanino' },
  { path: 'nosotros', component: NosotrosComponent, title: 'Nosotros | NexoCanino' },
  { path: 'contacto', component: ContactoComponent, title: 'Contacto | NexoCanino' },
  { path: '**', redirectTo: '' },
];
