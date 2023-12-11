CREATE TABLE user(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL,
    nickname VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL,
    lat DOUBLE(8, 7) NOT NULL,
    lng DOUBLE(8, 7) NOT NULL,
    stayed_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    updated_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6)
);
