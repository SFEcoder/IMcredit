import { axios } from '@/utils/request'

const api = {
    userPre: '/userservice/api/user'
}
export function loginAPI(data){
    return axios({
        url:`${api.userPre}/login`,
        method: 'POST',
        data
    })
}
export function CregisterAPI(data){//普通用户注册email,password,phoneNumber,username,userType
    return axios({
        url: `${api.userPre}/Cregister`,
        method: 'POST',
        data
    })
}
export function EregisterAPI(data) {//企业用户注册EnterpriseName,EnterpriseID,Contact_person,Email,EPhoneNumber,Password,registerPhotoUrl(营业执照,数组类型),userType
    return axios({
        url: `${api.userPre}/Eregister`,
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

