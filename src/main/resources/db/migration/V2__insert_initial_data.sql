INSERT INTO experience_status (name) VALUES
('COMPLETED'),
('IN_PROGRESS');

INSERT INTO experience_category (name) VALUES
('WORK'),
('EDUCATION'),
('PROJECT');

INSERT INTO organization (name) VALUES
('Imatia'),
('CARDIZA.DEV'),
('Cluster TIC Galicia y Xunta de Galicia'),
('CPR Afundación'),
('IES Campo de San Alberto'),
('UNED');

INSERT INTO technology (name) VALUES
('Dart'),
('Java'),
('HTML'),
('CSS'),
('SCSS'),
('TypeScript'),
('T-SQL'),
('Spring Boot'),
('JPA'),
('MapStruct'),
('PostgreSQL'),
('PostgreSQL: Multi-Tenancy'),
('MySQL'),
('MongoDB'),
('Angular'),
('TailwindCSS'),
('Flutter'),
('Git'),
('Postman'),
('Docker'),
('JUnit'),
('Mockito'),
('Springfox Swagger'),
('Jira'),
('Jenkins'),
('ActiveMq'),
('Github Actions'),
('OpenAPI Swagger'),
('Spring Security'),
('Lombok'),
('AWS'),
('S3'),
('Caffeine Cache'),
('Keycloak'),
('ArgoCD'),
('Grafana'),
('Ontimize Web'),
('Ontimize Boot'),
('Liquibase'),
('Flyway'),
('D3.js'),
('Maven'),
('Gradle'),
('Node.js'),
('npm'),
('Figma'),
('Kotlin'),
('JasperReports'),
('Firebase');

INSERT INTO experience (
    title, organization_id, status_id, category_id,
    description, start_date, end_date
) VALUES (
    'FLUTTER DEVELOPER - PRACTICES',
    (SELECT id FROM organization WHERE name = 'Imatia'),
    (SELECT id FROM experience_status WHERE name = 'COMPLETED'),
    (SELECT id FROM experience_category WHERE name = 'EDUCATION'),
    'Development of a mobile application for a startup that communicates via Bluetooth with a device. REST development started toward the end.',
    '2022-09-01',
    '2022-12-01'
);

INSERT INTO experience (
    title, organization_id, status_id, category_id,
    description, start_date, end_date
) VALUES (
    'FULL STACK DEVELOPER - 1',
    (SELECT id FROM organization WHERE name = 'Imatia'),
    (SELECT id FROM experience_status WHERE name = 'COMPLETED'),
    (SELECT id FROM experience_category WHERE name = 'WORK'),
    'Development of a mobile application for a startup that communicates via Bluetooth with a device. REST development started toward the end.',
    '2023-01-01',
    '2023-05-01'
);

INSERT INTO experience (
    title, organization_id, status_id, category_id,
    description, start_date, end_date
) VALUES (
    'FULL STACK DEVELOPER - 2',
    (SELECT id FROM organization WHERE name = 'Imatia'),
    (SELECT id FROM experience_status WHERE name = 'COMPLETED'),
    (SELECT id FROM experience_category WHERE name = 'WORK'),
    'Full stack development for a logistics sector project with multiple carrier integrations.',
    '2023-05-01',
    '2025-08-01'
);


INSERT INTO experience (
    title, organization_id, status_id, category_id,
    description, start_date, end_date
) VALUES (
    'FULL STACK DEVELOPER - 3',
    (SELECT id FROM organization WHERE name = 'Imatia'),
    (SELECT id FROM experience_status WHERE name = 'COMPLETED'),
    (SELECT id FROM experience_category WHERE name = 'WORK'),
    'Full stack development for an internal company project for employee expense management.',
    '2025-08-01',
    '2026-02-01'
);

INSERT INTO experience (
    title, organization_id, status_id, category_id,
    description, start_date, end_date
) VALUES (
    'BOOTCAMP FULL STACK DEVELOPER',
    (SELECT id FROM organization WHERE name = 'Cluster TIC Galicia y Xunta de Galicia'),
    (SELECT id FROM experience_status WHERE name = 'COMPLETED'),
    (SELECT id FROM experience_category WHERE name = 'EDUCATION'),
    'Intensive training in full stack development.',
    '2022-05-01',
    '2022-08-01'
);

INSERT INTO experience (
    title, organization_id, status_id, category_id,
    description, start_date, end_date
) VALUES (
    'CROSS-PLATFORM APPLICATION DEVELOPMENT',
    (SELECT id FROM organization WHERE name = 'CPR Afundación'),
    (SELECT id FROM experience_status WHERE name = 'COMPLETED'),
    (SELECT id FROM experience_category WHERE name = 'EDUCATION'),
    'Professional training in software development.',
    '2020-09-01',
    '2022-12-01'
);

INSERT INTO experience (
    title, organization_id, status_id, category_id,
    description, start_date, end_date
) VALUES (
    'SCIENCE BACCALAUREATE',
    (SELECT id FROM organization WHERE name = 'IES Campo de San Alberto'),
    (SELECT id FROM experience_status WHERE name = 'COMPLETED'),
    (SELECT id FROM experience_category WHERE name = 'EDUCATION'),
    NULL,
    '2018-09-01',
    '2020-06-01'
);

INSERT INTO experience (
    title, organization_id, status_id, category_id,
    description, start_date, end_date
) VALUES (
    'COMPUTER ENGINEERING',
    (SELECT id FROM organization WHERE name = 'UNED'),
    (SELECT id FROM experience_status WHERE name = 'COMPLETED'),
    (SELECT id FROM experience_category WHERE name = 'EDUCATION'),
    NULL,
    '2022-01-01',
    '2023-01-01'
);

INSERT INTO experience (
    title, organization_id, status_id, category_id,
    description, start_date, end_date
) VALUES (
    'CARDIZA.DEV',
    (SELECT id FROM organization WHERE name = 'CARDIZA.DEV'),
    (SELECT id FROM experience_status WHERE name = 'IN_PROGRESS'),
    (SELECT id FROM experience_category WHERE name = 'PROJECT'),
    'Research and development of a full stack portfolio application',
    '2026-03-01',
    null
);

INSERT INTO experience_technology (experience_id, technology_id)
SELECT e.id, t.id
FROM experience e, technology t
WHERE e.title = 'FLUTTER DEVELOPER - PRACTICES' AND t.name IN (
    'Dart', 'Flutter', 'Git', 'Keycloak', 'Firebase', 'PostgreSQL: Multi-Tenancy', 'Docker', 'Gradle'
);

INSERT INTO experience_technology (experience_id, technology_id)
SELECT e.id, t.id
FROM experience e, technology t
WHERE e.title = 'FULL STACK DEVELOPER - 1' AND t.name IN (
    'Dart', 'Java', 'Flutter', 'Git', 'Keycloak', 'Firebase', 'PostgreSQL: Multi-Tenancy', 'Docker', 'Spring Boot',
    'Postman', 'Ontimize Boot', 'Gradle', 'Maven'
);

INSERT INTO experience_technology (experience_id, technology_id)
SELECT e.id, t.id
FROM experience e, technology t
WHERE e.title = 'FULL STACK DEVELOPER - 2' AND t.name IN (
    'Java', 'HTML', 'SCSS', 'TypeScript', 'Spring Boot', 'JPA', 'MapStruct', 'PostgreSQL', 'MongoDB', 'Angular', 'Git',
    'Postman', 'Docker', 'JUnit', 'Mockito', 'Springfox Swagger', 'Jira', 'Jenkins', 'ActiveMq', 'OpenAPI Swagger',
    'Spring Security', 'Lombok', 'AWS', 'S3', 'ArgoCD', 'Grafana', 'Ontimize Web', 'Ontimize Boot',
    'D3.js', 'JasperReports', 'Liquibase', 'Maven', 'Node.js', 'npm', 'Figma'
);

INSERT INTO experience_technology (experience_id, technology_id)
SELECT e.id, t.id
FROM experience e, technology t
WHERE e.title = 'FULL STACK DEVELOPER - 3' AND t.name IN (
    'Java', 'HTML', 'CSS', 'TypeScript', 'Spring Boot', 'PostgreSQL', 'Angular', 'Git', 'Postman', 'Docker', 'JUnit',
    'Mockito', 'Jira', 'Lombok', 'AWS', 'S3', 'ArgoCD', 'Grafana', 'Ontimize Web', 'Ontimize Boot', 'JasperReports',
    'Flyway', 'Maven', 'Node.js', 'npm', 'Figma'
);

INSERT INTO experience_technology (experience_id, technology_id)
SELECT e.id, t.id
FROM experience e, technology t
WHERE e.title = 'BOOTCAMP FULL STACK DEVELOPER' AND t.name IN (
    'Java', 'HTML', 'SCSS', 'TypeScript', 'Spring Boot', 'MySQL', 'Liquibase', 'Git', 'Jira', 'Ontimize Web',
    'Ontimize Boot', 'Angular', 'Maven', 'Node.js', 'npm'
);

INSERT INTO experience_technology (experience_id, technology_id)
SELECT e.id, t.id
FROM experience e, technology t
WHERE e.title = 'CROSS-PLATFORM APPLICATION DEVELOPMENT' AND t.name IN (
    'Java', 'HTML', 'CSS', 'T-SQL', 'Git', 'Maven', 'Kotlin'
);

INSERT INTO experience_technology (experience_id, technology_id)
SELECT e.id, t.id
FROM experience e, technology t
WHERE e.title = 'CARDIZA.DEV' AND t.name IN (
    'Java', 'HTML', 'TypeScript', 'Spring Boot', 'JPA', 'MapStruct', 'PostgreSQL', 'Angular', 'TailwindCSS', 'Git',
    'Docker', 'JUnit', 'Mockito', 'Github Actions', 'OpenAPI Swagger', 'Lombok', 'Caffeine Cache', 'Grafana', 'Flyway',
    'Maven', 'Node.js', 'npm', 'Firebase'
);