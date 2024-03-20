package mprep;

public class App {

    public static void main(String[] args) {

        System.out.println("Hello world!");

        ArrayMethods fcns = new ArrayMethods();

        int arrayLength = 50;
        int bound = 10;
        int[] newIntArr = fcns.createRandomIntArray(arrayLength, bound);
        int[] arr1 = newIntArr.clone();
        int[] arr2 = newIntArr.clone();
        // int[] arr1 = { 1, 2, 2, 3, 4, 5, 5, 1, 1 };
        // int[] arr2 = { 1, 2, 2, 3, 4, 5, 5, 1, 1 };
        int val = 8;
        System.out.println("\nFirst - doesn't fix: ");
        int count = fcns.removeElementInPlace1(arr1, val);
        System.out.println("\n" + count);
        System.out.println("\nSecond - does fix: ");
        count = fcns.removeElementInPlace2(arr2, val);
        System.out.println("\n" + count);
    }
}
