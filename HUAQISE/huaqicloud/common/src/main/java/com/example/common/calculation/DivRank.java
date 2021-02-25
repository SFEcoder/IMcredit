package com.example.common.calculation;

import com.example.common.calculation.Target.DivTarget.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Owen
 * @Date: 2021/2/15 20:50
 * @Description:
 */
public class DivRank {

    private static final Integer[][] index = {{0,5,11,12}, {0,9,15,16,24}, {0,7,13,16,24}, {0,7,10,12}, {0,6,12,14}};

    public static List<Double> getDivergenceScore(List<List<Double>> list, int type){
        List<Double> divergenceScore = new ArrayList<>();
        List<List<Double>> resultList = new ArrayList<>();

        if (type == 1){
            MassDiscrete massDiscrete = new MassDiscrete();
            resultList = specifyDivergenceScore(list, massDiscrete.getrowcols() ,1);
        }else if (type == 2){
            ProcIndustry procIndustry = new ProcIndustry();
            resultList = specifyDivergenceScore(list, procIndustry.getrowcols() ,2);
        }else if (type == 3){
            SmeDiscrete smeDiscrete = new SmeDiscrete();
            resultList = specifyDivergenceScore(list, smeDiscrete.getrowcols() ,3);
        }else if (type == 4){
            ServeIndustry serveIndustry = new ServeIndustry();
            resultList = specifyDivergenceScore(list, serveIndustry.getrowcols() ,4);
        }else if (type == 5){
            MixIndustry mixIndustry = new MixIndustry();
            resultList = specifyDivergenceScore(list, mixIndustry.getrowcols() ,5);
        }else{
            System.out.println("Error type");
            return null;
        }
        divergenceScore = Calculation.entropyWeightForFinal(resultList);
        return divergenceScore;
    }

    public static List<List<Double>> getDivergenceTopTarget(List<List<Double>> list, int type){

        List<List<Double>> resultList = new ArrayList<>();

        if (type==1){
            MassDiscrete massDiscrete = new MassDiscrete();
            resultList = specifyDivergenceTopTarget(list, massDiscrete.getrowcols(), 1);
        }else if (type == 2) {
            ProcIndustry procIndustry = new ProcIndustry();
            resultList = specifyDivergenceTopTarget(list, procIndustry.getrowcols(), 2);
        }else if (type == 3){
            SmeDiscrete smeDiscrete = new SmeDiscrete();
            resultList = specifyDivergenceTopTarget(list, smeDiscrete.getrowcols(), 3);
        }else if (type == 4){
            ServeIndustry serveIndustry = new ServeIndustry();
            resultList = specifyDivergenceTopTarget(list, serveIndustry.getrowcols(), 4);
        }else if (type == 5){
            MixIndustry mixIndustry = new MixIndustry();
            resultList = specifyDivergenceTopTarget(list, mixIndustry.getrowcols(), 5);
        }else{
            System.out.println("Error type");
            return null;
        }
        return resultList;
    }

    /*
     * @function 细化getDivergenceScore
     * */
    private static List<List<Double>> specifyDivergenceScore(List<List<Double>> list, Integer[] rowcols, Integer type){

        List<Double> tmpList = new ArrayList<>();

        // 中间结果
        List<List<Double>> firstList = new ArrayList<>();
        List<List<List<Double>>> secondList = new ArrayList<>();
        List<Double> afterSQList = new ArrayList<>();
        List<List<Double>> thirdList = new ArrayList<>();

        int base = 0;
        for (int i=0; i<rowcols.length; i++){
            for (int j=0; j<list.size(); j++){
                int counter = base;
                for (int k=0; k<rowcols[i]; k++){
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
            afterSQList = Calculation.entropyWeightForDiv(secondList.get(i),index[type-1][i], type-1);
            thirdList.add(afterSQList);
        }
        return thirdList;
    }

    /*
    * @function 细化getDivergenceTopTarget
    * */
    private static List<List<Double>> specifyDivergenceTopTarget(List<List<Double>> list, Integer[] rowcols, Integer type){

        List<List<Double>> divTopList = new ArrayList<>();
        List<Double> tmpList = new ArrayList<>();

        // 中间结果
        List<List<Double>> firstList = new ArrayList<>();
        List<List<List<Double>>> secondList = new ArrayList<>();
        List<Double> afterSQList = new ArrayList<>();
        List<List<Double>> thirdList = new ArrayList<>();

        int base = 0;
        for (int i=0; i<rowcols.length; i++){
            for (int j=0; j<list.size(); j++){
                int counter = base;
                for (int k=0; k<rowcols[i]; k++){
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
            afterSQList = Calculation.entropyWeightForDiv(secondList.get(i),index[type-1][i], type-1);
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
