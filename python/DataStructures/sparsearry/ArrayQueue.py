#!/usr/bin/env python3
"""
@author: zhangdd on 2022/1/5
数组实现队列
"""


class Queue:
    def __init__(self, max_size=10):
        self.max_size = max_size


queue = Queue()
print(queue.max_size)