/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author gabi.richardz
 */

//class for bank employees
public class Employee {

    private String name;
    private int employeeId;
    private Department department;
    private Manager manager;

    public Employee(String name, int employeeId, Department department, Manager manager) {
        this.name = name;
        this.employeeId = employeeId;
        this.department = department;
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Employee: " + name + " (ID: " + employeeId + "), " +
               department.getDepartmentName() + ", Manager: " + manager.getManagerName();
    }
}

