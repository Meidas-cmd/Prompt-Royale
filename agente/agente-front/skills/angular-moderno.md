# Skill: Estándares de Angular 21 y Gestión de Estado

Cada vez que generes, completes o modifiques la lógica de un componente:

1. **Componentes Standalone:** Todo componente debe tener la propiedad `standalone: true`.
2. **Uso Obligatorio de Signals:** El estado reactivo del componente (listas de perros, filtros seleccionados, estados de carga) debe manejarse usando Signals (`signal()`).
   - Para valores derivados o filtrados automáticos basados en otra Signal, utiliza obligatoriamente variables calculadas con `computed()`.
3. **Flujo de Control en Plantillas:** Queda terminantemente prohibido usar las directivas estructurales antiguas (`*ngIf` o `*ngFor`). Usa exclusivamente la nueva sintaxis:
   - `@if (condicion()) { ... } @else { ... }`
   - `@for (perro of listaMascotas(); track perro.id) { ... }`