CREATE TABLE sigecan.application (
	id BIGINT auto_increment NOT NULL,
	date_application DATETIME NOT NULL,
	applicant_id BIGINT null,
	job_id BIGINT not null,
	state smallint default 1 not null,
	date_create DATETIME NOT NULL,
	user_create BIGINT NOT NULL,
	date_updt DATETIME NULL,
	user_updt BIGINT NULL,
	CONSTRAINT application_bint_id_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;