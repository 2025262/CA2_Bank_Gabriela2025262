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
            System.out.println("Please choose an option:");
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
                    System.out.println("Reading applicants from file and sorting");
                    
                try {
                    java.nio.file.Path path = java.nio.file.Paths.get("Applicants_Form.txt");
                    java.util.List<String> names = java.nio.file.Files.readAllLines(path);
                    
                    names.removeIf(line -> line.trim().isEmpty());

                    if (names.isEmpty()) {
                        System.out.println("No applicants found in file.");
                        break;
                    }

                    java.util.List<String> sortedNames = Sorting.mergeSort(names);

                    System.out.println("Sorted Applicants (first 20)");
                    for (int i = 0; i < Math.min(20, sortedNames.size()); i++) {
                        System.out.println((i + 1) + ". " + sortedNames.get(i));
                    }

                } catch (Exception ex) {
                    System.out.println("Error reading file: " + ex.getMessage());
                }
                    break;
                case SEARCH:
                    System.out.println("Enter the employee name to search:");
                    String target = input.nextLine();

                try {
                    java.nio.file.Path path = java.nio.file.Paths.get("Applicants_Form.txt");
                    java.util.List<String> names = java.nio.file.Files.readAllLines(path);

                    int index = Search.binarySearch(names, target);

                    if (index != -1) {
                        System.out.println(target + " found at position " + (index + 1));
                    } else {
                        System.out.println(target + " not found in the applicants list.");
                    }

                } catch (Exception ex) {
                    System.out.println("Error reading file: " + ex.getMessage());
                }
                break;
                
                case ADD:
                    System.out.println("Add new applicant");
                    
                    System.out.print("Enter applicant name: ");
                    String newName = input.nextLine();
                    
                    //managers
                    String[] validManagers = {"Branch Manager", "Assistant Manager", "Team Lead"};
                    System.out.println("Choose Manager Type:");
                    for (int i = 0; i < validManagers.length; i++) {
                        System.out.println((i + 1) + " - " + validManagers[i]);
                    }

                    System.out.print("Enter number for Manager Type: ");
                    int managerChoice = Integer.parseInt(input.nextLine());
                    if (managerChoice < 1 || managerChoice > validManagers.length) {
                        System.out.println("Invalid Manager Type choice!");
                        break;
                    }
                    String chosenManager = validManagers[managerChoice - 1];

                    //departments
                    String[] validDepartments = {"Finance", "IT", "Customer Service"};
                    System.out.println("Choose Department:");
                    for (int i = 0; i < validDepartments.length; i++) {
                        System.out.println((i + 1) + " - " + validDepartments[i]);
                    }

                    System.out.print("Enter number for Department: ");
                    int deptChoice = Integer.parseInt(input.nextLine());
                    if (deptChoice < 1 || deptChoice > validDepartments.length) {
                        System.out.println("Invalid Department choice!");
                        break;
                    }
                    String chosenDepartment = validDepartments[deptChoice - 1];

                    try {
                        java.nio.file.Path path = java.nio.file.Paths.get("Applicants_Form.txt");

                        //record manager and department
                        String record = newName + " | " + chosenManager + " | " + chosenDepartment;
                        java.nio.file.Files.write(
                            path,
                            java.util.Collections.singletonList(record),
                            java.nio.file.StandardOpenOption.APPEND
                        );

                        System.out.println("New applicant added successfully:");
                        System.out.println(record);

                    } catch (Exception ex) {
                        System.out.println("Error adding applicant: " + ex.getMessage());
                    }
                    break;
                
                case TREE:
                    System.out.println("Creating employee hierarchy (level-order)");

                    BinaryTree tree = new BinaryTree();

                    try {
                        java.nio.file.Path path = java.nio.file.Paths.get("Applicants_Form.txt");
                        java.util.List<String> lines = java.nio.file.Files.readAllLines(path);

                        if (lines.isEmpty()) {
                            System.out.println("No data found in Applicants_Form.txt");
                            break;
                        }

                        //reading file
                        for (String line : lines) {
                            String[] parts = line.split("\\|");
                            if (parts.length == 3) {
                                String name = parts[0].trim();
                                String managerType = parts[1].trim();
                                String department = parts[2].trim();
                                tree.insertLevelOrder(name, managerType, department);
                            }
                        }

                        System.out.println("Hierarchy created successfully!");
                        tree.displayLevelOrder();

                    } catch (Exception ex) {
                        System.out.println("Error reading Applicants_Form.txt: " + ex.getMessage());
                    }
                    break;
    
            }

        } while (choice != MenuOption.EXIT);

        input.close();
       
    }
}
   
