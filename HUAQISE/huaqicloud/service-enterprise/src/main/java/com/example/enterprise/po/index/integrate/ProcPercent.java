package com.example.enterprise.po.index.integrate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Owen
 * @Date: 2020/10/27 10:11
 * @Description:
 */
public class ProcPercent {

    public ProcPercent(){}

    public ProcPercent (Integer id, Double[] args){
        if (args.length != 25){
            System.out.println("Initialization failure");
            return ;
        }
        this.enterprise_id = id;
        this.system_manage_level = args[0];
        this.budget_management = args[1];
        this.auto_upload_info_range = args[2];
        this.auto_instruction_content = args[3];
        this.auto_information_coverage = args[4];
        this.auto_instruction_situation = args[5];
        this.integrated_management_cover = args[6];
        this.online_purchasing_rate = args[7];
        this.min_scheduling_unit = args[8];
        this.energy_management = args[9];
        this.social_contribution = args[10];
        this.business_collaboration = args[11];
        this.info_exchange_and_sharing = args[12];
        this.value_network_collaboration = args[13];
        this.green_development = args[14];
        this.maintenance_investment = args[15];
        this.organizational_model = args[16];
        this.plan_implementation = args[17];
        this.material_requirements = args[18];
        this.research_development = args[19];
        this.business_scope = args[20];
        this.equipment_management = args[21];
        this.hr_management = args[22];
        this.industrial_software_innovation = args[23];
        this.output_value = args[24];
    }

    private Integer enterprise_id;

    private double system_manage_level;

    private double budget_management;

    private double auto_upload_info_range;

    private double auto_instruction_content;

    private double auto_information_coverage;

    private double auto_instruction_situation;

    private double integrated_management_cover;

    private double online_purchasing_rate;

    private double min_scheduling_unit;

    private double energy_management;

    private double social_contribution;

    private double business_collaboration;

    private double info_exchange_and_sharing;

    private double value_network_collaboration;

    private double green_development;

    private double maintenance_investment;

    private double organizational_model;

    private double plan_implementation;

    private double material_requirements;

    private double research_development;

    private double business_scope;

    private double equipment_management;

    private double hr_management;

    private double industrial_software_innovation;

    private double output_value;

    public List<Double> getList(){
        List<Double> list = new ArrayList<>();
        list.add(this.system_manage_level);
        list.add(this.budget_management);
        list.add(this.auto_upload_info_range);
        list.add(this.auto_instruction_content);
        list.add(this.auto_information_coverage);
        list.add(this.auto_instruction_situation);
        list.add(this.integrated_management_cover);
        list.add(this.online_purchasing_rate);
        list.add(this.min_scheduling_unit);
        list.add(this.energy_management);
        list.add(this.social_contribution);
        list.add(this.business_collaboration);
        list.add(this.info_exchange_and_sharing);
        list.add(this.value_network_collaboration);
        list.add(this.green_development);
        list.add(this.maintenance_investment);
        list.add(this.organizational_model);
        list.add(this.plan_implementation);
        list.add(this.material_requirements);
        list.add(this.research_development);
        list.add(this.business_scope);
        list.add(this.equipment_management);
        list.add(this.hr_management);
        list.add(this.industrial_software_innovation);
        list.add(this.output_value);

        return list;
    }
}
