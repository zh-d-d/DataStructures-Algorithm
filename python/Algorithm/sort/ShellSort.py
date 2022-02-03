#!/usr/bin/env python3
"""
@author: zhangdd on 2022/2/3
"""


def shell_sort(arr):
    gap = len(arr) // 2
    while gap >= 1:
        for group in range(gap):
            for i in range(group, len(arr), gap):
                ready_index = i
                ready_value = arr[i]
                for j in range(i - gap, -1, -gap):
                    if arr[j] > ready_value:
                        arr[j + gap] = arr[j]
                        ready_index -= gap
                    else:
                        break
                arr[ready_index] = ready_value
        gap = gap // 2


if __name__ == '__main__':
    collection = [8, 9, 1, 7, 2, 3, 5, 4, 6, 0]
    shell_sort(collection)
    print(collection)
