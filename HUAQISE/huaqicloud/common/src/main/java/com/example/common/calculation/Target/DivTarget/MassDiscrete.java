package com.example.common.calculation.Target.DivTarget;

import java.util.ArrayList;
import java.util.List;

import com.example.common.calculation.Target.Target;

/**
 * @Author: Owen
 * @Date: 2020/12/5 19:59
 * @Description:
 */
public class MassDiscrete extends EnterTarget{

    public MassDiscrete(){
        this.init();
    }

    private void init(){
        RowsCols = new Integer[][]{{1,1,1,1,1},{2,1,2,1},{1},{2,1,1,1}};
        rowcols = new Integer[]{5,6,1,6};
        targets = new ArrayList<Target>();

        targets.add(new Target(0,100));
        targets.add(new Target(0,5));
        targets.add(new Target(0,5));
        targets.add(new Target(-5,0));
        targets.add(new Target(-5,5));
        targets.add(new Target(0,3));
        targets.add(new Target(0,7));
        targets.add(new Target(0,100));
        targets.add(new Target(0,10));
        targets.add(new Target(0,5));
        targets.add(new Target(0,5));
        targets.add(new Target(0,100));
        targets.add(new Target(0,9));
        targets.add(new Target(0,9));
        targets.add(new Target(0,7));
        targets.add(new Target(0,4));
        targets.add(new Target(0,4));

        total = 17;
    }

    public List<Target> getTargets(){
        return this.targets;
    }
}
