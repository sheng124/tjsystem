import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  // {
  //   path: '/',
  //   redirect:'/login' //表示重定向到/emp即可
  // },
  {
    path: '/login',  //地址hash
    name: 'login',
    component:  () => import('../views/LoginView.vue')  //对应的vue组件
  },
  {
    path: '/',  //地址hash
    name: 'home',
    component:  () => import('../views/HomeView.vue')  //对应的vue组件
  },
  
]

const router = new VueRouter({
  routes
})

export default router
