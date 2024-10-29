-- 3. The name, population, and sales tax of the states in the "West" census region.
-- Order the results by sales tax, lowest first.
-- (13 rows)

select state_name, population, sales_tax
From state
where census_region IN ('West')
order by sales_tax;