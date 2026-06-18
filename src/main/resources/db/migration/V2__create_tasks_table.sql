CREATE TABLE tasks
(
    id          BIGSERIAL PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    description TEXT,
    priority    VARCHAR(20) DEFAULT 'MEDIUM',
    completed   BOOLEAN     DEFAULT FALSE,
    created_at  TIMESTAMP   DEFAULT NOW(),
    due_date    DATE,
    user_id     BIGINT       NOT NULL,
    CONSTRAINT fk_user
        FOREIGN KEY (user_id) REFERENCES users (id)
            ON DELETE CASCADE,
    CONSTRAINT check_priority
        CHECK (priority IN ('LOW', 'MEDIUM', 'HIGH'))
);

CREATE INDEX idx_tasks_user_id ON tasks (user_id);