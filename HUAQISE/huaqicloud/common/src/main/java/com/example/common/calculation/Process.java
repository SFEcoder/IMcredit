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

//        System.out.println(DivRank.getDivergenceScore(diverList));

        List<Double> f1 = Arrays.asList(4.0,0.52,2.0,2.5,0.5,2.0,0.05,0.5,1.0,1.0,0.3,0.1,0.5,166.0,2.0,3.0,55.0);
        List<Double> f2 = Arrays.asList(3.0,0.51,2.0,2.5,0.5,2.0,0.05,0.5,1.0,1.0,0.3,0.1,0.5,166.0,2.0,3.0,55.0);
        List<Double> f3 = Arrays.asList(2.0,0.5,2.0,2.5,0.5,2.0,0.05,0.5,1.0,1.0,0.3,0.1,0.6,111.0,2.0,4.0,55.0);
        List<Double> f4 = Arrays.asList(5.0,0.5,2.0,2.5,0.5,2.0,0.05,0.5,1.0,1.0,0.3,0.1,0.2,222.0,2.0,5.0,5.0);
        List<List<Double>> finanList = Arrays.asList(f1,f2,f3,f4);

        System.out.println(FinRank.getFinanceTopTarget(finanList));
        List<Double> list = FinRank.getFinanceScore(finanList);
        System.out.println(list);
        System.out.println(FinRank.getFinanceDisplay(list));

//        System.out.println(getFinalScore(finanList, diverList));

    }

    public static List<Double> getFinalScore(List<List<Double>> finanList, List<List<Double>> diverList){

        List<Double> tmpList = new ArrayList<>();
        List<List<Double>> rankList = new ArrayList<>();

        // financial ranking
        List<Double> finList =FinRank.getFinanceScore(finanList);
        List<List<Double>> financeTopTarget = FinRank.getFinanceTopTarget(finanList);

        // divergence ranking
        List<Double> divList = DivRank.getDivergenceScore(diverList);
        List<List<Double>> divergenceTopTarget = DivRank.getDivergenceTopTarget(diverList);

        // final ranking

        for (int i=0; i<finList.size(); i++){
            tmpList.add(finList.get(i));
            tmpList.add(divList.get(i));
            rankList.add(tmpList);
            tmpList = new ArrayList<>();
        }

        List<Double> finalList = Calculation.entropyWeightForFinal(rankList);

        return finalList;
    }
}
