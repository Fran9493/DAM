SET GLOBAL log_bin_trust_function_creators = 1;

DELIMITER $$
drop function if exists f_aleatorio_suma; $$
create function f_aleatorio_suma (min int, max int) returns int
begin
	declare val1 int;
    declare val2 int;
    declare val3 int;
    
    call p_genera_aleatorio (min, max, val1, val2, val3);
     
    return (val1 + val2 + val3);
end; $$