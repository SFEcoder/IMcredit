package com.example.enterprise.po.index.integrate;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:
 * @Date: 2020/10/21 10:37
 */
@Data
public class MixIndustry {

    public MixIndustry(){}

    public MixIndustry (Integer id, Double[] args){
        if (args.length != 21){
            System.out.println("Initialization failure");
            return;
        }
        this.enterprise_id = id;
        this.system_manage_level = args[0];
        this.test_data_rate = args[1];
        this.tracking_oforders = args[2];
        this.online_purchasing_rate = args[3];
        this.monitoring_coverage = args[4];
        this.auto_instruction_content = args[5];
        this.collection_of_energy_data = args[6];
        this.environmental_management = args[7];
        this.info_exchange_and_sharing = args[8];
        this.value_network_collaboration = args[9];
        this.green_development = args[10];
        this.social_contribution = args[11];
        this.information_investment = args[12];
        this.equipment_assets = args[13];
        this.organizational_model = args[14];
        this.informatization_plan_implementation = args[15];
        this.material_requirements = args[16];
        this.business_scope = args[17];
        this.equipment_management = args[18];
        this.hr_management = args[19];
        this.industrial_software_innovation = args[20];
    }

    private Integer enterprise_id;

    private double system_manage_level;

    private double test_data_rate;

    private double tracking_oforders;

    private double online_purchasing_rate;

    private double monitoring_coverage;

    private double auto_instruction_content;

    private double collection_of_energy_data;

    private double environmental_management;

    private double info_exchange_and_sharing;

    private double value_network_collaboration;

    private double green_development;

    private double social_contribution;

    private double information_investment;

    private double equipment_assets;

    private double organizational_model;

    private double informatization_plan_implementation;

    private double material_requirements;

    private double business_scope;

    private double equipment_management;

    private double hr_management;

    private double industrial_software_innovation;

    public List<Double> getList(){
        List<Double> list = new ArrayList<>();
        list.add(this.system_manage_level);
        list.add(this.test_data_rate);
        list.add(this.tracking_oforders);
        list.add(this.online_purchasing_rate);
        list.add(this.monitoring_coverage);
        list.add(this.auto_instruction_content);
        list.add(this.collection_of_energy_data);
        list.add(this.environmental_management);
        list.add(this.info_exchange_and_sharing);
        list.add(this.value_network_collaboration);
        list.add(this.green_development);
        list.add(this.social_contribution);
        list.add(this.information_investment);
        list.add(this.equipment_assets);
        list.add(this.organizational_model);
        list.add(this.informatization_plan_implementation);
        list.add(this.material_requirements);
        list.add(this.business_scope);
        list.add(this.equipment_management);
        list.add(this.hr_management);
        list.add(this.industrial_software_innovation);

        return list;
    }

}
