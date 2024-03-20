package mprep;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class ArrayMethods {

    Object findMinElement(Object[] arr) {
        // this could be by numeric value only, or using ascii as integer values
        // equivalent to findMaxElement()

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
        int num = 0;
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
