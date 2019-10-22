package leetcode.algo.q;

/**
 * Table: Queries
 *
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | query_name  | varchar |
 * | result      | varchar |
 * | position    | int     |
 * | rating      | int     |
 * +-------------+---------+
 * There is no primary key for this table, it may have duplicate rows.
 * This table contains information collected from some queries on a database.
 * The position column has a value from 1 to 500.
 * The rating column has a value from 1 to 5. Query with rating less than 3 is a poor query.
 *
 *
 * We define query quality as:
 *
 * The average of the ratio between query rating and its position.
 *
 * We also define poor query percentage as:
 *
 * The percentage of all queries with rating less than 3.
 *
 * Write an SQL query to find each query_name, the quality and poor_query_percentage.
 *
 * Both quality and poor_query_percentage should be rounded to 2 decimal places.
 *
 * The query result format is in the following example:
 *
 * Queries table:
 * +------------+-------------------+----------+--------+
 * | query_name | result            | position | rating |
 * +------------+-------------------+----------+--------+
 * | Dog        | Golden Retriever  | 1        | 5      |
 * | Dog        | German Shepherd   | 2        | 5      |
 * | Dog        | Mule              | 200      | 1      |
 * | Cat        | Shirazi           | 5        | 2      |
 * | Cat        | Siamese           | 3        | 3      |
 * | Cat        | Sphynx            | 7        | 4      |
 * +------------+-------------------+----------+--------+
 *
 * Result table:
 * +------------+---------+-----------------------+
 * | query_name | quality | poor_query_percentage |
 * +------------+---------+-----------------------+
 * | Dog        | 2.50    | 33.33                 |
 * | Cat        | 0.66    | 33.33                 |
 * +------------+---------+-----------------------+
 *
 * Dog queries quality is ((5 / 1) + (5 / 2) + (1 / 200)) / 3 = 2.50
 * Dog queries poor_ query_percentage is (1 / 3) * 100 = 33.33
 *
 * Cat queries quality equals ((2 / 5) + (3 / 3) + (4 / 7)) / 3 = 0.66
 * Cat queries poor_ query_percentage is (1 / 3) * 100 = 33.33
 */
public class QueriesQualityandPercentage {
    /**
     * select query_name
     *       ,cast(avg(rating/(position * 1.0)) as decimal(18,2)) as quality
     *       ,cast((sum(case when rating < 3 then 1 else 0 end) / (count(*) * 1.0)) * 100  as decimal(18,2)) as poor_query_percentage
     *     from Queries
     * group by query_name
     */

    /**
     * select q.query_name,
     *        round(avg(q.quality), 2) as quality,
     *        round(100*sum(q.rating)/count(*), 2) as poor_query_percentage
     * from
     * (select query_name, rating/position as quality,
     *     case when rating >= 3 then 0 else 1 end as rating
     * from Queries) as q
     * group by q.query_name
     */

    /**
     * SELECT query_name, ROUND(SUM(rating/position)/ count(*),2) AS quality,
     * ROUND(SUM(IF(rating<3,1,0))*100 /COUNT(*),2) AS poor_query_percentage
     * FROM Queries
     * GROUP BY query_name
     */

}
