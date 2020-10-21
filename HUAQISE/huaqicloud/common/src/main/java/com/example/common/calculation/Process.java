package com.example.common.calculation;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Owen
 * @Date: 2020/10/20 16:41
 * @Description: 主进程
 */
public class Process {

    public static void main (String[] args){

        List<Double> tmp1 = Arrays.asList(4.0,0.5,2.0,1.0,0.4,1.0,0.1,0.2,1.0,0.2,0.2,0.1,0.5,300.0,1.0,2.0,30.0);
        List<Double> tmp2 = Arrays.asList(0.0,0.55,2.5,1.2,0.3,0.7,0.05,0.4,1.5,0.5,0.1,0.15,0.4,200.0,1.5,5.0,60.0);
        List<Double> tmp3 = Arrays.asList(3.0,0.45,1.5,0.8,0.5,1.5,0.08,0.45,0.5,0.7,0.15,0.15,0.2,150.0,2.2,3.0,15.0);
        List<List<Double>> list = Arrays.asList(tmp1,tmp2,tmp3);

        // financial ranking
        List<Double> finList = FinRank.main(list);

        // divergence ranking
        List<Double> divList = DivRank.main(list);

        // final ranking
        List<List<Double>> rankList = Arrays.asList(divList,finList);
        List<Double> finalList = Calculation.entropyWeightForFinal(rankList);

        System.out.println(finalList);
    }

}
