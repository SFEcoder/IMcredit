package com.example.common.calculation;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Owen
 * @Date: 2020/10/20 22:59
 * @Description: 财务评分
 */
public class FinRank {


    public static List<Double> main(List<List<Double>> list){

        List<List<Double>> doubleList = new ArrayList<>();
        List<List<Double>> starList = new ArrayList<>();
        List<Double> tmpList = new ArrayList<>();

        List<Double> initial = new ArrayList<>();
        List<Double> finalList = new ArrayList<>();

        for (int j=0; j<list.get(0).size(); j++){
            for (int i=0; i<list.size(); i++){
                tmpList.add(list.get(i).get(j));
            }
            doubleList.add(tmpList);
            tmpList = new ArrayList<>();
        }

        for (int i=0; i<doubleList.size(); i++){
            for (int j=0; j<doubleList.get(i).size(); j++){
                double xi = 0;
                xi = Calculation.minMaxScore(doubleList.get(i).get(j), doubleList.get(i), i);
                tmpList.add(xi);
            }
            starList.add(tmpList);
            tmpList = new ArrayList<>();
        }

        for (int i=0; i<starList.get(0).size(); i++){
            double tmp = 0;
            for (int j=0; j<starList.size(); j++){
                tmp += starList.get(j).get(i);
            }
            initial.add(tmp);
        }

        for (int i=0; i<initial.size(); i++){
            finalList.add(100 * Calculation.minMaxScore(initial.get(i), initial,0));  // 将enums[0]充当index，因为这边使用正向指标
        }

        return finalList;
    }
}
