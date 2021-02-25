<template>


  <a-result
      status="success"
      class="thin_font"
      style="height: 600px;padding-top: 100px"
  >
    <template #icon>
      <a-icon  type="check-circle" :style="{  color: '#690048', opacity : 0.7 }" />
    </template>

    <template #extra>
      <p style="font-size: 25px; color: rgb(105,0,75); margin-bottom: 40px">评级报告已生成</p>
      <p style="font-size: 16px; color: rgb(105,0,75)">请至左侧菜单栏“我的评级” ——>“查看报告”中查看评级</p>
      <button style="margin-top: 40px" class="btn purple_color_btn center-block btn-getit btn_pick_text" @click="go_to_check_report">
        点击前往
      </button>
<!--      <a-button key="console" type="primary">-->
<!--        Go Console-->
<!--      </a-button>-->
    </template>
  </a-result>
</template>

<script>
import  router from "@/router"
export default {

  name: "index_finished",
  methods:{
    go_to_check_report(){
      router.push("/credit/report")
    }
  }
}
</script>

<style scoped>
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
</style>