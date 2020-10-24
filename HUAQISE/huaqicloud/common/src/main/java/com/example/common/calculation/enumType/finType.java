package com.example.common.calculation.enumType;

/**
 * @Author: Owen
 * @Date: 2020/10/20 22:35
 * @Description:
 */
public enum finType {
    /**
     * A： 经营活动现金流量净额与经营活动净收益比
     * B： 资产负债率
     * C： 流动比率
     * D： 速动比率
     * E： 经营活动产生的现金流量净额与流动负债比
     * F： 有形资产负债率
     * G： 财务费用率
     * H： 营业总收入增长率
     * I： 利润总额增长率
     * J： 总负债增长率
     * K： 净资产收益率
     * L： 销售净利率
     * M： 销售毛利率
     * N： 存货周转天数
     * O： 流动资产周转率
     * P： 应收账款周转率
     * Q： 已获利息倍数
     * R:  行业景气指数
     * */

    A(5,-1), B(0.4,0.6, -1), C(3.5,1),D(2.5,0.5),E(0.6,0.2),F(3,0.5),G(0,0.1),H(0.5,0),I(2,0),J(0,1),K(0.3,0),L(0.2,0),M(0.6,0),N(0,360),O(2.5,0),P(10,0),Q(65,0),R(0,0,0);


    /**
     * @param below: a
     * @param above: b
     * @param contorl: 0:正向 ；1:负向 ； -1:满意值
     * */
    private final Double below;
    private final Double above;
    private final int control;
    private final Integer[] twoToOne = {1,5,3,3,5,1};

    private finType(double below, double above)
    {
        this.below = below;
        this.above = above;
        this.control = below > above ? 0 : 1;
    }

    private finType(double below, double above, int control)
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
