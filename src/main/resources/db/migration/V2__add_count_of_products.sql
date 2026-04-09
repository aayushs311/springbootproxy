ALTER TABLE category
    ADD count_of_products INT NULL;

ALTER TABLE category
    MODIFY count_of_products INT NOT NULL;