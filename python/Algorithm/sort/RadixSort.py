#!/usr/bin/env python3
"""
@author: zhangdd on 2022/2/4

基数排序
"""


def radix_sort(arr):
    bucket = [[] for _ in range(10)]
    max_length = 0
    for i in arr:
        if len(str(i)) > max_length:
            max_length = len(str(i))

    for i in range(max_length):
        base_div = pow(10, i)
        for j in arr:
            cur_point_value = j // base_div % 10
            bucket[cur_point_value].append(j)
        arr.clear()
        for j in bucket:
            for k in j:
                if k is not None:
                    arr.append(k)
                else:
                    break
            j.clear()


if __name__ == '__main__':
    collection = [8, 46, 5, 711, 1, 2]
    radix_sort(collection)
    print(collection)
