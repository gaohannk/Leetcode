Table: Sales

+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| sale_id      | int     |
| product_name | varchar |
| sale_date    | date    |
+--------------+---------+
sale_id is the primary key for this table.
Each row of this table contains the product name and the date it was sold.

Since table Sales was filled manually in the year 2000, product_name may contain leading and/or trailing white spaces, also they are case-insensitive.

Write an SQL query to report

product_name in lowercase without leading or trailing white spaces.
sale_date in the format ('YYYY-MM')
total the number of times the product was sold in this month.
Return the result table ordered by product_name in ascending order, in case of a tie order it by sale_date in ascending order.

The query result format is in the following example.



Sales
+------------+------------------+--------------+
| sale_id    | product_name     | sale_date    |
+------------+------------------+--------------+
| 1          |      LCPHONE     | 2000-01-16   |
| 2          |    LCPhone       | 2000-01-17   |
| 3          |     LcPhOnE      | 2000-02-18   |
| 4          |      LCKeyCHAiN  | 2000-02-19   |
| 5          |   LCKeyChain     | 2000-02-28   |
| 6          | Matryoshka       | 2000-03-31   |
+------------+------------------+--------------+

Result table:
+--------------+--------------+----------+
| product_name | sale_date    | total    |
+--------------+--------------+----------+
| lcphone      | 2000-01      | 2        |
| lckeychain   | 2000-02      | 2        |
| lcphone      | 2000-02      | 1        |
| matryoshka   | 2000-03      | 1        |
+--------------+--------------+----------+

In January, 2 LcPhones were sold, please note that the product names are not case sensitive and may contain spaces.
In Februery, 2 LCKeychains and 1 LCPhone were sold.
In March, 1 matryoshka was sold.

select
    TRIM(LOWER(product_name)) AS product_name ,
    DATE_FORMAT(sale_date , '%Y-%m') AS sale_date ,
    COUNT(*) AS total
FROM Sales
GROUP BY
    TRIM(LOWER(product_name)),
    DATE_FORMAT(sale_date , '%Y-%m')
ORDER BY
    product_name ASC,
    sale_date ASC;



SELECT *, COUNT(PRODUCT_NAME) AS TOTAL
FROM (
    SELECT LOWER(TRIM(product_name)) AS PRODUCT_NAME,  DATE_FORMAT(sale_date, "%Y-%m")AS SALE_DATE
    FROM Sales) _
GROUP BY
    PRODUCT_NAME,
    SALE_DATE
ORDER BY
    PRODUCT_NAME ASC,
    SALE_DATE ASC