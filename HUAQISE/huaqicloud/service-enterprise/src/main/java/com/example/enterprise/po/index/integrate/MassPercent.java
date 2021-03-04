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
        this.on_time_delivery_rate_p = args[0];
        this.system_manage_level_p = args[1];
        this.emergency_response_p = args[2];
        this.budget_management_p = args[3];
        this.auto_instruction_content_p = args[4];
        this.environmental_management_p = args[5];
        this.energy_management_p = args[6];
        this.social_contribution_p = args[7];
        this.business_collaboration_p = args[8];
        this.value_network_collaboration_p = args[9];
        this.tracking_and_feedback_p = args[10];
        this.maintenance_investment_p = args[11];
        this.organizational_model_p = args[12];
        this.plan_implementation_p = args[13];
        this.decision_support_p = args[14];
        this.equipment_management_p = args[15];
        this.hr_management_p = args[16];
    }

    public MassPercent(){}

    private Integer enterprise_id;

    private double on_time_delivery_rate_p;

    private double system_manage_level_p;

    private double emergency_response_p;

    private double budget_management_p;

    private double auto_instruction_content_p;

    private double environmental_management_p;

    private double energy_management_p;

    private double social_contribution_p;

    private double business_collaboration_p;

    private double value_network_collaboration_p;

    private double tracking_and_feedback_p;

    private double maintenance_investment_p;

    private double organizational_model_p;

    private double plan_implementation_p;

    private double decision_support_p;

    private double equipment_management_p;

    private double hr_management_p;

    public List<Double> getList(){
        List<Double> list = new ArrayList<>();
        list.add(this.on_time_delivery_rate_p);
        list.add(this.system_manage_level_p);
        list.add(this.emergency_response_p);
        list.add(this.budget_management_p);
        list.add(this.auto_instruction_content_p);
        list.add(this.environmental_management_p);
        list.add(this.energy_management_p);
        list.add(this.social_contribution_p);
        list.add(this.business_collaboration_p);
        list.add(this.value_network_collaboration_p);
        list.add(this.tracking_and_feedback_p);
        list.add(this.maintenance_investment_p);
        list.add(this.organizational_model_p);
        list.add(this.plan_implementation_p);
        list.add(this.decision_support_p);
        list.add(this.equipment_management_p);
        list.add(this.hr_management_p);

        return list;
    }
}
