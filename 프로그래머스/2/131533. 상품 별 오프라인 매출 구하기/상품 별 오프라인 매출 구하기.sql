select 
    p.product_code as PRODUCT_CODE,
    sum(os.sales_amount) * p.price as SALES
from 
    offline_sale as os 
    inner join product as p on os.product_id = p.product_id
group by p.product_code
order by sales desc, product_code