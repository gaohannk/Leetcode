package leetcode.r;

/**
 * Table: Failed
 *
 * +--------------+---------+
 * | Column Name  | Type    |
 * +--------------+---------+
 * | fail_date    | date    |
 * +--------------+---------+
 * Primary key for this table is fail_date.
 * Failed table contains the days of failed tasks.
 * Table: Succeeded
 *
 * +--------------+---------+
 * | Column Name  | Type    |
 * +--------------+---------+
 * | success_date | date    |
 * +--------------+---------+
 * Primary key for this table is success_date.
 * Succeeded table contains the days of succeeded tasks.
 *
 *
 * A system is running one task every day. Every task is independent of the previous tasks. The tasks can fail or succeed.
 *
 * Write an SQL query to generate a report of period_state for each continuous interval of days in the period from 2019-01-01 to 2019-12-31.
 *
 * period_state is 'failed' if tasks in this interval failed or 'succeeded' if tasks in this interval succeeded. Interval of days are retrieved as start_date and end_date.
 *
 * Order result by start_date.
 *
 * The query result format is in the following example:
 *
 * Failed table:
 * +-------------------+
 * | fail_date         |
 * +-------------------+
 * | 2018-12-28        |
 * | 2018-12-29        |
 * | 2019-01-04        |
 * | 2019-01-05        |
 * +-------------------+
 *
 * Succeeded table:
 * +-------------------+
 * | success_date      |
 * +-------------------+
 * | 2018-12-30        |
 * | 2018-12-31        |
 * | 2019-01-01        |
 * | 2019-01-02        |
 * | 2019-01-03        |
 * | 2019-01-06        |
 * +-------------------+
 *
 *
 * Result table:
 * +--------------+--------------+--------------+
 * | period_state | start_date   | end_date     |
 * +--------------+--------------+--------------+
 * | succeeded    | 2019-01-01   | 2019-01-03   |
 * | failed       | 2019-01-04   | 2019-01-05   |
 * | succeeded    | 2019-01-06   | 2019-01-06   |
 * +--------------+--------------+--------------+
 *
 * The report ignored the system state in 2018 as we care about the system in the period 2019-01-01 to 2019-12-31.
 * From 2019-01-01 to 2019-01-03 all tasks succeeded and the system state was "succeeded".
 * From 2019-01-04 to 2019-01-05 all tasks failed and system state was "failed".
 * From 2019-01-06 to 2019-01-06 all tasks succeeded and system state was "succeeded".
 */
public class ReportContiguousDates {
    /**
     * select task as period_state, min(Datee) as start_date,
     * max(Datee) as end_date
     * from
     * (select Datee, task,
     * Number,
     * dateadd(d, -Number, Datee) as Seq
     * from
     * (select *,
     * row_number() over(order by task, Datee asc) as Number
     * from
     * (select fail_date as 'Datee', 'failed' AS task from Failed
     * Union
     * select success_date as 'Datee', 'succeeded' AS task from succeeded) as tmp
     * where Datee >= '2019-01-01' and Datee <= '2019-12-31') as tmp2) tmp3
     * group by Seq, task
     * order by start_date
     */

    /**
     * with a  as (
     * (select fail_date as date,
     *        'failed' as period_state
     *        from failed)
     * union all
     *
     *  (select success_date as date,
     *          'succeeded' as period_state
     *          from succeeded)
     *     ),
     *
     *   b as (
     * select date,
     *        period_state,
     *        row_number() over (order by period_state, date asc) as seq
     *    from a where date between '2019-01-01' and '2019-12-31'
     *          ),
     *
     *  c as (
     * select date, period_state,seq, dateadd(d, -seq, date) as seqStart from b
     * )
     *
     * select period_state, min(date) as start_date, max(date) as end_date from c
     * group by seqStart,period_state
     * order by start_date asc
     */
}
