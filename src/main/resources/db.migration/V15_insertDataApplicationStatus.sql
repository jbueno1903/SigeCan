INSERT INTO sigecan.application_status
(id, description, state, date_create, user_create, date_updt, user_updt)
values
(1, 'Recibida', 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(2, 'En revision', 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(3, 'Contactando', 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(4, 'En entrevista', 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(5, 'Enviado al cliente', 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(6, 'Aprobado', 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(7, 'Contratado', 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(8, 'Rechazado', 1, CURRENT_TIMESTAMP, 1, NULL, NULL);