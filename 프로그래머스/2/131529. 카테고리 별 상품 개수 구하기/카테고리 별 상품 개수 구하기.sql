-- 코드를 입력하세요
SELECT left(product_code, 2) as CATEGORY, count(*) as PRODUCTS
from product
group by CATEGORY
