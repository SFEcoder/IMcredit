const items_to_check = {
    massDiscreteitems_to_check: [
        "按期交货率", '应用信息系统进行项目管理实现的功能与层级', '信息化条件下安全生产应急响应及重大危险源预测预警情况', '通过信息化全面落实企业战略规划，实现全面预算管理的情况', '经营管理系统向车间生产制造执行系统（或调度系统）自动下达指令包含内容', '应用信息化手段进行环保管理实现的功能', '应用信息化手段进行能源管理实现的功能', '社会贡献率', '通过信息化实现与产业链企业间业务协同情况', '通过建立互联网开放社区实现价值网络协同情况', '贯穿产品全生命周期各阶段的产品状态信息跟踪与反馈情况', '信息系统运维投入占信息化总投入的比例', '企业组织模式', '信息化规划执行情况', '综合运用信息化手段可实现的决策支持内容', '应用信息化手段进行设备管理实现的功能与层级', '应用信息化手段进行人力资源管理实现的功能与层级'
    ],
    processIndustry_to_check: [
        '应用信息系统进行项目管理实现的功能与层级',
        '通过信息化全面落实企业战略规划，实现全面预算管理的情况',
        '车间生产制造执行系统（或调度系统）向经营管理系统自动上传信息范围',
        '经营管理系统向车间生产制造执行系统（或调度系统）自动下达指令包含内容',
        '生产制造过程控制系统向车间生产制造执行系统（或调度系统）自动上传信息覆盖范围',
        '车间生产制造执行系统（或调度系统）向生产制造过程控制系统自动下达指令情况',
        '应用信息系统进行内部供应链集成管理所覆盖的环节',
        '网上采购率',
        '实现信息化排产的最小排产单元（或生产线）数占最小排产单元（或生产线）总数的比例',
        '应用信息化手段进行能源管理实现的功能',
        '社会贡献率',
        '通过信息化实现业务协同和一体化情况',
        '产业链企业之间信息交互和共享情况',
        '通过建立互联网开放社区实现价值网络协同情况',
        '应用信息化手段实现产品全生命周期绿色发展的情况',
        '信息系统运维投入占信息化总投入的比例',
        '企业组织模式',
        '信息化规划执行情况',
        '应用信息化手段开展物料需求计划管理情况',
        '应用信息化手段开展研发设计情况',
        '基于智能知识模型自动采集信息并进行综合分析的业务范围',
        '应用信息化手段进行设备管理实现的功能与层级',
        '应用信息化手段进行人力资源管理实现的功能与层级',
        '工业软件创新能力',
        '新产品产值率'
    ],
    smeDiscrete_to_check : [
        '应用信息系统进行项目管理实现的功能与层级',
        '财务系统对销售实时监控的情况',
        "经营管理系统向车间生产制造执行系统（或调度系统）自动下达指令包含内容",
        "车间生产制造执行系统（或调度系统）向经营管理系统自动上传信息范围",
        "应用信息系统进行质量管理的覆盖范围",
        "应用信息系统进行质量管理实现的功能",
        "是否能够通过信息化对外协全过程进行监管",
        "应用信息化手段进行能源管理实现的功能",
        "社会贡献率",
        "通过信息化实现与产业链企业间业务协同情况",
        "通过建立互联网开放社区实现价值网络协同情况",
        "在线实现产品服务延伸或远程管控的情况",
        "近五年信息化建设投入",
        "信息系统运维投入占信息化总投入的比例",
        "当年企业生产设备总资产",
        "企业组织模式",
        "信息化规划执行情况",
        "应用信息化手段开展物料需求计划管理情况",
        "应用信息化手段开展研发设计情况",
        "基于智能知识模型自动采集信息并进行综合分析的业务范围",
        "应用信息化手段进行设备管理实现的功能与层级",
        "应用信息化手段进行人力资源管理实现的功能与层级",
        "工业软件创新能力",
        "新产品研发周期",
        "百人专利拥有量",
        "产品模型数据定义情况"
    ],
    serviceTrade_to_check : [
        "应用信息系统进行项目管理实现的功能与层级",
        "是否建立了呼叫中心",
        "通过信息化全面落实企业战略规划，实现全面预算管理的情况",
        "服务业务管理与服务现场执行的集成情况",
        "网上采购率",
        "采购电子商务的应用范围",
        "全员劳动生产率",
        "应用信息化手段进行能源管理实现的功能",
        "通过信息化实现与产业链企业间业务协同情况",
        "产业链企业之间信息交互和共享情况",
        "信息系统运维投入占信息化总投入的比例",
        "实现企业级统一的编码",
        "企业组织模式",
        "信息化规划执行情况",
        "综合运用信息化手段可实现的决策支持内容",
        "应用信息化手段进行设备管理实现的功能与层级",
        "应用信息化手段进行人力资源管理实现的功能与层级",
        "云平台使用情况"
    ],
    mixedIndustry_to_check : [
        "应用信息系统进行项目管理实现的功能与层级",
        "上传到信息系统的检化验数据占全部检化验数据的比例",
        "应用信息化手段实现用户订单全过程跟踪情况",
        "网上采购率",
        "应用信息化手段实现的安全生产重点部位、设备集中监控覆盖程度",
        "经营管理系统向车间生产制造执行系统（或调度系统）自动下达指令包含内容",
        "能源数据自动采集上传比例",
        "应用信息化手段进行环保管理实现的功能",
        "产业链企业之间信息交互和共享情况",
        "通过建立互联网开放社区实现价值网络协同情况",
        "应用信息化手段实现产品全生命周期绿色发展的情况",
        "社会贡献率",
        "近五年信息化建设投入",
        "当年企业生产设备总资产",
        "企业组织模式",
        "信息化规划执行情况",
        "应用信息化手段开展物料需求计划管理情况",
        "基于智能知识模型自动采集信息并进行综合分析的业务范围",
        "应用信息化手段进行设备管理实现的功能与层级",
        "应用信息化手段进行人力资源管理实现的功能与层级",
        "工业软件创新能力"
    ]

}

export default items_to_check