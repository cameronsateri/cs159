import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Exercises for practicing with Java collection types.
 * 
 * @author cameron sateri
 * @version 4/12/23
 */
public class CollectionExercises {

    /**
     * This method removes all values from the provided list that are smaller than the indicated integer. The remaining
     * elements retain their original ordering.
     * 
     * @param list the list of integers
     * @param minVal the minimum value to retain
     */
    public static void removeSmallInts(List<Integer> list, int minVal) {
        for (int i : list) {
            if (i < minVal) {
                list.remove(i);
            }
        }
    }

    /**
     * This method returns true if the provided collection contains any duplicate elements.
     * 
     * @param ints a collection of integers
     * @return true if ints contains duplicates, false otherwise
     */
    public static boolean containsDuplicates(Collection<Integer> ints) {
        HashSet<Integer> hs = new HashSet<Integer>(ints);
        if (hs.size() == ints.size()) {
            return true;
        }
        return false;
    }

    /**
     * This method returns an ArrayList containing all elements that appear in either of the two collection arguments.
     * There will be no duplicate values in the resulting ArrayList. The values in the returned ArrayList may be in any
     * order.
     * 
     * For example, if the two arguments contain {2, 1, 2, 3} and {3, 4, 4, 5}, the returned ArrayList will contain {1,
     * 2, 3, 4, 5}. The original collections will not be modified.
     * 
     * @param ints1 the first collection
     * @param ints2 the second collection
     * @return An ArrayList containing the integers that appear in either collection.
     */
    public static ArrayList<Integer> inEither(Collection<Integer> ints1, Collection<Integer> ints2) {
        if (ints1 == null || ints1.size() == 0 || ints2 == null || ints2.size() == 0) {
            return null;
        }
        HashSet<Integer> hs1 = new HashSet<Integer>(ints1);
        HashSet<Integer> hs2 = new HashSet<Integer>(ints2);
        ArrayList<Integer> al = new ArrayList<>();
        al.addAll(hs1);
        al.addAll(hs2);
        return al;
    }

    /**
     * This method returns an ArrayList containing all elements that appear in both of the two collection arguments.
     * There will be no duplicate values in the resulting ArrayList. The values in the returned ArrayList may be in any
     * order. For example, if the two arguments contain {2, 1, 2, 3} and {3, 4, 4, 5}, the returned ArrayList will
     * contain {3}. The original collections will not be modified.
     * 
     * @param ints1 the first collection
     * @param ints2 the second collection
     * @return An ArrayList containing the integers that appear in both collections.
     */
    public static ArrayList<Integer> inBoth(Collection<Integer> ints1, Collection<Integer> ints2) {
        if (ints1 == null || ints1.size() == 0 || ints2 == null || ints2.size() == 0) {
            return null;
        }
        ArrayList<Integer> al = new ArrayList<Integer>();
        ints1.retainAll(ints2);
        al.addAll(ints1);
        return al;
    }

    /**
     * This method returns the String that appears most frequently in the provided list. For example, if the input list
     * contains the elements {"Bob", "Alice", "Bob"}, this method will return "Bob". If there are ties, any of the most
     * frequently occurring elements may be returned.
     * 
     * @param list a list of Strings
     * @return the most frequently occurring String
     */
    public static String mostFrequent(List<String> list) {
        // You should solve this problem in two stages: First iterate through
        // the list to count every String. Then iterate through your counts
        // to find the largest. You'll need a collection that allows you to
        // store a mapping from Strings to counts.
        // Remember: no nested for-loops are allowed.
        if (list == null || list.size() == 0) {
            return null;
        }
        HashMap<String, Integer> hm = new HashMap<>();
        for (String i : list) {
            if (hm.put(i, 1) == null) {
                hm.put(i, hm.get(i) + 1);
            }
        }
        int count = 0;
        String common = "";
        for (String i : hm.keySet()) {
            if (hm.get(i) > count) {
                count = hm.get(i);
                common = i;
            }
        }
        return common;
    }

}
