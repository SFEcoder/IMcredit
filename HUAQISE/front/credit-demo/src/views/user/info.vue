<template>
    <div class="info-wrapper">

        <a-tabs>
            <a-tab-pane tab="我的信息" key="1">

                <a-form :form="form" style="margin-top: 30px">
                    <a-form-item label="头像" :label-col="{ span: 3 }" :wrapper-col="{ span: 8, offset: 1  }">
                        <img
                                alt="example"
                                :src=this.userInfo.avatarUrl
                                width="240px"
                                height="240px"
                        />
                    </a-form-item>

                    <a-form-item label="用户名" :label-col="{ span: 3 }" :wrapper-col="{ span: 8, offset: 1  }">
                        <a-input
                                placeholder="请填写用户名"
                                v-decorator="['username', { rules: [{ required: true, message: '请输入用户名' }] }]"
                                v-if="modify"
                        />
                        <span v-else>{{ userInfo.username }}</span>
                    </a-form-item>
                    <a-form-item label="邮箱" :label-col="{ span: 3 }" :wrapper-col="{ span: 8, offset: 1 }">
                        <span>{{ userInfo.email }}</span>
                    </a-form-item>

                    <a-form-item label="手机号" :label-col="{ span: 3 }" :wrapper-col="{ span: 8, offset: 1 }">
                        <a-input
                                placeholder="请填写手机号"
                                v-decorator="['phoneNumber', { rules: [{ required: true, message: '请输入手机号' }] }]"
                                v-if="modify"
                        />
                        <span v-else>{{ userInfo.phoneNumber}}</span>
                    </a-form-item>
                    <a-form-item label="密码" :label-col="{ span: 3 }" :wrapper-col="{ span: 8, offset: 1 }" v-if="modify">
                        <a-input
                                placeholder="请输入新密码"
                                v-decorator="['password', { rules: [{ required: true, message: '请输入新密码' }] }]"
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
        },
        methods: {
            ...mapActions([
                'getUserInfo',
                'updateUserInfo',
            ]),
            saveModify() {
                this.form.validateFields((err, values) => {
                    if (!err) {
                        const data = {
                            username: this.form.getFieldValue('username'),
                            phoneNumber: this.form.getFieldValue('phoneNumber'),
                            password: this.form.getFieldValue('password')
                        }
                        this.updateUserInfo(data).then(()=>{
                            this.modify = false
                        })
                    }
                });
            },
            modifyInfo() {
                setTimeout(() => {
                    this.form.setFieldsValue({
                        'username': this.userInfo.username,
                        'phoneNumber': this.userInfo.phoneNumber,
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
