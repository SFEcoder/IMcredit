import Vue from 'vue'
import Vuex from 'vuex'
import user from './modules/user'
import  evaluate_process from './modules/evaluate_process'
import enterprise from "@/store/modules/enterprise";
import getters from './getters'

Vue.use(Vuex)
const store = new Vuex.Store({
    modules: {
        user,
        evaluate_process,
        enterprise
    },
    state: {
    },
    mutations: {
    },
    actions: {
    },
    getters
})

export default store
