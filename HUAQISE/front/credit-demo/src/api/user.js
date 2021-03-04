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


export function getAccessToken() {
    const grant_type = "password"
    const username = "user_1"
    const password = "123456"
    const client_id = "client_2"
    const  client_secret = "123456"
    const scope = "server"
    return axios({
        url: `/oauth/token`,
        method: 'POST',
        params:{
            grant_type:"password",
            username : "user_1",
            password : "123456",
            client_id : "client_2",
            client_secret : "123456",
            scope : "server",
        }
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



export function getBrowseHistoryAPI(id){
    return axios({
        url: `/userservice/api/browse/getAllBrowse`,
        method: 'POST',
        params:{
            userId: id
        }
    })
}


var myDate = new Date();
export function addBrowseHistoryAPI(epid,userId){
    return axios({
        url: `/userservice/api/browse/insert`,
        method: 'POST',
        data:{
            userId: userId,
            epId : epid,
            createTime: myDate.toLocaleString()
        }
    })
}






