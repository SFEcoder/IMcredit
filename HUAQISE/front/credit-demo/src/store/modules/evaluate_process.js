import router from '@/router'

const getDefaultState = () => {
    return {
        current_process_step: 0,
        enterprise_evaluate_type : -1,
        integration_indicators :{
            on_time_delivery_rate: 0,
            system_manage_level : 0,
            emergency_response: 0,
            budget_management : 0,
            auto_instruction_content : 0,
            environmental_management : 0,
            energy_management : 0,
            social_contribution : 0,
            business_collaboration : 0,
            value_network_collaboration : 0,
            tracking_and_feedback : 0,
            maintenance_investment: 0,
            organizational_model : 0,
            plan_implementation : 0,
            decision_support : 0,
            equipment_management : 0,
            hr_management : 0,
            auto_upload_info_range : 0,
            auto_information_coverage: 0,
            integrated_management_cover : 0,
            online_purchasing_rate : 0,
            min_scheduling_unit: 0,
            auto_instruction_situation: 0,
            info_exchange_and_sharing : 0,
            green_development : 0,
            material_requirements : 0,
            research_development : 0,
            business_scope : 0,
            industrial_software_innovation : 0,
            output_value : 0,
            financialsystem_monitor_sales : 0,
            newproduct_develope_cycle : 0,
            patent_ownership_hundred:0,
            upload_info_specification : 0,
            info_qua_coverage_area : 0,
            info_qua_function : 0,
            info_monitor_outsourceing : 0,
            productmodel_define_data : 0,
            info_manage_energy : 0,
            info_cooperate_business : 0,
            info_intershare_business : 0,
            inter_realize_value_network_synergy : 0,
            online_product_ext_recontrol : 0,
            info_inputmoney_five : 0,
            infosys_rate_info : 0,
            total_assets_proequ : 0,
            call_center: 0,
            service_Integration : 0,
            application_scope_of_purchasing_ecommerce : 0,
            labor_productivity : 0,
            enterprise_level_unified_coding : 0,
            cloud_platform_usage : 0,
            test_data_rate : 0,
            tracking_oforders : 0,
            monitoring_coverage : 0,
            collection_of_energy_data  : 0




        },
        financial_index: {
            ttm : 0,
            debt_ratio : 0,
            current_ratio : 0,
            quick_ratio : 0,
            cf_cl : 0,
            ttal : 0,
            operating_revenue : 0,
            total_profit : 0,
            total_liabilities : 0,
            roe : 0,
            profit_rate : 0,
            gross_profit : 0,
            fe_rev : 0,
            turnover_days : 0,
            current_assets : 0,
            accounts_receivable : 0,
            ebit_rev : 0,
            industry_prosperity : 0
        },
    }
}


const evaluate_process = {
    state: getDefaultState(),

    mutations: {
        set_current_process_step: function (state, step) {
            state.current_process_step = step
        },
        set_enterprise_evaluate_type: function (state, type) {
            state.enterprise_evaluate_type = type
        },
        set_integration_indicators : function (state, new_integration_indicators) {
            state.integration_indicators = {...new_integration_indicators}
            console.log('nbsszrx', state.integration_indicators)
        },
        set_financial_index : function(state, new_financial_index){
            state.financial_index = {...new_financial_index}
        }
    },

    actions: {}
}


export default evaluate_process
