#!/usr/bin/env python3
"""
@author: zhangdd on 2022/2/4
"""


def merge_sort(arr):
    left_index = 0
    right_index = len(arr) - 1
    do_merge_sort(arr, left_index, right_index)


def do_merge_sort(arr, left_index, right_index):
    if left_index < right_index:
        middle = (left_index + right_index) // 2
        # 对左边做归并排序
        do_merge_sort(arr, left_index, middle)
        # 对右边做归并排序
        do_merge_sort(arr, middle + 1, right_index)

        # 对当前的左右两组进行合并
        merge(arr, left_index, right_index, middle)


def merge(arr, left_index, right_index, middle):
    l = left_index
    r = middle + 1
    temp = []
    while l <= middle and r <= right_index:
        if arr[l] < arr[r]:
            temp.append(arr[l])
            l += 1
        else:
            temp.append(arr[r])
            r += 1

    while l <= middle:
        temp.append(arr[l])
        l += 1

    while r <= right_index:
        temp.append(arr[r])
        r += 1

    temp_left = left_index
    temp_index = 0
    while temp_left <= right_index:
        arr[temp_left] = temp[temp_index]
        temp_index += 1
        temp_left += 1


if __name__ == '__main__':
    collection = [8, 4, 5, 7, 1, 3, 6, 2]
    merge_sort(collection)
    print(collection)
