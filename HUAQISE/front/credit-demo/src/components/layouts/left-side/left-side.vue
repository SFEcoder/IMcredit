 <template>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="left-aside sidebar-offcanvas">
        <!-- sidebar: style can be found in sidebar-->
        <section class="sidebar">
            <div id="menu" role="navigation">
                <div class="nav_profile">
                    <profile></profile>
                </div>
                <vmenu>

                        <vmenu-item link = "/credit/display" icon="fa fa-globe" :class="{active_menu_clicked: ($route.path === '/credit/display') }">  评级公示</vmenu-item>

                  <vsub-menu title="我的评级" icon="fa fa-balance-scale ">
                    <div @click="appeal_evaluate">
                    <vmenu-item link = "" icon="fa fa-legal" :class="{active_menu_clicked: ($route.path.indexOf( '/credit/evaluate') !== -1) }">  申请评级</vmenu-item>
                    </div>
                    <div @click="check_my_report">
                      <vmenu-item link = "" @click="check_my_report" icon="fa fa-file-pdf-o" :class="{active_menu_clicked: ($route.path === '/credit/report') }" >  查看报告</vmenu-item>
                    </div>
                  </vsub-menu>

                        <vsub-menu title="个人中心" icon="fa fa-cube">
                          <div @click="show_history">
                          <vmenu-item link="" icon="fa fa-history"  :class="{active_menu_clicked: ($route.path === '/credit/history') }"> 浏览记录</vmenu-item>
                          </div>
                          <div @click="show_personal">
                          <vmenu-item link="" icon="fa fa-gear"  :class="{active_menu_clicked: ($route.path === '/user/info/'+this.userId) }"> 个人资料</vmenu-item>
                          </div>
                        </vsub-menu>



                </vmenu>
                <!-- / .navigation -->
            </div>
            <!-- menu -->
        </section>
        <!-- /.sidebar -->
    </aside>
</template>
<script>
import {
    vmenu,
    vmenuItem,
    vsubMenu
} from './menu';
import router from "@/router";
import profile from "./left-profile/user_profile.vue"
import {mapGetters, mapMutations} from "vuex";
import miniToastr from 'mini-toastr'

export default {
  computed:{
    ...mapGetters([
      "userId"
    ])
  },
  methods:{
    ...mapMutations([
      "set_checkedEnterpriseId"
    ]),
    check_my_report(){
      if(this.userId === 0){
        miniToastr.error("游客请先登录")
      }
      else{
        this.set_checkedEnterpriseId(this.userId)
        router.push("/credit/report")
      }

    },
    appeal_evaluate(){
      if(this.userId === 0){
        miniToastr.error("游客请先登录")
      }
      else
        router.push('/credit/evaluate')
    },
    show_history(){
      if(this.userId === 0){
        miniToastr.error("游客请先登录")
      }
      else
        router.push('/credit/history')
    },
    show_personal(){
      if(this.userId === 0){
        miniToastr.error("游客请先登录")
      }
      else{
        router.push( '/user/info/'+this.userId)
      }
    }
  },
    name: "left-side",
    components: {
        vmenu,
        vsubMenu,
        vmenuItem,
        profile
    },
    data() {
        return {
            curMenuClickedName:'/credit/display'
        }
    },
  mounted() {
  },

  watch: {
        $route(to, from) {
            $(function () {
                $('#right_side_title_h1').hide()
                this.curMenuClickedName = to.path
                $('#right_side_title_h1').fadeIn(500)
            })
        }
    }
}
</script>
<style scoped lang="scss">
@import "src/components/layouts/css/customvariables";
.left-aside {
    width: $left_menu_width;
    background: $leftmenu_color;
    background-repeat: repeat-y;
}

.navigation {
    padding: 0;
}

.divider {
    margin-top: 10px;
    list-style-type: none;
    border-bottom:1px solid #ececec;
    padding-bottom: 6px;
}

.divider span {
    font-size: 15px;
    font-weight: 700;
    color: $divider-leftheader;
    margin: 20px 20px -15px 20px;
}

.sidebar {
    display: block;
    font-size: 14px;
    letter-spacing: 1px;
}

.content {
    display: block;
    width: auto;
    overflow-x: hidden;
    padding: 0 15px;
}

.badge-success {
    background-color: #22d69d;
}

.badge {
    padding: 0.60em 0.7em;
    border-radius: 0.75rem;
}
.nav_profile{
    border-bottom:1px solid #eee;
}

    .active_menu_clicked{
        background-color: $menu_active;
    }
</style>
