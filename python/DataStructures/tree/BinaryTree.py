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

    def pre_search(self, no):
        if self.no == no:
            return self
        result = None
        if self.left is not None:
            result = self.left.pre_search(no)

        if result is not None:
            return result

        if self.right is not None:
            result = self.right.pre_search(no)

        return result

    def infix_search(self, no):
        result = None
        if self.left is not None:
            result = self.left.infix_search(no)

        if result is not None:
            return result

        if self.no == no:
            return self

        if self.right is not None:
            result = self.right.infix_search(no)

        return result

    def post_search(self, no):
        result = None
        if self.left is not None:
            result = self.left.post_search(no)

        if result is not None:
            return result

        if self.right is not None:
            result = self.right.post_search(no)

        if result is not None:
            return result

        if self.no == no:
            return self

        return result


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

    def pre_search(self, no):
        if self.root is None:
            print('当前树空')
            return
        return self.root.pre_search(no)

    def infix_search(self, no):
        if self.root is None:
            print('当前树空')
            return
        return self.root.infix_search(no)

    def post_search(self, no):
        if self.root is None:
            print('当前树空')
            return
        return self.root.post_search(no)


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
