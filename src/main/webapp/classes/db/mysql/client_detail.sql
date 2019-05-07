CREATE TABLE IF NOT EXISTS client_details (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,

	client_description VARCHAR(512),
	reuse_refresh_tokens BOOLEAN DEFAULT true NOT NULL,
	dynamically_registered BOOLEAN DEFAULT false NOT NULL,
	allow_introspection BOOLEAN DEFAULT false NOT NULL,
	id_token_validity_seconds BIGINT DEFAULT 600 NOT NULL,
	device_code_validity_seconds BIGINT,
	
	client_id VARCHAR(256),
	client_secret VARCHAR(1024),
	access_token_validity_seconds BIGINT,
	refresh_token_validity_seconds BIGINT,
	
	application_type VARCHAR(128),
	client_name VARCHAR(128),
	token_endpoint_auth_method VARCHAR(256),
	subject_type VARCHAR(256),
	
	logo_uri VARCHAR(1024),
	policy_uri VARCHAR(1024),
	client_uri VARCHAR(1024),
	tos_uri VARCHAR(1024),

	jwks_uri VARCHAR(1024),
	jwks VARCHAR(1024),
	sector_identifier_uri VARCHAR(1024),
	
	request_object_signing_alg VARCHAR(256),
	
	user_info_signed_response_alg VARCHAR(256),
	user_info_encrypted_response_alg VARCHAR(256),
	user_info_encrypted_response_enc VARCHAR(256),
	
	id_token_signed_response_alg VARCHAR(256),
	id_token_encrypted_response_alg VARCHAR(256),
	id_token_encrypted_response_enc VARCHAR(256),
	
	token_endpoint_auth_signing_alg VARCHAR(256),
	
	default_max_age BIGINT,
	require_auth_time BOOLEAN,
	created_at TIMESTAMP NULL,
	initiate_login_uri VARCHAR(1024),
	clear_access_tokens_on_refresh BOOLEAN DEFAULT true NOT NULL,
	
	software_statement VARCHAR(1024),
	software_id VARCHAR(1024),
	software_version VARCHAR(1024),
	
	code_challenge_method VARCHAR(256),
	
	UNIQUE (client_id)
);

CREATE INDEX cd_ci_idx ON client_details(client_id);