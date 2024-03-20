package mprep;

public class App {

    public static void main(String[] args) {

        ArrayMethods fcns = new ArrayMethods();

        int arrayLength = 4000;
        int bound = 10;
        int[] newIntArr = fcns.createRandomIntArray(arrayLength, bound);
        char[] newCharArr = fcns.createRandomCharArray(arrayLength);
        int[] arr1 = newIntArr.clone();
        int[] arr2 = newIntArr.clone();
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

        // int[] arr1 = { 1, 2, 2, 3, 4, 5, 5, 1, 1 };
        // int[] arr2 = { 1, 2, 2, 3, 4, 5, 5, 1, 1 };

        int val = 8;
        System.out.println("\nFirst - doesn't fix: ");
        int count = fcns.removeElementInPlace1(arr1, val);
        System.out.println("\n" + count);
        System.out.println("\nSecond - does fix: ");
        count = fcns.removeElementInPlace2(arr2, val);
        System.out.println("\n" + count);
        System.out.println("\n" + fcns.removeDuplicates(arr3));
        System.out.println("\n" + fcns.removeDuplicates(arr4));

        int numIntOccurrences = fcns.countFrequencyOfElement(arr3, (Object) 3);
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

        int numCharOccurrences = fcns.countFrequencyOfElement(arr4, (Object) 'c');
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
    }
}
