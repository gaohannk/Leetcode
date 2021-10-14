--The Employee table holds all employees. Every employee has an Id, and there is also a column for the department Id.
--
--+----+-------+--------+--------------+
--| Id | Name  | Salary | DepartmentId |
--+----+-------+--------+--------------+
--| 1  | Joe   | 85000  | 1            |
--| 2  | Henry | 80000  | 2            |
--| 3  | Sam   | 60000  | 2            |
--| 4  | Max   | 90000  | 1            |
--| 5  | Janet | 69000  | 1            |
--| 6  | Randy | 85000  | 1            |
--| 7  | Will  | 70000  | 1            |
--+----+-------+--------+--------------+
--The Department table holds all departments of the company.
--
--+----+----------+
--| Id | Name     |
--+----+----------+
--| 1  | IT       |
--| 2  | Sales    |
--+----+----------+
--Write a SQL query to find employees who earn the top three salaries in each of the department. For the above tables, your SQL query should return the following rows (order of rows does not matter).
--
--+------------+----------+--------+
--| Department | Employee | Salary |
--+------------+----------+--------+
--| IT         | Max      | 90000  |
--| IT         | Randy    | 85000  |
--| IT         | Joe      | 85000  |
--| IT         | Will     | 70000  |
--| Sales      | Henry    | 80000  |
--| Sales      | Sam      | 60000  |
--+------------+----------+--------+
--Explanation:
--
--In IT department, Max earns the highest salary, both Randy and Joe earn the second highest salary, and Will earns the third highest salary. There are only two employees in the Sales department, Henry earns the highest salary while Sam earns the second highest salary.


SELECT
    d.Name AS 'Department', e1.Name AS 'Employee', e1.Salary
FROM
    Employee e1
        JOIN
    Department d ON e1.DepartmentId = d.Id
WHERE
    3 > (SELECT
            COUNT(DISTINCT e2.Salary)
        FROM
            Employee e2
        WHERE
            e2.Salary > e1.Salary
                AND e1.DepartmentId = e2.DepartmentId
        )
;

select d.Name as `Department`, e.Name as `Employee`, e.Salary as `Salary`
from Employee as e inner join Department as d on e.DepartmentId=d.Id
where e.Salary in (
    select * from (
        select distinct(e1.Salary)
        from Employee e1
        where e1.DepartmentId=d.Id
        order by e1.Salary desc
        limit 3
    ) as _
)
group by d.Name, e.Name


SELECT DNAME AS Department, Employee, Salary FROM
(
    SELECT E.Name AS Employee, E.Salary AS Salary, D.Name AS DNAME,
    DENSE_RANK() OVER(PARTITION BY  E.DepartmentId Order By E.Salary DESC) DEPARTMENT_RANK
    FROM Employee E
    INNER JOIN Department D
    ON E.DepartmentId = D.Id
)SQL1
WHERE SQL1.DEPARTMENT_RANK IN (1,2,3)

