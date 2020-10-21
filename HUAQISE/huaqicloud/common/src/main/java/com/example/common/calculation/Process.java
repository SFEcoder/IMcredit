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

    public static void main(String[] args){

        List<Double> d1 = Arrays.asList(95.0,3.0,1.0,-2.0,1.0,0.0,1.0,30.92,2.0,1.0,1.0,8.0,2.0,1.0,2.0,3.0,2.0);
        List<Double> d2 = Arrays.asList(100.0,4.0,2.0,-5.0,5.0,3.0,3.0,39.43,9.0,1.0,5.0,65.0,3.0,1.0,4.0,4.0,4.0);
        List<Double> d3 = Arrays.asList(100.0,0.0,1.0,0.0,-1.0,0.0,0.0,20.0,0.0,1.0,1.0,40.0,0.0,1.0,1.0,0.0,1.0);
        List<Double> d4 = Arrays.asList(99.0,4.0,2.0,-3.0,-5.0,0.0,0.0,43.0,2.0,0.0,2.0,42.0,0.0,1.0,0.0,2.0,3.0);
        List<List<Double>> diverList = Arrays.asList(d1,d2,d3,d4);

        System.out.println(DivRank.getDivergenceScore(diverList));

//        List<Double> f1 = Arrays.asList();
//        List<Double> f2 = Arrays.asList();
//        List<Double> f3 = Arrays.asList();
//        List<Double> f4 = Arrays.asList();
//        List<List<Double>> finanList = Arrays.asList(f1,f2,f3,f4);

//        System.out.println(getFinalScore(finanList, diverList));

    }

    public static List<Double> getFinalScore(List<List<Double>> finanList, List<List<Double>> diverList){

        // financial ranking
        List<Double> finList =FinRank.getFinanceScore(finanList);
        List<List<Double>> financeTopTarget = FinRank.getFinanceTopTarget(finanList);

        // divergence ranking
        List<Double> divList = DivRank.getDivergenceScore(diverList);
        List<List<Double>> divergenceTopTarget = DivRank.getDivergenceTopTarget(diverList);

        // final ranking
        List<List<Double>> rankList = Arrays.asList(divList,finList);
        List<Double> finalList = Calculation.entropyWeightForFinal(rankList);

        System.out.println(finalList);

        return finalList;
    }
}
