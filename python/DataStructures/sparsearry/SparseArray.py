#!/usr/bin/env python3
"""
@author: zhangdd on 2022/1/4
"""
# 定义一个11*11的二维数组
chess_data = [[None for i in range(11)] for j in range(11)]
# 初始化数据
chess_data[1][2] = 1
chess_data[2][3] = 2
chess_data[4][3] = 1

valid_value_count = 0

for row in chess_data:
    for item in row:
        if item is None:
            pass
        else:
            valid_value_count += 1

# 定义稀疏数组
sparse_array = [[None for i in range(3)] for j in range(valid_value_count + 1)]
# 初始化稀疏数组数据
sparse_array[0][0] = len(chess_data)
sparse_array[0][1] = len(chess_data[0])
sparse_array[0][2] = valid_value_count + 1

sparse_index = 1
for i in range(len(chess_data)):
    for j in range(len(chess_data[i])):
        if chess_data[i - 1][j - 1] is None:
            pass
        else:
            sparse_array[sparse_index][0] = i - 1
            sparse_array[sparse_index][1] = j - 1
            sparse_array[sparse_index][2] = chess_data[i - 1][j - 1]
            sparse_index += 1

print(sparse_array)
