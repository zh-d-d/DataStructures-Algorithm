#!/usr/bin/env python3
"""
@author: zhangdd on 2022/1/14
栈 + 中缀表达式 实现综合计算器
"""

from enum import Enum


class ArrayStack:
    def __init__(self, max_size):
        self.top = -1
        self.max_size = max_size
        self.stack = [None] * max_size

    def push(self, data):
        if self.full():
            print('当前栈已满')
            return

        self.top += 1
        self.stack[self.top] = data

    def pop(self):
        if self.empty():
            print('当前栈为空')
            raise Exception('当前栈为空')
        value = self.stack[self.top]
        self.top -= 1
        return value

    def peek(self):
        if self.empty():
            print('当前栈为空')
        value = self.stack[self.top]
        return value

    def show(self):
        print(self.stack)

    def full(self):
        return self.top + 1 >= self.max_size

    def empty(self):
        return self.top <= -1


class OpeEnum(Enum):
    def __init__(self, ope, priority):
        self.ope = ope
        self.priority = priority

    ADD = ('+', 1)
    SUB = ('-', 1)
    MULTI = ('*', 2)
    DIV = ('/', 2)

    @staticmethod
    def get_priority(c):
        for ope in OpeEnum:
            if ope.ope == c:
                return ope.priority
        raise Exception('错误的操作符')

    @staticmethod
    def is_ope(c):
        for ope in OpeEnum:
            if ope.ope == c:
                return True
        return False

    @staticmethod
    def obtain_ope(c):
        for ope in OpeEnum:
            if ope.ope == c:
                return ope
        raise Exception('错误的操作符')


class Calculator:
    def __init__(self):
        pass

    @staticmethod
    def do_calculator(num1, num2, ope):
        ope_enum = OpeEnum.obtain_ope(ope)
        if ope_enum is OpeEnum.ADD:
            return int(num1) + int(num2)
        elif ope_enum is OpeEnum.SUB:
            return int(num1) - int(num2)
        elif ope_enum is OpeEnum.MULTI:
            return int(num1) * int(num2)
        else:
            return int(num1) / int(num2)

    def calculator(self, expression):
        num_stack = ArrayStack(100)
        char_stack = ArrayStack(100)
        index = -1
        num_join = ''
        while True:
            index += 1

            if index >= len(expression):
                # num_stack.show()
                # char_stack.show()
                break

            if OpeEnum.is_ope(expression[index]):
                # 当前操作符栈为空 或者 当前操作符权重大于栈顶权重，直接入栈
                if char_stack.empty() or OpeEnum.get_priority(expression[index]) >= OpeEnum.get_priority(
                        char_stack.peek()):
                    char_stack.push(expression[index])
                else:
                    num1 = num_stack.pop()
                    num2 = num_stack.pop()
                    char = char_stack.pop()
                    tmp_result = self.do_calculator(num2, num1, char)

                    num_stack.push(tmp_result)
                    char_stack.push(expression[index])
            else:
                num_join = num_join + expression[index]
                if index + 1 < len(expression) and not OpeEnum.is_ope(expression[index + 1]):
                    continue
                else:
                    num_stack.push(num_join)
                    num_join = ''

        while True:
            if char_stack.empty():
                break
            num1 = num_stack.pop()
            num2 = num_stack.pop()
            char = char_stack.pop()
            tmp_result = self.do_calculator(num2, num1, char)

            num_stack.push(tmp_result)

        return num_stack.peek()


clc = Calculator()
num = clc.calculator("3+2*6-100")
print(num)
