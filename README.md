# NexoCanino instrucciones

Aplicacion Angular 21 standalone para el MVP de NexoCanino. Consume el backend Spring Boot en `http://localhost:8080/api`.

## Requisitos

- Node.js compatible con Angular 21.
- npm instalado.
- Java 17 o superior para ejecutar el backend.

## Arrancar el backend

Desde la carpeta del backend:

```bash
cd App/backend
./mvnw.cmd spring-boot:run
```

El backend debe quedar disponible en:

```text
http://localhost:8080
```

Endpoints utiles:

```text
GET http://localhost:8080/api/perros
GET http://localhost:8080/api/razas
```

La consola H2 esta disponible en:

```text
http://localhost:8080/h2-console
```

Datos H2:

```text
JDBC URL: jdbc:h2:mem:nexocanino
User: sa
Password: dejar vacio
```

## Arrancar el frontend

Desde la carpeta del frontend:

```bash
cd App/frontend
npm install
npm.cmd start
```

Por defecto Angular intenta usar:

```text
http://localhost:4200
```

Si el puerto `4200` esta ocupado, usa otro puerto:

```bash
npm.cmd start -- --host 127.0.0.1 --port 4201
```

En ese caso abre:

```text
http://127.0.0.1:4201
```

## Compilar

```bash
cd App/frontend
npm.cmd run build
```

La salida se genera en:

```text
App/frontend/dist/nexocanino-front
```

## Tests frontend

```bash
cd App/frontend
npm.cmd test -- --watch=false
```

## Tests backend

```bash
cd App/backend
.\mvnw.cmd test
```

## Notas

- El frontend espera el backend en `http://localhost:8080/api`.
- Si no ves cambios recientes en el navegador, recarga con `Ctrl + F5` o reinicia `ng serve`.
- En PowerShell puede fallar `npm` por la politica de ejecucion de scripts; usa `npm.cmd`.
