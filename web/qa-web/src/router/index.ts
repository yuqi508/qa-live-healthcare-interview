import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router';
import Home from '../views/Home.vue';
import Consultation from '../views/Consultation.vue';
import DoctorLogin from '../views/DoctorLogin.vue';
import PatientLogin from '../views/PatientLogin.vue';
import DoctorRoom from '../views/DoctorRoom.vue';
import Doctors from '../views/Doctors.vue';
import About from '../views/About.vue';
import { useUserStore } from '@/store/modules/user'

const routes: RouteRecordRaw[] = [
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
  {
    path: '/consultation',
    name: 'Consultation',
    component: Consultation,
  },
  {
    path: '/consultation/:doctorUsername',
    name: 'ConsultationRoom',
    component: Consultation,
  },
  {
    path: '/doctors',
    name: 'Doctors',
    component: Doctors,
  },
  {
    path: '/about',
    name: 'About',
    component: About,
  },
  {
    path: '/doctor/login',
    name: 'DoctorLogin',
    component: DoctorLogin,
  },
  {
    path: '/patient/login',
    name: 'PatientLogin',
    component: PatientLogin,
  },
  {
    path: '/doctor/room/:username',
    name: 'DoctorRoom',
    component: DoctorRoom,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});


// 白名单列表
const whiteList = ['/doctor/login','/patient/login'];

// 路由跳转前
router.beforeEach(async (to, from, next) => {

  const userStore = useUserStore()

  // token存在的情况
  if (userStore.token) {
    if (to.path === '/doctor/login') {
      next('/doctor/login')
    } else if (to.path === '/patient/login') {
        next('/patient/login')
    } else {
      next()
    }
  } else {
    // 没有token的情况下，可以进入白名单
    if (whiteList.indexOf(to.path) > -1) {
      next()
    } else {

      if (to.fullPath === '/') {
        next('/doctor/login')
      } else {
        next(`/doctor/login?redirect=${to.fullPath}`)
      }
    }
  }
});

export default router;
