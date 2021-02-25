package com.example.common.calculation;

import com.example.common.calculation.enumType.*;

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;



/**
 * @Author: Owen
 * @Date: 2020/10/20 15:18
 * @Description: 基础算法类
 */
public class Calculation {

    // 指标的正负向数组
    private static final finType[] finenums = {finType.A,finType.B,finType.C,finType.D,finType.E,finType.F,finType.G,finType.H,finType.I,finType.J,finType.K,finType.L,finType.M,finType.N,finType.O,finType.P,finType.Q,finType.R};
    public static final divType1[] div1 = {divType1.A,divType1.B,divType1.C,divType1.D,divType1.E,divType1.F,divType1.G,divType1.H,divType1.I,divType1.J,divType1.K,divType1.L,divType1.M,divType1.N,divType1.O,divType1.P,divType1.Q};
    public static final divType2[] div2 = {divType2.A,divType2.B,divType2.C,divType2.D,divType2.E,divType2.F,divType2.G,divType2.H,divType2.I,divType2.J,divType2.K,divType2.L,divType2.M,divType2.N,divType2.O,divType2.P,divType2.Q,divType2.R,divType2.S,divType2.T,divType2.U,divType2.V,divType2.W,divType2.X,divType2.Y};
    public static final divType3[] div3 = {divType3.A,divType3.B,divType3.C,divType3.D,divType3.E,divType3.F,divType3.G,divType3.H,divType3.I,divType3.J,divType3.K,divType3.L,divType3.M,divType3.N,divType3.O,divType3.P,divType3.Q,divType3.R,divType3.S,divType3.T,divType3.U,divType3.V,divType3.W,divType3.X,divType3.Y,divType3.Z,divType3.A1};
    public static final divType4[] div4 = {divType4.A,divType4.B,divType4.C,divType4.D,divType4.E,divType4.F,divType4.G,divType4.H,divType4.I,divType4.J,divType4.K,divType4.L,divType4.M,divType4.N,divType4.O,divType4.P,divType4.Q,divType4.R};
    public static final divType5[] div5 = {divType5.A,divType5.B,divType5.C,divType5.D,divType5.E,divType5.F,divType5.G,divType5.H,divType5.I,divType5.J,divType5.K,divType5.L,divType5.M,divType5.N,divType5.O,divType5.P,divType5.Q,divType5.R,divType5.S,divType5.T,divType5.U};

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
     * @param index 0代表正向指标；1代表负向指标
     * */
    public static double minMaxScoreForFin (double xi, List<Double> xList, int index){

        finType et = finenums[index];

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
        if (type == 0){
            divType1 et = div1[index];

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
        }else if (type == 1){
            divType2 et = div2[index];

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
        }else if (type == 2){
            divType3 et = div3[index];

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
        }else if (type == 3){
            divType4 et = div4[index];

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
        }else if (type == 4){
            divType5 et = div5[index];

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
        }else{
            System.out.println("Error type!");
            return 0;
        }
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
            for (int j=0; j<list.get(i).size(); j++){
                for (int k=0; k<list.size(); k++){
                    tmpList.add(list.get(k).get(j));
                }
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
            dList.add(1 + sum / Math.log(pList.size()));
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
            dList.add(1 + sum / Math.log(pList.size()));
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
