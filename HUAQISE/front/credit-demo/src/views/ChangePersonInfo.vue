<template>
  <div class="main" >

    <div id="userinfo" > 用户资料</div>
    <a-tooltip placement="right">
      <template slot="title">
        修改头像
      </template>
      <a-upload>
        <a-avatar src="myuseravatarUrl" style="margin-left: 350px; margin-top:50px;width: 100px;height: 100px" />
      </a-upload>
    </a-tooltip>

    <div class="mycomponent" id="c1">
      <p class="staticText"><a-icon  type="user" class="myicon1"/> 用户名</p>
      <div class="dynamicText">{{myusername}}</div>
      <a-button class = "mybutton" type="primary" @click="showModalName">
        修改
      </a-button>
      <a-modal
          class="mymodal"
          width=600px
          centered="true"
          :visible="visibleName"
          :confirm-loading="confirmLoading"
          @ok="handleOkName"
          @cancel="handleCancelName"
      >

        <div class="modaltitle" > <a-icon  type="user" class="myicon" />       修改用户名</div>
            <a-input   v-model="Inputmyusername" class = "myinput" type="text"  placeholder="请输入名字" ></a-input>>
      </a-modal>
    </div>

    <div class="mycomponent" id ="c2">
      <p class="staticText"><a-icon  type="mail" class="myicon1"/> 电子邮箱</p>
      <div class="dynamicText">{{myuseremail}}</div>
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
        <div class="modaltitle" > <a-icon  type="mail" class="myicon"/>       修改邮箱</div>
        <a-input
            class = "myinput"
            type="text"
            placeholder="请填写企业邮箱号"
            v-model="Inputmyuseremail">
          <!--       //  <a-icon  slot="prefix" type="user" />-->
        </a-input>
      </a-modal>
    </div>

    <div class="mycomponent" id="c3">
      <p class="staticText"><a-icon  type="phone" class="myicon1"/> 联系电话</p>
      <div class="dynamicText">{{myuserphonenum}}</div>
      <a-button class = "mybutton" type="primary" @click="showModalPhone">
        修改
      </a-button>
      <a-modal
          class="mymodal"
          width=600px
          centered="true"
          :visible="visiblePhone"
          :confirm-loading="confirmLoading"
          @ok="handleOkPhone"
          @cancel="handleCancelPhone"
      >
        <div class="modaltitle" > <a-icon  type="phone" class="myicon"/>       修改联系电话</div>
        <a-input
            class = "myinput"
            type="text"
            v-model="Inputmyuserphonenum"
            placeholder="请填写新联系电话">
        </a-input>
      </a-modal>
    </div>

    <div class="mycomponent" id="c4">
      <p class="staticText"><a-icon  type="lock" class="myicon1"/> 账户密码</p>
      <div class="dynamicText">{{myusemail}}</div>
      <a-button class = "mybutton" type="primary" @click="showModalPassword">
        修改
      </a-button>
      <a-modal
          class="mymodal_pass"
          width=600px
          centered="true"
          :visible="visiblePassword"
          :confirm-loading="confirmLoading"
          @ok="handleOkPassword"
          @cancel="handleCancelPassword"

      >
        <div class="modaltitle_password" > <a-icon  type="lock" class="myicon"/>       修改密码</div>
        <div class = "threepassword">
      <a-form
          id="formChangePass"
          class="ChangePass"
          ref="formChangePass"
          :form="form"
          style="top: 20%;left:10%;width: 80%"
      >
        <a-form-item>
          <a-input
              size="large"
              type="password"
              placeholder="旧密码"
              class = "myinput_password"
              v-decorator="[
                'myuserpassword',
                {rules: [{ required: true, message: '请输入旧密码' },{ validator: this.ConfirmOldPassword }], validateTrigger: 'blur'}
              ]"
              style="width:400px;"
              id = "oldpasswordInput"
          >
          </a-input>
        </a-form-item>
        <a-form-item>
          <a-input
              size="large"
              type="password"
              class = "myinput_password"
              placeholder="新密码"
              v-decorator="[
                'newPassword',
                {rules: [{ required: true, message: '请输入新密码' }, { validator: this.handleNewPassword }], validateTrigger: 'blur'}]"
              style="width:400px"
          >
          </a-input>
        </a-form-item>

        <a-form-item>
          <a-input
              size="large"
              type="password"
              class = "myinput_password"
              placeholder="确认新密码"
              v-decorator="[
                'newPasswordconfirm',
                {rules: [{ required: true, message: '请再次输入密码' }, { validator: this.handleNewPasswordCheck }], validateTrigger: 'blur'}]"
              style="width:400px"
          >
          </a-input>
        </a-form-item>
      </a-form>
        </div>
      </a-modal>
    </div>
  </div>

</template>
<script>
import { mapGetters, mapActions, mapMutations } from 'vuex'
export default {
  data() {
    return {
      form: this.$form.createForm(this),
      visibleName:false,
      visibleEmail:false,
      visiblePhone:false,
      visiblePassword:false,
      confirmLoading: false,
      con1:false,
      con2:false,
      con3:false,
      myuseravatarUrl:"",
      myusername:"xujing",
      myuseremail:"2801423111@qq.com",
      myuserphonenum:"15720927772",
      myuserpassword:"181860118",
      // myuseremail:this.userInfo.email,
      // myuseravatarUrl:this.userInfo.avatarUrl,
      // myusername:this.userInfo.username,
      // myuserphonenum:this.userInfo.phoneNumber,
      // myuserpassword:this.userInfo.password,
      Inputmyusername:"xujing",
      Inputmyuseremail:"2801423111@qq.com",
      Inputmyphonenum:"1572092772"
    };
  },
  computed: {
    ...mapGetters([
      'userID',
      'userInfo'
    ])
  },
  async mounted() {
    await  this.getUserInfo()
  },
  watch: {
    $route: {
      handler: function(route) {
        this.redirect = route.query && route.query.redirect
      },
      immediate: true
    },
  },
  methods: {
    ...mapActions([
      'getUserInfo',
      'updateUserInfo',
    ]),
    showModalPassword(e) {
      this.visiblePassword = true;
    },
    handleOkPassword(e) {
      this.ModalText = 'The modal will be closed after two seconds';
      this.confirmLoading = true;
      console.log(this.con1)
      console.log(this.con2)
      console.log(this.con3)


      if (this.con1 && this.con2 && this.con3) {
        this.myuserpassword = this.form.getFieldValue('newPassword')
        console.log(this.myuserpassword)

        this.con1 = false
        this.con2 = false
        this.con3 = false
         setTimeout(() => {
          this.visiblePassword = false;
          this.confirmLoading = false;
          this.form.setFieldsValue({
          newPassword:"",
          newPasswordconfirm:"",
          myuserpassword:""
    })
        }, 500);

    }
      else{
        this.con1 = false
        this.con2 = false
        this.con3 = false
        this.confirmLoading = false;
        this.form.setFieldsValue({
      newPassword:"",
      newPasswordconfirm:"",
      myuserpassword:""
    })
      }
      //this.saveModify() 
    },
    handleCancelPassword(e) {
      this.visiblePassword= false;
      this.form.setFieldsValue({
      newPassword:"",
      newPasswordconfirm:"",
      myuserpassword:""
    })
    },
    showModalPhone(e) {
      this.visiblePhone = true;
    },
    handleOkPhone(e) {
      setTimeout(() => {
        this.visiblePhone = false;
        this.myuserphonenum = this.Inputmyuserphonenum;
      }, 500);
      //this.saveModify() 
      },
    handleCancelPhone(e) {
      this.visiblePhone= false;
      this.Inputmyuserphonenum = this.myuserphonenum;
    },
    
    showModalEmail(e) {
      this.visibleEmail = true;
    },
    handleOkEmail(e) {
      setTimeout(() => {
        this.visibleEmail = false;
        this.myuseremail=this.Inputmyuseremail;
      }, 500);
       //this.saveModify() 
    },
    handleCancelEmail(e) {
      this.visibleEmail= false;
      this.Inputmyuseremail=this.myuseremail;
    },

    showModalName(e) {
      this.visibleName = true;
    },
    handleOkName(e) {
      setTimeout(() => {
        this.visibleName = false;
        this.confirmLoading = false;
        this.myusername=this.Inputmyusername;
      }, 500);
        //this.saveModify() 
    },
    handleCancelName(e) {
      this.visibleName = false;
      this.Inputmyusername= this.myusername;
    },

    ConfirmOldPassword(rule,value,callback)
    {
      const oldpassword = this.myuserpassword
      if (value === undefined) {
        callback(new Error('请输入旧密码'))
        this.con1=false
      }
      if (value && oldpassword && value.trim() !== oldpassword.trim()) {
        callback(new Error('旧密码输入错误'))
        this.con1=false
      }
      if (value && oldpassword && value.trim() === oldpassword.trim()) {
        this.con1=true
      }
      callback()

    },


    handleNewPassword(rule, value, callback) {
      const oldpassword = this.myuserpassword
      if (value.length < 6) {
        callback(new Error('密码长度至少6位'))
        this.con2=false
      }
      if (value && oldpassword && value.trim() === oldpassword.trim()) {
        callback(new Error('新密码与旧密码相同'))
        this.con2=false
      }
      if (value && oldpassword && value.trim() !== oldpassword.trim()) {
        this.con2=true
      }
      callback()
    },

    handleNewPasswordCheck (rule, value, callback) {
      const password = this.form.getFieldValue('newPassword')
      // console.log(password)
      if (value === undefined) {
        callback(new Error('请输入密码'))
        this.con3=false
      }
      if (value && password && value.trim() !== password.trim()) {
        callback(new Error('两次密码不一致'))
        this.con3=false
      }
      if (value && password && value.trim() === password.trim()) {
        this.con3=true
      }
      callback()
    },
    saveModify() {
          const data = {
            username:this.myusername,
            phoneNumber: this.myuserphonenum,
            email:this.myuseremail,
            password:this. myuserpassword
          }
          this.updateUserInfo(data).then(()=>{
          })
    }
  },
};
</script>


<style scoped lang="less">


.main
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
  height: ;
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
  font-size: 30px;
}
.myinput_password{
  position: inherit;
  margin-top:20px;
  margin-left:50px;
  width:80%;
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

</style>
