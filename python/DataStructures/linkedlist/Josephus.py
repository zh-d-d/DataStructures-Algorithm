#!/usr/bin/env python3
"""
@author: zhangdd on 2022/1/13
"""


class Node:
    def __init__(self, data, name):
        self.data = data
        self.name = name

    def show(self):
        print('data:{},name:{}'.format(self.data, self.name))


class Josephus:
    def __init__(self):
        self.start = None

    def add_node(self, node):
        if self.start is None:
            self.start = node
            node.next = self.start
        else:
            tmp = self.start
            while tmp.next != self.start:
                tmp = tmp.next
            tmp.next = node
            node.next = self.start

    def show(self):
        tmp = self.start
        if tmp is None:
            return
        while True:
            tmp.show()
            if tmp.next == self.start:
                break
            tmp = tmp.next

    def count(self):
        tmp = self.start
        count = 0
        if tmp is None:
            return count
        while True:
            count += 1
            if tmp.next == self.start:
                return count
            tmp = tmp.next

    def play(self, start_no, count_no):
        if self.start is None:
            raise Exception('约瑟夫环还未初始化')

        count = self.count()
        if count <= 1:
            raise Exception('约瑟夫环大小不能小于1')
        if start_no <= 0 or count_no <= 0:
            raise Exception('游戏参数错误')

        # 获取一个帮助指针，指向起始位置的前一个位置，
        # 方便删除使用（因为是单向的，所以只能通过前一个节点删除当前节点）
        help_node = None
        tmp = self.start
        while True:
            if tmp.next == self.start:
                help_node = tmp
                break
            tmp = tmp.next

        # 将start 根据start_no 移动到对应位置，记得help节点也要紧跟着start
        index = 1
        while index < start_no:
            self.start = self.start.next
            help_node = help_node.next
            index += 1

        # 开始游戏
        while True:
            if help_node == self.start:
                self.start.show()
                self.start = None
                break
            index = 1
            while index < count_no:
                self.start = self.start.next
                help_node = help_node.next
                index += 1
            # 找到了要删除的位置了
            self.start.show()
            help_node.next = self.start.next
            self.start = help_node.next


josephus = Josephus()
node1 = Node(1, '鲁迅')
node2 = Node(2, '鲁肃')
node3 = Node(3, '周瑜')
node4 = Node(4, '黄盖')

josephus.add_node(node1)
josephus.add_node(node2)
josephus.add_node(node3)
josephus.add_node(node4)

josephus.show()
print(josephus.count())
print('-' * 50)
josephus.play(2, 2)
