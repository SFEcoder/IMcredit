import { axios } from '@/utils/request'

const api = {
    evaluatePre:'/epservice/api/index'
}




export function upload_indexAPI(id, div, fin) {//上传指标
    console.log('id' , id)
    console.log('div' , div)
    console.log('fin' , fin)
    return axios({
        url: `${api.evaluatePre}/${id}/add_target`,
        method: 'POST',
        params: {
            div : [1.1,1],
            fin : [2,2.4]
        }
    })
}

export function get_enterprise_indexAPI(id){

    // return axios({
    //     url : `${api.evaluatePre}/${id}/get_target`,
    //     method : 'GET'
    // })
}


