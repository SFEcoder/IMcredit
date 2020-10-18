<template>
  <div class="main">
    <Header></Header>

      <a-tabs default-active-key="1" size='large' >
      <a-tab-pane id="title" key="1"  size='large' class="top" > <a-icon type="lock" size='large'/>  修改密码
      </a-tab-pane>
      </a-tabs>
      <div class = "threepassword">
      <a-form
          id="formChangePass"
          class="ChangePass"
          ref="formChangePass"
          :form="form"
      >

        <a-form-item>
          <a-input

              size="large"
              type="password"
              placeholder="旧密码"
              v-decorator="[
                'password',
                {rules: [{ required: true, message: '请输入旧密码' },{ validator: this.ConfirmOldPassword }], validateTrigger: 'blur'}
              ]"
              style="width:400px"
              v-if="modify"
          >
            <a-icon slot="prefix" type="lock" :style="{ color: 'rgba(0,0,0,.25)' }"/>
          </a-input>
        </a-form-item>

        <a-form-item>
          <a-input
              size="large"
              type="password"
              placeholder="新密码"
              v-decorator="[
                'newPassword',
                {rules: [{ required: true, message: '请输入新密码' }, { validator: this.handleNewPassword }], validateTrigger: 'blur'}]"
              style="width:400px"
              v-if="modify"
          >
            <a-icon slot="prefix" type="lock" :style="{ color: 'rgba(0,0,0,.25)' }"/>
          </a-input>
        </a-form-item>

        <a-form-item>
          <a-input
              size="large"
              type="password"
              placeholder="确认新密码"
              v-decorator="[
                'newPasswordconfirm',
                {rules: [{ required: true, message: '请再次输入密码' }, { validator: this.handleNewPasswordCheck }], validateTrigger: 'blur'}]"
              style="width:400px"
              v-if="modify"
              >
            <a-icon slot="prefix" type="lock" :style="{ color: 'rgba(0,0,0,.25)' }"/>
          </a-input>
        </a-form-item>


        <a-form-item :wrapper-col="{ span: 12, offset: 4}">
          <a-button type="primary" @click="savePassModify" size='large'>
            确定
          </a-button>

        </a-form-item>
      </a-form>
    </div>
  </div>

</template>


<script>
import Header from '@/components/header'
import { mapGetters, mapActions, mapMutations } from 'vuex'

export default {
  name: 'ChangePassword',
  components: {
    Header
  },
  data () {
    return {
      modify:true,
      form: this.$form.createForm(this),
    }
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
      'ChangePassword'
    ]),
    ConfirmOldPassword(rule,value,callback)
    {
      const oldpassword = this.userInfo.userpassword
      if (value === undefined) {
        callback(new Error('请输入旧密码'))
      }
      if (value && oldpassword && value.trim() !== oldpassword.trim()) {
        callback(new Error('旧密码输入错误'))
      }
      callback()
    },


    handleNewPassword(rule, value, callback) {
      if (value.length < 6) {
        callback(new Error('密码长度至少6位'))
      }
      callback()
    },
    handleNewPasswordCheck (rule, value, callback) {
      const password = this.form.getFieldValue('newPassword')
      console.log(password)
      if (value === undefined) {
        callback(new Error('请输入密码'))
      }
      if (value && password && value.trim() !== password.trim()) {
        callback(new Error('两次密码不一致'))
      }
      callback()
    },
    savePassModify() {
      this.form.validateFields((err, values) => {
        if (!err) {
          const data = {
            username: this.userInfo.username,
            phoneNumber: this.userInfo.phoneNumber,
            password: this.form.getFieldValue('newPassword')
          }
          this.updateUserInfo(data).then(()=>{
            this.modify = true
          })
        }
        else
        {
          this.modify = true
        }

      });
    },

  }
}
</script>
<style scoped>
.main {
  margin-top: 50px;
}
.threepassword {
  margin-top: 20px;
}

#title{
  font-size: 20px;
}


</style>
