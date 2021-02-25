package com.example.common.calculation.Target.DivTarget;

import com.example.common.calculation.Target.Target;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Owen
 * @Date: 2020/12/6 20:50
 * @Description:
 */
public class ProcIndustry extends EnterTarget{

    private List<Target> targets;
    private List<Double> concrete;

    public ProcIndustry(){
        this.init();
    }

    private void init(){

        RowsCols = new Integer[][]{{1,1,4,1,1,1},{1,1,3,1},{1},{2,3,1,1,1},{1}};
        rowcols = new Integer[]{9,6,1,8,1};
        targets = new ArrayList<Target>();

        targets.add(new Target(0,5));
        targets.add(new Target(-5,0));
        targets.add(new Target(-15,15));
        targets.add(new Target(-5,5));
        targets.add(new Target(-5,5));
        targets.add(new Target(-5,5));
        targets.add(new Target(-6,6));
        targets.add(new Target(0,100));
        targets.add(new Target(0,100));
        targets.add(new Target(0,7));
        targets.add(new Target(0,100));
        targets.add(new Target(0,9));
        targets.add(new Target(0,3));
        targets.add(new Target(0,5));
        targets.add(new Target(0,5));
        targets.add(new Target(0,100));
        targets.add(new Target(0,10));
        targets.add(new Target(0,10));
        targets.add(new Target(0,5));
        targets.add(new Target(0,5));
        targets.add(new Target(-11,11));
        targets.add(new Target(0,4));
        targets.add(new Target(0,4));
        targets.add(new Target(0,3));
        targets.add(new Target(0,100));

        total = 25;
    }
}
