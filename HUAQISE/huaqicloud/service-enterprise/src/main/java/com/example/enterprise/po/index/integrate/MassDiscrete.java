package com.example.enterprise.po.index.integrate;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:
 * @Date: 2020/10/21 10:15
 */
@Data
public class MassDiscrete {

    private Integer enterprise_id;

    private double on_time_delivery_rate;

    private double system_manage_level;

    private double emergency_response;

    private double budget_management;

    private double auto_instruction_content;

    private double environmental_management;

    private double energy_management;

    private double social_contribution;

    private double business_collaboration;

    private double value_network_collaboration;

    private double tracking_and_feedback;

    private double maintenance_investment;

    private double organizational_model;

    private double plan_implementation;

    private double decision_support;

    private double equipment_management;

    private double hr_management;

    public List<Double> getList(){
        List<Double> list = new ArrayList<>();
        list.add(this.on_time_delivery_rate);
        list.add(this.system_manage_level);
        list.add(this.emergency_response);
        list.add(this.budget_management);
        list.add(this.auto_instruction_content);
        list.add(this.environmental_management);
        list.add(this.energy_management);
        list.add(this.social_contribution);
        list.add(this.business_collaboration);
        list.add(this.value_network_collaboration);
        list.add(this.tracking_and_feedback);
        list.add(this.maintenance_investment);
        list.add(this.organizational_model);
        list.add(this.plan_implementation);
        list.add(this.decision_support);
        list.add(this.equipment_management);
        list.add(this.hr_management);

        return list;
    }

}
