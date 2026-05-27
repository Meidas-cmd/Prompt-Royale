INSERT INTO raza (id, nombre, descripcion) VALUES
(1, 'Labrador Retriever', 'Raza sociable, paciente y muy usada en terapia asistida.'),
(2, 'Golden Retriever', 'Raza tranquila, afectuosa y con gran capacidad de aprendizaje.'),
(3, 'Border Collie', 'Raza inteligente, activa y excelente para tareas de acompanamiento.');

INSERT INTO perro (id, nombre, edad, tamano, descripcion, foto, disponible, raza_id) VALUES
(1, 'Luna', 4, 'Mediano', 'Perra tranquila y carinosa, ideal para visitas a centros educativos.', 'https://images.unsplash.com/photo-1552053831-71594a27632d', true, 1),
(2, 'Max', 6, 'Grande', 'Perro paciente y sociable con experiencia en acompanamiento emocional.', 'https://images.unsplash.com/photo-1558788353-f76d92427f16', true, 2),
(3, 'Nala', 3, 'Mediano', 'Perra activa, obediente y preparada para dinamicas grupales.', 'https://images.unsplash.com/photo-1548199973-03cce0bbc87b', false, 3),
(4, 'Toby', 5, 'Grande', 'Perro calmado y equilibrado para terapias individuales.', 'https://images.unsplash.com/photo-1518717758536-85ae29035b6d', true, 1);

ALTER TABLE raza ALTER COLUMN id RESTART WITH 4;
ALTER TABLE perro ALTER COLUMN id RESTART WITH 5;
