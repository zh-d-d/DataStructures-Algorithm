#!/usr/bin/env python3
"""
@author: zhangdd on 2022/2/3
"""


def insert_sort(arr):
    for i in range(1, len(arr)):
        ready_index = i
        ready_value = arr[i]
        for j in range(i - 1, -1, -1):
            if arr[j] > ready_value:
                arr[j + 1] = arr[j]
                ready_index -= 1
            else:
                break
        arr[ready_index] = ready_value


if __name__ == '__main__':
    collection = [1, 9, 7, -3, 2]
    insert_sort(collection)
    print(collection)
