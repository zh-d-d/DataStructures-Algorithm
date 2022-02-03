#!/usr/bin/env python3
"""
@author: zhangdd on 2022/2/3
"""


def quick_sort(arr):
    do_quick_sort(arr, 0, len(arr) - 1)


def do_quick_sort(arr, start_left, start_right):
    l = start_left
    r = start_right
    if l < r:

        pivot_index = (l + r) // 2
        pivot = arr[pivot_index]

        while l < r:
            while pivot >= arr[l] and l < pivot_index:
                l += 1

            if l < pivot_index:
                arr[pivot_index] = arr[l]
                pivot_index = l

            while pivot <= arr[r] and r > pivot_index:
                r -= 1

            if r > pivot_index:
                arr[pivot_index] = arr[r]
                pivot_index = r

        arr[pivot_index] = pivot

        do_quick_sort(arr, start_left, pivot_index - 1)
        do_quick_sort(arr, pivot_index + 1, start_right)


if __name__ == '__main__':
    collection = [8, 9, 1, 7, 2, 3, 5, 4, 6, 0]
    quick_sort(collection)
    print(collection)
