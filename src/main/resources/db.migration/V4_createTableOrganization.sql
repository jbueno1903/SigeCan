CREATE TABLE sigecan.organization (
	id BIGINT auto_increment NOT NULL,
	code VARCHAR(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	name varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	description VARCHAR(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	document_number varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	name_contact1 varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	email1 varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	phone_contact1 VARCHAR(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	name_contact2 varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
	email2 varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
	phone_contact2 VARCHAR(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
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