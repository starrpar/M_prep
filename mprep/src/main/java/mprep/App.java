package mprep;

import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {

        ArrayMethods arrMethods = new ArrayMethods();
        DynamicProgrammingMethods dp = new DynamicProgrammingMethods();

        System.out.println("\nFib: " + dp.calculateNthFibonacci(6));

        int arrayLength = 100;
        int bound = 100;
        int[] newIntArr = arrMethods.createRandomIntArray(arrayLength, bound);
        char[] newCharArr = arrMethods.createRandomCharArray(arrayLength);
        int[] arr1 = newIntArr.clone();
        int[] arr2 = newIntArr.clone();
        int[] arr5 = newIntArr.clone();
        int intArrLen = newIntArr.length;
        int charArrLen = newCharArr.length;
        Object[] arr3 = new Object[intArrLen];
        for (int i = 0; i < intArrLen; i++) {
            arr3[i] = (Object) newIntArr[i];
        }
        Object[] arr4 = new Object[charArrLen];
        for (int i = 0; i < charArrLen; i++) {
            arr4[i] = (Object) newCharArr[i];
            // System.out.print(arr4[i]);
        }

        // int[] testArr1 = { 1, 2, 2, 3, 4, 5, 5, 17, 1, 1 };
        int[] testArr2 = { 13, 2, 2, 3, 4, 5, 5, 17, 10, 11, 12, 13, 14, 15, 16, 17, 18 };
        long[] resultsArr = null;

        System.out.println("\nNum primes: " + arrMethods.countPrimes(arr1));

        for (int i = 0; i < testArr2.length; i++) {
            System.out.print(testArr2[i] + " ");
        }
        System.out.println(" ");
        resultsArr = arrMethods.sumOfAllElementsPreviousToSpecified(testArr2);
        for (int i = 0; i < resultsArr.length; i++) {
            System.out.print(resultsArr[i] + " ");
        }
        /*
         * List<Integer[]> lexiList =
         * fcns.getNextLexicographicalOutputOfArray(testArr2);
         * if (lexiList.size() <= 0) {
         * System.out.println("lexiList is empty");
         * }
         * for (int i = 0; i < lexiList.size(); i++) {
         * System.out.print("\n");
         * for (int j = 0; j < lexiList.get(i).length; j++) {
         * System.out.print(lexiList.get(i)[j] + " ");
         * }
         * }
         */

        int seqLen = arrMethods.findLongestIncreasingSequence(arr5, false);
        System.out.println("\nLongestSequenceLength: " + seqLen);

        // ************************************************************
        int val = 8;
        System.out.println("\nFirst - doesn't fix: ");
        int count = arrMethods.removeElementInPlace1(arr1, val);
        System.out.println("\n" + count);
        System.out.println("\nSecond - does fix: ");
        count = arrMethods.removeElementInPlace2(arr2, val);
        System.out.println("\n" + count);
        System.out.println("\n" + arrMethods.removeDuplicates(arr3));
        System.out.println("\n" + arrMethods.removeDuplicates(arr4));

        int numIntOccurrences = arrMethods.countFrequencyOfElement(arr3, (Object) 3);
        System.out.println("\nFrequency of number 3: " + numIntOccurrences);
        int expectedOccurrences = arrayLength / bound;
        System.out.println("number of expected \"random\" occurrences in array of int of length: " + arrayLength
                + " is: " + expectedOccurrences);
        if (numIntOccurrences > expectedOccurrences) {
            System.out.println(
                    "...so value is more common than expected, so \'randomeness\' is more liberal in this case");
        } else {
            System.out.println(
                    "...so value is less common than expected, so \'randomeness\' is more conservative in this case");
        }

        int numCharOccurrences = arrMethods.countFrequencyOfElement(arr4, (Object) 'c');
        System.out.println("\nFrequency of character \'c\': " + numCharOccurrences);
        expectedOccurrences = arrayLength / 52;
        System.out.println("number of expected \"random\" occurrences in array of char of length: " + arrayLength
                + " is: " + expectedOccurrences);
        if (numCharOccurrences > expectedOccurrences) {
            System.out.println(
                    "...so value is more common than expected, so \'randomeness\' is more liberal in this case");
        } else {
            System.out.println(
                    "...so value is less common than expected, so \'randomeness\' is more conservative in this case");
        }

        Integer[] testArr = { 0, 1, 2, 1, 0, 0, 2, 0, 1, 1, 2, 0, 2, 1, 2, 1, 2, 2, 0, 0, 2 };
        List<Integer> listArr = Arrays.asList(testArr);
        System.out.println("listArr: " + listArr);
        List<Integer> resultArr = arrMethods.moveZeroes(listArr);
        System.out.println("resultArr: " + resultArr);
        resultArr = arrMethods.moveZeroesMoreEfficient(testArr);
        System.out.println("resultArr: " + resultArr);

    }
}
