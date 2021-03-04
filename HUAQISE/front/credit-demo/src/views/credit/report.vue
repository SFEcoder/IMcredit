<template>

  <div>
<!--    报告内容的最外面盒子-->
    <div class="report_board fang_song" id="report_content_biggest_box">
      <h1 class="text-center title_song "  style="padding-top: 75px; margin-bottom:50px;font-size: 35px;  ">两化融合评级报告</h1>
      <!--     前面的企业基本信息-->
      <div class="row offset-1">



        <!--          报告的第一列-->
        <div class="col-md-6 report_title_first_col">

          <div class="report-item">
            <span class="text-bold">主体企业名称：</span>
            <span >{{this.report_list[0]}}</span>
          </div>

          <div class="report-item">
            <span class="text-bold">评级结果： </span>
            <span>{{this.report_list[2]}}</span>
          </div>

          <div class="report-item">
            <span class="text-bold">所属行业： </span>
            <span>{{this.report_list[4]}}</span>
          </div>
        </div>

        <!--          报告的第二列-->
        <div class="col-md-6 " style="padding-right: 12%">
          <div class="report-item">
            <span class="text-bold">企业总分 ： </span>
            <span >{{this.report_list[1]}}</span>
          </div>

          <div class="report-item">
            <span class="text-bold">评级日期 ：</span>
            <span>{{this.report_list[3]}}</span>
          </div>
          <div class="report-item">
            <span class="text-bold">行业关键指标 ：</span>
            <span>{{this.report_list[5]}}</span>
          </div>
        </div>


      </div>

      <h2 class="text-center title_song" style="font-size: 28px;margin-top: 80px">评级观点</h2>

      <!--      财务指标评析部分-->
      <h3 class="text-center title_song report-sub-title" >财务指标评析</h3>


      <!--      图1-->
      <p class="text-center graph_intro" >图1：企业得分与行业排名情况</p>
      <p class="text-center" >(紫色标记该企业得分在行业中所处的位置）<br/>行业排名：<span class="text-bold">{{range_rate}}</span></p>
      <div ref="chart_one" class="chart"  ></div>

      <p class="text-center" style="margin: 0 auto">图2：企业财务指标得分及与总体平均分对比</p>
      <div ref="chart_two" class="chart"  ></div>




      <!--      财务指标评析报告的正文-->
      <div class="report-body-part" >

        <!--        第一段-->
        <div class="report-paragraph">
          <span class="text-bold">{{this.report_list[6]}}</span>
          <span>{{this.report_list[7]}}</span>
        </div>

        <!--        第二段-->
        <div class="report-paragraph">
          <span class="text-bold">{{this.report_list[8]}}</span>
          <span>{{this.report_list[9]}}</span>
          <span>{{this.report_list[10]}}</span>
          <span>{{this.report_list[11]}}</span>
          <span>{{this.report_list[12]}}</span>
          <span>{{this.report_list[13]}}</span>
        </div>

      </div>

      <!--    图3-->
      <p class="text-center graph_intro">图3：偿债能力—企业与行业平均水平</p>
      <div ref="chart_three" class="chart"  ></div>

      <div class="report-body-part" >
        <!--        第三段-->
        <div class="report-paragraph">
          <span class="text-bold">{{this.report_list[14]}}</span>
          <span >{{this.report_list[15]}}</span>
          <span >{{this.report_list[16]}}</span>
          <span >{{this.report_list[17]}}</span>
        </div>
      </div>

      <!--    图4-->
      <p class="text-center graph_intro" >图4：企业所处发展阶段分布情况</p>
      <div ref="chart_four" class="chart"  ></div>

      <!--    图5-->
      <p class="text-center graph_intro" style="margin-top: 80px" >图5：成长能力—企业与行业平均水平</p>
      <div ref="chart_five" class="chart"  ></div>


      <div class="report-body-part" >
        <!--        第四段-->
        <div class="report-paragraph">
          <span class="text-bold">{{this.report_list[18]}}</span>
          <span >{{this.report_list[19]}}</span>
          <span >{{this.report_list[20]}}</span>
          <span >{{this.report_list[21]}}</span>
          <span >{{this.report_list[22]}}</span>
          <span >{{this.report_list[23]}}</span>
        </div>
      </div>

      <!--    图6-->
      <p class="text-center graph_intro" >图6：盈利能力—企业与行业平均水平</p>
      <div ref="chart_six" class="chart"  ></div>


      <div class="report-body-part" >
        <!--        第五段-->
        <div class="report-paragraph">
          <span class="text-bold">{{this.report_list[24]}}</span>
          <span >{{this.report_list[25]}}</span>
          <span >{{this.report_list[26]}}</span>
          <span >{{this.report_list[27]}}</span>
          <span >{{this.report_list[28]}}</span>
          <span >{{this.report_list[29]}}</span>
          <span >{{this.report_list[30]}}</span>
        </div>
      </div>

      <!--    图7-->
      <p class="text-center graph_intro" >图7：营运能力—企业与行业平均水平</p>
      <div ref="chart_seven" class="chart"  ></div>



      <!--     两化融合程度评析部分 -->
      <h3 class="text-center title_song report-sub-title" style="margin-top: 120px">两化融合程度评析</h3>
      <div class="report-body-part" >

        <!--图8 （2-1）-->
        <p class="text-center graph_intro" >图 2-1：企业两化融合总分与行业排名情况</p>
        <p class="text-center" >(紫色标记该企业得分在行业中所处的位置）<br/>行业排名：<span class="text-bold">{{range_rate_liang}}</span></p>
        <div ref="chart_eight" class="chart"  ></div>

        <!--    图2-2 (9)-->
        <p class="text-center graph_intro" >图 2-2：企业两化融合一级指标得分与总体平均分对比</p>
        <div ref="chart_nine" class="chart"  ></div>


        <!--        第一段-->
        <div class="report-paragraph">
          <span class="text-bold">{{this.report_list[31]}}</span>
          <span>{{this.report_list[32]}}</span>
          <span>{{this.report_list[33]}}</span>
          <span>{{this.report_list[34]}}</span>
          <span>{{this.report_list[35]}}</span>
        </div>
      </div>


      <!--    图2-3 (10)-->
      <p class="text-center graph_intro" >图 2-3：供应链管理体系—企业与行业平均水平</p>
      <div ref="chart_ten" class="chart"></div>



      <div class="report-body-part" >

        <!--        第二段-->
        <div class="report-paragraph">
          <span class="text-bold">{{this.report_list[36]}}</span>
          <span>{{this.report_list[37]}}</span>
          <span>{{this.report_list[38]}}</span>
          <span>{{this.report_list[39]}}</span>
          <span>{{this.report_list[40]}}</span>
        </div>
      </div>

      <!--    图2-4 (11)-->
      <p class="text-center graph_intro" >图 2-4：行政管理体系—企业与行业平均水平</p>
      <div ref="chart_eleven" class="chart"></div>

      <div class="report-body-part" >
        <!--        第三段-->
        <div class="report-paragraph">
          <span class="text-bold">{{this.report_list[41]}}</span>
          <span>{{this.report_list[42]}}</span>
        </div>
      </div>

      <!--    图2-5 (12)-->
      <p class="text-center graph_intro" >图 2-5：信息化管理体系—企业与行业平均水平</p>
      <div ref="chart_twelve" class="chart"></div>

      <div class="report-body-part" >
        <!--        第四段-->
        <div class="report-paragraph">
          <span class="text-bold">{{this.report_list[43]}}</span>
          <span >{{this.report_list[44]}}</span>
          <span >{{this.report_list[45]}}</span>
          <span >{{this.report_list[46]}}</span>
          <span >{{this.report_list[47]}}</span>
        </div>
      </div>

      <!--    图2-6 (13)-->
      <p class="text-center graph_intro" >图 2-6：增值服务管理体系—企业与行业平均水平</p>
      <div ref="chart_thirteen" class="chart"></div>


      <div class="report-body-part" >

        <!--        第五段-->
        <div class="report-paragraph  last-paragraph">
          <span class="text-bold">{{this.report_list[48]}}</span>
        </div>


      </div>




    </div>

<!--    导出pdf的按钮-->
    <div id="downloadPdfBtnBox">
      <button id="downloadPdfBtn" class="fang_song text-bold" @click="export_pdf">导出 pdf</button>
    </div>

  </div>
</template>

<script>
    let Echarts = require('echarts'); //图表
    require("echarts/lib/component/markPoint");
    import {mapGetters, mapActions} from "vuex"
    import miniToastr from 'mini-toastr'


    export default {
      computed: {
        ...mapGetters([
            "report_list",
            "evaluate_grade_list",
            "financial_grade_display_list",
            "debt_grade_display_list",
            'dev_phrase_list',
            'growth_abailty_indexs_list',
            'gain_abailty_indexs_list',
            'operation_abailty_indexs_list',
            'enterprise_evaluate_type',
            'liang_hua_first_index_grade_list',
            'liang_hua_grade_list',
            'gong_ying_lian_guan_li_list',
            'xing_zheng_guan_li_list',
            'money_investment_list',
            'zen_zhi_fu_wu_list'
        ])
      },
      data() {
        return {

          //图一，柱状图，总分排名
          chart_one: null, //图标实例
          range_rate: '', //分数排名百分比
          range_rate_liang: '', //分数排名百分比，两化融合
          chart_one_options : {
            color: ["#cccccc"],
            tooltip: {
              trigger: 'item',
              axisPointer: {
                type:'line'
              },
              formatter: '得分：{c0}'
            },
            xAxis: {type: 'category'},
            yAxis: {type: 'value', name:'企业得分', axisLabel: {fontSize: 18},nameTextStyle:{fontSize :16, align:'right'}},
            animationDuration:3000,
            series: {
              data: [],
              type: 'bar',
            }
          },

          //图表二，柱状图，企业财务指标得分及与总体平均分对比
          chart_two: null,
          chart_two_options: {
            color: ["#69004B", "#cccccc"],
            tooltip: {
              trigger: 'item',
              axisPointer: {
                type:'line'
              },
              formatter: '得分：{c0}'
            },
            legend: {data: ['企业得分', '行业平均分'],textStyle: {fontSize: 18}, top:'bottom'},
            xAxis: {type: 'category', data:['回款能力', '偿债能力','成长能力','盈利能力','营运能力'],            axisLabel: {fontSize: 18},},
            yAxis: {type: 'value',            axisLabel: {fontSize: 18},},
            series: [
              {
                name:'企业得分',
                type:'bar'
              },
              {
                name:'行业平均分',
                type:'bar'
              }
            ]
          },

          //图表三，雷达图，偿债能力—企业与行业平均水平
          chart_three: null,
          chart_three_options: {
            color: ["#69004B", "#0066cc"],
            tooltip:{},
            legend: {
              data: ['企业水平', '行业平均水平'],
              textStyle: {fontSize: 18}, top:'bottom'},
            radar:{
              name: {textStyle: {color: 'rgb(105,0,75)'}, fontSize:18},
              indicator: [{ name: '资产负债率', max: 100}, { name: '流动比率', max: 100},  { name: '速动比率', max: 100}, { name: '经营活动产生的现金流量净额 / 流动负债', max: 100},{ name: '有形资产/负债合计', max: 100}]
            },
            series:{
              type:'radar',
              data:[
                {name:'企业水平',value:[]},
                {name:'行业平均水平', value:[] }
              ]
            }
          },

          //图表4， 饼图，企业所处发展阶段分布情况
          chart_four: null,
          chart_four_options: {
            tooltip: {trigger: 'item'},
            aria: {decal: {show: true}},
            legend: {textStyle: {fontSize: 18}, orient: 'vertical', left: 'left', top:'center'},
            series: [{
                name: '分布情况',
                type: 'pie',
                data:[{}, {},{}],
                emphasis: {itemStyle: {shadowBlur: 20, shadowOffsetX: 0, shadowColor: 'rgba(0, 0, 0, 0.5)'}},
                label: {fontSize: 18, color: 'rgb(105,0,75)'},
                labelLine: {length: 57}
              }]
          },

          chart_five: null,
          chart_five_options: {
            color: ["#69004B", "#0066cc"],
            tooltip:{},
            legend: {
              data: ['企业水平', '行业平均水平'],
              textStyle: {fontSize: 18}, top:'bottom'},
            radar:{
              name: {textStyle: {color: 'rgb(105,0,75)'}, fontSize:18},
              indicator: [{ name: '营业总收入（同比增长率）', max: 100}, { name: '利润总额（同比增长率）', max: 100},  { name: '总负债（同比增长率）', max: 100} ]
            },
            series:{
              type:'radar',
              data:[
                {name:'企业水平',value:[]},
                {name:'行业平均水平', value:[] }
              ]
            }
          },

          chart_six: null,
          chart_six_options: {
            color: ["#69004B", "#0066cc"],
            tooltip:{},
            legend: {
              data: ['企业水平', '行业平均水平'],
              textStyle: {fontSize: 18}, top:'bottom'},
            radar:{
              name: {textStyle: {color: 'rgb(105,0,75)'}, fontSize:18},
              indicator: [{ name: '净资产收益率ROE（加权）', max: 100}, { name: '销售净利率', max: 100},  { name: '销售毛利率', max: 100} ]
            },
            series:{
              type:'radar',
              data:[
                {name:'企业水平',value:[]},
                {name:'行业平均水平', value:[] }
              ]
            }
          },


          chart_seven: null,
          chart_seven_options: {
            color: ["#69004B", "#0066cc"],
            tooltip:{},
            legend: {
              data: ['企业水平', '行业平均水平'],
              textStyle: {fontSize: 18}, top:'bottom'},
            radar:{
              name: {textStyle: {color: 'rgb(105,0,75)'}, fontSize:18},
              indicator: [{ name: '财务费用/营业总收入', max: 100}, { name: '存货周转天数', max: 100},  { name: '流动资产周转率', max: 100} , { name: '应收账款周转率', max: 100}, { name: '已获利息倍数(EBIT/利息费用)', max: 100}]
            },
            series:{
              type:'radar',
              data:[
                {name:'企业水平',value:[]},
                {name:'行业平均水平', value:[] }
              ]
            }
          },

          chart_eight: null,
          chart_eight_options: {
            color: ["#cccccc"],
            tooltip: {
              trigger: 'item',
              axisPointer: {
                type:'line'
              },
              formatter: '得分：{c0}'
            },
            xAxis: {type: 'category'},
            yAxis: {type: 'value', name:'企业得分', axisLabel: {fontSize: 18},nameTextStyle:{fontSize :16, align:'right'}},
            animationDuration:3000,
            series: {
              data: [],
              type: 'bar',
            }
          },

          chart_nine: null,
          chart_nine_options: {
            color: ["#69004B", "#cccccc"],
            tooltip: {
              trigger: 'item',
              axisPointer: {
                type:'line'
              },
              formatter: '得分：{c0}'
            },
            legend: {data: ['企业得分', '行业平均分'],textStyle: {fontSize: 18}, top:'bottom'},
            xAxis: {type: 'category', data:[],            axisLabel: {fontSize: 18}},
            yAxis: {type: 'value',            axisLabel: {fontSize: 18},},
            series: [
              {
                name:'企业得分',
                type:'bar'
              },
              {
                name:'行业平均分',
                type:'bar'
              }
            ]
          },

          chart_ten: null,
          chart_ten_options: {
            color: ["#69004B", "#0066cc"],
            tooltip:{},
            legend: {
              data: ['企业水平', '行业平均水平'],
              textStyle: {fontSize: 18}, top:'bottom'},
            radar:{
              name: {textStyle: {color: 'rgb(105,0,75)'}, fontSize:18},
              indicator: []
            },
            series:{
              type:'radar',
              data:[
                {name:'企业水平',value:[]},
                {name:'行业平均水平', value:[] }
              ]
            }
          },

          chart_eleven: null,
          chart_eleven_options: {
            color: ["#69004B", "#0066cc"],
            tooltip:{},
            legend: {
              data: ['企业水平', '行业平均水平'],
              textStyle: {fontSize: 18}, top:'bottom'},
            radar:{
              name: {textStyle: {color: 'rgb(105,0,75)'}, fontSize:18},
              indicator: []
            },
            series:{
              type:'radar',
              data:[
                {name:'企业水平',value:[]},
                {name:'行业平均水平', value:[] }
              ]
            }
          },

          chart_twelve: null,
          chart_twelve_options: {
            color: ["#69004B", "#0066cc"],
            tooltip:{},
            legend: {
              data: ['企业水平', '行业平均水平'],
              textStyle: {fontSize: 18}, top:'bottom'},
            radar:{
              name: {textStyle: {color: 'rgb(105,0,75)'}, fontSize:18},
              indicator: []
            },
            series:{
              type:'radar',
              data:[
                {name:'企业水平',value:[]},
                {name:'行业平均水平', value:[] }
              ]
            }
          },

          chart_thirteen: null,
          chart_thirteen_options:{
            color: ["#69004B", "#0066cc"],
            tooltip:{},
            legend: {
              data: ['企业水平', '行业平均水平'],
              textStyle: {fontSize: 18}, top:'bottom'},
            radar:{
              name: {textStyle: {color: 'rgb(105,0,75)'}, fontSize:18},
              indicator: []
            },
            series:{
              type:'radar',
              data:[
                {name:'企业水平',value:[]},
                {name:'行业平均水平', value:[] }
              ]
            }
          }
        }
      },
      name: "report",
      mounted() {
        this.get_enterprise_report_text()

        //获取图1所需要的后台数据
        this.get_grade_all_list()
        //图2
        this.get_financial_grade_display_list()
        //图3
        this.get_debt_grade_display_list()
        //图4
        this.get_dev_phrase_list()
        //图5
        this.get_growth_abailty_indexs_list()
        //图6
        this.get_gain_abailty_indexs_list()
        //图7
        this.get_operation_abailty_indexs_list()
        //图 8 （2 - 1）
        this.get_liang_hua_grade_list()

        //图 9 （2 - 2）
        this.get_liang_hua_first_index_grade_list()

        //图10 （2 - 3）
        this.get_gong_ying_lian_guan_li_list()

        //图11 （2 - 4）
        this.get_xing_zheng_guan_li_list()

        //图12 （2 - 5）
        this.get_money_investment_list()

        //图13 （2 - 6）
        this.get_zen_zhi_fu_wu_list()

        //调整窗口大小时，改变图表的大小
        window.addEventListener('resize', () => {
          this.chart_one.resize();
          this.chart_two.resize();
          this.chart_three.resize();
          this.chart_four.resize();
          this.chart_five.resize();
          this.chart_six.resize();
          this.chart_seven.resize();
          this.chart_eight.resize();
          this.chart_nine.resize();
          this.chart_ten.resize();
          this.chart_eleven.resize();

        });
      },

      watch:{
        //图表1所需数据列表
        'evaluate_grade_list':function (){
          this.$nextTick(function (){
            this.load_chart_1()
          })
        },

      //  图表2所需数据列表
        'financial_grade_display_list':function (){
          this.$nextTick(function (){
            this.load_chart_2()
          })
        },

      //  图表3所需数据列表
        'debt_grade_display_list':function (){
          this.$nextTick(function (){
            this.load_chart_3()
          })
        },

      //  图表4所需要的数据列表
        'dev_phrase_list':function (){
          this.$nextTick(function (){
            this.load_chart_4()
          })
        },

        //图表5所需要的数据列表
        'growth_abailty_indexs_list':function (){
          this.$nextTick(function (){
            this.load_chart_5()
          })
        },

        'gain_abailty_indexs_list':function (){
          this.$nextTick(function (){
            this.load_chart_6()
          })
        },

        'operation_abailty_indexs_list':function (){
          this.$nextTick(function (){
            this.load_chart_7()
          })
        },



        'liang_hua_grade_list':function (){
          this.$nextTick(function (){
            this.load_chart_8()
          })
        },


        'liang_hua_first_index_grade_list': function (){
          this.$nextTick(function (){
            this.load_chart_9()
          })
        },

        'gong_ying_lian_guan_li_list':function (){
          this.$nextTick(function (){
            this.load_chart_10()
          })
        },

        'xing_zheng_guan_li_list':function (){
          this.$nextTick(function (){
            this.load_chart_11()
          })
        },

        'money_investment_list':function (){
          this.$nextTick(function (){
            this.load_chart_12()
          })
        },

        'zen_zhi_fu_wu_list':function (){
          this.$nextTick(function (){
            this.load_chart_13()
          })
        },




      },

      methods: {
        ...mapActions([
          "get_enterprise_report_text",
            "get_grade_all_list",
            "get_financial_grade_display_list",
            'get_debt_grade_display_list',
            'get_dev_phrase_list',
            'get_growth_abailty_indexs_list',
            'get_gain_abailty_indexs_list',
            'get_operation_abailty_indexs_list',
          'get_liang_hua_grade_list',
          'get_liang_hua_first_index_grade_list',
            'get_gong_ying_lian_guan_li_list',
            'get_xing_zheng_guan_li_list',
            'get_money_investment_list',
            'get_zen_zhi_fu_wu_list'
        ]),



        //加载图表1
        load_chart_1(){
          //初始化
          let curGrade = this.evaluate_grade_list[0]
          let grade_list = this.evaluate_grade_list.slice(0)
          grade_list.sort(function(a, b){return a - b})
          //给当前企业的数据显示特别的颜色
          let special_index = grade_list.indexOf(curGrade)
          grade_list[special_index] = {
            value: curGrade,
            itemStyle: {
              color: 'rgb(105,0,75)'
            }
          }
          this.chart_one_options.series.data = grade_list
          this.range_rate = (100 - special_index * 100 / grade_list.length).toFixed(2)  + '% (' + (grade_list.length- special_index ) + '/' + grade_list.length + ')'
          this.chart_one = Echarts.init(this.$refs.chart_one);
          this.chart_one.setOption(this.chart_one_options);
        },

      //  加载图表2
        load_chart_2(){
          this.chart_two_options.series[0].data = this.financial_grade_display_list.slice(0,5)
          this.chart_two_options.series[1].data = this.financial_grade_display_list.slice(5,10)
          this.chart_two = Echarts.init(this.$refs.chart_two);
          this.chart_two.setOption(this.chart_two_options)
        },

      //  加载图表3
        load_chart_3(){
          this.chart_three_options.series.data[0].value = this.debt_grade_display_list.slice(0,5)
          this.chart_three_options.series.data[1].value = this.debt_grade_display_list.slice(5,10)
          this.chart_three = Echarts.init(this.$refs.chart_three);
          this.chart_three.setOption(this.chart_three_options)
        },

      //  加载图表4
        load_chart_4(){
          this.chart_four_options.series[0].data [0] = {value: this.dev_phrase_list[0], name:'成长期'}
          this.chart_four_options.series[0].data [1] = {value: this.dev_phrase_list[1], name:'稳定期'}
          this.chart_four_options.series[0].data [2] = {value: this.dev_phrase_list[2], name:'衰退期'}
          this.chart_four = Echarts.init(this.$refs.chart_four);
          this.chart_four.setOption(this.chart_four_options)
        },


        load_chart_5(){
          this.chart_five_options.series.data[0].value = this.growth_abailty_indexs_list.slice(0,3)
          this.chart_five_options.series.data[1].value = this.growth_abailty_indexs_list.slice(3,6)
          this.chart_five = Echarts.init(this.$refs.chart_five);
          this.chart_five.setOption(this.chart_five_options)
        },

        load_chart_6(){
          this.chart_six_options.series.data[0].value = this.gain_abailty_indexs_list.slice(0,3)
          this.chart_six_options.series.data[1].value = this.gain_abailty_indexs_list.slice(3,6)
          this.chart_six = Echarts.init(this.$refs.chart_six);
          this.chart_six.setOption(this.chart_six_options)
        },

        load_chart_7(){
          this.chart_seven_options.series.data[0].value = this.operation_abailty_indexs_list.slice(0,5)
          this.chart_seven_options.series.data[1].value = this.operation_abailty_indexs_list.slice(5,10)
          this.chart_seven = Echarts.init(this.$refs.chart_seven);
          this.chart_seven.setOption(this.chart_seven_options)
        },

        load_chart_8(){
          let curGrade = this.liang_hua_grade_list[0]
          let grade_list = this.liang_hua_grade_list.slice(0)
          grade_list.sort(function(a, b){return a - b})
          //给当前企业的数据显示特别的颜色
          let special_index = grade_list.indexOf(curGrade)
          grade_list[special_index] = {
            value: curGrade,
            itemStyle: {
              color: 'rgb(105,0,75)'
            }
          }
          this.chart_eight_options.series.data = grade_list

          this.range_rate_liang = (100 - special_index * 100 / grade_list.length).toFixed(2) + '% (' + (grade_list.length- special_index ) + '/' + grade_list.length + ')'
          this.chart_eight = Echarts.init(this.$refs.chart_eight);
          this.chart_eight.setOption(this.chart_eight_options);
        },

        load_chart_9(){
          if(this.enterprise_evaluate_type === 2 || this.enterprise_evaluate_type === 3){//流程行业 || 离散中小
            this.chart_nine_options.xAxis.data = ['供应链管理', '增值服务管理', '信息化管理', '行政管理', '研发管理']
            this.chart_nine_options.series[0].data = this.liang_hua_first_index_grade_list.slice(0,5)
            this.chart_nine_options.series[1].data = this.liang_hua_first_index_grade_list.slice(5,10)
          }
          else{//其它
            this.chart_nine_options.xAxis.data = ['供应链管理', '增值服务管理', '信息化管理', '行政管理']
            this.chart_nine_options.series[0].data = this.liang_hua_first_index_grade_list.slice(0,4)
            this.chart_nine_options.series[1].data = this.liang_hua_first_index_grade_list.slice(4,8)
          }
          this.chart_nine = Echarts.init(this.$refs.chart_nine)
          this.chart_nine.setOption(this.chart_nine_options)
        },

        load_chart_10(){
          if(this.enterprise_evaluate_type === 1 || this.enterprise_evaluate_type === 3) {//离散大 || 离散中小
            if(this.enterprise_evaluate_type === 1) this.chart_ten_options.radar.indicator = [{ name: '质量提升', max: 100}, { name: '项目管理', max: 100},  { name: '安全管理', max: 100}, { name: '财务与业务集成', max: 100},{ name: '管理与控制集成', max: 100}]
            else this.chart_ten_options.radar.indicator = [{ name: '项目管理', max: 100}, { name: '财务与业务集成', max: 100},  { name: '管理与控制集成', max: 100}, { name: '质量与计量', max: 100},{ name: '生产制造', max: 100}]
            this.chart_ten_options.series.data[0].value = this.gong_ying_lian_guan_li_list.slice(0,5)
            this.chart_ten_options.series.data[1].value = this.gong_ying_lian_guan_li_list.slice(5,10)
          }
          else{
            if(this.enterprise_evaluate_type === 2)this.chart_ten_options.radar.indicator = [{ name: '项目管理', max: 100}, { name: '财务与业务集成', max: 100},  { name: '管理与控制集成', max: 100}, { name: '产供销集成', max: 100},{ name: '采购管理', max: 100},{ name: '生产制造', max: 100}]
            else if(this.enterprise_evaluate_type === 4)this.chart_ten_options.radar.indicator = [{ name: '项目管理', max: 100}, { name: '销售管理', max: 100},  { name: '财务与业务集成', max: 100}, { name: '产供销集成', max: 100},{ name: '采购管理', max: 100},{ name: '业务效率', max: 100}]
            else this.chart_ten_options.radar.indicator = [{ name: '项目管理', max: 100}, { name: '质量与计量', max: 100},  { name: '产供销集成', max: 100}, { name: '采购管理', max: 100},{ name: '安全管理', max: 100},{ name: '管理与控制集成', max: 100}]
            this.chart_ten_options.series.data[0].value = this.gong_ying_lian_guan_li_list.slice(0,6)
            this.chart_ten_options.series.data[1].value = this.gong_ying_lian_guan_li_list.slice(6,12)
          }
          this.chart_ten = Echarts.init(this.$refs.chart_ten);
          this.chart_ten.setOption(this.chart_ten_options)
        },

        load_chart_11(){
          if(this.enterprise_evaluate_type === 1)this.chart_eleven_options.radar.indicator =  [{ name: '组织规划', max: 100}, { name: '决策支持', max: 100},  { name: '设备管理', max: 100}, { name: '人力资源管理', max: 100}]
          else this.chart_eleven_options.radar.indicator =  [{ name: '组织规划', max: 100}, { name: '决策支持', max: 100},  { name: '设备管理', max: 100}, { name: '人力资源管理', max: 100}, { name: '设备设施', max: 100}]
          this.chart_eleven_options.series.data[0].value = this.xing_zheng_guan_li_list.slice(0,5)
          this.chart_eleven_options.series.data[1].value = this.xing_zheng_guan_li_list.slice(5,10)
          this.chart_eleven = Echarts.init(this.$refs.chart_eleven);
          this.chart_eleven.setOption(this.chart_eleven_options)
        },

        load_chart_12(){
          if(this.enterprise_evaluate_type === 3){
            this.chart_twelve_options.radar.indicator =  [{ name: '近五年信息化建设投入', max: 100}, { name: '信息系统运维投入占信息化总投入的比例', max: 100},  { name: '当年企业生产设备总资产', max: 100}]
            this.chart_twelve_options.series.data[0].value = this.money_investment_list.slice(0,3)
            this.chart_twelve_options.series.data[1].value = this.money_investment_list.slice(3,6)
          }
          else if(this.enterprise_evaluate_type === 5){
            this.chart_twelve_options.series.data[0].value = this.money_investment_list.slice(0,2)
            this.chart_twelve_options.series.data[1].value = this.money_investment_list.slice(2,4)
          }
          else{
            this.chart_twelve_options.radar.indicator =  [{ name: '信息系统运维投入占信息化总投入的比例', max: 100},  { name: '当年企业生产设备总资产', max: 100}]

            this.chart_twelve_options.series.data[0].value = this.money_investment_list.slice(0,1)
              this.chart_twelve_options.series.data[1].value = this.money_investment_list.slice(1,2)
          }
          this.chart_twelve = Echarts.init(this.$refs.chart_twelve);
          this.chart_twelve.setOption(this.chart_twelve_options)

        },

        load_chart_13(){
          if(this.enterprise_evaluate_type === 4){
            this.chart_thirteen_options.radar.indicator =  [{ name: '能源与环保', max: 100}, { name: '产业链协同', max: 100}]
            this.chart_twelve_options.series.data[0].value = this.money_investment_list.slice(0,2)
            this.chart_twelve_options.series.data[1].value = this.money_investment_list.slice(2,4)
          }
          else{
            this.chart_thirteen_options.radar.indicator =  [{ name: '能源与环保', max: 100}, { name: '产品协同创新', max: 100},  { name: '产业链协同', max: 100},  { name: '社会贡献率', max: 100}]
            this.chart_twelve_options.series.data[0].value = this.money_investment_list.slice(0,4)
            this.chart_twelve_options.series.data[1].value = this.money_investment_list.slice(4,8)
          }
          this.chart_thirteen = Echarts.init(this.$refs.chart_thirteen);
          this.chart_thirteen.setOption(this.chart_eleven_options)
        },




      //  导出pdf
        export_pdf(){
          miniToastr.success("请稍后……","pdf报告导出中：")
          setTimeout(()=>{          miniToastr.success("生成成功","正在下载……")
          }, 1800)
          this.getPdf('report_content_biggest_box', "两化融合评级报告")
        }

      }
    }
</script>

<style scoped>

    /*报告的正文盒子*/
    .report-body-part{
        margin-left: 3.5em;
        margin-right: 2.5em;
    }

    .report_title_first_col{
      padding-left: 7%;
    }

    /*报告副标题*/
    .report-sub-title{
      margin-bottom: 24px;
      margin-top: 50px
    }


    /*报告正文段落*/
    .report-paragraph{
      text-indent: 2em;
      line-height: 1.8em;
      margin-bottom: 1em;
    }
    .report_board {
        line-height :  31.5px ;
        /*line-height的值为font-size的1.5倍，即1.5倍行距，使用line-height: 1.5效果相同;*/
        text-align : justify ;
        background-color: white;
         color: black;
        font-size: 21px;
    /*    */
    }

    .text-bold{
        font-weight: bold;
    }

    .report-item{
        margin-bottom: 10.5px
    }


    .last-paragraph{
      padding-bottom: 60px;
    }

    .chart{
      height: 450px; width: 80%;margin: 0 auto 40px auto;
    }

    .graph_intro{
      margin: 40px auto 0px auto;
    }

    #downloadPdfBtnBox{
      display: flex;
      justify-content: center;
    }
    #downloadPdfBtn{
      text-align: center;
      background-color: rgba(105,0,75,0.7);
      border: rgba(105,0,75,0.7) solid 1px;
      padding :6px 40px;
      margin-bottom: 30px;
      border-bottom-left-radius: 50px;
      border-bottom-right-radius: 50px;
      border-top-right-radius: 50px;
      border-top-left-radius: 50px;
      color: #ebf2f6;
      outline:none;
      font-size: 20px;
    }
</style>