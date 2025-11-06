/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author gabi.richardz
 */

//this class sorting names using merge sort
public class Sorting {

    //main method
    public static List<String> mergeSort(List<String> list) {
        if (list.size() <= 1) {
            return list;
        }
        //divide the list in 2 
        int middle = list.size() / 2;
        List<String> left = new ArrayList<>(list.subList(0, middle));
        List<String> right = new ArrayList<>(list.subList(middle, list.size()));

        return merge(mergeSort(left), mergeSort(right));
    }

    //method that performs ordered join
    private static List<String> merge(List<String> left, List<String> right) {
        List<String> sorted = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareToIgnoreCase(right.get(j)) <= 0) {
                sorted.add(left.get(i));
                i++;
            } else {
                sorted.add(right.get(j));
                j++;
            }
        }

        //the elements of the list that are not yet complete are added
        while (i < left.size()) {
            sorted.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            sorted.add(right.get(j));
            j++;
        }

        return sorted;
    }
}

