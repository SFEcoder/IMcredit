package com.example.common.calculation;

import java.util.ArrayList;
import java.util.List;
import com.example.common.calculation.enumType.divType1;
import com.example.common.calculation.enumType.divType2;
import com.example.common.calculation.enumType.divType3;
import com.example.common.calculation.enumType.divType4;
import com.example.common.calculation.enumType.divType5;

/**
 * @Author: Owen
 * @Date: 2020/10/20 23:00
 * @Description: 两化评分
 */
public class DivRank {

    public static final Integer[] index1 = {0,5,11,12};
    public static final Integer[] index2 = {0,9,15,16,24};
    public static final Integer[] index3 = {0,7,13,16,24};
    public static final Integer[] index4 = {0,7,12};
    public static final Integer[] index5 = {0,6,12,14};

    public static List<Double> getDivergenceScore(List<List<Double>> list, int type){

        List<Double> tmpList = new ArrayList<>();

        // 中间结果
        List<List<Double>> firstList = new ArrayList<>();
        List<List<List<Double>>> secondList = new ArrayList<>();
        List<Double> afterSQList = new ArrayList<>();
        List<List<Double>> thirdList = new ArrayList<>();

        List<Double> divergenceScore = new ArrayList<>();

        if (type == 1){
            int base = 0;
            for (int i=0; i<divType1.A.getTwoToOne().length; i++){
                for (int j=0; j<list.size(); j++){
                    int counter = base;
                    for (int k=0; k<divType1.A.getTwoToOne()[i]; k++){
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
                afterSQList = Calculation.entropyWeightForDiv(secondList.get(i),index1[i], type-1);
                thirdList.add(afterSQList);
            }
        }else if (type == 2){
            int base = 0;
            for (int i=0; i<divType2.A.getTwoToOne().length; i++){
                for (int j=0; j<list.size(); j++){
                    int counter = base;
                    for (int k=0; k<divType2.A.getTwoToOne()[i]; k++){
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
                afterSQList = Calculation.entropyWeightForDiv(secondList.get(i),index2[i], type-1);
                thirdList.add(afterSQList);
            }
        }else if (type == 3){
            int base = 0;
            for (int i=0; i<divType3.A.getTwoToOne().length; i++){
                for (int j=0; j<list.size(); j++){
                    int counter = base;
                    for (int k=0; k<divType3.A.getTwoToOne()[i]; k++){
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
                afterSQList = Calculation.entropyWeightForDiv(secondList.get(i),index3[i], type-1);
                thirdList.add(afterSQList);
            }
        }else if (type == 4){
            int base = 0;
            for (int i=0; i<divType4.A.getTwoToOne().length; i++){
                for (int j=0; j<list.size(); j++){
                    int counter = base;
                    for (int k=0; k<divType4.A.getTwoToOne()[i]; k++){
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
                afterSQList = Calculation.entropyWeightForDiv(secondList.get(i),index4[i], type-1);
                thirdList.add(afterSQList);
            }
        }else if (type == 5){
            int base = 0;
            for (int i=0; i<divType5.A.getTwoToOne().length; i++){
                for (int j=0; j<list.size(); j++){
                    int counter = base;
                    for (int k=0; k<divType5.A.getTwoToOne()[i]; k++){
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
                afterSQList = Calculation.entropyWeightForDiv(secondList.get(i),index5[i], type-1);
                thirdList.add(afterSQList);
            }
        }else{
            System.out.println("Error type");
            return null;
        }


        divergenceScore = Calculation.entropyWeightForFinal(thirdList);
        return divergenceScore;
    }

    public static List<List<Double>> getDivergenceTopTarget(List<List<Double>> list, int type){

        List<List<Double>> divTopList = new ArrayList<>();
        List<Double> tmpList = new ArrayList<>();

        // 中间结果
        List<List<Double>> firstList = new ArrayList<>();
        List<List<List<Double>>> secondList = new ArrayList<>();
        List<Double> afterSQList = new ArrayList<>();
        List<List<Double>> thirdList = new ArrayList<>();

        if (type==1){
            int base = 0;
            for (int i=0; i<divType1.A.getTwoToOne().length; i++){
                for (int j=0; j<list.size(); j++){
                    int counter = base;
                    for (int k=0; k<divType1.A.getTwoToOne()[i]; k++){
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
                afterSQList = Calculation.entropyWeightForDiv(secondList.get(i),index1[i], type-1);
                thirdList.add(afterSQList);
            }
        }else if (type == 2) {
            int base = 0;
            for (int i=0; i<divType2.A.getTwoToOne().length; i++){
                for (int j=0; j<list.size(); j++){
                    int counter = base;
                    for (int k=0; k<divType2.A.getTwoToOne()[i]; k++){
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
                afterSQList = Calculation.entropyWeightForDiv(secondList.get(i),index2[i], type-1);
                thirdList.add(afterSQList);
            }
        }else if (type == 3){
            int base = 0;
            for (int i=0; i<divType3.A.getTwoToOne().length; i++){
                for (int j=0; j<list.size(); j++){
                    int counter = base;
                    for (int k=0; k<divType3.A.getTwoToOne()[i]; k++){
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
                afterSQList = Calculation.entropyWeightForDiv(secondList.get(i),index3[i], type-1);
                thirdList.add(afterSQList);
            }
        }else if (type == 4){
            int base = 0;
            for (int i=0; i<divType4.A.getTwoToOne().length; i++){
                for (int j=0; j<list.size(); j++){
                    int counter = base;
                    for (int k=0; k<divType4.A.getTwoToOne()[i]; k++){
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
                afterSQList = Calculation.entropyWeightForDiv(secondList.get(i),index4[i], type-1);
                thirdList.add(afterSQList);
            }
        }else if (type == 5){
            int base = 0;
            for (int i=0; i<divType5.A.getTwoToOne().length; i++){
                for (int j=0; j<list.size(); j++){
                    int counter = base;
                    for (int k=0; k<divType5.A.getTwoToOne()[i]; k++){
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
                afterSQList = Calculation.entropyWeightForDiv(secondList.get(i),index5[i], type-1);
                thirdList.add(afterSQList);
            }
        }else{
            System.out.println("Error type");
            return null;
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
