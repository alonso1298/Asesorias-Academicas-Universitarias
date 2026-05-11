# Sistema de Asesorías Académicas Universitarias

## Descripción

Sistema web desarrollado para la gestión de asesorías académicas universitarias.  
La aplicación permite administrar alumnos, profesores, materias y asesorías mediante distintos roles de usuario.

El sistema fue desarrollado utilizando:

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Thymeleaf
- Bootstrap
- MySQL

---

# Objetivo del Proyecto

El objetivo del sistema es facilitar la organización y administración de asesorías académicas entre alumnos y profesores, permitiendo:

- Registro de alumnos
- Inicio de sesión seguro
- Gestión de asesorías
- Control de estados de asesorías
- Generación de reportes
- Exportación de reportes en PDF

---

# Tecnologías Utilizadas

| Tecnología | Descripción |
|---|---|
| Java 21 | Lenguaje principal |
| Spring Boot | Framework backend |
| Spring Security | Autenticación y autorización |
| Spring Data JPA | Persistencia de datos |
| Hibernate | ORM |
| Thymeleaf | Motor de plantillas |
| Bootstrap 5 | Diseño frontend |
| MySQL | Base de datos |
| Maven | Gestión de dependencias |
| iTextPDF | Generación de reportes PDF |

---

# Roles del Sistema

El sistema cuenta con los siguientes roles:

## Administrador

Puede:

- Gestionar alumnos
- Gestionar profesores
- Gestionar materias
- Visualizar todas las asesorías
- Generar reportes generales
- Exportar reportes en PDF

---

## Profesor

Puede:

- Visualizar sus asesorías
- Actualizar el estado de asesorías
- Consultar reportes semanales
- Exportar reportes PDF de sus asesorías

Estados disponibles:

- Pendiente
- Confirmada
- Completada
- Cancelada

---

## Alumno

Puede:

- Registrarse en el sistema
- Iniciar sesión
- Agendar asesorías
- Consultar asesorías registradas
- Cancelar asesorías
- Visualizar profesores disponibles

---

# Configuración del Proyecto

## 1. Clonar el repositorio

```bash
git clone <URL_DEL_REPOSITORIO>
```

---

## 2. Configurar la base de datos

Crear una base de datos en MySQL:

```sql
CREATE DATABASE asesorias_db;
```

---

## 3. Configurar application.properties

Ubicación:

```txt
src/main/resources/application.properties
```

Ejemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/asesorias_db
spring.datasource.username=root
spring.datasource.password=tu_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 4. Ejecutar el proyecto

Desde terminal:

```bash
mvn spring-boot:run
```

O ejecutar la clase principal desde IntelliJ IDEA.

---

# Estructura General del Proyecto

```txt
src
 ├── main
 │   ├── java
 │   │   └── mx.unam.aau
 │   │       ├── config
 │   │       ├── controller
 │   │       ├── entities
 │   │       ├── enums
 │   │       ├── repository
 │   │       ├── service
 │   │       └── utils
 │   └── resources
 │       ├── static
 │       └── templates
```

---

# Flujo de Uso del Sistema

# 1. Registro de Alumno

Un nuevo alumno puede registrarse desde la pantalla de login seleccionando:

```txt
Regístrate aquí
```

El sistema solicitará:

- Nombre completo
- Matrícula
- Carrera
- Semestre
- Correo electrónico
- Contraseña

Después del registro:

- Se crea automáticamente un usuario con rol ALUMNO
- La contraseña se almacena cifrada con BCrypt

---

# 2. Inicio de Sesión

El usuario accede mediante:

- Correo electrónico
- Contraseña

Spring Security valida las credenciales y redirige según el rol del usuario.

---

# 3. Flujo del Alumno

## Consultar profesores

El alumno puede visualizar los profesores registrados en el sistema.

---

## Agendar asesoría

El alumno selecciona:

- Profesor
- Materia
- Fecha
- Hora
- Notas de la asesoría

La asesoría se registra con estado:

```txt
pendiente
```

---

## Consultar asesorías

El alumno puede visualizar:

- Profesor
- Materia
- Fecha
- Hora
- Estado
- Notas

---

## Cancelar asesoría

El alumno puede cancelar asesorías mientras no estén completadas o canceladas previamente.

---

# 4. Flujo del Profesor

## Visualizar asesorías

El profesor puede consultar únicamente las asesorías asignadas a él.

---

## Actualizar estado

El profesor puede cambiar el estado de la asesoría:

- pendiente
- confirmada
- completada
- cancelada

---

## Generar reportes

El profesor puede consultar reportes semanales de:

- Total de asesorías
- Asesorías completadas
- Asesorías canceladas
- Asesorías pendientes

---

## Exportar PDF

El profesor puede exportar un reporte PDF semanal con sus asesorías.

---

# 5. Flujo del Administrador

## Gestión de alumnos

El administrador puede:

- Registrar
- Editar
- Eliminar
- Consultar alumnos

---

## Gestión de profesores

El administrador puede:

- Registrar
- Editar
- Eliminar
- Consultar profesores

---

## Gestión de materias

El administrador puede:

- Registrar
- Editar
- Eliminar
- Consultar materias

---

## Reportes generales

El administrador puede consultar estadísticas generales del sistema y exportarlas en PDF.

---

# Seguridad

El sistema implementa Spring Security para:

- Autenticación de usuarios
- Control de acceso por roles
- Protección de rutas
- Cifrado de contraseñas mediante BCrypt
- Manejo de sesiones

---

# Base de Datos

Principales tablas:

- usuario
- alumno
- profesor
- materia
- asesoria

Relaciones principales:

- Un alumno pertenece a un usuario
- Un profesor pertenece a un usuario
- Una asesoría pertenece a:
  - un alumno
  - un profesor
  - una materia

---

# Funcionalidades Implementadas

- Autenticación y autorización
- Registro de alumnos
- CRUD de profesores
- CRUD de materias
- Gestión de asesorías
- Cambio de estados
- Reportes semanales
- Exportación PDF
- Interfaz responsive con Bootstrap

---

# Autor

Proyecto desarrollado por Alonso Sagrero.

```
