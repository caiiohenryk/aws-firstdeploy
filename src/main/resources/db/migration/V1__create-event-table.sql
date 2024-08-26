CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE tb_events (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    title varchar(120) NOT NULL,
    description varchar(250),
    imgUrl varchar(300) NOT NULL,
    date TIMESTAMP NOT NULL,
    remote boolean NOT NULL
);