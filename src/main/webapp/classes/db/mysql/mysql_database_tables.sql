--
-- Tables for SSO OAuth Server functionality , My SQL 
--


CREATE TABLE IF NOT EXISTS access_token(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	token_value 		VARCHAR(2048),
	expiration 			TIMESTAMP NULL,
	token_type 			VARCHAR (256),
	refresh_token_id 	BIGINT,
	client_id 			BIGINT,
	auth_holder_id 		BIGINT,
	approved_site_id 	BIGINT
);


CREATE TABLE IF NOT EXISTS access_token_permissions(
	access_token_id 		BIGINT NOT NULL,
	permission_id 			BIGINT NOT NULL

);

CREATE TABLE IF NOT EXISTS address(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	formatted 				VARCHAR(256),
	street_address 			VARCHAR (256),
	locality 				VARCHAR(256),
	
);

CREATE TABLE IF NOT EXISTS approved_site(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	user_id 				 VARCHAR(256),
	client_id 				 VARCHAR(256),
	creation_date			 TIMESTAMP NULL,
	access_date				 TIMESTAMP NULL,
	timeout_date			 TIMESTAMP NULL,
	whitelisted_site_id	 	 BIGINT
);

CREATE TABLE IF NOT EXISTS approved_site_scope (
	owner_id BIGINT,
	scope VARCHAR(256)
);



CREATE TABLE IF NOT EXISTS user_info(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	sub 					 VARCHAR(256),
	preferred_username 		 VARCHAR(256),
	name 					 VARCHAR(256),
	given_name 				 VARCHAR(256),
	family_name				 VARCHAR(256),
	middle_name				 VARCHAR(256),
	nickname				 VARCHAR(256),
	profile					 VARCHAR(256),
	picture					 VARCHAR(256),
	website					 VARCHAR(256),
	email 					 VARCHAR(256),
	email_verified			 BOOLEAN,
	gender				     VARCHAR(256),
	zone_info				 VARCHAR(256),
	locale 					 VARCHAR(256),
	phone_number			 VARCHAR(256),
	phone_number_verifed	 BOOLEAN,
	address_id				 VARCHAR(256),
	updated_time			 VARCHAR(256),
	birthdate				 VARCHAR(256),
	src						 VARCHAR(2048)
);




