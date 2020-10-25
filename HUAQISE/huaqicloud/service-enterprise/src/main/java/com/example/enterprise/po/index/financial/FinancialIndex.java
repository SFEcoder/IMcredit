package com.example.enterprise.po.index.financial;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:
 * @Date: 2020/10/21 10:10
 */
@Data
public class FinancialIndex {

    private Integer enterprise_id;

    private double ttm;

    private double debt_ratio;

    private double current_ratio;

    private double quick_ratio;

    private double cf_cl;

    private double ttal;

    private double operating_revenue;

    private double total_profit;

    private double total_liabilities;

    private double roe;

    private double profit_rate;

    private double gross_profit;

    private double fe_rev;

    private double turnover_days;

    private double current_assets;

    private double accounts_receivable;

    private double ebit_rev;

    private double industry_prosperity;

    public List<Double> getList(){
        List<Double> list = new ArrayList<>();
        list.add(this.ttm);
        list.add(this.debt_ratio);
        list.add(this.current_ratio);
        list.add(this.quick_ratio);
        list.add(this.cf_cl);
        list.add(this.ttal);
        list.add(this.operating_revenue);
        list.add(this.total_profit);
        list.add(this.total_liabilities);
        list.add(this.roe);
        list.add(this.profit_rate);
        list.add(this.gross_profit);
        list.add(this.fe_rev);
        list.add(this.turnover_days);
        list.add(this.current_assets);
        list.add(this.accounts_receivable);
        list.add(this.ebit_rev);
        list.add(this.industry_prosperity);

        return list;
    }

}
