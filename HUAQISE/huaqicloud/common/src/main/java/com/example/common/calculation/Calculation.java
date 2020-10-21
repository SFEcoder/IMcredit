package com.example.common.calculation;

import com.example.common.calculation.enumType.EnumType;

import java.lang.Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
 * @Author: Owen
 * @Date: 2020/10/20 15:18
 * @Description: 基础算法类
 */
public class Calculation {

    // 指标的正负向数组
    private static final EnumType[] enums = {EnumType.A,EnumType.B,EnumType.C,EnumType.D,EnumType.E,EnumType.F,EnumType.G,EnumType.H,EnumType.I,EnumType.J,EnumType.K,EnumType.L,EnumType.M,EnumType.N,EnumType.O,EnumType.P,EnumType.Q};

    /**
     * @param xList
     * */
    public static double zScore (double xi, List<Double> xList){
        double atmp = 0, btmp = 0, revalue = 0;
        double tmp = 0, ave= 0;
        double n = xList.size();

        try{
            for (int i=0; i<n; i++)
                tmp += xList.get(i);
            ave = tmp / n;

            atmp = n * (xi - ave);

            for (int i=0; i<n; i++)
                btmp += Math.pow((xList.get(i)-ave), 2);
            btmp = Math.sqrt(btmp);

            revalue = (Math.sqrt(n-1)*atmp) / (n*btmp);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }

        return revalue;
    }

    /**
     * @param xList 相同指标集合
     * @param index 0代表正向指标；1代表负向指标
     * */
    public static double minMaxScore (double xi, List<Double> xList, int index){

        EnumType et = enums[index];

        if (et.getControl() != -1 && et.getControl() != 0 && et.getControl() != 1) return 0;

        // 指标为满意值另外判断
        if (et.getControl() == -1){
            if (xi < et.getBelow()) return 0;
            if (xi > et.getAbove()) return 1;
            return (xi - et.getBelow()) / (et.getAbove() - et.getBelow());
        }

        double xmin = 1000000, xmax = -1000000, revalue = 0;
        double reBelow = et.getBelow(), reAbove = et.getAbove();

        if (et.getBelow() > et.getAbove()) {
            reBelow = et.getAbove();
            reAbove = et.getBelow();
        }

        // 奇异值返回0
        if (xi < reBelow && xi > reAbove) return 0;

        for (int i=0; i<xList.size(); i++){
            if (xList.get(i) >= xmax) xmax = xList.get(i);
            if (xList.get(i) <= xmin) xmin = xList.get(i);
        }

        try{
            if (et.getControl() == 0){
                revalue = (xi - xmin) / (xmax - xmin);
            }else{
                revalue = (xmax - xi) / (xmax - xmin);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return revalue;
    }


    /**
     * 熵权法
     * @param doubleArray: 二维矩阵
     * List<Double>: 一个公司
     * List<List>: 公司集合
     *
     * 传进的二维矩阵指标顺序要固定，利用已存在的数组去判断正向或负向指标
     * */
    public static List<Double> entropyWeight (List<List<Double>> doubleArray) {

        List<Double> tmpList = new ArrayList<>();           // 相同指标的集合
        List<List<Double>> doubleList = new ArrayList<>();

        List<List<Double>> starList = new ArrayList<>();

        List<List<Double>> pList = new ArrayList<>();
        List<Double> dList = new ArrayList<>();
        List<Double> wList = new ArrayList<>();
        List<Double> sList = new ArrayList<>();          // 每个公司综合指标

        // step 1
        for (int j=0; j<doubleArray.get(0).size(); j++){
            for (int i=0; i<doubleArray.size(); i++){
                tmpList.add(doubleArray.get(i).get(j));
            }
            doubleList.add(tmpList);
            tmpList = new ArrayList<>();
        }

        // step 2
        for (int i=0; i<doubleList.size(); i++){
            for (int j=0; j<doubleList.get(i).size(); j++){
                double xi = 0;
                xi = minMaxScore(doubleList.get(i).get(j), doubleList.get(i), i);
                tmpList.add(xi);
            }
            starList.add(tmpList);
            tmpList = new ArrayList<>();
        }

        // step 3
        for (int i=0; i<starList.size(); i++){
            double sum = 0;
            for (int k=0; k<starList.get(i).size(); k++){
                sum += starList.get(i).get(k);
            }

            for (int j=0; j<doubleList.get(i).size(); j++){
                double p = starList.get(i).get(j) / sum;
                tmpList.add(p);
            }
            pList.add(tmpList);
            tmpList = new ArrayList<>();
        }

        // step 4
        double k = 1 / (Math.log(starList.size()));
        for (int i=0; i<starList.size(); i++){
            double tmp = 0;
            for (int j=0; j<starList.get(i).size(); j++){
                if (pList.get(i).get(j) == 0) break;
                else tmp += pList.get(i).get(j) * Math.log(pList.get(i).get(j));
            }
            dList.add(1 + k*tmp);
        }

        // step 5
        double sumD = 0;
        for (int i=0; i<dList.size(); i++){
            sumD += dList.get(i);
        }
        for (int i=0; i<dList.size(); i++){
            wList.add((dList.get(i) / sumD));
        }

        // step 6
        for (int i=0; i<pList.get(0).size(); i++){
            double s = 0;
            for (int j=0; j<pList.size(); j++){
                s += wList.get(j) * pList.get(j).get(i);     // start here
            }
            sList.add(s);
        }

        return sList;
    }

    public static List<Double> entropyWeightForFinal (List<List<Double>> doubleArray) {
        List<Double> tmpList = new ArrayList<>();           // 相同指标的集合
        List<List<Double>> doubleList = doubleArray;

        List<List<Double>> starList = new ArrayList<>();

        List<List<Double>> pList = new ArrayList<>();
        List<Double> dList = new ArrayList<>();
        List<Double> wList = new ArrayList<>();
        List<Double> sList = new ArrayList<>();          // 每个公司综合指标

        // step 2
        for (int i=0; i<doubleList.size(); i++){
            for (int j=0; j<doubleList.get(i).size(); j++){
                double xi = 0;
                xi = minMaxScore(doubleList.get(i).get(j), doubleList.get(i), i);
                tmpList.add(xi);
            }
            starList.add(tmpList);
            tmpList = new ArrayList<>();
        }

        // step 3
        for (int i=0; i<starList.size(); i++){
            double sum = 0;
            for (int k=0; k<starList.get(i).size(); k++){
                sum += starList.get(i).get(k);
            }

            for (int j=0; j<doubleList.get(i).size(); j++){
                double p = starList.get(i).get(j) / sum;
                tmpList.add(p);
            }
            pList.add(tmpList);
            tmpList = new ArrayList<>();
        }

        // step 4
        double k = 1 / (Math.log(starList.size()));
        for (int i=0; i<starList.size(); i++){
            double tmp = 0;
            for (int j=0; j<starList.get(i).size(); j++){
                if (pList.get(i).get(j) == 0) break;
                else tmp += pList.get(i).get(j) * Math.log(pList.get(i).get(j));
            }
            dList.add(1 + k*tmp);
        }

        // step 5
        double sumD = 0;
        for (int i=0; i<dList.size(); i++){
            sumD += dList.get(i);
        }
        for (int i=0; i<dList.size(); i++){
            wList.add((dList.get(i) / sumD));
        }

        // step 6
        for (int i=0; i<pList.get(0).size(); i++){
            double s = 0;
            for (int j=0; j<pList.size(); j++){
                s += wList.get(j) * pList.get(j).get(i);     // start here
            }
            sList.add(s);
        }

        return sList;

    }

}
