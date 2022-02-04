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

    print('前序查找')
    result = tree.pre_search(2)
    if result is not None:
        result.show()
    else:
        print('没有找到')

    print('-' * 50)

    print('中序查找')
    result = tree.infix_search(2)
    if result is not None:
        result.show()
    else:
        print('没有找到')

    print('-' * 50)

    print('后序查找')
    result = tree.post_search(1)
    if result is not None:
        result.show()
    else:
        print('没有找到')
