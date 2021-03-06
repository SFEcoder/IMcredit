import { axios } from '@/utils/request'

const api = {
    userPre: '/userservice/api/user'
}
export function loginAPI(data){
    return axios({
        url:`${api.userPre}/login`,
        method: 'POST',    //传很多参数
        data
    })
}
export function registerAPI(data){
    return axios({
        url: `${api.userPre}/register`,
        method: 'POST',
        data
    })
}
export function  ChangePasswordAPI(data){
    return axios({
        url:`${api.userPre}/ChangePassword`,
        method: 'POST',
        data
    })
}
export function getUserInfoAPI(id){
    return axios({
        url: `${api.userPre}/${id}/getUserInfo`,
        method: 'GET'
    })
}
export function updateUserInfoAPI(data) {
    return axios({
        url: `${api.userPre}/update`,
        method: 'POST',
        data
    })
}

