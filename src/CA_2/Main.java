/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.util.Scanner;
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
        
        
        //menu
        Scanner input = new Scanner(System.in);
        MenuOption choice = null;
        
        System.out.println("Welcome to the Bank Management System");

        do {
            System.out.println("\nPlease choose an option:");
            for (MenuOption option : MenuOption.values()) {
                System.out.println(option.getCode() + " - " + option.getDescription());
            }

            System.out.print("Enter your choice: ");
            int code = 0;

            try {
                code = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            choice = MenuOption.fromCode(code);

            if (choice == null) {
                System.out.println("Invalid choice! Try again.");
                continue;
            }

            switch (choice) {
                case SORT:
                    System.out.println("Sorting the applicants list");
                    break;
                case SEARCH:
                    System.out.println("Searching for employee");
                    break;
                case ADD:
                    System.out.println("Adding a new record");
                    break;
                case TREE:
                    System.out.println("Creating the employee hierarchy");
                    break;
                case EXIT:
                    System.out.println("Exiting the program");
                    break;
            }

        } while (choice != MenuOption.EXIT);

        input.close();
       
    }
}
   
