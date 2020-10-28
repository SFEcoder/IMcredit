package com.example.enterprise.po.index.integrate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Owen
 * @Date: 2020/10/27 10:11
 * @Description:
 */
public class SmePercent {

    public SmePercent(){}

    public SmePercent (Integer id, Double[] args){
        if (args.length != 26){
            System.out.println("Initialization failure");
            return ;
        }
        this.enterprise_id = id;
        this.system_manage_level = args[0];
        this.financial_system_monitor_sales = args[1];
        this.auto_instruction_content = args[2];
        this.upload_info_specification = args[3];
        this.info_qua_coverage_area = args[4];
        this.info_qua_function = args[5];
        this.info_monitor_outsourceing = args[6];
        this.info_manage_energy = args[7];
        this.social_contribution_rate = args[8];
        this.info_cooperate_business = args[9];
        this.inter_realize_value_network_synergy = args[10];
        this.online_product_ext_recontrol = args[11];
        this.info_inputmoney_five = args[12];
        this.infosys_rate_info = args[13];
        this.total_assets_proequ = args[14];
        this.enterprise_organization_model = args[15];
        this.info_plan_implement = args[16];
        this.info_matdemand_plan_management = args[17];
        this.info_app_design = args[18];
        this.info_analyze_business_scope = args[19];
        this.info_equ_manage_fun_level = args[20];
        this.info_humanres_fun_level = args[21];
        this.industrysoftware_innovation_ability = args[22];
        this.newproduct_develope_cycle = args[23];
        this.patent_ownership_hundred = args[24];
        this.productmodel_define_data = args[25];
    }

    private Integer enterprise_id;

    private double system_manage_level;

    private double financial_system_monitor_sales;

    private double auto_instruction_content;

    private double upload_info_specification;

    private double info_qua_coverage_area;

    private double info_qua_function;

    private double info_monitor_outsourceing;

    private double info_manage_energy;

    private double social_contribution_rate;

    private double info_cooperate_business;

    private double inter_realize_value_network_synergy;

    private double online_product_ext_recontrol;

    private double info_inputmoney_five;

    private double infosys_rate_info;

    private double total_assets_proequ;

    private double enterprise_organization_model;

    private double info_plan_implement;

    private double info_matdemand_plan_management;

    private double info_app_design;

    private double info_analyze_business_scope;

    private double info_equ_manage_fun_level;

    private double info_humanres_fun_level;

    private double industrysoftware_innovation_ability;

    private double newproduct_develope_cycle;

    private double patent_ownership_hundred;

    private double productmodel_define_data;

    public List<Double> getList(){
        List<Double> list = new ArrayList<>();
        list.add(this.system_manage_level);
        list.add(this.financial_system_monitor_sales);
        list.add(this.auto_instruction_content);
        list.add(this.upload_info_specification);
        list.add(this.info_qua_coverage_area);
        list.add(this.info_qua_function);
        list.add(this.info_monitor_outsourceing);
        list.add(this.info_manage_energy);
        list.add(this.social_contribution_rate);
        list.add(this.info_cooperate_business);
        list.add(this.inter_realize_value_network_synergy);
        list.add(this.online_product_ext_recontrol);
        list.add(this.info_inputmoney_five);
        list.add(this.infosys_rate_info);
        list.add(this.total_assets_proequ);
        list.add(this.enterprise_organization_model);
        list.add(this.info_plan_implement);
        list.add(this.info_matdemand_plan_management);
        list.add(this.info_app_design);
        list.add(this.info_analyze_business_scope);
        list.add(this.info_equ_manage_fun_level);
        list.add(this.info_humanres_fun_level);
        list.add(this.industrysoftware_innovation_ability);
        list.add(this.newproduct_develope_cycle);
        list.add(this.patent_ownership_hundred);
        list.add(this.productmodel_define_data);

        return list;
    }
}
