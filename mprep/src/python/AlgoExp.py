import sys

def isMonotonic(array):
    
    if len(array) <= 2:
        return True;
        
    previous = 0;
    retVal = True
    if array[0] < 0:
        for arr in array:
            if arr <= previous:
                previous = arr
            else:
                retVal = False
    else:
        retVal = True
        previous = 0
        for arr in array:
            if arr >= previous:
                previous = arr
            else:
                retVal = False
    return retVal

def longestPeakPy(array):
    if len(array) <= 0:
        return 0
        
    previous = array[0]
    # longest = -sys.maxsize - 1
    longest = 0
    count = 1
    peaked = False
    i = 0

    for arr in array:
        if i > 0:
            print('arr: ' + str(arr) + ', previous: ' + str(previous))
            if arr > previous:
                print("climbing, value: " + str(arr))
                if previous_to_previous > previous:
                    count = 2
                else:
                    count += 1
                previous_to_previous = previous
                previous = arr
                    
            elif arr == previous:
                print("plateau, value: " + str(arr))
                previous_to_previous = previous
                previous = arr
                peaked = False
                count = 1
            elif arr < previous: #only other alternative
                print("descending, value: " + str(arr))
            
                count += 1
                print('p2p: ' + str(previous_to_previous) + ', previous: ' + str(previous))
                if previous_to_previous < previous or peaked:
                    if count > longest:
                        print('setting longest to count: ' + str(count))
                        longest = count
                    print('peaked...')
                    peaked = True
                else:
                    peaked = False
                    count = 1
                
                print('arr: ' + str(arr) + ', array[len(array) - 1]: ' + str(array[len(array) - 1]))
                if arr == array[len(array) - 1] and peaked:
                    if count > longest:
                        print('setting longest to count: ' + str(count))
                        longest = count
                        
                previous_to_previous = previous
                previous = arr
        else:
            #first pass
            print('initial value: ' + str(arr))
            previous_to_previous = previous
        
        print('count: ' + str(count) + ', longest: ' + str(longest))
        i += 1
        
    return longest

array = {1, 1, 1, 2, 3, 10, 12, -3, -3, 2, 3, 45, 800, 99, 98, 0, -1, -1, 2, 3, 4, 5, 0, -1, -1}
print(longestPeakPy(array))