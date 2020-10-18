<template>

  <div class="main">
    <Header></Header>

    <div class="desc">

      <div class ="info">
        <a-tabs default-active-key="1" size='large' >
          <a-tab-pane key="1" tab="账号设置" size='large' class="top" >

            <div id="changepass" class="myitem1" @click="FchangePass" >
              修改密码
            </div>
            <div id="changeID" class="myitem1"  @click="FchangeID"  >
              切换账号
            </div>
            <div id="drawback" class="myitem1"  @click="Logof"  >
              退出登录
            </div>
          </a-tab-pane>
          <a-tab-pane key="2" tab="功能" class="top" >
            <div id="attenComp" class="myitem2" @click="FattenComp">
              我关注的公司
            </div>
            <div id="seenComp" class="myitem2" @click="FseenComp">
              我看过的公司
            </div>

          </a-tab-pane>

        </a-tabs>
      </div>

  </div>
  </div>
</template>



<script>
import Header from '@/components/header'
export default {

  name: 'personalCenter',
  components: {
    Header
  },
  methods: {
    FchangePass()
    {
      this.$router.push(`/ChangePassword`)
    },
    FchangeID()
    {
      this.$router.push(`/login`)
    },
    Logof(){
      // this.$router.push(`/login?redirect='/credit/main'`)
      this.$router.push(`/home`)
    }
  },

}
</script>

<style scoped lang="less">

</style>
<style lang="less">
.main{
  margin-top: 50px;
  .info {
    font-size: 30px;
    margin-top: 20px;
    padding-left: 30px;
    .top{
      flex-direction:column;
    }

     .myitem1{
      font-family:"Times New Roman",Georgia,Serif;
      width: 300px;
      border-style: solid;
      border-width:1px;
      background-color: white;
      border-color:silver;
      font-size:20px;
      color: purple;
      text-align: center;
      vertical-align: middle;
      margin-top: 15px;
    }
    .myitem2{
      font-family:"Times New Roman",Georgia,Serif;
      width: 300px;
      border-style: solid;
      border-width:1px;
      background-color: white;
      border-color:silver;
      font-size:20px;
      color:purple;
      text-align: center;
      vertical-align: middle;
      margin-top: 15px;

    }
    #drawback
    {
      //background-color: purple;
      color:chocolate;
    }
  }
}
</style>


<style scoped>

</style>


