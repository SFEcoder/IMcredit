package com.example.common.calculation;

/**
 * @Author: Owen
 * @Date: 2021/2/15 20:05
 * @Description:
 */
import com.example.common.calculation.Target.DivTarget.*;
import com.example.common.calculation.Target.FinTarget.FinanceTarget;
import com.example.common.calculation.Target.Target;

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;



/**
 * @Author: Owen
 * @Date: 2020/10/20 15:18
 * @Description: 基础算法类
 */
public class Calculation {

    // private static final Integer[] limit = {17,21,25,18,26};  // 17 25 26 18 21?
    private static final Integer[] limit = {17,25,26,18,21};
    /**
     * @function 标准化
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
     * @function 标准min_max
     * @param xList 相同指标集合
     * */
    public static double minMaxScore (double xi, List<Double> xList){


        double xmin = 1000000, xmax = -1000000, revalue = 0;

        for (int i=0; i<xList.size(); i++){
            if (xList.get(i) >= xmax) xmax = xList.get(i);
            if (xList.get(i) <= xmin) xmin = xList.get(i);
        }

        try{
            if (xi - xmin == xmax - xmin) revalue = 1;
            else revalue = (xi - xmin) / (xmax - xmin);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return revalue;
    }

    /**
     * @function 财务指标min_max
     * @param xList 相同指标集合
     * @param index
     * */
    public static double minMaxScoreForFin (double xi, List<Double> xList, int index){

        FinanceTarget financeTarget = new FinanceTarget();
        Target et = financeTarget.getTargets().get(index);

        if (et.getType() != 0 && et.getType() != 1 && et.getType() != 2) return 0;

        // 指标为满意值另外判断
        if (et.getType() == 2){
            if (xi < et.getLeft()) return 0;
            if (xi > et.getRight()) return 1;
            return (xi - et.getLeft()) / (et.getRight() - et.getLeft());
        }

        double xmin = 1000000, xmax = -1000000, revalue = 0;
        double reBelow = et.getLeft(), reAbove = et.getRight();

        // 调整成正确的阈值
        if (et.getLeft() > et.getRight()) {
            reBelow = et.getRight();
            reAbove = et.getLeft();
        }

        // 奇异值返回0
        if (xi < reBelow && xi > reAbove) return 0;

        for (int i=0; i<xList.size(); i++){
            if (xList.get(i) >= xmax) xmax = xList.get(i);
            if (xList.get(i) <= xmin) xmin = xList.get(i);
        }

        try{
            if (et.getType() == 0){
                if (xi - xmin == xmax - xmin) revalue = 1;
                else revalue = (xi - xmin) / (xmax - xmin);
            }else{
                if (xmax - xi == xmax - xmin) revalue = 1;
                else revalue = (xmax - xi) / (xmax - xmin);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return revalue;
    }

    /**
     * @function 两化指标min_max
     * @param xList 相同指标集合
     * @param index 0代表正向指标；1代表负向指标
     * */
    public static double minMaxScoreForDiv (double xi, List<Double> xList, int index, int type){

        Target et = new Target(0,0);
        if (type == 0){
            if(index >= 17)index = 16;
            MassDiscrete massDiscrete = new MassDiscrete();
            et = massDiscrete.getTargets().get(index);
        }else if (type == 1){
            if(index >= 25)index = 24;
            ProcIndustry procIndustry = new ProcIndustry();
            et = procIndustry.getTargets().get(index);
        }else if (type == 2){
            // if(index >= 26)index = 25;
            SmeDiscrete smeDiscrete = new SmeDiscrete();
            et = smeDiscrete.getTargets().get(index);
        }else if (type == 3){
            if(index >= 18 )index = 17;
            ServeIndustry serveIndustry = new ServeIndustry();
            et = serveIndustry.getTargets().get(index);
        }else if (type == 4){
            if(index >= 21)index = 20;
            MixIndustry mixIndustry = new MixIndustry();
            et = mixIndustry.getTargets().get(index);
        }else{
            return Double.MAX_VALUE;
        }
        return specifyByTypes(et, xi, xList);
    }

    /**
     * @function minMaxScoreForDiv方法细化
     */
    public static double specifyByTypes(Target et, double xi, List<Double> xList){

        if (et.getType() != 0 && et.getType() != 1 && et.getType() != 2) return 0;

        // 指标为满意值另外判断
        if (et.getType() == -1){
            if (xi < et.getLeft()) return 0;
            if (xi > et.getRight()) return 1;
            return (xi - et.getLeft()) / (et.getRight() - et.getLeft());
        }

        double xmin = 1000000, xmax = -1000000, revalue = 0;
        double reBelow = et.getLeft(), reAbove = et.getRight();

        if (et.getLeft() > et.getRight()) {
            reBelow = et.getRight();
            reAbove = et.getLeft();
        }

        // 奇异值返回0
        if (xi < reBelow && xi > reAbove) return 0;

        for (int i=0; i<xList.size(); i++){
            if (xList.get(i) >= xmax) xmax = xList.get(i);
            if (xList.get(i) <= xmin) xmin = xList.get(i);
        }

        try{
            if (et.getType() == 0){
                if (xi - xmin == xmax - xmin) revalue = 1;
                else revalue = (xi - xmin) / (xmax - xmin);
            }else{
                if (xmax - xi == xmax - xmin) revalue = 1;
                else revalue = (xmax - xi) / (xmax - xmin);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return revalue;
    }


    /**
     * 熵权法
     * 两化评分 : 二级指标转一级
     * @param list :二维数组
     * @param index: 起始下标
     * */
    public static List<Double> entropyWeightForDiv (List<List<Double>> list, int index, int type) {

        // 中间结果
        List<Double> afetrMMList = new ArrayList<>();
        List<List<Double>> firstList = new ArrayList<>();     // 第二步结果
        List<Double> after3List = new ArrayList<>();          // 第三步的中间结果
        List<List<Double>> pList = new ArrayList<>();         // 第三步结果
        List<Double> dList = new ArrayList<>();         // 第四步结果
        List<Double> wList = new ArrayList<>();         // 第五步结果
        List<Double> sList = new ArrayList<>();         // 第六步结果

        List<Double> tmpList = new ArrayList<>();

        for (int i=0; i<list.size(); i++){
            for (int j=0; j<list.get(i).size() ; j++){
                for (int k=0; k<list.size(); k++){
                    tmpList.add(list.get(k).get(j));
                }

                // afetrMMList.add(Calculation.minMaxScoreForDiv(list.get(i).get(j),tmpList,(index+j == limit[type])? (limit[type]-1): (index+j), type));
                afetrMMList.add(Calculation.minMaxScoreForDiv(list.get(i).get(j),tmpList,index+j, type));
                tmpList = new ArrayList<>();
            }
            firstList.add(afetrMMList);
            afetrMMList = new ArrayList<>();
        }

        for (int i=0; i<firstList.size(); i++){
            for (int j=0; j<firstList.get(i).size(); j++){
                double sum = 0;
                for (int k=0; k<firstList.size(); k++){
                    sum += firstList.get(k).get(j);
                }
                after3List.add(firstList.get(i).get(j) / sum);
            }
            pList.add(after3List);
            after3List = new ArrayList<>();
        }

        for (int j=0; j<pList.get(0).size(); j++){
            double sum = 0;
            for (int k=0; k<pList.size(); k++){
                if (pList.get(k).get(j) == 0) continue;
                else sum += pList.get(k).get(j) * Math.log(pList.get(k).get(j));
            }
            dList.add(1 + sum / Math.log(pList.size() + 1));
        }

        double s = 0;
        for (int i=0; i<dList.size(); i++){
            s += dList.get(i);
        }
        for (int i=0; i<dList.size(); i++){
            wList.add(dList.get(i) / s);
        }


        for (int i=0; i<pList.size(); i++){
            double sum = 0;
            for (int j=0; j<pList.get(i).size(); j++){
                sum += wList.get(j) * pList.get(i).get(j);
            }
            sList.add(sum);
        }

        return sList;
    }

    /**
     * 熵权法
     * 两化评分：一级转两化评分
     * */
    public static List<Double> entropyWeightForFinal (List<List<Double>> list) {
        // 中间结果
        List<Double> afetrMMList = new ArrayList<>();
        List<List<Double>> firstList = new ArrayList<>();     // 第二步结果
        List<Double> after3List = new ArrayList<>();          // 第三步的中间结果
        List<List<Double>> pList = new ArrayList<>();         // 第三步结果
        List<Double> dList = new ArrayList<>();         // 第四步结果
        List<Double> wList = new ArrayList<>();         // 第五步结果
        List<Double> sList = new ArrayList<>();         // 第六步结果

        List<Double> tmpList = new ArrayList<>();


        for (int i=0; i<list.size(); i++){
            for (int j=0; j<list.get(i).size(); j++){
                for (int k=0; k<list.size(); k++){
                    tmpList.add(list.get(k).get(j));
                }
                afetrMMList.add(Calculation.minMaxScore(list.get(i).get(j),tmpList));
                tmpList = new ArrayList<>();
            }
            firstList.add(afetrMMList);
            afetrMMList = new ArrayList<>();
        }

        for (int i=0; i<firstList.size(); i++){
            for (int j=0; j<firstList.get(i).size(); j++){
                double sum = 0;
                for (int k=0; k<firstList.size(); k++){
                    sum += firstList.get(k).get(j);
                }
                after3List.add(firstList.get(i).get(j) / sum);
            }
            pList.add(after3List);
            after3List = new ArrayList<>();
        }

        for (int j=0; j<pList.get(0).size(); j++){
            double sum = 0;
            for (int k=0; k<pList.size(); k++){
                if (pList.get(k).get(j) == 0) continue;
                else sum += pList.get(k).get(j) * Math.log(pList.get(k).get(j));
            }
            dList.add(1 + sum / (Math.log(pList.size() + 1) ));
        }

        double s = 0;
        for (int i=0; i<dList.size(); i++){
            s += dList.get(i);
        }
        for (int i=0; i<dList.size(); i++){
            wList.add(dList.get(i) / s);
        }


        for (int i=0; i<pList.size(); i++){
            double sum = 0;
            for (int j=0; j<pList.get(i).size(); j++){
                sum += wList.get(j) * pList.get(i).get(j);
            }
            sList.add(sum);
        }

        return sList;
    }
}
