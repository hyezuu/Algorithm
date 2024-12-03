-- 코드를 입력하세요
SELECT ai.animal_id as ANIMAL_ID, ai.animal_type as ANIMAL_TYPE, ai.name as NAME
FROM animal_ins as ai 
INNER JOIN animal_outs as ao ON ai.animal_id = ao.animal_id
WHERE ai.sex_upon_intake != ao.sex_upon_outcome


