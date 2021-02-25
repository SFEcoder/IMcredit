package com.example.common.calculation.Target.DivTarget;

import com.example.common.calculation.Target.Target;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Owen
 * @Date: 2020/12/6 21:51
 * @Description:
 */
public class MixIndustry extends EnterTarget{

    private List<Target> targets;
    private List<Double> concrete;

    public MixIndustry(){
        this.init();
    }

    private void init(){

        RowsCols = new Integer[][]{{1,1,1,1,1,1},{2,2,1,1},{2},{2,2,1,1,1}};
        rowcols = new Integer[]{6,6,2,7};
        targets = new ArrayList<Target>();

        targets.add(new Target(0,5));
        targets.add(new Target(0,100));
        targets.add(new Target(0,10));
        targets.add(new Target(0,100));
        targets.add(new Target(0,5));
        targets.add(new Target(-1,1));
        targets.add(new Target(0,100));
        targets.add(new Target(0,5));
        targets.add(new Target(0,0));
        targets.add(new Target(0,10));
        targets.add(new Target(0,10));
        targets.add(new Target(0,99));
        targets.add(new Target(0,0));
        targets.add(new Target(0,0));
        targets.add(new Target(0,10));
        targets.add(new Target(0,5));
        targets.add(new Target(0,10));
        targets.add(new Target(0,5));
        targets.add(new Target(0,5));
        targets.add(new Target(0,5));
        targets.add(new Target(0,5));

        total = 21;
    }
}
