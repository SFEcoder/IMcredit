package com.example.common.calculation;

import com.example.common.calculation.Target.DivTarget.EnterTarget;
import com.example.common.calculation.Target.DivTarget.MassDiscrete;
import com.example.common.calculation.Target.DivTarget.MixIndustry;
import com.example.common.calculation.Target.DivTarget.ProcIndustry;
import com.example.common.calculation.Target.DivTarget.ServeIndustry;
import com.example.common.calculation.Target.DivTarget.SmeDiscrete;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Owen
 * @Date: 2020/12/7 0:03
 * @Description:
 */
public class Tools {

    public List<Double> getMixScore(List<List<Double>> finanList, List<List<Double>> diverList){
        List<Double> tmpList = new ArrayList<>();
        List<List<Double>> rankList = new ArrayList<>();

        // financial ranking
        List<Double> finList =FinRank.getFinanceScore(finanList);
        List<List<Double>> financeTopTarget = FinRank.getFinanceTopTarget(finanList);

        // divergence ranking
        List<Double> divList = DivRank.getDivergenceScore(diverList,1);
        List<List<Double>> divergenceTopTarget = DivRank.getDivergenceTopTarget(diverList,1);

        // final ranking

        for (int i=0; i<finList.size(); i++){
            tmpList.add(finList.get(i));
            tmpList.add(divList.get(i));
            rankList.add(tmpList);
            tmpList = new ArrayList<>();
        }

        List<Double> finalList = Calculation.entropyWeightForFinal(rankList);
        List<Double> result = new ArrayList<>();

        for (int i=0; i<finalList.size(); i++){
            result.add(finalList.get(i)*100);
        }
        return result;
    }

    public List<Double> getFinance(List<List<Double>> list){
        return FinRank.getFinanceScore(list);
    }

    public List<Double> getDiver(List<List<Double>> list, Integer type){
        List<Double> mid = DivRank.getDivergenceScore(list, type);
        List<Double> result = new ArrayList<>();
        for (int i=0; i<mid.size(); i++){
            result.add(mid.get(i) * 100);
        }
        return result;
    }
}
