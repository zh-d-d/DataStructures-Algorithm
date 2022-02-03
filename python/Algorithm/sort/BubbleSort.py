#!/usr/bin/env python3
"""
@author: zhangdd on 2022/2/3
"""


def bubble_sort(arr):
    for i in range(len(arr) - 1):
        for j in range(len(arr) - 1 - i):
            if arr[j] > arr[j + 1]:
                tmp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = tmp


if __name__ == '__main__':
    collection = [1, 9, 7, -3, 2]
    bubble_sort(collection)
    print(collection)
