package mprep;

import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;
// import java.util.Set;
// import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Comparator;
import java.lang.reflect.Type;
import java.util.Collections;

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

        Pattern pattern = Pattern.compile("\\s");
        String[] sArr = s.split(pattern.toString());

        for (int i = sArr.length - 1; i >= 0; i--) {
            // System.out.println(sArr[i]);
            rtnStr += sArr[i];
            if (i > 0) {
                rtnStr += " ";
            }
        }

        return rtnStr;
    }

    // isPalindrome
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("\\s", "").replaceAll("\\.", "").replaceAll("\\,", "");
        char[] cArr = s.toCharArray();
        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] == cArr[cArr.length - 1 - i]) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    // isPalindrome - allow for typos
    public boolean isPalindromeAllowForTypos(String s) {
        s = s.toLowerCase().replaceAll("\\s", "").replaceAll("\\.", "").replaceAll("\\,", "");
        char[] cArr = s.toCharArray();
        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] == cArr[cArr.length - 1 - i]) {
                // System.out.println("A (i): " + i + ", " + cArr[i] + " :: " + cArr[cArr.length
                // - 1 - i]);
                continue;
            } else {
                // could probably make the following recursive possibly
                if (cArr[i + 1] == cArr[cArr.length - 1 - i]) {
                    // System.out.println("B (i): " + i + ", " + cArr[i + 1] + " :: " +
                    // cArr[cArr.length - 1 - i]);
                    continue;
                } else if (cArr[i] == cArr[cArr.length - i]) {
                    // System.out.println("C (i): " + i + ", " + cArr[i] + " :: " + cArr[cArr.length
                    // - i]);
                    continue;
                } else {
                    if (cArr[i] == cArr[cArr.length - 2 - i]) {
                        // System.out.println("D (i): " + i + ", " + cArr[i] + " :: " + cArr[cArr.length
                        // - 2 - i]);
                        continue;
                    } else if (cArr[i + 1] == cArr[cArr.length - 2 - i]) {
                        // System.out.println("E (i): " + i + ", " + cArr[i + 1] + " :: " +
                        // cArr[cArr.length - 2 - i]);
                        continue;
                    } else {
                        return false;
                    }
                }
            }
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

    // EASY:
    // [SKIP] ----merge 2 sorted arrays
    // DONE: -----remove dupes from an array--
    // made Object array so can take String or Integer types

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

    public Object[] removeDupes(Object[] objs, Type t) {
        List<Object> objList = new ArrayList<>();

        if (t == String.class) {
            for (int i = 0; i < objs.length; i++) {
                String myObj = objs[i].toString();
                if (!objList.contains(myObj)) {
                    // System.out.print(myObj);
                    objList.add(myObj);
                }
            }
        } else if (t == Integer.class) {
            for (int i = 0; i < objs.length; i++) {
                Integer myObj = (Integer) objs[i];
                if (!objList.contains(myObj)) {
                    // System.out.print(myObj);
                    objList.add(myObj);
                }
            }
        }

        System.out.println();
        Object[] rtnArr = new Object[objList.size()];
        for (int i = 0; i < objList.size(); i++) {
            rtnArr[i] = objList.get(i);
        }
        return rtnArr;
    }

    public Map<Object, Integer> countFrequencyOfObjectInArray(Object[] objs, Type t) {
        Map<Object, Integer> objHash = new HashMap<>();

        System.out.println();
        if (t == String.class) {
            for (int i = 0; i < objs.length; i++) {
                String myObj = objs[i].toString();
                objHash = insertValuesInMap(objHash, myObj);
            }
        } else if (t == Integer.class) {
            for (int i = 0; i < objs.length; i++) {
                Integer myObj = (Integer) objs[i];
                objHash = insertValuesInMap(objHash, myObj);
            }
        }

        return objHash;
    }

    public Map<Integer, List<Object>> keySort(Map<Integer, List<Object>> map) {

        Comparator<Integer> valueComparator = new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                int xInt = (int) x;
                int yInt = (int) y;
                return (xInt < yInt) ? -1 : ((xInt == yInt) ? 0 : 1);
            }
        };

        Map<Integer, List<Object>> sorted = new TreeMap<Integer, List<Object>>(valueComparator);
        sorted.putAll(map);
        return sorted;
    }

    public Map<Integer, List<Object>> keyReverseSort(Map<Integer, List<Object>> map) {

        Comparator<Integer> valueComparator = new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                int xInt = (int) x;
                int yInt = (int) y;
                return (xInt < yInt) ? 1 : ((xInt == yInt) ? 0 : -1);
            }
        };

        Map<Integer, List<Object>> sorted = new TreeMap<Integer, List<Object>>(valueComparator);
        sorted.putAll(map);
        return sorted;
    }

    public <K, V extends Comparable<V>> Map<K, V> valueSort(Map<K, V> map) {

        Comparator<K> valueComparator = new Comparator<K>() {
            public int compare(K k1, K k2) {
                int comp = map.get(k1).compareTo(map.get(k2));
                return comp;
            }
        };

        Map<K, V> sorted = new TreeMap<K, V>(valueComparator);
        sorted.putAll(map);
        return sorted;

    }

    // output of the following plus the keyReverseSort above yields the following:
    // 178: [ ]
    // 132: [e]
    // 98: [i]
    // 86: [n]
    // 80: [o, r]
    // 76: [s]
    // 75: [a]
    // 72: [t]
    // 58: [g]
    // 56: [m]
    // 52: [l]
    // 41: [d]
    // 40: [c]
    // 36: [p]
    // 25: [f, h]
    // 24: [u]
    // 18: [,]
    // 14: [y]
    // 12: [w]
    // 10: [v]
    // 9: [b]
    // 7: [.]
    // 4: [k, x]
    // 3: [-, q]
    // 2: [P, [, ], z]
    // 1: [A, C, I, ?, S, W, ', (, ), j, 1, 2]

    public Map<Integer, List<Object>> consolidateMapContents(Map<Object, Integer> map) {
        Map<Integer, List<Object>> sortedMap = new HashMap<>();
        List<Object> keysOfGivenValue = new ArrayList<>();
        for (Integer v : map.values()) {
            for (Object k : map.keySet()) {
                if (map.get(k) == v) {
                    keysOfGivenValue.add(k);
                }
            }
            sortedMap.put(v, keysOfGivenValue);
            keysOfGivenValue = new ArrayList<>();
        }

        return sortedMap;
    }

    private Map<Object, Integer> insertValuesInMap(Map<Object, Integer> map, Object obj) {
        if (map.get(obj) == null) {
            // System.out.print(obj);
            map.put(obj, 1);
        } else {
            // System.out.print(obj);
            map.put(obj, map.get(obj) + 1);
        }
        return map;
    }
}
