#!/usr/bin/env python3
"""
@author: zhangdd on 2022/2/4
"""
from python.DataStructures.tree.BinaryTree import Node, BinaryTree

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


    tree.remove(4)
    print('删除节点4后')
    tree.pre_order()
    print('-' * 50)

    tree.remove(1)
    print('删除节点1后')
    tree.pre_order()
