#!/usr/bin/env python3
"""
@author: zhangdd on 2022/2/2

 * 递归-迷宫问题
 * <p>
 * 一个8X7大小的迷宫，每个方格如果是1 表示是拦截物，
 * 约定方格中如果是2表示可以走，如果是3表示走过，但是通过该方格走不通
 * 按照下->右->上->左的顺序进行尝试走
"""


class MiGong:
    def __init__(self, data):
        """
        初始化迷宫数据
        :param data:
        """
        self.data = data

    def find_rode(self, goal_x, goal_y):
        if goal_x >= len(self.data):
            raise Exception('x不合法，不能大于二维数组的范围')

        if goal_y >= len(self.data[0]):
            raise Exception('y不合法，不能大于二维数组的范围')

        self.do_find_rode(self.data, 1, 1, goal_x, goal_y)

    def do_find_rode(self, data, x, y, goal_x, goal_y):
        if self.data[goal_x][goal_y] == 2:
            return True
        if self.data[x][y] is None:
            self.data[x][y] = 2
            if self.do_find_rode(data, x + 1, y, goal_x, goal_y):
                return True
            elif self.do_find_rode(data, x, y + 1, goal_x, goal_y):
                return True
            elif self.do_find_rode(data, x - 1, y, goal_x, goal_y):
                return True
            elif self.do_find_rode(data, x, y - 1, goal_x, goal_y):
                return True
            else:
                return False
        else:
            return False


if __name__ == '__main__':
    data = [[None for column in range(7)] for row in range(8)]
    for i in range(len(data)):
        data[i][0] = 1
        data[i][len(data[0]) - 1] = 1

    for i in range(len(data[0])):
        data[0][i] = 1
        data[len(data) - 1][i] = 1

    data[3][1] = 1
    data[3][2] = 1

    print('初始化地图')
    # 为了好看，进行了格式化输出
    for i in range(len(data)):
        for j in range(len(data[0])):
            print('%-6s' % data[i][j], end='')
        print()

    example = MiGong(data)
    example.find_rode(1, 5)

    print('循迹之后')
    for i in range(len(data)):
        for j in range(len(data[0])):
            print('%-6s' % data[i][j], end='')
        print()
