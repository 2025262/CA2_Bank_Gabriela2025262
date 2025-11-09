/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author gabi.richardz
 */
//class nodes - represents employees
class Node {
    String name;
    String managerType;
    String department;
    Node left;  
    Node right;  

    Node(String name, String managerType, String department) {
        this.name = name;
        this.managerType = managerType;
        this.department = department;
        this.left = null;
        this.right = null;
    }
}

//class binary tree - represents hierarchy
public class BinaryTree {

    private Node root;

    // level-order insertion
    public void insertLevelOrder(String name, String managerType, String department) {
        Node newNode = new Node(name, managerType, department);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.left == null) {
                current.left = newNode;
                return;
            } else if (current.right == null) {
                current.right = newNode;
                return;
            } else {
                queue.add(current.left);
                queue.add(current.right);
            }
        }
    }

    //shows hierarchy
    public void displayLevelOrder() {
        if (root == null) {
            System.out.println("No employees in the hierarchy.");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        System.out.println("Employee Hierarchy (Level Order)");
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println("Level " + level + ":");

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                System.out.println("  - " + current.name + " | " + current.managerType + " | " + current.department);

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

            level++;
        }

        System.out.println("Total employees: " + countNodes(root));
        System.out.println("Tree height: " + height(root));
    }

    private int countNodes(Node node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    private int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}