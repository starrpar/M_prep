package mprep;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ArrayMethods {

    // Object findMinElement(Object[] arr) {
    // // this could be by numeric value only, or using ascii as integer values
    // // equivalent to findMaxElement()

    // }

    // EASY:
    // merge 2 sorted arrays
    // DONE: --remove dupes from an array--
    // DONE: --count frequency of element in array--
    // <<???>> two sum
    // find min/max element in array
    // remove dupes from sorted array
    // DONE: --remove element in-place (pass array by ref)--
    // search insert position
    // <<<TO DO>>> max subarray
    // <<???>> plus one
    // <<<TO DO>>> convert sorted array to binary search tree
    // single number
    // DONE: --count primes--
    // DONE: --contains dupe--
    // third largest num
    // count odd/even

    // MEDIUM:
    // DONE: --move all zeros to beginning/end of array--
    // find if given element is in a sorted array (binary search)
    // rotate array
    // largest sum of non-adjacent numbers (dynamic programming)
    // product array puzzle
    // max product subarray (dynamic programming)
    // shortest unsorted continuous subarray
    // max sum of hour glass in matrix
    // paint house (dynamic programming)
    // min number of jumps to reach end
    // find dupes in O(n) time and O(1) extra space
    // find 3 numbers with max product
    // max sum circular subarray
    // min number swaps to sort array

    // HARD:
    // rotate 2D array
    // create change with coins
    // sliding window max
    // find smallest positive number missing from unsorted array
    // find missing number in ordered arithmetic progression
    // find max j-1, such that arr[j] > arr[i] (distance maximizing problem)
    // array manipulation
    // median of 2 sorted arrays
    // sudoku solver
    // largest rectangle in a histogram
    // max rectangle in binary matrix
    // find min in rotated sorted array
    // count of smaller numbers after self
    // palindrome pairs
    // sort an array containing 0's, 1's and 2's
    // longest increasing subsequence
    // trapping rain water

    // this is the brute force O(n^2) version I was trying during the interview
    public static List<Integer> moveZeroes(List<Integer> arr) {
        int arrayLen = arr.size();

        for (int i = 0; i < arrayLen; i++) {
            int k = i;
            while (i < arrayLen && k < arrayLen && arr.get(i) == 0) {
                // if moving 0 to current position 'i', then need to ALSO move that one to the
                // end as well (ongoing)
                // once have moved a non-zero value to current position 'i', THEN can increment
                // i and continue
                for (int j = i; j < arrayLen - 1; j++) {
                    arr.set(j, arr.get(j + 1));
                }
                arr.set(arrayLen - 1, 0);

                k++;
            }
        }
        return arr;
    }

    // todo: find a better than O(n^2) means of solving this
    // following is O(n)
    public static List<Integer> moveZeroesMoreEfficient(Integer[] arr) {
        int arrayLen = arr.length;
        List<Integer> arrList;
        List<Integer> newArr = new ArrayList<>();
        List<Integer> tmpArr = new ArrayList<>();

        arrList = Arrays.asList(arr);

        for (int i = 0; i < arrayLen; i++) {
            if (arrList.get(i) == 0) {
                // capture zeroes
                tmpArr.add(0);
            } else {
                // capture non-zeroes
                newArr.add(arr[i]);
            }
        }
        newArr.addAll(tmpArr);

        return newArr;
    }

    int countPrimes(int[] arr) {
        int count = 0;
        boolean isdivisible = false;

        for (int i = 0; i < arr.length; i++) {

            // LOGIC: reset boolean to determine if can be divided by anything
            isdivisible = false;

            // LOGIC: do not consider values of 1 or 2 - start with 3 as 1st prime
            if (arr[i] > 2) {

                // LOGIC: only index for divisors from 2 (evens) to 1 less than the number
                // itself
                for (int j = 2; j < arr[i]; j++) {

                    // LOGIC: if is divisible by anything (other than 1 and itself), move along to
                    // next
                    // value
                    if (arr[i] % j == 0) {
                        isdivisible = true;
                        break;
                    }
                }

                // LOGIC: once all divisors (from 2 to 1 less than the number itself) have been
                // considered
                // LOGIC: if not found to be divisible, count as a prime and move on to next
                // value
                // be sure to reset isdivisible boolean so next value does not get wrongly
                // included
                if (!isdivisible) {
                    // debugging output
                    // System.out.println("\nScore: " + arr[i]);
                    count++;
                    isdivisible = false;
                }
            }
        }

        // in this case, simply return number of primes, others want full list returned
        return count;
    }

    int removeDuplicates(Object[] arr) {
        int count = 0;
        List<Object> alreadyPresentList = new ArrayList<>();
        List<Object> tmpArray = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (!alreadyPresentList.contains(arr[i])) {
                tmpArray.add(arr[i]);
                count++;
                alreadyPresentList.add(arr[i]);
            }
        }
        Object[] newArr = new Object[count];

        for (int i = 0; i < count; i++) {
            newArr[i] = tmpArray.get(i);
        }
        arr = newArr;
        // print out to confirm/debugging
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1) {
                System.out.print(arr[i] + ",");
            } else {
                System.out.print(arr[i]);
            }
        }
        return count;
    }

    // package-private access (default)
    int[] createRandomIntArray(int length, int bound) {
        Random rdm = new Random();
        int[] returnArray = new int[length];

        for (int i = 0; i < length; i++) {
            returnArray[i] = rdm.nextInt(bound);
        }
        System.out.println("\nLength of final int array: " + returnArray.length);

        return returnArray;
    }

    // package-private access (default)
    char[] createRandomCharArray(int length) {
        Random rdm = new Random();
        char[] returnArray = new char[length];

        // NOTE: ascii - A = 65; Z = 90; a = 97; z = 122
        int decider = 0;
        int val = 0;

        for (int i = 0; i < length; i++) {
            decider = rdm.nextInt(2); // either 0 or 1
            if (decider == 0) {
                val = (int) 'A';
            } else {
                val = (int) 'a';
            }
            returnArray[i] = (char) (val + rdm.nextInt(26));
        }
        System.out.println("\nLength of final char array: " + returnArray.length);

        return returnArray;
    }

    public int countFrequencyOfElement(Object[] arr, Object val) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                arr[count++] = arr[i];
            }
        }

        return count;
    }

    public int removeElementInPlace1(int[] arr, int val) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                arr[count++] = arr[i];
            }
        }
        // print out to confirm/debugging
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.print("\nLength of final array: " + arr.length);
        return count;
    }

    public int removeElementInPlace2(int[] arr, int val) {
        int count = 0;
        List<Integer> tmpArray = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                tmpArray.add(arr[i]);
                count++;
            }
        }
        int[] newArr = new int[count];

        for (int i = 0; i < count; i++) {
            newArr[i] = tmpArray.get(i);
        }
        arr = newArr;
        // print out to confirm/debugging
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.print("\nLength of final array: " + arr.length);
        return count;
    }
}
