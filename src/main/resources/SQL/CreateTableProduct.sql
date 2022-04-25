CREATE TABLE sch_supermarket.products (
	id bigserial PRIMARY KEY,
	name VARCHAR ( 50 ) NOT NULL, -- Varchar -> String
	quantity NUMERIC ( 10,3 ) NOT NULL, -- Numeric -> Formato de numero com virgula, recebe o numero TOTAL de casas e de decimais.
	unity VARCHAR ( 50 ) NOT NULL,
	purchase_price NUMERIC (7,2) NOT NULL,
	sell_price NUMERIC (7,2) NOT NULL

);