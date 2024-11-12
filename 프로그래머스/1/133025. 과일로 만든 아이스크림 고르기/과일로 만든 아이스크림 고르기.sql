-- 코드를 입력하세요
SELECT fh.flavor from first_half as fh
join icecream_info as ii
on fh.flavor = ii.flavor
where ii.ingredient_type = 'fruit_based' and fh.total_order > 3000
order by fh.total_order desc
