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
        this.system_manage_level_p = args[0];
        this.budget_management_p = args[1];
        this.auto_upload_info_range_p = args[2];
        this.auto_instruction_content_p = args[3];
        this.auto_information_coverage_p = args[4];
        this.auto_instruction_situation_p = args[5];
        this.integrated_management_cover_p = args[6];
        this.online_purchasing_rate_p = args[7];
        this.min_scheduling_unit_p = args[8];
        this.energy_management_p = args[9];
        this.social_contribution_p = args[10];
        this.business_collaboration_p = args[11];
        this.info_exchange_and_sharing_p = args[12];
        this.value_network_collaboration_p = args[13];
        this.green_development_p = args[14];
        this.maintenance_investment_p = args[15];
        this.organizational_model_p = args[16];
        this.plan_implementation_p = args[17];
        this.material_requirements_p = args[18];
        this.research_development_p = args[19];
        this.business_scope_p = args[20];
        this.equipment_management_p = args[21];
        this.hr_management_p = args[22];
        this.industrial_software_innovation_p = args[23];
        this.output_value_p = args[24];
    }

    private Integer enterprise_id;

    private double system_manage_level_p;

    private double budget_management_p;

    private double auto_upload_info_range_p;

    private double auto_instruction_content_p;

    private double auto_information_coverage_p;

    private double auto_instruction_situation_p;

    private double integrated_management_cover_p;

    private double online_purchasing_rate_p;

    private double min_scheduling_unit_p;

    private double energy_management_p;

    private double social_contribution_p;

    private double business_collaboration_p;

    private double info_exchange_and_sharing_p;

    private double value_network_collaboration_p;

    private double green_development_p;

    private double maintenance_investment_p;

    private double organizational_model_p;

    private double plan_implementation_p;

    private double material_requirements_p;

    private double research_development_p;

    private double business_scope_p;

    private double equipment_management_p;

    private double hr_management_p;

    private double industrial_software_innovation_p;

    private double output_value_p;

    public List<Double> getList(){
        List<Double> list = new ArrayList<>();
        list.add(this.system_manage_level_p);
        list.add(this.budget_management_p);
        list.add(this.auto_upload_info_range_p);
        list.add(this.auto_instruction_content_p);
        list.add(this.auto_information_coverage_p);
        list.add(this.auto_instruction_situation_p);
        list.add(this.integrated_management_cover_p);
        list.add(this.online_purchasing_rate_p);
        list.add(this.min_scheduling_unit_p);
        list.add(this.energy_management_p);
        list.add(this.social_contribution_p);
        list.add(this.business_collaboration_p);
        list.add(this.info_exchange_and_sharing_p);
        list.add(this.value_network_collaboration_p);
        list.add(this.green_development_p);
        list.add(this.maintenance_investment_p);
        list.add(this.organizational_model_p);
        list.add(this.plan_implementation_p);
        list.add(this.material_requirements_p);
        list.add(this.research_development_p);
        list.add(this.business_scope_p);
        list.add(this.equipment_management_p);
        list.add(this.hr_management_p);
        list.add(this.industrial_software_innovation_p);
        list.add(this.output_value_p);

        return list;
    }
}
