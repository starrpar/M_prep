import sys

def isPalindrome(my_str):
    str1 = my_str.replace(" ", "")
    str1a = str1.replace(",","")
    str1b = str1a.replace(".","")
    str2 = str1b.lower()
    for i in range(len(str2)):
        if str2[i] != str2[len(str2)-1-i]:
            return False;
    return True;

palin_str = "A man, a plan, a canal, Panama."
print(isPalindrome(palin_str))

def useListsAndDictionaries(array):

    myList = []
    for x in array:
        myList.append(x)
    print("1:", myList)

    myList = []
    [myList.append(x) for x in array]
    print("2:", myList)
    
    #research - why use of list(map(...)) with lambda x:?
    myList = []
    myList = list(map(lambda x: x**2, array))
    print("3:", myList)

    myDict = {}
    myDict = {x: x**2 for x in array}
    print(myDict)
    

array = {1, 1, 1, 2, 3, 10, 12, -3, -3, 2, 3, 45, 800, 99, 98, 0, -1, -1, 2, 3, 4, 5, 0, -1, -1}
# print(array)
print(useListsAndDictionaries(array))

def reverseWords(s):
    """
    :type s: str
    :rtype: str
    """
    #remove leading/trailing spaces
    s = s.strip()

    #create a list from string
    s_split = s.split()
    #remove extra whitespace
    s_cleaned = " ".join(s_split)

    #create list from cleaned string parsed by spaces
    word_list = s_cleaned.split(" ")

    #reverse cleaned list of words
    word_list_reversed = word_list[::-1]
    
    separator = " "
    word_list_reversed_str = separator.join(word_list_reversed)
    return word_list_reversed_str

testStr = "the sky  is blue   "
print(reverseWords(testStr))

def getHint(secret, guess):
    """
    :type secret: str
    :type guess: str
    :rtype: str
    """
    #compare secret to guess; determine how many digits match in place;
    #second, determine how many digits are present but in wrong position;
    #third? determine how many digits are present in guess and do not exist in secret (necessary?)
    #
    bulls = 0
    cows = 0

    digitOccurrenceMap = {}
    
    #constraint is secret.length == guess.length
    for i in range (len(secret)):
        #if in right position, a bull
        if secret[i] == guess[i]:
            bulls = bulls + 1
        else:
            if secret[i] in digitOccurrenceMap:
                currentNum = digitOccurrenceMap[secret[i]]
                incremented = currentNum + 1
                digitOccurrenceMap[secret[i]] = incremented
            else:
                digitOccurrenceMap[secret[i]] = 1
    
    #if exists in secret, but not a bull, a cow, but only up to number present in secret
    #how determine? capture in dictionary how many occurrences of a given digit that are
    #not bulls
    digitNumChecked = {}
    for i in range(len(guess)):
        if secret[i] != guess[i]:
            if guess[i] in digitOccurrenceMap:
                #increment number already found
                if guess[i] in digitNumChecked:
                    currentNum = digitNumChecked[guess[i]]
                    incremented = currentNum + 1
                    digitNumChecked[guess[i]] = incremented
                else:
                    digitNumChecked[guess[i]] = 1
                    
                #add/increment cow
                if digitNumChecked[guess[i]] <= digitOccurrenceMap[guess[i]]:
                    cows = cows + 1
    
    # for key, value in digitOccurrenceMap.items():
    #     print(digitOccurrenceMap.keys(), digitOccurrenceMap.values())
    
    hint = str(bulls) + "A" + str(cows) + "B"
    return hint

secret = [1,1,1,1,1,2,3,4]
guess = [1,1,0,0,0,0,3,4]
print(getHint(secret, guess))

#not complete
def isPatternMatch(s, p):
    """
    :type s: str
    :type p: str
    :rtype: bool
    """
    #s is a string of characters
    #p is a pattern attempting to "describe" the string s
    #if p DOES successfully describe s, return true
    #else return false

    retVal = True
    
    # i = 0
    j = 0
    for i in range(0, len(s)):
        # if j < len(p):
        #     print("i: " + str(i) + ", j: " + str(j) + ", s: " + s[i] + ", p: " + p[j])

        continuation = False
        if i > 1:
            previous = s[i-1]
        else:
            previous = s[i]
        
        # print("i: " + str(i) + ", previous: " + previous)
        
        if j < len(p) and p[j] == '*':
            continuation = True
            #verify however many s[i] and increment i
            if s[i] != previous:
                # print("marking false: " + s[i])
                print("1:returning false")
                retVal = False
            elif j < len(p) - 1:
                # print("incrementing j")
                j = j + 1
                continue
            else:
                # print("still true")
                continue
        
        if j < len(p) and (p[j] == s[i]):
            # print("i :" + str(i) + ", j:" + str(j) + ", p[j] matches s[i]: " + p[j] + "::" + s[i])
            if i < len(s) - 1:
                i = i + 1
                if j < len(p) - 1:
                    j = j + 1
                else:
                    print("2:returning false - could not increment j")
                    retVal = False
                    continue
                    
                    # print("problem: did not increment j, but should have")
                    # j = j + 1
                    # print("i: " + str(i) + ", j: " + str(j))
                    # print("s[i]: " + s[i] + ", p[j]: " + p[j])
        elif j < len(p) and (p[j] == '.'):
            # print("p[j]: " + p[j] + "::" + s[i])
            if i < len(s):
                i = i + 1
            if j < len(p) - 1:
                j = j + 1
        # elif p[j] != s[i]:
        #     print("3:returning false")
        #     retVal = False
        #     continue
        else:
            # print("j is: " + str(j) + ", len(p) is: " + str(len(p)))
            # print("in else... p[j] matches s[i]: " + p[j] + "::" + s[i])
            print("4:returning false")
            retVal = False
        
        
        # if i < len(s):
        #     i = i + 1
        # if j < len(p):
        #     j = j + 1
        
    return retVal

s = "abab"
p = "ab*a*b"
print(isPatternMatch(s, p))


# def isMonotonic(array):
    
#     if len(array) <= 2:
#         return True;
        
#     previous = 0;
#     retVal = True
#     if array[0] < 0:
#         for arr in array:
#             if arr <= previous:
#                 previous = arr
#             else:
#                 retVal = False
#     else:
#         retVal = True
#         previous = 0
#         for arr in array:
#             if arr >= previous:
#                 previous = arr
#             else:
#                 retVal = False
#     return retVal

# def longestPeakPy(array):
#     if len(array) <= 0:
#         return 0
        
#     previous = array[0]
#     # longest = -sys.maxsize - 1
#     longest = 0
#     count = 1
#     peaked = False
#     i = 0

#     for arr in array:
#         if i > 0:
#             print('arr: ' + str(arr) + ', previous: ' + str(previous))
#             if arr > previous:
#                 print("climbing, value: " + str(arr))
#                 if previous_to_previous > previous:
#                     count = 2
#                 else:
#                     count += 1
#                 previous_to_previous = previous
#                 previous = arr
                    
#             elif arr == previous:
#                 print("plateau, value: " + str(arr))
#                 previous_to_previous = previous
#                 previous = arr
#                 peaked = False
#                 count = 1
#             elif arr < previous: #only other alternative
#                 print("descending, value: " + str(arr))
            
#                 count += 1
#                 print('p2p: ' + str(previous_to_previous) + ', previous: ' + str(previous))
#                 if previous_to_previous < previous or peaked:
#                     if count > longest:
#                         print('setting longest to count: ' + str(count))
#                         longest = count
#                     print('peaked...')
#                     peaked = True
#                 else:
#                     peaked = False
#                     count = 1
                
#                 print('arr: ' + str(arr) + ', array[len(array) - 1]: ' + str(array[len(array) - 1]))
#                 if arr == array[len(array) - 1] and peaked:
#                     if count > longest:
#                         print('setting longest to count: ' + str(count))
#                         longest = count
                        
#                 previous_to_previous = previous
#                 previous = arr
#         else:
#             #first pass
#             print('initial value: ' + str(arr))
#             previous_to_previous = previous
        
#         print('count: ' + str(count) + ', longest: ' + str(longest))
#         i += 1
        
#     return longest

# array = {1, 1, 1, 2, 3, 10, 12, -3, -3, 2, 3, 45, 800, 99, 98, 0, -1, -1, 2, 3, 4, 5, 0, -1, -1}
# print(longestPeakPy(array))
