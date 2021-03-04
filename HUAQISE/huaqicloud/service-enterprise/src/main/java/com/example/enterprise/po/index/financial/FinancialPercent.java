package com.example.enterprise.po.index.financial;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Owen
 * @Date: 2020/10/27 9:29
 * @Description:
 */
@Data
public class FinancialPercent {

    public FinancialPercent(){}

    public FinancialPercent(Integer id, Double[] args){
        if (args.length != 18){
            System.out.println("Initialization failure");
            return;
        }
        this.enterprise_id = id;
        this.ttm_p = args[0];
        this.debt_ratio_p = args[1];
        this.current_ratio_p = args[2];
        this.quick_ratio_p = args[3];
        this.cf_cl_p = args[4];
        this.ttal_p = args[5];
        this.operating_revenue_p = args[6];
        this.total_profit_p = args[7];
        this.total_liabilities_p = args[8];
        this.roe_p = args[9];
        this.profit_rate_p = args[10];
        this.gross_profit_p = args[11];
        this.fe_rev_p = args[12];
        this.turnover_days_p = args[13];
        this.current_assets_p = args[14];
        this.accounts_receivable_p = args[15];
        this.ebit_rev_p = args[16];
        this.industry_prosperity_p = args[17];
    }

    private Integer enterprise_id;

    private double ttm_p;

    private double debt_ratio_p;

    private double current_ratio_p;

    private double quick_ratio_p;

    private double cf_cl_p;

    private double ttal_p;

    private double operating_revenue_p;

    private double total_profit_p;

    private double total_liabilities_p;

    private double roe_p;

    private double profit_rate_p;

    private double gross_profit_p;

    private double fe_rev_p;

    private double turnover_days_p;

    private double current_assets_p;

    private double accounts_receivable_p;

    private double ebit_rev_p;

    private double industry_prosperity_p;

    public List<Double> getList(){
        List<Double> list = new ArrayList<>();
        list.add(this.ttm_p);
        list.add(this.debt_ratio_p);
        list.add(this.current_ratio_p);
        list.add(this.quick_ratio_p);
        list.add(this.cf_cl_p);
        list.add(this.ttal_p);
        list.add(this.operating_revenue_p);
        list.add(this.total_profit_p);
        list.add(this.total_liabilities_p);
        list.add(this.roe_p);
        list.add(this.profit_rate_p);
        list.add(this.gross_profit_p);
        list.add(this.fe_rev_p);
        list.add(this.turnover_days_p);
        list.add(this.current_assets_p);
        list.add(this.accounts_receivable_p);
        list.add(this.ebit_rev_p);
        list.add(this.industry_prosperity_p);

        return list;
    }
}
