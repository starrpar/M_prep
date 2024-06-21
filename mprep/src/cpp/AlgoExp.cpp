#include <iostream>
#include <string>
using namespace std;

string runLengthEncoding(string);

int main(int argc, char *argv[])
{
    string testStr1 = "AAAAAAAAAAAAABBCCCCDD";
    string testStr2 = "aA";
    string testStr3 = "122333";
    string testStr4 = "************^^^^^^^$$$$$$%%%%%%%!!!!!!AAAAAAAAAAAAAAAAAAAA";
    string testStr5 = "aAaAaaaaaAaaaAAAABbbbBBBB";
    string testStr6 = "                          ";
    string testStr7 = "1  222 333    444  555";
    string testStr8 = "1A2BB3CCC4DDDD";
    string testStr9 = "........______=========AAAA   AAABBBB   BBB";
    string testStr10 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    string testStr11 = "        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    string testStr12 = " ";
    string testStr13 = "[(aaaaaaa,bbbbbbb,ccccc,dddddd)]";
    string testStr14 = ";;;;;;;;;;;;''''''''''''''''''''1233333332222211112222111s";
    string testStr15 = "AAAAAAAAAAAAABBCCCCDDDDDDDDDDD";
    cout << runLengthEncoding(testStr9);
}

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
