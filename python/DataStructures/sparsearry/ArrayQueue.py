#!/usr/bin/env python3
"""
@author: zhangdd on 2022/1/5
数组实现队列
"""


class Queue:
    def __init__(self, max_size=10):
        self.max_size = max_size
        self.rear = -1
        self.front = -1
        self.queue = [None] * max_size

    def push(self, num):
        if self.rear == self.max_size - 1:
            print('当前队列已满')
            return
        else:
            self.rear += 1
            self.queue[self.rear] = num

    def pop(self):
        if self.front < self.rear:
            self.front += 1;
            print(self.queue[self.front])
        else:
            print('当前队列为空')


queue = Queue(10)
command = 0
while True:
    print('1:push data')
    print('2:pop data')
    print('3:exit program')
    command = int(input('please input command'))
    if command == 1:
        num = input('please input num')
        queue.push(num)
    elif command == 2:
        queue.pop()
    elif command == 3:
        break
    else:
        print('input error')
