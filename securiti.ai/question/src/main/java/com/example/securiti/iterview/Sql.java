package main.java.com.example.securiti.iterview;

/***
 * Employee: Id, Name, DeptNo, Salary
Department: No, Name, LocationCode
Location : Code, Name

The total salary in each department
 * 
 * 
 * SELECT D.Name, sum(E.Salary)
 * FROM Employee E 
 * JOIN Department D on E.DeptNo == D.No
 * GROUP BY D.Name
 * 
 * Locations that have no employees
 * 
 * SELECT L.Name, count(E.*) as countEmployee
 * FROM Employee E
 * JOIN Department D on E.DeptNo == D.No
 * JOIN Location L on D.LocationCode == L.Code
 * GROUP BY L.Name
 * HAVING countEmployee == 0
 * 
 * 
 * Employees whose salary is less than the average of their department
 * 
 * SELECT E.Name, E.Salary
 * FROM Employees E
 * where E.Salary < (
 *                      Select avg(E1.Salary)
 *                      FROM Employee E1
 *                      WHERE E1.DeptNo == E.DeptNo
 *                      GROUP BY E1.DeptNo
 *                  )
 * 
 */

public class Sql {
    
}
