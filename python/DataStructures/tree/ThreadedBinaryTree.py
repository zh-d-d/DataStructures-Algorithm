#!/usr/bin/env python3
"""
@author: zhangdd on 2022/2/4

线索化二叉树
"""


class Node:
    def __init__(self, no, name):
        self.no = no
        self.name = name
        self.left = None
        self.right = None
        # 0表示是左子树，1表示是前驱节点
        self.left_type = 0
        # 0表示是右子树，1表示是后继节点
        self.right_type = 0

    def set_left(self, node):
        self.left = node

    def set_right(self, node):
        self.right = node

    def show(self):
        print('no:{},name:{}'.format(self.no, self.name))


class ThreadedBinaryTree:
    def __init__(self, root):
        self.root = root
        self.pre = None

    def infix_threaded(self):
        self.__do_infix_threaded(self.root)

    def __do_infix_threaded(self, node):
        if node is None:
            return
        # 处理左节点
        self.__do_infix_threaded(node.left)

        # 处理当前节点的前驱节点
        if node.left is None:
            node.left = self.pre
            node.left_type = 1

        # 处理上一个节点的 后继节点
        if self.pre is not None and self.pre.right is None:
            self.pre.right = node
            self.pre.right_type = 1

        self.pre = node

        # 处理右节点
        self.__do_infix_threaded(node.right)

    def infix_order_threaded_tree(self):
        self.__do_infix_order_threaded_tree(self.root)

    def __do_infix_order_threaded_tree(self, node):
        if node is None:
            return
        tmp = node
        while tmp is not None:
            while tmp.left_type != 1:
                tmp = tmp.left
            tmp.show()

            while tmp.right_type == 1:
                tmp = tmp.right
                tmp.show()

            tmp = tmp.right


if __name__ == '__main__':
    root = Node(1, 'mick')
    node1 = Node(3, 'jack')
    node2 = Node(6, 'tom')
    node3 = Node(8, 'smith')
    node4 = Node(10, 'marry')
    node5 = Node(14, 'king')

    root.set_left(node1)
    root.set_right(node2)

    node1.set_left(node3)
    node1.set_right(node4)

    node2.set_left(node5)

    tree = ThreadedBinaryTree(root)
    tree.infix_threaded()

    tree.infix_order_threaded_tree()
