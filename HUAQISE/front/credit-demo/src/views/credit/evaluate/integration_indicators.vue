<template>
  <div id="integration_indicators_page">
    <div class="row">
      <div class="col-lg-12">
        <b-card class="mb-2" :header="'两化融合指标体系' + ' —— '+ get_enteprise_name_by_type_num()" header-tag="h4">
          <div>
            <a-form
                :form="form"
            >
              <div class="row">

                <!--                                左边栏-->
                <div class="col-md-6 evaluate_col_box">

                  <!--                                    按期交货率（%） ( 0 - 100 )-->
                  <div v-if="enterprise_evaluate_type === 1" class="evaluate_input_box">
                    <a-row class="input_description_text">按期交货率（%） ( 0 - 100 )</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="%" suffix="percent"
                                   v-decorator="['按期交货率',
                                                             {initialValue:this.integration_indicators.on_time_delivery_rate }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                    按期交货率（%） ( 0 - 100 )-->

                  <!--                                    新产品产值率 output_value（%） ( 0 - 100 )-->
                  <div v-if="enterprise_evaluate_type === 2" class="evaluate_input_box">
                    <a-row class="input_description_text">新产品产值率（%） ( 0 - 100 )</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="%" suffix="percent"
                                   v-decorator="['新产品产值率',
                                                             {initialValue:this.integration_indicators.output_value }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                    新产品产值率 output_value（%） ( 0 - 100 )-->

                  <!--                                    能源数据自动采集上传比例（%） ( 0 - 100 )-->
                  <div v-if="enterprise_evaluate_type === 5" class="evaluate_input_box">
                    <a-row class="input_description_text">能源数据自动采集上传比例（%） ( 0 - 100 )</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="%" suffix="percent"
                                   v-decorator="['能源数据自动采集上传比例',
                                                             {initialValue:this.integration_indicators.collection_of_energy_data}]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                    能源数据自动采集上传比例（%） ( 0 - 100 )-->


                  <!--                                    网上采购率（%） ( 0 - 100 )-->
                  <div
                      v-if="enterprise_evaluate_type === 2 || this.enterprise_evaluate_type === 4 || this.enterprise_evaluate_type === 5"
                      class="evaluate_input_box">
                    <a-row class="input_description_text">网上采购率（%） ( 0 - 100 )</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="%" suffix="percent"
                                   v-decorator="['网上采购率',
                                                             {initialValue:this.integration_indicators.online_purchasing_rate }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                    网上采购率（%） ( 0 - 100 )-->


                  <!--                                   当年企业生产设备总资产（万元） -->
                  <div v-if="this.enterprise_evaluate_type === 3 || this.enterprise_evaluate_type === 5"
                       class="evaluate_input_box">
                    <a-row class="input_description_text">当年企业生产设备总资产（万元）</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="￥" suffix="万"
                                   v-decorator="['当年企业生产设备总资产',
                                                             {initialValue:this.integration_indicators.total_assets_proequ }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                   当年企业生产设备总资产（万元）-->


                  <!--                                   新产品研发周期（天） -->
                  <div v-if="this.enterprise_evaluate_type === 3" class="evaluate_input_box">
                    <a-row class="input_description_text">新产品研发周期（天）</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input suffix="天"
                                   v-decorator="['新产品研发周期',
                                                             {initialValue:this.integration_indicators.newproduct_develope_cycle }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                   新产品研发周期（天）-->


                  <!--                                   百人专利拥有量 -->
                  <div v-if="this.enterprise_evaluate_type === 3" class="evaluate_input_box">
                    <a-row class="input_description_text">百人专利拥有量</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input
                              v-decorator="['百人专利拥有量',
                                                             {initialValue:this.integration_indicators.patent_ownership_hundred }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                   百人专利拥有量-->


                  <!--                                    应用信息系统进行项目管理实现的功能与层级 ( 0 - 5 )-->
                  <div class="evaluate_input_box">
                    <a-row class="input_description_text">应用信息系统进行项目管理实现的功能与层级 ( 0 - 5 )</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_five_mark"
                                  :min="0" :max="5" :step="1"
                                  v-decorator="['应用信息系统进行项目管理实现的功能与层级',
                                                             {initialValue:this.integration_indicators.system_manage_level }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    应用信息系统进行项目管理实现的功能与层级 ( 0 - 5 )-->


                  <!--                                    信息化条件下安全生产应急响应及重大危险源预测预警情况（0~5）-->
                  <div v-if="this.enterprise_evaluate_type === 1" class="evaluate_input_box">
                    <a-row class="input_description_text">信息化条件下安全生产应急响应及重大危险源预测预警情况（0~5）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_five_mark"
                                  :min="0" :max="5" :step="1"
                                  v-decorator="['信息化条件下安全生产应急响应及重大危险源预测预警情况',
                                                             {initialValue:this.integration_indicators.emergency_response }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    信息化条件下安全生产应急响应及重大危险源预测预警情况（0~5）-->

                  <!--                                    通过信息化全面落实企业战略规划，实现全面预算管理的情况（-5~0）-->
                  <div
                      v-if="this.enterprise_evaluate_type === 1 || this.enterprise_evaluate_type === 2 || this.enterprise_evaluate_type === 4"
                      class="evaluate_input_box">
                    <a-row class="input_description_text">通过信息化全面落实企业战略规划，实现全面预算管理的情况（-5~0）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.minus_five_to_zero_mark"
                                  :min="0" :max="5" :step="1" :tooltipVisible="false"
                                  v-decorator="['通过信息化全面落实企业战略规划，实现全面预算管理的情况',
                                                             {initialValue:this.integration_indicators.budget_management }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    通过信息化全面落实企业战略规划，实现全面预算管理的情况（-5~0）-->


                  <!--                                    信息化规划执行情况（0~9）-->
                  <div
                      v-if="this.enterprise_evaluate_type === 1 || this.enterprise_evaluate_type === 2 || this.enterprise_evaluate_type === 3"
                      class="evaluate_input_box">
                    <a-row class="input_description_text">信息化规划执行情况（0~9）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_nine_mark"
                                  :min="0" :max="9" :step="1"
                                  v-decorator="['信息化规划执行情况',
                                                             {initialValue:this.integration_indicators.plan_implementation }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    信息化规划执行情况（0~9）-->

                  <!--                   服务行业特定                信息化规划执行情况（0~5）-->
                  <div v-if="this.enterprise_evaluate_type === 4 || this.enterprise_evaluate_type === 5"
                       class="evaluate_input_box">
                    <a-row class="input_description_text">信息化规划执行情况（0~5）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_five_mark"
                                  :min="0" :max="5" :step="1"
                                  v-decorator="['信息化规划执行情况',
                                                             {initialValue:this.integration_indicators.plan_implementation }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    信息化规划执行情况（0~5）-->


                  <!--                                    服务业务管理与服务现场执行的集成情况（0~10）-->
                  <div v-if="this.enterprise_evaluate_type === 4" class="evaluate_input_box">
                    <a-row class="input_description_text">服务业务管理与服务现场执行的集成情况（0~10）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_ten_mark"
                                  :min="0" :max="10" :step="1"
                                  v-decorator="['服务业务管理与服务现场执行的集成情况',
                                                             {initialValue:this.integration_indicators.service_Integration }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    服务业务管理与服务现场执行的集成情况（0~10）-->


                  <!--                                    综合运用信息化手段可实现的决策支持内容（0~7）-->
                  <div v-if="this.enterprise_evaluate_type === 1" class="evaluate_input_box">
                    <a-row class="input_description_text">综合运用信息化手段可实现的决策支持内容（0~7）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_seven_mark"
                                  :min="0" :max="7" :step="1"
                                  v-decorator="['综合运用信息化手段可实现的决策支持内容',
                                                             {initialValue:this.integration_indicators.decision_support }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    综合运用信息化手段可实现的决策支持内容（0~7）-->

                  <!--                      服务行业特殊              综合运用信息化手段可实现的决策支持内容 (-10 ~ 0) -->
                  <div v-if="this.enterprise_evaluate_type === 4" class="evaluate_input_box">
                    <a-row class="input_description_text">综合运用信息化手段可实现的决策支持内容 (-10 ~ 0)</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.minus_ten_to_zero_mark"
                                  :min="0" :max="10" :step="1"
                                  v-decorator="['综合运用信息化手段可实现的决策支持内容',
                                                             {initialValue:this.integration_indicators.decision_support }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    综合运用信息化手段可实现的决策支持内容(-10 ~ 0)-->


                  <!--                                   应用信息化手段进行设备管理实现的功能与层级（0~4） -->
                  <div
                      v-if="this.enterprise_evaluate_type === 1 || this.enterprise_evaluate_type === 2 || this.enterprise_evaluate_type === 3 "
                      class="evaluate_input_box">
                    <a-row class="input_description_text">应用信息化手段进行设备管理实现的功能与层级（0~4）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_four_mark"
                                  :min="0" :max="4" :step="1"
                                  v-decorator="['应用信息化手段进行设备管理实现的功能与层级',
                                                             {initialValue:this.integration_indicators.equipment_management }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                   应用信息化手段进行设备管理实现的功能与层级（0~4） -->


                  <!--                服务行业特殊                   应用信息化手段进行设备管理实现的功能与层级（0~5） -->
                  <div v-if="this.enterprise_evaluate_type === 4 || this.enterprise_evaluate_type === 5 "
                       class="evaluate_input_box">
                    <a-row class="input_description_text">应用信息化手段进行设备管理实现的功能与层级（0~5）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_five_mark"
                                  :min="0" :max="5" :step="1"
                                  v-decorator="['应用信息化手段进行设备管理实现的功能与层级',
                                                             {initialValue:this.integration_indicators.equipment_management }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                   应用信息化手段进行设备管理实现的功能与层级（0~5） -->


                  <!--                                    应用信息化手段进行人力资源管理实现的功能与层级（0~4）-->
                  <div
                      v-if="this.enterprise_evaluate_type === 1 || this.enterprise_evaluate_type === 2 || this.enterprise_evaluate_type === 3"
                      class="evaluate_input_box">
                    <a-row class="input_description_text">应用信息化手段进行人力资源管理实现的功能与层级（0~4）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_four_mark"
                                  :min="0" :max="4" :step="1"
                                  v-decorator="['应用信息化手段进行人力资源管理实现的功能与层级',
                                                             {initialValue:this.integration_indicators.hr_management }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    应用信息化手段进行人力资源管理实现的功能与层级（0~4）-->

                  <!--                                    应用信息化手段进行人力资源管理实现的功能与层级（0~5）-->
                  <div v-if="this.enterprise_evaluate_type === 4 || this.enterprise_evaluate_type === 5"
                       class="evaluate_input_box">
                    <a-row class="input_description_text">应用信息化手段进行人力资源管理实现的功能与层级（0~5）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_five_mark"
                                  :min="0" :max="5" :step="1"
                                  v-decorator="['应用信息化手段进行人力资源管理实现的功能与层级',
                                                             {initialValue:this.integration_indicators.hr_management }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    应用信息化手段进行人力资源管理实现的功能与层级（0~5）-->


                  <!--                                    通过建立互联网开放社区实现价值网络协同情况（0~5）-->
                  <div
                      v-if="this.enterprise_evaluate_type === 1 || this.enterprise_evaluate_type === 2 || this.enterprise_evaluate_type === 3"
                      class="evaluate_input_box">
                    <a-row class="input_description_text">通过建立互联网开放社区实现价值网络协同情况（0~5）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_five_mark"
                                  :min="0" :max="5" :step="1"
                                  v-decorator="['通过建立互联网开放社区实现价值网络协同情况',
                                                             {initialValue:this.integration_indicators.value_network_collaboration }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    通过建立互联网开放社区实现价值网络协同情况（0~5）-->

                  <!--         混合行业特定                           通过建立互联网开放社区实现价值网络协同情况（0~10）-->
                  <div v-if="this.enterprise_evaluate_type === 5" class="evaluate_input_box">
                    <a-row class="input_description_text">通过建立互联网开放社区实现价值网络协同情况（0~10）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_ten_mark"
                                  :min="0" :max="10" :step="1"
                                  v-decorator="['通过建立互联网开放社区实现价值网络协同情况',
                                                             {initialValue:this.integration_indicators.value_network_collaboration }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    通过建立互联网开放社区实现价值网络协同情况（0~5）-->


                  <!--                                    通过信息化实现业务协同和一体化情况-->
                  <div v-if="this.enterprise_evaluate_type === 2" class="evaluate_input_box">
                    <a-row class="input_description_text">通过信息化实现业务协同和一体化情况（0~9）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_nine_mark"
                                  :min="0" :max="9" :step="1"
                                  v-decorator="['通过信息化实现业务协同和一体化情况',
                                                             {initialValue:this.integration_indicators.business_collaboration }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    通过信息化实现业务协同和一体化情况-->


                  <!--                                    产业链企业之间信息交互和共享情况（0~3）-->
                  <div
                      v-if="this.enterprise_evaluate_type === 2  || this.enterprise_evaluate_type === 5"
                      class="evaluate_input_box">
                    <a-row class="input_description_text">产业链企业之间信息交互和共享情况（0~3）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_three_mark"
                                  :min="0" :max="3" :step="1"
                                  v-decorator="['产业链企业之间信息交互和共享情况',
                                                             {initialValue:this.integration_indicators.info_exchange_and_sharing }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    产业链企业之间信息交互和共享情况（0~3）-->


                  <!--                               服务行业特定     产业链企业之间信息交互和共享情况（0~5）-->
                  <div v-if="this.enterprise_evaluate_type === 4" class="evaluate_input_box">
                    <a-row class="input_description_text">产业链企业之间信息交互和共享情况（0~5）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_five_mark"
                                  :min="0" :max="5" :step="1"
                                  v-decorator="['产业链企业之间信息交互和共享情况',
                                                             {initialValue:this.integration_indicators.info_exchange_and_sharing }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    产业链企业之间信息交互和共享情况（0~5）-->


                  <!--                                    应用信息化手段实现产品全生命周期绿色发展的情况（0~5）-->
                  <div v-if="this.enterprise_evaluate_type === 2" class="evaluate_input_box">
                    <a-row class="input_description_text"> 应用信息化手段实现产品全生命周期绿色发展的情况（0~5）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_five_mark"
                                  :min="0" :max="5" :step="1"
                                  v-decorator="['应用信息化手段实现产品全生命周期绿色发展的情况',
                                                             {initialValue:this.integration_indicators.green_development }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                     应用信息化手段实现产品全生命周期绿色发展的情况（0~5）-->

                  <!--             混合行业特定                       应用信息化手段实现产品全生命周期绿色发展的情况（0~10）-->
                  <div v-if="this.enterprise_evaluate_type === 5" class="evaluate_input_box">
                    <a-row class="input_description_text"> 应用信息化手段实现产品全生命周期绿色发展的情况（0~10）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_ten_mark"
                                  :min="0" :max="10" :step="1"
                                  v-decorator="['应用信息化手段实现产品全生命周期绿色发展的情况',
                                                             {initialValue:this.integration_indicators.green_development }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                     应用信息化手段实现产品全生命周期绿色发展的情况（0~10）-->


                  <!--                                    财务系统对销售实时监控的情况（-5~0）-->
                  <div v-if="this.enterprise_evaluate_type === 3" class="evaluate_input_box">
                    <a-row class="input_description_text">财务系统对销售实时监控的情况（-5~0）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.minus_five_to_zero_mark"
                                  :min="0" :max="5" :step="1" :tooltipVisible="false"
                                  v-decorator="['财务系统对销售实时监控的情况',
                                                             {initialValue:this.integration_indicators.financialsystem_monitor_sales }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    财务系统对销售实时监控的情况（-5~0）-->


                  <!--                                    应用信息系统进行质量管理实现的功能（0~10）-->
                  <div v-if="this.enterprise_evaluate_type === 3" class="evaluate_input_box">
                    <a-row class="input_description_text"> 应用信息系统进行质量管理实现的功能（0~10）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_ten_mark"
                                  :min="0" :max="10" :step="1"
                                  v-decorator="['应用信息系统进行质量管理实现的功能',
                                                             {initialValue:this.integration_indicators.info_qua_function }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    应用信息系统进行质量管理的覆盖范围（0~10）-->


                  <!--                                    应用信息系统进行质量管理的覆盖范围（0~10）-->
                  <div v-if="this.enterprise_evaluate_type === 3" class="evaluate_input_box">
                    <a-row class="input_description_text"> 应用信息系统进行质量管理的覆盖范围（0~10）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_ten_mark"
                                  :min="0" :max="10" :step="1"
                                  v-decorator="['应用信息系统进行质量管理的覆盖范围',
                                                             {initialValue:this.integration_indicators.info_qua_coverage_area }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    应用信息系统进行质量管理的覆盖范围（0~10）-->


                  <!--                                    车间生产制造执行系统（或调度系统）向经营管理系统自动上传信息范围-->
                  <div v-if="this.enterprise_evaluate_type === 2 || this.enterprise_evaluate_type === 3"
                       class="evaluate_input_box">
                    <a-row class="input_description_text">车间生产制造执行系统（或调度系统）向经营管理系统自动上传信息范围（-15~15）</a-row>
                    <a-form-item>
                      <a-col :span="35">
                        <a-slider :dots="true" :marks="slide_marks.minus_fifteen_to_fifteen_mark"
                                  :min="0" :max="30" :step="1"
                                  v-decorator="['车间生产制造执行系统（或调度系统）向经营管理系统自动上传信息范围',
                                                             {initialValue:this.integration_indicators.auto_upload_info_range }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    车间生产制造执行系统（或调度系统）向经营管理系统自动上传信息范围-->


                  <!--                                    基于智能知识模型自动采集信息并进行综合分析的业务范围（-11~11）-->
                  <div v-if="this.enterprise_evaluate_type === 2 || this.enterprise_evaluate_type === 3"
                       class="evaluate_input_box">
                    <a-row class="input_description_text">基于智能知识模型自动采集信息并进行综合分析的业务范围（-11~11）</a-row>
                    <a-form-item>
                      <a-col :span="35">
                        <a-slider :dots="true" :marks="slide_marks.minus_eleven_to_eleven_mark"
                                  :min="0" :max="22" :step="1"
                                  v-decorator="['基于智能知识模型自动采集信息并进行综合分析的业务范围',
                                                             {initialValue:this.integration_indicators.business_scope }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    基于智能知识模型自动采集信息并进行综合分析的业务范围（-11~11）-->


                  <!--                                    基于智能知识模型自动采集信息并进行综合分析的业务范围（0 - 5）-->
                  <div v-if="this.enterprise_evaluate_type === 5" class="evaluate_input_box">
                    <a-row class="input_description_text">基于智能知识模型自动采集信息并进行综合分析的业务范围（0~5）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_five_mark"
                                  :min="0" :max="5" :step="1"
                                  v-decorator="['基于智能知识模型自动采集信息并进行综合分析的业务范围',
                                                             {initialValue:this.integration_indicators.business_scope }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    基于智能知识模型自动采集信息并进行综合分析的业务范围（0 - 5）-->


                </div>


                <!--                                右边栏-->
                <div class="col-md-6 evaluate_col_box">

                  <!--                                   信息系统运维投入占信息化总投入的比例（%） -->
                  <div
                      v-if="this.enterprise_evaluate_type === 1 || this.enterprise_evaluate_type === 2 || this.enterprise_evaluate_type === 3 || this.enterprise_evaluate_type === 4"
                      class="evaluate_input_box">
                    <a-row class="input_description_text">信息系统运维投入占信息化总投入的比例（%） ( 0 - 100 )</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="%" suffix="percent"
                                   v-decorator="['信息系统运维投入占信息化总投入的比例',
                                                             {initialValue:this.integration_indicators.maintenance_investment }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                   信息系统运维投入占信息化总投入的比例（%） -->


                  <!--                                   上传到信息系统的检化验数据占全部检化验数据的比例（%） -->
                  <div v-if="this.enterprise_evaluate_type === 5" class="evaluate_input_box">
                    <a-row class="input_description_text">上传到信息系统的检化验数据占全部检化验数据的比例（%） ( 0 - 100 )</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="%" suffix="percent"
                                   v-decorator="['上传到信息系统的检化验数据占全部检化验数据的比例',
                                                             {initialValue:this.integration_indicators.test_data_rate }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                   上传到信息系统的检化验数据占全部检化验数据的比例（%） -->


                  <!--                                   近五年信息化建设投入（万元） -->
                  <div v-if="this.enterprise_evaluate_type === 3 || this.enterprise_evaluate_type === 5"
                       class="evaluate_input_box">
                    <a-row class="input_description_text">近五年信息化建设投入（万元）</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="￥" suffix="万"
                                   v-decorator="['近五年信息化建设投入',
                                                             {initialValue:this.integration_indicators.info_inputmoney_five }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                   近五年信息化建设投入（万元）-->


                  <!--                                    应用信息化手段实现的安全生产重点部位、设备集中监控覆盖程度（0~5）-->
                  <div v-if="this.enterprise_evaluate_type === 5" class="evaluate_input_box">
                    <a-row class="input_description_text">应用信息化手段实现的安全生产重点部位、设备集中监控覆盖程度（0~5）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_five_mark"
                                  :min="0" :max="5" :step="1"
                                  v-decorator="['应用信息化手段实现的安全生产重点部位、设备集中监控覆盖程度',
                                                             {initialValue:this.integration_indicators.monitoring_coverage }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    应用信息化手段实现的安全生产重点部位、设备集中监控覆盖程度-->


                  <!--                                   	全员劳动生产率（%） -->
                  <div v-if="this.enterprise_evaluate_type === 4" class="evaluate_input_box">
                    <a-row class="input_description_text">全员劳动生产率（%） ( 0 - 100 )</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="%" suffix="percent"
                                   v-decorator="['全员劳动生产率',
                                                             {initialValue:this.integration_indicators.labor_productivity }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                   	全员劳动生产率（%） -->


                  <!--                                    实现信息化排产的最小排产单元（或生产线）数占最小排产单元（或生产线）总数的比例（%） ( 0 - 100 )-->
                  <div v-if="this.enterprise_evaluate_type === 2" class="evaluate_input_box">
                    <a-row class="input_description_text">实现信息化排产的最小排产单元（或生产线）数占最小排产单元（或生产线）总数的比例（%） ( 0 - 100 )</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="%" suffix="percent"
                                   v-decorator="['实现信息化排产的最小排产单元（或生产线）数占最小排产单元（或生产线）总数的比例',
                                                             {initialValue:this.integration_indicators.min_scheduling_unit }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                    实现信息化排产的最小排产单元（或生产线）数占最小排产单元（或生产线）总数的比例（%） ( 0 - 100 )-->

                  <!--                                  应用信息化手段进行环保管理实现的功能（0~3）  -->
                  <div v-if="this.enterprise_evaluate_type === 1" class="evaluate_input_box">
                    <a-row class="input_description_text">应用信息化手段进行环保管理实现的功能（0~3）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_three_mark"
                                  :min="0" :max="3" :step="1"
                                  v-decorator="['应用信息化手段进行环保管理实现的功能',
                                                             {initialValue:this.integration_indicators.environmental_management }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                  应用信息化手段进行环保管理实现的功能（0~3）-->


                  <!--                        混合行业特殊          应用信息化手段进行环保管理实现的功能（0~5）  -->
                  <div v-if="this.enterprise_evaluate_type === 5" class="evaluate_input_box">
                    <a-row class="input_description_text">应用信息化手段进行环保管理实现的功能（0~5）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_five_mark"
                                  :min="0" :max="5" :step="1"
                                  v-decorator="['应用信息化手段进行环保管理实现的功能',
                                                             {initialValue:this.integration_indicators.environmental_management }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                  应用信息化手段进行环保管理实现的功能（0~5）-->


                  <!--                                   应用信息化手段进行能源管理实现的功能（0~7） -->
                  <div
                      v-if="this.enterprise_evaluate_type === 1 || this.enterprise_evaluate_type === 2 || this.enterprise_evaluate_type === 3 "
                      class="evaluate_input_box">
                    <a-row class="input_description_text">应用信息化手段进行能源管理实现的功能（0~7）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_seven_mark"
                                  :min="0" :max="7" :step="1"
                                  v-decorator="['应用信息化手段进行能源管理实现的功能',
                                                             {initialValue:this.integration_indicators.energy_management }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    应用信息化手段进行能源管理实现的功能（0~7）-->


                  <!--                   服务行业特定                应用信息化手段进行能源管理实现的功能（0~5） -->
                  <div v-if="this.enterprise_evaluate_type === 4" class="evaluate_input_box">
                    <a-row class="input_description_text">应用信息化手段进行能源管理实现的功能（0~5）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_five_mark"
                                  :min="0" :max="5" :step="1"
                                  v-decorator="['应用信息化手段进行能源管理实现的功能',
                                                             {initialValue:this.integration_indicators.energy_management }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    服务行业特定                应用信息化手段进行能源管理实现的功能（0~5）-->


                  <!--                                    实现企业级统一的编码（0~10）-->
                  <div v-if="this.enterprise_evaluate_type === 4" class="evaluate_input_box">
                    <a-row class="input_description_text">实现企业级统一的编码（0~10）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_ten_mark"
                                  :min="0" :max="10" :step="1"
                                  v-decorator="['实现企业级统一的编码',
                                                             {initialValue:this.integration_indicators.enterprise_level_unified_coding }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    实现企业级统一的编码（0~10）-->


                  <!--                                   	社会贡献率（%） -->
                  <div class="evaluate_input_box" v-if="this.enterprise_evaluate_type !== 4">
                    <a-row class="input_description_text">社会贡献率（%） ( 0 - 100 )</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="%" suffix="percent"
                                   v-decorator="['社会贡献率',
                                                             {initialValue:this.integration_indicators.social_contribution }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                   	社会贡献率（%） -->


                  <!--                                通过信息化实现与产业链企业间业务协同情况（0~10）-->
                  <div v-if="this.enterprise_evaluate_type === 1 || this.enterprise_evaluate_type === 3 "
                       class="evaluate_input_box">
                    <a-row class="input_description_text">通过信息化实现与产业链企业间业务协同情况（0~10）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_ten_mark"
                                  :min="0" :max="10" :step="1"
                                  v-decorator="['通过信息化实现与产业链企业间业务协同情况',
                                                             {initialValue:this.integration_indicators.business_collaboration }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                 通过信息化实现与产业链企业间业务协同情况（0~10）-->


                  <!--      服务行业特定                          通过信息化实现与产业链企业间业务协同情况（0~5）-->
                  <div v-if="this.enterprise_evaluate_type === 4" class="evaluate_input_box">
                    <a-row class="input_description_text">通过信息化实现与产业链企业间业务协同情况（0~5）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_five_mark"
                                  :min="0" :max="5" :step="1"
                                  v-decorator="['通过信息化实现与产业链企业间业务协同情况',
                                                             {initialValue:this.integration_indicators.business_collaboration }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                 通过信息化实现与产业链企业间业务协同情况（0~10）-->


                  <!--                                    贯穿产品全生命周期各阶段的产品状态信息跟踪与反馈情况（0~5）-->
                  <div v-if="this.enterprise_evaluate_type === 1" class="evaluate_input_box">
                    <a-row class="input_description_text">贯穿产品全生命周期各阶段的产品状态信息跟踪与反馈情况（0~5）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_five_mark"
                                  :min="0" :max="5" :step="1"
                                  v-decorator="['贯穿产品全生命周期各阶段的产品状态信息跟踪与反馈情况',
                                                             {initialValue:this.integration_indicators.tracking_and_feedback }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    贯穿产品全生命周期各阶段的产品状态信息跟踪与反馈情况（0~5）-->

                  <!--                                    企业组织模式（0~9）-->
                  <div
                      v-if="this.enterprise_evaluate_type === 1 || this.enterprise_evaluate_type === 2 || this.enterprise_evaluate_type === 3 || this.enterprise_evaluate_type === 4 || this.enterprise_evaluate_type === 5"
                      class="evaluate_input_box">
                    <a-row class="input_description_text">企业组织模式（0~9）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_nine_mark"
                                  :min="0" :max="9" :step="1"
                                  v-decorator="['企业组织模式',
                                                             {initialValue:this.integration_indicators.organizational_model }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    企业组织模式（0~9）-->


                  <!--                                    经营管理系统向车间生产制造执行系统（或调度系统）自动下达指令包含内容（-5~5）-->
                  <div
                      v-if="this.enterprise_evaluate_type === 1 || this.enterprise_evaluate_type === 2 || this.enterprise_evaluate_type === 3"
                      class="evaluate_input_box">
                    <a-row class="input_description_text">经营管理系统向车间生产制造执行系统（或调度系统）自动下达指令包含内容（-5~5）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.minus_five_to_five_mark"
                                  :min="0" :max="10" :step="1" :tooltipVisible="false"
                                  v-decorator="['经营管理系统向车间生产制造执行系统（或调度系统）自动下达指令包含内容',
                                                             {initialValue:this.integration_indicators.auto_instruction_content }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    经营管理系统向车间生产制造执行系统（或调度系统）自动下达指令包含内容（-5~5）-->


                  <!--                     混合类型特殊               经营管理系统向车间生产制造执行系统（或调度系统）自动下达指令包含内容（-5~5）-->
                  <div v-if="this.enterprise_evaluate_type === 5" class="evaluate_input_box">
                    <a-row class="input_description_text">经营管理系统向车间生产制造执行系统（或调度系统）自动下达指令包含内容（-1~1）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.minus_one_to_one"
                                  :min="0" :max="2" :step="1" :tooltipVisible="false"
                                  v-decorator="['经营管理系统向车间生产制造执行系统（或调度系统）自动下达指令包含内容',
                                                             {initialValue:this.integration_indicators.auto_instruction_content }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    经营管理系统向车间生产制造执行系统（或调度系统）自动下达指令包含内容（-5~5）-->


                  <!--                                    生产制造过程控制系统向车间生产制造执行系统（或调度系统）自动上传信息覆盖范围-->
                  <div v-if="this.enterprise_evaluate_type === 2" class="evaluate_input_box">
                    <a-row class="input_description_text">生产制造过程控制系统向车间生产制造执行系统（或调度系统）自动上传信息覆盖范围（-5~5）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.minus_five_to_five_mark"
                                  :min="0" :max="10" :step="1" :tooltipVisible="false"
                                  v-decorator="['生产制造过程控制系统向车间生产制造执行系统（或调度系统）自动上传信息覆盖范围',
                                                             {initialValue:this.integration_indicators.auto_information_coverage }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    生产制造过程控制系统向车间生产制造执行系统（或调度系统）自动上传信息覆盖范围-->


                  <!--                                    车间生产制造执行系统（或调度系统）向生产制造过程控制系统自动下达指令情况（-5~5）-->
                  <div v-if="this.enterprise_evaluate_type === 2" class="evaluate_input_box">
                    <a-row class="input_description_text">车间生产制造执行系统（或调度系统）向生产制造过程控制系统自动下达指令情况（-5~5）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.minus_five_to_five_mark"
                                  :min="0" :max="10" :step="1" :tooltipVisible="false"
                                  v-decorator="['车间生产制造执行系统（或调度系统）向生产制造过程控制系统自动下达指令情况',
                                                             {initialValue:this.integration_indicators.auto_instruction_situation }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    车间生产制造执行系统（或调度系统）向生产制造过程控制系统自动下达指令情况（-5~5）-->


                  <!--                                    应用信息化手段开展物料需求计划管理情况（0~5）-->
                  <div v-if="this.enterprise_evaluate_type === 2 || this.enterprise_evaluate_type === 3"
                       class="evaluate_input_box">
                    <a-row class="input_description_text">应用信息化手段开展物料需求计划管理情况（0~5）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_five_mark"
                                  :min="0" :max="5" :step="1" :tooltipVisible="false"
                                  v-decorator="['应用信息化手段开展物料需求计划管理情况',
                                                             {initialValue:this.integration_indicators.material_requirements }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    应用信息化手段开展物料需求计划管理情况（0~5）-->

                  <!--                  混合类型特定                  应用信息化手段开展物料需求计划管理情况（0~10）-->
                  <div v-if="this.enterprise_evaluate_type === 5" class="evaluate_input_box">
                    <a-row class="input_description_text">应用信息化手段开展物料需求计划管理情况（0~10）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_ten_mark"
                                  :min="0" :max="10" :step="1" :tooltipVisible="false"
                                  v-decorator="['应用信息化手段开展物料需求计划管理情况',
                                                             {initialValue:this.integration_indicators.material_requirements }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    应用信息化手段开展物料需求计划管理情况（0~10）-->


                  <!--                                    应用信息化手段开展研发设计情况（0~5）-->
                  <div v-if="this.enterprise_evaluate_type === 2 || this.enterprise_evaluate_type === 3"
                       class="evaluate_input_box">
                    <a-row class="input_description_text">应用信息化手段开展研发设计情况（0~5）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_five_mark"
                                  :min="0" :max="5" :step="1" :tooltipVisible="false"
                                  v-decorator="['应用信息化手段开展研发设计情况',
                                                             {initialValue:this.integration_indicators.research_development }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    应用信息化手段开展物料需求计划管理情况（0~5）-->


                  <!--                                    应用信息化手段实现用户订单全过程跟踪情况（0~10）-->
                  <div v-if="this.enterprise_evaluate_type === 5" class="evaluate_input_box">
                    <a-row class="input_description_text"> 应用信息化手段实现用户订单全过程跟踪情况（0~10）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_ten_mark"
                                  :min="0" :max="10" :step="1"
                                  v-decorator="['应用信息化手段实现用户订单全过程跟踪情况',
                                                             {initialValue:this.integration_indicators.tracking_oforders }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    应用信息系统进行质量管理的覆盖范围（0~10）-->


                  <!--                                    是否建立了呼叫中心（0~1）-->
                  <div v-if="this.enterprise_evaluate_type === 4" class="evaluate_input_box">
                    <a-row class="input_description_text">是否建立了呼叫中心（0~1）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_one_mark"
                                  :min="0" :max="1" :step="1" :tooltipVisible="false"
                                  v-decorator="['是否建立了呼叫中心',
                                                             {initialValue:this.integration_indicators.call_center }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    是否建立了呼叫中心（0~1）-->

                  <!--                                    云平台使用情况（0~1）-->
                  <div v-if="this.enterprise_evaluate_type === 4" class="evaluate_input_box">
                    <a-row class="input_description_text">云平台使用情况（0~1）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_one_mark"
                                  :min="0" :max="1" :step="1" :tooltipVisible="false"
                                  v-decorator="['云平台使用情况',
                                                             {initialValue:this.integration_indicators.cloud_platform_usage }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    云平台使用情况（0~1）-->


                  <!--                                    应用信息系统进行内部供应链集成管理所覆盖的环节-->
                  <div v-if="this.enterprise_evaluate_type === 2" class="evaluate_input_box">
                    <a-row class="input_description_text">应用信息系统进行内部供应链集成管理所覆盖的环节（-6~6）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.minus_six_to_six"
                                  :min="0" :max="12" :step="1" :tooltipVisible="false"
                                  v-decorator="['应用信息系统进行内部供应链集成管理所覆盖的环节',
                                                             {initialValue:this.integration_indicators.integrated_management_cover }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    应用信息系统进行内部供应链集成管理所覆盖的环节-->


                  <!--                                    工业软件创新能力（0~3）-->
                  <div v-if="this.enterprise_evaluate_type === 2 || this.enterprise_evaluate_type === 3"
                       class="evaluate_input_box">
                    <a-row class="input_description_text">工业软件创新能力（0~3）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_three_mark"
                                  :min="0" :max="3" :step="1" :tooltipVisible="false"
                                  v-decorator="['工业软件创新能力',
                                                             {initialValue:this.integration_indicators.industrial_software_innovation }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    工业软件创新能力（0~3）-->

                  <!--                      混合行业特殊              工业软件创新能力（0~5）-->
                  <div v-if="this.enterprise_evaluate_type === 5" class="evaluate_input_box">
                    <a-row class="input_description_text">工业软件创新能力（0~5）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_five_mark"
                                  :min="0" :max="5" :step="1" :tooltipVisible="false"
                                  v-decorator="['工业软件创新能力',
                                                             {initialValue:this.integration_indicators.industrial_software_innovation }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    工业软件创新能力（0~3）-->


                  <!--                                    是否能够通过信息化对外协全过程进行监管（0 or1）-->
                  <div v-if="this.enterprise_evaluate_type === 3" class="evaluate_input_box">
                    <a-row class="input_description_text">是否能够通过信息化对外协全过程进行监管（0 or1）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_one_mark"
                                  :min="0" :max="1" :step="1"
                                  v-decorator="['是否能够通过信息化对外协全过程进行监管',
                                                             {initialValue:this.integration_indicators.info_monitor_outsourceing }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    是否能够通过信息化对外协全过程进行监管（0 or1）-->


                  <!--                                    产品模型数据定义情况（0~10）-->
                  <div v-if="this.enterprise_evaluate_type === 3" class="evaluate_input_box">
                    <a-row class="input_description_text">产品模型数据定义情况（0~10）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_ten_mark"
                                  :min="0" :max="10" :step="1"
                                  v-decorator="['产品模型数据定义情况',
                                                             {initialValue:this.integration_indicators.productmodel_define_data }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    产品模型数据定义情况（0~10）-->


                  <!--                                采购电子商务的应用范围（0~10）-->
                  <div v-if="this.enterprise_evaluate_type === 4" class="evaluate_input_box">
                    <a-row class="input_description_text">采购电子商务的应用范围（0~10）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_ten_mark"
                                  :min="0" :max="10" :step="1"
                                  v-decorator="['采购电子商务的应用范围',
                                                             {initialValue:this.integration_indicators.application_scope_of_purchasing_ecommerce }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                 采购电子商务的应用范围（0~10）-->


                  <!--                                    在线实现产品服务延伸或远程管控的情况（0~8）-->
                  <div v-if="this.enterprise_evaluate_type === 3" class="evaluate_input_box">
                    <a-row class="input_description_text">在线实现产品服务延伸或远程管控的情况（0~8）</a-row>
                    <a-form-item>
                      <a-col :span="16">
                        <a-slider :dots="true" :marks="slide_marks.zero_to_eight_mark"
                                  :min="0" :max="8" :step="1"
                                  v-decorator="['在线实现产品服务延伸或远程管控的情况',
                                                             {initialValue:this.integration_indicators.online_product_ext_recontrol }]"
                        />
                      </a-col>
                    </a-form-item>
                  </div>
                  <!--                                    在线实现产品服务延伸或远程管控的情况（0~8）-->


                </div>
                <!--                                右边栏-->


              </div>
            </a-form>


            <hr/>
            <!--                        确定按钮-->
            <button class="btn purple_color_btn center-block btn-getit btn_pick_text"
                    @click="integration_indicators_done">
              保存
            </button>
            <!--                        确定按钮-->


          </div>
        </b-card>
      </div>
    </div>
  </div>
</template>
<script>
import {mapGetters, mapMutations, mapActions} from 'vuex'
import miniToastr from 'mini-toastr'
import slide_marks from "./static_values_used/slider_mark";
import items_to_check from "@/views/credit/evaluate/static_values_used/integration_indicators_items_to_check";

export default {
  name: "integration_indicators_vue",
  computed: {
    ...mapGetters([
      "enterprise_evaluate_type",
      "current_process_step",
      "integration_indicators"
    ])
  },
  data() {
    return {
      form: this.$form.createForm(this),
      slide_marks: slide_marks
    }
  },
  methods: {
    ...mapMutations([
      "set_integration_indicators",
        "set_current_process_step"
    ]),

    //判断是否为数字
    isNum(val){
      var regPos = /^\d+(\.\d+)?$/; //非负浮点数
      var regNeg = /^(-(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*)))$/; //负浮点数
      if(regPos.test(val) || regNeg.test(val)){
        return true;
      }else{
        return false;
      }
    },

    get_enteprise_name_by_type_num() {
      if (this.enterprise_evaluate_type === 1) return '离散大批量行业'
      if (this.enterprise_evaluate_type === 2) return '流程行业'
      if (this.enterprise_evaluate_type === 3) return '离散中小批量行业'
      if (this.enterprise_evaluate_type === 4) return '服务行业'
      else return '混合行业'
    },


    // 完成了所有的填写
    integration_indicators_done() {
      //    TODO 先检查数据是否合法
      if(this.check_leagal()){
        // 没问题再更新store
        this.update_integration_indicators_store()
        this.set_current_process_step(this.current_process_step + 1)
        miniToastr.success("保存成功")
      }

    },


    // 检查输入的数据是否合法
    check_leagal() {
      let field_to_check = []
      if (this.enterprise_evaluate_type === 1) field_to_check = items_to_check.massDiscreteitems_to_check
      else if (this.enterprise_evaluate_type === 2) field_to_check = items_to_check.processIndustry_to_check
      else if (this.enterprise_evaluate_type === 3) field_to_check = items_to_check.smeDiscrete_to_check
      else if (this.enterprise_evaluate_type === 4) field_to_check = items_to_check.serviceTrade_to_check
      else field_to_check = items_to_check.mixedIndustry_to_check

      for (var field_to_check_item of field_to_check){
        if (!this.isNum(this.form.getFieldValue(field_to_check_item))){
          miniToastr.error("请填写数字： " + " " + field_to_check_item)
          return false
        }
        if (parseFloat(this.form.getFieldValue(field_to_check_item)) > 100){
          miniToastr.error( field_to_check_item + "  超出范围")
          return false
        }
      }

      return true
    },



    update_integration_indicators_store() {
      if (this.enterprise_evaluate_type === 1) this.massDiscrete_integration_indicators_finished()
      else if (this.enterprise_evaluate_type === 2) this.processIndustry_integration_indicators_finished()
      else if (this.enterprise_evaluate_type === 3) this.smeDiscrete_integration_indicators_finished()
      else if (this.enterprise_evaluate_type === 4) this.serviceTrade_integration_indicators_finished()
      else this.mixed_industry_integration_indicators_finished()
    },

    // 离散大批量行业的所有数据完成填写
    massDiscrete_integration_indicators_finished() {
      // 取过来
      let massDiscrete_integration_indicators_values = {...(this.integration_indicators)}

      //更新值
      massDiscrete_integration_indicators_values.on_time_delivery_rate = parseFloat(this.form.getFieldValue("按期交货率"))
      massDiscrete_integration_indicators_values.system_manage_level = parseFloat(this.form.getFieldValue("应用信息系统进行项目管理实现的功能与层级"))
      massDiscrete_integration_indicators_values.emergency_response = parseFloat(this.form.getFieldValue("信息化条件下安全生产应急响应及重大危险源预测预警情况"))
      massDiscrete_integration_indicators_values.budget_management = parseFloat(this.form.getFieldValue("通过信息化全面落实企业战略规划，实现全面预算管理的情况"))
      massDiscrete_integration_indicators_values.auto_instruction_content = parseFloat(this.form.getFieldValue("经营管理系统向车间生产制造执行系统（或调度系统）自动下达指令包含内容"))
      massDiscrete_integration_indicators_values.environmental_management = parseFloat(this.form.getFieldValue("应用信息化手段进行环保管理实现的功能"))
      massDiscrete_integration_indicators_values.energy_management = parseFloat(this.form.getFieldValue("应用信息化手段进行能源管理实现的功能"))
      massDiscrete_integration_indicators_values.social_contribution = parseFloat(this.form.getFieldValue("社会贡献率"))
      massDiscrete_integration_indicators_values.business_collaboration = parseFloat(this.form.getFieldValue("通过信息化实现与产业链企业间业务协同情况"))
      massDiscrete_integration_indicators_values.value_network_collaboration = parseFloat(this.form.getFieldValue("通过建立互联网开放社区实现价值网络协同情况"))
      massDiscrete_integration_indicators_values.tracking_and_feedback = parseFloat(this.form.getFieldValue("贯穿产品全生命周期各阶段的产品状态信息跟踪与反馈情况"))
      massDiscrete_integration_indicators_values.maintenance_investment = parseFloat(this.form.getFieldValue("信息系统运维投入占信息化总投入的比例"))
      massDiscrete_integration_indicators_values.organizational_model = parseFloat(this.form.getFieldValue("企业组织模式"))
      massDiscrete_integration_indicators_values.plan_implementation = parseFloat(this.form.getFieldValue("信息化规划执行情况"))
      massDiscrete_integration_indicators_values.decision_support = parseFloat(this.form.getFieldValue("综合运用信息化手段可实现的决策支持内容"))
      massDiscrete_integration_indicators_values.equipment_management = parseFloat(this.form.getFieldValue("应用信息化手段进行设备管理实现的功能与层级"))
      massDiscrete_integration_indicators_values.hr_management = parseFloat(this.form.getFieldValue("应用信息化手段进行人力资源管理实现的功能与层级"))


      //    存回去
      this.set_integration_indicators(massDiscrete_integration_indicators_values)

    },

    //processIndustry流程行业完成所有数据填写
    processIndustry_integration_indicators_finished() {
      //    取过来
      let processIndustry_integration = {...this.integration_indicators}

      //    更新值
      processIndustry_integration.system_manage_level = parseFloat(this.form.getFieldValue("应用信息系统进行项目管理实现的功能与层级"))
      processIndustry_integration.budget_management = parseFloat(this.form.getFieldValue("通过信息化全面落实企业战略规划，实现全面预算管理的情况"))
      processIndustry_integration.auto_upload_info_range = parseFloat(this.form.getFieldValue("车间生产制造执行系统（或调度系统）向经营管理系统自动上传信息范围"))
      processIndustry_integration.auto_instruction_content = parseFloat(this.form.getFieldValue("经营管理系统向车间生产制造执行系统（或调度系统）自动下达指令包含内容"))
      processIndustry_integration.auto_information_coverage = parseFloat(this.form.getFieldValue("生产制造过程控制系统向车间生产制造执行系统（或调度系统）自动上传信息覆盖范围"))
      processIndustry_integration.auto_instruction_situation = parseFloat(this.form.getFieldValue("车间生产制造执行系统（或调度系统）向生产制造过程控制系统自动下达指令情况"))
      processIndustry_integration.integrated_management_cover = parseFloat(this.form.getFieldValue("应用信息系统进行内部供应链集成管理所覆盖的环节"))
      processIndustry_integration.online_purchasing_rate = parseFloat(this.form.getFieldValue("网上采购率"))
      processIndustry_integration.min_scheduling_unit = parseFloat(this.form.getFieldValue("实现信息化排产的最小排产单元（或生产线）数占最小排产单元（或生产线）总数的比例"))
      processIndustry_integration.energy_management = parseFloat(this.form.getFieldValue("应用信息化手段进行能源管理实现的功能"))
      processIndustry_integration.social_contribution = parseFloat(this.form.getFieldValue("社会贡献率"))
      processIndustry_integration.business_collaboration = parseFloat(this.form.getFieldValue("通过信息化实现业务协同和一体化情况"))
      processIndustry_integration.info_exchange_and_sharing = parseFloat(this.form.getFieldValue("产业链企业之间信息交互和共享情况"))
      processIndustry_integration.value_network_collaboration = parseFloat(this.form.getFieldValue("通过建立互联网开放社区实现价值网络协同情况"))
      processIndustry_integration.green_development = parseFloat(this.form.getFieldValue("应用信息化手段实现产品全生命周期绿色发展的情况"))
      processIndustry_integration.maintenance_investment = parseFloat(this.form.getFieldValue("信息系统运维投入占信息化总投入的比例"))
      processIndustry_integration.organizational_model = parseFloat(this.form.getFieldValue("企业组织模式"))
      processIndustry_integration.plan_implementation = parseFloat(this.form.getFieldValue("信息化规划执行情况"))
      processIndustry_integration.material_requirements = parseFloat(this.form.getFieldValue("应用信息化手段开展物料需求计划管理情况"))
      processIndustry_integration.research_development = parseFloat(this.form.getFieldValue("应用信息化手段开展研发设计情况"))
      processIndustry_integration.business_scope = parseFloat(this.form.getFieldValue("基于智能知识模型自动采集信息并进行综合分析的业务范围"))
      processIndustry_integration.equipment_management = parseFloat(this.form.getFieldValue("应用信息化手段进行设备管理实现的功能与层级"))
      processIndustry_integration.hr_management = parseFloat(this.form.getFieldValue("应用信息化手段进行人力资源管理实现的功能与层级"))
      processIndustry_integration.industrial_software_innovation = parseFloat(this.form.getFieldValue("工业软件创新能力"))
      processIndustry_integration.output_value = parseFloat(this.form.getFieldValue("新产品产值率"))


      //    修改原先的值
      this.set_integration_indicators(processIndustry_integration)
    },

    //    离散中小型企业完成所有数据填写
    smeDiscrete_integration_indicators_finished() {
      //    取过来
      let smeDiscrete_integration = {...this.integration_indicators}
      console.log(smeDiscrete_integration)
      //    更新值
      smeDiscrete_integration.system_manage_level = parseFloat(this.form.getFieldValue("应用信息系统进行项目管理实现的功能与层级"))
      smeDiscrete_integration.budget_management = parseFloat(this.form.getFieldValue("财务系统对销售实时监控的情况"))
      smeDiscrete_integration.auto_upload_info_range = parseFloat(this.form.getFieldValue("经营管理系统向车间生产制造执行系统（或调度系统）自动下达指令包含内容"))
      smeDiscrete_integration.auto_instruction_content = parseFloat(this.form.getFieldValue("车间生产制造执行系统（或调度系统）向经营管理系统自动上传信息范围"))
      smeDiscrete_integration.auto_information_coverage = parseFloat(this.form.getFieldValue("应用信息系统进行质量管理的覆盖范围"))
      smeDiscrete_integration.auto_instruction_situation = parseFloat(this.form.getFieldValue("应用信息系统进行质量管理实现的功能"))
      smeDiscrete_integration.integrated_management_cover = parseFloat(this.form.getFieldValue("是否能够通过信息化对外协全过程进行监管"))
      smeDiscrete_integration.info_manage_energy = parseFloat(this.form.getFieldValue("应用信息化手段进行能源管理实现的功能"))
      smeDiscrete_integration.social_contribution_rate = parseFloat(this.form.getFieldValue("社会贡献率"))
      smeDiscrete_integration.info_cooperate_business = parseFloat(this.form.getFieldValue("通过信息化实现与产业链企业间业务协同情况"))
      smeDiscrete_integration.inter_realize_value_network_synergy = parseFloat(this.form.getFieldValue("通过建立互联网开放社区实现价值网络协同情况"))
      smeDiscrete_integration.online_product_ext_recontrol = parseFloat(this.form.getFieldValue("在线实现产品服务延伸或远程管控的情况"))
      smeDiscrete_integration.info_inputmoney_five = parseFloat(this.form.getFieldValue("近五年信息化建设投入"))
      smeDiscrete_integration.infosys_rate_info = parseFloat(this.form.getFieldValue("信息系统运维投入占信息化总投入的比例"))
      smeDiscrete_integration.total_assets_proequ = parseFloat(this.form.getFieldValue("当年企业生产设备总资产"))
      smeDiscrete_integration.organizational_model = parseFloat(this.form.getFieldValue("企业组织模式"))
      smeDiscrete_integration.info_plan_implement = parseFloat(this.form.getFieldValue("信息化规划执行情况"))
      smeDiscrete_integration.material_requirements = parseFloat(this.form.getFieldValue("应用信息化手段开展物料需求计划管理情况"))
      smeDiscrete_integration.research_development = parseFloat(this.form.getFieldValue("应用信息化手段开展研发设计情况"))
      smeDiscrete_integration.info_analyze_business_scope = parseFloat(this.form.getFieldValue("基于智能知识模型自动采集信息并进行综合分析的业务范围"))
      smeDiscrete_integration.equipment_management = parseFloat(this.form.getFieldValue("应用信息化手段进行设备管理实现的功能与层级"))
      smeDiscrete_integration.hr_management = parseFloat(this.form.getFieldValue("应用信息化手段进行人力资源管理实现的功能与层级"))
      smeDiscrete_integration.industrial_software_innovation = parseFloat(this.form.getFieldValue("工业软件创新能力"))
      smeDiscrete_integration.newproduct_develope_cycle = parseFloat(this.form.getFieldValue("新产品研发周期"))
      smeDiscrete_integration.patent_ownership_hundred = parseFloat(this.form.getFieldValue("百人专利拥有量"))
      smeDiscrete_integration.productmodel_define_data = parseFloat(this.form.getFieldValue("产品模型数据定义情况"))

      //    修改原先的值
      this.set_integration_indicators(smeDiscrete_integration)
    },

    //  服务行业
    serviceTrade_integration_indicators_finished() {
      //    取过来
      let serviceTrade_integration = {...this.integration_indicators}

      //    更新值
      serviceTrade_integration.system_manage_level = parseFloat(this.form.getFieldValue("应用信息系统进行项目管理实现的功能与层级"))
      serviceTrade_integration.call_center = parseFloat(this.form.getFieldValue("是否建立了呼叫中心"))
      serviceTrade_integration.budget_management = parseFloat(this.form.getFieldValue("通过信息化全面落实企业战略规划，实现全面预算管理的情况"))
      serviceTrade_integration.service_Integration = parseFloat(this.form.getFieldValue("服务业务管理与服务现场执行的集成情况"))
      serviceTrade_integration.online_purchasing_rate = parseFloat(this.form.getFieldValue("网上采购率"))
      serviceTrade_integration.application_scope_of_purchasing_ecommerce = parseFloat(this.form.getFieldValue("采购电子商务的应用范围"))
      serviceTrade_integration.labor_productivity = parseFloat(this.form.getFieldValue("全员劳动生产率"))
      serviceTrade_integration.energy_management = parseFloat(this.form.getFieldValue("应用信息化手段进行能源管理实现的功能"))
      serviceTrade_integration.business_collaboration = parseFloat(this.form.getFieldValue("通过信息化实现与产业链企业间业务协同情况"))
      serviceTrade_integration.info_exchange_and_sharing = parseFloat(this.form.getFieldValue("产业链企业之间信息交互和共享情况"))
      serviceTrade_integration.maintenance_investment = parseFloat(this.form.getFieldValue("信息系统运维投入占信息化总投入的比例"))
      serviceTrade_integration.enterprise_level_unified_coding = parseFloat(this.form.getFieldValue("实现企业级统一的编码"))
      serviceTrade_integration.organizational_model = parseFloat(this.form.getFieldValue("企业组织模式"))
      serviceTrade_integration.plan_implementation = parseFloat(this.form.getFieldValue("信息化规划执行情况"))
      serviceTrade_integration.decision_support = parseFloat(this.form.getFieldValue("综合运用信息化手段可实现的决策支持内容"))
      serviceTrade_integration.equipment_management = parseFloat(this.form.getFieldValue("应用信息化手段进行设备管理实现的功能与层级"))
      serviceTrade_integration.hr_management = parseFloat(this.form.getFieldValue("应用信息化手段进行人力资源管理实现的功能与层级"))
      serviceTrade_integration.cloud_platform_usage = parseFloat(this.form.getFieldValue("云平台使用情况"))


      //    修改原先的值
      this.set_integration_indicators(serviceTrade_integration)
    },

    //    混合类型
    mixed_industry_integration_indicators_finished() {
      //    取过来
      // let mixedIndustry_integration = {...this.integration_indicators}
      let mixedIndustry_integration = {}

      //    更新值
      mixedIndustry_integration.system_manage_level = parseFloat(this.form.getFieldValue("应用信息系统进行项目管理实现的功能与层级"))
      mixedIndustry_integration.test_data_rate = parseFloat(this.form.getFieldValue("上传到信息系统的检化验数据占全部检化验数据的比例"))
      mixedIndustry_integration.tracking_oforders = parseFloat(this.form.getFieldValue("应用信息化手段实现用户订单全过程跟踪情况"))
      mixedIndustry_integration.online_purchasing_rate = parseFloat(this.form.getFieldValue("网上采购率"))
      mixedIndustry_integration.monitoring_coverage = parseFloat(this.form.getFieldValue("应用信息化手段实现的安全生产重点部位、设备集中监控覆盖程度"))
      mixedIndustry_integration.auto_instruction_content = parseFloat(this.form.getFieldValue("经营管理系统向车间生产制造执行系统（或调度系统）自动下达指令包含内容"))
      mixedIndustry_integration.collection_of_energy_data = parseFloat(this.form.getFieldValue("能源数据自动采集上传比例"))
      mixedIndustry_integration.environmental_management = parseFloat(this.form.getFieldValue("应用信息化手段进行环保管理实现的功能"))
      mixedIndustry_integration.info_exchange_and_sharing = parseFloat(this.form.getFieldValue("产业链企业之间信息交互和共享情况"))
      mixedIndustry_integration.value_network_collaboration = parseFloat(this.form.getFieldValue("通过建立互联网开放社区实现价值网络协同情况"))
      mixedIndustry_integration.green_development = parseFloat(this.form.getFieldValue("应用信息化手段实现产品全生命周期绿色发展的情况"))
      mixedIndustry_integration.social_contribution = parseFloat(this.form.getFieldValue("社会贡献率"))
      mixedIndustry_integration.info_inputmoney_five = parseFloat(this.form.getFieldValue("近五年信息化建设投入"))
      mixedIndustry_integration.total_assets_proequ = parseFloat(this.form.getFieldValue("当年企业生产设备总资产"))
      mixedIndustry_integration.organizational_model = parseFloat(this.form.getFieldValue("企业组织模式"))
      mixedIndustry_integration.plan_implementation = parseFloat(this.form.getFieldValue("信息化规划执行情况"))
      mixedIndustry_integration.material_requirements = parseFloat(this.form.getFieldValue("应用信息化手段开展物料需求计划管理情况"))
      mixedIndustry_integration.business_scope = parseFloat(this.form.getFieldValue("基于智能知识模型自动采集信息并进行综合分析的业务范围"))
      mixedIndustry_integration.equipment_management = parseFloat(this.form.getFieldValue("应用信息化手段进行设备管理实现的功能与层级"))
      mixedIndustry_integration.hr_management = parseFloat(this.form.getFieldValue("应用信息化手段进行人力资源管理实现的功能与层级"))
      mixedIndustry_integration.industrial_software_innovation = parseFloat(this.form.getFieldValue("工业软件创新能力"))


      //    修改原先的值
      this.set_integration_indicators(mixedIndustry_integration)
    }
  }
}
</script>


<style type="text/css" scoped>
#integration_indicators_page {
  padding-top: 0;
}

.card-header {
  background-color: #fafafa;
  font-family: thin_font;
}

#color {
  height: 35px;
}

/deep/ .form-control:disabled {
  cursor: not-allowed;
}

.disabled {
  cursor: not-allowed;
}

.form-control:active, .input-group .form-control:hover {
  z-index: 1;
}

.input_description_text {
  text-align: left;
  font-size: 15px;
  font-family: thin_font;
}

.input_slider_and_frame_box {
  display: flex;
  align-items: center;
}


.evaluate_input_box {
  margin-top: 15px;
  display: flex;
  flex-direction: column;
}

.purple_color_btn {
  color: white;
  background-color: rgba(105, 0, 75, 0.7);
  border-color: rgba(105, 0, 75, 0.4);
  -webkit-box-shadow: 1px 1px 11px rgba(105, 0, 75, 0.5);
}

.btn-getit {
  border-radius: 20px;
  padding: 5px 17px;
}

.btn_pick_text {
  font-size: 15px;
  margin-top: 10px;
}

.evaluate_col_box {
  padding-left: 5%;
}
</style>
