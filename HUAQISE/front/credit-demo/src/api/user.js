import { axios } from '@/utils/request'

const api = {
    userPre: '/userservice/api/user',
}
export function CloginAPI(data){
    return axios({
        url:`${api.userPre}/login`,
        method: 'POST',
        data
    })
}
export function CregisterAPI(data){//普通用户注册email,password,phoneNumber,username,userType
    return axios({
        url: `${api.userPre}/register`,
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






