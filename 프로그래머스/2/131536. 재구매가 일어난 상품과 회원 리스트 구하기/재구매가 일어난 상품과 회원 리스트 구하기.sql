SELECT 
    user_id,
    product_id
FROM 
    online_sale
GROUP BY
    1,
    2
HAVING
    COUNT(sales_amount) >= 2
ORDER BY
    1, 
    2 DESC;