import { defineStore } from 'pinia'
import {useDoctorLoginApi, usePatientLoginApi} from '@/api/auth'
import {message} from "ant-design-vue";
import cache from '@/utils/cache'
import {getDoctor} from "../../api/doctors.ts";
import {getPatient} from "../../api/patient.ts";

export const useUserStore = defineStore('userStore', {
	state: () => ({
		// 医生信息
		doctor: {
			id: '',
			username: '',
			password: '',
			name: '',
			title: '',
			department: '',
			avatar: '',
			experience: '',
			specialties: [],
			isActive: false,
		},
		// 患者信息
		patient: {
			id: '',
			username: '',
			password: '',
			name: '',
			birthday: '',
			phone: '',
			gender: '',
		},
		//
		username: '',
		// 权限列表
		authorityList: [],
		// 访问token
		token: '',
		// 刷新token
		refreshToken: ''
	}),
	actions: {
		setDoctor(val: any) {
			this.doctor = val
		},
		setPatient(val: any) {
			this.patient = val
		},
		setUsername(val: any) {
			this.username = val
			cache.setUsername(val)
		},
		setToken(val: any) {
			this.token = val
			cache.setToken(val)
		},
		setRefreshToken(val: any) {
			this.refreshToken = val
			cache.setRefreshToken(val)
		},
		// 医生登录
		async doctorLoginAction(loginForm: any) {
			const {message} = await useDoctorLoginApi(loginForm)

			this.setDoctor({username: loginForm.username})
			this.setUsername(loginForm.username)
			this.setToken(message)
			this.setRefreshToken(message)
		},
		// 患者登录
		async patientLoginAction(loginForm: any) {
			const {message} = await usePatientLoginApi(loginForm)
			this.setPatient({username: loginForm.username})
			this.setUsername(loginForm.username)
			this.setToken(message)
			this.setRefreshToken(message)
		},
		// 获取医生信息
		async getDoctorInfoAction(username: string) {
			const { data } = await getDoctor(username)
			this.setDoctor(data)
		},
		// 获取患者信息
		async getPatientInfoAction(username: string) {
			const { data } = await getPatient(username)
			this.setPatient(data)
		},
		// 用户退出
		async logoutAction() {

			// 移除 token
			this.setToken(null)
			this.setRefreshToken(null)
		}
	}
})
