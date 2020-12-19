DROP TABLE IF EXISTS account;
CREATE TABLE account
(
    account_name VARCHAR(255) NOT NULL,
    password     VARCHAR(255) NOT NULL,
    id           BIGINT,
    enabled      BOOL DEFAULT true
);

drop table if exists entry;
create table entry
(
    id      BIGINT(20) NOT NULL AUTO_INCREMENT,
    created DATE,
    summary VARCHAR(255),
    title   VARCHAR(255),
    PRIMARY KEY (id)
);
