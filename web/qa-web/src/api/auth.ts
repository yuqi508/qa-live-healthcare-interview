import service from '@/utils/request'

export const useDoctorLoginApi = (data: any) => {
    return service.post('/qa-user/doctor/login', data)
}

export const usePatientLoginApi = (data: any) => {
    return service.post('/qa-user/patient/login', data)
}