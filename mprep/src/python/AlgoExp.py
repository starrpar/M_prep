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