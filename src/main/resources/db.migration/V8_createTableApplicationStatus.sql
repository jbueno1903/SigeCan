CREATE TABLE sigecan.application_status (
	id BIGINT NOT NULL,
	description VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	state smallint default 1 not null,
	date_create DATETIME NOT NULL,
	user_create BIGINT NOT NULL,
	date_updt DATETIME NULL,
	user_updt BIGINT NULL,
	CONSTRAINT app_status_bint_id_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;