CREATE TABLE sigecan.applicant (
	id BIGINT auto_increment NOT NULL,
	first_name VARCHAR(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	last_name varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	email varchar(200) NOT NULL,
	phone_number varchar(20) not null,
	profile_url1 varchar(300) NOT NULL,
	profile_url2 varchar(300) NULL,
	summary varchar(500) not null,
	gender VARCHAR(1) not null,
	salary_expected DECIMAL(10,2) not null,
	state smallint default 1 not null,
	date_create DATETIME NOT NULL,
	user_create BIGINT NOT NULL,
	date_updt DATETIME NULL,
	user_updt BIGINT NULL,
	CONSTRAINT applicant_bint_id_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;