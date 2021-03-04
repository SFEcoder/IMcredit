import Vue from 'vue'
import axios from 'axios'
import { VueAxios } from './axios'
import {notification, message} from 'ant-design-vue'
import store from '@/store'
import { getToken, setToken} from '@/utils/auth'
import { getAccessToken } from '@/api/user'
import NProgress from 'nprogress'
// 创建 axios 实例
const service = axios.create({
    baseURL: process.env.NODE_ENV === 'production' ? 'http://localhost:8040': "http://localhost:8040",
    withCredentials: true
})
console.log(process.env.NODE_ENV)
const err = (error) => {
    console.log("in")
    if (error.response) {
        const data = error.response.data
        const token = Vue.ls.get('ACCESS_TOKEN')
        if (error.response.status === 403) {
            notification.error({
                message: 'Forbidden' ,
                description: data.message
            })
        }
        if (error.response.status === 401 && !(data.result && data.result.isLogin)) {
            notification.error({
                message: 'Unauthorized' ,
                description: 'Authorization verification failed'
            })
            if (token) {
                store.dispatch('Logout').then(() => {
                    setTimeout(() => {
                        window.location.reload()
                    } , 1500)
                })
            }
        }
    }

}

//request incerceptor
service.interceptors.request.use((config) => {
    if(store.getters.port_change){
        config.baseURL = 'http://localhost:8002'
    }else{
        config.baseURL = 'http://localhost:8040'
    }
    const requestConfig = {
        ...config,
        url: `${config.url}`,
    }
    console.log(requestConfig.baseURL+requestConfig.url)
    if (store.getters.access_token) {
        const authorization = config.headers['Authorization']
        if (authorization === undefined || authorization.indexOf('Basic') === -1) {
            config.headers['Authorization'] = 'Bearer ' + store.getters.access_token // 让每个请求携带token
        }
        console.log(config.headers['Authorization'])
    }
    return requestConfig
}, err)

service.interceptors.response.use((response) => {
    switch (response.status) {
        case 200:
            console.log()
            if(response.data.success){
                return response.data.content
            }
            if(response.data.access_token){
                return response
            }
            message.error(response.data.message)
            break
        case 404:
            return false
        default:
            message.error(response.data.message)
    }
},error => {
    NProgress.done()
    if (error.response) {
        const originalRequest = error.config
        // 接口返回401并且已经重试过，自动刷新token
        if ((error.response.status === 401 || error.response.status === 403)) {
            // 退出请求
            store.commit('set_port_change' , true)
            console.log(store.getters.port_change)
            return getAccessToken().then(response => {
                // 保存新的token
                setToken(response.data.access_token)
                store.commit('set_access_token' , response.data.access_token)
                // 带上新的token
                originalRequest.headers['Authorization'] = 'Bearer ' + response.data.access_token
                // 重新请求
                store.commit('set_port_change' , false)
                console.log(originalRequest)
                return axios(originalRequest).then(response =>{
                    switch (response.status) {
                        case 200:
                            console.log()
                            if(response.data.success && response.data.success){
                                return response.data.content
                            }
                            if(response.data.access_token){
                                return response
                            }
                            message.error(response.data.message)
                            break
                        case 404:
                            return false
                        default:
                            message.error(response.data.message)
                    }
                })
            }).catch(() => {
                // 刷新失败，执行退出
                store.dispatch('logout').then(() => location.reload())
            })
        }
        return Promise.reject(error)
    }
    return Promise.reject(new Error(error))
})

const installer = {
    vm: {},
    install (Vue) {
        Vue.use(VueAxios, service)
    }
}

export {
    installer as VueAxios,
    service as axios
}
