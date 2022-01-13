#!/usr/bin/env python3
"""
@author: zhangdd on 2022/1/13
双向链表
"""


class Node:
    def __init__(self, data, name):
        self.data = data
        self.name = name
        self.pre = None
        self.next = None

    def show(self):
        print('data:{},name:{}'.format(self.data, self.name))


class DoubleLinkedList:

    def __init__(self):
        self.head = Node(-1, None)

    def add_node(self, node):
        tmp = self.head
        while tmp.next is not None:
            tmp = tmp.next
        tmp.next = node
        node.pre = tmp

    def del_node(self, data):
        tmp = self.head.next
        while tmp is not None:
            if tmp.data == data:
                tmp.pre.next = tmp.next
                tmp.next.pre = tmp.pre
                break
            tmp = tmp.next

    def show(self):
        tmp = self.head
        while tmp.next is not None:
            tmp.next.show()
            tmp = tmp.next


link_list = DoubleLinkedList()
node1 = Node(1, '鲁迅')
node2 = Node(2, '鲁肃')
node3 = Node(3, '周瑜')
node4 = Node(4, '黄盖')

link_list.add_node(node1)
link_list.add_node(node2)
link_list.add_node(node3)
link_list.add_node(node4)

link_list.show()

print('-' * 50)

link_list.del_node(3)
link_list.del_node(2)

link_list.show()
