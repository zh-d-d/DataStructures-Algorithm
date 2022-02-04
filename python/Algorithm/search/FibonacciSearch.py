#!/usr/bin/env python3
"""
@author: zhangdd on 2022/2/4

斐波那契查找
"""
MAX_LENGTH = 20


def build_fibonacci_arr():
    fibonacci_arr = [1, 1]
    for i in range(2, MAX_LENGTH):
        fibonacci_arr.append(fibonacci_arr[i - 1] + fibonacci_arr[i - 2])
    return fibonacci_arr


def fibonacci_search(arr, value):
    left = 0
    right = len(arr) - 1
    fibonacci_index = 0

    arr_length = len(arr)
    fibonacci_arr = build_fibonacci_arr()

    gap = 0
    for item in fibonacci_arr:
        if arr_length > item:
            fibonacci_index += 1
            continue
        else:
            gap = item - arr_length
            break
    for i in range(gap):
        arr.append(arr[len(arr) - 1])

    while left <= right:
        middle = left + fibonacci_arr[fibonacci_index - 1] - 1
        if value < arr[middle]:
            right = middle - 1
            fibonacci_index -= 1
        elif value > arr[middle]:
            left = middle + 1
            fibonacci_index -= 2
        else:
            return min(middle, right)

    return None


if __name__ == '__main__':
    arr = [1, 2, 3, 5, 8, 8, 10, 18, 19]
    index = fibonacci_search(arr, 20)
    print(index)
