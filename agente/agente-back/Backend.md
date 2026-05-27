Hola. Necesito que actúes exclusivamente como mi Agente de Backend Senior. Vamos a desarrollar la API REST del proyecto utilizando JAVA 17 y SPRING BOOT 3.x. 

Por exigencias del equipo, el apartado de Frontend (Angular) queda totalmente fuera de tus tareas (lo gestionará otra persona). Tu foco único y absoluto es el Backend. 

Para evitar mezclas de código, procesa y ejecuta la arquitectura dividiendo las tareas estrictamente entre el bloque ESENCIAL (Obligatorio) y el bloque OPCIONAL, trabajando en un orden lógico.

---

## 🚨 REQUISITOS ESENCIALES Y OBLIGATORIOS (Prioridad Máxima)

Debes generar una API funcional y persistente estructurada por capas (`model`, `repository`, `service`, `controller`) que implemente una relación relacional Uno a Muchos (1:M).

1. **Configuración del Entorno (`src/main/resources/application.properties`):**
   - Configurar la base de datos relacional **H2 en memoria**.
   - Habilitar la consola web de H2 (`spring.h2.console.enabled=true`) para pruebas de base de datos en el navegador.

2. **Modelo de Datos Relacional (1:M) con JPA:**
   - **Entidad Principal (1):** `Raza.java` (Campos obligatorios: `id` tipo Long autoincremental, `nombre` String, `descripcion` String). Debe incluir la anotación `@OneToMany` apuntando a los perros.
   - **Entidad Hija (M):** `Perro.java` (Campos obligatorios: `id` tipo Long autoincremental, `nombre` String, `edad` Integer, `tamaño` String, `descripcion` String, `foto` String, `disponible` Boolean). Debe incluir la anotación `@ManyToOne` y `@JoinColumn` hacia Raza.

3. **Endpoints de la API REST Functional (Controladores con `@RestController`):**
   - Todos los controladores deben llevar la anotación `@CrossOrigin` para permitir la futura conexión del equipo de frontend sin errores de CORS.
   - **Operación Listar (GET):** `GET /api/perros` -> Devuelve el listado completo de todos los perros.
   - **Operación Detalle (GET):** `GET /api/perros/{id}` -> Devuelve un perro específico por su ID.
   - **Operación Crear (POST):** `POST /api/perros` -> Recibe un JSON en el cuerpo (`@RequestBody`) e inserta un nuevo perro en la base de datos H2 vinculándolo a su raza.
   - **Consulta de la Relación (GET):** `GET /api/razas/{id}/perros` -> Devuelve todos los perros que pertenecen a esa ID de raza concreta.
   - **Operación Editar (PUT):** `PUT /api/perros/{id}` -> Permite modificar y actualizar los datos de un perro existente.
   - **Operación Borrar (DELETE):** `DELETE /api/perros/{id}` -> Elimina un registro de perro de la base de datos de manera física o lógica.

---

## 💤 REQUISITOS OPCIONALES Y SECUNDARIOS (Pausados por ahora)

No generes absolutamente nada de este bloque hasta que lo esencial compile y responda correctamente en Postman/navegador:
- Esquemas de paginación o ordenación de registros en los métodos `GET` (Pageable).
- Seguridad del sistema (Spring Security / JWT).
- Endpoints adicionales para la gestión individualizada de usuarios, login o roles.
- Scripts automáticos complejos de carga masiva de datos (`data.sql` masivos).

---

🎯 TAREA ACTUAL:
Por favor, asume tu rol de Agente Back en Java 17 y genera ÚNICAMENTE la primera parte del bloque OBLIGATORIO: el archivo `application.properties` con la base de datos H2 y el código de las dos entidades JPA (`Raza.java` y `Perro.java`) mapeadas correctamente con su relación 1:M. ¡Facítame el código limpio para empezar a guardarlo!
