INSERT INTO sigecan.job_status
(id, description, state, date_create, user_create, date_updt, user_updt)
values
(1, 'Abierto', 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(2, 'En construcción', 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(3, 'Publicado', 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(4, 'Recibiendo CVs', 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(5, 'En entrevistas', 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(6, 'En contratación', 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(7, 'En acompañamiento', 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(8, 'Finalizado', 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(9, 'Declarado Desierto', 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(10, 'Cancelado por Negocio', 1, CURRENT_TIMESTAMP, 1, NULL, NULL),
(11, 'Cancelado por Cliente', 1, CURRENT_TIMESTAMP, 1, NULL, NULL);