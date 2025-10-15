-- Managers with direct report counts and average report age (rounded)
SELECT
  m.employee_id,
  m.name,
  COUNT(r.employee_id)     AS reports_count,
  ROUND(AVG(r.age))        AS average_age
FROM Employees AS m
JOIN Employees AS r
  ON r.reports_to = m.employee_id   -- r directly reports to m
GROUP BY
  m.employee_id, m.name
ORDER BY
  m.employee_id;
