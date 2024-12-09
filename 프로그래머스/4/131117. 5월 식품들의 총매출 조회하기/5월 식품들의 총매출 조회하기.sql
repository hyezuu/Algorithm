-- 코드를 입력하세요
SELECT fp.PRODUCT_ID, fp.PRODUCT_NAME, fp.price*sum(fo.amount) as TOTAL_SALES
FROM FOOD_PRODUCT as fp
INNER JOIN FOOD_ORDER as fo on fp.product_id = fo.product_id
WHERE fo.produce_date like '2022-05%'
GROUP BY product_id 
ORDER BY TOTAL_SALES desc, PRODUCT_ID