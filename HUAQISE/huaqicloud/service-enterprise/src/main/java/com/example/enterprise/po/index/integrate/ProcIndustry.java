package com.example.enterprise.po.index.integrate;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:
 * @Date: 2020/10/21 10:19
 */
@Data
public class ProcIndustry {

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
