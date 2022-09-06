import request from '@/utils/request'

const api_url = '/admin/vod/teacher'

export default {
  // 讲师列表
  pageList(page, limit, searchObj) {
    return request({
      url: `${api_url}/findQueryPage/${page}/${limit}`,
      method: `post`,
      data: searchObj
    })
  },
  removeTeacherById(id) {
    return request({
      url: `${api_url}/delete/${id}`,
      method: 'delete'
    })
  },
  save(teacher) {
    return request({
      url: `${api_url}/save`,
      method: 'post',
      data: teacher
    })
  },  
  update(teacher) {
    return request({
      url: `${api_url}/update`,
      method: 'put',
      data: teacher
    })
  },
  getById(id) {
    return request({
      url: `${api_url}/get/${id}`,
      methods: 'get'
    })
  },
  batchRemove(itList) {
    return request({
      url: `${api_url}/batchRemove`,
      method: 'delete',
      data: itList
    })
  }
}
