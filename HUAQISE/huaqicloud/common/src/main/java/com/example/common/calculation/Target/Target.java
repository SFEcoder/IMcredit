package com.example.common.calculation.Target;

/**
 * @Author: Owen
 * @Date: 2020/12/6 20:13
 * @Description:
 */
public class Target {
    /*  type: 正向 0 ; 负向: 1 ； 满意值: 2 */
    private Double left;
    private Double right;
    private Integer type;

    public Target(Double left, Double right){
        this.left = left;
        this.right = right;
        this.type = 0;
    }

    public Target(Double left, Double right, Integer type){
        this.left = left;
        this.right = right;
        this.type = type;
    }

    public Target(Integer left, Integer right){
        this.left = left.doubleValue();
        this.right = right.doubleValue();
        this.type = 0;
    }

    public Target(Integer left, Integer right, Integer type){
        this.left = left.doubleValue();
        this.right = right.doubleValue();
        this.type = type;
    }

    public Integer getType(){
        return this.type;
    }

    public Double getLeft(){
        return this.left;
    }

    public Double getRight(){
        return this.right;
    }
}
