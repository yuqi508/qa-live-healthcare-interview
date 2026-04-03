import service from '@/utils/request'

export const getPatient= (username: string) => {
    return service.get('/qa-user/api/v1/patient/' + username)
}

