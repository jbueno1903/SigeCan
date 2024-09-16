CREATE TABLE sigecan.application_status_evo (
	id BIGINT auto_increment NOT NULL,
	date_registered DATETIME NOT NULL,
	application_status_id BIGINT not null,
	application_id BIGINT not null,
	CONSTRAINT app_stat_evo_bint_id_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;