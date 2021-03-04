<template>
    <div class="back_color">

        <!--        上面的筛选栏-->
        <div class="row" style="margin-bottom: 20px;">

            <!--         右边的搜索框   -->
            <div class="col-lg-6 col-md-6 col-sm-6 col-sxs-12" >
                <a-input-search placeholder="输入企业名称以搜索" @search="onSearch">
                    <a-button slot="enterButton" class="display_search_btn" size="">
                        Search
                    </a-button>
                </a-input-search>
            </div>
            <!--         右边的搜索框 -->

            <!--            上面筛选栏右边的筛选按钮-->
            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 text-lg-right text-md-right  text-sm-right">
                <div class="btn-group">
                    <button style="margin-right: 13px" v-for="(val, key) in option.getFilterData" class="btn"
                            :class="[key===filterOption? 'is-checked' : '']" @click="filter(key)" :key="key">{{key}}
                    </button>
                </div>
            </div>
            <!--            上面筛选栏右边的按筛选钮-->

        </div>

        <isotope class="center-block" ref="cpt" id="isotope" :item-selector="'element-item'" :list="this.display_list"
                 :options='option' v-images-loaded:on.progress="layout" @filter="filterOption=arguments[0]">
            <div v-for="(element,index) in this.display_list" :key="index" :class="element.filter" class="col-md-3">
                <div class="box_border box_color grade_display_box">
                    <div class="col-md-12 text-center">

                        <!--                        右上角的评级-->
                        <div>
                            <span class="eGrade_right_up_box jump_cool_font"
                                  :style="'background-color:' + get_box_color_by_num_grade(element.egrade) + '; -webkit-box-shadow:1px 1px 22px '+ get_box_color_by_num_grade(element.egrade)">{{'评级: ' +get_str_grade_by_num_grade(element.egrade)}}</span>
                        </div>
                        <!--                        右上角的评级-->

                        <!--                        企业评级公式的图片-->
                        <a :href="element.ephoto" class="text_Gcolor">
                            <img style="height:250px; width: 250px" :src="element.ephoto"
                                 class="img-fluid rounded-circle" alt="image missing">
                        </a>
                        <!--                        企业评级公式的图片-->
                    </div>
                    <hr/>
                    <!--                    图片下面的内容-->

                    <div class="row tot_padd">
                        <div class="col-md-6 col-6 text-center">
                            <span><b>企业名称</b></span>
                        </div>
                        <div style="white-space:nowrap;overflow:hidden;text-overflow:ellipsis;" class="col-md-6 col-6">
                            <b class="text_ndz"><span>{{element.name}}</span></b>
                        </div>


                        <div class="col-md-6 col-6 text-center">
                            <span><b>企业评级</b></span>
                        </div>
                        <div class="col-md-6 col-6">
                            <span style="font-weight: bold">{{get_str_grade_by_num_grade(element.egrade)}}</span>
                        </div>

                        <div class="col-md-6 col-6 text-center">
                            <span>企业邮箱</span>
                        </div>
                        <div style="white-space:nowrap;overflow:hidden;text-overflow:ellipsis;" class="col-md-6 col-6">
                            <span>{{element.email}}</span>
                        </div>

                        <div class="col-md-6 col-6 text-center">
                            <span>联系电话</span>
                        </div>
                        <div style="white-space:nowrap;overflow:hidden;text-overflow:ellipsis;" class="col-md-6 col-6">
                            <span>{{element.contactNumber}}</span>
                        </div>


                        <div class="col-md-12 col-12 text-center mt-2">
                            <div @click="check_report(element)" class="btn text-white cost_bold thin_font"
                                 :style="'background-color:' + get_box_color_by_num_grade(element.egrade) + '; -webkit-box-shadow:1px 1px 22px '+ get_box_color_by_num_grade(element.egrade)">
                                详细报告
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </isotope>
    </div>
</template>
<script>
    var unsub;
    import  router from "@/router"
    import  {mapGetters, mapMutations, mapActions} from 'vuex'
    import isotope from 'vueisotope'
    import imagesLoaded from 'vue-images-loaded'
    import baguetteBox from 'baguettebox.js'
    require("baguettebox.js/dist/baguetteBox.min.css");
    import miniToastr from 'mini-toastr'



    export default {
        computed:{
          ...mapGetters([
              "display_list",
              'userId'
          ])
        },
        directives: {
            imagesLoaded,
        },
        components: {
            isotope,
        },
        data() {
            return {
                filterOption: "All",
                option: {
                    itemSelector: ".element-item",
                    getFilterData: {
                        All() {
                            return true;
                        },
                        SSS(el) {
                            return el.egrade === 0;
                        },
                        A(el) {
                            return el.egrade === 1;
                        },
                        B(el) {
                            return el.egrade === 2
                        },
                        C(el) {
                            return el.egrade === 3
                        },
                        D(el) {
                            return el.egrade === 4
                        },
                    }
                }
            }

        },
        methods: {
          ...mapMutations([
            "set_checkedEnterpriseId"
          ]),
          ...mapActions([
              "get_display_list",
              "search_enterprise_display_list",
              'addBrowseHistory'
          ]),
            filter: function (key) {
                this.$refs.cpt.filter(key);
            },
            layout() {
                this.$refs.cpt.layout('masonry');
            },
            onSearch(value){
                miniToastr.warn("目标企业: "+ value,"正在搜索…")
                this.search_enterprise_display_list(value)
            },

          check_report(item){
            //查看报告
            if(this.userId === 0){
              miniToastr.error("游客请先登录")
            }
            else{
              this.addBrowseHistory(item.id)
              this.set_checkedEnterpriseId(item.id)
              router.push("/credit/report")
            }

          },

            // 根据评级获取评级公式右上角盒子的颜色
            get_box_color_by_num_grade(num_grade) {
                if (num_grade === 0) return 'rgba(25,190, 107, 0.8)'
                else if (num_grade === 1) return 'rgba(105,0,75, 0.8)'
                else if (num_grade === 2) return 'rgba(45, 183,245, 0.8)'
                else if (num_grade === 3) return 'rgba(255, 153, 0, 0.8)'
                else return 'rgba(237, 64, 20, 0.8)'
            },
            get_str_grade_by_num_grade(num_grade) {
                //五个评级,根据数字评级获取对应的字符评级
                if (num_grade === 0) return 'SSS'
                else if (num_grade === 1) return 'A'
                else if (num_grade === 2) return 'B'
                else if (num_grade === 3) return 'C'
                else return 'D'
            }
        },
        mounted() {

          this.get_display_list()
          baguetteBox.run('#isotope'); //点击查看大图
        },
        beforeRouteLeave(to, from, next) {
            next();
        },

    }
</script>



<style scoped>
    .element-item {
        padding: 12px;
    }

    .element-item img {
        width: 100%;
    }

    @media screen and (max-width: 1250px)and (min-width: 1100px) {
        .element-item img {
            width: 400px;
        }
    }

    @media screen and (max-width: 991px) and (min-width: 900px) {
        .element-item img {
            width: 270px;
        }
    }

    @media screen and (max-width: 899px) and (min-width: 775px) {
        .element-item img {
            width: 350px;
        }
    }

    @media screen and (max-width: 670px) and (min-width: 400px) {
        .element-item img {
            width: 270px;
        }
    }

    @media screen and (max-width: 680px) and (min-width: 424px) {
        .eGrade_right_up_box {
            position: absolute;
            right: 67px !important;
        }
    }


    button.is-checked {
        -webkit-box-shadow: 1px 1px 22px rgba(105, 0, 75, 0.5);
        background-color: rgba(105, 0, 75, 0.6);
        color: #fff;
    }

    button.btn {
        cursor: pointer;
    }

    .box_border {
        border: 1px solid #ccc;
    }

    .text_color {
        color: #000000;
    }

    .text_color:focus {
        outline: none !important;
    }

    .tot_padd {
        padding: 10px;
    }

    .text_ndz {
        color: rgb(105, 0, 75);
    }

    .eGrade_right_up_box {
        padding: 4px 7px;
        position: absolute;
        right: 5px;
        border-radius: 5px;
        top: 8px;
        color: white;
        font-weight: bold;
        font-size: 14.5px;
    }

    .cost_bold {
        font-weight: bold;
    }

    .box_color {
        background-color: rgba(249, 250, 251, 0.1);
    }

    .description_content {
        text-align: justify;
        padding-right: 30px;
    }

    .grade_display_box {
        font-size: 13px;
        box-shadow: 0 6px 30px #CCC;
    }

    .display_search_btn {
        color: white;
        background-color: rgba(105, 0, 75, 0.6);
        border: rgba(105, 0, 75, 0.6);
        -webkit-box-shadow: 1px 1px 12px rgba(105, 0, 75, 0.6);
        border-radius: 0.5rem;
    }
</style>
