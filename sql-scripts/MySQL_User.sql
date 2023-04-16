-- Drop user first if they exist
DROP USER if exists 'blogauthor'@'localhost' ;

-- Now create user with prop privileges
CREATE USER 'blogauthor'@'localhost' IDENTIFIED BY 'blogauthor';

GRANT ALL PRIVILEGES ON * . * TO 'blogauthor'@'localhost';