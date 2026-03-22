CREATE TABLE organization (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL,
    logo_url TEXT
);

CREATE TABLE technology_category (
    id SERIAL PRIMARY KEY,
    name_es VARCHAR(50) NOT NULL,
    name_en VARCHAR(50) NOT NULL,
    color_bg CHAR(7) NOT NULL,
    color_text CHAR(7) NOT NULL,
    color_border CHAR(7) NOT NULL
);

CREATE TABLE technology (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL,
    url TEXT
);

CREATE TABLE technology_technology_category (
    technology_id INTEGER REFERENCES technology(id) NOT NULL,
    category_id INTEGER REFERENCES technology_category(id) NOT NULL,
    PRIMARY KEY (technology_id, category_id)
);

CREATE TABLE experience_category (
    id SERIAL PRIMARY KEY,
    name_es VARCHAR(50) NOT NULL,
    name_en VARCHAR(50) NOT NULL,
    color_bg CHAR(7) NOT NULL,
    color_text CHAR(7) NOT NULL,
    color_border CHAR(7) NOT NULL
);

CREATE TABLE experience_status (
    id SERIAL PRIMARY KEY,
    name_es VARCHAR(50) NOT NULL,
    name_en VARCHAR(50) NOT NULL,
    color_bg CHAR(7) NOT NULL,
    color_text CHAR(7) NOT NULL,
    color_border CHAR(7) NOT NULL
);

CREATE TABLE experience (
    id SERIAL PRIMARY KEY,
    title_es VARCHAR(100) NOT NULL,
    title_en VARCHAR(100) NOT NULL,
    organization_id INTEGER REFERENCES organization(id) NOT NULL,
    status_id INTEGER REFERENCES experience_status(id) NOT NULL,
    category_id INTEGER REFERENCES experience_category(id) NOT NULL,
    description_es TEXT,
    description_en TEXT,
    start_date DATE NOT NULL,
    end_date DATE
);

CREATE TABLE comment (
    id SERIAL PRIMARY KEY,
    user_id VARCHAR(100) NOT NULL,
    experience_id INTEGER REFERENCES experience(id) NULL,
    comment_text TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE experience_technology (
    experience_id INTEGER REFERENCES experience(id) NOT NULL,
    technology_id INTEGER REFERENCES technology(id) NOT NULL,
    PRIMARY KEY (experience_id, technology_id)
);