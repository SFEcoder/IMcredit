import {axios} from '@/utils/request'

const api = {
    evaluatePre: '/epservice/api/index',
    chartPre : '/epservice/api/analy'
}


//上传该企业的指标
export function upload_indexAPI(id, div, fin) {
    return axios({
        url: `${api.evaluatePre}/${id}/add_target`,
        method: 'post',
        data: {
            div: div,
            fin: fin
        }
    })
}


//获得当前企业的指标
export function get_enterprise_indexAPI(id) {
    return axios({
        url : `${api.evaluatePre}/${id}/get_target`,
        method : 'GET'
    })
}


//获得所有企业的评级得分，用于报告的图1, 其中，数组的第一项为当前企业的得分
export function get_grade_all_list_API(id){
    return axios({
        url : `${api.chartPre}/get_grade_all_list/${id}`,
        method : 'GET'
    })
    // return [
    //     89,87,68,99,78,35,65,30,12,68,78,77,99,88,77,78,79,87,74,77,87,68,99,78,45,65,45,68,78,77,45,78,88,77,66,55,77,88,99,88,77,78,79,87,74,77
    // ]
}

//获得该行业内所有企业的量化融合指标总分, 用于报告的图8, 其中，数组的第一项为当前企业的得分
export function get_liang_hua_grade_list_API(id){
    return axios({
        url : `${api.chartPre}/get_liang_hua_grade_list/${id}`,
        method : 'GET'
    })
    // return [
    //     89,87,68,99,78,45,65,45,12,68,78,77,45,78,88,77,66,55,77,88,99,88,77,78,79,87,74,77,87,68,99,78,45,65,45,68,78,77,45,78,88,77,66,55,77,88,99,88,77,78,79,87,74,77
    // ]
}

//获得当前企业所处行业不同发展阶段的企业数量，用于报告的图四
export function get_dev_phrase_num_API(id){
    return axios({
        url : `${api.chartPre}/get_dev_phrase_num/${id}`,
        method : 'GET'
    })
    //分别是成长期，稳定期和衰退期
    // return [
    //     35,50,45
    // ]
}


//获得当前企业财务指标的评分，以及所处行业财务指标的平均得分，共10个值
export function get_financial_grade_display_list_API(id){
    return axios({
        url : `${api.chartPre}/get_financial_grade_display_list/${id}`,
        method : 'GET'
    })
    // return [
    //     3.1,4.2,4.7,4.3,4.2,3.1,3.2,4.4,3.0,1.8
    // ]
}


//获得当前企业企业自身，及所处行业平均分数 （财务指标-盈利能力）：盈利能力指标（企业自身+行业平均分数）、销售净利率、销售毛利率
export function get_gain_abailty_indexs_list_API(id){
    return axios({
        url : `${api.chartPre}/get_gain_abailty_indexs_list/${id}`,
        method : 'GET'
    })
    // return [
    //     80,70,60,90,40,20
    // ]
}


//用于图10,  id为当前企业的id
// 企业和所处行业平均：供应链管理中的二级指标得分
export function get_gong_ying_lian_guan_li_list_API(id){
    return axios({
        url : `${api.chartPre}/get_gong_ying_lian_guan_li_list/${id}`,
        method : 'GET'
    })
    // return [
    //     40,60,70,80,90,10,20,30,30,40,20,40   //离散大批量、离散中小批量行业，10个值
    // ]
}




//获得当前企业企业自身，及所处行业平均分数 （财务指标-营运能力）：财务费用/营业总收入 、 存货周转天数、 流动资产周转率、 应收账款周转率、已获利息倍数(EBIT/利息费用)
export function get_operation_abailty_indexs_list_API(id){
    return axios({
        url : `${api.chartPre}/get_operation_abailty_indexs_list/${id}`,
        method : 'GET'
    })
    // return [
    //     40,50,60,70,80,90,10,20,30,40
    // ]
}


//获得当前企业企业自身，及所处行业平均分数  : 两化融合指标体系的一级指标
export function get_liang_hua_first_index_grade_list_API(id){
    return axios({
        url : `${api.chartPre}/get_liang_hua_first_index_grade_list/${id}`,
        method : 'GET'
    })
    // return [
    //     40,60,70,80,90,10,20,30
    // ]
}

//获得当前企业偿债能力的评分，以及所处行业偿债能力的平均指标，共10个值
export function get_debt_grade_display_list_API(id){
    return axios({
        url : `${api.chartPre}/get_debt_grade_display_list/${id}`,
        method : 'GET'
    })
    // return [
    //     0.78,0.54,0.34,15,9,0.55,0.45,0.43,9,15
    // ]
}


//获得当前企业企业自身，及所处行业平均分数 （财务指标-成长能力）：所有营业总收入、利润总额、总负债得分
export function get_growth_abailty_indexs_list_API(id){
    return axios({
        url : `${api.chartPre}/get_growth_abailty_indexs_list/${id}`,
        method : 'GET'
    })
    // return [
    //     68, 78, 94, 90, 41, 60
    // ]
}

//用于图11
// 企业和所处行业平均：行政管理中的二级指标得分
export function get_xing_zheng_guan_li_list_API(id){
    return axios({
        url : `${api.chartPre}/get_xing_zheng_guan_li_list/${id}`,
        method : 'GET'
    })
    // return [
    //     40,60,70,80,90,10,20,30,30,40
    // ]
}


//用于图12
// 企业和所处行业平均：信息化管理中的资金投入这一项的得分
export function get_money_investment_list_API(id){
    return axios({
        url : `${api.chartPre}/get_money_investment_list/${id}`,
        method : 'GET'
    })
    // return [
    //     88, 76, 88, 76, 88, 76
    // ]
}

//用于图13
// 企业和所处行业平均：增值服务管理二级指标得分
export function get_zen_zhi_fu_wu_list_API(id){
    return axios({
        url : `${api.chartPre}/get_zen_zhi_fu_wu_list/${id}`,
        method : 'GET'
    })
    // return [
    //     88, 76, 97, 48, 88, 76, 97, 48
    // ]
}


//获得报告的文字内容
export function get_enterprise_reportAPI(id) {
    return axios({
        url: `/epservice/api/analy/${id}/getAnaly`,
        method: 'GET'
    })

    // return [
    //     "公司A", //0
    //     "94.54",//1
    //     "SSS",//2
    //     '2020年5月20日',//3
    //     '混合行业',//4
    //     '财务指标、组织规划、按时交货率等',//5
    //     '公司回款能力较强。',//6
    //     "2019年公司经营活动产生的现金流量净额与经营活动净收益之比为xxx，与同行业相比，公司的经营活动现金流可以更多地转化为经营活动净收益。",//7
    //     '公司偿债能力较强。',//8
    //     '2019年，公司的资产负债率为68.00%，公司已经资不抵债，对于债权人来说风险非常大。',//9
    //     '流动比率为1.32，速动比率为1.05，资金流动性差',//10
    //     '经营活动产生的现金流量净额与流动负债之比为0.12，企业流动负债的偿还有保证',//11
    //     '有形资产与负债合计之比为45%，企业有较好的偿债能力，举债规模正常',//12
    //     '公司面临债务偿还压力较大，应优化资本结构，提高资产质量，科学举债，制定合理的偿债计划。',//13
    //     '公司成长能力较强。',//14
    //     '2019年，营业总收入同比增长率为15%，正处于成长期，将继续保持较好的增长势头，尚未面临产品更新的风险，属于成长型公司。',//15
    //     '利润总额同比增长率为20%，处于行业较高水平',//16
    //     '公司应找寻增加利润的销售方式，实行合理的负债经营。',//17
    //     '公司盈利能力较强。',//18
    //     '2019年公司净资产收益率为1.55%，公司对资金的利用效率较好。',//19
    //     '资金使用效率很高，但这是建立在高负债基础上的，风险不可小觑。', //20
    //     '销售净利率2%，销售收入收益水平处于行业较低水平', //21
    //     '销售毛利率96%，处于行业中等水平',//22
    //     '公司未来需积极开拓更灵活的经营方式，合理配置资本结构，通过正确决策和管理运营增加营业总收入，降低总成本，提高销售净利率。',//23
    //     '公司营运能力较强。',//24
    //     '公司财务费用与营业总收入之比为1.2，企业财务负担与同行业相比较轻',//25
    //     '存货周转天数为72天，存货变现的速度较快，存货占用资金时间较短，工作效率较高。',//26
    //     '企业流动资产周转速度较快，利用较好。',//27
    //     '公司应收账款周转率为1.30，公司收账速度快，平均收账期短，坏账损失少，资产流动快，偿债能力强', //28
    //     '已获利息倍数为3，公司在一定盈利水平下支付债务利息的能力很弱。',//29
    //     '公司在一定盈利水平下支付债务利息的能力较强。',//30
    //     '在供应链管理层面，公司在采购、生产、销售流程中的体系比较全面。', //31
    //     '2019年公司实现按期交货率为95%，相对较高。', //32
    //     '企业具有一体化的管理与控制集成模式，经营管理系统与车间生产制造执行系统之间的指令传达具有范围广、系统化、自动化的特点', //33
    //     '企业在项目管理过程中的信息系统与解决方案较为成熟', //34
    //     '其主要的业务与控制集成化指标，例如：通过信息化全面落实企业战略规划实现全面预算管理的情况、经营管理系统向车间生产制造执行系统或调度系统自动下达指令包含内容等得分所反映出的集成化程度比较可观，位居同行业前中部', //35
    //     '在行政管理层面，公司的水平较高。', //36
    //     '其中企业组织模式得分为6，说明公司本身对于“两化融合”中的行政管理进程予以高度关注', //37
    //     '在人力资源方面，应用信息化手段进行人力资源管理实现的功能与层级得分为4，比较可观', //38
    //     '在设备管理方面，公司应用信息化手段进行设备管理实现的功能与层级得分为4，位于行业前列', //39
    //     '整体来看，信息化规划执行情况得分为7，说明公司正处于信息化较为成熟的阶段', //40
    //     '在信息化管理层面，公司的资金投入水平较高。', //41
    //     '公司的信息系统运维投入占信息化总投入的比例为13.45%（1），当年企业生产设备总资产为6.9亿元（2），近五年信息化建设投入为3000万元', //42
    //     '在增值服务管理层面，公司所反映出的协同水平较高。', //43
    //     '综合比对一些主要指标得分，包括：通过信息化实现业务协同和一体化情况、产业链企业之间信息交互和共享情况、以及通过建立互联网开放社区实现价值网络协同情况等，发现该公司在产业链协同方面具有比较良好的协同发展生态圈，比较利于跨企业资源共享与关键制造环节协同优化', //44
    //     '同时，公司可以很好地利用信息化手段实现能源与环保的管理，有利于企业的可持续发展与升级', //45
    //     '在研发管理层面，公司的创新能力较强。', //46
    //     '从新产品产值率这一指标来看，该公司的创新能力位于行业前列，面临较大的创新滞后风险与可持续性发展瓶颈', //47
    //     '综上所述，本平台确定×××长期信用等级为AAA。该评级结论有效反映了企业的信用风险状况。' //48
    // ]

}


