#!/usr/bin/env python3
"""
@author: zhangdd on 2022/2/3
"""


def bubble_sort_enhance(arr):
    for i in range(len(arr) - 1):
        flag = False
        for j in range(len(arr) - 1 - i):
            if arr[j] > arr[j + 1]:
                tmp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = tmp
                flag = True
        if not flag:
            break


if __name__ == '__main__':
    collection = [1, 9, 7, -3, 2]
    bubble_sort_enhance(collection)
    print(collection)
