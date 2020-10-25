package com.example.enterprise.po.index.integrate;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:
 * @Date: 2020/10/21 10:27
 */
@Data
public class ServeIndustry {

    private Integer enterprise_id;

    private double system_manage_level;

    private double call_center;

    private double budget_management;

    private double service_Integration;

    private double online_purchase_rate;

    private double application_scope_of_purchasing_ecommerce;

    private double labor_productivity;

    private double Informatization_energy_management;

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
