const getters = {
    //user
    token: state => state.user.token,
    userId: state => state.user.userId,
    userInfo: state => state.user.userInfo,
    Url:state => state.user.Url,
    access_token:state => state.user.access_token,
    port_change:state => state.user.port_change,
    browseHistoryList:state => state.user.browseHistoryList,
    //evaluate_process评级过程指标
    current_process_step : state => state.evaluate_process.current_process_step,
    enterprise_evaluate_type : state => state.evaluate_process.enterprise_evaluate_type,
    integration_indicators : state => state.evaluate_process.integration_indicators,
    financial_index : state => state.evaluate_process.financial_index,
    report_list : state => state.evaluate_process.report_list,
    checkedEnterpriseId : state => state.evaluate_process.checkedEnterpriseId,
    // 企业信息 enterprise
    display_list : state => state.enterprise.display_list,
    evaluate_grade_list : state => state.enterprise.evaluate_grade_list,
    liang_hua_grade_list : state => state.enterprise.liang_hua_grade_list,
    liang_hua_first_index_grade_list : state => state.enterprise.liang_hua_first_index_grade_list,
    financial_grade_display_list : state => state.enterprise.financial_grade_display_list,
    debt_grade_display_list : state => state.enterprise.debt_grade_display_list,
    dev_phrase_list: state=>state.enterprise.dev_phrase_list,
    growth_abailty_indexs_list: state=>state.enterprise.growth_abailty_indexs_list,
    gain_abailty_indexs_list: state=>state.enterprise.gain_abailty_indexs_list,
    operation_abailty_indexs_list: state=>state.enterprise.operation_abailty_indexs_list,
    gong_ying_lian_guan_li_list:state=>state.enterprise.gong_ying_lian_guan_li_list,
    xing_zheng_guan_li_list:state=>state.enterprise.xing_zheng_guan_li_list,
    money_investment_list:state=>state.enterprise.money_investment_list,
    zen_zhi_fu_wu_list:state=>state.enterprise.zen_zhi_fu_wu_list,



}

export default getters
