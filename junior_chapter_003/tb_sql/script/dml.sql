-- 1. Написать запрос получение всех продуктов с типом "СЫР"
SELECT 			 product.id, "type".name, product.name, product.price, product.expired_date
FROM 			 product, "type"
WHERE 			 product.type_id = "type".id AND "type".name = 'СЫР';

-- 2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
SELECT 			 id, name, price, expired_date
FROM 			 product
WHERE 			 name LIKE '%мороженное%';

-- 3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
SELECT 			 id, name, expired_date, price
FROM 			 product
WHERE 			 date_part('month', ndate) = date_part('month', CURRENT_DATE + INTERVAL '1 month');

-- 4. Написать запрос, который выводит самый дорогой продукт.
SELECT 			 id, name, expired_date, price
FROM 			 product
WHERE 			 price = (SELECT MAX(price) FROM product);

-- 5. Написать запрос, который выводит количество всех продуктов определенного типа.
SELECT 			 "type".name, COUNT(product.type_id)
FROM 			 product, "type"
WHERE 			 "type".id = product.type_id
GROUP BY 		 "type".name, type_id;

-- 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО".
SELECT 			 product.id, "type".name, product.name, product.price, product.expired_date
FROM 			 product, "type"
WHERE 			 product.type_id = "type".id AND ("type".name = 'СЫР' OR "type".name = 'МОЛОКО');

-- 7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
SELECT 			 name
FROM 			 "type"
WHERE (
				 SELECT 			 COUNT(product.id)
				 FROM 			 product
				 INNER JOIN		 "type"
				 ON 				 product.type_id = "type".id) < 10;

-- 8. Вывести все продукты и их тип.
SELECT 			 "type".name, product.name
FROM 			 "type"
INNER JOIN 		 product
ON 				 "type".id = product.type_id;