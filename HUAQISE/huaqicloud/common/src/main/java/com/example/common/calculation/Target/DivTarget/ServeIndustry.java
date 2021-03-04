package com.example.common.calculation.Target.DivTarget;

import com.example.common.calculation.Target.Target;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Owen
 * @Date: 2020/12/6 21:48
 * @Description:
 */
public class ServeIndustry extends EnterTarget{

    private List<Target> targets;
    private List<Double> concrete;

    public ServeIndustry(){
        this.init();
    }

    private void init(){

        RowsCols = new Integer[][]{{1,1,1,1,2,1},{1,2,1,1},{2,1,1,1,1}};
        rowcols = new Integer[]{7,5,6};
        targets = new ArrayList<Target>();
        targets.add(new Target(0,5));
        targets.add(new Target(0,1));
        targets.add(new Target(0,5));
        targets.add(new Target(0,10));
        targets.add(new Target(0,100));
        targets.add(new Target(0,10));
        targets.add(new Target(0,100));
        targets.add(new Target(0,5));
        targets.add(new Target(0,5));
        targets.add(new Target(0,5));
        targets.add(new Target(0,99));
        targets.add(new Target(0,10));
        targets.add(new Target(0,10));
        targets.add(new Target(0,5));
        targets.add(new Target(-10,0));
        targets.add(new Target(0,5));
        targets.add(new Target(0,5));
        targets.add(new Target(0,1));

        total = 18;

    }

    public List<Target> getTargets(){
        return this.targets;
    }
}
