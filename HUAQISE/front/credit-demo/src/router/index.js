import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/login.vue'
import Home from '../views/home.vue'
import UserInfo from '../views/userinfo'
import ChangePersonInfo from "@/views/ChangePersonInfo"
import ChangeCompanyInfo from  "@/views/ChangeCompanyInfo"
Vue.use(VueRouter)
const routes = [
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
                path: '/user/info/:userId',
                name: '个人信息',
                component: () => import('@/views/user/info')
            },
            {
                path: '/ChangeCompanyInfo',
                name: 'ChangeCompanyInfo',
                component: ChangeCompanyInfo
            },
            {
                path: '/4',
                name: 'ChangePersonInfo',
                component: ChangePersonInfo
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
