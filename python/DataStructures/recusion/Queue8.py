#!/usr/bin/env python3
"""
@author: zhangdd on 2022/2/3
八皇后问题
"""

MAX = 8


class Queue8:

    def __init__(self):
        self.position = [-1] * MAX
        self.count = 0

    '''
    先定一个长度大小为8的一维数组position，初始化值为-1，表示都还没放
    
    先放第一个皇后，第一个皇后肯定在第一行，也就是处理position[0]=? 
    尝试从第一行的第一列开始 即假设设置position[0]=0 ，看是否冲突，和在此之前放过的比较，由于是第一个放的，所以没有冲突
    
    开始放第二个皇后，第二个皇后肯定在第二行，也就是要处理position[1]=? 的问题
    尝试从第二行的第一列开始 即假设设置position[0]=0 ，看是否冲突，和在此之前放过的比较 ，发现有冲突，
    尝试从第二行的第二列开始 即假设设置position[0]=1 ，看是否冲突，和在此之前放过的比较 ，
    ......
    
    重要的当前这个位置如果是可以的话，进行递归操作 也就是保存了当前的栈情况
    '''

    def is_conflict(self, n):
        for i in range(n):
            if self.position[i] == self.position[n] or abs(n - i) == abs(self.position[n] - self.position[i]):
                return True
        return False

    def play(self):
        self.do_play(0)
        print('一共有{0}种解法'.format(self.count))

    def do_play(self, n):
        if n == MAX:
            self.count += 1
            self.show_solution()
            return
        for i in range(MAX):
            self.position[n] = i
            if not self.is_conflict(n):
                self.do_play(n + 1)

    def show_solution(self):
        print(self.position)


queue8 = Queue8()
queue8.play()
