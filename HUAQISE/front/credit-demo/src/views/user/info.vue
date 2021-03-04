
<template>
    <div class="info-wrapper">

        <a-tabs>
            <a-tab-pane tab="自己的信息" key="1">

                <a-form v-if="this.userInfo.userType === 1" :form="form" style="margin-top: 30px" >
                    <a-upload
                        name="file"
                        :customRequest="customRequest_enterprise"
                        :showUploadList = false
                    >
                        <img
                            style="margin-left:60px;width:80px;height:80px;border-radius:150px;"
                                :src= this.userInfo.ephoto
                        />
                        <a-tag color="" style="margin-left: 40px; font-size: 16px" icon="cloud-upload">修改头像</a-tag>
                    </a-upload>
                    <a-divider/>


                    <a-form-item label="企业的全称" :label-col="{ span: 3 }" :wrapper-col="{ span: 8, offset: 1  }">
                        <span >{{ userInfo.name }}</span>
                    </a-form-item>
                    <a-divider/>

                    <a-form-item label="企业注册号" :label-col="{ span: 3 }" :wrapper-col="{ span: 8, offset: 1  }">
                        <span >{{ userInfo.registerNumber }}</span>
                    </a-form-item>
                    <a-divider/>

                    <a-form-item label="联系人姓名" :label-col="{ span: 3 }" :wrapper-col="{ span: 8, offset: 1  }">

                        <a-input
                                placeholder="请填写联系人姓名"
                                v-decorator="['contactName', { rules: [{ required: false, message: '请输入联系人姓名' }] }]"
                                v-if="modify"
                        />
                        <span v-else>{{ userInfo.contactName}}</span>
                    </a-form-item>

                    <a-form-item label="企业邮箱号" :label-col="{ span: 3 }" :wrapper-col="{ span: 8, offset: 1 }">

                        <a-input
                                placeholder="请填写企业邮箱号"
                                v-decorator="['email', { rules: [{ required: false, message: '请输入企业邮箱号' }] }]"
                                v-if="modify"
                        />
                        <span v-else>{{ userInfo.email}}</span>

                    </a-form-item>
                    <a-divider/>

                    <a-form-item label="联系方式" :label-col="{ span: 3 }" :wrapper-col="{ span: 8, offset: 1 }">
                        <a-input
                                placeholder="请填写手机号"
                                v-decorator="['contactNumber', { rules: [{ required: false, message: '请输入手机号' }] }]"
                                v-if="modify"
                        />
                        <span v-else>{{ userInfo.contactNumber}}</span>
                    </a-form-item>
                    <a-divider/>

                    <a-form-item label="营业执照" :label-col="{ span: 3 }" :wrapper-col="{ span: 8, offset: 1 }">
                        <a-upload>
                            <img
                                    style="margin-left:0px;width:150px;height:150px;"
                                    alt="example"
                                    :src= this.userInfo.avatarUrl
                            />

                        </a-upload>

                    </a-form-item>
                    <a-divider/>

                    <a-form-item label="评级" :label-col="{ span: 3 }" :wrapper-col="{ span: 8, offset: 1 }">
                        <span>{{ userInfo.egrade }}</span>
                    </a-form-item>
                    <a-divider/>


                    <a-form-item label="密码" :label-col="{ span: 3 }" :wrapper-col="{ span: 8, offset: 1  }">

                        <a-input
                                placeholder="请输入新密码"
                                v-decorator="['password', { rules: [{ required: false, message: '请输入新密码' }] }]"
                                v-if="modify"
                        />


                    </a-form-item>


                    <a-form-item :wrapper-col="{ span: 12, offset: 5 }" v-if="modify">
                        <a-button type="primary" @click="saveModify">
                            保存
                        </a-button>
                        <a-button type="default" style="margin-left: 30px" @click="cancelModify">
                            取消
                        </a-button>
                    </a-form-item>

                    <a-form-item :wrapper-col="{ span: 8, offset: 4 }" v-else>
                        <a-button type="primary" @click="modifyInfo" style="margin-right: 30px">
                            修改信息
                        </a-button>
                    </a-form-item>
                </a-form >


                <a-form :form="form" style="margin-top: 30px" v-else>
                    <a-upload
                        name="file"
                        :customRequest="customRequest_user"
                        :showUploadList = false
                    >
                        <img
                                style="margin-left:60px;width:80px;height:80px;border-radius:150px;"
                                :src= this.userInfo.avatarUrl
                        />
                        <a-tag color="" style="margin-left: 40px; font-size: 16px" icon="cloud-upload">修改头像</a-tag>
                    </a-upload>
                    <a-divider/>

                    <a-form-item label="个人昵称" :label-col="{ span: 3 }" :wrapper-col="{ span: 8, offset: 1  }">
                        <a-input
                                placeholder="请填写联系人姓名"
                                v-decorator="['username', { rules: [{ required: false, message: '请输入联系人姓名' }] }]"
                                v-if="modify"
                        />
                        <span v-else>{{ userInfo.username}}</span>
                    </a-form-item>

                    <a-divider/>

                    <a-form-item label="个人邮箱" :label-col="{ span: 3 }" :wrapper-col="{ span: 8, offset: 1 }">

                        <a-input
                                placeholder="请填写企业邮箱号"
                                v-decorator="['email', { rules: [{ required: false, message: '请输入邮箱号' }] }]"
                                v-if="modify"
                        />
                        <span v-else>{{ userInfo.email}}</span>

                    </a-form-item>
                    <a-divider/>

                    <a-form-item label="联系方式" :label-col="{ span: 3 }" :wrapper-col="{ span: 8, offset: 1 }">
                        <a-input
                                placeholder="请填写手机号"
                                v-decorator="['phoneNumber', { rules: [{ required: false, message: '请输入手机号' }] }]"
                                v-if="modify"
                        />
                        <span v-else>{{ userInfo.phoneNumber}}</span>
                    </a-form-item>
                    <a-divider/>




                    <a-form-item label="个人密码" :label-col="{ span: 3 }" :wrapper-col="{ span: 8, offset: 1  }">

                        <a-input
                                placeholder="请输入新密码"
                                v-decorator="['password', { rules: [{ required: false, message: '请输入新密码' }] }]"
                                v-if="modify"
                        />
                      <span v-else>**********</span>


                    </a-form-item>



                    <a-form-item :wrapper-col="{ span: 12, offset: 5 }" v-if="modify">
                        <a-button type="primary" @click="saveModify">
                            保存
                        </a-button>
                        <a-button type="default" style="margin-left: 30px" @click="cancelModify">
                            取消
                        </a-button>
                    </a-form-item>

                    <a-form-item :wrapper-col="{ span: 8, offset: 4 }" v-else>
                        <a-button type="primary" @click="modifyInfo" style="margin-right: 30px">
                            修改信息
                        </a-button>
                    </a-form-item>
                </a-form>



            </a-tab-pane>
        </a-tabs>
    </div>
</template>



<script>
    import { mapGetters, mapMutations, mapActions } from 'vuex'
    export default {
        name: 'info',
        data(){
            return {
                type:false,
                modify: false,
                formLayout: 'horizontal',
                pagination: {},
                form: this.$form.createForm(this, { name: 'coordinated' }),
                appealed: false,
                detailReplyVisible:false,
                showInputModal:false,
                replyVal:'',
                toId:'',
                toName:'',
                toAvatar:'',
                commentId:'',
                replyTitle:'',
                content:'',
            }
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
          console.log(this.userInfo)
        },
        methods: {
            ...mapActions([
                'getUserInfo',
                'updateUserInfo',
                'updateEnterprise',
                'upload_user_avatar',
                'upload_ephoto'
            ]),
          customRequest_user (data) {
            const formData = new FormData()
            formData.append('file', data.file)
            this.upload_user_avatar(formData)
          },
          customRequest_enterprise (data) {
            const formData = new FormData()
            formData.append('file', data.file)
            this.upload_ephoto(formData)
          },
            saveModify() {
                this.form.validateFields((err, values) => {
                    if (!err) {

                        if(this.userInfo.type === 1){
                          const data = {
                            contactName: this.form.getFieldValue('contactName'),
                            contactNumber: this.form.getFieldValue('contactNumber'),
                            email: this.form.getFieldValue('email'),
                            password: this.form.getFieldValue('password')
                          }
                          this.updateEnterprise(data)
                        }
                        else {
                          const data = {
                            username: this.form.getFieldValue('username'),
                            phoneNumber: this.form.getFieldValue('phoneNumber'),
                            email: this.form.getFieldValue('email'),
                            password: this.form.getFieldValue('password')
                          }
                          this.updateUserInfo(data).then(() => {
                            this.modify = false
                          })
                        }
                    }
                });
            },
            modifyInfo() {
                setTimeout(() => {
                    this.form.setFieldsValue({
                        'username': this.userInfo.username,
                        'phoneNumber': this.userInfo.phoneNumber,
                        'email':this.userInfo.email,
                    })
                }, 0)
                this.modify = true
            },
            cancelModify() {
                this.modify = false
            },
        }
    }
</script>


<style scoped lang="less">
    .info-wrapper {
        padding: 50px;
        .chart {
            display: flex;
            align-items: center;
            justify-content: space-between;
            margin-top: 20px
        }
    }
</style>



<style lang="less">
    .info-wrapper {
        .ant-tabs-bar {
            padding-left: 30px
        }
    }
</style>
<style lang="less">

</style>
