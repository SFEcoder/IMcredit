package com.example.common.calculation.enumType;

/**
 * @Author: Owen
 * @Date: 2020/10/20 22:35
 * @Description:
 */
public enum divType {
    /**
     * A： 按期交货率
     * B： 应用信息系统进行项目管理实现的功能与层级
     * C： 信息化条件下安全生产应急响应及重大危险源预测预警情况
     * D： 通过信息化全面落实企业战略规划，实现全面预算管理的情况
     * E： 经营管理系统向车间生产制造执行系统（或调度系统）自动下达指令包含内容
     * F： 应用信息化手段进行环保管理实现的功能
     * G： 应用信息化手段进行能源管理实现的功能
     * H： 社会贡献率
     * I： 通过信息化实现与产业链企业间业务协同情况
     * J： 通过建立互联网开放社区实现价值网络协同情况
     * K： 贯穿产品全生命周期各阶段的产品状态信息跟踪与反馈情况
     * L： 信息系统运维投入占信息化总投入的比例
     * M： 企业组织模式
     * N： 信息化规划执行情况
     * O： 综合运用信息化手段可实现的决策支持内容
     * P： 应用信息化手段进行设备管理实现的功能与层级
     * Q： 应用信息化手段进行人力资源管理实现的功能与层级
     * */

    A(0,100), B(0,5), C(0,5),D(-5,0),E(-5,5),F(0,3),G(0,7),H(0,100),I(0,10),J(0,5),K(0,5),L(0,100),M(0,9),N(0,9),O(0,7),P(0,4),Q(0,4);


    /**
     * @param below: a
     * @param above: b
     * @param contorl: 0:正向 ；1:负向 ； -1:满意值
     * */
    private final Double below;
    private final Double above;
    private final int control;
    private final Integer[] twoToOne = {5,6,1,5};

    private divType(double below, double above)
    {
        this.below = below;
        this.above = above;
        this.control = below < above ? 0 : 1;
    }

    private divType(double below, double above, int control)
    {
        this.below = below;
        this.above = above;
        this.control = control;
    }

    public double getBelow() {
        return below;
    }

    public double getAbove() {
        return above;
    }

    public int getControl(){
        return control;
    }

    public Integer[] getTwoToOne(){ return twoToOne; }

}
