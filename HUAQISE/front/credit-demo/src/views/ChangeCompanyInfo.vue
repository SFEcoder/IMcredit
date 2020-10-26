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
      <div id="userinfo" style=" position: inherit;font-size: 60px;top:80px;left:100px;" > 企业信息</div>
      <a-avatar src="mycompanyavatarUrl" style="margin-left: 450px; margin-top:80px;width: 100px;height: 100px" />


      <div class="company_dynamic" id="a1" style="margin-top: 20px; margin-left: 80px;  width:800px">
        <p class="staticText"><a-icon  type="team" class="myicon1"/> 企业全称</p>
        <div class="dynamicText">{{mycompanyName}}</div>
      </div>

      <div class="company_dynamic" id="a2" style="margin-top: 130px; margin-left: 80px; width:800px">
        <p class="staticText">
          <a-icon type="idcard" class="myicon1" />     企业注册号</p>
        <div class="dynamicText">   {{mycompanyID}}</div>
      </div>


      <div class="company_dynamic" id="a3" style="margin-top: 250px; margin-left: 80px; width:800px">
        <p class="staticText">
          <a-icon type="audit" class="myicon1"/>   营业执照</p>
        <div class="dynamicText">{{mycompanyLicense}}</div>
      </div>


      <div class="company_dynamic" id="a4" style="margin-top: 400px; margin-left:80px; width:800px">
        <p class="staticText">
          <a-icon type="crown" class="myicon1" /> 企业评级</p>
        <div class="dynamicText">{{mycompanyRate}}</div>
      </div>

      <div class="mycomponent" id="changeTel" style="margin-top:510px;height: 180px">
        <p class="staticText"><a-icon  type="user" class="myicon1"/>联系人</p>
        <div class="dynamicText">{{mycompanyManName}}</div>
        <a-button class = "mybutton" type="primary" @click="showModalManName">
          修改
        </a-button>
        <a-modal
            class="mymodal"
            width=600px
            centered="true"
            :visible="visibleManName"
            @ok="handleOkManName"
            @cancel="handleCancelManName"
        >
          <div class="modaltitle" > <a-icon  type="user" class="myicon"/>       修改联系人</div>
          <a-input
              class = "myinput"
              type="text"
              placeholder="请填写新联系人姓名"
              v-model="InputmycompanyManName">
          </a-input>
        </a-modal>
      </div>

      <div class="mycomponent" id="changeTel" style="margin-top:620px;height: 180px">
        <p class="staticText"><a-icon  type="phone" class="myicon1"/> 联系电话</p>
        <div class="dynamicText">{{mycompanyPhoneNum}}</div>
        <a-button class = "mybutton" type="primary" @click="showModalPhoneNum">
          修改
        </a-button>
        <a-modal
            class="mymodal"
            width=600px
            centered="true"
            :visible="visiblePhoneNum"
            :confirm-loading="confirmLoading"
            @ok="handleOkPhoneNum"
            @cancel="handleCancelPhoneNum"
        >

          <div class="modaltitle" > <a-icon  type="phone" class="myicon"/>       修改联系电话</div>
          <a-input
              class = "myinput"
              type="text"
              placeholder="请填写新联系电话"
              v-model="InputmycompanyPhoneNum">
          </a-input>
        </a-modal>
      </div>


      <div class="mycomponent" id="changemail" style="margin-top: 730px;height: 180px">
        <p class="staticText"><a-icon  type="mail" class="myicon1"/> 企业邮箱</p>
        <div class="dynamicText">{{mycompanyEmail}}</div>
        <a-button class = "mybutton" type="primary" @click="showModalEmail">
          修改
        </a-button>
        <a-modal
            class="mymodal"
            width=600px
            centered="true"
            :visible="visibleEmail"
            :confirm-loading="confirmLoading"
            @ok="handleOkEmail"
            @cancel="handleCancelEmail"
        >

          <div class="modaltitle" > <a-icon  type="mail" class="myicon"/>       修改企业邮箱</div>
          <a-input
              class = "myinput"
              type="text"
              placeholder="请填写新邮箱"
            v-model="InputmycompanyEmail">
          </a-input>
        </a-modal>
      </div>

    </div>
  </div>
</template>


<script>
import { mapGetters, mapMutations, mapActions } from 'vuex'
export default {
  data() {
    return {
      visibleManName: false,
      visibleEmail:false,
      visiblePhoneNum:false,
      confirmLoading: false,
      mycompanyID:"MF181860118",
      mycompanyLicense:"",
      mycompanyRate:"",
      mycompanyname:"泰隆格利国际空调有限公司",
      mycompanyEmail:"2801423111@qq.com",
      mycompanyPhoneNum:"15720927772",
      mycompanyManName:"李莉莉丝"
    };
  },
  components: {
  },
  computed: {
  ...mapGetters([
    'userId',
    'userInfo',
  ])
  },
  async mounted() {
    await this.getUserInfo()
  },
  methods: {
    ...mapActions([
      'getUserInfo',
      'updateUserInfo',
    ]),
    showModalPhoneNum(e) {
      this.visiblePhoneNum = true;
    },
    handleOkPhoneNum(e) {
      this.ModalText = 'The modal will be closed after two seconds';
      setTimeout(() => {
        this.visiblePhoneNum = false;
        this.mycompanyPhoneNum = this.InputmycompanyPhoneNum;
      }, 500);
      },
    handleCancelPhoneNum(e) {
      console.log('Clicked cancel button');
      this.visiblePhoneNum= false;
      this.InputmycompanyPhoneNum = this.mycompanyPhoneNum;

    },
    showModalEmail(e) {
        this.visibleEmail = true;
      },
    handleOkEmail(e) {
      this.ModalText = 'The modal will be closed after two seconds';
      setTimeout(() => {
        this.confirmLoading = false;
        this.mycompanyEmail=this.InputmycompanyEmail;
        this.visibleEmail=false;
      }, 500);
    },
    handleCancelEmail(e) {
      console.log('Clicked cancel button');
      this.visibleEmail= false;
      this.InputmycompanyEmail=this.mycompanyEmail;
    },
    showModalManName(e) {
      this.visibleManName = true;
    },
    handleOkManName(e) {
      this.ModalText = 'The modal will be closed after two seconds';
      setTimeout(() => {
        this.visibleManName = false;
        this.mycompanyManName=this.InputmycompanyManName;

      }, 500);
    },
    handleCancelManName(e) {
      console.log('Clicked cancel button');
      this.visibleManName = false;
      this.InputmycompanyManName= this.mycompanyManName;
    }
    },  
    saveModify()
    {
      const data={
        username: this.mycompanyManName,
        phoneNumber: this.mycompanyPhoneNum,
        email:this.mycompanyEmail,
        password:this.mycompanyEmail
      }
      this.updateUserInfo(data).then(()=>{
      })
    }

};
</script>


<style scoped lang="less">

.mycomponent
{
  position: inherit;
  left:7%;
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
