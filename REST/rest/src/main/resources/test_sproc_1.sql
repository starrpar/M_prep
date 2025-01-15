CREATE DEFINER=`root`@`localhost` PROCEDURE `new_procedure`()

BEGIN

UPDATE mydb.user
	SET first_name = 'Don'
    WHERE first_name = 'Edward'
    AND last_name = 'King';
    
INSERT INTO mydb.user(age, occupation, first_name, last_name)
VALUES(20,"Manager","Stephen","King");

END
