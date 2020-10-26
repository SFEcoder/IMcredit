<template>
    <div>
        <!--    顶部的导航条-->
        <a-steps :current="current_process_step">
            <a-step class="thin_font" v-for="item in steps" :key="item.title" :title="item.title" style="cursor: pointer"
                    @click="guide_title_clicked(item.step_num)"/>
        </a-steps>
        <!--    顶部的导航条-->
        <transition name="fade-transform" mode="out-in">

            <router-view class="steps-content">
            </router-view>
        </transition>


    </div>


</template>

<script>
    import {mapMutations, mapActions, mapGetters} from "vuex";
    import miniToastr from 'mini-toastr'

    import router from '@/router'
    const steps = [
        {
            title: '选择企业类型',
            step_num: 0
        },
        {
            title: '填写两化融合指标体系',
            step_num: 1
        },
        {
            title: '填写财务指标',
            step_num: 2
        },
        {
            title: '填写完毕，查看报告',
            step_num: 4
        },
    ];
    const indexs = [
        '/credit/evaluate/enterpriseType',
        '/credit/evaluate/integration_indicators',
        '/credit/evaluate/financial_index'
    ]
    export default {
        name: "evalueateGuide",
        computed: {
            ...mapGetters([
                "current_process_step",
                "enterprise_evaluate_type"
            ])
        },

        data() {
            return {
                steps: steps,
                indexs: indexs
            }
        },

        methods: {
            ...mapMutations([
                "set_current_process_step"
            ]),
            guide_title_clicked(index) {
                // 首先看有没有选择企业类型
                if (this.enterprise_evaluate_type === -1){
                    miniToastr.error("请先选择企业类型")
                    return
                }
                // this.set_current_process_step(index)
                router.push(this.indexs[index])
            }
        },
        mounted() {
            //    根据现有的step跳转到相应的步骤页面
            router.push(this.indexs[this.current_process_step])
        },

        watch: {
            current_process_step() {
                this.$router.push(this.indexs[this.current_process_step])
            },
            $route(to, from) {
                if (this.indexs.indexOf(to.path) !== -1) {
                    this.set_current_process_step(this.indexs.indexOf(to.path))
                }
            }
        }
    }
</script>

<style scoped>
    .steps-content {
        margin-top: 16px;
        border: 1px dashed #e9e9e9;
        border-radius: 6px;
        background-color: #fafafa;
        min-height: 200px;
        text-align: center;
        padding-top: 20px;
        padding-bottom: 30px;
    }

    .steps-action {
        margin-top: 24px;
    }
</style>