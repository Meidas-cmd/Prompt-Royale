import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { NexoApiService } from '../../core/services/nexo-api.service';

@Component({
  selector: 'app-contacto',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './contacto.component.html',
})
export class ContactoComponent {
  private readonly fb = inject(FormBuilder);
  private readonly api = inject(NexoApiService);

  public readonly form = this.fb.nonNullable.group({
    tipoFormulario: ['SOLICITUD_SERVICIO' as const, Validators.required],
    nombreContacto: ['', [Validators.required, Validators.minLength(3)]],
    email: ['', [Validators.required, Validators.email]],
    telefono: ['', [Validators.required, Validators.pattern(/^[0-9 +()-]{7,}$/)]],
    tipoServicio: ['Acompanamiento hospitalario', Validators.required],
    mensaje: ['', [Validators.required, Validators.minLength(10)]],
  });

  public statusMessage = '';

  submit(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      this.statusMessage = 'Revisa los campos marcados antes de enviar.';
      return;
    }

    this.api.enviarSolicitud(this.form.getRawValue()).subscribe(() => {
      this.statusMessage = 'Solicitud enviada correctamente.';
      this.form.reset({
        tipoFormulario: 'SOLICITUD_SERVICIO',
        nombreContacto: '',
        email: '',
        telefono: '',
        tipoServicio: 'Acompanamiento hospitalario',
        mensaje: '',
      });
    });
  }
}
