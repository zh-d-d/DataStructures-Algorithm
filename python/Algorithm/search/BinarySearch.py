#!/usr/bin/env python3
"""
@author: zhangdd on 2022/2/4
"""


def binary_search(arr, value):
    return do_binary_search(arr, 0, len(arr) - 1, value)


def do_binary_search(arr, left, right, value):
    if left > right:
        return None

    middle = (left + right) // 2
    if arr[middle] == value:
        return middle
    elif value < arr[middle]:
        return do_binary_search(arr, left, middle - 1, value)
    elif value > arr[middle]:
        return do_binary_search(arr, middle + 1, right, value)
    else:
        return None


if __name__ == '__main__':
    arr = [1, 2, 3, 5, 8, 8, 10, 18]
    index = binary_search(arr, 8)
    print(index)
