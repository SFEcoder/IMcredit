package com.example.enterprise.po.index.integrate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Owen
 * @Date: 2020/10/27 9:40
 * @Description:
 */
public class MassPercent {

    public MassPercent (Integer id, Double[] args){
        if (args.length != 17) {
            System.out.println("Initialization failure");
            return;
        }
        this.enterprise_id = id;
        this.on_time_delivery_rate = args[0];
        this.system_manage_level = args[1];
        this.emergency_response = args[2];
        this.budget_management = args[3];
        this.auto_instruction_content = args[4];
        this.environmental_management = args[5];
        this.energy_management = args[6];
        this.social_contribution = args[7];
        this.business_collaboration = args[8];
        this.value_network_collaboration = args[9];
        this.tracking_and_feedback = args[10];
        this.maintenance_investment = args[11];
        this.organizational_model = args[12];
        this.plan_implementation = args[13];
        this.decision_support = args[14];
        this.equipment_management = args[15];
        this.hr_management = args[16];
    }

    public MassPercent(){}

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
