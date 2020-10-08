import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/login.vue'
import Home from '../views/home.vue'

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
        path: '/',
        redirect: '/home'
    },
    {
        path: '/NJUSE',
        name: 'layout',
        redirect: '/credit/main',
        component: ()=> import('@/views/layout'),
        children: [
            {
                path: '/credit/main',
                name: 'main',
                component: () => import('@/views/credit/blank')
            },
            {
                path: '/user/info/:userId',
                name: 'userInfo',
                component: () => import('@/views/user/info')
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

export default router
