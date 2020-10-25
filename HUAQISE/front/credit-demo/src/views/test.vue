<template>
  <div class ="info-wrapper">
    <div class="container" style="
          position: absolute;
           height: 2000px;
           width: 1200px;
           background-color: white;
           top: 60%;
           left: 60%;
           transform: translate(-50%, -30%);
           border-radius: 10px;
           font-size: 60px;">
      <div id="userinfo" style=" position: inherit;font-size: 60px;top:100px;left:100px;" > 企业信息</div>
      <a-avatar src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png" style="margin-left: 450px; margin-top:80px;width: 100px;height: 100px" />


      <div class="company_dynamic" id="a1" style="margin-top: 80px; margin-left: 80px;  width:800px">
        <p class="staticText"><a-icon  type="team" class="myicon1"/> 企业全称</p>
        <div class="dynamicText">{{username}}</div>
      </div>

      <div class="company_dynamic" id="a2" style="margin-top: 200px; margin-left: 80px; width:800px">
        <p class="staticText">
          <a-icon type="idcard" class="myicon1" />     企业注册号</p>
        <div class="dynamicText">   {{userID}}</div>
      </div>


      <div class="company_dynamic" id="a3" style="margin-top: 320px; margin-left: 80px; width:800px">
        <p class="staticText">
          <a-icon type="audit" class="myicon1"/>   营业执照</p>
        <div class="dynamicText">{{user}}</div>
      </div>


      <div class="company_dynamic" id="a4" style="margin-top: 440px; margin-left:80px; width:800px">
        <p class="staticText">
          <a-icon type="crown" class="myicon1" /> 企业评级</p>
        <div class="dynamicText">{{userInfoemail}}</div>
      </div>

      <div class="mycomponent" id="changeTel" style="margin-top:560px;margin-left:300px;height: 180px">
        <p class="staticText"><a-icon  type="user" class="myicon1"/>联系人</p>
        <div class="dynamicText">{{myusername}}</div>
        <a-button class = "mybutton" type="primary" @click="showModal1">
          修改
        </a-button>
        <a-modal
            class="mymodal"
            width=600px
            centered="true"
            :visible="visible1"
            :confirm-loading="confirmLoading"
            @ok="handleOk1"
            @cancel="handleCancel1"
        >

          <div class="modaltitle" > <a-icon  type="user" class="myicon"/>       修改联系人</div>


          <a-input
              class = "myinput"
              type="text"
              placeholder="请填写新联系人姓名"
              v-model="Inputmyusername">

          </a-input>


        </a-modal>
      </div>

      <div class="mycomponent" id="changeTel" style="margin-top:660px;margin-left:320px;height: 180px">
        <p class="staticText"><a-icon  type="phone" class="myicon1"/> 联系电话</p>
        <div class="dynamicText">{{myuserphonenum}}</div>
        <a-button class = "mybutton" type="primary" @click="showModal3">
          修改
        </a-button>
        <a-modal
            class="mymodal"
            width=600px
            centered="true"
            :visible="visible3"
            :confirm-loading="confirmLoading"
            @ok="handleOk3"
            @cancel="handleCancel3"
        >

          <div class="modaltitle" > <a-icon  type="phone" class="myicon"/>       修改联系电话</div>


          <a-input
              class = "myinput"
              type="text"
              placeholder="请填写新联系电话"
              v-model="Inputmyuserphonenum">

          </a-input>


        </a-modal>
      </div>



      <div class="mycomponent" id="changemail" style="margin-top: 780px;margin-left:320px;height: 180px">
        <p class="staticText"><a-icon  type="mail" class="myicon1"/> 企业邮箱</p>
        <div class="dynamicText">{{myuseremail}}</div>
        <a-button class = "mybutton" type="primary" @click="showModal2">
          修改
        </a-button>
        <a-modal
            class="mymodal"
            width=600px
            centered="true"
            :visible="visible2"
            :confirm-loading="confirmLoading"
            @ok="handleOk2"
            @cancel="handleCancel2"
        >

          <div class="modaltitle" > <a-icon  type="mail" class="myicon"/>       修改企业邮箱</div>


          <a-input
              class = "myinput"
              type="text"
              placeholder="请填写新邮箱"
            v-model="Inputmyuseremail">

            <!--       //  <a-icon  slot="prefix" type="user" />-->
          </a-input>


        </a-modal>
      </div>




    </div>
  </div>
</template>


<script>
export default {
  data() {
    return {
      ModalText: 'Content of the modal',
      visible1: false,
      visible2:false,
      visible3:false,

      confirmLoading: false,
      userID:"MF181860118",
      username:"泰隆格利国际空调有限公司",
      myuseremail:"2801423111@qq.com",
      myuserphonenum:"15720927772",
      myusername:"李莉莉丝"
    };
  },
  methods: {
    showModal() {
      this.visible = true;
    },
    handleOk(e) {
      this.ModalText = 'The modal will be closed after two seconds';
      setTimeout(() => {
        this.visible = false;
        this.confirmLoading = false;
      }, 500);
    },
    handleCancel(e) {
      console.log('Clicked cancel button');
      this.visible = false;
    },
    showModal3(e) {
      this.visible3 = true;
    },
    handleOk3(e) {
      this.ModalText = 'The modal will be closed after two seconds';
      setTimeout(() => {
        this.visible3 = false;
        this.myuserphonenum = this.Inputmyuserphonenum;

      }, 500);
      },
    handleCancel3(e) {
      console.log('Clicked cancel button');
      this.visible3= false;
      this.Inputmyuserphonenum = this.myuserphonenum;

    },
    showModal2(e) {
        this.visible2 = true;
      },
    handleOk2(e) {
      this.ModalText = 'The modal will be closed after two seconds';
      setTimeout(() => {
        this.confirmLoading = false;
        this.myuseremail=this.Inputmyuseremail;
        this.visible2=false;
      }, 500);
    },
    handleCancel2(e) {
      console.log('Clicked cancel button');
      this.visible2= false;
      this.Inputmyuseremail=this.myuseremail;
    },
    showModal1(e) {
      this.visible1 = true;
    },
    handleOk1(e) {
      this.ModalText = 'The modal will be closed after two seconds';
      setTimeout(() => {
        this.visible1 = false;
        this.myusername=this.Inputmyusername;

      }, 500);
    },
    handleCancel1(e) {
      console.log('Clicked cancel button');
      this.visible1 = false;
      this.Inputmyusername= this.myusername;
    }
  }

};
</script>


<style scoped lang="less">

.mycomponent
{
  position: absolute;

  transform: translate(-50%, -30%);

}

.staticText{
  font-size: 30px;
  color: purple;
  font-weight: bold;
  margin-top: 30px;
  margin-left: 20px;
}
.dynamicText{
  font-weight: normal;
  color: purple;
  font-size:30px;
  margin-left: 300px;
  margin-top: -75px;
}
.mybutton{
  width:100px;
  height: 60px;
  top:-70px;
  left:600px;
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

.modaltitle
{
  font-size: 50px;
  color: black;
  margin-left: 100px;
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

.myicon{
  font-size: 50px;
  margin-top: 50px;
}

.myicon1{
  font-size: 50px;
}
.company_dynamic{
  position: absolute;
  height:200px;
  width: 400px;

}
.company_static{
  position: absolute;
  height:100px;
  width: 800px;


}


</style>
