package com.example.common.calculation.Target.DivTarget;

import com.example.common.calculation.Target.Target;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Owen
 * @Date: 2020/12/6 21:42
 * @Description:
 */
public class SmeDiscrete extends EnterTarget{

    private List<Target> targets;
    private List<Double> concrete;

    public SmeDiscrete(){
        this.init();
    }

    private void init(){
        RowsCols = new Integer[][]{{1,1,2,2,1},{1,1,2,1},{3},{2,3,1,1,1},{2,1}};
        rowcols = new Integer[]{7,5,3,8,3};
        targets = new ArrayList<Target>();
        targets.add(new Target(0,5));
        targets.add(new Target(-5,0));
        targets.add(new Target(-5,5));
        targets.add(new Target(-15,15));
        targets.add(new Target(0,10));
        targets.add(new Target(0,10));
        targets.add(new Target(0,1));
        targets.add(new Target(0,7));
        targets.add(new Target(0,100));
        targets.add(new Target(0,10));
        targets.add(new Target(0,5));
        targets.add(new Target(0,8));
        targets.add(new Target(0,0));
        targets.add(new Target(0,100));
        targets.add(new Target(0,0));
        targets.add(new Target(0,10));
        targets.add(new Target(0,10));
        targets.add(new Target(0,5));
        targets.add(new Target(0,5));
        targets.add(new Target(-11,11));
        targets.add(new Target(0,4));
        targets.add(new Target(0,4));
        targets.add(new Target(0,3));
        targets.add(new Target(0,0));
        targets.add(new Target(0,0));
        targets.add(new Target(0,10));

        total = 26;
    }

    public List<Target> getTargets(){
        return this.targets;
    }
}
