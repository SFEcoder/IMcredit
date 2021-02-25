<template>
    <div class="report_board fang_song">
        <h1 class="text-center biao_song"  style="padding-top: 75px; margin-bottom:50px;font-size: 29px;  ">两化融合评级报告</h1>

        <div class="row offset-2">
            <div class="col-md-6">

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
            <div class="col-md-6 ">
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
    </div>
</template>

<script>
    import {mapGetters, mapActions} from "vuex"

    export default {
        computed : {
           ...mapGetters([
               "report_list"
           ])
        },
        name: "report",
        mounted() {
            this.get_enterprise_report_text()
        },
        methods: {
            ...mapActions([
                "get_enterprise_report_text"
            ])
        }
    }
</script>

<style scoped>
    .report_board {
        line-height :  31.5px ;
        /*line-height的值为font-size的1.5倍，即1.5倍行距，使用line-height: 1.5效果相同;*/
        text-align : justify ;
        background-color: white;
        font-size: 21px;
    /*    */
    }

    .text-bold{
        font-weight: bold;
    }

    .report-item{
        margin-bottom: 10.5px
    }
</style>