CREATE TABLE sch_supermarket.employees (
	id bigserial PRIMARY KEY,
	name VARCHAR ( 50 ) NOT NULL, -- Varchar -> String
	cpf VARCHAR (14) NOT NULL,
	birth DATE NOT NULL);