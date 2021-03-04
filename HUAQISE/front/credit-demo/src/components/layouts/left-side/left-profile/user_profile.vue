<template>
    <div>
        <div class="user_section">
            <div class="row">
                <div class="col-12">
                  <div class="img-wrapper" v-if="this.userId === 0"><img src="https://dss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1736163552,1696885273&fm=26&gp=0.jpg" class="rounded-circle"></div>
                  <div class="img-wrapper" v-else-if="this.userInfo.userType === 0"><img :src=" this.userInfo.avatarUrl" alt="暂无头像" class="rounded-circle"></div>
                  <div class="img-wrapper" v-else><img :src=" this.userInfo.ephoto === null ? this.userInfo.license : this.userInfo.ephoto" alt="暂无头像" class="rounded-circle"></div>
                  <p class="mt-2 mb-1 user_name_max text-center" v-if="this.userId === 0" @click="go_login" style="cursor: pointer">游客（点击登录）</p>
                  <p class="mt-2 mb-1 user_name_max text-center" v-else>{{(this.userInfo.userType === 0)?this.userInfo.username:this.userInfo.name}}</p>
                </div>
                <div class="leftuser_icons col-12 compact_data">
                    <div class="row user_profile_btn_box">
                        <div class="col-md-3"><a  @click="go_info" title="个人资料"><i class="fa fa-gear"></i></a></div>
                        <div class="col-md-3 logout_padd"><a @click="log_out" title="退出登录"><i class="fa fa-sign-out"></i></a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import {mapGetters, mapMutations} from "vuex"
    import miniToastr from 'mini-toastr'
    import router from "@/router";
    export default {
        name : "user_profile_vue",
        computed:{
            ...mapGetters([
                "userInfo",
                'userId'
            ])
        },
      methods:{
          ...mapMutations([
              "set_userId"
          ]),
        go_login(){
          router.push('/login')
        },
        go_info(){
          if(this.userId === 0){
            miniToastr.error("游客请先登录")
          }
          else{
            router.push( '/user/info/'+this.userId)
          }
        },
        log_out(){
          if(this.userId !== 0){
            this.set_userId(0)
          }
          router.push('/login')
        }
      },
        mounted() {
          console.log(this.userInfo.ephoto === null ? this.userInfo.license : this.userInfo.ephoto)
        }
    }
</script>



<style scoped lang="scss">
/*user section*/
@import "../../css/customvariables";

.user_section {
    height: 188px;
    /*background-color:#f3f6f9;*/
     padding: 15px 20px;

    .img-wrapper{
        width: 100px;
        border-radius:200px;
        padding:7px;
        margin:auto;
    }
    img {
        width: 84px;
      height: 84px;
        border: 2px solid #ccc;
    }

    p {
        font-size: 15px;
    }
    .leftuser_icons .logout_padd{
        padding: 1px !important;
    }
}
.user_name_max {
    font-weight:700;
    max-width: 210px;
    white-space: nowrap;
    overflow: hidden !important;
    text-overflow: ellipsis;
    margin: 0 0 -4px;
    padding-top: 2px;
    padding-bottom: 5px;
}

.leftuser_icons div {
    cursor: pointer;
    padding: 1px 12px;
    font-size:18px;
    background-color: transparent;
    margin-right: 3px;
    border-radius: 50px;
    margin: auto;
    width: 100%;
}
.user_name_max,
.leftuser_icons i{
    color:$menu_color;
}

    .user_profile_btn_box{
        display: flex;
        flex-wrap: nowrap;
        justify-content: space-between;
    }

</style>
