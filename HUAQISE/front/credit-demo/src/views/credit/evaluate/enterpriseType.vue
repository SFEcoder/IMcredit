<template>
    <div>
        <div class="row">
            <!--      标题-->
            <div class="col-lg-12 col-sm-12 text-center">
                <h3 class="plan-desc thin_font"><strong>请选择企业类型</strong></h3>
            </div>
            <!--      标题-->

            <div class="col-lg-10 offset-lg-1 ">
                <div class="row">

                    <!--          流程行业-->
                    <div class="col-md-4 text-center">
                        <div class="standard modal-1">
                            <!--                            右上角的选中标签-->
                            <div class="enterprise_type_picked_tag" v-show="this.enterprise_evaluate_type === 2">
                                <div class="tag-design text-white">已选择</div>
                            </div>
                            <!--                            右上角的选中标签-->

                            <div class="pack-heading">
                                <h4 class="pack-title purple_color thin_font "><strong>流程行业</strong></h4>
                                <div class="pack-price purple_color_btn transparent_effect"><span
                                        class="text-white">PI</span></div>
                            </div>
                            <ul class="pack-details list-unstyled">
                                <li>通过对原材料物理形状的改变、组装</li>
                                <li>成为产品, 使其增值</li>
                                <li>同时，产品是标准或少数选配需求主要靠预测</li>
                                <li>需求主要靠预测，也考虑订单</li>
                                <li>生产是以物料为对象组成一条条流水生产线</li>
                            </ul>
                            <button class="btn purple_color_btn center-block btn-getit btn_pick_text"
                                    @click="start_btn_clicked('流程行业')">start now
                            </button>
                        </div>
                    </div>
                    <!--          流程行业-->

                    <!--          服务行业-->
                    <div class="col-md-4 text-center">
                        <div class="standard modal-1">

<!--                            右上角的选中标签-->
                            <div class="enterprise_type_picked_tag" v-if="enterprise_evaluate_type === 4">
                                <div class="tag-design text-white">已选择</div>
                            </div>
<!--                            右上角的选中标签-->

                            <div class="pack-heading">
                                <h4 class="pack-title purple_color thin_font "><strong>服务行业</strong></h4>
                                <div class="pack-price purple_color_btn transparent_effect"><span
                                        class="text-white">STI</span></div>
                            </div>
                            <ul class="pack-details list-unstyled">
                                <li>通过对原材料物理形状的改变、组装</li>
                                <li>成为产品, 使其增值</li>
                                <li>同时，产品是标准或少数选配需求主要靠预测</li>
                                <li>需求主要靠预测，也考虑订单</li>
                                <li>生产是以物料为对象组成一条条流水生产线</li>
                            </ul>
                            <button class="btn purple_color_btn center-block btn-getit btn_pick_text"
                                    @click="start_btn_clicked('服务行业')">start now
                            </button>
                        </div>
                    </div>
                    <!--            服务行业-->




                    <!--          混合行业-->
                    <div class="col-md-4 text-center">
                        <div class="standard modal-1">
                            <!--                            右上角的选中标签-->
                            <div class="enterprise_type_picked_tag" v-if="enterprise_evaluate_type === 5">
                                <div class="tag-design text-white">已选择</div>
                            </div>
                            <!--                            右上角的选中标签-->
                            <div class="pack-heading">
                                <h4 class="pack-title purple_color thin_font "><strong>混合行业</strong></h4>
                                <div class="pack-price purple_color_btn transparent_effect"><span
                                        class="text-white">MI</span></div>
                            </div>
                            <ul class="pack-details list-unstyled">
                                <li>通过对原材料物理形状的改变、组装</li>
                                <li>成为产品, 使其增值</li>
                                <li>同时，产品是标准或少数选配需求主要靠预测</li>
                                <li>需求主要靠预测，也考虑订单</li>
                                <li>生产是以物料为对象组成一条条流水生产线</li>
                            </ul>
                            <button class="btn purple_color_btn center-block btn-getit btn_pick_text"
                                    @click="start_btn_clicked('混合行业')">start now
                            </button>
                        </div>
                    </div>
                    <!--          混合行业-->

                </div>

                <div class="row ">

                    <!--          离散大批量-->
                    <div class="col-md-4 text-center  offset-2">
                        <div class="standard modal-1">
                            <!--                            右上角的选中标签-->
                            <div class="enterprise_type_picked_tag" v-if="enterprise_evaluate_type === 1">
                                <div class="tag-design text-white">已选择</div>
                            </div>
                            <!--                            右上角的选中标签-->
                            <div class="pack-heading">
                                <h4 class="pack-title purple_color thin_font "><strong>离散大批量行业</strong></h4>
                                <div class="pack-price purple_color_btn transparent_effect"><span
                                        class="text-white">MDI</span></div>
                            </div>
                            <ul class="pack-details list-unstyled">
                                <li>通过对原材料物理形状的改变、组装</li>
                                <li>成为产品, 使其增值</li>
                                <li>同时，产品是标准或少数选配需求主要靠预测</li>
                                <li>需求主要靠预测，也考虑订单</li>
                                <li>生产是以物料为对象组成一条条流水生产线</li>
                            </ul>
                            <button class="btn purple_color_btn center-block btn-getit btn_pick_text"
                                    @click="start_btn_clicked('离散大批量行业')">start now
                            </button>
                        </div>
                    </div>
                    <!--          离散大批量-->


                    <!--          离散中小批量-->
                    <div class="col-md-4 text-center">
                        <div class="standard modal-1">
                            <!--                            右上角的选中标签-->
                            <div class="enterprise_type_picked_tag" v-if="enterprise_evaluate_type === 3">
                                <div class="tag-design text-white">已选择</div>
                            </div>
                            <!--                            右上角的选中标签-->
                            <div class="pack-heading">
                                <h4 class="pack-title purple_color thin_font "><strong>离散中小批量行业</strong></h4>
                                <div class="pack-price purple_color_btn transparent_effect"><span
                                        class="text-white">SMEDI</span></div>
                            </div>
                            <ul class="pack-details list-unstyled">
                                <li>通过对原材料物理形状的改变、组装</li>
                                <li>成为产品, 使其增值</li>
                                <li>同时，产品是标准或少数选配需求主要靠预测</li>
                                <li>需求主要靠预测，也考虑订单</li>
                                <li>生产是以物料为对象组成一条条流水生产线</li>
                            </ul>
                            <button class="btn purple_color_btn center-block btn-getit btn_pick_text"
                                    @click="start_btn_clicked('离散中小批量行业')">start now
                            </button>
                        </div>
                    </div>
                    <!--          离散中小批量-->
                </div>

            </div>

        </div>
    </div>

</template>
<script>
    import {mapGetters,mapMutations} from "vuex";
    import router from "@/router"
    import miniToastr from 'mini-toastr'

    export default {
        name: "Pricing",
        computed:{
            ...mapGetters([
                "current_process_step",
                "enterprise_evaluate_type"
            ])
        },
        methods: {
            ...mapMutations([
                "set_enterprise_evaluate_type",
                "set_current_process_step"
            ]),
            start_btn_clicked(enterprise_type_str) {
                miniToastr.success("企业类型： " +  enterprise_type_str)

                this.set_current_process_step(1)
                router.push('/credit/evaluate/integration_indicators')
                //判断企业类型并设置
                if (enterprise_type_str === "服务行业") {
                    this.set_enterprise_evaluate_type(4)
                } else if (enterprise_type_str === "流程行业") {
                    this.set_enterprise_evaluate_type(2)
                } else if (enterprise_type_str === "混合行业") {
                    this.set_enterprise_evaluate_type(5)
                } else if (enterprise_type_str === "离散大批量行业") {
                    this.set_enterprise_evaluate_type(1)
                } else if (enterprise_type_str === "离散中小批量行业") {
                    this.set_enterprise_evaluate_type(3)
                }

            }

        },
        mounted: function () {

        },
        destroyed: function () {

        }
    }
</script>
<style src="@/assets/css/enterpriseType.css" scoped></style>
