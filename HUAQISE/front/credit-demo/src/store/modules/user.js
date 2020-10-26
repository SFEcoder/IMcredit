
import router from '@/router'
import {  setToken, removeToken } from '@/utils/auth'
import { resetRouter } from '@/router'
import { message } from 'ant-design-vue'
import {
    CloginAPI,
    CregisterAPI,
    getUserInfoAPI,
    updateUserInfoAPI,
} from '@/api/user'
import {
    EloginAPI,
    EregisterAPI,
    getEnterpriseAPI,
    updateEnterpriseAPI,
} from '@/api/enterprise'
import {
    uploadImgAPI
}from '@/api/oss'
import { decrypt , encrypt,getKey } from "../../utils/aes";

const getDefaultState = () => {
    return {
        personal:true,
        Url:'',
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
                state.Url='',
                state.userInfo = {}
        } ,

        set_token: function (state , token) {
            state.token = token
        } ,
        set_userId: (state , data) => {
            state.userId = data
        } ,

        set_personal: function(state , data){
            state.personal = data
        },

        set_userInfo: (state , data) => {
            state.userInfo = {
                ...state.userInfo ,
                ...data
            }
        } ,
    },

    actions: {
        // test: async ({dispatch , commit})=>{
        //     let str = 'wyx'
        //     let keypair=rsa_generate()
        //     let str_en = rsa_encrypt(str,keypair.publicKey)
        //     let str_de = rsa_decrypt(str_en,keypair.privateKey)
        //     console.log('加密前'+str)
        //     console.log('加密后'+str_en)
        //     console.log('解密后'+str_de)
        // },
        login: async ({dispatch , commit} , userData) => {
            userData.password = encrypt(userData.password,getKey())
            console.log(decrypt(userData.password,getKey()))
            const data={
                email:userData.email,
                password:userData.password
            }

            if(userData.ispersonal){
                const res = await CloginAPI(data)
                if (res) {
                    commit('set_personal',userData.ispersonal)
                    setToken(res.id)//从'@/utils/auth'中导入的方法
                    commit('set_userId' , res.id)
                    dispatch('getUserInfo')
                    router.push('/credit/main')//mutations的方法用commit，actions的方法用dispatch
                }
            }else{
                //console.log(data)
                const res = await EloginAPI(data)
                console.log(res)
                if (res) {
                    commit('set_personal',userData.ispersonal)
                    setToken(res.id)//从'@/utils/auth'中导入的方法
                    commit('set_userId' , res.id)
                    dispatch('getUserInfo')
                    router.push('/credit/main')//mutations的方法用commit，actions的方法用dispatch
                }
            }


            //假数据
            // setToken('1')
            // commit('set_userId' , '1')
            // dispatch('getUserInfo')
            // router.push('/credit/main')
        } ,

        uploadADImg: async ({state , dispatch} , data) => {
            const res = await uploadImgAPI(data) //res就是图片字符串
            console.log(res)
            if (res) {
                state.Url = res
                message.success("上传成功")
            }
        } ,

        register: async ({commit},data) => {
            data.password = encrypt(data.password,getKey())
            console.log(data)
            if(data.userType === '0'){
                const res = await CregisterAPI(data)
                if (res) {
                    message.success('注册成功')
                }
            }else{
                const res = await EregisterAPI(data)
                if (res) {
                    message.success('注册成功')
                }
            }
        } ,


        getUserInfo({state , commit}) {
            return new Promise((resolve , reject) => {
                if(state.personal){
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
                }else{
                    getEnterpriseAPI(state.userId).then(response => {
                        const data = response
                        //console.log(data)
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
                }


                //假数据
                // const data = {
                //     id:'1',
                //     email:'C1@qq.com',
                //     password:'123456',
                //     phoneNumber:'123456789',
                //     userType: 'Client',
                //     avatarUrl:'https://pic4.zhimg.com/80/v2-00196e71224b2e48ea7a2223a50f2bdd_1440w.jpg?source=1940ef5c'
                // }
                // commit('set_userInfo' , data)
                // commit('set_userId' , data.id)
                // resolve(data)
            })
        } ,
        updateEnterprise: async ({state , dispatch} , data) => {
            const params = {
                id: state.userId ,
                ...data ,
            }
            const res = await updateEnterpriseAPI(params)
            if (res) {
                message.success('修改成功')
                dispatch('getEnterprise')
            }
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
