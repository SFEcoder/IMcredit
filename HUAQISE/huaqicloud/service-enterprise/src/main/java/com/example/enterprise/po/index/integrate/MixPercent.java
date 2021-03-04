package com.example.enterprise.po.index.integrate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Owen
 * @Date: 2020/10/27 9:59
 * @Description:
 */
public class MixPercent {

    public MixPercent(){}

    public MixPercent (Integer id, Double[] args){
        if (args.length != 21){
            System.out.println("Initialization failure");
            return;
        }
        this.enterprise_id = id;
        this.system_manage_level_p = args[0];
        this.test_data_rate_p = args[1];
        this.tracking_oforders_p = args[2];
        this.online_purchasing_rate_p = args[3];
        this.monitoring_coverage_p = args[4];
        this.auto_instruction_content_p = args[5];
        this.collection_of_energy_data_p = args[6];
        this.environmental_management_p = args[7];
        this.info_exchange_and_sharing_p = args[8];
        this.value_network_collaboration_p = args[9];
        this.green_development_p = args[10];
        this.social_contribution_p = args[11];
        this.information_investment_p = args[12];
        this.equipment_assets_p = args[13];
        this.organizational_model_p = args[14];
        this.informatization_plan_implementation_p = args[15];
        this.material_requirements_p = args[16];
        this.business_scope_p = args[17];
        this.equipment_management_p = args[18];
        this.hr_management_p = args[19];
        this.industrial_software_innovation_p = args[20];
    }

    private Integer enterprise_id;

    private double system_manage_level_p;

    private double test_data_rate_p;

    private double tracking_oforders_p;

    private double online_purchasing_rate_p;

    private double monitoring_coverage_p;

    private double auto_instruction_content_p;

    private double collection_of_energy_data_p;

    private double environmental_management_p;

    private double info_exchange_and_sharing_p;

    private double value_network_collaboration_p;

    private double green_development_p;

    private double social_contribution_p;

    private double information_investment_p;

    private double equipment_assets_p;

    private double organizational_model_p;

    private double informatization_plan_implementation_p;

    private double material_requirements_p;

    private double business_scope_p;

    private double equipment_management_p;

    private double hr_management_p;

    private double industrial_software_innovation_p;

    public List<Double> getList(){
        List<Double> list = new ArrayList<>();
        list.add(this.system_manage_level_p);
        list.add(this.test_data_rate_p);
        list.add(this.tracking_oforders_p);
        list.add(this.online_purchasing_rate_p);
        list.add(this.monitoring_coverage_p);
        list.add(this.auto_instruction_content_p);
        list.add(this.collection_of_energy_data_p);
        list.add(this.environmental_management_p);
        list.add(this.info_exchange_and_sharing_p);
        list.add(this.value_network_collaboration_p);
        list.add(this.green_development_p);
        list.add(this.social_contribution_p);
        list.add(this.information_investment_p);
        list.add(this.equipment_assets_p);
        list.add(this.organizational_model_p);
        list.add(this.informatization_plan_implementation_p);
        list.add(this.material_requirements_p);
        list.add(this.business_scope_p);
        list.add(this.equipment_management_p);
        list.add(this.hr_management_p);
        list.add(this.industrial_software_innovation_p);

        return list;
    }
}
