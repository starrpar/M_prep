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
