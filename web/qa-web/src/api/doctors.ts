import service from '@/utils/request'

// 查询 用户组 列表
export const listDoctor= () => {
    return service.get('/qa-user/api/v1/doctors')
}

export const getDoctor= (username: string) => {
    return service.get('/qa-user/api/v1/doctors/' + username)
}
