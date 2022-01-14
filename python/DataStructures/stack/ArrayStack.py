#!/usr/bin/env python3
"""
@author: zhangdd on 2022/1/14
使用数组实现栈
"""


class ArrayStack:
    def __init__(self, max_size):
        self.top = -1
        self.stack = [None] * max_size
        self.max_size = max_size

    def pop(self):
        if self.top <= -1:
            print('当前栈为空')
            return
        value = self.stack[self.top]
        self.top -= 1
        return value

    def push(self, data):
        if self.top + 1 >= self.max_size:
            print('当前栈已满')
            return
        self.top += 1
        self.stack[self.top] = data

    def show(self):
        for i in range(self.top + 1):
            print(self.stack[i])


array_stack = ArrayStack(5)

print(len(array_stack.stack))
print('-' * 50)
array_stack.push(1)
array_stack.push(2)
array_stack.push(3)
array_stack.push(4)
array_stack.push(5)
array_stack.show()

array_stack.push(6)

print(array_stack.pop())
print(array_stack.pop())
array_stack.push(7)
print(array_stack.pop())
print(array_stack.pop())
print(array_stack.pop())
print(array_stack.pop())
print(array_stack.pop())
print(array_stack.pop())
