import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/user/login.vue'
import Home from '../views/home.vue'
Vue.use(VueRouter)
const routes = [
    {
        path: '/',
        redirect : '/home'
    },
    {
        path: '/login',
        name: 'login',
        component: Login
    },
    {
        path: '/home',
        name: 'home',
        component: Home
    },

    {
        path: '/NJUSE',
        name: 'layout',
        redirect: '/credit/display',
        component: ()=> import('@/views/layout'),
        children: [
            {
                path: '/credit/display',
                name: '评级公示',
                component: () => import('@/views/credit/display')
            },
            {
                path: '/credit/history',
                name: '浏览记录',
                component: () => import('@/views/credit/history')
            },
            {
                path : '/credit/report',
                name:"评级报告",
                component: () => import('@/views/credit/report')
            },
            {
                path: '/user/info/:userId',
                name: '个人信息',
                component: () => import('@/views/user/info')
            },
            {
                path: '/QandA/about_privacy',
                name: '关于企业评级隐私',
                component: () => import('@/views/QandA/about_privacy')
            },
            {
                path: '/QandA/pdf_guide',
                name: '信用报告生成教程',
                component: () => import('@/views/QandA/pdf_guide')
            },
            {
                path: '/QandA/reg_eva_guide',
                name: '公司注册、参评指南',
                component: () => import('@/views/QandA/register_evaluate_guide')
            },
            {
                path: '/credit/evaluate',
                name: '申请评级',
                component: () => import('@/views/credit/evaluateGuide'),
                redirect:  '/credit/evaluate/enterpriseType',
                children:[
                    {
                        path: '/credit/evaluate/enterpriseType',
                        name: '选择企业类型',
                        component: () => import('@/views/credit/evaluate/enterpriseType')
                    },
                    {
                        path: '/credit/evaluate/integration_indicators',
                        name: "两化融合指标体系",
                        component:()=> import("@/views/credit/evaluate/integration_indicators")
                    },
                    {
                        path: '/credit/evaluate/financial_index',
                        name: "财务指标",
                        component:()=> import("@/views/credit/evaluate/financial_index")
                    },
                    {
                        path: '/credit/evaluate/finished_input',
                        name : "填写完毕，至“我的评级”菜单栏下选择“查看报告”进行报告浏览",
                        component: () => import("@/views/credit/evaluate/index_finished")
                    }
                ]
            },
            ]
    },
]
const createRouter = () => new VueRouter({
    // mode: 'history', // require service support
    scrollBehavior: () => ({ y: 0 }),
    routes
})
const router = createRouter()

export function resetRouter() {
    const newRouter = createRouter()
    router.matcher = newRouter.matcher // reset router
}

const VueRouterPush = VueRouter.prototype.push
VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
}

export default router
