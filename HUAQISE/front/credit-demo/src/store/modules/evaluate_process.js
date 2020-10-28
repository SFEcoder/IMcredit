import router from '@/router'
import {message} from "ant-design-vue";
import {
    upload_indexAPI,
    get_enterprise_reportAPI
}from '@/api/evaluate'
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
        report_list:[]
    }
}
import user from "@/store/modules/user";

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
        },
        set_financial_index : function(state, new_financial_index){
            state.financial_index = {...new_financial_index}
        },
        set_report_list : function (state, report_list) {
            state.report_list = report_list
        }
    },

    actions: {
        upload_evaluate_index: async ({state , commit}) => {
            let integration_indicators_to_upload = []
            let financial_index_to_upload = []
            if (state.enterprise_evaluate_type === 1) {
            //    离散大批量
                integration_indicators_to_upload.push(state.integration_indicators.on_time_delivery_rate)
                integration_indicators_to_upload.push(state.integration_indicators.system_manage_level)
                integration_indicators_to_upload.push(state.integration_indicators.emergency_response)
                integration_indicators_to_upload.push(state.integration_indicators.budget_management)
                integration_indicators_to_upload.push(state.integration_indicators.auto_instruction_content)
                integration_indicators_to_upload.push(state.integration_indicators.environmental_management)
                integration_indicators_to_upload.push(state.integration_indicators.energy_management)
                integration_indicators_to_upload.push(state.integration_indicators.social_contribution)
                integration_indicators_to_upload.push(state.integration_indicators.business_collaboration)
                integration_indicators_to_upload.push(state.integration_indicators.value_network_collaboration)
                integration_indicators_to_upload.push(state.integration_indicators.tracking_and_feedback)
                integration_indicators_to_upload.push(state.integration_indicators.maintenance_investment)
                integration_indicators_to_upload.push(state.integration_indicators.organizational_model)
                integration_indicators_to_upload.push(state.integration_indicators.plan_implementation)
                integration_indicators_to_upload.push(state.integration_indicators.decision_support)
                integration_indicators_to_upload.push(state.integration_indicators.equipment_management)
                integration_indicators_to_upload.push(state.integration_indicators.hr_management)
            }
            else if (state.enterprise_evaluate_type === 2){
            //    流程行业指标
                integration_indicators_to_upload.push(state.integration_indicators.system_manage_level)
                integration_indicators_to_upload.push(state.integration_indicators.budget_management)
                integration_indicators_to_upload.push(state.integration_indicators.auto_upload_info_range)
                integration_indicators_to_upload.push(state.integration_indicators.auto_instruction_content)
                integration_indicators_to_upload.push(state.integration_indicators.auto_information_coverage)
                integration_indicators_to_upload.push(state.integration_indicators.auto_instruction_situation)
                integration_indicators_to_upload.push(state.integration_indicators.integrated_management_cover)
                integration_indicators_to_upload.push(state.integration_indicators.online_purchasing_rate)
                integration_indicators_to_upload.push(state.integration_indicators.min_scheduling_unit)
                integration_indicators_to_upload.push(state.integration_indicators.energy_management)
                integration_indicators_to_upload.push(state.integration_indicators.social_contribution)
                integration_indicators_to_upload.push(state.integration_indicators.business_collaboration)
                integration_indicators_to_upload.push(state.integration_indicators.info_exchange_and_sharing)
                integration_indicators_to_upload.push(state.integration_indicators.value_network_collaboration)
                integration_indicators_to_upload.push(state.integration_indicators.green_development)
                integration_indicators_to_upload.push(state.integration_indicators.maintenance_investment)
                integration_indicators_to_upload.push(state.integration_indicators.organizational_model)
                integration_indicators_to_upload.push(state.integration_indicators.plan_implementation)
                integration_indicators_to_upload.push(state.integration_indicators.material_requirements)
                integration_indicators_to_upload.push(state.integration_indicators.research_development)
                integration_indicators_to_upload.push(state.integration_indicators.business_scope)
                integration_indicators_to_upload.push(state.integration_indicators.equipment_management)
                integration_indicators_to_upload.push(state.integration_indicators.hr_management)
                integration_indicators_to_upload.push(state.integration_indicators.industrial_software_innovation)
                integration_indicators_to_upload.push(state.integration_indicators.output_value)
            }
            else if (state.enterprise_evaluate_type === 3){
            //    离散中小批量
                integration_indicators_to_upload.push(state.integration_indicators.system_manage_level)
                integration_indicators_to_upload.push(state.integration_indicators.financialsystem_monitor_sales)
                integration_indicators_to_upload.push(state.integration_indicators.auto_instruction_content)
                integration_indicators_to_upload.push(state.integration_indicators.upload_info_specification)
                integration_indicators_to_upload.push(state.integration_indicators.info_qua_coverage_area)
                integration_indicators_to_upload.push(state.integration_indicators.info_qua_function)
                integration_indicators_to_upload.push(state.integration_indicators.info_monitor_outsourceing)
                integration_indicators_to_upload.push(state.integration_indicators.info_manage_energy)
                integration_indicators_to_upload.push(state.integration_indicators.social_contribution_rate)
                integration_indicators_to_upload.push(state.integration_indicators.info_cooperate_business)
                integration_indicators_to_upload.push(state.integration_indicators.info_intershare_business)
                integration_indicators_to_upload.push(state.integration_indicators.inter_realize_value_network_synergy)
                integration_indicators_to_upload.push(state.integration_indicators.online_product_ext_recontrol)
                integration_indicators_to_upload.push(state.integration_indicators.info_inputmoney_five)
                integration_indicators_to_upload.push(state.integration_indicators.infosys_rate_info)
                integration_indicators_to_upload.push(state.integration_indicators.total_assets_proequ)
                integration_indicators_to_upload.push(state.integration_indicators.organizational_model)
                integration_indicators_to_upload.push(state.integration_indicators.info_plan_implement)
                integration_indicators_to_upload.push(state.integration_indicators.material_requirements)
                integration_indicators_to_upload.push(state.integration_indicators.research_development)
                integration_indicators_to_upload.push(state.integration_indicators.info_analyze_business_scope)
                integration_indicators_to_upload.push(state.integration_indicators.equipment_management)
                integration_indicators_to_upload.push(state.integration_indicators.hr_management)
                integration_indicators_to_upload.push(state.integration_indicators.industrial_software_innovation)
                integration_indicators_to_upload.push(state.integration_indicators.newproduct_develope_cycle)
                integration_indicators_to_upload.push(state.integration_indicators.patent_ownership_hundred)
                integration_indicators_to_upload.push(state.integration_indicators.productmodel_define_data)
            }
            else if (state.enterprise_evaluate_type === 4){
                integration_indicators_to_upload.push(state.integration_indicators.system_manage_level)
                integration_indicators_to_upload.push(state.integration_indicators.call_center)
                integration_indicators_to_upload.push(state.integration_indicators.budget_management)
                integration_indicators_to_upload.push(state.integration_indicators.service_Integration)
                integration_indicators_to_upload.push(state.integration_indicators.online_purchasing_rate)
                integration_indicators_to_upload.push(state.integration_indicators.application_scope_of_purchasing_ecommerce)
                integration_indicators_to_upload.push(state.integration_indicators.labor_productivity)
                integration_indicators_to_upload.push(state.integration_indicators.energy_management)
                integration_indicators_to_upload.push(state.integration_indicators.business_collaboration)
                integration_indicators_to_upload.push(state.integration_indicators.info_exchange_and_sharing)
                integration_indicators_to_upload.push(state.integration_indicators.maintenance_investment)
                integration_indicators_to_upload.push(state.integration_indicators.enterprise_level_unified_coding)
                integration_indicators_to_upload.push(state.integration_indicators.organizational_model)
                integration_indicators_to_upload.push(state.integration_indicators.plan_implementation)
                integration_indicators_to_upload.push(state.integration_indicators.decision_support)
                integration_indicators_to_upload.push(state.integration_indicators.equipment_management)
                integration_indicators_to_upload.push(state.integration_indicators.hr_management)
                integration_indicators_to_upload.push(state.integration_indicators.cloud_platform_usage)
            }
            else{
                integration_indicators_to_upload.push(state.integration_indicators.system_manage_level)
                integration_indicators_to_upload.push(state.integration_indicators.test_data_rate)
                integration_indicators_to_upload.push(state.integration_indicators.tracking_oforders)
                integration_indicators_to_upload.push(state.integration_indicators.online_purchasing_rate)
                integration_indicators_to_upload.push(state.integration_indicators.monitoring_coverage)
                integration_indicators_to_upload.push(state.integration_indicators.auto_instruction_content)
                integration_indicators_to_upload.push(state.integration_indicators.collection_of_energy_data)
                integration_indicators_to_upload.push(state.integration_indicators.environmental_management)
                integration_indicators_to_upload.push(state.integration_indicators.info_exchange_and_sharing)
                integration_indicators_to_upload.push(state.integration_indicators.value_network_collaboration)
                integration_indicators_to_upload.push(state.integration_indicators.green_development)
                integration_indicators_to_upload.push(state.integration_indicators.social_contribution)
                integration_indicators_to_upload.push(state.integration_indicators.info_inputmoney_five)
                integration_indicators_to_upload.push(state.integration_indicators.total_assets_proequ)
                integration_indicators_to_upload.push(state.integration_indicators.organizational_model)
                integration_indicators_to_upload.push(state.integration_indicators.plan_implementation)
                integration_indicators_to_upload.push(state.integration_indicators.material_requirements)
                integration_indicators_to_upload.push(state.integration_indicators.business_scope)
                integration_indicators_to_upload.push(state.integration_indicators.equipment_management)
                integration_indicators_to_upload.push(state.integration_indicators.hr_management)
                integration_indicators_to_upload.push(state.integration_indicators.industrial_software_innovation)
            }

        //    财务指标
            financial_index_to_upload.push(state.financial_index.ttm)
            financial_index_to_upload.push(state.financial_index.debt_ratio)
            financial_index_to_upload.push(state.financial_index.current_ratio)
            financial_index_to_upload.push(state.financial_index.quick_ratio)
            financial_index_to_upload.push(state.financial_index.cf_cl)
            financial_index_to_upload.push(state.financial_index.ttal)
            financial_index_to_upload.push(state.financial_index.operating_revenue)
            financial_index_to_upload.push(state.financial_index.total_profit)
            financial_index_to_upload.push(state.financial_index.total_liabilities)
            financial_index_to_upload.push(state.financial_index.roe)
            financial_index_to_upload.push(state.financial_index.profit_rate)
            financial_index_to_upload.push(state.financial_index.gross_profit)
            financial_index_to_upload.push(state.financial_index.fe_rev)
            financial_index_to_upload.push(state.financial_index.turnover_days)
            financial_index_to_upload.push(state.financial_index.current_assets)
            financial_index_to_upload.push(state.financial_index.accounts_receivable)
            financial_index_to_upload.push(state.financial_index.ebit_rev)
            financial_index_to_upload.push(state.financial_index.industry_prosperity)
            //财务指标收集完毕


            // 提交上去
            const res = await upload_indexAPI(user.state.userId, integration_indicators_to_upload , financial_index_to_upload)
            if (res){
                console.log('上传完毕')
            }
        } ,
        get_enterprise_report_text : async ({state, commit}) =>{
            const res = await get_enterprise_reportAPI()
            if (res){
                commit("set_report_list", res)
            }
        }
    }
}


export default evaluate_process
