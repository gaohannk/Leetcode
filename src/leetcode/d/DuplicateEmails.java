package leetcode.d;

/**
 * SQL Schema
 *
 * Write a SQL query to find all duplicate emails in a table named Person.
 *
 * +----+---------+
 * | Id | Email   |
 * +----+---------+
 * | 1  | a@b.com |
 * | 2  | c@d.com |
 * | 3  | a@b.com |
 * +----+---------+
 *
 * For example, your query should return the following for the above table:
 *
 * +---------+
 * | Email   |
 * +---------+
 * | a@b.com |
 * +---------+
 *
 * Note: All emails are in lowercase.
 */
public class DuplicateEmails {
    /**
     * select Email from
     * (
     *   select Email, count(Email) as num
     *   from Person
     *   group by Email
     * ) as statistic
     * where num > 1
     * ;
     */
    /**
     * select Email
     * from Person
     * group by Email
     * having count(Email) > 1;
     */
}
