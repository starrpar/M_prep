package mprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {

        SimpleMethods simple = new SimpleMethods();
        ArrayMethods arrMethods = new ArrayMethods();
        TreeMethods treeMethods = new TreeMethods();

        // String methods (20%)
        String testStr = "a man, a plan, a canal, panama";
        simple.isPalindrome(testStr);

        // Dynamic Programming (and Recursive) methods (20%)
        int inputVal = 8;
        System.out.println("\n" + inputVal + "th Fibonacci: " + simple.calculateNthFibonacci(inputVal));

        // Array methods (20%)
        Integer[] testArray = { 1, 0, 2, 1, 2, 1, 0, 0, 2, 0, 1, 1, 2, 0, 2, 1, 2, 1, 2, 2, 0, 0, 2 };
        simple.moveZeroesMoreEfficient(testArray);

        int arrayLen = 100;
        int bnd = 100;
        int[] newIntArray = arrMethods.createRandomIntArray(arrayLen, bnd);
        int[] array0 = newIntArray.clone();
        System.out.println("\nNum primes: " + simple.countPrimes(array0));
        int[] array1 = newIntArray.clone();
        System.out.println("\nCount: " + simple.removeElementInPlace(array1, 8));

        Object[] array2 = new Object[newIntArray.length];
        for (int i = 0; i < newIntArray.length; i++) {
            array2[i] = (Object) newIntArray[i];
        }
        simple.countFrequencyOfElement(array2, (Object) 3);

        System.out.println("\nDuplicates removed: " + simple.removeDuplicates(array2));

        // Tree methods (15%)
        TreeMethods.BinaryTree tree = new TreeMethods.BinaryTree();
        List<Integer> treeList = new ArrayList<>();
        List<Integer> treeTraversalOutputList = new ArrayList<>();

        // for (int i = 0; i < testArray.length; i++) {
        // treeList.add(testArray[i]);
        // }
        for (int i = 0; i < array0.length; i++) {
            treeList.add(array0[i]);
        }

        System.out.println("\nBuild tree; treeList length: " + treeList.size());
        tree = treeMethods.buildTree(treeList);

        System.out.println("\nTraverse tree: ");
        treeMethods.traverseTree(tree.root);
        treeTraversalOutputList = treeMethods.binaryTreeToList(tree.root);
        System.out.print("\nOutput of binaryTreeToList:\n" + treeTraversalOutputList);
        System.out.println("\nOriginal array: ");
        for (int i = 0; i < array0.length; i++) {

            System.out.print(array0[i] + ", ");
        }

        // Graph methods (15%)

        // Search/Sort methods (10%)

        // LinkedList methods (4%)

        // Stack/Queue methods (2%)

        // runAllOthers();
    }

    static void runAllOthers() {
        ArrayMethods arrMethods = new ArrayMethods();
        DynamicProgrammingMethods dp = new DynamicProgrammingMethods();
        StringMethods strMethods = new StringMethods();

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

        String testStr1 = "a man, a plan, a canal, panama";
        String testStr2 = "rrrrrrrrrrrrrrrrrrrrr";
        String testStr3 = "a man, a plant, a canal, panama"; // 1 typo
        String testStr4 = "a man, a plant, a canall, panama"; // 2 typos
        String testStr5 = "a main, a plant, a canall, panama"; // 3 typos

        // simplest form - does not tolerate typos
        System.out.println("\nPalindrome1? " + strMethods.isPalindrome1(testStr1));

        // this one will only succeed with a single typo to correct
        // System.out.println("\nPalindrome2? " + strMethods.isPalindrome2(testStr5));
        // System.out.println("\n\n");

        // this version will succeed with having to cleanup up multiple typos (as long
        // as
        // they are not adjacent to one another - to include adjacent when mirrored)
        // System.out.println("\nPalindrome3? " + strMethods.isPalindrome3(testStr5));

        System.out.println("\nNum primes: " + arrMethods.countPrimes(arr1));

        // for (int i = 0; i < testArr2.length; i++) {
        // System.out.print(testArr2[i] + " ");
        // }
        // System.out.println(" ");
        // resultsArr = arrMethods.sumOfAllElementsPreviousToSpecified(testArr2);
        // for (int i = 0; i < resultsArr.length; i++) {
        // System.out.print(resultsArr[i] + " ");
        // }

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

        // int seqLen = arrMethods.findLongestIncreasingSequence(arr5, false);
        // System.out.println("\nLongestSequenceLength: " + seqLen);

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
