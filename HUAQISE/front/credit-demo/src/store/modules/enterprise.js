import router from '@/router'
import miniToastr from 'mini-toastr'

import {
    get_enterprise_display_listAPI,
    search_enterprise_display_listAPI
} from "@/api/enterprise"

import {
    get_grade_all_list_API,
    get_financial_grade_display_list_API,
    get_debt_grade_display_list_API,
    get_dev_phrase_num_API,
    get_growth_abailty_indexs_list_API,
    get_gain_abailty_indexs_list_API,
    get_operation_abailty_indexs_list_API,
    get_liang_hua_first_index_grade_list_API,
    get_liang_hua_grade_list_API,
    get_gong_ying_lian_guan_li_list_API,
    get_xing_zheng_guan_li_list_API,
    get_money_investment_list_API,
    get_zen_zhi_fu_wu_list_API
}from '@/api/evaluate'

const getDefaultState = () => {
    return {
        display_list: [],
        evaluate_grade_list:[],
        financial_grade_display_list:[],
        debt_grade_display_list:[], //偿债能力各项指标的数据，用于报告的图3
        dev_phrase_list:[], //企业不同发展阶段的企业数量，顺序：成长期，稳定期，衰退期
        growth_abailty_indexs_list:[], //企业自身，及所处行业平均分数 （财务指标-成长能力）：所有营业总收入、利润总额、总负债得分
        gain_abailty_indexs_list:[], //盈利能力指标（企业自身+行业平均分数）
        operation_abailty_indexs_list:[], //营运能力指标（企业自身+行业平均分数）
        liang_hua_first_index_grade_list:[], //该行业内的所有企业的两化融合各项一级指标得分
        liang_hua_grade_list:[], //所有企业的量化融合总分
        gong_ying_lian_guan_li_list: [] , //供应链管理体系的分数
        xing_zheng_guan_li_list:[], //企业和所处行业平均：行政管理中的二级指标得分
        money_investment_list:[], //企业和所处行业平均：信息化管理中的资金投入这一项的得分
        zen_zhi_fu_wu_list:[], //企业和所处行业平均：增值服务管理二级指标得分
    }
}

import user from "@/store/modules/user";


const enterprise = {
    state: getDefaultState(),

    mutations: {
        set_display_list: (state, data) => {
            state.display_list = data
        },

        set_evaluate_grade_list: (state, data) =>{
            state.evaluate_grade_list = data
        },

        set_financial_grade_display_list: (state, data) =>{
            state.financial_grade_display_list = data
        },

        set_debt_grade_display_list: (state, data) =>{
            state.debt_grade_display_list = data
        },

        set_dev_phrase_list: (state, data) =>{
            state.dev_phrase_list = data
        },

        set_growth_abailty_indexs_list: (state, data) =>{
            state.growth_abailty_indexs_list = data
        },

        set_gain_abailty_indexs_list:(state, data) =>{
            state.gain_abailty_indexs_list = data
        },

        set_operation_abailty_indexs_list:(state, data) =>{
            state.operation_abailty_indexs_list = data
        },

        set_liang_hua_first_index_grade_list:(state, data) =>{
            state.liang_hua_first_index_grade_list = data
        },

        set_liang_hua_grade_list:(state, data) =>{
            state.liang_hua_grade_list = data
        },

        set_gong_ying_lian_guan_li_list:(state,data) =>{
            state.gong_ying_lian_guan_li_list = data
        },

        set_xing_zheng_guan_li_list:(state,data) =>{
            state.xing_zheng_guan_li_list = data
        },

        set_money_investment_list:(state,data) =>{
            state.money_investment_list = data
        },

        set_zen_zhi_fu_wu_list:(state,data) =>{
            state.zen_zhi_fu_wu_list = data
        },


    },


    actions: {

        get_display_list: async ({commit, state}) => {
            const res = await search_enterprise_display_listAPI("")
            // const res = await get_enterprise_display_listAPI()
            if (res) {
                commit('set_display_list', res)

            }
        },


        search_enterprise_display_list: async ({commit, state}, key) => {
            const res = await search_enterprise_display_listAPI(key)
            if (res) {
                commit("set_display_list", res)
                miniToastr.success("搜索成功")
            }
        },

        get_grade_all_list: async ({commit, state}) =>{
            const res = await get_grade_all_list_API(user.state.userId)
            if(res){
                commit('set_evaluate_grade_list', res)
            }
        },

        get_financial_grade_display_list: async ({commit, state}) =>{
            const res = await get_financial_grade_display_list_API(user.state.userId)
            if(res){
                commit('set_financial_grade_display_list', res)
            }
        },

        get_debt_grade_display_list: async ({commit, state}) =>{
            const res = await get_debt_grade_display_list_API(user.state.userId)
            if(res){
                commit('set_debt_grade_display_list', res)
            }
        },


        get_dev_phrase_list: async ({commit, state}) =>{
            const res = await get_dev_phrase_num_API(user.state.userId)
            if(res){
                commit('set_dev_phrase_list', res)
            }
        },

        get_growth_abailty_indexs_list: async ({commit, state}) =>{
            const res = await get_growth_abailty_indexs_list_API(user.state.userId)
            if(res){
                commit('set_growth_abailty_indexs_list', res)
            }
        },

        get_gain_abailty_indexs_list: async ({commit, state}) =>{
            const res = await get_gain_abailty_indexs_list_API(user.state.userId)
            if(res){
                commit('set_gain_abailty_indexs_list', res)
            }
        },

        get_operation_abailty_indexs_list: async ({commit, state}) =>{
            const res = await get_operation_abailty_indexs_list_API(user.state.userId)
            if(res){
                commit('set_operation_abailty_indexs_list', res)
            }
        },

        get_liang_hua_first_index_grade_list: async ({commit, state}) =>{
            const res = await get_liang_hua_first_index_grade_list_API(user.state.userId)
            if(res){
                commit('set_liang_hua_first_index_grade_list', res)
            }
        },

        get_liang_hua_grade_list: async ({commit, state}) =>{
            const res = await get_liang_hua_grade_list_API(user.state.userId)
            if(res){
                commit('set_liang_hua_grade_list', res)
            }
        },

        get_gong_ying_lian_guan_li_list: async ({commit, state}) =>{
            const res = await get_gong_ying_lian_guan_li_list_API(user.state.userId)
            if(res){
                commit('set_gong_ying_lian_guan_li_list', res)
            }
        },

        get_xing_zheng_guan_li_list: async ({commit, state}) =>{
            const res = await get_xing_zheng_guan_li_list_API(user.state.userId)
            if(res){
                commit('set_xing_zheng_guan_li_list', res)
            }
        },

        get_money_investment_list: async ({commit, state}) =>{
            const res = await get_money_investment_list_API(user.state.userId)
            if(res){
                commit('set_money_investment_list', res)
            }
        },

        get_zen_zhi_fu_wu_list: async ({commit, state}) =>{
            const res = await get_zen_zhi_fu_wu_list_API(user.state.userId)
            if(res){
                commit('set_zen_zhi_fu_wu_list', res)
            }
        },

    }



}

export default enterprise
