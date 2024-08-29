CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE tb_coupons (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    code varchar(50) NOT NULL,
    discount integer NOT NULL,
    valid TIMESTAMP NOT NULL,
    event_id UUID,
    FOREIGN KEY (event_id) REFERENCES tb_events(id) ON DELETE CASCADE
);