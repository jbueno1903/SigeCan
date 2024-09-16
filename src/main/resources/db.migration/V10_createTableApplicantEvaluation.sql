CREATE TABLE sigecan.applicant_evaluation (
	id BIGINT NOT NULL,
	results VARCHAR(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	observations VARCHAR(1000) CHARACTER SET utf8 COLLATE utf8_general_ci null,
	phase VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_general_ci not null,
	recruiter_id BIGINT not null,
	application_id BIGINT not null,
	evaluation_date DATETIME not null,
	CONSTRAINT app_evaluation_bint_id_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;