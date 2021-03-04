<template>
    <div class="home">

    </div>
</template>

<script>
    import { mapGetters, mapMutations, mapActions } from 'vuex'
    export default {

        name: 'Home',

        methods: {
            ...mapActions([
                'test',
            ]),
            jumpToLogin(){
                this.test()
                // this.$router.push(`/login?redirect='/credit/main'`)
                this.$router.push(`/login`)

            }
        },
      mounted() {
        $(function () {
          $('.toHide').fadeIn()
          $('.toHideHeader').fadeIn()
        })

      },


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
