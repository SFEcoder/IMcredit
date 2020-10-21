package com.example.common.calculation;

import java.util.ArrayList;
import java.util.List;
import com.example.common.calculation.enumType.divType;

/**
 * @Author: Owen
 * @Date: 2020/10/20 23:00
 * @Description: 两化评分
 */
public class DivRank {

    public static final Integer[] index = {0,5,11,12};

    public static List<Double> getDivergenceScore(List<List<Double>> list){

        List<Double> tmpList = new ArrayList<>();

        // 中间结果
        List<List<Double>> firstList = new ArrayList<>();
        List<List<List<Double>>> secondList = new ArrayList<>();
        List<Double> afterSQList = new ArrayList<>();
        List<List<Double>> thirdList = new ArrayList<>();

        List<Double> divergenceScore = new ArrayList<>();

        int base = 0;
        for (int i=0; i<divType.A.getTwoToOne().length; i++){
            for (int j=0; j<list.size(); j++){
                int counter = base;
                for (int k=0; k<divType.A.getTwoToOne()[i]; k++){
                    tmpList.add(list.get(j).get(counter));
                    counter++;
                }
                firstList.add(tmpList);
                tmpList = new ArrayList<>();
            }
            secondList.add(firstList);
            firstList = new ArrayList<>();
        }

        for (int i=0; i<secondList.size(); i++){
            afterSQList = Calculation.entropyWeightForDiv(secondList.get(i),index[i]);
            thirdList.add(afterSQList);
        }
        divergenceScore = Calculation.entropyWeightForFinal(thirdList);

        return divergenceScore;
    }

    public static List<List<Double>> getDivergenceTopTarget(List<List<Double>> list){

        List<List<Double>> divTopList = new ArrayList<>();
        List<Double> tmpList = new ArrayList<>();

        // 中间结果
        List<List<Double>> firstList = new ArrayList<>();
        List<List<List<Double>>> secondList = new ArrayList<>();
        List<Double> afterSQList = new ArrayList<>();
        List<List<Double>> thirdList = new ArrayList<>();

        int base = 0;
        for (int i=0; i<divType.A.getTwoToOne().length; i++){
            for (int j=0; j<list.size(); j++){
                int counter = base;
                for (int k=0; k<divType.A.getTwoToOne()[i]; k++){
                    tmpList.add(list.get(j).get(counter));
                    counter++;
                }
                firstList.add(tmpList);
                tmpList = new ArrayList<>();
            }
            secondList.add(firstList);
            firstList = new ArrayList<>();
        }

        for (int i=0; i<secondList.size(); i++){
            afterSQList = Calculation.entropyWeightForDiv(secondList.get(i),index[i]);
            thirdList.add(afterSQList);
        }

        // 保存一级指标
        for (int i=0; i<thirdList.size(); i++){
            for (int j=0; j<thirdList.get(i).size(); j++){
                tmpList.add(thirdList.get(i).get(j));
            }
            divTopList.add(tmpList);
            tmpList = new ArrayList<>();
        }

        return divTopList;
    }
}
