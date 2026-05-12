-- =========================
-- USUARIOS
-- =========================

INSERT INTO usuario (nombre, email, password, rol) VALUES
                                                       ('Administrador General', 'admin@aau.mx', '$2a$12$VNsQBzlR3aat7nc21sSxPOHS7uosrQpNaTOOWXCF9zpnFdVYqjT9G', 'ADMIN'),

                                                       ('Carlos Ramírez', 'carlos@aau.mx', '$2a$12$VNsQBzlR3aat7nc21sSxPOHS7uosrQpNaTOOWXCF9zpnFdVYqjT9G', 'PROFESOR'),
                                                       ('Laura Méndez', 'laura@aau.mx', '$2a$12$VNsQBzlR3aat7nc21sSxPOHS7uosrQpNaTOOWXCF9zpnFdVYqjT9G', 'PROFESOR'),
                                                       ('Miguel Sánchez', 'miguel@aau.mx', '$2a$12$VNsQBzlR3aat7nc21sSxPOHS7uosrQpNaTOOWXCF9zpnFdVYqjT9G', 'PROFESOR'),
                                                       ('Patricia Gómez', 'patricia@aau.mx', '$2a$12$VNsQBzlR3aat7nc21sSxPOHS7uosrQpNaTOOWXCF9zpnFdVYqjT9G', 'PROFESOR'),

                                                       ('Ana Torres', 'ana@aau.mx', '$2a$12$VNsQBzlR3aat7nc21sSxPOHS7uosrQpNaTOOWXCF9zpnFdVYqjT9G', 'ALUMNO'),
                                                       ('Luis Hernández', 'luis@aau.mx', '$2a$12$VNsQBzlR3aat7nc21sSxPOHS7uosrQpNaTOOWXCF9zpnFdVYqjT9G', 'ALUMNO'),
                                                       ('María López', 'maria@aau.mx', '$2a$12$VNsQBzlR3aat7nc21sSxPOHS7uosrQpNaTOOWXCF9zpnFdVYqjT9G', 'ALUMNO'),
                                                       ('José Martínez', 'jose@aau.mx', '$2a$12$VNsQBzlR3aat7nc21sSxPOHS7uosrQpNaTOOWXCF9zpnFdVYqjT9G', 'ALUMNO'),
                                                       ('Fernanda Ruiz', 'fernanda@aau.mx', '$2a$12$VNsQBzlR3aat7nc21sSxPOHS7uosrQpNaTOOWXCF9zpnFdVYqjT9G', 'ALUMNO'),
                                                       ('Ricardo Flores', 'ricardo@aau.mx', '$2a$12$VNsQBzlR3aat7nc21sSxPOHS7uosrQpNaTOOWXCF9zpnFdVYqjT9G', 'ALUMNO');

-- =========================
-- ALUMNOS
-- =========================

INSERT INTO alumno (id, matricula, carrera, semestre) VALUES
                                                          (6, 'A001', 'Ingeniería en Computación', 5),
                                                          (7, 'A002', 'Ingeniería en Sistemas', 3),
                                                          (8, 'A003', 'Ciencias de la Computación', 7),
                                                          (9, 'A004', 'Ingeniería en Software', 2),
                                                          (10, 'A005', 'Tecnologías de la Información', 6),
                                                          (11, 'A006', 'Ingeniería en Computación', 8);

-- =========================
-- PROFESORES
-- =========================

INSERT INTO profesor (nombre, numero_empleado, experiencia, especialidad, usuario_id) VALUES
                                                                                          ('Carlos Ramírez', 'EMP001', '10 años en desarrollo backend', 'COMPUTACION', 2),

                                                                                          ('Laura Méndez', 'EMP002', '8 años en bases de datos', 'BASES_DE_DATOS', 3),

                                                                                          ('Miguel Sánchez', 'EMP003', '12 años en inteligencia artificial', 'INTELIGENCIA_ARTIFICIAL', 4),

                                                                                          ('Patricia Gómez', 'EMP004', '6 años en estructuras de datos', 'PROGRAMACION', 5);

-- =========================
-- MATERIAS
-- =========================

INSERT INTO materia (nombre, descripcion) VALUES
                                              ('Programación Java', 'Curso avanzado de Java con Spring Boot'),

                                              ('Bases de Datos', 'Modelado relacional y consultas SQL'),

                                              ('Estructuras de Datos', 'Listas, pilas, colas y árboles'),

                                              ('Inteligencia Artificial', 'Introducción a Machine Learning'),

                                              ('Desarrollo Web', 'Aplicaciones web con Spring y Thymeleaf'),

                                              ('Algoritmos', 'Resolución de problemas y optimización');

-- =========================
-- RELACION PROFESOR-MATERIA
-- =========================

INSERT INTO profesor_materia (profesor_id, materia_id) VALUES
                                                           (1, 1),
                                                           (1, 5),
                                                           (2, 2),
                                                           (3, 4),
                                                           (4, 3),
                                                           (4, 6);

-- =========================
-- HORARIOS
-- =========================

INSERT INTO horario_disponible (profesor_id, dia_semana, hora_inicio, hora_fin) VALUES

                                                                                    (1, 'LUNES', '09:00:00', '12:00:00'),
                                                                                    (1, 'MIERCOLES', '10:00:00', '13:00:00'),

                                                                                    (2, 'MARTES', '08:00:00', '11:00:00'),
                                                                                    (2, 'JUEVES', '14:00:00', '17:00:00'),

                                                                                    (3, 'LUNES', '15:00:00', '18:00:00'),
                                                                                    (3, 'VIERNES', '09:00:00', '12:00:00'),

                                                                                    (4, 'MARTES', '10:00:00', '13:00:00'),
                                                                                    (4, 'JUEVES', '09:00:00', '12:00:00');

-- =========================
-- ASESORIAS
-- =========================

INSERT INTO asesoria
(alumno_id, profesor_id, materia_id, fecha, hora, estado, notas)
VALUES

    (6, 1, 1, '2026-05-04', '10:00:00', 'confirmada',
     'Revisión de proyecto Spring Boot'),

    (7, 2, 2, '2026-05-05', '09:00:00', 'pendiente',
     'Dudas sobre normalización y JOINs'),

    (8, 4, 3, '2026-05-06', '11:30:00', 'completada',
     'Repaso para examen parcial'),

    (9, 3, 4, '2026-05-06', '16:00:00', 'confirmada',
     'Introducción a redes neuronales'),

    (10, 1, 5, '2026-05-07', '12:00:00', 'cancelada',
     'Reprogramar sesión'),

    (11, 4, 6, '2026-05-07', '10:00:00', 'pendiente',
     'Resolver ejercicios de algoritmos'),

    (6, 2, 2, '2026-05-08', '15:00:00', 'completada',
     'Consultas avanzadas SQL'),

    (7, 3, 4, '2026-05-08', '17:00:00', 'confirmada',
     'Machine Learning supervisado'),

    (8, 1, 1, '2026-05-09', '09:00:00', 'pendiente',
     'Errores con JPA y Hibernate'),

    (9, 4, 6, '2026-05-09', '11:00:00', 'confirmada',
     'Complejidad temporal de algoritmos'),

    (10, 3, 4, '2026-05-10', '10:30:00', 'cancelada',
     'Dudas sobre clasificación'),

    (11, 1, 5, '2026-05-10', '13:00:00', 'completada',
     'Configuración de Spring Security');

-- =========================
-- NOTIFICACIONES
-- =========================

INSERT INTO notificacion (usuario_id, asunto, mensaje) VALUES

                                                           (6, 'Asesoría confirmada',
                                                            'Tu asesoría fue confirmada con el profesor Carlos Ramírez'),

                                                           (7, 'Recordatorio',
                                                            'No olvides tu asesoría mañana'),

                                                           (2, 'Nueva asesoría',
                                                            'Tienes una nueva solicitud de asesoría'),

                                                           (3, 'Asesoría cancelada',
                                                            'Una asesoría fue cancelada por el alumno'),

                                                           (10, 'Asesoría completada',
                                                            'Tu asesoría fue marcada como completada');

-- =========================
-- REPORTES
-- =========================

INSERT INTO reporte_semanal
(total_asesorias, archivo_pdf, archivo_excel, generado_por)
VALUES

    (12, 'reporte_semana_19.pdf',
     'reporte_semana_19.xlsx', 1),

    (8, 'reporte_semana_20.pdf',
     'reporte_semana_20.xlsx', 1);