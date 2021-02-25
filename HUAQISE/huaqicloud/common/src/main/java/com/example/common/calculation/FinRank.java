package com.example.common.calculation;

import com.example.common.calculation.Target.FinTarget.FinanceTarget;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Owen
 * @Date: 2021/2/15 20:44
 * @Description:
 */
public class FinRank {

    public static List<Double> getFinanceScore(List<List<Double>> list){

        FinanceTarget financeTarget = new FinanceTarget();

        // 中间结果
        List<Double> afterMMList = new ArrayList<>();        // 公司的各项指标（做过min_max）
        List<List<Double>> firstList = new ArrayList<>();    // 中间结果 1 （全部公司）
        List<Double> afterSUMList = new ArrayList<>();      // 公司二级指标和
        List<List<Double>> secondList = new ArrayList<>();  // 中间结果 2 (全部公司 ) aka 一级指标
        List<Double> afterMM2List = new ArrayList<>();      // 公司一级级指标和
        List<List<Double>> thirdList = new ArrayList<>();  // 中间结果 2 (全部公司 )

        List<Double> financeScore = new ArrayList<>();      // 最终财务评分

        List<Double> tmpList = new ArrayList<>();

        for (int i=0; i<list.size(); i++){      // 3
            for (int j=0; j<list.get(i).size(); j++){   // 17
                for (int k=0; k<list.size(); k++){
                    tmpList.add(list.get(k).get(j));
                }
                afterMMList.add(Calculation.minMaxScoreForFin(list.get(i).get(j), tmpList, j));
                tmpList = new ArrayList<>();
            }
            firstList.add(afterMMList);
            afterMMList = new ArrayList<>();
        }


        for (int a=0; a<firstList.size(); a++){
            int counter = 0;

            for (int i=0; i<financeTarget.getRowsCols().length; i++){
                double sum = 0;
                for (int j=0; j<financeTarget.getRowsCols()[i]; j++){
                    sum += firstList.get(a).get(counter);
                    counter++;
                }
                afterSUMList.add(sum);
            }
            secondList.add(afterSUMList);
            afterSUMList = new ArrayList<>();
        }
        //财务第二部直接是总评 = 一级指标和
        for (int i=0; i<secondList.size(); i++){
            double sum = 0;
            for (int j=0; j<secondList.get(i).size(); j++){
                sum += secondList.get(i).get(j);
            }
            financeScore.add(sum);
        }


        // 财务第二部也取min_max
//        for (int i=0; i<secondList.size(); i++){
//            for (int j=0; j<secondList.get(i).size(); j++){
//                for (int k=0; k<secondList.size(); k++){
//                    tmpList.add(secondList.get(k).get(j));
//                }
//                afterMM2List.add(Calculation.minMaxScore(secondList.get(i).get(j), tmpList));
//                tmpList = new ArrayList<>();
//            }
//            thirdList.add(afterMM2List);
//            afterMM2List = new ArrayList<>();
//        }
//
//        for (int i=0; i<thirdList.size(); i++){
//            double sum = 0;
//            for (int j=0; j<thirdList.get(i).size(); j++){
//                sum += thirdList.get(i).get(j);
//            }
//            financeScore.add(sum);
//        }

        return financeScore;
    }

    public static List<List<Double>> getFinanceTopTarget(List<List<Double>> list){

        FinanceTarget financeTarget = new FinanceTarget();
        // 中间结果
        List<Double> afterMMList = new ArrayList<>();        // 公司的各项指标（做过min_max）
        List<List<Double>> firstList = new ArrayList<>();    // 中间结果 1 （全部公司）
        List<Double> afterSUMList = new ArrayList<>();      // 公司二级指标和
        List<List<Double>> secondList = new ArrayList<>();  // 中间结果 2 (全部公司 ) aka 一级指标
        List<List<Double>> finTopList = new ArrayList<>();

        List<Double> tmpList = new ArrayList<>();

        for (int i=0; i<list.size(); i++){      // 3
            for (int j=0; j<list.get(i).size(); j++){   // 17
                for (int k=0; k<list.size(); k++){
                    tmpList.add(list.get(k).get(j));
                }
                afterMMList.add(Calculation.minMaxScoreForFin(list.get(i).get(j), tmpList, j));
                tmpList = new ArrayList<>();
            }
            firstList.add(afterMMList);
            afterMMList = new ArrayList<>();
        }


        for (int a=0; a<firstList.size(); a++){
            int counter = 0;
            for (int i=0; i<financeTarget.getRowsCols().length; i++){
                double sum = 0;
                for (int j=0; j<financeTarget.getRowsCols()[i]; j++){
                    sum += firstList.get(a).get(counter);
                    counter++;
                }
                afterSUMList.add(sum);
            }
            secondList.add(afterSUMList);
            afterSUMList = new ArrayList<>();
        }

        // 存中间结果 一级指标
        for (int i=0; i<secondList.size(); i++){
            for (int j=0; j<secondList.get(i).size(); j++){
                tmpList.add(secondList.get(i).get(j));
            }
            finTopList.add(tmpList);
            tmpList = new ArrayList<>();
        }
        return finTopList;
    }


    /***
     * 财务评分 - 用于页面展示
     */
    public static List<Double> getFinanceDisplay(List<Double> list){
        List<Double> relist = new ArrayList<>();
        for (int i=0; i<list.size(); i++){
            relist.add(100 * Calculation.minMaxScore(list.get(i), list));
        }
        return relist;
    }
}
