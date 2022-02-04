#!/usr/bin/env python3
"""
@author: zhangdd on 2022/2/4

插值查找
"""


def insert_search(arr, value):
    return do_insert_search(arr, 0, len(arr) - 1, value)


def do_insert_search(arr, left, right, value):
    if left > right or arr[left] > value or arr[right] < value:
        return None
    middle = left + (right - left) * (value - arr[left]) // (arr[right] - arr[left])
    if arr[middle] == value:
        return middle
    elif value < arr[middle]:
        return do_insert_search(arr, left, middle - 1, value)
    elif value > arr[middle]:
        return do_insert_search(arr, middle + 1, right, value)
    else:
        return None


if __name__ == '__main__':
    arr = [1, 2, 3, 5, 8, 8, 10, 18]
    index = insert_search(arr, 20)
    print(index)
