package com.example.common.calculation.enumType;

/**
 * @Author: Owen
 * @Date: 2020/10/24 9:54
 * @Description: 流程行业
 */
public enum divType2 {

    /**
     * A： 应用信息系统进行项目管理实现的功能与层级（0~5）
     * B： 通过信息化全面落实企业战略规划，实现全面预算管理的情况（-5~0）
     * C： 车间生产制造执行系统（或调度系统）向经营管理系统自动上传信息范围（-15~15）
     * D： 经营管理系统向车间生产制造执行系统（或调度系统）自动下达指令包含内容（-5~5）
     * E： 生产制造过程控制系统向车间生产制造执行系统（或调度系统）自动上传信息覆盖范围（-5~5）
     * F： 车间生产制造执行系统（或调度系统）向生产制造过程控制系统自动下达指令情况（-5~5）
     * G： 应用信息系统进行内部供应链集成管理所覆盖的环节（-6~6）
     * H： 网上采购率（%）
     * I： 实现信息化排产的最小排产单元（或生产线）数占最小排产单元（或生产线）总数的比例（%）
     * J： 应用信息化手段进行能源管理实现的功能（0~7）
     * K： 社会贡献率（0/1）
     * L： 通过信息化实现业务协同和一体化情况（0~9）
     * M： 产业链企业之间信息交互和共享情况（0~3）
     * N： 通过建立互联网开放社区实现价值网络协同情况（0 ~5）
     * O： 应用信息化手段实现产品全生命周期绿色发展的情况（0~5）
     * P： 信息系统运维投入占信息化总投入的比例（%）
     * Q： 企业组织模式（0~10）
     * R:  信息化规划执行情况（0~10）
     * S:  应用信息化手段开展物料需求计划管理情况（0~5）
     * T:  应用信息化手段开展研发设计情况（0~5）
     * U:  基于智能知识模型自动采集信息并进行综合分析的业务范围（-11~11）
     * V:  应用信息化手段进行设备管理实现的功能与层级（0~4）
     * W:  应用信息化手段进行人力资源管理实现的功能与层级（0~4）
     * X:  工业软件创新能力（0~3）
     * Y:  新产品产值率（%）
     * */

    A(0,5), B(-5,0), C(-15,15),D(-5,5),E(-5,5),F(-5,5),G(-6,6),H(0,100),I(0,100),J(0,7),K(0,100),L(0,9),M(0,3),N(0,5),O(0,5),P(0,100),Q(0,10),R(0,10),S(0,5),T(0,5),U(-11,11),V(0,4),W(0,4),X(0,3),Y(0,100);


    /**
     * @param below: a
     * @param above: b
     * @param contorl: 0:正向 ；1:负向 ； -1:满意值
     * */
    private final Double below;
    private final Double above;
    private final int control;
    private final Integer[] twoToOne = {9,6,1,8,1};

    private divType2(double below, double above)
    {
        this.below = below;
        this.above = above;
        this.control = below < above ? 0 : 1;
    }

    private divType2(double below, double above, int control)
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
