-- 코드를 입력하세요
SELECT DISTINCT CART_ID
FROM CART_PRODUCTS c
WHERE c.NAME = 'Milk'
    AND EXISTS (
    SELECT 1 
    FROM CART_PRODUCTS sub
    WHERE c.cart_id = sub.cart_id
        and sub.NAME = 'Yogurt'
    )
ORDER BY CART_ID