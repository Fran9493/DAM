SET GLOBAL log_bin_trust_function_creators = 1;

DELIMITER $$
drop procedure if exists p_genera_aleatorio; $$
create procedure p_genera_aleatorio (in min int, in max int, out al1 int, out al2 int, out al3 int)
begin
	select round((rand() * (max - min)) + min) into al1;
    select round((rand() * (max - min)) + min) into al2;
    select round((rand() * (max - min)) + min) into al3;
end; $$
