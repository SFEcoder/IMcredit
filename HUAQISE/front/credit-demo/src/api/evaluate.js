import { axios } from '@/utils/request'

const api = {
    evaluatePre:'/api/index'
}



export function upload_indexAPI(id, div, fin) {//上传指标
    console.log('id' , id)
    console.log('div' , div)
    console.log('fin' , fin)
    return axios({
        url: `${api.evaluatePre}/${id}/add_target`,
        method: 'POST',
        params: {
            div : div,
            fin : fin
        }
    })
}

export function get_enterprise_indexAPI(id){

    // return axios({
    //     url : `${api.evaluatePre}/${id}/get_target`,
    //     method : 'GET'
    // })
}


