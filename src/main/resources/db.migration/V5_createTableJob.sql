CREATE TABLE sigecan.job (
	id BIGINT auto_increment NOT NULL,
	code VARCHAR(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	name VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	description VARCHAR(500) CHARACTER SET utf8 COLLATE utf8_general_ci not NULL,
	recruiter_id BIGINT not null,
	requirements VARCHAR(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
	knowledges VARCHAR(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
	seniority VARCHAR(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
	date_published DATETIME NOT NULL,
	start_applications DATETIME NOT NULL,
	end_applications DATETIME NOT NULL,
	start_job DATETIME NOT NULL,
	number_vacancies smallint not null,
	job_position VARCHAR(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	job_category VARCHAR(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	organization_id BIGINT NOT NULL,
	period VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	job_status_id BIGINT not null,
	state smallint default 1 not null,
	date_create DATETIME NOT NULL,
	user_create BIGINT NOT NULL,
	date_updt DATETIME NULL,
	user_updt BIGINT NULL,
	CONSTRAINT job_bint_id_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;