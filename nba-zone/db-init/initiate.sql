CREATE TABLE player_data(
	id INT PRIMARY KEY,
	name VARCHAR, 
	team_abb VARCHAR,
	age NUMERIC,
	height NUMERIC,
	weight NUMERIC,
	college VARCHAR,
	country VARCHAR,
	draft_year VARCHAR,
	draft_round VARCHAR,
	draft_number VARCHAR,
	gp INT,
	pts NUMERIC,
	reb NUMERIC,
	ast NUMERIC,
	net_rating NUMERIC,
	oreb NUMERIC,
	dreb NUMERIC,
	usg NUMERIC,
	ts NUMERIC,
	ast_p NUMERIC,
	season VARCHAR
);

\copy player_data(id,name, team_abb, age,height,weight,college,country,draft_year,draft_round,draft_number,gp,pts,reb,ast,net_rating,oreb,dreb,usg,ts,ast_p,season) FROM '/docker-entrypoint-initdb.d/all_seasons.csv' WITH (FORMAT CSV, HEADER, DELIMITER ',');

ALTER TABLE player_data
	DROP COLUMN draft_round,
	DROP COLUMN net_rating,
	DROP COLUMN oreb,
	DROP COLUMN dreb,
	DROP COLUMN usg,
	DROP COLUMN ts,
	DROP COLUMN ast_p;
	
GRANT ALL PRIVILEGES ON DATABASE "nba_data" TO postgres;

SELECT * FROM player_data;