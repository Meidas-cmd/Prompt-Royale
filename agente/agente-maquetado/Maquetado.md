# Agente Maquetador y Diseñador UI/UX - NexoCanino

*Objetivo:* Replicar con total fidelidad el estilo visual, encuadrado, gama de colores y patrones de distribución de la sección /logistic de la plantilla 'Genesis' de PrimeNG para las pantallas de nuestra aplicación.

---

## 🎨 1. Paleta de Colores y Fondos (ADN Genesis)
Aplica estrictamente los siguientes códigos cromáticos para lograr el acabado limpio y corporativo:
- *Fondo de la Aplicación (Body/Canvas):* Gris ultra claro mate (#f8f9fa o #f1f5f9). Las tarjetas deben "flotar" sobre este fondo.
- *Fondo de Contenedores/Tarjetas:* Blanco puro (#ffffff).
- *Color de Texto Principal:* Gris oscuro suave (#334155 o #475569) para títulos y etiquetas primarias. Nunca usar negro puro (#000000).
- *Color de Texto Secundario (Métricas/Subtítulos):* Gris tenue (#64748b o #94a3b8).
- *Colores de Estado (Badges/Etiquetas de Estado):* Utilizar tonos pastel con texto de alta intensidad para asegurar contraste (WCAG AA):
  - Completado/Activo (Verde): Fondo #dcfce7, Texto #15803d
  - Pendiente/En Proceso (Naranja/Azul): Fondo #e0f2fe, Texto #0369a1
  - Alerta/Urgente (Rojo): Fondo #fee2e2, Texto #b91c1c

---

## 📦 2. El "Encuadrado" y Contenedores (Cards Layout)
Las tarjetas de la pestaña /logistic siguen un patrón geométrico muy específico:
- *Bordes suavizados:* Aplicar un radio de curvatura idéntico de border-radius: 12px en todas las tarjetas de información.
- *Sombra "Invisible" (Soft Shadow):* No usar bordes lineales rígidos. La separación se da mediante una sombra difuminada y sutil:
  box-shadow: 0px 4px 20px rgba(0, 0, 0, 0.04), 0px 1px 2px rgba(0, 0, 0, 0.02);
- *Márgenes y Aireación (Paddings):* El contenido dentro de cada tarjeta debe respirar. Utilizar un padding interno estricto de padding: 1.5rem (24px).

---

## 🖥️ 3. Distribución y Enmaquetado (Dashboard Components)
Organiza los datos simulando el layout de logística mediante CSS Grid y Flexbox:
1. *Fila Superior (Métricas Rápidas):* Un grid de 3 o 4 columnas con tarjetas de datos clave (ej: total de perros, adopciones completadas hoy, solicitudes pendientes). Cada tarjeta incluye:
   - Un icono estilizado metido dentro de un círculo con fondo de color pastel muy suave en la esquina superior derecha.
   - El dato numérico en grande con tipografía semibold.
2. *Cuerpo Central (Sección Principal + Barra Lateral):* Layout dividido en dos columnas asimétricas (ej: 75% contenido, 25% barra de control):
   - Columna Izquierda: Un Grid/Tabla interactiva de registros con esquinas redondeadas, separadores de fila grises muy finos (border-bottom: 1px solid #f1f5f9) y estados marcados con los badges de colores definidos arriba.
   - Columna Derecha: Tarjeta de resumen o filtros rápidos acumulativos (estilo widget de seguimiento de envíos).

---

## ♿ 4. Capa de Accesibilidad Requerida (WCAG 2.1 AA)
- Todos los elementos interactivos que imiten el comportamiento de PrimeNG deben incorporar indicadores de foco (:focus-visible) mediante un anillo azul o violeta de 2px.
- Uso de etiquetas semánticas HTML5 (<main>, <section>, <article>) para estructurar el dashboard.
- Contraste de texto mínimo de 4.5:1 sobre los fondos blancos y grises.