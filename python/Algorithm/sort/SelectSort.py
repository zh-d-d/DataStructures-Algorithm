#!/usr/bin/env python3
"""
@author: zhangdd on 2022/2/3
"""


def select_sort(arr):
    for i in range(len(arr) - 1):
        for j in range(i + 1, len(arr)):
            if arr[i] > arr[j]:
                tmp = arr[i]
                arr[i] = arr[j]
                arr[j] = tmp


if __name__ == '__main__':
    collection = [1, 9, 7, -3, 2]
    select_sort(collection)
    print(collection)
