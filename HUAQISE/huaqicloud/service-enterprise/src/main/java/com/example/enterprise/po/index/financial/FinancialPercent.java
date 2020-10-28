package com.example.enterprise.po.index.financial;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Owen
 * @Date: 2020/10/27 9:29
 * @Description:
 */
public class FinancialPercent {

    public FinancialPercent(){}

    public FinancialPercent(Integer id, Double[] args){
        if (args.length != 18){
            System.out.println("Initialization failure");
            return;
        }
        this.enterprise_id = id;
        this.ttm = args[0];
        this.debt_ratio = args[1];
        this.current_ratio = args[2];
        this.quick_ratio = args[3];
        this.cf_cl = args[4];
        this.ttal = args[5];
        this.operating_revenue = args[6];
        this.total_profit = args[7];
        this.total_liabilities = args[8];
        this.roe = args[9];
        this.profit_rate = args[10];
        this.gross_profit = args[11];
        this.fe_rev = args[12];
        this.turnover_days = args[13];
        this.current_assets = args[14];
        this.accounts_receivable = args[15];
        this.ebit_rev = args[16];
        this.industry_prosperity = args[17];
    }

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
