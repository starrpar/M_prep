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

secretcode('https://docs.google.com/document/u/0/d/e/2PACX-1vRMx5YQlZNa3ra8dYYxmv-QIQ3YJe8tbI3kqcuC7lQiZm-CSEznKfN_HYNSpoXcZIV3Y_O3YoUB1ecq/pub?pli=1')
           
# secretcode('https://docs.google.com/document/d/e/2PACX-1vQGUck9HIFCyezsrBSnmENk5ieJuYwpt7YHYEzeNJkIb9OSDdx-ov2nRNReKQyey-cwJOoEKUhLmN9z/pub')