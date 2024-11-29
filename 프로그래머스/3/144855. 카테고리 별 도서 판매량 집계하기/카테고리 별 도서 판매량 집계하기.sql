-- 코드를 입력하세요
SELECT b.category as CATEGORY, sum(bs.sales) as TOTAL_SALES
from book b 
inner join book_sales as bs
    on b.book_id = bs.book_id
where year(bs.sales_date) = '2022' and month(bs.sales_date) = '1'
group by CATEGORY
order by CATEGORY