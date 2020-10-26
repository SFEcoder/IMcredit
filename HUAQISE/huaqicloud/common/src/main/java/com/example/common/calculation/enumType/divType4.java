package com.example.common.calculation.enumType;

/**
 * @Author: Owen
 * @Date: 2020/10/24 10:50
 * @Description: 服务行业
 */
public enum divType4 {
    /**
     * A： 应用信息系统进行项目管理实现的功能与层级（0~5）
     * B： 是否建立了呼叫中心（0~1）
     * C： 通过信息化全面落实企业战略规划，实现全面预算管理的情况（0~5）
     * D： 服务业务管理与服务现场执行的集成情况（0~10）
     * E： 网上采购率（0~100）
     * F： 采购电子商务的应用范围（0~10）
     * G： 全员劳动生产率（0~100）
     * H： 应用信息化手段进行能源管理实现的功能（0~5）
     * I： 通过信息化实现与产业链企业间业务协同情况（0~5）
     * J： 产业链企业之间信息交互和共享情况（0~5）
     * K： 信息系统运维投入占信息化总投入的比例（0~99）
     * L： 实现企业级统一的编码（0~10）
     * M： 企业组织模式（0~10）
     * N： 信息化规划执行情况（0~5）
     * O： 综合运用信息化手段可实现的决策支持内容（-10~0）
     * P： 应用信息化手段进行设备管理实现的功能与层级（0~5）
     * Q： 应用信息化手段进行人力资源管理实现的功能与层级（0~5）
     * R:  云平台使用情况（0~1）
     * */

    A(0,5), B(0,1), C(0,5),D(0,10),E(0,100),F(0,10),G(0,100),H(0,5),I(0,5),J(0,5),K(0,99),L(0,10),M(0,10),N(0,5),O(-10,0),P(0,5),Q(0,5),R(0,1);


    /**
     * @param below: a
     * @param above: b
     * @param contorl: 0:正向 ；1:负向 ； -1:满意值
     * */
    private final Double below;
    private final Double above;
    private final int control;
    private final Integer[] twoToOne = {7,5,6};

    private divType4(double below, double above)
    {
        this.below = below;
        this.above = above;
        this.control = below < above ? 0 : 1;
    }

    private divType4(double below, double above, int control)
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
