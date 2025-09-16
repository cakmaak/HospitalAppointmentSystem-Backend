CREATE SCHEMA IF NOT EXISTS hospitalappointment;

CREATE TABLE hospitalappointment.users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    rol VARCHAR(20) NOT NULL DEFAULT 'USER'
);

CREATE TABLE hospitalappointment.poliklinikler (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE hospitalappointment.doctors (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    poliklinik_id BIGINT NOT NULL REFERENCES hospitalappointment.poliklinikler(id)
);

CREATE TABLE hospitalappointment.appointments (
    id BIGSERIAL PRIMARY KEY,
    tarih TIMESTAMP NOT NULL,
    durum VARCHAR(50) DEFAULT 'BEKLEMEDE',
    user_id BIGINT NOT NULL REFERENCES hospitalappointment.users(id) ON DELETE CASCADE,
    poliklinik_id BIGINT NOT NULL REFERENCES hospitalappointment.poliklinikler(id),
    doctor_id BIGINT NOT NULL REFERENCES hospitalappointment.doctors(id)
);
