package com.example.common.calculation.enumType;

/**
 * @Author: Owen
 * @Date: 2020/10/20 22:35
 * @Description:
 */
public enum EnumType {
    A(5,-1), B(0.4,0.6, -1), C(3.5,1),D(2.5,0.5),E(0.6,0.2),F(3,0.5),G(0,0.1),H(0.5,0),I(2,0),J(0,1),K(0.3,0),L(0.2,0),M(0.6,0),N(0,360),O(2.5,0),P(10,0),Q(65,0);


    /**
     * @param below: a
     * @param above: b
     * @param contorl: 0:正向 ；1:负向 ； -1:满意值
     * */
    private final Double below;
    private final Double above;
    private final int control;

    private EnumType(double below, double above)
    {
        this.below = below;
        this.above = above;
        this.control = below > above ? 0 : 1;
    }

    private EnumType(double below, double above, int control)
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

}
