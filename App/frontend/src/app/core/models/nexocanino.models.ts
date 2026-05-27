export interface Raza {
  id: number;
  nombre: string;
  descripcion: string;
}

export interface Perro {
  id: number;
  nombre: string;
  edad: number;
  tamano: string;
  descripcion: string;
  foto: string;
  disponible: boolean;
  raza: Raza;
}

export interface EspecialidadCanina {
  id: number;
  titulo: string;
  descripcion: string;
  icono: string;
}

export interface SolicitudDto {
  tipoFormulario: 'SOLICITUD_SERVICIO' | 'VOLUNTARIADO';
  nombreContacto: string;
  email: string;
  telefono: string;
  tipoServicio: string;
  mensaje: string;
}

export interface Producto {
  id: number;
  nombre: string;
  categoria: string;
  precio: number;
  descripcion: string;
}

export interface CartItem extends Producto {
  cantidad: number;
}
