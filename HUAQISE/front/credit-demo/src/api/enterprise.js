import { axios } from '@/utils/request'

const api = {
    enterprisePre:'/epservice/api/enterprise'
}

export function EloginAPI(data){
    return axios({
        url:`${api.enterprisePre}/login`,
        method: 'POST',
        data
    })
}

export function EregisterAPI(data) {//企业用户注册EnterpriseName,EnterpriseID,Contact_person,Email,EPhoneNumber,Password,registerPhotoUrl(营业执照,数组类型),userType
    return axios({
        url: `${api.enterprisePre}/register`,
        method: 'POST',
        data
    })
}

export function getEnterpriseAPI(id){
    return axios({
        url: `${api.enterprisePre}/${id}/getEpById`,
        method: 'GET'
    })
}
export function updateEnterpriseAPI(data) {
    return axios({
        url: `${api.enterprisePre}/update`,
        method: 'POST',
        data
    })
}