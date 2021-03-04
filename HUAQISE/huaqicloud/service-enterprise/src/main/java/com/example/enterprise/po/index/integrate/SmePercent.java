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
        this.system_manage_level_p = args[0];
        this.financial_system_monitor_sales_p = args[1];
        this.auto_instruction_content_p = args[2];
        this.upload_info_specification_p = args[3];
        this.info_qua_coverage_area_p = args[4];
        this.info_qua_function_p = args[5];
        this.info_monitor_outsourceing_p = args[6];
        this.info_manage_energy_p = args[7];
        this.social_contribution_rate_p = args[8];
        this.info_cooperate_business_p = args[9];
        this.inter_realize_value_network_synergy_p = args[10];
        this.online_product_ext_recontrol_p = args[11];
        this.info_inputmoney_five_p = args[12];
        this.infosys_rate_info_p = args[13];
        this.total_assets_proequ_p = args[14];
        this.enterprise_organization_model_p = args[15];
        this.info_plan_implement_p = args[16];
        this.info_matdemand_plan_management_p = args[17];
        this.info_app_design_p = args[18];
        this.info_analyze_business_scope_p = args[19];
        this.info_equ_manage_fun_level_p = args[20];
        this.info_humanres_fun_level_p = args[21];
        this.industrysoftware_innovation_ability_p = args[22];
        this.newproduct_develope_cycle_p = args[23];
        this.patent_ownership_hundred_p = args[24];
        this.productmodel_define_data_p = args[25];
    }

    private Integer enterprise_id;

    private double system_manage_level_p;

    private double financial_system_monitor_sales_p;

    private double auto_instruction_content_p;

    private double upload_info_specification_p;

    private double info_qua_coverage_area_p;

    private double info_qua_function_p;

    private double info_monitor_outsourceing_p;

    private double info_manage_energy_p;

    private double social_contribution_rate_p;

    private double info_cooperate_business_p;

    private double inter_realize_value_network_synergy_p;

    private double online_product_ext_recontrol_p;

    private double info_inputmoney_five_p;

    private double infosys_rate_info_p;

    private double total_assets_proequ_p;

    private double enterprise_organization_model_p;

    private double info_plan_implement_p;

    private double info_matdemand_plan_management_p;

    private double info_app_design_p;

    private double info_analyze_business_scope_p;

    private double info_equ_manage_fun_level_p;

    private double info_humanres_fun_level_p;

    private double industrysoftware_innovation_ability_p;

    private double newproduct_develope_cycle_p;

    private double patent_ownership_hundred_p;

    private double productmodel_define_data_p;

    public List<Double> getList(){
        List<Double> list = new ArrayList<>();
        list.add(this.system_manage_level_p);
        list.add(this.financial_system_monitor_sales_p);
        list.add(this.auto_instruction_content_p);
        list.add(this.upload_info_specification_p);
        list.add(this.info_qua_coverage_area_p);
        list.add(this.info_qua_function_p);
        list.add(this.info_monitor_outsourceing_p);
        list.add(this.info_manage_energy_p);
        list.add(this.social_contribution_rate_p);
        list.add(this.info_cooperate_business_p);
        list.add(this.inter_realize_value_network_synergy_p);
        list.add(this.online_product_ext_recontrol_p);
        list.add(this.info_inputmoney_five_p);
        list.add(this.infosys_rate_info_p);
        list.add(this.total_assets_proequ_p);
        list.add(this.enterprise_organization_model_p);
        list.add(this.info_plan_implement_p);
        list.add(this.info_matdemand_plan_management_p);
        list.add(this.info_app_design_p);
        list.add(this.info_analyze_business_scope_p);
        list.add(this.info_equ_manage_fun_level_p);
        list.add(this.info_humanres_fun_level_p);
        list.add(this.industrysoftware_innovation_ability_p);
        list.add(this.newproduct_develope_cycle_p);
        list.add(this.patent_ownership_hundred_p);
        list.add(this.productmodel_define_data_p);

        return list;
    }
}
