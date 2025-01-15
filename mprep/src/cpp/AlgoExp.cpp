#include <vector>
#include <iostream>
#include <string>
using namespace std;

string runLengthEncoding(string);
vector<int> bubbleSort(vector<int>);
vector<int> insertionSort(vector<int>);
vector<int> selectionSort(vector<int>);
int longestPeak(vector<int>);

// int main(int argc, char *argv[])
// {
//     string testStr1 = "AAAAAAAAAAAAABBCCCCDD";
//     string testStr2 = "aA";
//     string testStr3 = "122333";
//     string testStr4 = "************^^^^^^^$$$$$$%%%%%%%!!!!!!AAAAAAAAAAAAAAAAAAAA";
//     string testStr5 = "aAaAaaaaaAaaaAAAABbbbBBBB";
//     string testStr6 = "                          ";
//     string testStr7 = "1  222 333    444  555";
//     string testStr8 = "1A2BB3CCC4DDDD";
//     string testStr9 = "........______=========AAAA   AAABBBB   BBB";
//     string testStr10 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//     string testStr11 = "        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//     string testStr12 = " ";
//     string testStr13 = "[(aaaaaaa,bbbbbbb,ccccc,dddddd)]";
//     string testStr14 = ";;;;;;;;;;;;''''''''''''''''''''1233333332222211112222111s";
//     string testStr15 = "AAAAAAAAAAAAABBCCCCDDDDDDDDDDD";
//     cout << runLengthEncoding(testStr9);

//     vector<int> array = {8, 5, 2, 9, 5, 6, 3};
//     selectionSort(array);
//     insertionSort(array);
//     bubbleSort(array);

//     vector<int> array2 = {1, 1, 1, 2, 3, 10, 12, -3, -3, 2, 3, 45, 800, 99, 98, 0, -1, -1, 2, 3, 4, 5, 0, -1, -1};
//     // should output 9
//     cout << longestPeak(array2);
// }

// expected results of below...
//  ---------- Test Case 1 ----------
//  AAAAAAAAAAAAABBCCCCDD
//  9A4A2B4C2D

// ---------- Test Case 2 ----------
// aA
// 1a1A

// ---------- Test Case 3 ----------
// 122333
// 112233

// ---------- Test Case 4 ----------
// ************^^^^^^^$$$$$$%%%%%%%!!!!!!AAAAAAAAAAAAAAAAAAAA
// 9*3*7^6$7%6!9A9A2A

// ---------- Test Case 5 ----------
// aAaAaaaaaAaaaAAAABbbbBBBB
// 1a1A1a1A5a1A3a4A1B3b4B

// ---------- Test Case 6 ----------

// 9 9 8

// ---------- Test Case 7 ----------
// 1  222 333    444  555
// 112 321 334 342 35

// ---------- Test Case 8 ----------
// 1A2BB3CCC4DDDD
// 111A122B133C144D

// ---------- Test Case 9 ----------
// ........______=========AAAA   AAABBBB   BBB
// 8.6_9=4A3 3A4B3 3B

// ---------- Test Case 10 ----------
// aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
// 9a9a9a9a9a9a9a9a9a9a9a9a9a9a9a9a9a9a9a9a9a9a9a1a

// ---------- Test Case 11 ----------
//         aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
// 8 9a9a9a9a9a4a

// ---------- Test Case 12 ----------

// 1

// ---------- Test Case 13 ----------
// [(aaaaaaa,bbbbbbb,ccccc,dddddd)]
// 1[1(7a1,7b1,5c1,6d1)1]

// ---------- Test Case 14 ----------
// ;;;;;;;;;;;;''''''''''''''''''''1233333332222211112222111s
// 9;3;9'9'2'111273524142311s

// ---------- Test Case 15 ----------
// AAAAAAAAAAAAABBCCCCDDDDDDDDDDD
// 9A4A2B4C9D2D

string runLengthEncoding(string str)
{
    // All characters types are permitted (so spaces, special chars,
    // etc.. - wonder about single and double quotes and use of escape char (\)?)

    char prevChar = '\0';
    int currentNum = 0;
    string retStr = "";
    cout << str << "\n";

    for (int i = 0; i < str.length(); i++)
    {
        // cout << "(i: " << i << "; " << str[i] << "... currentNum: " << currentNum << ") \n";
        char currentChar = str[i];
        currentNum++;

        if (i <= 0 || (i > 0 && currentChar == prevChar))
        {
            // if we have a match to last character,
            // either simply continue, or, if at a count of 9
            // capture that and then continue
            // and, if this is the last character in the string, close it out
            if (currentNum == 9)
            {
                retStr += to_string(currentNum) + currentChar;
                // cout << "1.5: " << currentNum << ", " << currentChar << "\n";
                // cout << "1.5: " << retStr << "\n";
                currentNum = 0;
            }
            else if (i == str.length() - 1)
            { // i.e. last character
                retStr += to_string(currentNum) + currentChar;
                // cout << "10a: " << currentNum << ", " << currentChar << "\n";
                // cout << "10a: " << retStr << "\n";
            }
            // else{
            //   cout << "1.25b: " << currentNum << ", " << currentChar << "\n";
            // }
        }
        // else, i.e. if currentChar does NOT match prevChar
        // then need to capture current run-length
        // and start on next run length
        // unless last character, in which case close it out
        // and remember, may not have closed out last run yet
        else
        {
            if (currentNum > 1)
            {
                retStr += to_string(currentNum - 1) + prevChar;
                // cout << "2: " << currentNum-1 << ", " << prevChar << "\n";
                // cout << "2: " << retStr << "\n";
                currentNum = 1;
            }

            if (i == str.length() - 1)
            { // i.e. last character
                retStr += to_string(currentNum) + currentChar;
                // cout << "10b: " << currentNum << ", " << currentChar << "\n";
                // cout << "10b: " << retStr << "\n";
            }
        }

        prevChar = currentChar;
    }
    // cout << retStr << "\n";

    return retStr;
}

void swap(int i, int j, vector<int> &array)
{
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}
vector<int> selectionSort(vector<int> array)
{
    // methodology: find smallest value, and swap it with the value just past the end of sorted section at beginning of array
    int leastIndex = 0;
    int nextIndex = 0;

    while (nextIndex < array.size() - 1)
    {
        for (int i = nextIndex; i < array.size(); i++)
        {
            if (array[i] < array[leastIndex])
            {
                leastIndex = i;
            }
        }
        swap(leastIndex, nextIndex, array);
        nextIndex++;
        leastIndex = nextIndex;
        for (int i = 0; i < array.size(); i++)
        {
            cout << array[i];
        }
        cout << "\n";
    }

    cout << "\n";
    return array;
}

void swapPlaces(int j, vector<int> &array)
{
    int temp = array[j];
    array[j] = array[j - 1];
    array[j - 1] = temp;
}
vector<int> insertionSort(vector<int> array)
{
    int j = 0;
    int temp = 0;
    for (int i = 0; i < array.size(); i++)
    {
        j = i;
        while (j > 0 && array[j] < array[j - 1])
        {
            // cout << array[j] << " is less than " << array[j-1] << ", so swapping\n";
            swapPlaces(j, array);
            j--;
            for (int k = 0; k < array.size(); k++)
            {
                cout << array[k];
            }
            cout << "\n";
        }
    }
    cout << "\n";
    return array;
}

vector<int> bubbleSort(vector<int> array)
{

    bool sorted = false;
    int counter = 0;
    int temp = 0;
    while (!sorted)
    {
        sorted = true;
        for (int i = 0; i < array.size() - 1 - counter; i++)
        {
            // std::cout << "i = " << i << ", comparing: " << array[i] << " to " << array[i+1] << "\n";
            if (array[i] > array[i + 1])
            {
                // std::cout << array[i] << ", " << array[i+1] << "\n";

                sorted = false;
                temp = array[i + 1];
                array[i + 1] = array[i];
                array[i] = temp;
            }
            // else{
            //   std::cout << "else condition: " << array[i] << ", " << array[i+1] << "\n";
            // }
        }
        counter++;
    }
    for (int i = 0; i < array.size(); i++)
    {
        cout << array[i];
    }
    cout << "\n";
    cout << "\n";

    return array;
}

int longestPeak(vector<int> array)
{

    // strategy: find strictly increasing first (not == / flat); then find strictly decreasing until not
    // track longest occurring and simply report longest at end
    int longest = 0;
    int count = 1;
    bool peakReached = false;
    bool peakWasReached = false;
    bool climbing = false;
    bool setPeakReachedTrue = false;
    int previous = 0;

    for (int i = 0; i < array.size(); i++)
    {
        if (i == 0)
        {
            previous = array[i];
            continue;
        }
        if (!peakReached)
        {
            if (array[i] > previous)
            { // strictly greater than
                count++;
                climbing = true;
                cout << "climbing... " << previous << " -> " << array[i] << ", count = " << count << "\n";
                previous = array[i];
            }
            else if (array[i] < previous)
            {
                if (climbing)
                {
                    climbing = false;
                    setPeakReachedTrue = true;
                    count++;
                    cout << "Peak reached, descending... " << previous << " -> " << array[i] << ", longest = " << longest << ", count = " << count << "\n";
                    previous = array[i];
                }
                else
                {
                    count = 1;
                    cout << "descending... " << previous << " -> " << array[i] << ", count = " << count << "\n";
                    previous = array[i];
                }
            }
            else if (array[i] == previous)
            {
                count = 1;
                climbing = false;
                cout << "plateau " << previous << " == " << array[i] << ", count = " << count << "\n";
            }
            else
            {
                cout << "why are we here? -- investigate...\n";
            }
        }
        // once peak reached
        if (peakReached)
        {
            if (array[i] < previous)
            { // strictly less than
                count++;
                cout << "descending: " << previous << " -> " << array[i] << ", count = " << count << "\n";
                previous = array[i];
            }
            else if (array[i] > previous)
            {
                if (count > longest)
                {
                    longest = count;
                }
                count = 2;
                peakReached = false;
                climbing = true;
                cout << "starting to climb again: " << previous << " -> " << array[i] << ", longest = " << longest << ", count = " << count << "\n";
                previous = array[i];
            }
            else
            { // plateau after reaching a peak, reset
                if (count > longest)
                {
                    longest = count;
                }
                count = 1; // start over
                peakReached = false;
                cout << "plateau when descending from a peak - start over: " << previous << " -> " << array[i] << ", longest = " << longest << ", count = " << count << "\n";
                previous = array[i];
            }
        }

        if (setPeakReachedTrue)
        {
            peakReached = true;
            peakWasReached = true;
            setPeakReachedTrue = false;
        }
        if (i == array.size() - 1 && count > longest && peakWasReached)
        {                    // at last array index
            longest = count; // capture value at end
            cout << "longest being set to: " << longest << "\n";
        }
    }

    cout << "longest: " << longest << "\n";
    return longest;
}

class BST
{
public:
    int value;
    BST *left;
    BST *right;

    BST(int val);
    BST &insert(int val);
};

bool validateBstHelper(BST *, int, int);

bool validateBst(BST *tree)
{
    return validateBstHelper(tree, INT_MIN, INT_MAX);
}

bool validateBstHelper(BST *tree, int min, int max)
{
    if (tree == NULL)
    {
        return true;
    }
    if (tree->value < min || tree->value >= max)
    {
        return false;
    }
    bool leftValid = validateBstHelper(tree->left, min, tree->value);
    bool rightValid = validateBstHelper(tree->right, tree->value, max);
    return leftValid && rightValid;
}

bool isPalindrome(string str)
{
    bool isPal = false;

    int i = 0;
    while (str[i] == str[str.length() - 1 - i] && i < (str.length() + 1) / 2)
    {
        i++;
        continue;
    }
    if (i == (str.length() + 1) / 2)
    {
        isPal = true;
    }

    return isPal;
}

vector<int> sweetAndSavory(vector<int> dishes, int target)
{
    vector<int> retArr = {0, 0};
    int total = 0;
    int bestResult = INT_MIN;
    int sweet = 0;
    int savory = 0;
    bool quit = false;

    for (int i = 0; i < dishes.size(); i++)
    {
        total = 0;
        quit = false;
        for (int j = i; j >= 0; j--)
        {
            if (i != j)
            {
                if ((dishes[i] > 0 && dishes[j] < 0) || (dishes[i] < 0 && dishes[j] > 0))
                {
                    total = dishes[i] + dishes[j];
                    // cout << "d[i]: " << dishes[i] << ", d[j]: " << dishes[j] << "\n";
                    if (total <= target)
                    {
                        // cout << "total: " << total << ", target: " << target << "\n";
                        if (total > bestResult)
                        {
                            bestResult = total;
                            // cout << "bestResult: " << bestResult << "\n";
                            if (dishes[i] < dishes[j])
                            {
                                sweet = dishes[i];
                                savory = dishes[j];
                            }
                            else
                            {
                                savory = dishes[i];
                                sweet = dishes[j];
                            }
                            // cout << "sweet: " << sweet << ", savory: " << savory << "\n";
                            quit = true;
                        }
                    }
                }
            }
        }
    }

    return {sweet, savory};
}

public
boolean zeroSumSubarray(int[] nums)
{
    boolean retVal = false;
    int total = 0;
    int index = 0;

    for (int i = 0; i < nums.length; i++)
    {
        total = 0;
        for (int j = i; j >= 0; j--)
        {
            total += nums[j];
            if (total == 0)
            {
                index = j;
                retVal = true;
                break;
            }
        }
        if (!retVal)
        {
            int[] subA = new int[i - index];
            for (int j = 0; j < i; j++)
            {
                subA[j] = nums[i - index];
            }
        }
        else
        {
            break;
        }
    }
    return retVal;
}
