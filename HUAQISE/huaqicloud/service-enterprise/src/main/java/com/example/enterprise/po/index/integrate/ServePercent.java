package com.example.enterprise.po.index.integrate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Owen
 * @Date: 2020/10/27 10:11
 * @Description:
 */
public class ServePercent {

    public ServePercent(){}

    public ServePercent (Integer id, Double[] args){
        if (args.length != 18){
            System.out.println("Initialization failure");
            return;
        }
        this.enterprise_id = id;
        this.system_manage_level_p = args[0];
        this.call_center_p = args[1];
        this.budget_management_p = args[2];
        this.service_Integration_p = args[3];
        this.online_purchase_rate_p = args[4];
        this.application_scope_of_purchasing_ecommerce_p = args[5];
        this.labor_productivity_p = args[6];
        this.Informatization_energy_management_p = args[7];
        this.Industry_chain_cooperation_p = args[8];
        this.Information_exchange_and_sharing_p = args[9];
        this.maintenance_investment_proportion_p = args[10];
        this.enterprise_level_unified_coding_p = args[11];
        this.enterprise_organization_mode_p = args[12];
        this.informatization_plan_implementation_p = args[13];
        this.informatization_decision_support_p = args[14];
        this.informatization_equipment_management_p = args[15];
        this.informatization_human_resource_management_p = args[16];
        this.cloud_platform_usage_p = args[17];
    }

    private Integer enterprise_id;

    private double system_manage_level_p;

    private double call_center_p;

    private double budget_management_p;

    private double service_Integration_p;

    private double online_purchase_rate_p;

    private double application_scope_of_purchasing_ecommerce_p;

    private double labor_productivity_p;

    private double Informatization_energy_management_p;

    private double Industry_chain_cooperation_p;

    private double Information_exchange_and_sharing_p;

    private double maintenance_investment_proportion_p;

    private double enterprise_level_unified_coding_p;

    private double enterprise_organization_mode_p;

    private double informatization_plan_implementation_p;

    private double informatization_decision_support_p;

    private double informatization_equipment_management_p;

    private double informatization_human_resource_management_p;

    private double cloud_platform_usage_p;

    public List<Double> getList(){
        List<Double> list = new ArrayList<>();
        list.add(this.system_manage_level_p);
        list.add(this.call_center_p);
        list.add(this.budget_management_p);
        list.add(this.service_Integration_p);
        list.add(this.online_purchase_rate_p);
        list.add(this.application_scope_of_purchasing_ecommerce_p);
        list.add(this.labor_productivity_p);
        list.add(this.Informatization_energy_management_p);
        list.add(this.Industry_chain_cooperation_p);
        list.add(this.Information_exchange_and_sharing_p);
        list.add(this.maintenance_investment_proportion_p);
        list.add(this.enterprise_level_unified_coding_p);
        list.add(this.enterprise_organization_mode_p);
        list.add(this.informatization_plan_implementation_p);
        list.add(this.informatization_decision_support_p);
        list.add(this.informatization_equipment_management_p);
        list.add(this.informatization_human_resource_management_p);
        list.add(this.cloud_platform_usage_p);

        return list;
    }
}
