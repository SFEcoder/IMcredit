<template>
  <div id="integration_indicators_page">
    <div class="row">
      <div class="col-lg-12">
        <b-card class="mb-2" :header="'财务指标' + ' —— '+ get_enteprise_name_by_type_num()" header-tag="h4">
          <div>
            <a-form
                :form="form"
            >
              <div class="row">

                <!--                                左边栏-->
                <div class="col-md-6 evaluate_col_box">


                  <!--                                    经营活动产生的现金流量净额/经营活动净收益(TTM) ttm-->
                  <div class="evaluate_input_box">
                    <a-row class="input_description_text">经营活动产生的现金流量净额/经营活动净收益(TTM)</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="%" suffix="percent"
                                   v-decorator="['经营活动产生的现金流量净额/经营活动净收益(TTM)',
                                                             {initialValue:this.financial_index.ttm }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                    经营活动产生的现金流量净额/经营活动净收益(TTM) ttm-->


                  <!--                                    流动比率-->
                  <div class="evaluate_input_box">
                    <a-row class="input_description_text">流动比率</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="%" suffix="percent"
                                   v-decorator="['流动比率',
                                                             {initialValue:this.financial_index.current_ratio }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                    流动比率-->


                  <!--                                    速动比率-->
                  <div class="evaluate_input_box">
                    <a-row class="input_description_text">速动比率</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="%" suffix="percent"
                                   v-decorator="['速动比率',
                                                             {initialValue:this.financial_index.quick_ratio }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                    速动比率-->


                  <!--                                    经营活动产生的现金流量净额/流动负债-->
                  <div class="evaluate_input_box">
                    <a-row class="input_description_text">经营活动产生的现金流量净额/流动负债</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="%" suffix="percent"
                                   v-decorator="['经营活动产生的现金流量净额/流动负债',
                                                             {initialValue:this.financial_index.cf_cl }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                    经营活动产生的现金流量净额/流动负债-->

                  <!--                                    有形资产/负债合计-->
                  <div class="evaluate_input_box">
                    <a-row class="input_description_text">有形资产/负债合计</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="%" suffix="percent"
                                   v-decorator="['有形资产/负债合计',
                                                             {initialValue:this.financial_index.ttal }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                    有形资产/负债合计-->


                  <!--                                    营业总收入(同比增长率)-->
                  <div class="evaluate_input_box">
                    <a-row class="input_description_text">营业总收入(同比增长率)</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="%" suffix="percent"
                                   v-decorator="['营业总收入(同比增长率)',
                                                             {initialValue:this.financial_index.operating_revenue }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                    营业总收入(同比增长率)-->


                  <!--                                    利润总额(同比增长率)-->
                  <div class="evaluate_input_box">
                    <a-row class="input_description_text">利润总额(同比增长率)</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="%" suffix="percent"
                                   v-decorator="['利润总额(同比增长率)',
                                                             {initialValue:this.financial_index.total_profit }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                    利润总额(同比增长率)-->


                  <!--                                    总负债(同比增长率)-->
                  <div class="evaluate_input_box">
                    <a-row class="input_description_text">总负债(同比增长率)</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="%" suffix="percent"
                                   v-decorator="['总负债(同比增长率)',
                                                             {initialValue:this.financial_index.total_liabilities }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                    总负债(同比增长率)-->

                  <!--                                   资产负债率 -->
                  <div class="evaluate_input_box">
                    <a-row class="input_description_text">资产负债率</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="%" suffix="percent"
                                   v-decorator="['资产负债率',
                                                             {initialValue:this.financial_index.debt_ratio }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                   资产负债率  -->


                </div>


                <!--                                右边栏-->
                <div class="col-md-6 evaluate_col_box">


                  <!--                                   净资产收益率ROE(加权) -->
                  <div class="evaluate_input_box">
                    <a-row class="input_description_text">净资产收益率ROE(加权)</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="%" suffix="percent"
                                   v-decorator="['净资产收益率ROE(加权)',
                                                             {initialValue:this.financial_index.roe }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                   净资产收益率ROE(加权)  -->


                  <!--                                   销售净利率 -->
                  <div class="evaluate_input_box">
                    <a-row class="input_description_text">销售净利率</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="%" suffix="percent"
                                   v-decorator="['销售净利率',
                                                             {initialValue:this.financial_index.profit_rate }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                   销售净利率  -->


                  <!--                                   销售毛利率 -->
                  <div class="evaluate_input_box">
                    <a-row class="input_description_text">销售毛利率</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="%" suffix="percent"
                                   v-decorator="['销售毛利率',
                                                             {initialValue:this.financial_index.gross_profit }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                   销售毛利率  -->


                  <!--                                   财务费用/营业总收入 -->
                  <div class="evaluate_input_box">
                    <a-row class="input_description_text">财务费用/营业总收入</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="%" suffix="percent"
                                   v-decorator="['财务费用/营业总收入',
                                                             {initialValue:this.financial_index.fe_rev }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                   财务费用/营业总收入  -->


                  <!--                                   存货周转天数 -->
                  <div class="evaluate_input_box">
                    <a-row class="input_description_text">存货周转天数</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="%" suffix="percent"
                                   v-decorator="['存货周转天数',
                                                             {initialValue:this.financial_index.turnover_days }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                   存货周转天数  -->


                  <!--                                   流动资产周转率 -->
                  <div class="evaluate_input_box">
                    <a-row class="input_description_text">流动资产周转率</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="%" suffix="percent"
                                   v-decorator="['流动资产周转率',
                                                             {initialValue:this.financial_index.current_assets }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                   流动资产周转率  -->


                  <!--                                   应收账款周转率 -->
                  <div class="evaluate_input_box">
                    <a-row class="input_description_text">应收账款周转率</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="%" suffix="percent"
                                   v-decorator="['应收账款周转率',
                                                             {initialValue:this.financial_index.accounts_receivable }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                   应收账款周转率  -->


                  <!--                                   已获利息倍数(EBIT/利息费用)  -->
                  <div class="evaluate_input_box">
                    <a-row class="input_description_text">已获利息倍数(EBIT/利息费用)</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="%" suffix="percent"
                                   v-decorator="['已获利息倍数(EBIT/利息费用)',
                                                             {initialValue:this.financial_index.ebit_rev }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                   已获利息倍数(EBIT/利息费用)   -->


                  <!--                                   行业景气指数 -->
                  <div class="evaluate_input_box">
                    <a-row class="input_description_text">行业景气指数</a-row>
                    <a-row>
                      <a-col :span="16">
                        <a-form-item>
                          <a-input prefix="%" suffix="percent"
                                   v-decorator="['行业景气指数',
                                                             {initialValue:this.financial_index.industry_prosperity }]"
                          />
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <!--                                   行业景气指数-->


                </div>
                <!--                                右边栏-->


              </div>
            </a-form>


            <hr/>
            <!--                        确定按钮-->
            <button class="btn purple_color_btn center-block btn-getit btn_pick_text" @click="financial_index_done">
              提交数据， 完成测评
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
import items_to_check from "@/views/credit/evaluate/static_values_used/financial_index_items_to_check";

export default {
  name: "integration_indicators_vue",
  computed: {
    ...mapGetters([
      "enterprise_evaluate_type",
      "current_process_step",
      "financial_index"
    ])
  },
  data() {
    return {
      form: this.$form.createForm(this),
    }
  },
  methods: {
    ...mapMutations([
      "set_financial_index",
      "set_current_process_step"
    ]),
    ...mapActions([
        "upload_evaluate_index"
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

    // 检查输入的数据是否合法
    check_leagal() {
      let field_to_check = items_to_check
      for (var field_to_check_item of field_to_check) {
        if (!this.isNum(this.form.getFieldValue(field_to_check_item))) {
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

    get_enteprise_name_by_type_num() {
      if (this.enterprise_evaluate_type === 1) return '离散大批量行业'
      if (this.enterprise_evaluate_type === 2) return '流程行业'
      if (this.enterprise_evaluate_type === 3) return '离散中小批量行业'
      if (this.enterprise_evaluate_type === 4) return '服务行业'
      else return '混合行业'
    },

    // 完成了所有的填写
    financial_index_done() {
      // 更新store
      if (this.check_leagal()){
        this.update_financial_index_input_value()
        this.upload_evaluate_index()
        this.set_current_process_step(this.current_process_step + 1)
      }
    },

    // 数据完成填写
    update_financial_index_input_value() {
      // 取过来
      let new_financial_index_values = {...(this.financial_index)}

      //更新值
      new_financial_index_values.ttm = parseFloat(this.form.getFieldValue("经营活动产生的现金流量净额/经营活动净收益(TTM)"))
      new_financial_index_values.debt_ratio = parseFloat(this.form.getFieldValue("资产负债率"))
      new_financial_index_values.current_ratio = parseFloat(this.form.getFieldValue("流动比率"))
      new_financial_index_values.quick_ratio = parseFloat(this.form.getFieldValue("速动比率"))
      new_financial_index_values.cf_cl = parseFloat(this.form.getFieldValue("经营活动产生的现金流量净额/流动负债"))
      new_financial_index_values.ttal = parseFloat(this.form.getFieldValue("有形资产/负债合计"))
      new_financial_index_values.operating_revenue = parseFloat(this.form.getFieldValue("营业总收入(同比增长率)"))
      new_financial_index_values.total_profit = parseFloat(this.form.getFieldValue("利润总额(同比增长率)"))
      new_financial_index_values.total_liabilities = parseFloat(this.form.getFieldValue("总负债(同比增长率)"))
      new_financial_index_values.roe = parseFloat(this.form.getFieldValue("净资产收益率ROE(加权)"))
      new_financial_index_values.profit_rate = parseFloat(this.form.getFieldValue("销售净利率"))
      new_financial_index_values.gross_profit = parseFloat(this.form.getFieldValue("销售毛利率"))
      new_financial_index_values.fe_rev = parseFloat(this.form.getFieldValue("财务费用/营业总收入"))
      new_financial_index_values.turnover_days = parseFloat(this.form.getFieldValue("存货周转天数"))
      new_financial_index_values.current_assets = parseFloat(this.form.getFieldValue("流动资产周转率"))
      new_financial_index_values.accounts_receivable = parseFloat(this.form.getFieldValue("应收账款周转率"))
      new_financial_index_values.ebit_rev = parseFloat(this.form.getFieldValue("已获利息倍数(EBIT/利息费用)"))
      new_financial_index_values.industry_prosperity = parseFloat(this.form.getFieldValue("行业景气指数"))


      //    修改值
      this.set_financial_index(new_financial_index_values)

    }
  },
  mounted() {

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
  padding-left: 7%;
}
</style>
