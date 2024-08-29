CREATE TABLE tb_adresses(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    uf varchar(2) NOT NULL,
    city varchar(50) NOT NULL,
    event_id UUID,
    FOREIGN KEY (event_id) REFERENCES tb_events(id) ON DELETE CASCADE
);