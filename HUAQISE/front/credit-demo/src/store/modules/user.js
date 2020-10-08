
import router from '@/router'
import {  setToken, removeToken } from '@/utils/auth'
import { resetRouter } from '@/router'
import { message } from 'ant-design-vue'
import {
    loginAPI,
    registerAPI,
    getUserInfoAPI,
    updateUserInfoAPI,
} from '@/api/user'

const getDefaultState = () => {
    return {
        userId: '',
        userInfo: {

        },
    }
}

const user = {//定义对象user
    state: getDefaultState() ,//user中定义的state对象（符合模板中module的定义）

    mutations: {//参见index中的module
        reset_state: function (state) {
            state.infoCredit = '',
                state.token = '',
                state.userId = '',
                state.userInfo = {}
        } ,

        set_token: function (state , token) {
            state.token = token
        } ,
        set_userId: (state , data) => {
            state.userId = data
        } ,

        set_userInfo: (state , data) => {
            state.userInfo = {
                ...state.userInfo ,
                ...data
            }
        } ,
    },

    actions: {
        login: async ({dispatch , commit} , userData) => {
            const res = await loginAPI(userData)
            if (res) {
                setToken(res.id)//从'@/utils/auth'中导入的方法
                commit('set_userId' , res.id)
                dispatch('getUserInfo')
                router.push('/credit/main')//mutations的方法用commit，actions的方法用dispatch
            }
        } ,

        register: async ({commit},data) => {
            const res = await registerAPI(data)
            if (res) {
                message.success('注册成功')
            }
        } ,
        getUserInfo({state , commit}) {
            return new Promise((resolve , reject) => {
                getUserInfoAPI(state.userId).then(response => {
                    const data = response
                    if (!data) {
                        reject('登录已过期，请重新登录')
                    }
                    commit('set_userInfo' , data)
                    commit('set_userId' , data.id)
                    console.log('getUserInfo')
                    resolve(data)
                }).catch(error => {
                    reject(error)
                })
            })
        } ,
        updateUserInfo: async ({state , dispatch} , data) => {
            const params = {
                id: state.userId ,
                ...data ,
            }
            const res = await updateUserInfoAPI(params)
            if (res) {
                message.success('修改成功')
                dispatch('getUserInfo')
            }
        } ,

        logout: async ({commit}) => {
            removeToken()
            resetRouter()
            commit('reset_state')
        } ,
        // remove token
        resetToken({commit}) {
            return new Promise(resolve => {
                removeToken() // must remove  token  first
                commit('reset_state')
                resolve()
            })
        } ,

    }
}

export default user
