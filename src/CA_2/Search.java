/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.util.List;
import java.util.Collections;
/**
 *
 * @author gabi.richardz
 */
//binary search class
public class Search {
    
    public static int binarySearch(List<String> list, String target) {
        
        //garantee that the list is organized
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = target.compareToIgnoreCase(list.get(mid));

            if (result == 0) {
                return mid; //found
            } else if (result > 0) {
                left = mid + 1; // search right
            } else {
                right = mid - 1; // search left
            }
        }
        return -1; // not found
    }
    
}
