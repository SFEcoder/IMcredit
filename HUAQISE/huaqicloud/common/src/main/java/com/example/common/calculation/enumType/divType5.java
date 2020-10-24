package com.example.common.calculation.enumType;

/**
 * @Author: Owen
 * @Date: 2020/10/24 10:58
 * @Description: 混合行业
 */
public enum divType5 {

    /**
     * @Description 类似 “  产业链企业之间信息交互和共享 ”无单位指标当作无阈值情况处理
     * */

    /**
     * A： 应用信息系统进行项目管理实现的功能与层级（0~5）
     * B： 上传到信息系统的检化验数据占全部检化验数据的比例（0~100）
     * C： 应用信息化手段实现用户订单全过程跟踪情况（0~10）
     * D： 网上采购率（0~100）
     * E： 应用信息化手段实现的安全生产重点部位、设备集中监控覆盖程度（0~5）
     * F： 经营管理系统向车间生产制造执行系统（或调度系统）自动下达指令包含内容（-1~1）
     * G： 能源数据自动采集上传比例（0~100）
     * H： 应用信息化手段进行环保管理实现的功能（0~5）
     * I： 产业链企业之间信息交互和共享
     * J： 通过建立互联网开放社区实现价值网络协同情况（0~10）
     * K： 应用信息化手段实现产品全生命周期绿色发展的情况（0~10）
     * L： 社会贡献率（0~99）
     * M： 近五年信息化建设投入
     * N： 当年企业生产设备总资产
     * O： 企业组织模式（0~10）
     * P： 信息化规划执行情况（0~5）
     * Q： 应用信息化手段开展物料需求计划管理情况（0~10）
     * R:  基于智能知识模型自动采集信息并进行综合分析的业务范围（0~5）
     * S:  应用信息化手段进行设备管理实现的功能与层级（0~5）
     * T:  应用信息化手段进行人力资源管理实现的功能与层级（0~5）
     * U:  工业软件创新能力（0~5）
     * */

    A(0,5), B(0,100), C(0,10),D(0,100),E(0,5),F(-1,1),G(0,100),H(0,5),I(0,0),J(0,10),K(0,10),L(0,99),M(0,0),N(0,0),O(0,10),P(0,5),Q(0,10),R(0,5),S(0,5),T(0,5),U(0,5);


    /**
     * @param below: a
     * @param above: b
     * @param contorl: 0:正向 ；1:负向 ； -1:满意值
     * */
    private final Double below;
    private final Double above;
    private final int control;
    private final Integer[] twoToOne = {6,6,2,7};

    private divType5(double below, double above)
    {
        this.below = below;
        this.above = above;
        this.control = below < above ? 0 : 1;
    }

    private divType5(double below, double above, int control)
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
