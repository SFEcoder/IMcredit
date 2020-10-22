<template>
  <GeminiScrollbar class="my_scroll_bar">
<div class="container" >

<div id="userinfo" > 企业信息</div>
<a-tooltip placement="right">
  <template slot="title">
    修改企业头标
  </template>
  <a-upload>
    <a-avatar src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png" style="margin-left: 350px; margin-top:50px;width: 100px;height: 100px" />
  </a-upload>
</a-tooltip>

<div class="company_static" id="a1" style="margin-top: 150px; margin-left: 300px">
  <TeamOutlined />
  <p class="staticText"><a-icon  type="team" class="myicon1"/> 企业全称</p>
  <div class="dynamicText">{{userInfoemail}}</div>
</div>

<div class="company_static" id="a2" style="margin-top: 150px; margin-left: 850px">
  <p class="staticText">
    <a-icon type="idcard" class="myicon1" />
    企业注册号</p>
  <div class="dynamicText">{{userInfoemail}}</div>
</div>


<div class="company_static" id="a3" style="margin-top: 450px; margin-left: 300px">
  <p class="staticText">
    <a-icon type="audit" class="myicon1"/>   营业执照</p>
  <div class="dynamicText">{{userInfoemail}}</div>
</div>


<div class="company_static" id="a4" style="margin-top: 450px; margin-left:850px">
  <p class="staticText">
    <a-icon type="crown" class="myicon1" /> 企业评级</p>
  <div class="dynamicText">{{userInfoemail}}</div>
</div>


<div id="companyinfo" style="font-size: 60px;margin-top:700px ;margin-left:60px ">企业资料</div>

<div class="mycomponent" id ="b2" style="margin-left: 850px;margin-top: 700px">
  <p class="staticText"><a-icon  type="mail" class="myicon1"/> 电子邮箱</p>
  <div class="dynamicText">{{userInfoemail}} </div>
  <a-button class = "mybutton" type="primary" @click="showModal">
    修改
  </a-button>
  <a-modal
      class="mymodal"
      width=600px
      centered="true"
      :visible="visible"
      :confirm-loading="confirmLoading"
      @ok="handleOk"
      @cancel="handleCancel"
  >

    <div class="modaltitle" > <a-icon  type="mail" class="myicon"/>       修改邮箱</div>


    <a-input
        class = "myinput"
        type="text"
        placeholder="请填写企业邮箱号"
        v-decorator="['userInfoemail', { rules: [{ required: true, message: '请输入企业邮箱号' }] }]">
      <!--       //  <a-icon  slot="prefix" type="user" />-->
    </a-input>


  </a-modal>
</div>


<div class="company_static" id="b1" style="margin-top: 150px; margin-left: 300px">
  <TeamOutlined />
  <p class="staticText"><a-icon  type="team" class="myicon1"/> 联系人</p>
  <div class="dynamicText">{{userInfoemail}}</div>
</div>



<!--  <div class="company_static" id="b3" style="margin-top: 450px; margin-left: 300px">-->
<!--    <p class="staticText">-->
<!--      <a-icon type="audit" class="myicon1"/>   营业执照</p>-->
<!--    <div class="dynamicText">{{userInfoemail}}</div>-->
<!--  </div>-->


<!--  <div class="company_static" id="b4" style="margin-top: 450px; margin-left:850px">-->
<!--    <p class="staticText">-->
<!--      <a-icon type="crown" class="myicon1" /> 企业评级</p>-->
<!--    <div class="dynamicText">{{userInfoemail}}</div>-->
<!--  </div>-->
</div>


<!--    <div class="mycomponent" id ="c2">-->
<!--      <p class="staticText"><a-icon  type="mail" class="myicon1"/> 电子邮箱</p>-->
<!--      <div class="dynamicText">{{userInfoemail}}</div>-->
<!--      <a-button class = "mybutton" type="primary" @click="showModal">-->
<!--        修改-->
<!--      </a-button>-->
<!--      <a-modal-->
<!--          class="mymodal"-->
<!--          width=600px-->
<!--          centered="true"-->
<!--          :visible="visible"-->
<!--          :confirm-loading="confirmLoading"-->
<!--          @ok="handleOk"-->
<!--          @cancel="handleCancel"-->
<!--      >-->

<!--        <div class="modaltitle" > <a-icon  type="mail" class="myicon"/>       修改邮箱</div>-->


<!--        <a-input-->
<!--            class = "myinput"-->
<!--            type="text"-->
<!--            placeholder="请填写企业邮箱号"-->
<!--            v-decorator="['userInfoemail', { rules: [{ required: true, message: '请输入企业邮箱号' }] }]">-->
<!--          &lt;!&ndash;       //  <a-icon  slot="prefix" type="user" />&ndash;&gt;-->
<!--        </a-input>-->


<!--      </a-modal>-->
<!--    </div>-->

<!--    <div class="mycomponent" id="c3">-->
<!--      <p class="staticText"><a-icon  type="phone" class="myicon1"/> 联系电话</p>-->
<!--      <div class="dynamicText">{{userInfoemail}}</div>-->
<!--      <a-button class = "mybutton" type="primary" @click="showModal">-->
<!--        修改-->
<!--      </a-button>-->
<!--      <a-modal-->
<!--          class="mymodal"-->
<!--          width=600px-->
<!--          centered="true"-->
<!--          :visible="visible"-->
<!--          :confirm-loading="confirmLoading"-->
<!--          @ok="handleOk"-->
<!--          @cancel="handleCancel"-->
<!--      >-->

<!--        <div class="modaltitle" > <a-icon  type="phone" class="myicon"/>       修改联系电话</div>-->


<!--        <a-input-->
<!--            class = "myinput"-->
<!--            type="text"-->
<!--            placeholder="请填写新联系电话"-->
<!--            v-decorator="['userInfoemail', { rules: [{ required: true, message: '请输入新联系电话' }] }]">-->
<!--          &lt;!&ndash;       //  <a-icon  slot="prefix" type="user" />&ndash;&gt;-->
<!--        </a-input>-->


<!--      </a-modal>-->
<!--    </div>-->

<!--    <div class="mycomponent" id="c4">-->
<!--      <p class="staticText"><a-icon  type="lock" class="myicon1"/> 账户密码</p>-->
<!--      <div class="dynamicText">{{userInfoemail}}</div>-->
<!--      <a-button class = "mybutton" type="primary" @click="showModal">-->
<!--        修改-->
<!--      </a-button>-->
<!--      <a-modal-->
<!--          class="mymodal_pass"-->
<!--          width=1000px-->
<!--          centered="true"-->
<!--          :visible="visible"-->
<!--          :confirm-loading="confirmLoading"-->
<!--          @ok="handleOk"-->
<!--          @cancel="handleCancel"-->
<!--      >-->

<!--        <div class="modaltitle_password" > <a-icon  type="lock" class="myicon"/>       修改密码</div>-->


<!--        <a-input-->
<!--            class = "myinput_password"-->
<!--            type="password"-->
<!--            placeholder="请填写旧密码"-->
<!--            v-decorator="['userInfoemail', { rules: [{ required: true, message: '请输入旧密码' }] }]">-->
<!--          &lt;!&ndash;       //  <a-icon  slot="prefix" type="user" />&ndash;&gt;-->
<!--        </a-input>-->

<!--        <a-input-->
<!--            class = "myinput_password"-->
<!--            type="password"-->
<!--            placeholder="请填写新密码"-->
<!--            v-decorator="['userInfoemail', { rules: [{ required: true, message: '请输入新密码' }] }]">-->
<!--          &lt;!&ndash;       //  <a-icon  slot="prefix" type="user" />&ndash;&gt;-->
<!--        </a-input>-->

<!--        <a-input-->
<!--            class = "myinput_password"-->
<!--            type="password"-->
<!--            placeholder="请再次填写新密码"-->
<!--            v-decorator="['userInfoemail', { rules: [{ required: true, message: '请输入新密码' }] }]">-->
<!--          &lt;!&ndash;       //  <a-icon  slot="prefix" type="user" />&ndash;&gt;-->
<!--        </a-input>-->


<!--      </a-modal>-->
<!--    </div>-->
<!--    </div>-->
  </GeminiScrollbar>
</template>


<script>
export default {
  data() {
    return {
      ModalText: 'Content of the modal',
      visible: false,
      confirmLoading: false,
      userInfoemail:"2801423111@qq.com"
    };
  },
  methods: {
    showModal() {
      this.visible = true;
    },
    handleOk(e) {
      this.ModalText = 'The modal will be closed after two seconds';
      this.confirmLoading = true;
      setTimeout(() => {
        this.visible = false;
        this.confirmLoading = false;
      }, 2000);
    },
    handleCancel(e) {
      console.log('Clicked cancel button');
      this.visible = false;
    },
  },
};
</script>


<style scoped lang="less">

.container
{
  position: absolute;
  height: 2000px;
  width: 1200px;
  background-color: white;
  top: 60%;
  left: 60%;
  transform: translate(-50%, -30%);
  border-radius: 10px;
  font-size: 60px;
}
#userinfo{
  position: inherit;
  font-size: 60px;
  top:60px;
  left:60px;
}
#myimage{
  width: 100px;
  height: 100px;
}

.mycomponent
{
  position: absolute;
  height:200px;
  width: 500px;
  background-color: rgba(255, 255, 255, .9);
  transform: translate(-50%, -30%);
  border-radius: 10px;
  border-color: gainsboro;
  border-width: thin;
  border-style: solid;
}
#c1{
  position:inherit;
  top:300px;
  left:300px;
}

#c2{
  position:inherit;
  top:300px;
  left:900px;
}
#c3{
  position:inherit;
  top:600px;
  left:300px;
}
#c4{
  position:inherit;
  top:600px;
  left:900px;
}
.staticText{
  font-size: 25px;
  color: purple;
  font-weight: bold;
  margin-top: 30px;
  margin-left: 20px;
}
.dynamicText{
  font-weight: normal;
  color: purple;
  font-size:25px;
  margin-left: 20px;
}
.mybutton{
  width:100px;
  height: 60px;
  top:-100px;
  left:350px;
  border-radius: 5px;
  font-size: 20px;
}
.mymodal
{

  /deep/ .ant-modal{
    top:350px;
    height: 100%;
    font-size: 16px;
  }
  /deep/ .ant-modal-footer{
    padding: 10px 1px;
    background-color: darkmagenta;
    height:80px;
  }
  /deep/ .ant-modal-body{
    height: 350px;
  }
}
.mymodal_pass
{

  /deep/ .ant-modal{
    top:350px;
    height: 100%;
    font-size: 16px;
  }
  /deep/ .ant-modal-footer{
    padding: 10px 1px;
    background-color: darkmagenta;
    height:80px;
  }
  /deep/ .ant-modal-body{
    height: 500px;
  }
}

.modaltitle
{
  font-size: 50px;
  color: black;
  margin-left: 100px;
  margin-top: 0px;
}
.modaltitle_password
{
  row_align:center;
  font-size: 40px;
  color: black;
  margin-left: 70px;
  margin-top: 0px;
}
.myinput{
  text-align:left;
  top:10%;
  left:6%;
  border-color: purple;
  width: 90%;
  height:100px;
  border-radius: 2px;
  row-align: middle;
  font-size: 30px;
}
.myinput_password{
  position: inherit;
  margin-top:20px;
  margin-left:50px;
  width:90%;
  font-size: 22px;
  height: 60px;
}
.myicon{
  font-size: 50px;
  margin-top: 50px;
}

.myicon1{
  font-size: 50px;
}
.company_static{
  position: absolute;
  height:200px;
  width: 500px;
  background-color: rgba(255, 255, 255, .9);
  transform: translate(-50%, -30%);
  border-radius: 10px;
  border-color: gainsboro;
  border-width: thin;
  border-style: solid;
}
.my_scroll_bar{
  height:200px;
}

</style>
