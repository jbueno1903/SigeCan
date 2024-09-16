CREATE TABLE sigecan.recruiter (
	id BIGINT auto_increment NOT NULL,
	first_name VARCHAR(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	last_name varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	email varchar(200) NOT NULL,
	state smallint default 1 not null,
	date_create DATETIME NOT NULL,
	user_create BIGINT NOT NULL,
	date_updt DATETIME NULL,
	user_updt BIGINT NULL,
	CONSTRAINT recruiter_bint_id_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;