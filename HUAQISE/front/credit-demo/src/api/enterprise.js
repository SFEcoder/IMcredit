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

export function get_enterprise_display_listAPI(){
    return [
        {
            ePhoto: "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603432533688&di=c26b849b0ad7a0d0bf94dd21cccb7227&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20170408%2Ff4463d2f3ad341b8884e4473550fe1ba_th.jpeg",
            name: "Tencent",
            contactNumber: '18851074558',
            email: '251386202@qq.com',
            eGrade: 2
        },
        {
            ePhoto: "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603432789255&di=e633b52cbc5d3fb6fcd7937db8c7084f&imgtype=0&src=http%3A%2F%2Fn1.itc.cn%2Fimg8%2Fwb%2Frecom%2F2017%2F03%2F21%2F149006794778594397.JPEG",
            name: "Alibaba",
            contactNumber: '18851074558',
            email: '251386202@qq.com',
            eGrade: 0
        },
        {
            ePhoto: "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1841747477,4197549819&fm=26&gp=0.jpg",
            name: "Nanjing University",
            contactNumber: '18851074558',
            email: '251386202@qq.com',
            eGrade: 1
        },
        {
            ePhoto: "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603432533688&di=c26b849b0ad7a0d0bf94dd21cccb7227&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20170408%2Ff4463d2f3ad341b8884e4473550fe1ba_th.jpeg",
            name: "Tencent",
            contactNumber: '18851074558',
            email: '251386202@qq.com',
            eGrade: 2
        },
        {
            ePhoto: "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603432789255&di=e633b52cbc5d3fb6fcd7937db8c7084f&imgtype=0&src=http%3A%2F%2Fn1.itc.cn%2Fimg8%2Fwb%2Frecom%2F2017%2F03%2F21%2F149006794778594397.JPEG",
            name: "Alibaba",
            contactNumber: '18851074558',
            email: '251386202@qq.com',
            eGrade: 3
        },
        {
            ePhoto: "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1841747477,4197549819&fm=26&gp=0.jpg",
            name: "Nanjing University",
            contactNumber: '18851074558',
            email: '251386202@qq.com',
            eGrade: 4
        },
        {
            ePhoto: "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603432533688&di=c26b849b0ad7a0d0bf94dd21cccb7227&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20170408%2Ff4463d2f3ad341b8884e4473550fe1ba_th.jpeg",
            name: "Tencent",
            contactNumber: '18851074558',
            email: '251386202@qq.com',
            eGrade: 2
        },
        {
            ePhoto: "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603432789255&di=e633b52cbc5d3fb6fcd7937db8c7084f&imgtype=0&src=http%3A%2F%2Fn1.itc.cn%2Fimg8%2Fwb%2Frecom%2F2017%2F03%2F21%2F149006794778594397.JPEG",
            name: "Alibaba",
            contactNumber: '18851074558',
            email: '251386202@qq.com',
            eGrade: 0
        },
        {
            ePhoto: "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1841747477,4197549819&fm=26&gp=0.jpg",
            name: "Nanjing University",
            contactNumber: '18851074558',
            email: '251386202@qq.com',
            eGrade: 1
        },
        {
            ePhoto: "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603432533688&di=c26b849b0ad7a0d0bf94dd21cccb7227&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20170408%2Ff4463d2f3ad341b8884e4473550fe1ba_th.jpeg",
            name: "Tencent",
            contactNumber: '18851074558',
            email: '251386202@qq.com',
            eGrade: 2
        },
        {
            ePhoto: "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603432789255&di=e633b52cbc5d3fb6fcd7937db8c7084f&imgtype=0&src=http%3A%2F%2Fn1.itc.cn%2Fimg8%2Fwb%2Frecom%2F2017%2F03%2F21%2F149006794778594397.JPEG",
            name: "Alibaba",
            contactNumber: '18851074558',
            email: '251386202@qq.com',
            eGrade: 0
        },
        {
            ePhoto: "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1841747477,4197549819&fm=26&gp=0.jpg",
            name: "Nanjing University",
            contactNumber: '18851074558',
            email: '251386202@qq.com',
            eGrade: 1
        },
        {
            ePhoto: "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603432533688&di=c26b849b0ad7a0d0bf94dd21cccb7227&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20170408%2Ff4463d2f3ad341b8884e4473550fe1ba_th.jpeg",
            name: "Tencent",
            contactNumber: '18851074558',
            email: '251386202@qq.com',
            eGrade: 2
        },
        {
            ePhoto: "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603432789255&di=e633b52cbc5d3fb6fcd7937db8c7084f&imgtype=0&src=http%3A%2F%2Fn1.itc.cn%2Fimg8%2Fwb%2Frecom%2F2017%2F03%2F21%2F149006794778594397.JPEG",
            name: "Alibaba",
            contactNumber: '18851074558',
            email: '251386202@qq.com',
            eGrade: 0
        },
        {
            ePhoto: "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1841747477,4197549819&fm=26&gp=0.jpg",
            name: "Nanjing University",
            contactNumber: '18851074558',
            email: '251386202@qq.com',
            eGrade: 1
        }, {
            ePhoto: "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603432533688&di=c26b849b0ad7a0d0bf94dd21cccb7227&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20170408%2Ff4463d2f3ad341b8884e4473550fe1ba_th.jpeg",
            name: "Tencent",
            contactNumber: '18851074558',
            email: '251386202@qq.com',
            eGrade: 2
        },
        {
            ePhoto: "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603432789255&di=e633b52cbc5d3fb6fcd7937db8c7084f&imgtype=0&src=http%3A%2F%2Fn1.itc.cn%2Fimg8%2Fwb%2Frecom%2F2017%2F03%2F21%2F149006794778594397.JPEG",
            name: "Alibaba",
            contactNumber: '18851074558',
            email: '251386202@qq.com',
            eGrade: 0
        },
        {
            ePhoto: "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1841747477,4197549819&fm=26&gp=0.jpg",
            name: "Nanjing University",
            contactNumber: '18851074558',
            email: '251386202@qq.com',
            eGrade: 1
        },
        {
            ePhoto: "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603432533688&di=c26b849b0ad7a0d0bf94dd21cccb7227&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20170408%2Ff4463d2f3ad341b8884e4473550fe1ba_th.jpeg",
            name: "Tencent",
            contactNumber: '18851074558',
            email: '251386202@qq.com',
            eGrade: 2
        },
        {
            ePhoto: "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603432789255&di=e633b52cbc5d3fb6fcd7937db8c7084f&imgtype=0&src=http%3A%2F%2Fn1.itc.cn%2Fimg8%2Fwb%2Frecom%2F2017%2F03%2F21%2F149006794778594397.JPEG",
            name: "Alibaba",
            contactNumber: '18851074558',
            email: '251386202@qq.com',
            eGrade: 0
        },
        {
            ePhoto: "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1841747477,4197549819&fm=26&gp=0.jpg",
            name: "Nanjing University",
            contactNumber: '18851074558',
            email: '251386202@qq.com',
            eGrade: 1
        },


    ]

    // return axios({
    //     url : ``
    // })
}

export function search_enterprise_display_listAPI(){
    return [
        {
            ePhoto: "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603432533688&di=c26b849b0ad7a0d0bf94dd21cccb7227&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20170408%2Ff4463d2f3ad341b8884e4473550fe1ba_th.jpeg",
            name: "Tencent",
            contactNumber: '18851074558',
            email: '251386202@qq.com',
            eGrade: 2
        },{
            ePhoto: "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1841747477,4197549819&fm=26&gp=0.jpg",
            name: "Nanjing University",
            contactNumber: '18851074558',
            email: '251386202@qq.com',
            eGrade: 1
        },


    ]

    // return axios({
    //     url : ``
    // })
}

