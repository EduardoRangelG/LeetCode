WITH cte_salary_rank AS (
    SELECT 
        d.name as Department,
        e.name as Employee,
        e.salary as Salary,
        DENSE_RANK() OVER(PARTITION BY d.name ORDER BY e.salary DESC) AS sal_rank
    FROM Employee as e
    JOIN Department AS d ON d.id=e.departmentId
)

SELECT Department,Employee,Salary
FROM cte_salary_rank
WHERE sal_rank<=3
ORDER BY Department,Salary DESC