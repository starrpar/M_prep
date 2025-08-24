package mprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mprep.TreeMethods.BinaryTree;
import mprep.TreeMethods.CharNode;

public class SimpleMethods {

    int[] allocations = new int[65536]; // presuming initialized to 0

    int alloc() {
        for (int i = 0; i < allocations.length; i++) {
            if (allocations[i] <= 0) {
                allocations[i] = 1;
                return i;
            }
        }

        return -1;
    }

    void free(int freed) {
        allocations[freed] = 0;
    }

    // public static void main(String[] args) {

    // // String str = "a man, a plan, a canal, panama";
    // // String str = "abbcca";
    // // String str = "aa";
    // // String str = "aaa";
    // // String str = "abba";
    // String str = "abbcaacdda";
    // // String str = "aba";

    // removeSequences(str); //version I was working on during interview
    // }

    // Example expected functionalities:
    // "aa" -> ""
    // "aaa" -> ""
    // "abba" -> "aa" -> ""
    // "aab" -> "b"
    // "aba" -> "aba"

    String removeSequencesUsingRegEx(String s) {

        // String regex = "[a-z]{2,}";
        // String regex = "/a$";
        // String regex = "([a-z]){2,}";
        String regex = "(\\w)\\1+";
        // String regex = "(\\w){2,}";

        System.out.println(s);

        s = s.replaceAll(regex, "");

        System.out.println(s);

        return s;
    }

    String removeSequences(String s) {

        // NOTE: This is the brute force method I was initially pursuing during the
        // interview - works now that is completed

        // base case - do not process or recurse further when nothing to act on
        if (s == "")
            return s;

        // clean up string first (could use RegEx)
        s = s.replaceAll("\\s", "").replaceAll("\\t", "").replaceAll(",", "").toLowerCase();
        char[] cArr = s.toCharArray();
        String newStr = "";

        for (int i = 0; i < s.length(); i++) {
            int start = 0;
            int end = 0;
            boolean notYet = true;
            for (int j = i; j < cArr.length - 1 - i; j++) {
                if (cArr[j] == cArr[j + 1]) {
                    if (notYet) {
                        start = j;
                        notYet = false;
                    }
                    end = j + 1;
                }
            }

            if (!s.isEmpty() && (start != 0 || end != 0)) {
                newStr = s.substring(0, start) + s.substring(end + 1, s.length());
            }

            if (end != 0) {
                break;
            }
        }

        if (newStr != "") {
            return removeSequences(newStr);
        }
        return s;
    }

    boolean isPalindrome(String s) {
        String tempStr = s.toLowerCase().replaceAll("\\s", "").replaceAll(",", "");

        char[] cArr = tempStr.toCharArray();

        for (int i = 0; i < tempStr.length(); i++) {
            if (cArr[i] != cArr[(tempStr.length() - 1) - i]) {
                return false;
            }
        }
        return true;
    }

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

    public int removeElementInPlace(int[] arr, int val) {
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

    public int countFrequencyOfElement(Object[] arr, Object val) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                arr[count++] = arr[i];
            }
        }

        return count;
    }

    // #region Fibonacci
    int calculateNthFibonacci(int n) {
        return fibo(n);
    }

    //NOTE: this method is incorrect...
    int fibo(int n) {
        int fibAns = 0;

        if (n <= 1) {
            return n;
        }

        for (int i = 2; i <= n; i++) {
            fibAns = fibo(n - 1) + fibo(n - 2);
        }
        return fibAns;
    }
    // #endregion
}
