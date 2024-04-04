package mprep;

import java.util.List;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

public class ArrayMethods {

    // Object findMinElement(Object[] arr) {
    // // this could be by numeric value only, or using ascii as integer values
    // // equivalent to findMaxElement()

    // }

    // EASY:
    // [SKIP] ----merge 2 sorted arrays
    // DONE: -----remove dupes from an array--
    // DONE: -----count frequency of element in array--
    // << ??? >> -two sum
    // [SKIP] ----find min/max element in array
    // [SKIP] ----remove dupes from sorted array
    // DONE: -----remove element in-place (pass array by ref)--
    // [SKIP] ----search insert position
    // << NEXT >> max subarray
    // << ??? >> -plus one
    // << NEXT >> convert sorted array to binary search tree
    // [SKIP] ----single number
    // DONE: -----count primes--
    // DONE: -----contains dupe--
    // [SKIP] ----third largest num
    // [SKIP] ----count odd/even

    // MEDIUM:
    // DONE: -----move all zeros to beginning/end of array--
    // << NEXT >> find if given element is in a sorted array (binary search)
    // [SKIP] ----rotate array
    // << NEXT >> largest sum of non-adjacent numbers (dynamic programming)
    // << ??? >> -product array puzzle
    // << NEXT >> max product subarray (dynamic programming)
    // << NEXT >> shortest unsorted continuous subarray
    // << ??? >> -max sum of hour glass in matrix
    // << ??? >> -paint house (dynamic programming)
    // << NEXT >> min number of jumps to reach end
    // << NEXT >> find dupes in O(n) time and O(1) extra space
    // << NEXT >> find 3 numbers with max product
    // << ??? >> -max sum circular subarray
    // << NEXT >> min number swaps to sort array

    // HARD:
    // << NEXT >> rotate 2D array
    // << NEXT >> create change with coins
    // << NEXT >> sliding window max
    // << NEXT >> find smallest positive number missing from unsorted array
    // << NEXT >> find missing number in ordered arithmetic progression
    // << ??? >> -find max j-1, such that arr[j] > arr[i] (distance maximizing
    // problem)
    // << ??? >> -array manipulation
    // << ??? >> -median of 2 sorted arrays
    // << NEXT >> sudoku solver
    // << ??? >> -largest rectangle in a histogram
    // << ??? >> -max rectangle in binary matrix
    // << NEXT >> find min in rotated sorted array
    // << ??? >> -count of smaller numbers after self
    // << ??? >> -palindrome pairs
    // << NEXT >> sort an array containing 0's, 1's and 2's
    // << NEXT >> longest increasing subsequence
    // << ??? >> -trapping rain water

    // longest increasing subsequence
    // find longest continuously increasing sequence
    // per requirements, does NOT have to be continuous
    int findLongestIncreasingSequence(int[] nums, boolean first) {
        // create container to hold "sub-sequences"
        // don't know how many will exist (meaning will be determined only in the end)
        // (for example, could start towards the end and be longer than any other
        // heretofore)
        // could keep only "2 longest" - and if a new longer one comes in, just drop the
        // 2nd longest
        // thereby still keeping the 2 longest by having the new one and the previously
        // longest ones
        // so could just use a KVP with keys 1 and 2, and values are List<Integer> that
        // could be
        // converted back to int[] once complete.

        if (first) {

            // understand how this progresses, but do not follow how that yields only a
            // continuously increasing sub-sequence...
            // also seems like there are errors in where it suggests inserting values
            // in the binary search tree

            List<Integer> piles = new ArrayList<>(nums.length);
            System.out.println("\n" + nums.length);
            for (int num : nums) {
                int pile = Collections.binarySearch(piles, num); // search for value at current array index
                System.out.println("pile: " + pile);
                if (pile < 0) // if failed to find, then value will be < 0 representing the point at which the
                              // value would be inserted into the tree
                    pile = ~pile; // bitwise invert (make the value positive and one less, so -19 becomes +18)
                // System.out.println("(tilde)pile: " + pile);
                if (pile == piles.size()) {
                    piles.add(num); // if value is size of list, indicates all list contents are less than value, so
                                    // simply add to end of list
                } else {
                    piles.set(pile, num); // otherwise, insert value at indicated insertion point from above
                }
            }
            System.out.println(piles.size());
            return piles.size(); // somehow, total size of all values inserted equals size of increasing
                                 // subsequence
            // Q: what happens if value is same as another (dupe)?
            // Q: this (tree insertion) does not account for order in the array listing
        } else {

            // alternate approach

            int[] tails = new int[nums.length];
            int size = 0;
            for (int num : nums) { // go through array
                int i = 0, j = size; // initialize i, j => 0
                while (i != j) { // check if i == j
                    int m = (i + j) / 2;// take the average of i & j (note this is int division, so uses floor -- i.e.
                                        // (2 + 3)/2 = 5/2 = 2.5 = 2)
                    if (tails[m] < num) // if the value in tails[(i+j)/2] is less than the value at the current array
                                        // index
                        i = m + 1; // then increment i to m+1 (int(i+j)/2) + 1)
                    else
                        j = m; // or, if value at current array index is equal or greater than tails[(i+j)/2],
                    System.out.println("i,j,m: " + i + "," + j + "," + m); // then increment j to m
                }
                System.out.println("\ninsert into tails at i: " + num);
                tails[i] = num; // once while is satisfied (i == j), then set tails[i] to the value at current
                                // array index
                if (i == size) {
                    ++size; // increment value of size if i has reached that value
                    System.out.println("increment size: " + size);
                }

            }
            return size;

        }

        /*
         * Map<Integer, List<Integer>> kvp = new HashMap<>();
         * List<Integer> list1 = new ArrayList<>();
         * List<Integer> list2 = new ArrayList<>();
         * List<Integer> swapList = new ArrayList<>();
         * 
         * List<Integer> tmpList = new ArrayList<>();
         * 
         * // initiate first 2 lists for comparison of sequence length with first 2
         * values
         * // in array
         * list1.add(arr[0]);
         * kvp.put(1, list1);
         * list2.add(arr[1]);
         * kvp.put(2, list2);
         * 
         * System.out.println();
         * System.out.println(kvp.get(1));
         * System.out.println(kvp.get(2));
         * 
         * // index through array
         * boolean used = false;
         * // for (int i = 2; i < arr.length; i++) {
         * // if (arr[i] > kvp.get(1).get(kvp.get(1).size() - 1)) {
         * // // System.out.println(arr[i]);
         * // kvp.get(1).add(arr[i]);
         * // used = true;
         * // }
         * // if (arr[i] > kvp.get(2).get(kvp.get(2).size() - 1)) {
         * // // System.out.println(arr[i]);
         * // kvp.get(2).add(arr[i]);
         * // used = true;
         * // }
         * // if ((arr[i] != kvp.get(1).get(kvp.get(1).size() - 1) &&
         * // arr[i] != kvp.get(2).get(kvp.get(2).size() - 1)) &&
         * // swapList.size() > 0 &&
         * // arr[i] > swapList.get(swapList.size() - 1)) {
         * // swapList.add(arr[i]);
         * // System.out
         * // .println("adding... i: " + i + ", " + arr[i] + ", "
         * // + (kvp.get(1).get(kvp.get(1).size() - 1)).toString()
         * // + ", " + (kvp.get(2).get(kvp.get(2).size() - 1)).toString());
         * // used = true;
         * // }
         * // if ((arr[i] != kvp.get(1).get(kvp.get(1).size() - 1) &&
         * // arr[i] != kvp.get(2).get(kvp.get(2).size() - 1)) &&
         * // !used) {
         * // swapList.add(arr[i]);
         * // System.out.println("adding to empty list... not used: " + i + ", " +
         * arr[i]);
         * // used = false;
         * // }
         * // }
         * System.out.println(kvp.get(1));
         * for (int i = 2; i < arr.length; i++) {
         * for (int j = 1; j < i; j++) {
         * if (arr[i] == kvp.get(1).get(kvp.get(1).size() - 1) + 1) {
         * kvp.get(1).add(arr[i]);
         * System.out.println("i: " + i + ", arr[i]: " + arr[i] + "... " + kvp.get(1));
         * }
         * }
         * }
         * 
         * System.out.println(kvp.get(1));
         * System.out.println(kvp.get(2));
         * System.out.println(swapList);
         * 
         * if (kvp.get(1).size() > kvp.get(2).size()) {
         * if (swapList.size() > kvp.get(1).size()) {
         * tmpList = swapList;
         * kvp.put(1, swapList);
         * if (swapList.size() > kvp.get(2).size()) {
         * kvp.put(2, kvp.get(1));
         * } else {
         * swapList = kvp.get(2);
         * }
         * } else {
         * tmpList = kvp.get(1);
         * // kvp.put(1, kvp.get(1)); //implicit - redundant
         * if (swapList.size() > kvp.get(2).size()) {
         * kvp.put(2, swapList);
         * }
         * // else {
         * // kvp.put(2, kvp.get(1)); //implicit - redundant
         * // }
         * }
         * } else {
         * if (swapList.size() > kvp.get(2).size()) {
         * tmpList = swapList;
         * kvp.put(1, swapList);
         * kvp.put(2, swapList);
         * swapList = kvp.get(1);
         * } else {
         * tmpList = kvp.get(2);
         * kvp.put(1, kvp.get(2));
         * if (swapList.size() > kvp.get(1).size()) {
         * kvp.put(2, swapList);
         * swapList = kvp.get(1);
         * } else {
         * kvp.put(2, kvp.get(1));
         * // swapList = swapList; //implicit - redundant
         * }
         * }
         * }
         * 
         * int[] tmpArr = new int[tmpList.size()];
         * 
         * for (int i = 0; i < tmpList.size(); i++) {
         * tmpArr[i] = tmpList.get(i);
         * System.out.print(tmpArr[i] + " ");
         * }
         * 
         * return tmpArr;
         */
    }

    // ALSO...
    // Given an array nums of n integers where n > 1, return an array output such
    // that output[i] is equal to the product of all the elements of nums except
    // nums[i] - see sumOfAllElementsPreviousToSpecified() below...

    long[] sumOfAllElementsPreviousToSpecified(int[] arr) throws InvalidParameterException {
        long product = 1L; // product, not sum, so start with 1 as identity
        long[] products = new long[arr.length];

        for (int i = 0; i < arr.length; i++) {
            product = 1L;
            if (arr[i] > 1) {
                for (int j = 0; j < arr.length; j++) {
                    if (j != i) {
                        product *= arr[j];
                    }
                }
            } else {
                throw new InvalidParameterException("Invalid input value: " + arr[i] + " <= 1");
            }
            products[i] = product;
        }

        return products;
    }

    // this is the brute force O(n^2) version I was trying during the interview
    List<Integer> moveZeroes(List<Integer> arr) {
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
    List<Integer> moveZeroesMoreEfficient(Integer[] arr) {
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
        // or could just keep count of how many zeroes to add back,
        // then simply run a loop for that count and use "newArr.add(0);"

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
                    isdivisible = false; // redundantSt

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
            System.out.print(arr[i] + ",");
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
            System.out.print(arr[i] + ",");
        }
        System.out.print("\nLength of final array: " + arr.length);
        return count;
    }

    // ALSO:
    // Implement next permutation, which rearranges numbers into the
    // lexicographically next greater permutation of numbers.

    // A permutation of an array of integers is an arrangement of its members into a
    // sequence or linear order.

    // For example, for arr = [1,2,3], the following are all the permutations of
    // arr:
    // [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
    // The next permutation of an array of integers is the next lexicographically
    // greater permutation of its integer. More formally, if all the permutations
    // of the array are sorted in one container according to their lexicographical
    // order,
    // then the next permutation of that array is the permutation that follows it in
    // the
    // sorted container. If such arrangement is not possible, the array must be
    // rearranged
    // as the lowest possible order (i.e., sorted in ascending order).

    // For example, the next permutation of arr = [1,2,3] is [1,3,2].
    // Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
    // While the next permutation of arr = [3,2,1] is [1,2,3] because
    // [3,2,1] does not have a lexicographical larger rearrangement.
    // Given an array of integers nums, find the next permutation of nums.

    // The replacement must be in-place and use only constant extra memory.

    // Example 1:
    // Input: nums = [1,2,3]
    // Output: [1,3,2]

    // Example 2:
    // Input: nums = [3,2,1]
    // Output: [1,2,3]

    // Example 3:
    // Input: nums = [1,1,5]
    // Output: [1,5,1]

    // NOTES: this is not finished yet - logic is not implemented for parsing
    // array(s)
    List<Integer[]> getNextLexicographicalOutputOfArray(int[] arr) {
        // logic: the idea is to start with the lowest numbers from the first position
        // (0th) and similarly
        // throughout the rest of the array; following that initial sorted arrangement,
        // each "next step" will
        // simply involve allowing the "next highest sorted" set of values occupy all
        // positions in a sorted
        // manner, until ultimately the order consists of the highest values from the
        // beginning of the array
        // and throughout, which will be the last position. The next lexicographical
        // value after that is to
        // wrap back to the first.

        // given the array, sort it in lexicographical order
        System.out.print("\n");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        List<Integer[]> orderArrayList = sortArrayLexicographically(arr);

        // based on what was initially provided (input parameter), provide in return the
        // next progression (permutation)
        // from that lexicographically ordered list

        // return orderArrayList.get(0);
        return orderArrayList;
    }

    List<Integer[]> sortArrayLexicographically(int[] arr) {
        int arrLength = arr.length;
        Map<Integer, Integer> valueMap = new HashMap<Integer, Integer>();
        List<Integer[]> retVal = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (valueMap.get(arr[i]) == null) {
                System.out.println("\nadding initial entry: " + arr[i]);
                valueMap.put(arr[i], 1);
            } else {
                System.out
                        .println("\nupdating entry: " + arr[i] + ", with new value of: " + (valueMap.get(arr[i]) + 1));
                valueMap.put(arr[i], (valueMap.get(arr[i]) + 1)); // increment already existing by 1
            }
        }
        Integer[] tmpArr = new Integer[arrLength];
        List<Integer> tmpList = new ArrayList<>();
        // now construct a listing of possible enumerations / permutations from the
        // listing extracted from the input array
        for (int i = 0; i < arrLength; i++) {
            // int tmpInt = valueMap.get(arr[i]);
            // if (tmpInt >= arrLength) {
            // for (int j = 0; j < arrLength; j++) {
            // tmpList.add(arr[i]); // will be full here
            // }
            // } else {
            for (int j = 0; j < 1; j++) {
                tmpList.add(arr[i]); // will be partial here
            }
            // }
            for (int j = 0; j < arr.length; j++) {
                System.out.println(tmpList);
            }
            // tmpList will be empty otherwise

            // at this point, tmpList is either empty, or has some entries, or is full (of
            // length arrLength)
            // now have to do bookkeeping to ensure all values are used and none are missed

            // just to mention, same values for each entry is one, and only one
            // lexicographic representation
            // i.e. there is not "rearranging" the same values and having a different set...
            // for example, if the following array was sent in [1, 1, 1] that would be the
            // only lexicographic
            // order/arrangement to be done - there are no other "variations" - the number
            // have to differ for
            // that to be the case...
        }
        for (int i = 0; i < 100; i++) {
            System.out.print("\n");
            if (tmpList.size() == arrLength) {
                for (int j = 0; j < tmpList.size(); j++) {
                    tmpArr[j] = tmpList.get(j);
                    // System.out.println(tmpArr[j]);
                }
                retVal.add(tmpArr);
            }
            // else {
            // for (int j = 0; j < arr.length; j++) {
            // System.out.println(tmpList);
            // }
            // }
        }
        return retVal;
    }

    // maybe someday...

    // Given an array of N non-negative integers arr[] representing an elevation map
    // where
    // the width of each bar is 1, compute how much water it is able to trap after
    // raining.

    // Examples:

    // Input: arr[] = {2, 0, 2}
    // Output: 2
    // Explanation: The structure is like below.
    // We can trap 2 units of water in the middle gap.

}

// EASY:
// 1.1 Merge two sorted arrays
// Text guide (GeeksforGeeks)
// Video guide (TECH DOSE)
// 1.2 Remove duplicates from an array
// Video guide (Kevin Naughton Jr.)
// Text guide (W3Schools)
// Text guide (Javarevisted)
// Code example (LeetCode)
// 1.3 Count the frequency of an element in an array
// Text guide (GeeksforGeeks)
// Video guide (SDET)
// 1.4 Two sum
// Text guide (Codeburst)
// Video guide (Kevin Naughton Jr.)
// 1.5 Find the minimum (or maximum) element of an array
// Text guide (Enjoy Algorithms)
// Text guide (After Academy)
// Video guide (GeeksforGeeks)
// 1.6 Remove duplicates from sorted array
// Text guide (Redquark)
// Video guide (Kevin Naughton Jr.)
// Video guide (Take u Forward)
// 1.7 Remove element in-place
// Text guide (Redquark)
// Video guide (Nick White)
// Code example (LeetCode)
// 1.8 Search Insert Position
// Text guide (GeeksforGeeks)
// Text guide (Codesdope)
// Video guide (NeetCode)
// 1.9 Maximum Subarray
// Text guide (Wikipedia)
// Text guide (Techie Delight)
// Video guide (CS Dojo)
// 1.10 Plus One
// Text guide (Medium/Punitkmryh)
// Video guide (Kevin Naughton Jr.)
// Video guide (Back to Back SWE)
// 1.11 Convert Sorted Array to Binary Search Tree (Arrays/Binary Trees)
// Text guide (GeeksForGeeks)
// Video guide (Kevin Naughton Jr)
// 1.12 Single Number
// Text guide (Akhilpokle)
// Video guide (Kevin Naughton Jr)
// Video guide (TECH DOSE)
// 1.13 Count Primes
// Text guide (GeeksForGeeks)
// Video guide (Terrible Whiteboard)
// 1.14 Contains Duplicate
// Text guide (Medium/Punitkmryh)
// Video guide (Terrible Whiteboard)
// Code example (LeetCode)
// 1.15 Third Largest Number
// Text guide (GeeksForGeeks)
// Video guide (Terrible Whiteboard)
// 1.16 Count Odd Even
// Text guide (W3resource)
// Text guide (GeeksForGeeks)
// Video guide (Technotip)

// MEDIUM:
// 2.1 Move all zeros to the beginning/end of an array
// Text guide (Educative)
// Video guide (Programming tutorials)
// Code example (LeetCode)
// 2.2 Find if a given element is in a sorted array (binary search)
// Text guide (Khan academy)
// Video guide (HackerRank)
// Code example (LeetCode)
// 2.3 Rotate an array
// Text guide (GeeksforGeeks)
// Video guide (Nick White)
// Code example (LeetCode)
// 2.4 Largest sum of non-adjacent numbers (Dynamic Programming)
// Text guide (Medium/Arun Kumar)
// Text guide (GeeksForGeeks)
// Video guide (Coding Simplified)
// 2.5 A Product Array Puzzle
// Text guide (TutorialCup)
// Text guide (Akhilpokle)
// Video guide (Nick White)
// 2.6 Maximum Product Subarray (Dynamic programming)
// Text guide (Techie Delight)
// Video guide (NeetCode)
// Video guide (Back to Back SWE)
// 2.7 Shortest Unsorted Continuous Subarray
// Text guide (GeeksForGeeks)
// Text guide (Seanpgallivan)
// Video guide (Nick White)
// 2.8 Maximum sum of hour glass in matrix
// Text guide (GeeksforGeeks)
// Video guide(Over The Shoulder Coding)
// 2.9 Paint House (Dynamic programming)
// Text guide (ProgrammerSought)
// Video guide (NeetCode)
// 2.10 Minimum number of jumps to reach end
// Text guide (Medium/Himanshu)
// Video guide (Nick White)
// 2.11 Find duplicates in O(n) time and O(1) extra space
// Text guide (GeeksForGeeks)
// Video guide (Nick White)
// 2.12 Find three numbers with the maximum product
// Text guide (Techie Delight)
// Video guide (Programmer Mitch)
// 2.13 Maximum Sum Circular Subarray
// Text Guide (Techie Delight)
// Video Guide (TECH DOSE)
// 2.14 Minimum number of swaps to sort an array
// Text guide (GeeksForGeeks)
// Video guide (Brian Dyck)

// HARD:
// 3.1 Rotate a 2D array
// Text guide (Jack)
// Text guide (GeeksforGeeks)
// Video guide (Nick White)
// 3.2 Create change with coins (dynamic programming)
// Text guide (Educative)
// Video guide (Back to Back SWE)
// 3.3 Sliding window maximum
// Text guide (After Academy)
// Video guide (Jessica Lin)
// 3.4 Find the smallest positive number missing from an unsorted array
// Text guide (Codes Dope)
// Video guide (Michael Muinos)
// 3.5 Find the missing number in unordered Arithmetic Progression
// Text guide (GeeksForGeeks)
// 3.6 Find the maximum j – i such that arr[j] > arr[i] (Distance maximising
// problem)
// Text guide (GeeksForGeeks)
// Text guide (Techie Delight)
// Video guide (Genetic Coders)
// 3.7 Array manipulation
// Text guide (The Poor Coder)
// Video guide (Brian Dyck)
// 3.8 Median of Two Sorted Arrays
// Text guide (GeeksForGeeks)
// Video guide (Take u Forward)
// Code example (LeetCode)
// 3.9 Sudoku Solver
// Text guide (After Academy)
// Video guide (Back To Back SWE)
// Code example (LeetCode)
// 3.10 Largest Rectangle in Histogram
// Text guide (After Academy)
// Video guide (TECH DOSE)
// 3.11 Maximal Rectangle in binary matrix
// Text guide (GeeksForGeeks)
// Video guide (TECH DOSE)
// 3.12 Find Minimum in Rotated Sorted Array
// Text guide (Algorithmsandme)
// Video guide (Nick White)
// 3.13 Count of Smaller Numbers After Self
// Text guide (CodeStudio)
// Text guide (GeeksForGeeks)
// Video guide (Happygirlzt)
// 3.14 Palindrome Pairs
// Text guide (Seanpgallivan)
// Video guide (Happygirlzt)
// 3.15 Sort an array containing 0’s, 1’s and 2’s
// Text guide (Techie Delight)
// Text guide (GeeksForGeeks)
// Video guide (Take u Forward)
// Video guide (Back To Back SWE)
// 3.16 Longest increasing subsequence
// Text guide (GeeksForGeeks)
// Video guide (Back To Back SWE)
// Code example (LeetCode)
// 3.17 Trapping Rain Water
// Text guide (GeeksForGeeks)
// Video guide (Take u Forward)
// Code example (LeetCode)