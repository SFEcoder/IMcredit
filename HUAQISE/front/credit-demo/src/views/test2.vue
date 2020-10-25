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

        <div class="modaltitle" > <a-icon  type="user" class="myicon" />       修改用户名</div>
            <a-input   v-model="Inputmyusername" class = "myinput" type="text"  placeholder="请输入名字" ></a-input>>


      </a-modal>
    </div>

    <div class="mycomponent" id ="c2">
      <p class="staticText"><a-icon  type="mail" class="myicon1"/> 电子邮箱</p>
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
            v-model="Inputmyuserphonenum"
            placeholder="请填写新联系电话">
        </a-input>


      </a-modal>
    </div>


    <div class="mycomponent" id="c4">
      <p class="staticText"><a-icon  type="lock" class="myicon1"/> 账户密码</p>
      <div class="dynamicText">{{myusemail}}</div>
      <a-button class = "mybutton" type="primary" @click="showModal4">
        修改
      </a-button>
      <a-modal
          class="mymodal_pass"
          width=600px
          centered="true"
          :visible="visible4"
          :confirm-loading="confirmLoading"
          @ok="handleOk4"
          @cancel="handleCancel4"

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
                'myoldpassword',
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
      ModalText: 'Content of the modal',
      visible1:false,
      visible2:false,
      visible3:false,

      visible4:false,
      confirmLoading: false,
      con1:false,
      con2:false,
      con3:false,
      myusername:"xujing",
      myuseremail:"2801423111@qq.com",
      myuserphonenum:"15720927772",
      myoldpassword:"181860118",
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
    showModal4(e) {
      this.visible4 = true;
    },
    handleOk4(e) {
      this.ModalText = 'The modal will be closed after two seconds';
      this.confirmLoading = true;
      console.log(this.con1)
      console.log(this.con2)
      console.log(this.con3)


      if (this.con1 && this.con2 && this.con3) {
        this.myoldpassword = this.form.getFieldValue('newPassword')
        console.log(this.myoldpassword)

        this.con1 = false
        this.con2 = false
        this.con3 = false
         setTimeout(() => {
          this.visible4 = false;
          this.confirmLoading = false;
        }, 500);

    }
      else{
        this.con1 = false
        this.con2 = false
        this.con3 = false
        this.confirmLoading = false;

      }
    },
    handleCancel4(e) {
      console.log('Clicked cancel button');
      this.visible4= false;
      this.form.setFieldsValue({


      newPassword:"",
      newPasswordconfirm:"",
      myoldpassword:""


    })
    },
    showModal3(e) {
      this.visible3 = true;
    },
    handleOk3(e) {
      this.ModalText = 'The modal will be closed after two seconds';
      this.confirmLoading = true;
      setTimeout(() => {
        this.visible3 = false;
        this.confirmLoading = false;
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
      this.confirmLoading = true;
      setTimeout(() => {
        this.visible2 = false;
        this.confirmLoading = false;
        this.myuseremail=this.Inputmyuseremail;

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
      this.confirmLoading = true;
      setTimeout(() => {
        this.visible1 = false;
        this.confirmLoading = false;
        this.myusername=this.Inputmyusername;

      }, 500);
    },
    handleCancel1(e) {
      console.log('Clicked cancel button');
      this.visible1 = false;
      this.Inputmyusername= this.myusername;
    },

     ConfirmOldPassword(rule,value,callback)
    {
      const oldpassword = this.myoldpassword
      if (value === undefined) {
        callback(new Error('请输入旧密码'))
        this.con1=false
      }
      if (value && oldpassword && value.trim() !== oldpassword.trim()) {
        callback(new Error('旧密码输入错误'))
        value=""
        this.con1=false
      }
      if (value && oldpassword && value.trim() === oldpassword.trim()) {
        this.con1=true
      }
      callback()

    },


    handleNewPassword(rule, value, callback) {
      const oldpassword = this.myoldpassword
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
      console.log(password)
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
