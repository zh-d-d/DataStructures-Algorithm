#!/usr/bin/env python3
"""
@author: zhangdd on 2022/1/18
波兰表达式
"""
import enum


class OpeEnum(enum.Enum):
    def __init__(self, ope, priority):
        self.ope = ope
        self.priority = priority

    ADD = ('+', 1)
    SUB = ('-', 1)
    MULTI = ('*', 2)
    DIV = ('/', 2)

    @staticmethod
    def obtain_ope(ope):
        for item in OpeEnum:
            if item.ope == ope:
                return item
        raise Exception('不支持的操作符')

    @staticmethod
    def is_ope(ope):
        for item in OpeEnum:
            if item.ope == ope:
                return True
        return False


class PolandNotation:
    def __init__(self):
        pass

    def infix2suffix(self, infix_express):

        stack1 = []
        stack2 = []
        index = -1
        while True:
            index += 1
            if index >= len(infix_express):
                break

            if infix_express[index].isdigit():
                stack2.append(infix_express[index])
            elif infix_express[index] == '(':
                stack1.append(infix_express[index])
            elif infix_express[index] == ')':
                flag = True
                while flag and len(stack1) > 0:
                    tmp = stack1.pop()
                    if tmp == '(':
                        flag = False
                    else:
                        stack2.append(tmp)
            else:
                flag = True
                while flag:
                    if len(stack1) <= 0 or stack1[-1] == '(':
                        stack1.append(infix_express[index])
                        flag = False
                    elif OpeEnum.obtain_ope(infix_express[index]).priority > OpeEnum.obtain_ope(stack1[-1]).priority:
                        stack1.append(infix_express[index])
                        flag = False
                    else:
                        tmp = stack1.pop()
                        stack2.append(tmp)

        while True:
            if len(stack1) <= 0:
                break
            tmp = stack1.pop()
            stack2.append(tmp)

        return stack2

    def calculate(self, suffix_expression):
        """
        后缀表达式计算
        :param suffix_expression:
        :return:
        """

        num_stack = []
        index = -1
        while True:
            index += 1
            if index >= len(suffix_expression):
                break

            if OpeEnum.is_ope(suffix_expression[index]):
                num2 = num_stack.pop()
                num1 = num_stack.pop()
                result = self.do_calculator(num1, num2, suffix_expression[index])
                num_stack.append(result)
            else:
                num_stack.append(suffix_expression[index])

        return num_stack.pop()

    def do_calculator(self, num1, num2, ope):
        ope_enum = OpeEnum.obtain_ope(ope)
        if ope_enum is OpeEnum.ADD:
            return int(num1) + int(num2)
        elif ope_enum is OpeEnum.SUB:
            return int(num1) - int(num2)
        elif ope_enum is OpeEnum.MULTI:
            return int(num1) * int(num2)
        else:
            return int(num1) / int(num2)


poland_notation = PolandNotation()

result = poland_notation.infix2suffix('1+((2+3)*4)-5')
print(result)

result = poland_notation.calculate(result)
print(result)
