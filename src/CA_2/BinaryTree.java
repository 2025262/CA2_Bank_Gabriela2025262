/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author gabi.richardz
 */
//class for tree nodes
class Node {
    String name;
    Node left;  
    Node right;  

    Node(String name) {
        this.name = name;
        left = right = null;
    }
}

//manage nodes
public class BinaryTree {

    private Node root;

    //adding a node
    public void insert(String name) {
        root = insertRec(root, name);
    }

    private Node insertRec(Node root, String name) {
        if (root == null) {
            root = new Node(name);
            return root;
        }
        if (name.compareToIgnoreCase(root.name) < 0) {
            root.left = insertRec(root.left, name);
        } else if (name.compareToIgnoreCase(root.name) > 0) {
            root.right = insertRec(root.right, name);
        }
        return root;
    }

    //show hierarchy
    public void displayHierarchy() {
        System.out.println("Employee Hierarchy (In-Order Traversal)");
        inorder(root, 0);
    }

    private void inorder(Node root, int level) {
        if (root != null) {
            inorder(root.right, level + 1);
            
            System.out.println("    ".repeat(level) + " - " + root.name);
            inorder(root.left, level + 1);
        }
    }
}