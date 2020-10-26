<template>
    <div>
        <div class="wrapper row-offcanvas">
            <left_side></left_side>

            <right_side>
                <transition name="fade-transform" mode="out-in">
                    <router-view></router-view>
                </transition>
            </right_side>

        </div>


    </div>
</template>
<script>
    import right_side from '@/components/layouts/right-side'
    import left_side from '@/components/layouts/left-side/left-side'
    import '@/assets/sass/custom.scss'
    import '@/components/layouts/css/fixed-menu.scss'
    import anime from 'animejs'

    export default {
        name: 'layout',
        components: {
            left_side,
            right_side
        },
        data() {
            return {}
        }
    }
</script>
<style lang="scss" scoped>
    .wrapper:before,
    .wrapper:after {
        display: table;
        content: " ";
    }

    .wrapper:after {
        clear: both;
    }

    .wrapper {
        display: table;
        overflow-x: hidden;
        width: 100%;
        max-width: 100%;
        table-layout: fixed
    }

    .right-aside,
    .left-aside {
        display: table-cell;
        vertical-align: top;
    }

    .right-aside {
        background-color: #ebf2f6 !important;
    }

    @media (max-width: 992px) {
        .wrapper > .right-aside {
            width: 100vw;
            min-width: 100vw;
        }
    }

    /* fade-transform */
    .fade-transform-leave-active,
    .fade-transform-enter-active {
        transition: all .5s;
    }

    .fade-transform-enter {
        opacity: 0;
        transform: translateX(-30px);
    }

    .fade-transform-leave-to {
        opacity: 0;
        transform: translateX(30px);
    }
</style>



