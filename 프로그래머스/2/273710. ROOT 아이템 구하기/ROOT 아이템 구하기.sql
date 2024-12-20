-- 코드를 작성해주세요  
select ii.ITEM_ID, ii.ITEM_NAME 
FROM ITEM_INFO ii
inner join ITEM_TREE it on ii.item_id = it.item_id
where it.parent_item_id is null
order by item_id 