-- 코드를 작성해주세요
SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPER_INFOS
WHERE "Python" in (skill_1, skill_2, skill_3)
ORDER BY 1