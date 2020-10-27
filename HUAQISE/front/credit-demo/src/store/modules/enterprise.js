import router from '@/router'
import miniToastr from 'mini-toastr'

import {
    get_enterprise_display_listAPI,
    search_enterprise_display_listAPI
} from "@/api/enterprise"


const getDefaultState = () => {
    return {
        display_list: [],

    }
}

const enterprise = {
    state: getDefaultState(),

    mutations: {
        set_display_list: (state, data) => {
            state.display_list = data

        }
    },


    actions: {

        get_display_list: async ({commit, state}) => {
            const res = await get_enterprise_display_listAPI()
            if (res) {
                commit('set_display_list', res)
            }
        },


        search_enterprise_display_list: async ({commit, state}, key) => {
            const res = await search_enterprise_display_listAPI()
            if (res) {
                commit("set_display_list", res)
                miniToastr.success("搜索成功")
            }
        }

    }



}

export default enterprise
