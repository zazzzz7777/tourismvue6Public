const config = {
  get() {
    return {
      url:
        process.env.VUE_APP_BASE_API_URL + process.env.VUE_APP_BASE_API + '/',
      name: process.env.VUE_APP_BASE_API,
      menuList: [
        {
          name: '景点介绍管理',
          icon: 'icon-common2',
          child: [
            {
              name: '景点介绍',
              url: '/index/jingdianjieshaoList',
            },
          ],
        },
        {
          name: '景点信息管理',
          icon: 'icon-common13',
          child: [
            {
              name: '景点门票',
              url: '/index/jingdianmenpiaoList',
            },
          ],
        },
      ],
    }
  },
  getProjectName() {
    return {
      projectName: '景区管理系统',
    }
  },
}
export default config
