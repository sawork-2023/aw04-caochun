INSERT INTO TBL_PRODUCTS (prd_category, prd_name, prd_price)
SELECT * FROM CSVREAD('/home/chun/develop/aw04-caochun/target/classes/data.csv', NULL, 'charset=UTF-8');