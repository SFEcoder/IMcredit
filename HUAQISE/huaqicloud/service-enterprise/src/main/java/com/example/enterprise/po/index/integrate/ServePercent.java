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
        this.system_manage_level = args[0];
        this.call_center = args[1];
        this.budget_management = args[2];
        this.service_Integration = args[3];
        this.online_purchase_rate = args[4];
        this.application_scope_of_purchasing_ecommerce = args[5];
        this.labor_productivity = args[6];
        this.Informatization_energy_management = args[7];
        this.Industry_chain_cooperation = args[8];
        this.Information_exchange_and_sharing = args[9];
        this.maintenance_investment_proportion = args[10];
        this.enterprise_level_unified_coding = args[11];
        this.enterprise_organization_mode = args[12];
        this.informatization_plan_implementation = args[13];
        this.informatization_decision_support = args[14];
        this.informatization_equipment_management = args[15];
        this.informatization_human_resource_management = args[16];
        this.cloud_platform_usage = args[17];
    }

    private Integer enterprise_id;

    private double system_manage_level;

    private double call_center;

    private double budget_management;

    private double service_Integration;

    private double online_purchase_rate;

    private double application_scope_of_purchasing_ecommerce;

    private double labor_productivity;

    private double Informatization_energy_management;

    private double Industry_chain_cooperation;

    private double Information_exchange_and_sharing;

    private double maintenance_investment_proportion;

    private double enterprise_level_unified_coding;

    private double enterprise_organization_mode;

    private double informatization_plan_implementation;

    private double informatization_decision_support;

    private double informatization_equipment_management;

    private double informatization_human_resource_management;

    private double cloud_platform_usage;

    public List<Double> getList(){
        List<Double> list = new ArrayList<>();
        list.add(this.system_manage_level);
        list.add(this.call_center);
        list.add(this.budget_management);
        list.add(this.service_Integration);
        list.add(this.online_purchase_rate);
        list.add(this.application_scope_of_purchasing_ecommerce);
        list.add(this.labor_productivity);
        list.add(this.Informatization_energy_management);
        list.add(this.Industry_chain_cooperation);
        list.add(this.Information_exchange_and_sharing);
        list.add(this.maintenance_investment_proportion);
        list.add(this.enterprise_level_unified_coding);
        list.add(this.enterprise_organization_mode);
        list.add(this.informatization_plan_implementation);
        list.add(this.informatization_decision_support);
        list.add(this.informatization_equipment_management);
        list.add(this.informatization_human_resource_management);
        list.add(this.cloud_platform_usage);

        return list;
    }
}
