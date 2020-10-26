<template>
    <div class="login-register">

        <!--        <div class="contain">-->
        <div class="big-box" :class="{active:isLogin}" >

            <!-- 登录  -->
            <div class="big-contain" v-if="isLogin">
                <a-form
                        class="user-layout-login"
                        ref="formLogin"
                        :form="form"
                >

                    <div class="btitle">
                        <div v-if="personal">个人登录</div>
                        <div v-else>企业登录</div>
                    </div>
                    <a-form-item>
                        <a-input
                                size="default"
                                type="text"
                                style="width: 300px"
                                placeholder="邮箱"
                                v-decorator="[
                'username',
                {rules: [{ required: true, message: '请输入邮箱地址' }], validateTrigger: 'blur'}
              ]"
                        >
                            <a-icon slot="prefix" type="mail" :style="{ color: 'rgba(0,0,0,.25)' }"/>
                        </a-input>
                    </a-form-item>
                    <a-form-item>
                        <a-input
                                size="default"
                                type="password"
                                style="width: 300px"
                                autocomplete="false"
                                placeholder="密码"
                                v-decorator="[
                'password',
                {rules: [{ required: true, message: '请输入密码' }], validateTrigger: 'blur'}
              ]"
                        >
                            <a-icon slot="prefix" type="lock" :style="{ color: 'rgba(0,0,0,.25)' }"/>
                        </a-input>
                    </a-form-item>
                    <!--验证码-->
                    <a-row>
                        <a-col :span="13"
                        >
                            <a-input
                                    placeholder="验证码"
                                    v-model="code"
                                    clearable
                                    prop="Identify"
                            >
                            </a-input>
                        </a-col>
                        <a-col :span="10" style="margin-left: 12px">
                            <div class="code" @click="refreshCode">
                                <Identify :identifyCode="identifyCode"></Identify>
                            </div>
                        </a-col>
                    </a-row>
                    <a-form-item>
                        <div style="width: 200px;height: 100px;position: absolute; left: 50%;margin-left: 100px">
                            <a-radio-group name="radioGroup"  @change="changePersonal" style="vertical-align: middle ; display: block ; margin: 0 auto">
                                <a-radio :value="1" >
                                    个人
                                </a-radio>
                                <a-radio :value="2" >
                                    企业
                                </a-radio>
                            </a-radio-group>
                        </div>
                    </a-form-item>
                    <!--确定按钮-->
                    <a-form-item style="margin-top:24px" >
                        <a-button
                                size="default"
                                type= "primary"
                                class="bbutton"
                                :loading="loginLoading"
                                @click="handlelogin()"
                        >确定</a-button>
                    </a-form-item>

                </a-form>
            </div>
            <!-- 注册   -->
            <div class="big-contain" v-else>
                <a-form
                        id="formLogin"
                        class="user-layout-login"
                        ref="formLogin"
                        :form="form"
                >
                    <div class="btitle" >
                        <div v-if="personal">个人注册</div>
                        <div v-else>企业注册</div>
                    </div>
                    <div v-if="personal">
                        <a-form-item>
                            <a-input
                                    size="default"
                                    style="width: 500px ; vertical-align: middle ; display: block ; margin: 0 auto"
                                    placeholder="邮箱"
                                    v-decorator="[
              'registerUserMail',
              {rules: [{ required: true, message: '请输入邮箱' }], validateTrigger: 'blur'}]">
                                <a-icon slot="prefix" type="mail" :style="{ color: 'rgba(0,0,0,.25)' }"/>
                            </a-input>
                        </a-form-item>
                        <a-form-item>
                            <a-input
                                    size="default"
                                    style="width: 500px ; vertical-align: middle ; display: block ; margin: 0 auto"
                                    placeholder="用户名"
                                    v-decorator="[
              'registerUsername',
              {rules: [{ required: true, message: '请输入用户名' }], validateTrigger: 'blur'}]">
                                <a-icon slot="prefix" type="user" :style="{ color: 'rgba(0,0,0,.25)' }"/>
                            </a-input>
                        </a-form-item>
                        <a-form-item>
                            <a-input
                                    size="default"
                                    style="width: 500px ; vertical-align: middle ; display: block ; margin: 0 auto"
                                    placeholder="手机号"
                                    v-decorator="[
              'registerPhoneNumber',
              {rules: [{ required: true, message: '请输入手机号' }], validateTrigger: 'blur'}]">
                                <a-icon slot="prefix" type="phone" :style="{ color: 'rgba(0,0,0,.25)' }"/>
                            </a-input>
                        </a-form-item>
                        <a-form-item>
                            <a-input
                                    size="default"
                                    style="width: 500px ; vertical-align: middle ; display: block ; margin: 0 auto"
                                    type="password"
                                    placeholder="密码"
                                    v-decorator="[
                'registerPassword',
                {rules: [{ required: true, message: '请输入密码' }, { validator: this.handlePassword }], validateTrigger: 'blur'}]">
                                <a-icon slot="prefix" type="lock" :style="{ color: 'rgba(0,0,0,.25)' }"/>
                            </a-input>
                        </a-form-item>
                        <a-form-item>
                            <a-input
                                    size="default"
                                    style="width: 500px ; vertical-align: middle ; display: block ; margin: 0 auto"
                                    type="password"
                                    placeholder="确认密码"
                                    v-decorator="[
                'registerPasswordconfirm',
                {rules: [{ required: true, message: '请输入密码' }, { validator: this.handlePasswordCheck }], validateTrigger: 'blur'}]">
                                <a-icon slot="prefix" type="lock" :style="{ color: 'rgba(0,0,0,.25)' }"/>
                            </a-input>
                        </a-form-item>
                    </div>
                    <!--                        </a-tab-pane>-->

                    <!--                        <a-tab-pane key="tab2" tab="企业">-->
                    <div v-else>
                        <a-form-item>
                            <div class="clearfix">
                                <a-upload
                                        name="file"
                                        action="https://www.mocky.io/v2/5cc8019d300000980a055e76"
                                        list-type="picture-card"
                                        :customRequest="customRequest"
                                        :file-list="fileList"
                                        @preview="handlePreview"
                                        @change="handleChange"
                                >
                                    <div v-if="fileList.length < 8">
                                        <a-icon type="plus" />
                                        <div class="ant-upload-text">
                                            营业执照
                                        </div>
                                    </div>
                                </a-upload>
                                <a-modal :visible="previewVisible" :footer="null" @cancel="handleCancel">
                                    <img alt="example" style="width: 100%" :src="previewImage" />
                                </a-modal>
                            </div>
                        </a-form-item>
                        <a-form-item>
                            <a-input
                                    size="default"
                                    style="width: 500px ; vertical-align: middle ; display: block ; margin: 0 auto"
                                    type="user"
                                    placeholder="企业全称"
                                    v-decorator="[
              'registerEnterpriseName',
              {rules: [{ required: true,  message: '请输入企业全称' ,px: 500}], validateTrigger: 'blur'}]">
                                <a-icon slot="prefix" type="home" :style="{ color: 'rgba(0,0,0,.25)' }"/>
                            </a-input>
                        </a-form-item>
                        <a-form-item>
                            <a-input
                                    size="default"
                                    style="width: 500px ; vertical-align: middle ; display: block ; margin: 0 auto"
                                    placeholder="企业注册号/信用码"
                                    v-decorator="[
              'registerRegistrationID',
              {rules: [{ required: true, message: '请输入企业注册号/信用码' }], validateTrigger: 'blur'}]">
                                <a-icon slot="prefix" type="book" :style="{ color: 'rgba(0,0,0,.25)' }"/>
                            </a-input>
                        </a-form-item>
                        <a-form-item>
                            <a-input
                                    size="default"
                                    style="width: 500px ; vertical-align: middle ; display: block ; margin: 0 auto"
                                    placeholder="企业联系人"
                                    v-decorator="[
              'registerContacts',
              {rules: [{ required: true, message: '请输入企业联系人' }], validateTrigger: 'blur'}]">
                                <a-icon slot="prefix" type="contacts" :style="{ color: 'rgba(0,0,0,.25)' }"/>
                            </a-input>
                        </a-form-item>
                        <a-form-item>
                            <a-input
                                    size="default"
                                    style="width: 500px ; vertical-align: middle ; display: block ; margin: 0 auto"
                                    type="email"
                                    placeholder="邮箱"
                                    v-decorator="[
              'registerEmail',
              {rules: [{ required: true, message: '请输入邮箱' }], validateTrigger: 'blur'}]">
                                <a-icon slot="prefix" type="mail" :style="{ color: 'rgba(0,0,0,.25)' }"/>
                            </a-input>
                        </a-form-item>
                        <a-form-item>
                            <a-input
                                    size="default"
                                    style="width: 500px ; vertical-align: middle ; display: block ; margin: 0 auto"
                                    placeholder="联系方式"
                                    v-decorator="[
              'registerEPhoneNumber',
              {rules: [{ required: true, message: '请输入联系方式' }], validateTrigger: 'blur'}]">
                                <a-icon slot="prefix" type="phone" :style="{ color: 'rgba(0,0,0,.25)' }"/>
                            </a-input>
                        </a-form-item>


                        <a-form-item>
                            <a-input
                                    size="default"
                                    style="width: 500px ; vertical-align: middle ; display: block ; margin: 0 auto"
                                    type="password"
                                    placeholder="密码"
                                    v-decorator="[
                'registerEPassword',
                {rules: [{ required: true, message: '请输入密码' }, { validator: this.handlePassword }], validateTrigger: 'blur'}]">
                                <a-icon slot="prefix" type="lock" :style="{ color: 'rgba(0,0,0,.25)' }"/>
                            </a-input>
                        </a-form-item>
                        <a-form-item>
                            <a-input
                                    size="default"
                                    style="width: 500px ; vertical-align: middle ; display: block ; margin: 0 auto"
                                    type="password"
                                    placeholder="确认密码"
                                    v-decorator="[
                'registerEPasswordconfirm',
                {rules: [{ required: true, message: '请输入密码' }, { validator: this.handlePasswordCheck }], validateTrigger: 'blur'}]">
                                <a-icon slot="prefix" type="lock" :style="{ color: 'rgba(0,0,0,.25)' }"/>
                            </a-input>
                        </a-form-item>

                    </div>
                    <a-form-item>
                        <div style="width: 200px;height: 100px;position: absolute; left: 50%;margin-left: 200px">
                            <a-radio-group name="radioGroup"  @change="changePersonal" style="vertical-align: middle ; display: block ; margin: 0 auto">
                                <a-radio :value="1" >
                                    个人
                                </a-radio>
                                <a-radio :value="2" >
                                    企业
                                </a-radio>
                            </a-radio-group>
                        </div>
                    </a-form-item>
                    <a-form-item style="margin-top:24px" >
                        <a-button
                                size="default"
                                type= "primary"
                                class="sbutton"
                                :loading="loginLoading"
                                @click="handleRegister()"
                        >确定</a-button>
                    </a-form-item>
                    <!--                        </a-tab-pane>-->
                    <!--                    </a-tabs>-->
                </a-form>
            </div>
        </div>
        <div class="small-box" :class="{active:isLogin}" >
            <div class="small-contain" v-if="isLogin">
                <button class="changeButton" @click="changeType">注册</button>
            </div>
            <div class="small-contain" v-else>
                <button class="changeButton" @click="changeType">登录</button>
            </div>
        </div>
    </div>

    <!--    </div>-->
</template>

<script>
    import { message } from 'ant-design-vue'
    import Identify from '../components/SIdentify.vue'
    import {mapActions, mapGetters} from "vuex";

    function getBase64(file) {
        return new Promise((resolve, reject) => {
            const reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = () => resolve(reader.result);
            reader.onerror = error => reject(error);
        });
    }

    export default{
        name:'login-register',

        data(){
            return {
                personal:true,
                enterprise:false,

                previewVisible: false,
                previewImage: '',
                fileList: [],


                //验证码
                code: '',
                // 随机抽取四位数
                identifyCodes: '1234567890abcdef',
                identifyCode: '',
                checked: false,
                //验证码

                customActiveKey : 'tab1',
                loginLoading: false,
                registerLoading: false,
                form: this.$form.createForm(this),
                isLogin:true,
                emailError: false,
                passwordError: false,
                existed: false,
            }
        },
        computed: {
            ...mapGetters([
                'token',
                'Url'
            ])
        },
        components:{
            Identify
        },
        mounted() {
            this.identifyCode = ''
            this.makeCode(this.identifyCodes, 4)
        },

        watch: {
            $route: {
                handler: function(route) {
                    this.redirect = route.query && route.query.redirect
                },
                immediate: true
            },
        },

        methods:{

            ...mapActions([
                'login',
                'register',
                'uploadADImg'
            ]),

            changePersonal(){
                this.personal=!this.personal
                this.enterprise=!this.enterprise
            },


            customRequest (file) {
                file.preview = getBase64(file.originFileObj)
                const formData = new FormData()
                formData.append('file', file.file)
                console.log(formData)
                this.uploadADImg(formData)
            },


            changeType() {
                this.isLogin = !this.isLogin
                this.form.username = ''
                this.form.useremail = ''
                this.form.userpwd = ''
            },
            handleTabClick (key) {
                this.customActiveKey = key
            },


            handlePassword(rule, value, callback) {
                if (value.length < 6) {
                    callback(new Error('密码长度至少6位'))
                }
                callback()
            },
            handlePasswordCheck (rule, value, callback) {
                const password = this.form.getFieldValue('registerPassword')
                console.log(password)
                if (value === undefined) {
                    callback(new Error('请输入密码'))
                }
                if (value && password && value.trim() !== password.trim()) {
                    callback(new Error('两次密码不一致'))
                }
                callback()
            },



            handlelogin() {
                if(this.code !== this.identifyCode){
                    console.log("验证码错误")
                    message.error("验证码错误")
                    return 0
                }
                const validateFieldsKey =  ['username', 'password']
                this.form.validateFields(validateFieldsKey, { force: true }, async (err, values) => {
                    if(!err){
                        this.loginLoading = true
                        const data = {
                            email: this.form.getFieldValue("username"),
                            password: this.form.getFieldValue("password"),
                            ispersonal:this.personal
                        }
                        console.log(data)
                        await this.login(data)
                        this.loginLoading = false
                    }
                })
            },

            handleRegister() {
                const { form: { validateFields } } = this
                const validateFieldsKey = this.personal ? ['registerUsername','registerPhoneNumber','registerUserMail','registerPassword','registerPasswordconfirm']:['registerEnterpriseName','registerRegistrationID','registerContacts','registerEmail','registerEPhoneNumber','registerEPassword','registerEPasswordconfirm']
                validateFields(validateFieldsKey, { force: true }, async (err, values) => {
                    if (!err) {
                        this.registerLoading = true

                        if(this.personal){
                            const data = {
                                email: this.form.getFieldValue('registerUserMail'),
                                password: this.form.getFieldValue('registerPassword'),
                                phoneNumber: this.form.getFieldValue('registerPhoneNumber'),
                                username: this.form.getFieldValue('registerUsername'),
                                userType: "0"
                            }
                            console.log(data)
                            await this.register(data).then(() => {
                                this.form.setFieldsValue({
                                    'registerUserMail': '',
                                    'registerPassword': '',
                                    'registerPasswordconfirm': ''
                                })
                            })
                        }else{
                            const data={
                                name:this.form.getFieldValue('registerEnterpriseName'),
                                registerNumber:this.form.getFieldValue('registerRegistrationID'),
                                contactName:this.form.getFieldValue('registerContacts'),
                                email:this.form.getFieldValue('registerEmail'),
                                contactNumber:this.form.getFieldValue('registerEPhoneNumber'),
                                password:this.form.getFieldValue('registerEPassword'),
                                license:this.Url,
                                userType:'1'
                            }
                            console.log(data)
                            await this.register(data).then(() => {
                                this.Url=''
                                this.form.setFieldsValue({
                                    'registerEnterpriseName':'',
                                    'registerRegistrationID':'',
                                    'registerContacts':'',
                                    'registerEmail': '',
                                    'registerEPassword': '',
                                    'registerEPasswordconfirm': ''
                                })
                            })
                        }
                        this.registerLoading = false
                    }
                });
            },


            handleCancel() {
                this.previewVisible = false;
            },
            async handlePreview(file) {
                if (!file.url && !file.preview) {
                    file.preview = await getBase64(file.originFileObj);
                }
                this.previewImage = file.url || file.preview;
                this.previewVisible = true;
            },
            handleChange({ fileList }) {
                this.fileList = fileList;
                console.log(this.fileList)
            },


            // 验证码处理
            randomNum(min, max) {
                return Math.floor(Math.random() * (max - min) + min)
            },

            // 刷新验证码
            refreshCode() {
                this.identifyCode = ''
                this.makeCode(this.identifyCodes, 4)
            },
            makeCode(o, l) {
                for (let i = 0; i < l; i++) {
                    this.identifyCode += this.identifyCodes[
                        this.randomNum(0, this.identifyCodes.length)
                        ]
                }
                console.log(this.identifyCode)
            }

        }
    }
</script>

<style scoped="scoped">
    .login-register{
        width: 100vw;
        height: 100%;
        box-sizing: border-box;
    }
    .contain{
        width: 60%;
        height: 90%;
        position: relative;
        top: 50%;
        left: 45%;
        transform: translate(-50%,-50%);
        background-color: #fff;
        border-radius: 20px;
        box-shadow: 0 0 3px #f0f0f0,
        0 0 6px #f0f0f0;
    }
    .big-box{
        width: 70%;
        height: 100%;
        position: absolute;
        top: 0;
        left: 30%;
        transform: translateX(0%);
        transition: all 1s;
    }
    .big-contain{
        width: 100%;
        height: 100%;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }
    .btitle{
        text-align: center;
        font-size: 1.5em;
        font-weight: bold;
        margin-bottom: 20px;
        color: rgba(105, 0 , 75, 0.8);
    }
    .bform{
        width: 100%;
        height: 60%;
        padding: 2em 0;
        display: flex;
        flex-direction: column;
        justify-content: space-around;
        align-items: center;
    }
    .bform .errTips{
        display: block;
        width: 50%;
        text-align: left;
        color: red;
        font-size: 0.7em;
        margin-left: 1em;
    }
    .bform input{
        width: 50%;
        height: 30px;
        border: none;
        outline: none;
        border-radius: 10px;
        padding-left: 2em;
        background-color: #f0f0f0;
    }

    .bbutton{
        width: 30%;
        height: 40px;
        border-radius: 24px;
        border: none;
        outline: none;
        background-color: rgba(105, 0 , 75, 0.8);
        color: #fff;
        font-size: 0.9em;
        cursor: pointer;
        text-align: center;
        margin: auto;
        float: left;
        left: 35%;

    }
    .small-box{
        width: 30%;
        height: 100%;
        background: linear-gradient(135deg,rgb(106, 0, 106),rgb(105,0,75));
        position: absolute;
        top: 0;
        left: 0;
        transform: translateX(0%);
        transition: all 1s;
        border-top-left-radius: inherit;
        border-bottom-left-radius: inherit;
    }
    .small-contain{
        width: 100%;
        height: 100%;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }

    .sbutton{
        width: 15%;
        height: 40px;
        border-radius: 24px;
        border: none;
        outline: none;
        background-color: rgba(105, 0 , 75, 0.8);
        color: #fff;
        font-size: 0.9em;
        cursor: pointer;
        text-align: center;
        margin: auto;
        float: left;
        left: 45%;

    }

    .changeButton{
        font-size: 18px;
        width: 60%;
        height: 40px;
        border-radius: 24px;
        border: 1px solid #fff;
        outline: none;
        background-color: transparent;
        color: #fff;
        font-size: 0.9em;
        cursor: pointer;
    }
    .big-box.active{
        left: 0;
        transition: all 0.5s;
    }
    .small-box.active{
        left: 100%;
        border-top-left-radius: 0;
        border-bottom-left-radius: 0;
        border-top-right-radius: inherit;
        border-bottom-right-radius: inherit;
        transform: translateX(-100%);
        transition: all 1s;
    }



</style>