<template>
    <div class="header">
        <div class="label">
            <img src="@/assets/temp.jpg" class="logo" alt="logo">
            <span class="title">NJUSE 智能信用评估系统</span>

        </div>
        <div class="logout">
            <a-dropdown placement="bottomCenter">
                <div class="user">
                    <a-avatar :src=userInfo.avatarUrl></a-avatar>
                    <span style="font-size: 14px">{{ userInfo.userName }}</span>
                    <a-icon style="margin-left: 3px; font-size: 16px" type="down"></a-icon>
                </div>
                <a-menu slot="overlay">
                    <a-menu-item  @click="jumpToHome()">
                        <a-icon type="home"></a-icon>
                        首页
                    </a-menu-item>
                    <a-menu-item @click="jumpToUserInfo()">
                        <a-icon type="profile"></a-icon>
                        我的信息
                    </a-menu-item>
                    <a-menu-item @click="quit()">
                        <a-icon type="poweroff"></a-icon>
                        退出登录
                    </a-menu-item>
                </a-menu>
            </a-dropdown>
        </div>

    </div>

</template>
<script>
    import { mapGetters, mapActions, mapMutations } from 'vuex'
    export default {
        name: '',
        data() {
            return {
                current: ['1'],
                theme:''
            }
        },
        computed: {
            ...mapGetters([
                'userId',
                'userInfo',
            ])
        },
        mounted() {

        },
        created(){
            this.getUserInfo()
        },
        methods: {
            ...mapActions([
                'logout',
                'getUserInfo'
            ]),
            async quit() {
                await this.$store.dispatch('logout')
                this.$router.push(`/login?redirect=${this.$route.fullPath}`)
            },
            jumpToUserInfo() {
                this.$router.push({ name: 'userInfo', params: { userId: this.userId } })
            },
            jumpToHome(){
                this.$router.push(`/credit/main`)
            }
        }
    }
</script>
<style scoped lang="less">
    .header {
        display: flex;
        line-height: 44px;
        height: 44px;
        align-items: center;
        justify-content: space-between;
        min-width: 800px;
        .label{
            height: 44px;
            line-height: 44px;
            vertical-align: middle;
            min-width: 400px;

            .logo {
                height: 44px;
                vertical-align: top;
                margin-right: 16px;
                border-style: none;
                cursor: pointer;
            }

            .title {
                font-size: 33px;
                color: rgba(0, 0, 0, .85);
                font-family: Avenir, 'Helvetica Neue', Arial, Helvetica, sans-serif;
                font-weight: 600;
                position: relative;
                top: 2px;
            }

            .search {
                width: 300px;
                margin-left: 30px
            }
        }
        .logout {
            margin-right: 40px;
            .user {
                cursor: pointer;
                display:flex;
                align-items: center;
                span {
                    margin-left: 5px
                }
            }
        }

    }
</style>
<style lang="less">
    .header {
        .ant-menu {
            background: none
        }
    }
</style>
