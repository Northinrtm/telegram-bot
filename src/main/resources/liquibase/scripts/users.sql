-- liquibase formatted sql

-- changeset northinrtm:1

CREATE TABLE notification_task
(
    id           SERIAL NOT NULL PRIMARY KEY,
    chat_id      INTEGER,
    notification TEXT,
    date_time    TIMESTAMP
)