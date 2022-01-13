#!/usr/bin/env python3
"""
@author: zhangdd on 2022/1/7
单向链表
"""


class Node:
    def __init__(self, data, name):
        self.data = data
        self.name = name
        self.next = None

    def show(self):
        print('data:{},name:{}'.format(self.data, self.name))


class LinkList:
    def __init__(self):
        self.head = Node(-1, None)

    def add_node(self, node):
        if self.head is None:
            self.head.next = node
        else:
            tmp = self.head
            while tmp.next is not None:
                tmp = tmp.next
            tmp.next = node

    def del_node(self, data):
        tmp = self.head
        while tmp.next is not None:
            if tmp.next.data == data:
                if tmp.next.next is not None:
                    tmp.next = tmp.next.next
                else:
                    tmp.next = None
                break
            else:
                tmp = tmp.next

    def get_node(self, data):
        tmp = self.head
        while tmp.next is not None:
            if tmp.next.data == data:
                tmp.next.show()
                break
            else:
                tmp = tmp.next

    def edit_node(self, data, name):
        tmp = self.head
        while tmp.next is not None:
            if tmp.next.data == data:
                tmp.next.name = name
                break
            else:
                tmp = tmp.next

    def show(self):
        tmp = self.head
        while tmp.next is not None:
            tmp.next.show()
            tmp = tmp.next

    def count(self):
        tmp = self.head
        count = 0
        while tmp.next is not None:
            tmp = tmp.next
            count += 1
        return count

    def last_index_node(self, index):
        length = self.count()
        if index <= 0 or index > length:
            raise Exception('索引不合法')
        tmp = self.head
        for i in range(length - index + 1):
            tmp = tmp.next
        return tmp

    def revert(self):
        if self.head.next is None:
            return
        new_head = Node(-1, None)
        cur_ele = self.head.next
        while cur_ele is not None:
            next_ele = cur_ele.next
            cur_ele.next = new_head.next
            new_head.next = cur_ele

            cur_ele = next_ele
        self.head.next = new_head.next


link_list = LinkList()
link_list.show()
node1 = Node(1, '曹操')
node2 = Node(2, '刘备')
node3 = Node(3, '吕布')

link_list.add_node(node1)
link_list.add_node(node3)
link_list.add_node(node2)
link_list.show()
print('-' * 50)

link_list.edit_node(1, '曹孟德')
link_list.show()
print('-' * 50)

link_list.del_node(2)
link_list.show()
print('-' * 50)

link_list.get_node(3)

print('-' * 50)

print(link_list.count())

print('-' * 50)

link_list.last_index_node(2).show()

print('-' * 50)

link_list.revert()
link_list.show()
