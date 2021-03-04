package com.example.common.calculation.Target.FinTarget;

import com.example.common.calculation.Target.Target;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Owen
 * @Date: 2020/12/7 0:09
 * @Description:
 */
public class FinanceTarget {

    public List<Target> targets;
    public Integer[] RowsCols;
    public Integer total;

    private List<Double> concrete = new ArrayList<Double>();

    public FinanceTarget(){
        init();
    }

    private void init(){
        RowsCols = new Integer[]{1,5,3,3,5,1};
        targets = new ArrayList<Target>();

        targets.add(new Target(-1,5));
        targets.add(new Target(0.4,0.6,2));
        targets.add(new Target(1.0,3.5));
        targets.add(new Target(0.5,2.5));
        targets.add(new Target(0.2,0.6));
        targets.add(new Target(0.5,3.0));
        targets.add(new Target(0.0,0.1,1));
        targets.add(new Target(0.0,0.5));
        targets.add(new Target(0.0,2.0));
        targets.add(new Target(0.0,1.0,1));
        targets.add(new Target(0.0,0.3));
        targets.add(new Target(0.0,0.2));
        targets.add(new Target(0.0,0.6));
        targets.add(new Target(0,360,1));
        targets.add(new Target(0.0,2.5));
        targets.add(new Target(0,10));
        targets.add(new Target(0,65));
        targets.add(new Target(0,0));

        total = 18;
    }

    public boolean setConcrete(List<Double> list){

        if (list.size() != total){
            return false;
        }
        for (Double d: list){
            this.concrete.add(d);
        }
        return true;
    }

    public List<Double> getConcrete(){
        return this.concrete;
    }

    public List<Target> getTargets(){
        return this.targets;
    }
    public Integer[] getRowsCols(){
        return RowsCols;
    }
}
