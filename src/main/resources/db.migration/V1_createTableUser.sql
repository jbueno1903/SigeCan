CREATE TABLE sigecan.`user` (
	id BIGINT auto_increment NOT NULL,
	user_name varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	password varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	session_id varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
	state BIGINT NOT NULL,
	CONSTRAINT user_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;