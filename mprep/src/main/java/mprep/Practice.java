package mprep;

import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;
// import java.util.Set;
// import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class Practice {
    // Strings

    // EASY:
    // 1.1 Remove Vowels from a String
    // 1.2 Defanging an IP Address
    // 1.3 Jewels and Stones
    // 1.4 Shuffle String
    // 1.5 Split a String in Balanced Strings (Balanced strings are those that have
    // an equal quantity of 'L' and 'R' characters.)
    // 1.6 To Lower Case
    // (1.7 Unique Morse Code Words)
    // 1.8 Count Substrings with Only One Distinct Letter
    // (1.9 Robot Return to Origin)
    // 1.10 Fizz Buzz
    // (1.11 First Unique Character in a String)
    // 1.12 Reverse String
    // 1.13 Valid Anagram
    // 1.14 Valid Palindrome
    // 1.15 Implement Strstr()
    // 1.16 Valid Parentheses
    // 1.17 Roman to Integer
    // 1.18 Longest Common Prefix
    // 1.19 Excel Sheet Column Number
    // 1.20 Palindrome Permutation

    public String removeVowelsUsingRegex(String s) {
        Pattern pattern = Pattern.compile("[aeiou]", Pattern.CASE_INSENSITIVE);
        String replacement = "";
        return removePerRegexPattern(s, pattern.toString(), replacement);
    }

    public String defangingAnIPAddress(String s) {
        Pattern pattern = Pattern.compile("[\\.]");
        String replacement = "[.]";
        return removePerRegexPattern(s, pattern.toString(), replacement);
    }

    private String removePerRegexPattern(String s, String regexPattern, String replacement) {
        return s.replaceAll(regexPattern, replacement);
    }

    public int deJewel(String a, String b) {
        Pattern pattern = Pattern.compile("[" + a + "]");
        String rtnStr = b.replaceAll(pattern.toString(), "");
        return b.length() - rtnStr.length();
    }

    public String shuffleString(String s, int[] arr) {
        String rtnStr = "";
        char[] cArr = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            rtnStr += cArr[i];
        }
        return rtnStr;
    }

    public int splitBalancedStringIntoBalancedSubstrings(String s) {

        // logic thoughts:
        // create substring everytime there is a matching pair or set of matching pairs
        // of Ls and Rs
        // whatever you start with (L or R) count how many of each until you have an
        // equivalent number
        // of the other too
        // when number is even, call that a substring and continue

        List<String> subStrings = new ArrayList<>();
        char[] cArr = s.toLowerCase().toCharArray();
        int numLs = 0;
        int numRs = 0;
        int lastIndex = 0;
        int currentIndex = 0;
        int numSubStrs = 0;
        boolean even = false;

        for (int i = 0; i < cArr.length; i++) {
            switch (cArr[i]) {
                case 'l':
                    numLs++;
                    currentIndex++;
                    break;
                case 'r':
                    numRs++;
                    currentIndex++;
                    break;
                default:
                    System.out.println("problem");
            }
            if (numLs == numRs) {
                even = true;
            }

            if (even) {
                subStrings.add(s.substring(lastIndex, currentIndex));
                lastIndex = currentIndex;
                numSubStrs++;
                even = false; // reset
                numLs = 0;
                numRs = 0;
            }
        }

        return numSubStrs;
    }

    public String strToLowerCase(String s) {
        String rtnVal = "";
        char[] cArr = s.toCharArray();
        int asciiDelta = (int) 'a' - (int) 'A';

        // do so simply using ascii
        for (int i = 0; i < cArr.length; i++) {
            if ((int) cArr[i] >= (int) 'A' && (int) cArr[i] <= (int) 'Z') {
                // System.out.println("Adjusting: " + cArr[i] + " to: " + (char) ((int) cArr[i]
                // + asciiDelta));
                cArr[i] = (char) ((int) cArr[i] + asciiDelta);
            }
        }
        for (int i = 0; i < cArr.length; i++) {
            rtnVal += cArr[i];
        }
        return rtnVal;
    }

    public int countSubstringsWithOnlyOneDistinctLetter(String s) {
        // Set<String> setSubstrings = new HashSet<>();
        Map<String, Integer> setSubstrings = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            // for (int j = i + 1; j < s.length(); j++) {
            // setSubstrings.add(s.substring(i, j));
            // }
            for (int j = i + 1; j < s.length(); j++) {
                if (setSubstrings.containsKey(s.substring(i, j))) {
                    setSubstrings.put(s.substring(i, j), setSubstrings.get(s.substring(i, j)) + 1);
                } else {
                    setSubstrings.put(s.substring(i, j), 1);
                }
            }
        }

        boolean distinct = true;
        String example = "";
        for (String str : setSubstrings.keySet()) {
            if (setSubstrings.get(str) > 1) {
                distinct = false;
                example = str;
            }
        }
        if (!distinct)
            System.out
                    .println("Substrings not distinct: " + example + " has " + setSubstrings.get(example) + " values");
        System.out.println(setSubstrings);

        return setSubstrings.size();
    }

    public List<String> fizzBuzz(int n) {
        // insert "Fizz" if value is divisible by 3
        // insert "Buzz" if value is divisible by 5
        // insert "FizzBuzz" if value is divisible by both 3 and 5

        // return List(String> of integer values (with Fizz and Buzz) up to value n
        // (sent))

        List<String> numList = new ArrayList<>();
        String currentValue = "";

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                currentValue = "Fizz";
            }
            if (i % 5 == 0) {
                currentValue += "Buzz";
            }
            if (currentValue == "") {
                currentValue = ((Integer) i).toString();
            }
            numList.add(currentValue);
            currentValue = "";
        }
        return numList;
    }

    // reverse a string character by character
    public String reverseString(String s) {
        String rtnStr = "";
        char[] cArr = s.toCharArray();
        char[] cNewArr = new char[cArr.length];

        for (int i = 0; i < cArr.length; i++) {
            cNewArr[i] = cArr[(cArr.length - 1) - i];
        }
        for (int i = 0; i < cArr.length; i++) {
            rtnStr += cNewArr[i];
        }
        return rtnStr;
    }

    // reverse a string word by word
    public String reverseStringByWord(String s) {
        String rtnStr = "";

        return rtnStr;
    }

    // isPalindrome - allow for typos
    public boolean isPalindromeAllowForTypos(String s) {

        char[] cArr = s.toCharArray();
        for (char c : cArr) {
            // so something
        }

        return true;
    }
    // longest non-repeating subsequence (is there an optimal way?)

    // other?

    // Arrays

    // move all 0's to the end

    // find all primes

    // sum total of all contents

    // other?

    // Lists and Hashmaps

    // LinkedLists/DoublyLinkedLists?

    // create a doubly linked list with a hashmap for removals/inserts in O(1)
    // time...

    // other?
}
