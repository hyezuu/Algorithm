-- 코드를 입력하세요
SELECT ao.animal_id as ANIMAL_ID, ao.name as NAME
FROM animal_outs as ao
LEFT JOIN animal_ins as ai on ai.animal_id = ao.animal_id
WHERE ai.animal_id is null
ORDER BY ANIMAL_ID