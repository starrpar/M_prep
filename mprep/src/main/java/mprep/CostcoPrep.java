package mprep;

import java.util.List;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import mprep.LList;
import mprep.LListNode;
import java.util.regex.*; //Pattern, Matcher
import java.util.Set;

//NOTE: methods not explicitly marked public are package-private by default
//(which is all we need for this practice code)

public class CostcoPrep {

    // Areas to practice:
    // recursion
    // regex
    // strings
    // arrays
    // lists
    // dictionaries

    public int makeTheIntegerZero(int num1, int num2) {

        for (int k = 1; k <= 60; k++) {
            long x = 1L * num1 - 1L * num2 * k;
            // if (num1 - (num2 * k)) < k, then no solution (why?) - parens solely for
            // clarification...
            if (x < k) {
                return -1;
            }
            System.out.println("k: " + k + ", x: " + x + ", bitCount: " + Long.bitCount(x));
            // once k > num bits set in Binary representation of int value, then number of
            // iterations is found (why?)
            if (k >= Long.bitCount(x)) {
                return k;
            }
        }
        return -1;
    }

    // this is NOT sufficient - order matters...
    public boolean NORDValidParenCheck(String s) {

        int numParen = 0;
        int numParensRemoved = 0;
        int numBracket = 0;
        int numBracketsRemoved = 0;
        int num = 0;
        List<Integer> openers = new ArrayList<>();

        char[] cArr = s.toCharArray();

        for (int i = 0; i < cArr.length; i++) {
            if (numParen < 0) {
                return false;
            }
            if (cArr[i] == '(') {
                numParen++;
                openers.add(0);
            } else if (cArr[i] == ')') {
                if ((numBracket + numBracketsRemoved * 2 + numParensRemoved * 2 + 1) == i
                        && openers.get(openers.size() - 1) == 0) {
                    System.out.println("numBracket: " + numBracket + ", " + "num: " + num + ", "
                            + "numBracketsRemoved: " + numBracketsRemoved * 2 + ", " + "numParensRemoved: "
                            + numParensRemoved * 2 + ", " + "i: " + i);
                    numParen--;
                    openers.remove(openers.size() - 1);
                    numParensRemoved++;
                } else {
                    System.out.println(
                            "FAIL - numBracket: " + numBracket + ", " + "numBracketsRemoved: " + numBracketsRemoved * 2
                                    + ", " + "numParensRemoved: " + numParensRemoved * 2 + ", " + "i: " + i);
                    return false;
                }
            }
            if (cArr[i] == '{') {
                numBracket++;
                openers.add(1);
            } else if (cArr[i] == '}') {
                if ((numParen + numBracketsRemoved * 2 + numParensRemoved * 2 + 1) == i
                        && openers.get(openers.size() - 1) == 1) {
                    // System.out.println("numParen: " + numParen + ", " + "num: " + num + ", " +
                    // "numBracketsRemoved: " + numBracketsRemoved*2 + ", " + "numParensRemoved: " +
                    // numParensRemoved*2 + ", " + "i: " + i);
                    numBracket--;
                    openers.remove(openers.size() - 1);
                    numBracketsRemoved++;
                } else {
                    // System.out.println("FAIL - numParen: " + numParen + ", " +
                    // "numBracketsRemoved: " + numBracketsRemoved*2 + ", " + "numParensRemoved: " +
                    // numParensRemoved*2 + ", " + "i: " + i);
                    return false;
                }
            }
            // if(cArr[i] == '(' || cArr[i] == '{' || cArr[i] == '['){
            // numParen++;
            // }
            // else if(cArr[i] == ')' || cArr[i] == '}' || cArr[i] == ']'){
            // numParen--;
            // }
        }

        if (numParen == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean newIsPalindrome(String s) {
        String cleaned = "";
        String regexPattern = "[^a-zA-Z0-9]";
        String replacementText = "";

        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(s);

        cleaned = matcher.replaceAll(replacementText);
        cleaned = cleaned.toLowerCase();

        for (int i = 0; i < cleaned.length(); i++) {
            if (cleaned.charAt(i) != cleaned.charAt((cleaned.length() - 1) - i)) {
                return false;
            }
        }
        return true;
    }

    public boolean ValidParenCheck(String s) {

        int numParen = 0;
        int numParensRemoved = 0;
        // List<Integer> openers = new ArrayList<>();

        Deque<Integer> test = new ArrayDeque<>();
        test.addFirst(1);
        int x = 0;
        if (test.peekFirst() == 1) {
            x = test.removeFirst();
        }
        System.out.println(x);

        char[] cArr = s.toCharArray();

        for (int i = 0; i < cArr.length; i++) {
            // verify haven't removed more than added
            if (numParen < 0) {
                return false;
            }
            if (cArr[i] == '(') {
                numParen++;
                // openers.add(0);
            } else if (cArr[i] == ')') {
                numParen--;
                // openers.remove(openers.size() - 1);
            }
        }

        // verify closed out all paren that were opened before finishing
        if (numParen == 0) {
            return true;
        } else {
            return false;
        }
    }

    // recursion
    int Fibonacci(int i) {
        return fiboRecurse(i);
    }

    private int fiboRecurse(int i) {
        if (i <= 1) {
            // System.out.println("adding: " + i);
            return i;
        }

        // System.out.println("adding: " + (i-1) + " and " + (i-2));
        return fiboRecurse(i - 1) + fiboRecurse(i - 2);
    }

    int[] storeUpToNWithoutLooping(int n) {

        int[] nums = new int[n];

        // call recursively (passing array to populate),
        // and then finally insert last value
        nums[n - 1] = storeNRecurse(n, nums);
        return nums;
    }

    private int storeNRecurse(int i, int[] nums) {
        // base case to stop recursion
        if (i <= 0) {
            return 0;
        }

        nums[i - 1] = storeNRecurse(i - 1, nums) + 1;
        return i;
    }

    int addUpToNWithoutLooping(int n) {

        return addNRecurse(n);
    }

    private int addNRecurse(int i) {
        // base case to stop recursion at 0
        if (i <= 0) {
            return 0;
        }
        // add current value (i) to sum or previous values
        int total = i;
        total += addNRecurse(i - 1);
        return total;
    }

    // ToDo: reversing linked list is "working", but bookkeeping is not 100%
    // #region Linked List code

    LList reverseLinkedList(LList ll) {
        LList reversed = new LList();
        reversed.setSize(0);

        System.out.println("Beginning at: " + ll.getHead().getItem());
        // sets initial node to head - correct for initial (non-reversed) string
        ll.setCurrentNodeToHead();
        LListNode lln = constructReversedLList(ll.getCurrentNode(), reversed);

        System.out.println("adding node: " + lln.getItem().toString());
        reversed.addNode(lln);

        reversed.setPreviousNodeNextToNode(lln);

        // LListNode lastNode = null;
        // if(lln != null && !lln.hasNext()){
        // System.out.println("setting head to: " + lln.getItem().toString());
        // reversed.setHead(lln);
        // // reversed.setCurrentNodeToHead();
        // } else {
        // reversed.addNode(lln);
        // // lastNode = lln;
        // if(lln.hasNext()){
        // reversed.moveNext();
        // } else if(lln.hasPrev()){
        // reversed.moveNext();
        // }
        // }
        return reversed;
    }

    private LListNode constructReversedLList(LListNode node, LList reversedList) {

        if (node.hasNext()) {
            System.out.println("Navigating to: " + node.getNext().getItem().toString());
        }

        LListNode nextNode = null;
        LListNode lln = null;
        LListNode lastNode = null;
        if (node.hasNext()) {
            nextNode = node.getNext();
        } else {
            System.out.println("returning node: " + node.getItem().toString());
            lastNode = lln;
            reversedList.setHead(lln);
            return node;
        }
        if (nextNode != null) {
            System.out.println("Before: " + nextNode.getItem().toString());
            lln = constructReversedLList(nextNode, reversedList);
            System.out.println("After: " + lln.getItem().toString());
        }

        // if(reversedList.getSize() > 1){
        // reversedList.setPreviousNodeNextToCurrentNode(lln);
        // reversedList.addNode(lln);
        // } else {
        if (reversedList.getSize() <= 0) {
            if (lln != null && !lln.hasNext()) {
                System.out.println("setting head to: " + lln.getItem().toString());
                reversedList.setHead(lln);
                reversedList.setCurrentNodeToHead();
            }
        }
        System.out.println("Unwinding: " + lln.getItem().toString());
        if (lln.hasNext()) {
            reversedList.setPreviousNodeNextToNode(lln);
            reversedList.addNode(lln);
        }

        if (lln.hasPrev()) {
            return lln.getPrev();
        } else if (lln.hasNext()) {
            return lln.getNext();
        } else {
            return lln;
        }
    }

    // #endregion

    // regex
    public boolean divideArray(int[] nums) {
        // is nums.length an even number?
        if ((nums.length % 2) != 0) {
            return false;
        }

        // does each value present exist in an even number?
        // store already dealt with values in a list so as not to duplicate effort

        // possible states: empty array, single value (but that is already ruled out by
        // requiring
        // the length of array to be an even number, above)...
        // best approach - single pass through array (O(n)) and store number of
        // occurrences
        // for each value present in a key/value dictionary (HashMap)

        HashMap<Integer, Integer> numOccurrencesByValue = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int numOccurrences = 0;
            System.out.println("calculating numOccurrences...i: " + i);
            if (!numOccurrencesByValue.containsKey(nums[i])) {
                boolean moreThanOneOccurrence = false;
                for (int j = i + 1; j < nums.length; j++) {
                    // System.out.println("num: " + nums[j]);
                    if (nums[j] == nums[i]) {
                        moreThanOneOccurrence = true;
                        if (numOccurrences == 0) {
                            numOccurrences = 2;
                        } else {
                            numOccurrences++;
                        }
                        // System.out.println("numOccurrences: " + numOccurrences);
                    }
                }
                if (!moreThanOneOccurrence) {
                    return false;
                }
            }

            if (numOccurrences > 0) {
                // System.out.println("storing value for: " + nums[i] + " as numOccurrences: " +
                // numOccurrences);
                numOccurrencesByValue.put(nums[i], numOccurrences);
            }
        }

        // if any number of occurrences of a value present is not even, return false
        if (numOccurrencesByValue.isEmpty()) {
            return false;
        }
        for (Integer key : numOccurrencesByValue.keySet()) {
            System.out.println("Inspecting number of occurrences by key: " + key);
            if ((numOccurrencesByValue.get(key) % 2) != 0) {
                return false;
            } else {
                System.out.println("even: " + key + "::" + numOccurrencesByValue.get(key));
            }
        }

        return true;
    }

    String replaceValuesInString(String baseStr, String regexPattern, String replacementText) {

        System.out.println("Input string: " + baseStr);

        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(baseStr);

        while (matcher.find()) {
            System.out.println("Found pattern: " + matcher.group());
        }

        String strWithReplacements = matcher.replaceAll(replacementText);

        return strWithReplacements;
    }

    // strings

    String reverseString1(String s) {
        String revStr = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            revStr += s.charAt(i);
        }

        return revStr;
    }

    // equivalent to above but using toCharArray() instead of .charAt()
    String reverseString2(String s) {
        String revStr = "";
        char[] cStr = s.toCharArray();

        System.out.println("input string length: " + s.length());
        for (int i = cStr.length - 1; i >= 0; i--) {
            revStr += cStr[i];
        }

        return revStr;
    }

    String reverseStringSansPunctuation(String s) {
        String revStr = "";

        String searchPattern = "[,.\\s;-_:]";
        String replacementStr = "";
        Pattern pattern = Pattern.compile(searchPattern);
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        String dePunctuatedStr = matcher.replaceAll(replacementStr);
        System.out.println("dePunctuated string length: " + dePunctuatedStr.length());
        for (int i = dePunctuatedStr.length() - 1; i >= 0; i--) {
            revStr += dePunctuatedStr.charAt(i);
        }

        return revStr;
    }

    String[] reverseStringByWord(String s) {
        String space = " ";
        // split input string based on spaces
        String[] strArray = s.split(space);
        String[] revStrArray = new String[strArray.length];

        int j = 0;
        // go through input string array in reverse order
        // and assign word by word to return word array in
        // forward order (convenience)
        for (int i = strArray.length - 1; i >= 0; i--) {
            revStrArray[j] = strArray[i];
            j++;
        }
        return revStrArray;
    }

    // arrays
    int findFirstDuplicate(int[] intArray) {
        int firstDupeIndex = 0;

        // strategy: capture which values are duplicate / number of occurrences in a
        // dictionary
        // keep track of 2nd occurrence of any char/digit in a dictionary (for more
        // flexible alternatives)
        // could easily simply note when first "2nd occurrence" occurs and exit then
        // returning index value
        // and char/digit at that location
        //
        // alternatively, capture indexes of each occurrence - could also be in a
        // dictionary as
        // {char/int, list<int>} - this would work in a single data structure...

        // for simplicity start with assuming array contains numbers/digits
        HashMap<Integer, ArrayList<Integer>> indexesOfValues = new HashMap<>();

        for (int i = 0; i < intArray.length; i++) {
            // System.out.print(intArray[i] + ", ");
            if (indexesOfValues.containsKey(intArray[i])) {
                indexesOfValues.get(intArray[i]).add(i);
            } else {
                ArrayList<Integer> indices = new ArrayList<>();
                indices.add(i);
                indexesOfValues.put(((Integer) intArray[i]), indices);
            }
        }

        int lowestIndex = intArray.length; // start at 0 since first "dupe" MUST be after first instance (first instance
        // cannot be a duplicate since nothing has occurred before it yet
        int valueOfLowestIndex = 0;

        for (int i = 0; i < intArray.length; i++) {
            if (indexesOfValues.containsKey(intArray[i])) {
                for (int j = 0; j < indexesOfValues.get(intArray[i]).size(); j++) {
                    // System.out.println(i + "," + j + " :: " + indexesOfValues.get(intArray[i]));
                    if (j == 1 && indexesOfValues.get(intArray[i]).get(j) < lowestIndex) {
                        // System.out.println("inside loop: " + i + ", " + j + ":: " + "index: " +
                        // indexesOfValues.get(intArray[i]).get(j) +
                        // ", " + "value: " + intArray[i]);
                        lowestIndex = indexesOfValues.get(intArray[i]).get(j);
                        valueOfLowestIndex = intArray[i];
                    }
                }
            }
        }

        // System.out.println("Value with first dupe: " + valueOfLowestIndex);
        // System.out.println("Index of first dupe: " + lowestIndex);
        firstDupeIndex = lowestIndex;
        return firstDupeIndex;
    }

    int findLastDuplicate(int[] intArray) {
        int lastDupeIndex = 0;

        HashMap<Integer, ArrayList<Integer>> indexesOfValues = new HashMap<>();

        for (int i = 0; i < intArray.length; i++) {
            // System.out.print(intArray[i] + ", ");
            if (indexesOfValues.containsKey(intArray[i])) {
                indexesOfValues.get(intArray[i]).add(i);
            } else {
                ArrayList<Integer> indices = new ArrayList<>();
                indices.add(i);
                indexesOfValues.put(((Integer) intArray[i]), indices);
            }
        }

        int lowestIndex = 0; // start at 0 since first "dupe" MUST be after first instance (first instance
        // cannot be a duplicate since nothing has occurred before it yet
        int valueOfLowestIndex = 0;

        for (int i = 0; i < intArray.length; i++) {
            if (indexesOfValues.containsKey(intArray[i])) {
                for (int j = 0; j < indexesOfValues.get(intArray[i]).size(); j++) {
                    // System.out.println(i + "," + j + " :: " + indexesOfValues.get(intArray[i]) +
                    // "..." + lowestIndex);
                    if (indexesOfValues.get(intArray[i]).get(j) > lowestIndex) {
                        // System.out.println("inside loop: " + i + ", " + j + ":: " + "index: " +
                        // indexesOfValues.get(intArray[i]).get(j) +
                        // ", " + "value: " + intArray[i]);
                        lowestIndex = indexesOfValues.get(intArray[i]).get(j);
                        valueOfLowestIndex = intArray[i];
                    }
                }
            }
        }

        lastDupeIndex = lowestIndex;
        return lastDupeIndex;
    }

    // above uses dictionary/hashmap and list...

    // lists

    // dictionaries

    // Costco interview question:

    public String countSequentialOccurrences1(String s) {
        String outputStr = "";

        // address null or empty string input
        if (s == null || s.isEmpty()) {
            // System.out.println("Input string is empty or null.");
            return outputStr;// return empty string
        }

        // 1. get initial string position as char
        char currentChar = s.charAt(0);

        // 2. initialize counter
        int count = 1;

        // System.out.println("Analyzing string: " + s);

        // 3. iterate through string starting from 2nd position
        for (int i = 1; i < s.length(); i++) {
            // 4. if current position is same as previous, increment count
            if (s.charAt(i) == currentChar) {
                count++;
            } else {

                // 5. otherwise, update currentChar to char at current position and reset count
                // to 1
                // also, append output string with count and currentChar

                // System.out.println("Character '" + currentChar + "' occurred " + count + "
                // times sequentially.");
                String tmpStr = ((Integer) count).toString() + currentChar;
                outputStr += tmpStr;
                currentChar = s.charAt(i);
                count = 1;
            }
        }

        // 6. once done comparing against, capture final values of count and currentChar
        // (either a new char and value of 1 for count, or an incremented count for
        // previous char)

        // Print the last sequence
        // System.out.println("Character '" + currentChar + "' occurred " + count + "
        // times sequentially.");
        String tmpStr = ((Integer) count).toString() + currentChar;
        outputStr += tmpStr;
        System.out.println(); // Add a blank line for readability between different string analyses

        return outputStr;
    }

    // Alternate solution:
    public long countSequentialOccurrences2(long num) {

        // Better design:
        // - Track count and currentChar external to for loop
        // - In for loop, if currentChar is same as previous, increment count
        // (requires capturing initial 0 position value prior to for loop)
        // - If currentChar not same as previous (i.e 'else'), simply write out values
        // to aggregated string
        // ...and reset currentChar to current value (str.charAt(i)) and count = 1
        // - Once for loop is complete, capture last values for currentChar and count
        // into aggregated string
        // and return aggregated string as result

        // Current design (submitted late for previous interview test - works but is
        // inefficient)

        // 1. capture input value (long) as charArray

        // convert to char array for simple handling
        char[] numAsCharArray = String.valueOf(num).toCharArray();

        // 2. initialize values
        List<Long> rtnVal = new ArrayList<>();
        long prevValue = -1L;
        long numOccurrences = 1L;

        // 3. index through charArray (starting at 0th position)
        for (int i = 0; i < numAsCharArray.length; i++) {

            // 4. initialize variables to keep track
            long valueToWrite = -1L;
            char currentValue = numAsCharArray[i]; // (currentChar in other method)

            // process contents

            // 5. check if current value is same as previous char (step 4 in other method)
            // (if so, increment count)
            if (Character.getNumericValue(currentValue) == prevValue) {
                numOccurrences++;

                // 6. if not, reset previous value to current value (step 5 in other method)
                // (INVESTIGATE: not sure why I broke out handling for negative vs. positive
                // values)
            } else if (prevValue < 0) {
                prevValue = Character.getNumericValue(currentValue);
            } else if (prevValue >= 0) {
                valueToWrite = prevValue;
                prevValue = Character.getNumericValue(currentValue);
            }

            // 7. handle final value case
            // (but still from within for loop - probably poor design)

            // handle close out case
            if (i >= numAsCharArray.length - 1) {
                valueToWrite = prevValue;
            }

            // 8. writing out results (count and currentChar) to a List to later aggregate
            // outside of loop...
            // easier to simply build output string on fly, as in other (previous) method...

            // write out results, once removed to handle multiple occurrences
            if (valueToWrite > 0L) {
                // capture numOccurrences and value, and increment j
                rtnVal.add(numOccurrences);
                rtnVal.add(valueToWrite);

                // 9. reset values and continue through for loop

                // ... and reset
                numOccurrences = 1;
                prevValue = Character.getNumericValue(currentValue);
            }
        }

        // convert from List<Long> back to an int value
        String returnValue = "";
        for (int i = 0; i < rtnVal.size(); i++) {
            returnValue += rtnVal.get(i);
        }

        return Long.parseLong(returnValue);
    }

    // //Original solution:
    // public int countSequentialOccurrencesX(int num) {
    // char[] numAsCharArray = String.valueOf(num).toCharArray();
    // HashMap<Character, Integer> numDigits = new HashMap<>();

    // for (int i = 0; i < numAsCharArray.length; i++) {
    // if (numDigits.containsKey(numAsCharArray[i])) {
    // int currentNum = numDigits.get(numAsCharArray[i]);
    // numDigits.replace(numAsCharArray[i], currentNum + 1);
    // } else {
    // numDigits.put(numAsCharArray[i], 1);
    // }
    // }

    // int[] rtnVal = new int[2 * numAsCharArray.length];

    // int j = 0;
    // for (int i = 0; i < numAsCharArray.length; i++) {
    // int numOccurrences = numDigits.get(numAsCharArray[i]);
    // int currentNum = Integer.parseInt(String.valueOf(numAsCharArray[i]));

    // rtnVal[j] = Integer.parseInt(String.valueOf(numOccurrences));
    // rtnVal[j + 1] = Integer.parseInt(String.valueOf(currentNum));

    // j += 2;
    // }

    // String returnValue = "";

    // for (int i = 0; i < rtnVal.length; i++) {
    // returnValue += rtnVal[i];
    // }

    // return Integer.parseInt(returnValue);
    // }
}