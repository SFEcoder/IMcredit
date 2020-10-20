package com.example.common.calculation;

import java.util.List;

/**
 * @Author: Owen
 * @Date: 2020/10/20 23:00
 * @Description: 两化评分
 */
public class DivRank {

    public static List<Double> main(List<List<Double>> list){
        return Calculation.entropyWeight(list);
    }

}
