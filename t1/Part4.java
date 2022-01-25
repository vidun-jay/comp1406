/*
name: Vidun Jayakody
id: 101224988
course: Introduction to Computer Science II
### Tutorial 1 ###
*/

import java.util.ArrayList;

public class Part4 {

    public static char[] filter(char[] list, char target) {

        // create new ArrayList for the filtered list
        ArrayList<Character> new_list = new ArrayList<Character>();

        // for every item in the list...
        for (char item : list) {
            // ...as long as its not the target, add it to the new list
            if (item != target) {
                new_list.add(item);
            }
        }

        // convert to ArrayList to char[] array before returning
        char[] char_array = new char[new_list.size()];
        for(int i = 0; i < new_list.size(); i++) {
            char_array[i] = new_list.get(i);
        }

        return char_array;
    }
    public static void main(String[] args) {

        // declare and initiate sample list
        char[] list = new char[]{'a', 'b', 'a', 'c' ,'d'};
        // define the target to remove
        char target = 'a';

        // print original list
        System.out.print("Original list: ");
        for (int i = 0; i < list.length; i++) {System.out.print(list[i]);}

        // print filtered list
        System.out.print("\nFiltered list: ");
        System.out.println(filter(list, target));
    }
}