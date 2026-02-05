-- Table for my Niche Item (Smartphone)
CREATE TABLE IF NOT EXISTS smartphones (
                                           id INT AUTO_INCREMENT PRIMARY KEY,
                                           product_id VARCHAR(36),
    brand VARCHAR(255) NOT NULL,
    warranty_months INT NOT NULL,
    camera_mp INT NOT NULL,
    price DOUBLE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

-- Table for Stationery
CREATE TABLE IF NOT EXISTS notebooks (
                                         id INT AUTO_INCREMENT PRIMARY KEY,
                                         product_id VARCHAR(36),
    brand VARCHAR(255) NOT NULL,
    page_count INT NOT NULL,
    price DOUBLE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );