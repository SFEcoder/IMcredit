<template>
    <div class="home">

        <a-button class="button_style" type="primary" size="large" @click="jumpToLogin">登录</a-button>
        <a-button class="button_style" type="primary" size="large">合作</a-button>
    </div>
</template>

<script>

    export default {
        name: 'Home',

        methods: {
            jumpToLogin(){
                // this.$router.push(`/login?redirect='/credit/main'`)
                this.$router.push(`/login`)
            }
        }
    }
</script>

<style lang="less" scoped>
    .home{
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: center;
        width: 1600px;
        height: 800px;
        .button_style {
            height: 200px;
            width: 400px;
            margin-right: 40px;
            border-radius:120px;
            font-weight: bold;
            font-size: 24px;
        }
    }
</style>
