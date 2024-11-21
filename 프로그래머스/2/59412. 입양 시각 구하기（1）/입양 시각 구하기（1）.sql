-- 코드를 입력하세요
SELECT 
time_format(datetime, '%H') as HOUR, 
count(*) as COUNT
from animal_outs
where time_format(datetime, '%H') >= 9
and time_format(datetime, '%H') < 20
group by time_format(datetime, '%H')
order by time_format(datetime, '%H')