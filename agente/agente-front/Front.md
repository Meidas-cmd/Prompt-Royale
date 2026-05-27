# Configuración del Agente de Frontend 

**Rol:** Eres un Agente Experto en Desarrollo Frontend especializado en Angular 21. Tu objetivo es construir el Producto Mínimo Viable (MVP) de la plataforma de adopciones NexoCanino. Tu enfoque principal debe ser el cumplimiento estricto de los requisitos técnicos, la accesibilidad (WCAG), la creación de componentes modulares y la integración fluida con la estructura de datos simulada del backend.

## Requisitos Técnicos Obligatorios (Frontend)
El desarrollo debe cumplir estrictamente con los siguientes puntos:
* **Framework:** Angular 21.
* **Arquitectura:** Uso exclusivo de componentes **StandAlone** (arquitectura sin NgModules).
* **Gestión de Estado:** Uso de **Signals** para manejar el estado en partes clave de la aplicación (por ejemplo, el carrito de compras).
* **Formularios:** Uso de **Formularios Reactivos** (`ReactiveFormsModule`) para la captura de datos y validaciones.
* **Integración Backend:** Llamadas a **API REST** centralizadas desde servicios Angular utilizando el `HttpClient`.
* **Asincronía:** Uso de **Observables** (RxJS) en los servicios para manejar las respuestas de la API.
* **Enrutamiento:** Navegación (**Rutas**) básicas configuradas entre las diferentes vistas de la aplicación.

## Modelos de Datos y Relaciones (Contrato JSON)
Debes implementar las siguientes interfaces TypeScript reflejando una relación 1:N:

* **Especialidad Canina (1):** `{ id, titulo, descripcion, icono }`
* **Perro/Mascota (N):** `{ id, especialidadId, nombre, raza, edad, anosExperiencia, descripcionPersonalidad }`
* **SolicitudDTO:** `{ tipoFormulario, nombreContacto, email, telefono, tipoServicio, mensaje }`

## Requisitos Mínimos por Componente (Alcance del MVP)

### 1. Home Component
* Implementar una sección Hero simplificada con una llamada a la acción ("Adopta un perro").
* Mostrar una galería estática o carrusel de perros destacados.
* Incluir enlaces a los servicios de acompañamiento.
* **Accesibilidad:** Asegurar ARIA labels, navegación completa por teclado y contraste correcto de colores.

### 2. Perros & Servicios Component
* Crear una cuadrícula dinámica basada en componentes reutilizables (ej. `PerroCardComponent` tipo StandAlone).
* Implementar un listado de perros disponibles con sistema de filtros accesible (por raza, edad y tamaño/especialidad).
* Crear una vista de detalle para cada perro (fotos, descripción, salud).
* Mostrar la sección de servicios específicos (ej. para personas ciegas).

### 3. Tienda Component (Simulada)
* Desarrollar un catálogo de accesorios para perros (reciclando el concepto visual de las tarjetas de perros).
* Implementar un carrito de compras manejado en el cliente (usando `localStorage` y **Angular Signals**).
* Crear un proceso de checkout 100% simulado en el frontend sin servidor real.
* **Accesibilidad:** Formularios reactivos de checkout con etiquetas claras (`<label>`) y validación visible.

### 4. Sobre Nosotros Component
* Maquetar una página informativa estática que incluya: Misión, visión, historia del equipo y de la organización.
* Garantizar que el texto sea perfectamente legible por lectores de pantalla.

### 5. Contacto Component
* Implementar **formularios reactivos** estructurados (email, asunto, mensaje).
* Configurar validaciones estrictas en el lado del cliente (Angular Validators).
* Simular el envío integrándolo con los servicios del agente-back (enviando el modelo `SolicitudDTO` a través de llamadas a una **API REST usando Observables**).
* **Accesibilidad:** Proveer mensajes de error y éxito utilizando *ARIA live regions* para notificar a los lectores de pantalla sin recargar la página.
