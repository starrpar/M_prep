package mprep;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class SearchAndSortMethods {

    // NOTE: there are also SelectionSort and InsertionSort if I want to include
    // those

    // also do Binary Search problems

    // TO DO: add quicksort implementation...
    public int[] quicksort(int[] array) {
        return quicksort_helper(array);
    }

    public int[] quicksort_helper(int[] array) {
        int[] helper = new int[array.length];

        return helper;
    }

    // TO DO: add heapsort implementation...
    public int[] heapsort(int[] array) {
        return heapsort_helper(array);
    }

    public int[] heapsort_helper(int[] array) {
        int[] helper = new int[array.length];

        return helper;
    }

    public void forwardsort(int[] array) {
        Arrays.sort(array);
    }

    public void reversesortInPlace(int[] array) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };

        // Arrays.sort(array, Collections.reverseOrder());
        Integer[] arrayInt = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayInt[i] = (Integer) array[i];
        }

        // *******************************************************
        Arrays.sort(arrayInt, comparator);
        // *******************************************************

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) arrayInt[i];
        }

    }

    public int[] reversesort(int[] array, boolean useComparator) {
        // *******************************************************
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };
        // *******************************************************

        int[] arrayInt = new int[array.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }

        // *******************************************************
        Comparator<Integer> comparer = Collections.reverseOrder();
        if (useComparator == true) {
            Collections.sort(list, comparator);
        } else {
            Collections.sort(list, comparer);
        }
        // *******************************************************

        Object[] objs = list.toArray();
        for (int i = 0; i < objs.length; i++) {
            arrayInt[i] = (int) objs[i];
        }
        return arrayInt;
    }

    // alternate version of bubblesort used to verify if sorted yet - if a swap is
    // needed, it's not sorted
    public boolean issorted(int[] array) {
        int sortedIndex = array.length - 1;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < sortedIndex; j++) {
                if (array[j] > array[j + 1]) {
                    return false;
                }
            }
            sortedIndex--;
        }
        return true;
    }

    public void bubblesort(int[] array) {
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    sorted = false;
                }
            }
        }

    }

    private void swap(int[] array, int first, int second) {
        int tmpInt = array[first];
        array[first] = array[second];
        array[second] = tmpInt;
    }

    public int[] mergesort(int[] array) {
        return mergesort_helper(array, 0, array.length - 1);
    }

    public int[] mergesort_helper(int[] array, int left, int right) {
        int[] helper = new int[array.length];

        // base case - when down to single value, simply return (to stop recursion)
        if (right == left) {
            return array;
        }

        // (can also use (left + ((right - left)/2)) to avoid overrun with large values)
        int middle = (left + right) / 2; // Java integer math - auto flooring

        mergesort_helper(array, left, middle);
        mergesort_helper(array, middle + 1, right);

        helper = mergeback(array, left, middle + 1, right);
        copyback(array, helper, left);

        return array;
    }

    public int[] mergeback(int[] array, int left_start, int right_start, int right_end) {

        int[] helper = new int[(right_end - left_start) + 1];

        int left_index = left_start;
        int right_index = right_start;

        for (int i = 0; i < helper.length; i++) {
            // if either right is out of indexing (i.e. - just process remaining left)
            // or left value is less than right (as long as still comparing)
            if (right_index > right_end || (left_index < right_start &&
                    array[left_index] <= array[right_index])) {
                helper[i] = array[left_index];
                left_index++;
                // otherwise, take right value
            } else {
                helper[i] = array[right_index];
                right_index++;
            }
        }

        return helper;
    }

    public int[] copyback(int[] array, int[] helper, int offset) {
        for (int i = 0; i < helper.length; i++) {
            array[offset + i] = helper[i];
        }
        return array;
    }

    // todo - implement heapsearch
    // static void heapify(int[] array, int length, int i) {
    // int leftChild = 2*i+1;
    // int rightChild = 2*i+2;
    // int largest = i;

    // // if the left child is larger than parent
    // if (leftChild < length && array[leftChild] > array[largest]) {
    // largest = leftChild;
    // }

    // // if the right child is larger than parent
    // if (rightChild < length && array[rightChild] > array[largest]) {
    // largest = rightChild;
    // }

    // // if a swap needs to occur
    // if (largest != i) {
    // int temp = array[i];
    // array[i] = array[largest];
    // array[largest] = temp;
    // heapify(array, length, largest);
    // }
    // }

    // public static void heapSort(int[] array) {
    // if (array.length == 0) return;

    // // Building the heap
    // int length = array.length;
    // // we're going from the first non-leaf to the root
    // for (int i = length / 2-1; i >= 0; i--)
    // heapify(array, length, i);

    // for (int i = length-1; i >= 0; i--) {
    // int temp = array[0];
    // array[0] = array[i];
    // array[i] = temp;

    // heapify(array, i, 0);
    // }
    // }
}
