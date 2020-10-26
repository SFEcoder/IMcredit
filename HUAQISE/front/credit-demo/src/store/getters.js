const getters = {
    //user
    token: state => state.user.token,
    userId: state => state.user.userId,
    userInfo: state => state.user.userInfo,
    Url:state => state.user.Url,
    //
    current_process_step : state => state.evaluate_process.current_process_step,
    enterprise_evaluate_type : state => state.evaluate_process.enterprise_evaluate_type,
    integration_indicators : state => state.evaluate_process.integration_indicators,
    financial_index : state => state.evaluate_process.financial_index,


}

export default getters
