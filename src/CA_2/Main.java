/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author gabi.richardz
 */
public class Main {

    public static void main(String[] args) {

        // creating departments
        Department finance = new Department("Finance", "D001");
        Department it = new Department("IT", "D002");

        // creating managers
        Manager m1 = new Manager("Alice Brown", "Branch Manager", 101);
        Manager m2 = new Manager("John Smith", "Assistant Manager", 102);

        // creating employees
        Employee e1 = new Employee("Maria Oliveira", 201, finance, m1);
        Employee e2 = new Employee("Carlos Silva", 202, it, m2);

        
        System.out.println(e1);
        System.out.println(e2);
    }
}
