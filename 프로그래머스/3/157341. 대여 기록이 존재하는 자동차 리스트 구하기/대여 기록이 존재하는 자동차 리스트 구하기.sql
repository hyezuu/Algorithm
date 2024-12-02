-- 코드를 입력하세요
SELECT distinct cc.car_id as CAR_ID
from car_rental_company_car as cc
inner join car_rental_company_rental_history as rh
on cc.car_id = rh.car_id
where month(start_date) = '10' and cc.car_type = '세단'
order by cc.car_id desc