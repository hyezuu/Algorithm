-- 코드를 작성해주세요
WITH TEMP AS
(
    SELECT EMP_NO,
        CASE 
            WHEN AVG(SCORE) >= 96 THEN 'S'
            WHEN AVG(SCORE) >= 90 THEN 'A'
            WHEN AVG(SCORE) >= 80 THEN 'B'
            ELSE 'C'
        END AS GRADE
    FROM HR_GRADE
    GROUP BY EMP_NO
)

SELECT E.EMP_NO, E.EMP_NAME, T.GRADE, 
    CASE 
        WHEN T.GRADE = 'S' THEN E.SAL * 0.2
        WHEN T.GRADE = 'A' THEN E.SAL * 0.15
        WHEN T.GRADE = 'B' THEN E.SAL * 0.1
        ELSE 0
    END AS BONUS
FROM HR_EMPLOYEES as E
JOIN TEMP as T ON E.EMP_NO = T.EMP_NO
ORDER BY EMP_NO