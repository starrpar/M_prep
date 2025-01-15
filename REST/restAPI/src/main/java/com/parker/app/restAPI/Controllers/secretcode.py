import requests
import pandas as pd
from bs4 import BeautifulSoup
from io import StringIO

def secretcode(googleDocLocation):

    url = googleDocLocation
    doc = requests.get(url)
    soup = BeautifulSoup(doc.content, features='lxml')

    df_list = pd.read_html(StringIO(str(soup)))

    x_coords = df_list[0][0]
    y_coords = df_list[0][2]
    values = df_list[0][1]
    
    i = 0
    list_of_points = []

    for x_coord in x_coords:
        list = [x_coords[i], y_coords[i], values[i]]
        list_of_points.append(list)
        i += 1
    
    i = 0
    x_max = 0
    for x_coord in x_coords:
        if is_convertible_to_int(x_coords[i]):
            x_val = int(x_coords[i])
            if x_val > x_max:
                x_max = x_val
        i += 1

    i = 0
    y_max = 0
    for y_coord in y_coords:
        if is_convertible_to_int(y_coords[i]):
            y_val = int(y_coords[i])
            if y_val > y_max:
                y_max = y_val
        i += 1

    list_of_rows = []

    i = 0
    j = 0
    list = []
    for x_coord in x_coords:
        if is_convertible_to_int(x_coords[i]):
            x_val = int(x_coords[i])
            if x_val > j:
                j = x_val
                list_of_rows.append(list)
                list = []
                list.append([x_coords[i], y_coords[i], values[i]])
            else:
                list.append([x_coords[i], y_coords[i], values[i]])
        
        i += 1
    if j >= x_max:
        list_of_rows.append(list)

    printSecretCode(list_of_rows, y_max)

def is_convertible_to_int(value):
  if value is None:
      return False
  try:
      int(value)
      return True
  except:
      return False
  
def printSecretCode(list_of_lists, y_max):

    i = 0
    array = []
    j = y_max
    while j >= 0:
        new_list = []
        array.append(new_list)
        j -= 1

    for list in list_of_lists:

        #want to do this in reverse order to be 'upright'
        #print out character value (list[2]) per coordinates
        #where x_coord 0 is 1st column, x_coord 1 is 2nd column, ...
        #and y_coord 0 is "base" row, y_coord 1 is 1st row up from base row, ...

        #y_coord[max] is first "row", y_coord[max-1] is next row, down to y_coord[0]
        #in each row, start with x_coord[0], then x_coord[1], x_coord[2], etc...

        #y_coord[max] is y_coord[i=8]

        #y_coord[8]

        # row[0]: [['0', '0', '█'], ['0', '1', '█'], ['0', '2', '█']]
        # row[1]: [['1', '1', '▀'], ['1', '2', '▀']]
        # row[2]: [['2', '1', '▀'], ['2', '2', '▀']]
        # row[3]: [['3', '2', '▀']]

        #reversed
        # rev(row[0]): [['0', '2', '█'], ['0', '1', '█'], ['0', '0', '█']]
        # rev(row[1]): [['1', '2', '▀'], ['1', '1', '▀']]
        # rev(row[2]): [['2', '2', '▀'], ['2', '1', '▀']]
        # rev(row[3]): [['3', '2', '▀']]

        #conversion - 
        #dimension - y_max
        # what we want:
        #   \/ rev(list 0)    \/ rev(list 1)      \/ rev(list 2)      \/ rev(list 3)
        # new list[0]: ['0', '2', '█']   ['1', '2', '▀']     ['2', '2', '▀']     ['3', '2', '▀']
        # new list[1]: ['0', '1', '█']   ['1', '1', '▀']     ['2', '1', '▀']
        # new list[2]: ['0', '0', '█']

        i = y_max
        while i >= 0:
            rev_list = reversed(list)
            for item in rev_list:
                if int(item[1]) == i:
                    array[i].append(item[2])

            i -= 1
    
    rev_array = []
    j = y_max
    while j >= 0:
        new_list = array[j]
        rev_array.append(new_list)
        j -= 1

    for list in rev_array:
        i = 0
        str = ""
        while i < len(list):
            str += list[i]
            i += 1
        print(str)

    # print('len(list_of_lists) - i.e. width:',len(list_of_lists),' y_max - i.e. height:',y_max + 1)

# secretcode('https://docs.google.com/document/u/0/d/e/2PACX-1vRMx5YQlZNa3ra8dYYxmv-QIQ3YJe8tbI3kqcuC7lQiZm-CSEznKfN_HYNSpoXcZIV3Y_O3YoUB1ecq/pub?pli=1')
           
secretcode('https://docs.google.com/document/d/e/2PACX-1vQGUck9HIFCyezsrBSnmENk5ieJuYwpt7YHYEzeNJkIb9OSDdx-ov2nRNReKQyey-cwJOoEKUhLmN9z/pub')