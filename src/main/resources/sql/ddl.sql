CREATE table "user"(
	id 			int ,
	full_name	varchar(100) ,
	email 		varchar(100),
	nickname 	varchar(50),
	password 	varchar(255),
	created_at 	timestamp,
	constraint user_pk primary key (id)
);

CREATE table submission(
	user_id 		int ,
	challenge_id 	int ,
	score 			float,
	created_at 		timestamp,
	constraint submission_pk primary key (user_id, challenge_id),
	constraint user_fk foreign key (user_id) references "user"(id),
	constraint challenge_fk foreign key (challenge_id) references challenge(id)
);


CREATE table candidate(
	user_id 			int ,
	acceleration_id 	int ,
	company_id 			int ,
	status 				float,
	created_at 			timestamp,
	constraint 	candidate_pk primary key (user_id, acceleration_id, company_id),
	constraint 	user_fk foreign key (user_id) references "user"(id),
	constraint	acceleration_fk foreign key (acceleration_id) references acceleration(id),
	constraint	company_fk foreign key (company_id) references company(id)
);

CREATE table company(
	id 			int,
	name 		varchar(100),
	slug 		varchar(50),
	created_at 	timestamp,
	constraint 	company_pk primary key (id)
);


CREATE table acceleration(
	id 				int,
	name 			varchar(100),
	slug 			varchar(50),
	challenge_id 	int,
	created_at 		timestamp,
	constraint 	acceleration_pk primary key (id),
	constraint 	challenge_fk foreign key (challenge_id) references challenge(id)
);


CREATE table challenge(
	id 			int,
	name 		varchar(100),
	slug 		varchar(50),
	created_at 	timestamp,
	constraint 	challenge_pk primary key (id)
);