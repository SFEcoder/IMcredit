import Vue from 'vue'
import App from './App.vue'
import router from './router'
import Antd from 'ant-design-vue'
import BootstrapVue from 'bootstrap-vue'
import ToggleButton from 'vue-js-toggle-button'
import 'ant-design-vue/dist/antd.css'
import 'ant-design-vue/dist/antd.less'
import store from './store'
import '@/permission'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'font-awesome/css/font-awesome.min.css'
import $ from 'jquery'
import 'bootstrap/dist/js/bootstrap.bundle.min.js'
import 'bootstrap/dist/js/bootstrap.min.js'

import htmlToPdf from './utils/htmlToPdf'
Vue.use(htmlToPdf)


import miniToastr from 'mini-toastr'
miniToastr.init()
miniToastr.setIcon('error', 'i', {
    'class': 'fa fa-times'
});
miniToastr.setIcon('info', 'i', { 'class' : 'fa fa-file'})
miniToastr.setIcon('success', 'i', {
    'class': 'fa fa-check'
});
miniToastr.setIcon('warn', 'i', {
    'class': 'fa fa-search'
});

Vue.config.productionTip = false
const options = {
    namespace: 'pro__',
    name: 'ls',
    storage: 'local'
}
Vue.use(Antd)
Vue.use(BootstrapVue)
Vue.use(ToggleButton)
Vue.directive('title', {
    inserted: function (el, binding) {
        document.title = el.dataset.title
    }
})
new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')
