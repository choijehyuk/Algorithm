SELECT CAR_TYPE , COUNT(OPTIONS) AS CARS
FROM CAR_RENTAL_COMPANY_CAR
# WHERE OPTIONS LIKE '%가죽시트%'
# OR OPTIONS LIKE '%열선시트%'
# OR OPTIONS LIKE '%가죽시트%'
WHERE OPTIONS LIKE '%시트%'
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE ASC;

#select * from car_rental_company_car