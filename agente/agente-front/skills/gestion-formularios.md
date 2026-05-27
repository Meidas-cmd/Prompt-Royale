# Skill: Formularios Reactivos Complejos (Reactive Forms)

Cada vez que implementes un formulario en NexoCanino (Servicios o Voluntariado):

1. **Estructura Reactiva:** Utiliza obligatoriamente `FormBuilder` y `FormGroup` importando `ReactiveFormsModule` en el componente standalone.
2. **Validación Estricta:** Aplica validaciones nativas de Angular (`Validators.required`, `Validators.email`, etc.) en todos los campos obligatorios del contrato.
3. **Control en la Plantilla:** Mapea el formulario en el HTML usando las directivas `[formGroup]` y `formControlName`. 
4. **Envío Seguro:** Al procesar el método de guardado, verifica que el formulario sea válido (`this.miFormulario.valid`) antes de transformar el valor en el payload JSON final que se enviará al servicio.