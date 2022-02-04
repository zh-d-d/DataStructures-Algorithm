#!/usr/bin/env python3
"""
@author: zhangdd on 2022/2/4
"""


class Node:
    def __init__(self, no, name):
        self.no = no
        self.name = name
        self.left = None
        self.right = None

    def show(self):
        print('no:{},name:{}'.format(self.no, self.name))

    def pre_order(self):
        self.show()
        if self.left is not None:
            self.left.pre_order()
        if self.right is not None:
            self.right.pre_order()

    def infix_order(self):
        if self.left is not None:
            self.left.infix_order()

        self.show()

        if self.right is not None:
            self.right.infix_order()

    def post_order(self):
        if self.left is not None:
            self.left.post_order()

        if self.right is not None:
            self.right.post_order()

        self.show()

    def remove(self, no):
        if self.left is not None:
            if self.left.no == no:
                self.left = None
            else:
                self.left.remove(no)

        if self.right is not None:
            if self.right.no == no:
                self.right = None
            else:
                self.right.remove(no)

    def set_left(self, node):
        self.left = node

    def set_right(self, node):
        self.right = node


class BinaryTree:
    def __init__(self, node):
        self.root = node

    def pre_order(self):
        if self.root is None:
            print('当前树空')
            return
        self.root.pre_order()

    def infix_order(self):
        if self.root is None:
            print('当前树空')
            return
        self.root.infix_order()

    def post_order(self):
        if self.root is None:
            print('当前树空')
            return
        self.root.post_order()

    def remove(self, no):
        if self.root is None:
            print('当前树空')
            return
        if self.root.no == no:
            self.root = None
            return
        self.root.remove(no)


if __name__ == '__main__':
    root = Node(1, '宋江')
    node2 = Node(2, '吴用')
    node3 = Node(3, '卢俊义')
    node4 = Node(4, '林冲')
    node5 = Node(5, '关胜')

    root.set_left(node2)
    root.set_right(node3)

    node3.set_left(node5)
    node3.set_right(node4)

    tree = BinaryTree(root)

    print('前序')
    tree.pre_order()

    print('中序')
    tree.infix_order()

    print('后序')
    tree.post_order()

    print('-' * 50)
    tree.remove(4)
    print('删除节点4后')
    tree.pre_order()
    print('-' * 50)

    tree.remove(1)
    print('删除节点1后')
    tree.pre_order()
