package mprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {

    public static void main(String[] args) {

        // *****************************************
        // New...
        //
        // *****************************************
        CostcoPrep costcoPrep = new CostcoPrep();

        String anotherString = "7777889778888899999";
        Long anotherStringL = 7777889778888899999L;
        System.out.println("countSequentialOccurrences1: " + costcoPrep.countSequentialOccurrences1(anotherString));
        Long tmpL = costcoPrep.countSequentialOccurrences2(anotherStringL);
        System.out.println("countSequentialOccurrences2: " + tmpL.toString());

        String testStr1 = "A man, a plan, a canal; Panama";
        System.out.println(testStr1 + ": " + costcoPrep.newIsPalindrome(testStr1));

        long startTime = 0L;
        long endTime = 0L;
        long duration = 0L;

        int[] nums1 = { 3, 2, 3, 2, 2, 2 };
        startTime = System.nanoTime();
        System.out.println("divideArray: " + costcoPrep.divideArray(nums1));
        endTime = System.nanoTime();
        duration = (endTime - startTime); // divide by 1000000 to get milliseconds.
        System.out.println("nums1 perf: " + duration / 1000000);

        int[] nums2 = { 1, 2, 3, 4 };
        startTime = System.nanoTime();
        System.out.println("divideArray: " + costcoPrep.divideArray(nums2));
        endTime = System.nanoTime();
        duration = (endTime - startTime); // divide by 1000000 to get milliseconds.
        System.out.println("nums2 perf: " + duration / 1000000);

        // int[] nums3 =
        // {477,160,331,170,486,443,295,318,476,409,344,299,471,155,401,13,56,141,445,360,230,78,404,137,187,45,446,120,455,428,137,73,458,137,56,256,327,418,185,104,432,403,42,120,229,151,457,269,406,324,127,405,267,360,409,409,489,231,263,470,112,78,285,295,311,302,435,137,464,389,427,372,453,83,56,137,370,84,46,86,231,231,52,97,436,95,45,323,201,60,106,263,104,333,451,256,50,145,295,142,295,424,226,496,303,349,295,467,136,143,209,449,122,46,13,380,464,156,45,103,254,377,52,24,464,180,427,120,379,172,103,190,486,478,363,358,342,325,264,319,341,14,120,453,309,344,10,498,226,454,161,353,500,458,112,21,214,458,218,19,363,96,470,212,220,246,451,357,105,35,143,465,462,487,227,499,13,24,385,229,151,50,246,226,192,420,61,192,66,436,227,316,136,105,221,127,117,473,486,97,3,19,127,115,202,12,341,417,325,427,299,321,170,303,303,498,304,135,435,268,415,269,282,464,128,395,208,61,172,297,83,93,71,105,477,390,175,223,35,134,161,327,323,427,212,219,256,308,388,355,261,114,316,151,220,249,406,352,208,156,185,83,421,155,489,41,342,84,396,385,370,110,77,476,220,360,416,138,94,19,172,495,97,275,462,225,355,460,205,292,170,467,267,173,326,97,445,421,373,134,194,382,129,3,41,313,164,160,357,41,127,132,396,276,172,180,185,219,65,315,24,158,356,401,105,269,416,7,125,156,215,331,454,78,443,279,153,344,312,316,178,239,162,229,55,390,311,65,97,122,138,370,400,405,187,236,446,311,129,379,21,352,249,206,229,190,297,71,337,175,310,327,205,419,202,264,304,96,310,288,183,170,215,227,85,209,467,32,398,217,269,80,250,175,346,416,375,51,418,312,267,158,145,80,61,35,229,78,380,347,226,416,131,256,453,229,456,327,62,233,365,369,217,327,308,234,82,487,406,467,170,324,411,269,431,83,115,395,255,251,264,215,313,285,216,249,298,275,202,160,61,212,184,500,128,348,256,358,108,382,352,217,216,459,51,375,147,82,111,467,370,147,303,239,156,30,172,33,106,462,148,463,136,209,495,33,286,117,145,356,473,54,360,110,192,282,325,217,93,170,427,500,432,131,233,158,406,13,239,141,427,436,464,323,388,312,94,142,355,265,267,325,12,275,222,445,255,22,377,139,105,223,174,321,250,365,104,499,185,66,458,177,111,388,436,495,498,412,489,85,5,419,357,500,417,223,348,459,287,22,206,71,364,141,348,43,39,430,498,335,225,487,465,405,318,374,387,464,251,114,288,14,412,345,178,86,377,174,236,66,385,326,104,55,251,406,85,254,251,135,279,77,151,455,221,316,400,446,30,347,220,47,178,5,443,285,236,221,54,125,431,19,282,396,464,309,344,264,236,132,85,180,132,304,357,156,379,309,162,285,220,329,137,239,5,65,265,256,39,418,479,341,329,471,446,458,424,390,171,465,139,122,148,47,464,403,21,379,26,199,323,158,412,127,304,353,404,8,286,455,396,403,344,453,170,329,398,41,115,346,413,156,21,147,298,437,177,349,221,418,222,127,390,177,132,341,462,146,171,455,369,251,437,261,496,303,374,173,227,180,212,379,42,71,420,218,175,282,263,387,372,35,122,318,183,10,379,478,61,263,268,177,373,312,250,355,47,141,486,110,269,223,487,110,145,292,460,403,391,43,327,391,405,199,458,337,164,428,285,178,160,5,409,47,228,287,302,465,467,350,251,377,282,411,395,445,170,56,61,160,21,387,239,267,285,344,415,225,160,463,275,65,358,295,45,296,95,443,348,234,225,406,92,7,279,65,282,202,230,21,352,405,108,495,106,333,385,315,209,136,457,24,92,147,32,26,430,106,250,209,467,489,95,413,231,145,201,97,220,65,215,479,459,329,459,115,449,345,319,276,303,340,228,92,60,162,364,350,267,162,73,92,456,388,8,395,209,387,239,467,95,318,172,385,249,385,62,309,105,389,194,296,279,412,145,214,192,340,358,184,311,146,405,66,335,153};
        // startTime = System.nanoTime();
        // System.out.println("divideArray: " + costcoPrep.divideArray(nums3));
        // endTime = System.nanoTime();
        // duration = (endTime - startTime); //divide by 1000000 to get milliseconds.
        // System.out.println("nums3 perf: " + duration/1000000);

        String strA = "()";// true
        String strB = "())";// false
        String strC = "(())";// true
        String strD = "(()";// false
        String strE = ")(";// false

        String strA2 = "({})";// true
        String strB2 = "({}))";// false
        String strC2 = "((}{}))";// false
        String strD2 = "({)}";// false
        String strE2 = "{()}";// true

        System.out.println("validParentCheck: " + costcoPrep.ValidParenCheck(strA));
        System.out.println("validParentCheck: " + costcoPrep.ValidParenCheck(strB));
        System.out.println("validParentCheck: " + costcoPrep.ValidParenCheck(strC));
        System.out.println("validParentCheck: " + costcoPrep.ValidParenCheck(strD));
        System.out.println("validParentCheck: " + costcoPrep.ValidParenCheck(strE));

        System.out.println("validParentCheck: " + costcoPrep.NORDValidParenCheck(strA2));
        System.out.println("validParentCheck: " + costcoPrep.NORDValidParenCheck(strB2));
        System.out.println("validParentCheck: " + costcoPrep.NORDValidParenCheck(strC2));
        System.out.println("validParentCheck: " + costcoPrep.NORDValidParenCheck(strD2));
        System.out.println("validParentCheck: " + costcoPrep.NORDValidParenCheck(strE2));

        // recursion algorithms

        int maxVal = 13;
        for (int i = 0; i < maxVal; i++) {
            System.out.println("Debugging - Fibonacci for " + i + ": " + costcoPrep.Fibonacci(i));
        }

        int c_N = 10;
        int[] nums = costcoPrep.storeUpToNWithoutLooping(c_N);
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Debugging - entry : " + i + ": " + nums[i]);
        }

        c_N = 10;
        System.out.println("Debugging - addUp values to N: " + c_N + "..." + costcoPrep.addUpToNWithoutLooping(c_N));

        // reverse linked list using recursion

        String s1 = "This";
        String s2 = "is";
        String s3 = "sentence";
        String s4 = "with";
        String s5 = "no";
        String s6 = "spaces";

        LList ll = new LList(s1);
        System.out.println("1: " + ll.getSize());
        LListNode lln1 = new LListNode(s2);
        ll.navigateThroughNextAndAddNode(lln1);
        System.out.println("2: " + ll.getSize());
        LListNode lln2 = new LListNode(s3);
        ll.navigateThroughNextAndAddNode(lln2);
        System.out.println("3: " + ll.getSize());
        LListNode lln3 = new LListNode(s4);
        ll.navigateThroughNextAndAddNode(lln3);
        System.out.println("4: " + ll.getSize());
        LListNode lln4 = new LListNode(s5);
        ll.navigateThroughNextAndAddNode(lln4);
        System.out.println("5: " + ll.getSize());
        LListNode lln5 = new LListNode(s6);
        ll.navigateThroughNextAndAddNode(lln5);
        System.out.println("6: " + ll.getSize());

        System.out.println(ll.getHead().getItem().toString());
        ll.setCurrentNodeToHead();
        while (ll.getCurrentNode().hasNext()) {
            if (ll.iterator().hasNext()) {
                ll.moveNext();
            }
            System.out.println(ll.getCurrentNode().getItem().toString());
        }

        // LList llr = costcoPrep.reverseLinkedList(ll);

        // System.out.println("reversed string size: " + llr.getSize());

        // for(int i = 0; i < llr.getSize(); i++){
        // System.out.println("Current: " + llr.getCurrentNode());
        // System.out.println(llr.getCurrentNode().getItem().toString());

        // System.out.println("Next: " + llr.getCurrentNode().getNext());
        // System.out.println(llr.getCurrentNode().getNext().getItem().toString());

        // llr.moveNext();
        // }

        // if(llr != null){
        // llr.setCurrentNodeToHead();
        // if(llr.getCurrentNode() != null){
        // System.out.print(llr.getCurrentNode().getItem().toString());
        // }
        // while(llr.getCurrentNode().hasNext()){
        // if(llr.iterator().hasNext()){
        // llr.moveNext();
        // }
        // System.out.print(llr.getCurrentNode().getItem().toString());
        // }
        // }

        // regex algorithms

        String baseStr = "This is a test string with numbers 123 and 456.";
        String regexPatternText = "\\d+";
        String replacementText = "###";
        String baseStr1 = "This is a test string with numbers 123 and 456.";
        String regexPatternText1 = "[a-z&&[^m-t],and]"; // finds a-z less m-t, except for n (and a, d) - finds those
        String replacementText1 = "#";
        String baseStr2 = "This is a test string with numbers 123 and 456.";
        // String regexPatternText2 = "[and,test]";
        String regexPatternText2 = "[adenst]"; // equivalent to above
        String replacementText2 = "#";

        System.out.println("Debugging: " +
                costcoPrep.replaceValuesInString(baseStr, regexPatternText, replacementText));
        System.out.println("Debugging: " +
                costcoPrep.replaceValuesInString(baseStr1, regexPatternText1, replacementText1));
        System.out.println("Debugging: " +
                costcoPrep.replaceValuesInString(baseStr2, regexPatternText2, replacementText2));

        // string algorithms

        String testStringABC = "This is a sample string, primarily for manipulation; or possibly for other purposes.";
        System.out.println(testStringABC);

        // reverse strings either by character or by word (space-delimited)
        System.out.println("reverseString1: " + costcoPrep.reverseString1(testStringABC));
        System.out.println("reverseString2: " + costcoPrep.reverseString2(testStringABC));
        System.out.println("reverseStringSansPunctuation: " + costcoPrep.reverseStringSansPunctuation(testStringABC));

        String[] rtnRevArray = costcoPrep.reverseStringByWord(testStringABC);
        System.out.println("reverseStringByWord: (length: " + rtnRevArray.length + ")");
        for (int i = 0; i < rtnRevArray.length; i++) {
            System.out.print(rtnRevArray[i] + " ");
        }
        System.out.println();

        // array algorithms

        int[] intArray = { 1, 2, 3, 4, 5, 3, 6, 7, 2, 3, 1, 2, 6, 4, 3 };
        int firstDupe = costcoPrep.findFirstDuplicate(intArray);
        int lastDupe = costcoPrep.findLastDuplicate(intArray);

        System.out.println("Index of first dupe is: " + firstDupe + "; value of first dupe is: " + intArray[firstDupe]);
        System.out.println("Index of last dupe is: " + lastDupe + "; value of last dupe is: " + intArray[lastDupe]);

        // list algorithms

        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);

        for (int i = 0; i < intList.size(); i++) {
            System.out.println("value: " + intList.get(i));
        }

        // dictionary algorithms

        HashMap<Integer, String> intStrMap = new HashMap<Integer, String>() {
            {
                put(1, "test1");
                put(2, "test2");
                put(3, "test3");
                put(4, "test4");
                put(5, "test5");
            }
        };

        for (int intVal : intStrMap.keySet()) {
            System.out.println("key: " + intVal + ", value: " + intStrMap.get(intVal));
        }

        // *************************************************************************************************************
        // Leetcode algorithms
        // *************************************************************************************************************

        String romanNum = "MCMXCIV";
        System.out.println("romanToInt: " + costcoPrep.romanToInt(romanNum));
        romanNum = "MM";
        System.out.println("romanToInt: " + costcoPrep.romanToInt(romanNum));
        romanNum = "MMXXV";
        System.out.println("romanToInt: " + costcoPrep.romanToInt(romanNum));

        System.out.println("climbStairs: " + costcoPrep.climbStairs(6));
        System.out.println("climbStairs: " + costcoPrep.climbStairs(16));
        System.out.println("climbStairs: " + costcoPrep.climbStairs(10));
        System.out.println("climbStairs: " + costcoPrep.climbStairs(45));
        System.out.println("climbStairs: " + costcoPrep.climbStairs(2));
        System.out.println("climbStairs: " + costcoPrep.climbStairs(4));

        // *****************************************
        boolean runBasics = false;

        boolean testOnly = true;

        if (!testOnly) {
            Test testCode = new Test();

            // String tstStr = "abcdcba";
            // System.out.println("is_Palindrome? " + testCode.isPalindrome(tstStr));

            // tstStr = "abcddcba";
            // System.out.println("is_Palindrome? " + testCode.isPalindrome(tstStr));

            // tstStr = "abcddccba";
            // System.out.println("is_Palindrome? " + testCode.isPalindrome(tstStr));

            // String tstStr1 = "this is a test string";
            // System.out.println("string_Reverse " + testCode.reverseString(tstStr1));
            // System.out.println("string_Reverse_By_Word " +
            // testCode.string_Reverse_By_Word(tstStr1));

            // int[] tstArr = {1, 2, 4, 8, 16, 32};
            // int[] rtnArr = testCode.reverse_IntArray(tstArr);
            // for(int i = 0; i < rtnArr.length; i++){
            // System.out.println(rtnArr[i]);
            // }

            int num = 5;
            // System.out.println(fibonacctestCode.fibonacci_(num));

            /*
             * String input1 = "123";
             * input1 = "012378";
             * 
             * String input2 = "345";
             * input2 = "012347";
             * 
             * System.out.println(testCode.multiplyLongNumsAsString2(input1, input2));
             * System.out.println(testCode.multiplyLongNumsAsString3(input1, input2));
             * 
             * input1 = "012345678901234567"
             * + "8901234567890123"
             * + "4567890123456789"
             * + "0123456789012345"
             * + "6789012345678901"
             * + "654632498739473";
             * 
             * input2 = "0123456789012345"
             * + "6789012345678901"
             * + "2345678901234567"
             * + "8901234567890123"
             * + "4567890123456789"
             * + "61247612748612746";
             * System.out.println(testCode.multiplyLongNumsAsString3(input1, input2));
             * 
             * String testStr1A = "is was saw si";
             * String testStr2A = "is was saw so";
             * 
             * System.out.println("original string: " + testStr1A);
             * System.out.println("reverse string: " + testCode.reverseString(testStr1A));
             * System.out.println("is palindrome? " + testCode.isPalindrome(testStr1A));
             * System.out.println("is palindrome? " +
             * testCode.isPalindrome(testCode.reverseString(testStr1A)));
             * System.out.println("original string: " + testStr2A);
             * System.out.println("reverse string: " + testCode.reverseString(testStr2A));
             * System.out.println("is palindrome? " + testCode.isPalindrome(testStr2A));
             * System.out.println("is palindrome? " +
             * testCode.isPalindrome(testCode.reverseString(testStr2A)));
             * 
             * int number = 12345678;
             * char[] returnedArr = testCode.convertNumToCharArray(number);
             * for(int i = 0; i < returnedArr.length; i++){
             * System.out.println(returnedArr[i]);
             * }
             */

            Practice practice = new Practice();

            String testString = "Computer programming or coding is the composition of sequences of instructions, called programs, that computers can follow to perform tasks.[1][2] It involves designing and implementing algorithms, step-by-step specifications of procedures, by writing code in one or more programming languages. Programmers typically use high-level programming languages that are more easily intelligible to humans than machine code, which is directly executed by the central processing unit. Proficient programming usually requires expertise in several different subjects, including knowledge of the application domain, details of programming languages and generic code libraries, specialized algorithms, and formal logic.  Auxiliary tasks accompanying and related to programming include analyzing requirements, testing, debugging (investigating and fixing problems), implementation of build systems, and management of derived artifacts, such as programs' machine code. While these are sometimes considered programming, often the term software development is used for this larger overall process – with the terms programming, implementation, and coding reserved for the writing and editing of code per se. Sometimes software development is known as software engineering, especially when it employs formal methods or follows an engineering design process.";
            String result = practice.removeVowelsUsingRegex(testString);
            System.out.println(result);
            System.out.println(testString.length() - result.length());

            String ipAddress = "192.168.0.1";
            System.out.println(practice.defangingAnIPAddress(ipAddress));

            // String jewels = "aA";
            // String stones = "aAAbbbb";
            // System.out.println(practice.deJewel(jewels, stones));
            String jewels = "aeiou";
            System.out.println(practice.deJewel(jewels, testString));

            String input = "codeleet";
            int[] indices = new int[] { 4, 5, 6, 7, 0, 2, 1, 3 };
            System.out.println(practice.shuffleString(input, indices));

            String rlStr1 = "RLRRLLRLRL";
            String rlStr2 = "RLRRRLLRLL";
            String rlStr3 = "LLLLRRRR";

            System.out.println(practice.splitBalancedStringIntoBalancedSubstrings(rlStr1));
            System.out.println(practice.splitBalancedStringIntoBalancedSubstrings(rlStr2));
            System.out.println(practice.splitBalancedStringIntoBalancedSubstrings(rlStr3));

            System.out.println(practice.strToLowerCase(testString));

            System.out.println(practice.countSubstringsWithOnlyOneDistinctLetter(input));

            System.out.println(practice.fizzBuzz(15));

            System.out.println("\nReverse string by character: \n" + practice.reverseString(testString));

            System.out.println("\nReverse string by word: \n" + practice.reverseStringByWord(testString));

            String palindrome = "A man, a plan, a canal, panama.";
            // String palindrome = "A man, a plant, a canal, panmama.";
            System.out.println("Is Palindrome? " + practice.isPalindrome(palindrome));

            System.out.println("Is Palindrome? " + practice.isPalindromeAllowForTypos(palindrome));

            Class<Integer> clsI = Integer.class;
            Object[] objs = new Object[] { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5,
                    1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
            Object[] rtnObns = practice.removeDupes(objs, clsI);
            for (Object obj : rtnObns) {
                System.out.print(obj);
            }

            System.out.print("\n");
            Class<String> clsS = String.class;
            char[] cArr = testString.toCharArray();
            objs = new Object[cArr.length];
            for (int i = 0; i < cArr.length; i++) {
                // System.out.print(cArr[i]);
                objs[i] = (Object) cArr[i];
            }
            rtnObns = practice.removeDupes(objs, clsS);
            for (Object obj : rtnObns) {
                System.out.print(obj);
            }

            System.out.print("\n");
            Map<Object, Integer> rtnMap = new HashMap<>();
            rtnMap = practice.countFrequencyOfObjectInArray(objs, clsS);
            for (Object obj : rtnMap.keySet()) {
                System.out.println(obj + ": " + rtnMap.get(obj));
            }
            System.out.print("\n");
            Map<Integer, List<Object>> sortedMap = practice.consolidateMapContents(rtnMap);
            sortedMap = practice.keyReverseSort(sortedMap);
            for (int i : sortedMap.keySet()) {
                System.out.println(i + ": " + sortedMap.get(i));
            }

            Employee employee = new Employee();
            employee.findOlderEmployees();

            AlgoExp algoExp = new AlgoExp();
            List<AlgoExp.BinaryTree> bTrees = new ArrayList<>();
            for (int i = 10; i > 0; i--) {
                AlgoExp.BinaryTree bTree = algoExp.new BinaryTree();
                bTree.value = i;
                // if (i % 2 == 0) {
                // bTree.right = bTrees.get(i);
                // } else {
                // bTree.left = bTrees.get(i - 1);
                // }

                bTrees.add(bTree);
            }
            // BTree Structure
            // 9
            // / \
            // 7 8
            // / /
            // 5 4
            // / / \
            // 3 2 6
            // /
            // 1

            bTrees.get(9).left = bTrees.get(7);
            bTrees.get(7).left = bTrees.get(5);
            bTrees.get(5).left = bTrees.get(3);
            bTrees.get(3).left = bTrees.get(1);

            bTrees.get(9).right = bTrees.get(8);
            bTrees.get(8).left = bTrees.get(4);
            bTrees.get(4).right = bTrees.get(6);
            bTrees.get(4).left = bTrees.get(2);

            System.out.println(algoExp.branchSums(bTrees.get(9)));

            System.out.println(algoExp.nodeDepths(bTrees.get(9)));

            List<String> walkedGraph = new ArrayList<>();

            AlgoExp.Node nodeA = algoExp.new Node("A");

            nodeA = nodeA.addChild("B");
            nodeA = nodeA.addChild("C");
            nodeA = nodeA.addChild("D");

            AlgoExp.Node nodeB = nodeA.children.get(0);
            AlgoExp.Node nodeC = nodeA.children.get(1);
            AlgoExp.Node nodeD = nodeA.children.get(2);

            nodeB = nodeB.addChild("E");
            nodeB = nodeB.addChild("F");

            AlgoExp.Node nodeE = nodeB.children.get(0);
            AlgoExp.Node nodeF = nodeB.children.get(1);

            nodeD = nodeD.addChild("G");
            nodeD = nodeD.addChild("H");

            AlgoExp.Node nodeG = nodeD.children.get(0);
            AlgoExp.Node nodeH = nodeD.children.get(1);

            nodeF = nodeF.addChild("I");
            nodeF = nodeF.addChild("J");

            AlgoExp.Node nodeI = nodeF.children.get(0);
            AlgoExp.Node nodeJ = nodeF.children.get(1);

            nodeG = nodeG.addChild("K");

            AlgoExp.Node nodeK = nodeG.children.get(0);

            walkedGraph = nodeA.depthFirstSearch(walkedGraph);
            System.out.println(walkedGraph);

            int[] redShirts = new int[] { 5, 5, 3, 9, 2 };
            int[] blueShirts = new int[] { 3, 6, 7, 2, 1 };
            boolean fastest = true;

            System.out.println(algoExp.tandemBicycle(redShirts, blueShirts, fastest));

            assert (algoExp.tandemBicycle(redShirts, blueShirts, fastest)) == 32;

            algoExp.firstNonRepeatingCharacter(testString);

            String newS1 = "racecar";
            String newS2 = "aabbcc";
            String newS3 = "aabbccdeefffg";
            String newS4 = "";
            System.err.println("should be e: " + algoExp.NORDFindFirstNonRepeatingChar1(newS1));
            System.err.println("should be ^: " + algoExp.NORDFindFirstNonRepeatingChar1(newS2));
            System.err.println("should be d: " + algoExp.NORDFindFirstNonRepeatingChar1(newS3));
            System.err.println("should be ^: " + algoExp.NORDFindFirstNonRepeatingChar1(newS4));
            System.err.println("should be e: " + algoExp.NORDFindFirstNonRepeatingChar2(newS1));
            System.err.println("should be ^: " + algoExp.NORDFindFirstNonRepeatingChar2(newS2));
            System.err.println("should be d: " + algoExp.NORDFindFirstNonRepeatingChar2(newS3));
            System.err.println("should be ^: " + algoExp.NORDFindFirstNonRepeatingChar2(newS4));

            String parenString1 = "()";
            String parenString2 = ")()";
            String parenString3 = "((()()))";
            String parenString4 = "((()()))())";
            String parenString5 = "))((()()))((()";
            String parenString6 = "{}[]()";
            System.err.println("reply is: " + algoExp.NORDValidParenCheck(parenString1));
            System.err.println("reply is: " + algoExp.NORDValidParenCheck(parenString2));
            System.err.println("reply is: " + algoExp.NORDValidParenCheck(parenString3));
            System.err.println("reply is: " + algoExp.NORDValidParenCheck(parenString4));
            System.err.println("reply is: " + algoExp.NORDValidParenCheck(parenString5));
            System.err.println("reply is: " + algoExp.NORDValidParenCheck(parenString6));

            System.out.println("*********************************");
            System.out.println(algoExp.ArrayChallenge2(211));
            System.out.println("*********************************");

            int[] testArr3 = new int[] { 3, 6, 7, 2, 1, 21, 300, 27, 13, 13, 19 };
            int target = 19;
            Arrays.sort(testArr3);

            System.out.println(algoExp.binarySearchIterative(testArr3, target));
            System.out.println(algoExp.binarySearch(testArr3, target));

            String parenStr1 = "(a(b)c))";
            String parenStr2 = "(a(b)c)";
            String parenStr3 = ")()()";
            String parenStr4 = "(((((";
            String parenStr5 = "(()()(";
            System.out.print("input:  " + parenStr1);
            System.out.println("output: " + algoExp.balance(parenStr1));
            System.out.print("input:  " + parenStr2);
            System.out.println("output: " + algoExp.balance(parenStr2));
            System.out.print("input:  " + parenStr3);
            System.out.println("output: " + algoExp.balance(parenStr3));
            System.out.print("input:  " + parenStr4);
            System.out.println("output: " + algoExp.balance(parenStr4));
            System.out.print("input:  " + parenStr5);
            System.out.println("output: " + algoExp.balance(parenStr5));

            System.out.println(algoExp.isPalindromeInt(palindrome));

            int[] intArrLongestPeak = { 1, 1, 1, 2, 3, 10, 12, -3, -3, 2, 3, 45, 800, 99, 98, 0, -1, -1, 2, 3, 4, 5, 0,
                    -1,
                    -1 };
            System.out.println(algoExp.longestPeakJava(intArrLongestPeak));// correct answer is '9'
        }

        // ***********************************************************/
        // ***********************************************************/
        // ***********************************************************/
        // ***********************************************************/
        // ***********************************************************/
        // ***********************************************************/
        // ***********************************************************/
        // ***********************************************************/
        // ***********************************************************/
        // ***********************************************************/
        // ***********************************************************/

        if (runBasics) {

            SimpleMethods simple = new SimpleMethods();
            ArrayMethods arrMethods = new ArrayMethods();
            TreeMethods treeMethods = new TreeMethods();
            DynamicProgrammingMethods dpMethods = new DynamicProgrammingMethods();
            DynamicProgrammingMethods.NQueensProblem nqMethods = dpMethods.new NQueensProblem();
            SearchAndSortMethods sortMethods = new SearchAndSortMethods();
            StackAndQueueMethods stackMethods = new StackAndQueueMethods();
            GraphMethods graphMethods = new GraphMethods();

            // String methods (20%)
            String testStr = "a man, a plan, a canal, panama.";
            System.out.println(simple.isPalindrome(testStr));

            String testStrA = "a man, a plan, a canal, panama";
            // String testStrA = "abbcca";
            // String testStrA = "aa";
            // String testStrA = "aaa";
            // String testStrA = "aaaaaaaaa";
            // String testStrA = "abba";
            // String testStrA = "abbcaacdda";
            // String testStrA = "aba";

            // System.out.println("removeSequences result: " +
            // simple.removeSequencesUsingRegEx(testStrA));
            System.out.println("removeSequences result: " +
                    simple.removeSequences(testStrA));

            for (int i = 0; i < 5; i++) {
                System.out.println(simple.alloc());
            }
            simple.free(2);
            simple.free(3);
            for (int i = 0; i < 5; i++) {
                System.out.println(simple.allocations[i]);
            }

            // Dynamic Programming (and Recursive) methods (20%)
            int inputVal = 8;
            System.out.println("\n" + inputVal + "th Fibonacci: " + simple.calculateNthFibonacci(inputVal));

            int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
            int len = arr.length;

            // Function call
            System.out.println("Length of lis is " + DynamicProgrammingMethods.LIS.lis(arr, len));

            // int n = 4; // n can be anything >= 4; try 8 for chessboard and n = 10
            int n = 8;
            // int n = 10;
            nqMethods.solveNQueens(n);

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
            TreeMethods.BinaryTree tree = treeMethods.new BinaryTree();
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
            Set<GraphMethods.Node> s = new HashSet<>();
            int numNodesInGraph = 8;
            GraphMethods.Node prevNode = null;
            for (int i = 0; i < numNodesInGraph; i++) {
                GraphMethods.Node n1 = graphMethods.new Node();

                n1.value = i;
                if (prevNode != null) {
                    n1.neighbors.add(prevNode);
                }

                prevNode = n1;
                s.add(n1);
            }

            GraphMethods.Node source = null;
            GraphMethods.Node dest = null;
            for (GraphMethods.Node n2 : s) {
                if (n2.value == 0) {
                    dest = n2;
                }
                if (n2.value == s.size() - 1) {
                    source = n2;
                }
            }

            System.out.println("\n");
            System.out.println(s);
            System.out.println("\nDFS graph: " + graphMethods.DFS(source, dest, s));
            System.out.println("\nBFS graph: " + graphMethods.BFS(source, dest, s));
            System.out.println();

            // let's modify set now to force next relationships

            // attach Nodes in Set to tangible instances so can assign to neighbor lists
            GraphMethods.Node node0 = null;
            GraphMethods.Node node1 = null;
            GraphMethods.Node node2 = null;
            GraphMethods.Node node3 = null;
            GraphMethods.Node node4 = null;
            GraphMethods.Node node5 = null;
            GraphMethods.Node node6 = null;
            GraphMethods.Node node7 = null;
            for (GraphMethods.Node n3 : s) {

                if (n3.value == 0) {
                    node0 = n3;
                    node0.neighbors = new ArrayList<>();
                    System.out.println("0: " + n3);
                }
                if (n3.value == 1) {
                    node1 = n3;
                    node1.neighbors = new ArrayList<>();
                    System.out.println("1: " + n3);
                }
                if (n3.value == 2) {
                    node2 = n3;
                    node2.neighbors = new ArrayList<>();
                    System.out.println("2: " + n3);
                }
                if (n3.value == 3) {
                    node3 = n3;
                    node3.neighbors = new ArrayList<>();
                    System.out.println("3: " + n3);
                }
                if (n3.value == 4) {
                    node4 = n3;
                    node4.neighbors = new ArrayList<>();
                    System.out.println("4: " + n3);
                }
                if (n3.value == 5) {
                    node5 = n3;
                    node5.neighbors = new ArrayList<>();
                    System.out.println("5: " + n3);
                }
                if (n3.value == 6) {
                    node6 = n3;
                    node6.neighbors = new ArrayList<>();
                    System.out.println("6: " + n3);
                }
                if (n3.value == 7) {
                    node7 = n3;
                    node7.neighbors = new ArrayList<>();
                    System.out.println("7: " + n3);
                }
            }

            node0.neighbors.add(node1);
            node0.neighbors.add(node3);
            node1.neighbors.add(node2);
            node2.neighbors.add(node6);
            node2.neighbors.add(node3);
            node3.neighbors.add(node6);
            // node3.neighbors.add(node7);
            node4.neighbors.add(node5);
            node5.neighbors.add(node3);
            node5.neighbors.add(node7);
            node6.neighbors.add(node3);
            node6.neighbors.add(node4);

            for (GraphMethods.Node n2 : s) {
                if (n2.value == 0) {
                    source = n2;
                }
                if (n2.value == s.size() - 1) { // set dest to 7
                    dest = n2;
                }
            }
            System.out.println("\nDFS graph: " + graphMethods.DFS(source, dest, s));
            System.out.println("\nBFS graph: " + graphMethods.BFS(source, dest, s));

            for (GraphMethods.Node n2 : s) {
                if (n2.value == 0) {
                    source = n2;
                }
                if (n2.value == s.size() - 2) { // set dest to 6
                    dest = n2;
                }
            }
            System.out.println("\nDFS graph: " + graphMethods.DFS(source, dest, s));
            System.out.println("\nBFS graph: " + graphMethods.BFS(source, dest, s));

            // Search/Sort methods (10%)
            System.out.println("\n\nForward Sort: ");
            int[] array3 = newIntArray.clone();
            System.out.println("\nUnsorted array: ");
            System.out.print(Arrays.toString(array3));
            sortMethods.forwardSort(array3);
            System.out.println("\nSorted array: ");
            System.out.print(Arrays.toString(array3));

            System.out.println("\n\nReverse Sort (2 variations): ");
            int[] array4 = newIntArray.clone();
            int[] sortedArray = new int[array3.length];
            System.out.println("\nUnsorted array: ");
            System.out.print(Arrays.toString(array4));
            sortedArray = sortMethods.reverseSort(array4, false);
            System.out.println("\nSorted array: ");
            System.out.print(Arrays.toString(sortedArray));

            int[] array5 = newIntArray.clone();
            System.out.println("\nUnsorted array: ");
            System.out.print(Arrays.toString(array5));
            sortMethods.reverseSortInPlace(array5);
            System.out.println("\nSorted array: ");
            System.out.print(Arrays.toString(array5));

            int[] array6 = newIntArray.clone();

            System.out.println("\n\nBubble Sort: ");
            System.out.println("\n" + sortMethods.isSorted(array6));
            System.out.println("\nUnsorted array: ");
            for (int i = 0; i < array6.length; i++) {
                System.out.print(array6[i] + ", ");
            }
            sortMethods.bubbleSort(array6);
            System.out.println("\nSorted array: ");
            for (int i = 0; i < array6.length; i++) {
                System.out.print(array6[i] + ", ");
            }
            System.out.println("\n" + sortMethods.isSorted(array6));

            System.out.println("\n\nMergeSort: ");
            int[] array7 = newIntArray.clone();
            sortedArray = new int[array7.length];

            System.out.println("\nUnsorted array: ");
            for (int i = 0; i < array7.length; i++) {
                System.out.print(array7[i] + ", ");
            }
            sortedArray = sortMethods.mergeSort(array7);
            System.out.println("\nSorted array: ");
            for (int i = 0; i < sortedArray.length; i++) {
                System.out.print(sortedArray[i] + ", ");
            }

            // int[] array8 = newIntArray.clone();

            // System.out.println("\n\nQuick Sort: ");
            // System.out.println("\n" + sortMethods.isSorted(array8));
            // System.out.println("\nUnsorted array: ");
            // for (int i = 0; i < array8.length; i++) {
            // System.out.print(array8[i] + ", ");
            // }
            // sortMethods.quickSort(array8);
            // System.out.println("\nSorted array: ");
            // for (int i = 0; i < array8.length; i++) {
            // System.out.print(array8[i] + ", ");
            // }
            // System.out.println("\n" + sortMethods.isSorted(array8));

            // LinkedList methods (4%)

            // Stack/Queue methods (2%)
            int numNodes = 5;
            StackAndQueueMethods.Stack currentStack = stackMethods.new Stack();
            StackAndQueueMethods.Node[] nodes = new StackAndQueueMethods.Node[numNodes];
            for (int i = 0; i < numNodes; i++) {
                StackAndQueueMethods.Node newNode = stackMethods.new Node();
                newNode.value = i;
                nodes[i] = newNode;
            }
            for (int i = 0; i < numNodes; i++) {
                currentStack.push(nodes[i].value);
            }

            try {
                System.out.println("\nContents of stack, peeked: ");
                System.out.println(((Integer) currentStack.peek()).toString());

                System.out.println("Contents of stack, popped: ");
                for (int i = numNodes - 1; i >= 0; i--) {
                    System.out.println(((Integer) currentStack.pop()).toString());
                }

                // Commented out because will fail (stop program from running) by design
                if (!currentStack.empty()) {
                    System.out.println("Contents of stack, peeked (will now be empty): ");
                    int val = currentStack.peek();
                    System.out.println(((Integer) val).toString());
                }

            } catch (Exception e) {
                System.out.println("Exception caught: " + e.getMessage() + "; " + e.getStackTrace());
            }

            StackAndQueueMethods.Queue currentQueue = stackMethods.new Queue();
            for (int i = 0; i < numNodes; i++) {
                StackAndQueueMethods.Node newNode = stackMethods.new Node();
                newNode.value = i;
                nodes[i] = newNode;
            }
            for (int i = 0; i < numNodes; i++) {
                currentQueue.enqueue(nodes[i].value);
            }

            try {
                System.out.println("\nContents of queue, peeked: ");
                System.out.println(((Integer) currentQueue.peek()).toString());

                System.out.println("Contents of queue, dequeued: ");
                for (int i = numNodes - 1; i >= 0; i--) {
                    System.out.println(((Integer) currentQueue.dequeue()).toString());
                }

                // Commented out because will fail (stop program from running) by design
                if (!currentQueue.empty()) {
                    System.out.println("Contents of queue, peeked (will now be empty): ");
                    int val = currentQueue.peek();
                    System.out.println(((Integer) val).toString());
                }

            } catch (Exception e) {
                System.out.println("Exception caught: " + e.getMessage() + "; " + e.getStackTrace());
            }

            StackAndQueueMethods.QueueUsingStacks queueViaStacks = stackMethods.new QueueUsingStacks();
            for (int i = 0; i < numNodes; i++) {
                StackAndQueueMethods.Node newNode = stackMethods.new Node();
                newNode.value = i;
                nodes[i] = newNode;
            }
            for (int i = 0; i < numNodes; i++) {
                queueViaStacks.enQueue(nodes[i].value);
            }
            try {
                System.out.println("\nContents of queueByStacks, peeked: ");
                System.out.println(((Integer) queueViaStacks.peek()).toString());

                System.out.println("Contents of queueByStacks, dequeued: ");
                for (int i = numNodes - 1; i >= 0; i--) {
                    System.out.println(((Integer) queueViaStacks.deQueue()).toString());
                }

                // Commented out because will fail (stop program from running) by design
                if (!queueViaStacks.empty()) {
                    System.out.println("Contents of queueByStacks, peeked (will now be empty): ");
                    int val = queueViaStacks.peek();
                    System.out.println(((Integer) val).toString());
                }

            } catch (Exception e) {
                System.out.println("Exception caught: " + e.getMessage() + "; " + e.getStackTrace());
            }

        }
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
