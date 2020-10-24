package com.example.common.calculation.enumType;

/**
 * @Author: Owen
 * @Date: 2020/10/24 10:25
 * @Description: 离散中小批量
 */
public enum divType3 {

    /**
     * @Description
     * 类似 “ 当年企业生产设备总资产__（万元）  ”没上限的指标，阈值统一设置（0，0）
     * 类似 “ 是否能够通过信息化对外协全过程进行监管（0 or1） ”阈值就选择（0，1）
     * */

    /**
     * A： 应用信息系统进行项目管理实现的功能与层级（0`5）
     * B： 财务系统对销售实时监控的情况（-5~0）
     * C： 经营管理系统向车间生产制造执行系统（或调度系统）自动下达指令包含内容（-5~5）
     * D： 车间生产制造执行系统（或调度系统）向经营管理系统自动上传信息范围（-15~15）
     * E： 应用信息系统进行质量管理的覆盖范围（0~10）
     * F： 应用信息系统进行质量管理实现的功能（0~10）
     * G： 是否能够通过信息化对外协全过程进行监管（0 or1）
     * H： 应用信息化手段进行能源管理实现的功能（0~7）
     * I： 社会贡献率（0/1）
     * J： 通过信息化实现与产业链企业间业务协同情况（0~10）
     * K： 产业链企业之间信息交互和共享（0~3）
     * L： 通过建立互联网开放社区实现价值网络协同情况（0~5）
     * M： 在线实现产品服务延伸或远程管控的情况（0~8）
     * N： 近五年信息化建设投入（万元）
     * O： 信息系统运维投入占信息化总投入的比例（%）
     * P： 当年企业生产设备总资产__（万元）
     * Q： 企业组织模式（0~10）
     * R:  信息化规划执行情况（0~10）
     * S:  应用信息化手段开展物料需求计划管理情况（0~5）
     * T:  应用信息化手段开展研发设计情况（0~5）
     * U:  基于智能知识模型自动采集信息并进行综合分析的业务范围（-11~11）
     * V:  应用信息化手段进行设备管理实现的功能与层级（0~4）
     * W:  应用信息化手段进行人力资源管理实现的功能与层级（0~4）
     * X:  工业软件创新能力（0~3）
     * Y:  新产品研发周期_（天）
     * Z:  百人专利拥有量
     * A1: 产品模型数据定义情况（0~10）
     * */

    A(0,5), B(-5,0), C(-5,5),D(-15,15),E(0,10),F(0,10),G(0,1),H(0,7),I(0,100),J(0,10),K(0,3),L(0,5),M(0,8),N(0,0),O(0,100),P(0,0),Q(0,10),R(0,10),S(0,5),T(0,5),U(-11,11),V(0,4),W(0,4),X(0,3),Y(0,0),Z(0,0),A1(0,10);


    /**
     * @param below: a
     * @param above: b
     * @param contorl: 0:正向 ；1:负向 ； -1:满意值
     * */
    private final Double below;
    private final Double above;
    private final int control;
    private final Integer[] twoToOne = {7,6,3,8,3};

    private divType3(double below, double above)
    {
        this.below = below;
        this.above = above;
        this.control = below < above ? 0 : 1;
    }

    private divType3(double below, double above, int control)
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
