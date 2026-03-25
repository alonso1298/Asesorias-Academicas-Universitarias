INSERT INTO usuario (nombre, email, password, rol) VALUES
('Administrador General', 'admin@aau.mx', '1234', 'ADMIN'),
('Carlos Ramírez', 'carlos@aau.mx', '1234', 'PROFESOR'),
('Laura Méndez', 'laura@aau.mx', '1234', 'PROFESOR'),
('Ana Torres', 'ana@aau.mx', '1234', 'ALUMNO'),
('Luis Hernández', 'luis@aau.mx', '1234', 'ALUMNO'),
('María López', 'maria@aau.mx', '1234', 'ALUMNO');

INSERT INTO alumno (id, matricula, carrera, semestre) VALUES
(4, 'A001', 'Ingeniería en Computación', 5),
(5, 'A002', 'Ingeniería en Sistemas', 3),
(6, 'A003', 'Ciencias de la Computación', 7);

INSERT INTO profesor (nombre, numero_empleado, experiencia, especialidad, usuario_id) VALUES
('Carlos Ramírez', 'EMP001', '10 años en desarrollo backend', 'COMPUTACION', 2),
('Laura Méndez', 'EMP002', '8 años en bases de datos', 'BASES_DE_DATOS', 3);

INSERT INTO materia (nombre, descripcion) VALUES
('Programación Java', 'Curso avanzado de Java con Spring Boot'),
('Bases de Datos', 'Modelado relacional y consultas SQL'),
('Estructuras de Datos', 'Listas, pilas, colas y árboles'),
('Inteligencia Artificial', 'Introducción a Machine Learning');

INSERT INTO profesor_materia (profesor_id, materia_id) VALUES
(1, 1),
(1, 3),
(2, 2),
(2, 4);

INSERT INTO horario_disponible (profesor_id, dia_semana, hora_inicio, hora_fin) VALUES
(1, 'LUNES', '09:00:00', '12:00:00'),
(1, 'MIERCOLES', '10:00:00', '13:00:00'),
(2, 'MARTES', '08:00:00', '11:00:00'),
(2, 'JUEVES', '14:00:00', '17:00:00');

INSERT INTO asesoria (alumno_id, profesor_id, materia_id, fecha, hora, estado, notas) VALUES
(4, 1, 1, '2026-03-10', '10:00:00', 'confirmada', 'Revisión de proyecto final'),
(5, 2, 2, '2026-03-11', '09:00:00', 'pendiente', 'Dudas sobre normalización'),
(6, 1, 3, '2026-03-12', '11:30:00', 'completada', 'Repaso para examen parcial'),
(4, 2, 4, '2026-03-15', '15:00:00', 'cancelada', 'Reprogramar sesión');

INSERT INTO notificacion (usuario_id, asunto, mensaje) VALUES
(4, 'Asesoría confirmada', 'Tu asesoría fue confirmada con el profesor Carlos'),
(5, 'Recordatorio', 'No olvides tu asesoría mañana'),
(2, 'Nueva asesoría', 'Tienes una nueva solicitud de asesoría');

INSERT INTO reporte_semanal (total_asesorias, archivo_pdf, archivo_excel, generado_por) VALUES
(4, 'reporte_semana1.pdf', 'reporte_semana1.xlsx', 1);