package mprep;

import java.util.List;
import java.util.ArrayList;

public class MetaCodingIntvw {

    // 1. Toeplitz Matrix
    // Problem Statement: Given an m x n matrix, determine if a given matrix is a
    // Toeplitz matrix.

    // A Toeplitz matrix is one in which every diagonal from top-left to
    // bottom-right has the same elements.

    // In other words, the matrix should have the property that each element is
    // equal to the element diagonally down to its right.

    // Example:

    // Input: [[1,2,3],[4,1,2],[5,4,1]]
    // Expected Output: true
    // Justification: All diagonals have the same elements. Diagonals of the above
    // matrix are [5], [4, 4], [1, 1, 1], [2, 2], and [3].
    // Difficulty Level: Easy

    // Solution: Toeplitz Matrix
    public boolean isToeplitzMatrix(int[][] matrix) {
        boolean isToeplitzMatrix = false;
        List<List<Integer>> stripedArray = new ArrayList<>();
        int baseColumn = matrix[0].length - 1;
        int baseRow = 0;
        int baseColumn2 = 0;
        int baseRow2 = matrix[0].length - 1; // cheating but same as square matrix
        int columnIncrement = 0;
        int rowIncrement = 0;
        int columnIncrement2 = 0;
        int rowIncrement2 = 0;
        int columnIncrement3 = 0;
        int rowIncrement3 = 0;
        int column = 0;
        int row = 0;
        int step = 0;
        int stripedIndex = 0;

        step = 0;
        column = 2;
        int len = matrix[column].length;
        for (int j = 0; j < len; j++) {
            columnIncrement = baseColumn - step; // 2 - 0/1/2
            rowIncrement = baseRow + step; // 0 + 0/1/2
            System.out.println("columnIncrement: " + columnIncrement);
            System.out.println("rowIncrement: " + rowIncrement);

            for (int k = matrix[0].length - 1; k >= 0; k--) {
                column = k;
                len = matrix[k].length;
                List<Integer> tmpList = new ArrayList<>();
                for (int l = 0; l < len; l++) {
                    row = l;
                    // need to come up with a 'continuous' way of saying this...
                    // "from" where the first condition is met
                    // "to" the second condition
                    // and all steps in between, incrementing by "one down, one over", which
                    // constitutes the diagonal...
                    // f0r(int m = baseColumn, int n = baseRow; m >= columnIncrement, n <
                    // rowIncrement; m--, n++){
                    int m = baseColumn;
                    int n = baseRow;
                    while (m >= columnIncrement && n < rowIncrement) {
                        System.out.println("column: " + column + ", row: " + row + " value: " + matrix[k][l]);
                        tmpList.add(matrix[k][l]);
                        m--;
                        n++;
                    }

                    // if ((column == columnIncrement && row == baseRow)
                    // || (column == baseColumn && row == rowIncrement)) {
                    // System.out.println("column: " + column + ", row: " + row + " value: " +
                    // matrix[k][l]);
                    // tmpList.add(matrix[k][l]);
                    // }
                }
                stripedArray.add(tmpList);
            }
            step++;
            stripedIndex++;
            System.out.println("step: " + step);
        }

        step = 1;
        column = 0;
        len = matrix[column].length - 2;
        for (int j = 0; j < len; j++) {
            // columnIncrement2 = baseColumn2 + step; // 0 + 0/1/2
            // rowIncrement2 = baseRow2 - step; // 2 - 0/1/2
            columnIncrement3 = baseColumn2 + step; // 0 + 1/0
            rowIncrement3 = baseRow2 - step; // 2 - 1/0
            System.out.println("columnIncrement3: " + columnIncrement3);
            System.out.println("rowIncrement3: " + rowIncrement3);

            for (int k = matrix[0].length - 1; k >= 0; k--) {
                column = k;
                len = matrix[k].length;
                List<Integer> tmpList = new ArrayList<>();
                for (int l = 0; l < len; l++) {
                    row = l;
                    // this approach only produces 2 values - need an approach that produces ALL
                    // values for a given diagonal
                    // also note that at the corners (1 cell diagonals) the values produced by both
                    // conditions (when step = 0) are
                    // the same - so the fix for the 1st issue - to get all values on all but the
                    // corner diagonals (1 and 2 cell)
                    // this may indicate this approach isn't sufficient - need to think on this...

                    // how to traverse full diagonal? looking for a "sum" of the 2 components that
                    // totals some value
                    //

                    if ((column == columnIncrement3 && row == baseRow2)
                            || (column == baseColumn2 && row == rowIncrement3)) {
                        System.out.println("column: " + column + ", row: " + row + " value: " + matrix[k][l]);
                        tmpList.add(matrix[k][l]);
                    }
                }
                stripedArray.add(tmpList);
            }
            if (step < matrix[0].length - 1 && step > 0) {
                step--;
                System.out.println("step: " + step);
            } else {
                break;
            }
        }
        System.out.println(stripedArray);

        // so far, this is what we're getting:
        // [[5], [], [], [4], [4], [], [1], [], [1], [], [], [3], [], [2], [2], [1], [],
        // [1]]
        // or, focused down...
        // [[5] ... [4], [4] ... [1], [], [1] ... [3] ... [2], [2]]
        // and we want:
        // [[5] ... [4], [4] ... [1], [1], [1] ... [2], [2] ... [3]]

        // ToDo:
        // - getting middle value: [1], [1], [1]
        // - this will require determining ALL "middle" cells between the extremes
        // (first and last only on middle diagonal)
        // - this will also be required for all "other middle" diagonals (meaning beyond
        // the corner diagonals that consist
        // of only one or two cells on the top right and bottom left corners of the
        // matrix)
        //
        //
        // - and order of [3] ... [2], [2] - should be simply assigning to correct
        // column in stripedArray
        // FIXED: by reversing order of step (decreasing) and limiting travel (< len -
        // 1; > 0)
        //
        // - not getting repeat of [1], [], [1] - this should be easy enough - just stop
        // before repeating middle diagonals
        // FIXED: by limiting incrementing 'step' value

        // so getting close, meaning we want the [5], [4][4], and [1][1][1], and then
        // [2][2] and [3]...
        // could then extrapolate that to any size square matrix and determine if those
        // diags were made up
        // of only same values, then the answer to isToeplitzMatrix would be 'true'

        // strategy analysis below. Problems still - missing "middle" cell (get [0,0]
        // and [2,2], but not [1,1]),
        // also, not yet also getting "other half" - meaning not getting [0,1] and [1,2]
        // or [0,2]...
        // should be able to get those by simply reversing the "step" amount

        // matrix is correctly read in; how to assess diagonals? (come up with simple
        // algorithm)
        // for each 'next row', you will want to move one add'l 'next column' over to
        // compare
        // so from 1st row, last column
        // to 1st row, 2nd to last column compared to 2nd row, last column
        // to 1st row, 3rd from last column, compared to 2nd row, 2nd from last column,
        // compared to 3rd row, last column
        // etc...
        // until end for last row, first column by itself

        // so we can either deal with a set of columns, and row levels within those
        // columns
        // or a set of rows, and columns within each of those rows

        // choosing a set of columns, and row levels within those columns
        // so matrix looks like this:
        // 1 4 5
        // 2 1 4
        // 3 2 1
        // ...and we would match 5 (top right), then [4,4], then [1,1,1], then [2,2]
        // then 3 (bottom left)
        // (i,j) for this matrix would be:
        // (0,0) (1,0) (2,0)
        // (0,1) (1,1) (2,1)
        // (0,2) (1,2) (2,2)
        // so matching "pattern" is (i,j) matches (i+1, j+1) matches (i+2, j+2)
        // or (i,j) == (i+x,j+x), where x = 0...array dimension (must be square array
        // for this (diagonals) to be logical)

        // approach: create a "stripedArray" that will contain contents of each diagonal
        // so [2,0]
        // then [1,0] and [2,1]
        // then [0,0], [1,1] and [2,2]
        // then [0,1] and [1,2]
        // and finally [0,2]

        // how to "refer" to these?
        // the dimension will always be the square of the (dimension - 1) + 1
        // so for a 3 x 3 matrix like this, it will be (2 x 2) + 1 = 5

        // and then we just have to identify a pattern/approach for storage of the cells
        // within that stripedArray
        // which will match "last, upper cell", then in and down one, then in and down
        // one, rinse - repeat, until final
        // is "first column, last (bottom) cell" or of course vice-versa - same thing

        // so at end of first column, store in 1st stripedArray List
        // then, in first column, row BEFORE last, store in 2nd stripedArray List, as
        // well as last entry in "next" (2nd) column
        // then, rinse/repeat until finally reaching last column and first entry, which
        // will go in final/last stripedArray List

        // manage using column and row "counters"
        // pattern is: initial - max column, min row
        // next - column - 1, same row; same column, row + 1
        // next - rinse and repeat until column or row length (matrix dimension) reached
        // next - then close down opposite of initial
        // ending at - least column [0], max row

        return isToeplitzMatrix;
    }

}

// 2. Remove All Adjacent Duplicates In String
// Problem Statement: Given a string S, remove all adjacent duplicate characters
// recursively to generate the resultant string.

// Example:

// Input: s = "abccba"
// Expected Output: “”
// Justification: First, we remove "cc" to get "abba". Then, we remove "bb" to
// get "aa". Finally, we remove "aa" to get an empty string.
// Difficulty Level: Easy

// Solution: Remove All Adjacent Duplicates In String

// 3. Minimum Depth of a Binary Tree
// Problem Statement: Find the minimum depth of a binary tree. The minimum depth
// is the number of nodes along the shortest path from the root node to the
// nearest leaf node.

// Example:

// Image
// minimum depth of a binary tree
// Difficulty Level: Easy

// Solution: Minimum Depth of a Binary Tree

// 4. Tree Diameter
// Problem Statement: Given a binary tree, find the length of its diameter. The
// diameter of a tree is the number of nodes on the longest path between any two
// leaf nodes. The diameter of a tree may or may not pass through the root.

// Note: You can always assume that there are at least two leaf nodes in the
// given tree.

// Example:

// Image
// Tree diameter
// Expected Output: 5
// Justification: The diameter of the tree is: [4,2,1,3,6]
// Difficulty Level: Easy

// Solution: Tree Diameter

// 5. Island Perimeter
// Problem Statement: You are given a 2D matrix containing only 1s (land) and 0s
// (water).

// An island is a connected set of 1s (land) and is surrounded by either an edge
// or 0s (water). Each cell is considered connected to other cells horizontally
// or vertically (not diagonally).

// There are no lakes on the island, so the water inside the island is not
// connected to the water around it. A cell is a square with a side length of 1.
// The given matrix has only one island, write a function to find the perimeter
// of that island.

// Example:

// Input: matrix=
// Image
// Expected Output: 14
// Justification: The boundary of the island constitutes 14 sides.
// Difficulty Level: Easy

// Solution: Island Perimeter

// 6. Move Zeroes
// Problem Statement: Given an array of integers nums, move all the 0s, which
// are present in the array to the end while maintaining the relative order of
// the non-zero elements.

// Note: This rearrangement should be done in-place without using extra space
// for another array.

// Example:

// Input: [1, 0, 2, 0, 3, 0, 4]
// Expected Output: [1, 2, 3, 4, 0, 0, 0]
// Justification: Here, all non-zero elements (1, 2, 3, 4) retain their order,
// and all zeros are moved to the end of the array.
// Difficulty Level: Easy

// Solution: Move Zeroes

// 7. Missing Ranges
// Problem Statement: You are given two integers, lower and upper, specifying
// the inclusive range, and the sorted array of unique integers nums, where each
// element is in between [lower, upper].

// We can say the number n is missing if n is not in the nums and falls in the
// range [lower, upper].

// Return the shortest sorted list of ranges that covers all missing numbers.
// These ranges should fall within the inclusive bounds specified by the lower
// and upper limit integers.

// Example:

// Input: nums = [0, 1, 3, 50, 75], lower = 0, upper = 99
// Expected Output: [[2, 2], [4, 49], [51, 74], [76, 99]]
// Justification: The missing ranges are 2, 4-49, 51-74, and 76-99. Each missing
// range is represented as a pair in the list, where both numbers are the same
// for a single missing number.
// Difficulty Level: Easy

// Solution: Missing Ranges

// 8. Rank Transform of an Array
// Problem Statement: Given an array arr containing integers, replace each
// element with its rank in the array.

// The rank is determined based on the size of the element compared to others in
// the array.
// Smaller numbers get a lower rank, and equal numbers share the same rank.
// The ranking starts from 1.
// Example:

// Input: [10, 20, 20, 30]
// Expected Output: [1,2,2,3]
// Justification: 10 is the smallest, so its rank is 1. 20, occurring twice,
// shares the rank 2. 30, being the largest, gets the rank 3.
// Difficulty Level: Easy

// Solution: Rank Transform of an Array

// 9. Palindrome Permutation
// Problem Statement: Given a string s, return true if any permutation of the
// given string s can form a palindromic string. Otherwise, return false.

// A palindrome is a word, phrase, number, or other sequences of characters that
// reads the same forward and backward (ignoring spaces, punctuation, and
// capitalization).

// Example:

// Input: "tactcoa"
// Expected Output: true
// Justification: The string can be rearranged to form "tacocat", which is a
// palindrome.
// Difficulty Level: Easy

// Solution: Palindrome Permutation

// 10. Diagonal Traverse
// Problem Statement: Given a 2D matrix of size m x n, return a 1D array
// containing elements of the matrix in the diagonal order.

// Example:

// Input: matrix = [[1,2,3], [4,5,6]]
// Expected Output: [1,2,4,5,3,6]
// Justification: Traversal begins at 1, moves to 2, diagonally down to 4, up to
// 5, down to 3, and finally to 6.
// Image
// Difficulty Level: Medium

// Solution: Diagonal Traverse

// 11. Maximum Swap
// Problem Statement: Given a non-negative integer num, return the maximum
// number, which you can create by swapping any two digits of the number only
// once.

// If no swaps can improve the number, return the original number.

// Example:

// Input: 2736
// Expected Output: 7236
// Justification: Swapping the first and second digits (2 and 7) results in the
// largest possible number.
// Difficulty Level: Medium

// Solution: Maximum Swap

// 12. Custom Sort String
// Problem Statement: You are given two strings pattern and text. It is given
// that all characters of the pattern string are unique.

// Rearrange the characters of the text string based on the characters' order in
// pattern string.

// In other words, if a character a occurs before a character b in the pattern
// string, then a should occur before b in the output string.

// Characters in text that do not appear in pattern should be appended at the
// end of the rearranged string in their original order.

// Example:

// Input: pattern = "xy", text = "yyzx"
// Expected Output: "xyyz"
// Justification: In 'pattern', the order is 'x', 'y'. In the text, 'x' appears
// once, 'y' twice, and 'z' doesn't appear. So, we put z at the end of the
// string. Thus, the output string is xzyy.
// Difficulty Level: Medium

// Solution: Custom Sort String

// 13. Buildings With an Ocean View
// Problem Statement: You are given an array heights of size n, representing the
// heights of n buildings.

// The ocean is to the right of these buildings. A building has an ocean view if
// there are no taller buildings to its right. The task is to find the
// indices(0-based) of all such buildings with an ocean view.

// Example:

// Input: [4, 3, 2, 1]
// Expected Output: [0, 1, 2, 3]
// Justification: Each building is shorter than the one to its left, hence all
// have an ocean view.
// Difficulty Level: Medium

// Solution: Buildings With an Ocean View

// 14. Basic Calculator II
// Problem Statement: Given a string s, representing the mathematical
// expression, evaluate the expression and return the integer value.

// The integer division should truncate toward zero.

// Note: You are not allowed to use the built-in functions like eval().

// Example:

// Input: "8*5/4+3-2"
// Expected Output: 11
// Justification: The calculation proceeds as follows: 8*5 = 40, 40/4 = 10, 10+3
// = 13, 13-2 = 11.
// Difficulty Level: Medium

// Solution: Basic Calculator II

// 15. Dot Product of Two Sparse Vectors
// Problem Statement: Given two sparse vectors, efficiently compute the dot
// product of them.

// A sparse vector is one in which most elements are zero.

// Implement class Solution:

// Solution(nums) Initializes the object with the vector nums
// dotProduct(vec) Calculates the dot product between the vec and instance of
// Solution.
// Example:

// Input: vec1 = [1, 0, 0, 2], vec2 = [2, 3, 0, 1]
// Expected Output: 4
// Justification: The dot product is (12) + (03) + (00) + (21) = 2 + 0 + 0 + 2 =
// 4.
// Difficulty Level: Medium

// Solution: Dot Product of Two Sparse Vectors

// 16. Alien Dictionary
// Problem Statement: There is a dictionary containing words from an alien
// language for which we don’t know the ordering of the letters.

// Write a method to find the correct order of the letters in the alien
// language. It is given that the input is a valid dictionary and there exists
// an ordering among its letters.

// Example:

// Input: Words: ["ba", "bc", "ac", "cab"]
// Expected Output: bac
// Justification: Given that the words are sorted lexicographically by the rules
// of the alien language, so from the given words we can conclude the following
// ordering among its characters:
// From "ba" and "bc", we can conclude that 'a' comes before 'c'.

// From "bc" and "ac", we can conclude that 'b' comes before 'a' From the above
// two points, we can conclude that the correct character order is: "bac"

// Difficulty Level: Hard

// Solution: Alien Dictionary

// 17. Best Meeting Point
// Problem Statement: You are given m x n matrix containing 1 and 0 digits only,
// where each 1 represents the home of one friend, return the minimum total
// travel distance.

// The minimal total travel distance is defined as a sum of distances between
// each friend's house and meeting point. Here, you need to find the meeting
// point such that it should have minimal distance from the home of each friend.

// The distance is calculated as the Manhattan distance, which is the sum of the
// absolute differences in the horizontal and vertical coordinates (distance(a1,
// a2) = |a2.x - a1.x| + |a2.y - a1.y|).

// Example:

// Input: [[1,0],[0,1]]
// Expected Output: 2
// Justification: There are two people located at the top-left and bottom-right
// corners. The best meeting point is either of the two empty cells, each
// resulting in a total distance of 2.
// Difficulty Level: Hard

// Solution: Best Meeting Point

// 18. Making A Large Island
// Problem Statement: Given a 2D binary matrix of size n x n, return the integer
// representing the size of the largest island after changing at most 0 to 1.
// Here, Island is defined as a 4-directionally connected group of 1s.

// Example:

// Input: [[1, 0, 1, 0],[0, 1, 1, 0],[0, 0, 0, 1],[1, 1, 0, 0]]
// Expected Output: 6
// Justification: Converting the water cell at position (2,1) will connect two
// large islands (top right and bottom left) with a new land cell, creating an
// island of size 6.
// Difficulty Level: Hard

// Solution: Making a Large Island

// 19. Longest Increasing Path in a Matrix
// Problem Statement: Given a 2D matrix of size m x n, return the length of the
// longest increasing path in the matrix. The increasing path should have each
// element should be greater than the previous element in the path.

// It is given that you can move only in 4-directions: left, right, top, and
// bottom.

// Example:

// Input: matrix =[[3, 4, 5], [3, 2, 6], [2, 2, 1]]
// Expected Output: 4
// Image
// Justification: The longest increasing path is 3 -> 4 -> 5 -> 6. No other path
// has a greater length.
// Difficulty Level: Hard

// Solution: Longest Increasing Path in a Matrix

// 20. Serialize and Deserialize Binary Tree
// Problem Statement: Serialization involves converting a binary tree into a
// string format such that it can be stored in the file or memory, preserving
// its structure and data.

// Deserialization, on the other hand, is about reconstructing the binary tree
// from this string representation.

// Design an algorithm to serialize and deserialize the binary tree. There is no
// restriction on designing the algorithm for serialization and deserialization
// of the binary tree.

// Example:

// Input: [1,2,3,null,null,4,5]
// Image
// Expected Output: [1,2,3,null,null,4,5]
// Justification: The tree starts with the root node 1, followed by its left
// child 2 and right child 3. Since 2 and 3 have no left children, they are
// followed by null. Nodes 4 and 5 are the left and right children of 3.
// Difficulty Level: Hard

// Solution: Serialize and Deserialize Binary Tree

// Image
// Grokking Dynamic Programming Patterns for Coding Interviews
// Image
// Grokking the Coding Interview: Patterns for Coding Questions
// Image
// Grokking the Object Oriented Design Interview
// Final Words
// Meta looks for problem solvers, clear thinkers, and team players.

// It's not just about knowing the right answers but also showing how you
// approach and solve problems. Show them you can tackle tough problems, write
// clean code, and work well with others.

// The questions we’ve covered will give you a solid start, but don’t stop
// there—keep practicing and learning. Most importantly, stay calm and confident
// during your interview.