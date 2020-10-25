import { axios } from '@/utils/request'
const api = {
    ossPre: 'userservice/api/file'
}
export function uploadImgAPI(data) {
    return axios({
        url: `${api.ossPre}/upload`,
        method: 'POST' ,
        data,
        headers:{
            'Content-Type': 'multipart/form-data'
        }
    })
}