#!/usr/bin/env python3
"""
@author: zhangdd on 2022/2/4

顺序存储二叉树
"""


class ArrayBinaryTree:
    def __init__(self, list):
        self.list = list

    def pre_order(self):
        if self.list is None or len(self.list) == 0:
            print('当前树空')
            return
        self.__do_pre_order(0)

    def __do_pre_order(self, index):
        if index >= len(self.list):
            return
        print(str(self.list[index]) + ' ', end='')

        self.__do_pre_order(2 * index + 1)

        self.__do_pre_order(2 * index + 2)

    def infix_order(self):
        if self.list is None or len(self.list) == 0:
            print('当前树空')
            return
        self.__do_infix_order(0)

    def __do_infix_order(self, index):
        if index >= len(self.list):
            return
        self.__do_infix_order(2 * index + 1)
        print(str(self.list[index]) + ' ', end='')
        self.__do_infix_order(2 * index + 2)

    def post_order(self):
        if self.list is None or len(self.list) == 0:
            print('当前树空')
            return
        self.__do_post_order(0)

    def __do_post_order(self, index):
        if index >= len(self.list):
            return

        self.__do_post_order(2 * index + 1)
        self.__do_post_order(2 * index + 2)
        print(str(self.list[index]) + ' ', end='')


if __name__ == '__main__':
    arr = [1, 2, 3, 4, 5, 6, 7]
    tree = ArrayBinaryTree(arr)

    print('前序', end='')
    print('-' * 50)
    tree.pre_order()
    print()

    print('中序', end='')
    print('-' * 50)
    tree.infix_order()
    print()

    print('后序', end='')
    print('-' * 50)
    tree.post_order()
    print()
