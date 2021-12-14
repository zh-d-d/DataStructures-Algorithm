package com.zhangdd.hanoitower;

/**
 * @author zhangdd on 2021/12/13
 *
 * https://mp.weixin.qq.com/s/F7ZBME8PafMCOwgOYP0IIg
 */
public class HanoiTower {

    private final int plateNum;
    private final String[] PILLARS = {"A", "B", "C"};

    public HanoiTower(int plateNum) {
        this.plateNum = plateNum;
    }

    public void start() {
        doStart(plateNum, PILLARS[0], PILLARS[1], PILLARS[2]);
    }

    /**
     * 将plate个盘子从起始位置移动到目标位置
     *
     * @param plate 盘子数量
     * @param start 起始柱子名称
     * @param end   目标柱子名称
     */
    private void doStart(int plate, String start, String helper, String end) {
        if (plate == 1) {
            //如果只有一个，直接将这个盘子从起始移动到终点就可以了
            System.out.println(plate + "号盘子从" + start + "移动到" + end);
        } else {
            //先把n-1个上面的盘子移动到到辅助柱子B，这样start的地方还剩一个盘子
            doStart(plate - 1, start, end, helper);

            //最下面还剩一个盘子，移动最后一个盘子到C
            System.out.println(plate + "号盘子从" + start + "移动到" + end);

            //将辅助柱子上的东西搞到目标柱子上去
            doStart(plate - 1, helper, start, end);
        }

    }
}
