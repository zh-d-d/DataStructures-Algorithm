#!/usr/bin/env python3
"""
@author: zhangdd on 2022/1/7

环形队列，注意当前实现的队列可以存放的有效值个数为队列的长度-1
"""


class CircleArrayQueue:
    def __init__(self, max_size):
        self.max_size = max_size
        self.front = 0
        self.rear = 0
        self.queue = [None] * max_size

    def add_num(self, num):
        if self.is_ful():
            print("当前队列已满")
            return
        self.queue[self.rear] = num
        self.rear = (self.rear + 1) % self.max_size

    def get_num(self):
        if self.is_empty():
            print('当前队列为空')
            return
        print(self.queue[self.front])
        self.queue[self.front] = None
        self.front = (self.front + 1) % self.max_size

    def show(self):
        print(self.queue)

    def is_ful(self):
        return (self.rear + 1) % self.max_size == self.front

    def is_empty(self):
        return self.front == self.rear


queue = CircleArrayQueue(3)
queue.add_num(1)

queue.add_num(2)

queue.add_num(3)
queue.show()
command = ''
while True:
    print('a:add num')
    print('g:get num')
    print('s:show list')
    print('e:exit program')
    command = input('input command')
    if command == 'a':
        num = input('please input num')
        queue.add_num(num)
    elif command == 'g':
        queue.get_num()
    elif command == 's':
        queue.show()
    elif command == 'e':
        break
