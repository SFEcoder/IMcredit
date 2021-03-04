package com.example.common.calculation.Target.DivTarget;

import com.example.common.calculation.Target.Target;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Owen
 * @Date: 2020/12/6 21:55
 * @Description:
 */
public class EnterTarget {

    public List<Target> targets;
    public Integer[][] RowsCols;
    public Integer[] rowcols;
    public Integer total;

    private List<Double> concrete = new ArrayList<Double>();

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

    public Integer[][] getRowsCols(){
        return RowsCols;
    }
    public Integer[] getrowcols(){ return this.rowcols; }
}
