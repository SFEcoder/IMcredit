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

        List<List<Double>> list = new ArrayList<>();

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
