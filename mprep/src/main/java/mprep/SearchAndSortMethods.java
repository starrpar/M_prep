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
    public void quickSort(int[] array) {
        quickSort_helper(array, 0, array.length - 1, true);
    }

    public static void quickSort_helper(int[] array, int begin, int end, boolean left) {
        if (end <= begin)
            return; // base case

        System.out.println("left? " + left);
        int pivot = partition(array, begin, end);
        quickSort_helper(array, begin, pivot - 1, true);
        quickSort_helper(array, pivot + 1, end, false);
    }

    static int partition(int[] array, int begin, int end) {
        int pivot = end;

        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                System.out.println(
                        "Swapping in for loop, i: " + i + "... " + array[i] + ":" + array[counter] + ", pivot: "
                                + array[pivot]);
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            } else {
                System.out.println("in for loop, i: " + i);
            }
        }

        // Some quick analysis:
        // this part places the chosen pivot value in its "correct" place, based on the
        // comparison above
        // in combination with the advancement of the counter value above (counter is
        // only advanced if the
        // "ith" value was less than the "pivot" value, and if so, was placed to the
        // left of the "counter"
        // place - which means the values to the left of counter are all less than the
        // pivot value, even if
        // they are not 100% sorted yet, still the pivot value is in its correct place -
        // but since the
        // counter value starts at the beginning and comes up, that means those to the
        // left ARE also already
        // sorted, based on the insertion of the pivot values previously)
        System.out.println("\nSwapping: " + array[counter] + ":" + array[pivot]);
        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;

        return counter;
    }

    // TO DO: add heapsort implementation...
    public void heapSort(int[] array) {

        // base case - stop when empty array sent
        if (array.length == 0)
            return;

        // Building the heap
        int length = array.length;
        // we're going from the first non-leaf to the root
        // start at halfway - 1 (so if 7 (3 levels of binary), then start at 3 - integer
        // division)
        // which is 2 in array terms - 0, 1, 2...
        for (int i = length / 2 - 1; i >= 0; i--) // by order of precedence, length / 2 - 1 is same as (length / 2) -
                                                  // 1...
            heapify(array, length, i);

        // swap ith value to end (sorting - largest from top of heap to back of array)
        // array[0] being top of heap; array[i] starting at end (length - 1) and coming
        // in with each top level call to heapify)
        for (int i = length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    static void heapify(int[] array, int length, int i) {
        // in array, get to children by going to twice current position plus 1 and 2
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int largest = i;

        // check both children for larger than current (i) - could use either left first
        // or right first
        // if the left child is larger than parent
        if (leftChild < length && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        // if the right child is larger than parent
        if (rightChild < length && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        // if a swap needs to occur -- i.e. if either child was larger, and so largest
        // has changed...
        // then push new largest to the ith position (further up in the heap (to the top
        // of the heap for the current pass))
        // once current swap is made, recursively heapify, with "i" for next execution
        // set to value of node that was swapped
        // with previous top of heap for current pass (i.e. so now start with location
        // that was previously larger and is now
        // containing the previously smaller value that was at the top of the current
        // pass heap at the beginning of that pass).
        // see example below for visual understanding...

        // this pass ONLY does the recursive heapifying, not the top level, just fyi...
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, length, largest);
        }
    }

    // heapSort logic:
    // heapify initially...
    // 6 1 8 3 5 2 4: Both children are smaller than the parent, so everything stays
    // the same.
    // 6 1 8 3 5 2 4: Because 5 > 1, we swap them. We recursively heapify() for 5
    // now.
    // 6 5 8 3 1 2 4: Both of the children are smaller, so nothing happens.
    // 6 5 8 3 1 2 4: Because 8 > 6, we swap them.
    // 8 5 6 3 1 2 4: We got the heap pictured above!

    // then simply swap top (root) to end (largest value, so sorting) and
    // re-heapify:
    // 8 5 6 3 1 2 4
    // 4 5 6 3 1 2 8: swapped
    // 6 5 4 3 1 2 8: heapified
    // 2 5 4 3 1 6 8: swapped
    // 5 2 4 2 1 6 8: heapified
    // 1 2 4 2 5 6 8: swapped

    public void forwardSort(int[] array) {
        Arrays.sort(array);
    }

    public void reverseSortInPlace(int[] array) {
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

    public int[] reverseSort(int[] array, boolean useComparator) {
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
    public boolean isSorted(int[] array) {
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

    public void bubbleSort(int[] array) {
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

    public int[] mergeSort(int[] array) {
        return mergeSort_helper(array, 0, array.length - 1);
    }

    public int[] mergeSort_helper(int[] array, int left, int right) {
        int[] helper = new int[array.length];

        // base case - when down to single value, simply return (to stop recursion)
        if (right == left) {
            return array;
        }

        // (can also use (left + ((right - left)/2)) to avoid overrun with large values)
        int middle = (left + right) / 2; // Java integer math - auto flooring

        mergeSort_helper(array, left, middle);
        mergeSort_helper(array, middle + 1, right);

        helper = mergeBack(array, left, middle + 1, right);
        copyBack(array, helper, left);

        return array;
    }

    public int[] mergeBack(int[] array, int left_start, int right_start, int right_end) {

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

    public int[] copyBack(int[] array, int[] helper, int offset) {
        for (int i = 0; i < helper.length; i++) {
            array[offset + i] = helper[i];
        }
        return array;
    }
}

// Quicksort behavior: - basically "drags" the higher group of values

// Unsorted array:
// 70, 70, 36, 27, 37, 11, 55, 77, 73, 26, 52, 76, 89, 31, 0, 48, 89, 51, 12,
// 72, 41, 35, 96, 25, 91, 53, 70, 73, 56, 13, 2, 74, 65, 28, 23, 36, 88, 1, 29,
// 1, 3, 18, 15, 46, 16, 42, 41, 51, 76, 45, 50, 11, 48, 40, 43, 41, 60, 23, 83,
// 85, 99, 73,
// 60, 28, 11, 75, 49, 60, 63, 86, 71, 10, 48, 75, 13, 9, 73, 0, 42, 52, 51, 22,
// 84, 76, 0, 58, 64, 53, 20, 37, 7, 88, 82, 3, 77, 77, 97, 40, 57, 59, left?
// true
// in for loop, i: 0
// in for loop, i: 1
// Swapping in for loop, i: 2... 36:70, pivot: 59
// Swapping in for loop, i: 3... 27:70, pivot: 59
// Swapping in for loop, i: 4... 37:70, pivot: 59
// Swapping in for loop, i: 5... 11:70, pivot: 59
// Swapping in for loop, i: 6... 55:70, pivot: 59
// in for loop, i: 7
// in for loop, i: 8
// Swapping in for loop, i: 9... 26:70, pivot: 59
// Swapping in for loop, i: 10... 52:70, pivot: 59
// in for loop, i: 11
// in for loop, i: 12
// Swapping in for loop, i: 13... 31:77, pivot: 59
// Swapping in for loop, i: 14... 0:73, pivot: 59
// Swapping in for loop, i: 15... 48:70, pivot: 59
// in for loop, i: 16
// Swapping in for loop, i: 17... 51:70, pivot: 59
// Swapping in for loop, i: 18... 12:76, pivot: 59
// in for loop, i: 19
// Swapping in for loop, i: 20... 41:89, pivot: 59
// Swapping in for loop, i: 21... 35:77, pivot: 59
// in for loop, i: 22
// Swapping in for loop, i: 23... 25:73, pivot: 59
// in for loop, i: 24
// Swapping in for loop, i: 25... 53:70, pivot: 59
// in for loop, i: 26
// in for loop, i: 27
// Swapping in for loop, i: 28... 56:89, pivot: 59
// Swapping in for loop, i: 29... 13:70, pivot: 59
// Swapping in for loop, i: 30... 2:76, pivot: 59
// in for loop, i: 31
// in for loop, i: 32
// Swapping in for loop, i: 33... 28:72, pivot: 59
// Swapping in for loop, i: 34... 23:89, pivot: 59
// Swapping in for loop, i: 35... 36:77, pivot: 59
// in for loop, i: 36
// Swapping in for loop, i: 37... 1:96, pivot: 59
// Swapping in for loop, i: 38... 29:73, pivot: 59
// Swapping in for loop, i: 39... 1:91, pivot: 59
// Swapping in for loop, i: 40... 3:70, pivot: 59
// Swapping in for loop, i: 41... 18:70, pivot: 59
// Swapping in for loop, i: 42... 15:73, pivot: 59
// Swapping in for loop, i: 43... 46:89, pivot: 59
// Swapping in for loop, i: 44... 16:70, pivot: 59
// Swapping in for loop, i: 45... 42:76, pivot: 59
// Swapping in for loop, i: 46... 41:74, pivot: 59
// Swapping in for loop, i: 47... 51:65, pivot: 59
// in for loop, i: 48
// Swapping in for loop, i: 49... 45:72, pivot: 59
// Swapping in for loop, i: 50... 50:89, pivot: 59
// Swapping in for loop, i: 51... 11:77, pivot: 59
// Swapping in for loop, i: 52... 48:88, pivot: 59
// Swapping in for loop, i: 53... 40:96, pivot: 59
// Swapping in for loop, i: 54... 43:73, pivot: 59
// Swapping in for loop, i: 55... 41:91, pivot: 59
// in for loop, i: 56
// Swapping in for loop, i: 57... 23:70, pivot: 59
// in for loop, i: 58
// in for loop, i: 59
// in for loop, i: 60
// in for loop, i: 61
// in for loop, i: 62
// Swapping in for loop, i: 63... 28:70, pivot: 59
// Swapping in for loop, i: 64... 11:73, pivot: 59
// in for loop, i: 65
// Swapping in for loop, i: 66... 49:89, pivot: 59
// in for loop, i: 67
// in for loop, i: 68
// in for loop, i: 69
// in for loop, i: 70
// Swapping in for loop, i: 71... 10:70, pivot: 59
// Swapping in for loop, i: 72... 48:76, pivot: 59
// in for loop, i: 73
// Swapping in for loop, i: 74... 13:74, pivot: 59
// Swapping in for loop, i: 75... 9:65, pivot: 59
// in for loop, i: 76
// Swapping in for loop, i: 77... 0:76, pivot: 59
// Swapping in for loop, i: 78... 42:72, pivot: 59
// Swapping in for loop, i: 79... 52:89, pivot: 59
// Swapping in for loop, i: 80... 51:77, pivot: 59
// Swapping in for loop, i: 81... 22:88, pivot: 59
// in for loop, i: 82
// in for loop, i: 83
// Swapping in for loop, i: 84... 0:96, pivot: 59
// Swapping in for loop, i: 85... 58:73, pivot: 59
// in for loop, i: 86
// Swapping in for loop, i: 87... 53:91, pivot: 59
// Swapping in for loop, i: 88... 20:60, pivot: 59
// Swapping in for loop, i: 89... 37:70, pivot: 59
// Swapping in for loop, i: 90... 7:83, pivot: 59
// in for loop, i: 91
// in for loop, i: 92
// Swapping in for loop, i: 93... 3:85, pivot: 59
// in for loop, i: 94
// in for loop, i: 95
// in for loop, i: 96
// Swapping in for loop, i: 97... 40:99, pivot: 59
// Swapping in for loop, i: 98... 57:73, pivot: 59

// Swapping: 60:59
// left? true
// Swapping in for loop, i: 0... 36:36, pivot: 57
// Swapping in for loop, i: 1... 27:27, pivot: 57
// Swapping in for loop, i: 2... 37:37, pivot: 57
// Swapping in for loop, i: 3... 11:11, pivot: 57
// Swapping in for loop, i: 4... 55:55, pivot: 57
// Swapping in for loop, i: 5... 26:26, pivot: 57
// Swapping in for loop, i: 6... 52:52, pivot: 57
// Swapping in for loop, i: 7... 31:31, pivot: 57
// Swapping in for loop, i: 8... 0:0, pivot: 57
// Swapping in for loop, i: 9... 48:48, pivot: 57
// Swapping in for loop, i: 10... 51:51, pivot: 57
// Swapping in for loop, i: 11... 12:12, pivot: 57
// Swapping in for loop, i: 12... 41:41, pivot: 57
// Swapping in for loop, i: 13... 35:35, pivot: 57
// Swapping in for loop, i: 14... 25:25, pivot: 57
// Swapping in for loop, i: 15... 53:53, pivot: 57
// Swapping in for loop, i: 16... 56:56, pivot: 57
// Swapping in for loop, i: 17... 13:13, pivot: 57
// Swapping in for loop, i: 18... 2:2, pivot: 57
// Swapping in for loop, i: 19... 28:28, pivot: 57
// Swapping in for loop, i: 20... 23:23, pivot: 57
// Swapping in for loop, i: 21... 36:36, pivot: 57
// Swapping in for loop, i: 22... 1:1, pivot: 57
// Swapping in for loop, i: 23... 29:29, pivot: 57
// Swapping in for loop, i: 24... 1:1, pivot: 57
// Swapping in for loop, i: 25... 3:3, pivot: 57
// Swapping in for loop, i: 26... 18:18, pivot: 57
// Swapping in for loop, i: 27... 15:15, pivot: 57
// Swapping in for loop, i: 28... 46:46, pivot: 57
// Swapping in for loop, i: 29... 16:16, pivot: 57
// Swapping in for loop, i: 30... 42:42, pivot: 57
// Swapping in for loop, i: 31... 41:41, pivot: 57
// Swapping in for loop, i: 32... 51:51, pivot: 57
// Swapping in for loop, i: 33... 45:45, pivot: 57
// Swapping in for loop, i: 34... 50:50, pivot: 57
// Swapping in for loop, i: 35... 11:11, pivot: 57
// Swapping in for loop, i: 36... 48:48, pivot: 57
// Swapping in for loop, i: 37... 40:40, pivot: 57
// Swapping in for loop, i: 38... 43:43, pivot: 57
// Swapping in for loop, i: 39... 41:41, pivot: 57
// Swapping in for loop, i: 40... 23:23, pivot: 57
// Swapping in for loop, i: 41... 28:28, pivot: 57
// Swapping in for loop, i: 42... 11:11, pivot: 57
// Swapping in for loop, i: 43... 49:49, pivot: 57
// Swapping in for loop, i: 44... 10:10, pivot: 57
// Swapping in for loop, i: 45... 48:48, pivot: 57
// Swapping in for loop, i: 46... 13:13, pivot: 57
// Swapping in for loop, i: 47... 9:9, pivot: 57
// Swapping in for loop, i: 48... 0:0, pivot: 57
// Swapping in for loop, i: 49... 42:42, pivot: 57
// Swapping in for loop, i: 50... 52:52, pivot: 57
// Swapping in for loop, i: 51... 51:51, pivot: 57
// Swapping in for loop, i: 52... 22:22, pivot: 57
// Swapping in for loop, i: 53... 0:0, pivot: 57
// in for loop, i: 54
// Swapping in for loop, i: 55... 53:58, pivot: 57
// Swapping in for loop, i: 56... 20:58, pivot: 57
// Swapping in for loop, i: 57... 37:58, pivot: 57
// Swapping in for loop, i: 58... 7:58, pivot: 57
// Swapping in for loop, i: 59... 3:58, pivot: 57
// Swapping in for loop, i: 60... 40:58, pivot: 57

// Swapping: 58:57
// left? true
// Swapping in for loop, i: 0... 36:36, pivot: 40
// Swapping in for loop, i: 1... 27:27, pivot: 40
// Swapping in for loop, i: 2... 37:37, pivot: 40
// Swapping in for loop, i: 3... 11:11, pivot: 40
// in for loop, i: 4
// Swapping in for loop, i: 5... 26:55, pivot: 40
// in for loop, i: 6
// Swapping in for loop, i: 7... 31:55, pivot: 40
// Swapping in for loop, i: 8... 0:52, pivot: 40
// in for loop, i: 9
// in for loop, i: 10
// Swapping in for loop, i: 11... 12:55, pivot: 40
// in for loop, i: 12
// Swapping in for loop, i: 13... 35:52, pivot: 40
// Swapping in for loop, i: 14... 25:48, pivot: 40
// in for loop, i: 15
// in for loop, i: 16
// Swapping in for loop, i: 17... 13:51, pivot: 40
// Swapping in for loop, i: 18... 2:55, pivot: 40
// Swapping in for loop, i: 19... 28:41, pivot: 40
// Swapping in for loop, i: 20... 23:52, pivot: 40
// Swapping in for loop, i: 21... 36:48, pivot: 40
// Swapping in for loop, i: 22... 1:53, pivot: 40
// Swapping in for loop, i: 23... 29:56, pivot: 40
// Swapping in for loop, i: 24... 1:51, pivot: 40
// Swapping in for loop, i: 25... 3:55, pivot: 40
// Swapping in for loop, i: 26... 18:41, pivot: 40
// Swapping in for loop, i: 27... 15:52, pivot: 40
// in for loop, i: 28
// Swapping in for loop, i: 29... 16:48, pivot: 40
// in for loop, i: 30
// in for loop, i: 31
// in for loop, i: 32
// in for loop, i: 33
// in for loop, i: 34
// Swapping in for loop, i: 35... 11:53, pivot: 40
// in for loop, i: 36
// in for loop, i: 37
// in for loop, i: 38
// in for loop, i: 39
// Swapping in for loop, i: 40... 23:56, pivot: 40
// Swapping in for loop, i: 41... 28:51, pivot: 40
// Swapping in for loop, i: 42... 11:55, pivot: 40
// in for loop, i: 43
// Swapping in for loop, i: 44... 10:41, pivot: 40
// in for loop, i: 45
// Swapping in for loop, i: 46... 13:52, pivot: 40
// Swapping in for loop, i: 47... 9:46, pivot: 40
// Swapping in for loop, i: 48... 0:48, pivot: 40
// in for loop, i: 49
// in for loop, i: 50
// in for loop, i: 51
// Swapping in for loop, i: 52... 22:42, pivot: 40
// Swapping in for loop, i: 53... 0:41, pivot: 40
// in for loop, i: 54
// Swapping in for loop, i: 55... 20:51, pivot: 40
// Swapping in for loop, i: 56... 37:45, pivot: 40
// Swapping in for loop, i: 57... 7:50, pivot: 40
// Swapping in for loop, i: 58... 3:53, pivot: 40

// Swapping: 48:40
// left? true
// in for loop, i: 0
// in for loop, i: 1
// in for loop, i: 2
// in for loop, i: 3
// in for loop, i: 4
// in for loop, i: 5
// Swapping in for loop, i: 6... 0:36, pivot: 3
// in for loop, i: 7
// in for loop, i: 8
// in for loop, i: 9
// in for loop, i: 10
// Swapping in for loop, i: 11... 2:27, pivot: 3
// in for loop, i: 12
// in for loop, i: 13
// in for loop, i: 14
// Swapping in for loop, i: 15... 1:37, pivot: 3
// in for loop, i: 16
// Swapping in for loop, i: 17... 1:11, pivot: 3
// in for loop, i: 18
// in for loop, i: 19
// in for loop, i: 20
// in for loop, i: 21
// in for loop, i: 22
// in for loop, i: 23
// in for loop, i: 24
// in for loop, i: 25
// in for loop, i: 26
// in for loop, i: 27
// in for loop, i: 28
// Swapping in for loop, i: 29... 0:26, pivot: 3
// in for loop, i: 30
// Swapping in for loop, i: 31... 0:31, pivot: 3
// in for loop, i: 32
// in for loop, i: 33
// in for loop, i: 34

// Swapping: 36:3
// left? true
// in for loop, i: 0
// in for loop, i: 1
// in for loop, i: 2
// in for loop, i: 3
// in for loop, i: 4

// Swapping: 0:0
// left? false
// in for loop, i: 1
// in for loop, i: 2
// in for loop, i: 3
// in for loop, i: 4

// Swapping: 2:0
// left? false
// Swapping in for loop, i: 2... 1:1, pivot: 2
// Swapping in for loop, i: 3... 1:1, pivot: 2
// Swapping in for loop, i: 4... 0:0, pivot: 2

// Swapping: 2:2
// left? true
// in for loop, i: 2
// in for loop, i: 3

// Swapping: 1:0
// left? false
// in for loop, i: 3

// Swapping: 1:1
// left? false
// Swapping in for loop, i: 7... 12:12, pivot: 36
// Swapping in for loop, i: 8... 35:35, pivot: 36
// Swapping in for loop, i: 9... 25:25, pivot: 36
// Swapping in for loop, i: 10... 13:13, pivot: 36
// Swapping in for loop, i: 11... 27:27, pivot: 36
// Swapping in for loop, i: 12... 28:28, pivot: 36
// Swapping in for loop, i: 13... 23:23, pivot: 36
// in for loop, i: 14
// in for loop, i: 15
// Swapping in for loop, i: 16... 29:36, pivot: 36
// Swapping in for loop, i: 17... 11:37, pivot: 36
// Swapping in for loop, i: 18... 3:36, pivot: 36
// Swapping in for loop, i: 19... 18:37, pivot: 36
// Swapping in for loop, i: 20... 15:36, pivot: 36
// Swapping in for loop, i: 21... 16:37, pivot: 36
// Swapping in for loop, i: 22... 11:36, pivot: 36
// Swapping in for loop, i: 23... 23:37, pivot: 36
// Swapping in for loop, i: 24... 28:36, pivot: 36
// Swapping in for loop, i: 25... 11:37, pivot: 36
// Swapping in for loop, i: 26... 10:36, pivot: 36
// Swapping in for loop, i: 27... 13:37, pivot: 36
// Swapping in for loop, i: 28... 9:36, pivot: 36
// Swapping in for loop, i: 29... 26:37, pivot: 36
// Swapping in for loop, i: 30... 22:36, pivot: 36
// Swapping in for loop, i: 31... 31:37, pivot: 36
// Swapping in for loop, i: 32... 20:36, pivot: 36
// in for loop, i: 33
// Swapping in for loop, i: 34... 7:37, pivot: 36

// Swapping: 36:36
// left? true
// in for loop, i: 7
// in for loop, i: 8
// in for loop, i: 9
// in for loop, i: 10
// in for loop, i: 11
// in for loop, i: 12
// in for loop, i: 13
// in for loop, i: 14
// in for loop, i: 15
// Swapping in for loop, i: 16... 3:12, pivot: 7
// in for loop, i: 17
// in for loop, i: 18
// in for loop, i: 19
// in for loop, i: 20
// in for loop, i: 21
// in for loop, i: 22
// in for loop, i: 23
// in for loop, i: 24
// in for loop, i: 25
// in for loop, i: 26
// in for loop, i: 27
// in for loop, i: 28
// in for loop, i: 29
// in for loop, i: 30

// Swapping: 35:7
// left? false
// Swapping in for loop, i: 9... 25:25, pivot: 35
// Swapping in for loop, i: 10... 13:13, pivot: 35
// Swapping in for loop, i: 11... 27:27, pivot: 35
// Swapping in for loop, i: 12... 28:28, pivot: 35
// Swapping in for loop, i: 13... 23:23, pivot: 35
// Swapping in for loop, i: 14... 29:29, pivot: 35
// Swapping in for loop, i: 15... 11:11, pivot: 35
// Swapping in for loop, i: 16... 12:12, pivot: 35
// Swapping in for loop, i: 17... 18:18, pivot: 35
// Swapping in for loop, i: 18... 15:15, pivot: 35
// Swapping in for loop, i: 19... 16:16, pivot: 35
// Swapping in for loop, i: 20... 11:11, pivot: 35
// Swapping in for loop, i: 21... 23:23, pivot: 35
// Swapping in for loop, i: 22... 28:28, pivot: 35
// Swapping in for loop, i: 23... 11:11, pivot: 35
// Swapping in for loop, i: 24... 10:10, pivot: 35
// Swapping in for loop, i: 25... 13:13, pivot: 35
// Swapping in for loop, i: 26... 9:9, pivot: 35
// Swapping in for loop, i: 27... 26:26, pivot: 35
// Swapping in for loop, i: 28... 22:22, pivot: 35
// Swapping in for loop, i: 29... 31:31, pivot: 35
// Swapping in for loop, i: 30... 20:20, pivot: 35

// Swapping: 35:35
// left? true
// in for loop, i: 9
// Swapping in for loop, i: 10... 13:25, pivot: 20
// in for loop, i: 11
// in for loop, i: 12
// in for loop, i: 13
// in for loop, i: 14
// Swapping in for loop, i: 15... 11:25, pivot: 20
// Swapping in for loop, i: 16... 12:27, pivot: 20
// Swapping in for loop, i: 17... 18:28, pivot: 20
// Swapping in for loop, i: 18... 15:23, pivot: 20
// Swapping in for loop, i: 19... 16:29, pivot: 20
// Swapping in for loop, i: 20... 11:25, pivot: 20
// in for loop, i: 21
// in for loop, i: 22
// Swapping in for loop, i: 23... 11:27, pivot: 20
// Swapping in for loop, i: 24... 10:28, pivot: 20
// Swapping in for loop, i: 25... 13:23, pivot: 20
// Swapping in for loop, i: 26... 9:29, pivot: 20
// in for loop, i: 27
// in for loop, i: 28
// in for loop, i: 29

// Swapping: 25:20
// left? true
// in for loop, i: 9
// in for loop, i: 10
// in for loop, i: 11
// in for loop, i: 12
// in for loop, i: 13
// in for loop, i: 14
// in for loop, i: 15
// in for loop, i: 16
// in for loop, i: 17
// in for loop, i: 18

// Swapping: 13:9
// left? false
// Swapping in for loop, i: 10... 11:11, pivot: 13
// Swapping in for loop, i: 11... 12:12, pivot: 13
// in for loop, i: 12
// in for loop, i: 13
// in for loop, i: 14
// Swapping in for loop, i: 15... 11:18, pivot: 13
// Swapping in for loop, i: 16... 11:15, pivot: 13
// Swapping in for loop, i: 17... 10:16, pivot: 13
// in for loop, i: 18

// Swapping: 18:13
// left? true
// in for loop, i: 10
// in for loop, i: 11
// in for loop, i: 12
// in for loop, i: 13

// Swapping: 11:10
// left? false
// in for loop, i: 11
// in for loop, i: 12
// in for loop, i: 13

// Swapping: 12:11
// left? false
// Swapping in for loop, i: 12... 11:11, pivot: 12
// Swapping in for loop, i: 13... 11:11, pivot: 12

// Swapping: 12:12
// left? true
// in for loop, i: 12

// Swapping: 11:11
// left? false
// Swapping in for loop, i: 16... 15:15, pivot: 18
// Swapping in for loop, i: 17... 16:16, pivot: 18
// Swapping in for loop, i: 18... 13:13, pivot: 18

// Swapping: 18:18
// left? true
// in for loop, i: 16
// in for loop, i: 17

// Swapping: 15:13
// left? false
// in for loop, i: 17

// Swapping: 16:15
// left? false
// Swapping in for loop, i: 21... 23:23, pivot: 25
// in for loop, i: 22
// in for loop, i: 23
// in for loop, i: 24
// Swapping in for loop, i: 25... 23:28, pivot: 25
// in for loop, i: 26
// in for loop, i: 27
// Swapping in for loop, i: 28... 22:27, pivot: 25
// in for loop, i: 29

// Swapping: 28:25
// left? true
// in for loop, i: 21
// in for loop, i: 22

// Swapping: 23:22
// left? false
// in for loop, i: 22

// Swapping: 23:23
// left? false
// in for loop, i: 25
// in for loop, i: 26
// Swapping in for loop, i: 27... 26:28, pivot: 28
// Swapping in for loop, i: 28... 27:29, pivot: 28
// in for loop, i: 29

// Swapping: 28:28
// left? true
// Swapping in for loop, i: 25... 26:26, pivot: 27

// Swapping: 27:27
// left? false
// in for loop, i: 28
// in for loop, i: 29

// Swapping: 29:28
// left? false
// in for loop, i: 29

// Swapping: 31:29
// left? false
// in for loop, i: 33
// in for loop, i: 34

// Swapping: 37:36
// left? false
// in for loop, i: 34

// Swapping: 37:37
// left? false
// Swapping in for loop, i: 37... 40:40, pivot: 48
// Swapping in for loop, i: 38... 43:43, pivot: 48
// Swapping in for loop, i: 39... 41:41, pivot: 48
// in for loop, i: 40
// in for loop, i: 41
// in for loop, i: 42
// in for loop, i: 43
// Swapping in for loop, i: 44... 41:56, pivot: 48
// in for loop, i: 45
// in for loop, i: 46
// Swapping in for loop, i: 47... 46:51, pivot: 48
// in for loop, i: 48
// Swapping in for loop, i: 49... 42:55, pivot: 48
// in for loop, i: 50
// in for loop, i: 51
// Swapping in for loop, i: 52... 42:49, pivot: 48
// Swapping in for loop, i: 53... 41:56, pivot: 48
// in for loop, i: 54
// in for loop, i: 55
// Swapping in for loop, i: 56... 45:48, pivot: 48
// in for loop, i: 57
// in for loop, i: 58

// Swapping: 52:48
// left? true
// Swapping in for loop, i: 37... 40:40, pivot: 45
// Swapping in for loop, i: 38... 43:43, pivot: 45
// Swapping in for loop, i: 39... 41:41, pivot: 45
// Swapping in for loop, i: 40... 41:41, pivot: 45
// in for loop, i: 41
// Swapping in for loop, i: 42... 42:46, pivot: 45
// Swapping in for loop, i: 43... 42:46, pivot: 45
// Swapping in for loop, i: 44... 41:46, pivot: 45

// Swapping: 46:45
// left? true
// Swapping in for loop, i: 37... 40:40, pivot: 41
// in for loop, i: 38
// in for loop, i: 39
// in for loop, i: 40
// in for loop, i: 41
// in for loop, i: 42

// Swapping: 43:41
// left? false
// Swapping in for loop, i: 39... 41:41, pivot: 43
// Swapping in for loop, i: 40... 41:41, pivot: 43
// Swapping in for loop, i: 41... 42:42, pivot: 43
// Swapping in for loop, i: 42... 42:42, pivot: 43

// Swapping: 43:43
// left? true
// Swapping in for loop, i: 39... 41:41, pivot: 42
// Swapping in for loop, i: 40... 41:41, pivot: 42
// in for loop, i: 41

// Swapping: 42:42
// left? true
// in for loop, i: 39

// Swapping: 41:41
// left? false
// Swapping in for loop, i: 47... 51:51, pivot: 52
// Swapping in for loop, i: 48... 48:48, pivot: 52
// in for loop, i: 49
// in for loop, i: 50
// Swapping in for loop, i: 51... 51:55, pivot: 52
// Swapping in for loop, i: 52... 49:52, pivot: 52
// in for loop, i: 53
// in for loop, i: 54
// Swapping in for loop, i: 55... 51:55, pivot: 52
// Swapping in for loop, i: 56... 48:52, pivot: 52
// Swapping in for loop, i: 57... 50:56, pivot: 52
// in for loop, i: 58

// Swapping: 53:52
// left? true
// in for loop, i: 47
// Swapping in for loop, i: 48... 48:51, pivot: 50
// in for loop, i: 49
// Swapping in for loop, i: 50... 49:51, pivot: 50
// in for loop, i: 51
// Swapping in for loop, i: 52... 48:51, pivot: 50

// Swapping: 51:50
// left? true
// in for loop, i: 47
// in for loop, i: 48

// Swapping: 48:48
// left? false
// in for loop, i: 48

// Swapping: 49:48
// left? false
// in for loop, i: 51
// in for loop, i: 52

// Swapping: 51:51
// left? false
// in for loop, i: 52

// Swapping: 51:51
// left? false
// in for loop, i: 55
// Swapping in for loop, i: 56... 52:55, pivot: 53
// in for loop, i: 57
// in for loop, i: 58

// Swapping: 55:53
// left? false
// in for loop, i: 57
// Swapping in for loop, i: 58... 53:56, pivot: 55

// Swapping: 56:55
// left? false
// in for loop, i: 63
// in for loop, i: 64
// in for loop, i: 65
// in for loop, i: 66
// in for loop, i: 67
// in for loop, i: 68
// in for loop, i: 69
// in for loop, i: 70
// in for loop, i: 71
// in for loop, i: 72
// in for loop, i: 73
// in for loop, i: 74
// in for loop, i: 75
// in for loop, i: 76
// in for loop, i: 77
// in for loop, i: 78
// in for loop, i: 79
// in for loop, i: 80
// in for loop, i: 81
// in for loop, i: 82
// in for loop, i: 83
// in for loop, i: 84
// in for loop, i: 85
// in for loop, i: 86
// in for loop, i: 87
// in for loop, i: 88
// in for loop, i: 89
// in for loop, i: 90
// in for loop, i: 91
// in for loop, i: 92
// in for loop, i: 93
// in for loop, i: 94
// in for loop, i: 95
// in for loop, i: 96
// in for loop, i: 97
// in for loop, i: 98

// Swapping: 70:60
// left? false
// in for loop, i: 64
// in for loop, i: 65
// in for loop, i: 66
// Swapping in for loop, i: 67... 60:73, pivot: 70
// Swapping in for loop, i: 68... 63:75, pivot: 70
// in for loop, i: 69
// in for loop, i: 70
// in for loop, i: 71
// in for loop, i: 72
// in for loop, i: 73
// in for loop, i: 74
// Swapping in for loop, i: 75... 65:89, pivot: 70
// in for loop, i: 76
// in for loop, i: 77
// in for loop, i: 78
// in for loop, i: 79
// in for loop, i: 80
// in for loop, i: 81
// in for loop, i: 82
// in for loop, i: 83
// in for loop, i: 84
// in for loop, i: 85
// Swapping in for loop, i: 86... 64:73, pivot: 70
// in for loop, i: 87
// Swapping in for loop, i: 88... 60:75, pivot: 70
// in for loop, i: 89
// in for loop, i: 90
// in for loop, i: 91
// in for loop, i: 92
// in for loop, i: 93
// in for loop, i: 94
// in for loop, i: 95
// in for loop, i: 96
// in for loop, i: 97
// in for loop, i: 98

// Swapping: 86:70
// left? true
// in for loop, i: 64
// in for loop, i: 65
// in for loop, i: 66
// in for loop, i: 67

// Swapping: 60:60
// left? false
// in for loop, i: 65
// in for loop, i: 66
// in for loop, i: 67

// Swapping: 63:60
// left? false
// in for loop, i: 66
// in for loop, i: 67

// Swapping: 65:63
// left? false
// Swapping in for loop, i: 67... 64:64, pivot: 65

// Swapping: 65:65
// left? false
// Swapping in for loop, i: 70... 71:71, pivot: 86
// Swapping in for loop, i: 71... 70:70, pivot: 86
// Swapping in for loop, i: 72... 76:76, pivot: 86
// Swapping in for loop, i: 73... 75:75, pivot: 86
// Swapping in for loop, i: 74... 74:74, pivot: 86
// in for loop, i: 75
// Swapping in for loop, i: 76... 73:89, pivot: 86
// Swapping in for loop, i: 77... 76:89, pivot: 86
// Swapping in for loop, i: 78... 72:89, pivot: 86
// in for loop, i: 79
// Swapping in for loop, i: 80... 77:89, pivot: 86
// in for loop, i: 81
// Swapping in for loop, i: 82... 84:89, pivot: 86
// Swapping in for loop, i: 83... 76:89, pivot: 86
// in for loop, i: 84
// Swapping in for loop, i: 85... 73:88, pivot: 86
// Swapping in for loop, i: 86... 73:89, pivot: 86
// in for loop, i: 87
// Swapping in for loop, i: 88... 75:89, pivot: 86
// Swapping in for loop, i: 89... 70:96, pivot: 86
// Swapping in for loop, i: 90... 83:88, pivot: 86
// in for loop, i: 91
// Swapping in for loop, i: 92... 82:89, pivot: 86
// Swapping in for loop, i: 93... 85:91, pivot: 86
// Swapping in for loop, i: 94... 77:89, pivot: 86
// Swapping in for loop, i: 95... 77:96, pivot: 86
// in for loop, i: 96
// in for loop, i: 97
// Swapping in for loop, i: 98... 73:88, pivot: 86

// Swapping: 88:86
// left? true
// Swapping in for loop, i: 70... 71:71, pivot: 73
// Swapping in for loop, i: 71... 70:70, pivot: 73
// in for loop, i: 72
// in for loop, i: 73
// in for loop, i: 74
// in for loop, i: 75
// in for loop, i: 76
// Swapping in for loop, i: 77... 72:76, pivot: 73
// in for loop, i: 78
// in for loop, i: 79
// in for loop, i: 80
// in for loop, i: 81
// in for loop, i: 82
// in for loop, i: 83
// Swapping in for loop, i: 84... 70:75, pivot: 73
// in for loop, i: 85
// in for loop, i: 86
// in for loop, i: 87
// in for loop, i: 88
// in for loop, i: 89

// Swapping: 74:73
// left? true
// in for loop, i: 70
// in for loop, i: 71
// in for loop, i: 72

// Swapping: 71:70
// left? false
// Swapping in for loop, i: 71... 70:70, pivot: 71
// in for loop, i: 72

// Swapping: 72:71
// left? false
// Swapping in for loop, i: 75... 73:73, pivot: 74
// in for loop, i: 76
// in for loop, i: 77
// in for loop, i: 78
// in for loop, i: 79
// in for loop, i: 80
// Swapping in for loop, i: 81... 73:76, pivot: 74
// Swapping in for loop, i: 82... 73:76, pivot: 74
// in for loop, i: 83
// in for loop, i: 84
// in for loop, i: 85
// in for loop, i: 86
// in for loop, i: 87
// in for loop, i: 88
// in for loop, i: 89

// Swapping: 77:74
// left? true
// in for loop, i: 75
// in for loop, i: 76

// Swapping: 73:73
// left? false
// in for loop, i: 76

// Swapping: 73:73
// left? false
// in for loop, i: 79
// Swapping in for loop, i: 80... 76:84, pivot: 77
// Swapping in for loop, i: 81... 76:84, pivot: 77
// Swapping in for loop, i: 82... 76:84, pivot: 77
// Swapping in for loop, i: 83... 75:84, pivot: 77
// Swapping in for loop, i: 84... 75:84, pivot: 77
// in for loop, i: 85
// in for loop, i: 86
// in for loop, i: 87
// in for loop, i: 88
// in for loop, i: 89

// Swapping: 84:77
// left? true
// in for loop, i: 79
// in for loop, i: 80
// in for loop, i: 81
// in for loop, i: 82

// Swapping: 76:75
// left? false
// in for loop, i: 80
// in for loop, i: 81
// Swapping in for loop, i: 82... 75:76, pivot: 76

// Swapping: 76:76
// left? false
// in for loop, i: 82

// Swapping: 76:76
// left? false
// Swapping in for loop, i: 85... 83:83, pivot: 84
// Swapping in for loop, i: 86... 82:82, pivot: 84
// in for loop, i: 87
// Swapping in for loop, i: 88... 77:85, pivot: 84
// Swapping in for loop, i: 89... 77:85, pivot: 84

// Swapping: 85:84
// left? true
// in for loop, i: 85
// in for loop, i: 86
// in for loop, i: 87

// Swapping: 83:77
// left? false
// Swapping in for loop, i: 86... 82:82, pivot: 83
// Swapping in for loop, i: 87... 77:77, pivot: 83

// Swapping: 83:83
// left? true
// in for loop, i: 86

// Swapping: 82:77
// left? false
// in for loop, i: 92
// in for loop, i: 93
// in for loop, i: 94
// in for loop, i: 95
// in for loop, i: 96
// in for loop, i: 97
// in for loop, i: 98

// Swapping: 89:88
// left? false
// in for loop, i: 93
// in for loop, i: 94
// in for loop, i: 95
// in for loop, i: 96
// in for loop, i: 97
// Swapping in for loop, i: 98... 88:91, pivot: 89

// Swapping: 89:89
// left? false
// in for loop, i: 95
// in for loop, i: 96
// in for loop, i: 97
// in for loop, i: 98

// Swapping: 96:89
// left? false
// in for loop, i: 96
// in for loop, i: 97
// Swapping in for loop, i: 98... 91:97, pivot: 96

// Swapping: 99:96
// left? false
// Swapping in for loop, i: 98... 97:97, pivot: 99

// Swapping: 99:99

// Sorted array:
// 0, 0, 0, 1, 1, 2, 3, 3, 7, 9, 10, 11, 11, 11, 12, 13, 13, 15, 16, 18, 20, 22,
// 23, 23, 25, 26, 27, 28, 28, 29, 31, 35, 36, 36, 37, 37, 40, 40, 41, 41, 41,
// 42, 42,
// 43, 45, 46, 48, 48, 48, 49, 50, 51, 51, 51, 52, 52, 53, 53, 55, 56, 57, 58,
// 59, 60, 60, 60, 63, 64, 65, 70, 70, 70, 71, 72, 73, 73, 73, 73, 74, 75, 75,
// 76, 76, 76, 77, 77, 77, 82, 83, 84, 85, 86, 88, 88, 89, 89, 91, 96, 97, 99,