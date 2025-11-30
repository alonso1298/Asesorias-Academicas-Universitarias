--  CREACIÓN DE BASE DE DATOS
CREATE DATABASE IF NOT EXISTS aau_db;
USE aau_db;

-- ==========================
--  TABLA: rol
-- ==========================
CREATE TABLE rol (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

-- ==========================
--  TABLA: usuario
-- ==========================
CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(120) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    rol_id BIGINT NOT NULL,
    FOREIGN KEY (rol_id) REFERENCES rol(id)
);

-- ==========================
--  TABLA: alumno (1:1 usuario)
-- ==========================
CREATE TABLE alumno (
    id BIGINT PRIMARY KEY,
    matricula VARCHAR(50) NOT NULL UNIQUE,
    carrera VARCHAR(100) NOT NULL,
    semestre INT NOT NULL CHECK (semestre BETWEEN 1 AND 12),
    FOREIGN KEY (id) REFERENCES usuario(id)
);

-- ==========================
--  TABLA: profesor (1:1 usuario)
-- ==========================
CREATE TABLE profesor (
    id BIGINT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    numero_empleado VARCHAR(100),
    experiencia TEXT,
    FOREIGN KEY (id) REFERENCES usuario(id)
);

-- ==========================
--  TABLA: materia
-- ==========================
CREATE TABLE materia (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    descripcion TEXT
);

-- ==========================
--  TABLA: profesor_materia (N:N)
-- ==========================
CREATE TABLE profesor_materia (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    profesor_id BIGINT NOT NULL,
    materia_id BIGINT NOT NULL,

    UNIQUE (profesor_id, materia_id),

    FOREIGN KEY (profesor_id) REFERENCES profesor(id),
    FOREIGN KEY (materia_id) REFERENCES materia(id)
);

-- ==========================
--  TABLA: horario_disponible
-- ==========================
CREATE TABLE horario_disponible (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    profesor_id BIGINT NOT NULL,
    dia_semana ENUM('LUNES','MARTES','MIERCOLES','JUEVES','VIERNES','SABADO') NOT NULL,
    hora_inicio TIME NOT NULL,
    hora_fin TIME NOT NULL,

    CHECK (hora_inicio < hora_fin),

    FOREIGN KEY (profesor_id) REFERENCES profesor(id)
);

CREATE INDEX idx_profesor_horario ON horario_disponible(profesor_id);

-- ==========================
--  TABLA: asesoria
-- ==========================
CREATE TABLE asesoria (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    alumno_id BIGINT NOT NULL,
    profesor_id BIGINT NOT NULL,
    materia_id BIGINT NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    estado ENUM('pendiente','confirmada','completada','cancelada') DEFAULT 'pendiente',
    notas TEXT,

    FOREIGN KEY (alumno_id) REFERENCES alumno(id),
    FOREIGN KEY (profesor_id) REFERENCES profesor(id),
    FOREIGN KEY (materia_id) REFERENCES materia(id)
);

CREATE INDEX idx_asesoria_fecha ON asesoria(fecha);
CREATE INDEX idx_asesoria_profesor ON asesoria(profesor_id);
CREATE INDEX idx_asesoria_alumno ON asesoria(alumno_id);

-- ==========================
--  TABLA: notificacion
-- ==========================
CREATE TABLE notificacion (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT NOT NULL,
    asunto VARCHAR(200) NOT NULL,
    mensaje TEXT NOT NULL,
    fecha_envio DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

-- ==========================
--  TABLA: reporte_semanal
-- ==========================
CREATE TABLE reporte_semanal (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha_generacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    total_asesorias INT NOT NULL,
    archivo_pdf VARCHAR(255),
    archivo_excel VARCHAR(255),
    generado_por BIGINT NOT NULL,
    FOREIGN KEY (generado_por) REFERENCES usuario(id)
);
