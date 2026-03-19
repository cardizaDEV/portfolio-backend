DELETE FROM experience_technology;
DELETE FROM technology_technology_category;
DELETE FROM experience;
DELETE FROM technology;
DELETE FROM technology_category;
DELETE FROM experience_category;
DELETE FROM experience_status;
DELETE FROM organization;

INSERT INTO experience_status (name, color_bg, color_text, color_border) VALUES
('COMPLETED', '#EAF3DE', '#27500A', '#C0DD97'),
('IN_PROGRESS', '#FEF0DC', '#7A3E00', '#F9C47A');

INSERT INTO experience_category (name, color_bg, color_text, color_border) VALUES
('WORK', '#FCEBEB', '#791F1F', '#F7C1C1'),
('EDUCATION', '#E6F1FB', '#185FA5', '#B5D4F4'),
('PROJECT', '#EAF3DE', '#27500A', '#C0DD97');

INSERT INTO organization (name) VALUES
('Imatia'),
('CARDIZA.DEV'),
('Cluster TIC Galicia y Xunta de Galicia'),
('CPR Afundación'),
('IES Campo de San Alberto'),
('UNED');

INSERT INTO technology_category (name, color_bg, color_text, color_border) VALUES
('Backend', '#FEF0DC', '#7A3E00', '#F9C47A'),
('Frontend', '#E6F1FB', '#185FA5', '#B5D4F4'),
('Database', '#EAF3DE', '#27500A', '#C0DD97'),
('Infrastructure', '#EEEDFE', '#3C3489', '#CECBF6'),
('Testing', '#FCEBEB', '#791F1F', '#F7C1C1'),
('Utilities', '#F1EFE8', '#444441', '#D3D1C7'),
('Tools', '#FBEAF0', '#4B1528', '#F4C0D1'),
('Styles', '#E1F5EE', '#085041', '#9FE1CB');

INSERT INTO technology (name, url) VALUES
('ActiveMQ', 'https://activemq.apache.org'),
('Angular', 'https://angular.dev'),
('ArgoCD', 'https://argoproj.github.io/cd'),
('AWS', 'https://aws.amazon.com'),
('Caffeine Cache', 'https://github.com/ben-manes/caffeine'),
('CSS', 'https://developer.mozilla.org/en-US/docs/Web/CSS'),
('D3.js', 'https://d3js.org'),
('Dart', 'https://dart.dev'),
('Docker', 'https://www.docker.com'),
('PostgreSQL', 'https://www.postgresql.org'),
('Figma', 'https://www.figma.com'),
('Firebase', 'https://firebase.google.com'),
('Flutter', 'https://flutter.dev'),
('Flyway', 'https://flywaydb.org'),
('Git', 'https://git-scm.com'),
('GitHub Actions', 'https://github.com/features/actions'),
('Gradle', 'https://gradle.org'),
('Grafana', 'https://grafana.com'),
('Ontimize Web', 'https://ontimizeweb.github.io/docs'),
('HTML', 'https://developer.mozilla.org/en-US/docs/Web/HTML'),
('JasperReports', 'https://www.jaspersoft.com'),
('Java', 'https://www.java.com'),
('Jenkins', 'https://www.jenkins.io'),
('Jira', 'https://www.atlassian.com/software/jira'),
('JPA', 'https://jakarta.ee/specifications/persistence'),
('JUnit', 'https://junit.org'),
('Keycloak', 'https://www.keycloak.org'),
('Kotlin', 'https://kotlinlang.org'),
('Liquibase', 'https://www.liquibase.com'),
('Lombok', 'https://projectlombok.org'),
('MapStruct', 'https://mapstruct.org'),
('Maven', 'https://maven.apache.org'),
('Mockito', 'https://site.mockito.org'),
('MongoDB', 'https://www.mongodb.com'),
('MySQL', 'https://www.mysql.com'),
('Node.js', 'https://nodejs.org'),
('npm', 'https://www.npmjs.com'),
('Ontimize Boot', 'https://ontimize.github.io/ontimize-boot'),
('OpenAPI (Swagger)', 'https://swagger.io'),
('PostgreSQL: Multi-Tenancy', 'https://www.postgresql.org'),
('Postman', 'https://www.postman.com'),
('S3', 'https://aws.amazon.com/s3'),
('SCSS', 'https://sass-lang.com'),
('Spring Boot', 'https://spring.io/projects/spring-boot'),
('Spring Security', 'https://spring.io/projects/spring-security'),
('Springfox (Swagger)', 'https://swagger.io'),
('T-SQL', 'https://learn.microsoft.com/en-us/sql/t-sql'),
('TailwindCSS', 'https://tailwindcss.com'),
('TypeScript', 'https://www.typescriptlang.org');

INSERT INTO technology_technology_category (technology_id, category_id)
SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'ActiveMQ' AND c.name = 'Backend'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'Angular' AND c.name = 'Frontend'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'ArgoCD' AND c.name = 'Infrastructure'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'AWS' AND c.name = 'Infrastructure'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'Caffeine Cache' AND c.name = 'Backend'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'CSS' AND c.name = 'Frontend'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'CSS' AND c.name = 'Styles'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'D3.js' AND c.name = 'Frontend'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'Dart' AND c.name = 'Frontend'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'Docker' AND c.name = 'Infrastructure'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'PostgreSQL' AND c.name = 'Database'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'Figma' AND c.name = 'Tools'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'Figma' AND c.name = 'Styles'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'Firebase' AND c.name = 'Database'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'Flutter' AND c.name = 'Frontend'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'Flyway' AND c.name = 'Database'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'Git' AND c.name = 'Tools'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'GitHub Actions' AND c.name = 'Infrastructure'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'Gradle' AND c.name = 'Utilities'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'Grafana' AND c.name = 'Infrastructure'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'HTML' AND c.name = 'Frontend'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'Java' AND c.name = 'Backend'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'JasperReports' AND c.name = 'Backend'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'Jenkins' AND c.name = 'Infrastructure'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'Jira' AND c.name = 'Tools'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'JPA' AND c.name = 'Backend'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'JUnit' AND c.name = 'Testing'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'Keycloak' AND c.name = 'Backend'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'Kotlin' AND c.name = 'Backend'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'Liquibase' AND c.name = 'Database'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'Lombok' AND c.name = 'Backend'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'MapStruct' AND c.name = 'Backend'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'Maven' AND c.name = 'Utilities'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'Mockito' AND c.name = 'Testing'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'MongoDB' AND c.name = 'Database'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'MySQL' AND c.name = 'Database'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'Node.js' AND c.name = 'Backend'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'npm' AND c.name = 'Utilities'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'Ontimize Boot' AND c.name = 'Backend'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'Ontimize Web' AND c.name = 'Frontend'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'OpenAPI (Swagger)' AND c.name = 'Backend'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'PostgreSQL: Multi-Tenancy' AND c.name = 'Database'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'Postman' AND c.name = 'Tools'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'S3' AND c.name = 'Infrastructure'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'SCSS' AND c.name = 'Frontend'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'SCSS' AND c.name = 'Styles'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'Spring Boot' AND c.name = 'Backend'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'Spring Security' AND c.name = 'Backend'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'Springfox (Swagger)' AND c.name = 'Backend'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'T-SQL' AND c.name = 'Database'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'TailwindCSS' AND c.name = 'Frontend'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'TailwindCSS' AND c.name = 'Styles'
UNION ALL SELECT t.id, c.id FROM technology t, technology_category c WHERE t.name = 'TypeScript' AND c.name = 'Frontend';

INSERT INTO experience (title, organization_id, status_id, category_id, description, start_date, end_date) VALUES
('FLUTTER DEVELOPER - PRACTICES',
 (SELECT id FROM organization WHERE name = 'Imatia'),
 (SELECT id FROM experience_status WHERE name = 'COMPLETED'),
 (SELECT id FROM experience_category WHERE name = 'EDUCATION'),
 'Development of a mobile application for a startup that communicates via Bluetooth with a device. REST development started toward the end.',
 '2022-09-01', '2022-12-01');

INSERT INTO experience (title, organization_id, status_id, category_id, description, start_date, end_date) VALUES
('FULL STACK DEVELOPER - 1',
 (SELECT id FROM organization WHERE name = 'Imatia'),
 (SELECT id FROM experience_status WHERE name = 'COMPLETED'),
 (SELECT id FROM experience_category WHERE name = 'WORK'),
 'Development of a mobile application for a startup that communicates via Bluetooth with a device. REST development started toward the end.',
 '2023-01-01', '2023-05-01');

INSERT INTO experience (title, organization_id, status_id, category_id, description, start_date, end_date) VALUES
('FULL STACK DEVELOPER - 2',
 (SELECT id FROM organization WHERE name = 'Imatia'),
 (SELECT id FROM experience_status WHERE name = 'COMPLETED'),
 (SELECT id FROM experience_category WHERE name = 'WORK'),
 'Full stack development for a logistics sector project with multiple carrier integrations.',
 '2023-05-01', '2025-08-01');

INSERT INTO experience (title, organization_id, status_id, category_id, description, start_date, end_date) VALUES
('FULL STACK DEVELOPER - 3',
 (SELECT id FROM organization WHERE name = 'Imatia'),
 (SELECT id FROM experience_status WHERE name = 'COMPLETED'),
 (SELECT id FROM experience_category WHERE name = 'WORK'),
 'Full stack development for an internal company project for employee expense management.',
 '2025-08-01', '2026-02-01');

INSERT INTO experience (title, organization_id, status_id, category_id, description, start_date, end_date) VALUES
('BOOTCAMP FULL STACK DEVELOPER',
 (SELECT id FROM organization WHERE name = 'Cluster TIC Galicia y Xunta de Galicia'),
 (SELECT id FROM experience_status WHERE name = 'COMPLETED'),
 (SELECT id FROM experience_category WHERE name = 'EDUCATION'),
 'Intensive training in full stack development.',
 '2022-05-01', '2022-08-01');

INSERT INTO experience (title, organization_id, status_id, category_id, description, start_date, end_date) VALUES
('CROSS-PLATFORM APPLICATION DEVELOPMENT',
 (SELECT id FROM organization WHERE name = 'CPR Afundación'),
 (SELECT id FROM experience_status WHERE name = 'COMPLETED'),
 (SELECT id FROM experience_category WHERE name = 'EDUCATION'),
 'Professional training in software development.',
 '2020-09-01', '2022-12-01');

INSERT INTO experience (title, organization_id, status_id, category_id, description, start_date, end_date) VALUES
('SCIENCE BACCALAUREATE',
 (SELECT id FROM organization WHERE name = 'IES Campo de San Alberto'),
 (SELECT id FROM experience_status WHERE name = 'COMPLETED'),
 (SELECT id FROM experience_category WHERE name = 'EDUCATION'),
 NULL,
 '2018-09-01', '2020-06-01');

INSERT INTO experience (title, organization_id, status_id, category_id, description, start_date, end_date) VALUES
('COMPUTER ENGINEERING',
 (SELECT id FROM organization WHERE name = 'UNED'),
 (SELECT id FROM experience_status WHERE name = 'COMPLETED'),
 (SELECT id FROM experience_category WHERE name = 'EDUCATION'),
 NULL,
 '2022-01-01', '2023-01-01');

INSERT INTO experience (title, organization_id, status_id, category_id, description, start_date, end_date) VALUES
('CARDIZA.DEV',
 (SELECT id FROM organization WHERE name = 'CARDIZA.DEV'),
 (SELECT id FROM experience_status WHERE name = 'IN_PROGRESS'),
 (SELECT id FROM experience_category WHERE name = 'PROJECT'),
 'Research and development of a full stack portfolio application',
 '2026-03-01', NULL);

INSERT INTO experience_technology (experience_id, technology_id)
SELECT e.id, t.id FROM experience e, technology t
WHERE e.title = 'FLUTTER DEVELOPER - PRACTICES' AND t.name IN (
    'Dart', 'Flutter', 'Git', 'Keycloak', 'Firebase', 'PostgreSQL: Multi-Tenancy', 'Docker', 'Gradle'
);

INSERT INTO experience_technology (experience_id, technology_id)
SELECT e.id, t.id FROM experience e, technology t
WHERE e.title = 'FULL STACK DEVELOPER - 1' AND t.name IN (
    'Dart', 'Java', 'Flutter', 'Git', 'Keycloak', 'Firebase', 'PostgreSQL: Multi-Tenancy', 'Docker',
    'Spring Boot', 'Postman', 'Ontimize Boot', 'Gradle', 'Maven'
);

INSERT INTO experience_technology (experience_id, technology_id)
SELECT e.id, t.id FROM experience e, technology t
WHERE e.title = 'FULL STACK DEVELOPER - 2' AND t.name IN (
    'Java', 'HTML', 'SCSS', 'TypeScript', 'Spring Boot', 'JPA', 'MapStruct', 'MySQL', 'MongoDB', 'Angular',
    'Git', 'Postman', 'Docker', 'JUnit', 'Mockito', 'Springfox (Swagger)', 'Jira', 'Jenkins', 'ActiveMQ',
    'OpenAPI (Swagger)', 'Spring Security', 'Lombok', 'AWS', 'S3', 'ArgoCD', 'Grafana', 'Ontimize Web',
    'Ontimize Boot', 'D3.js', 'JasperReports', 'Liquibase', 'Maven', 'Node.js', 'npm', 'Figma'
);

INSERT INTO experience_technology (experience_id, technology_id)
SELECT e.id, t.id FROM experience e, technology t
WHERE e.title = 'FULL STACK DEVELOPER - 3' AND t.name IN (
    'Java', 'HTML', 'CSS', 'TypeScript', 'Spring Boot', 'PostgreSQL', 'Angular', 'Git', 'Postman', 'Docker',
    'JUnit', 'Mockito', 'Jira', 'Lombok', 'AWS', 'S3', 'ArgoCD', 'Grafana', 'Ontimize Web', 'Ontimize Boot',
    'JasperReports', 'Flyway', 'Maven', 'Node.js', 'npm', 'Figma'
);

INSERT INTO experience_technology (experience_id, technology_id)
SELECT e.id, t.id FROM experience e, technology t
WHERE e.title = 'BOOTCAMP FULL STACK DEVELOPER' AND t.name IN (
    'Java', 'HTML', 'SCSS', 'TypeScript', 'Spring Boot', 'PostgreSQL', 'Liquibase', 'Git', 'Jira',
    'Ontimize Web', 'Ontimize Boot', 'Angular', 'Maven', 'Node.js', 'npm'
);

INSERT INTO experience_technology (experience_id, technology_id)
SELECT e.id, t.id FROM experience e, technology t
WHERE e.title = 'CROSS-PLATFORM APPLICATION DEVELOPMENT' AND t.name IN (
    'Java', 'HTML', 'CSS', 'T-SQL', 'Git', 'Maven', 'Kotlin'
);

INSERT INTO experience_technology (experience_id, technology_id)
SELECT e.id, t.id FROM experience e, technology t
WHERE e.title = 'CARDIZA.DEV' AND t.name IN (
    'Java', 'HTML', 'TypeScript', 'Spring Boot', 'JPA', 'MapStruct', 'PostgreSQL', 'Angular', 'TailwindCSS',
    'Git', 'Docker', 'JUnit', 'Mockito', 'GitHub Actions', 'OpenAPI (Swagger)', 'Lombok', 'Caffeine Cache',
    'Grafana', 'Flyway', 'Maven', 'Node.js', 'npm', 'Firebase'
);