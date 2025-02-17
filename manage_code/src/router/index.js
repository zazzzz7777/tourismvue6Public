	import {
		createRouter,
		createWebHashHistory
	} from 'vue-router'
	import daoyou from '@/views/daoyou/list'
	import daoyouyuyan from '@/views/daoyouyuyan/list'
	import yonghu from '@/views/yonghu/list'
	import menpiaogoumai from '@/views/menpiaogoumai/list'
	import shenqingdaoyou from '@/views/shenqingdaoyou/list'
	import daoyoufenpei from '@/views/daoyoufenpei/list'
	import jingdianjieshao from '@/views/jingdianjieshao/list'
	import jingdianmenpiao from '@/views/jingdianmenpiao/list'
	import config from '@/views/config/list'
	import users from '@/views/users/list'
	import daoyouRegister from '@/views/daoyou/register'
	import daoyouCenter from '@/views/daoyou/center'

export const routes = [{
		path: '/login',
		name: 'login',
		component: () => import('../views/login.vue')
	},{
		path: '/',
		name: '首页',
		component: () => import('../views/index'),
		children: [{
			path: '/',
			name: '首页',
			component: () => import('../views/HomeView.vue'),
			meta: {
				affix: true
			}
		}, {
			path: '/updatepassword',
			name: '修改密码',
			component: () => import('../views/updatepassword.vue')
		}
		
		,{
			path: '/daoyouCenter',
			name: '导游个人中心',
			component: daoyouCenter
		}
		,{
			path: '/daoyou',
			name: '导游',
			component: daoyou
		}
		,{
			path: '/daoyouyuyan',
			name: '导游语言',
			component: daoyouyuyan
		}
		,{
			path: '/yonghu',
			name: '用户',
			component: yonghu
		}
		,{
			path: '/menpiaogoumai',
			name: '门票购买',
			component: menpiaogoumai
		}
		,{
			path: '/shenqingdaoyou',
			name: '申请导游',
			component: shenqingdaoyou
		}
		,{
			path: '/daoyoufenpei',
			name: '导游分配',
			component: daoyoufenpei
		}
		,{
			path: '/jingdianjieshao',
			name: '景点介绍',
			component: jingdianjieshao
		}
		,{
			path: '/jingdianmenpiao',
			name: '景点门票',
			component: jingdianmenpiao
		}
		,{
			path: '/config',
			name: '轮播图',
			component: config
		}
		,{
			path: '/users',
			name: '管理员',
			component: users
		}
		]
	},
	{
		path: '/daoyouRegister',
		name: '导游注册',
		component: daoyouRegister
	},
]

const router = createRouter({
	history: createWebHashHistory(process.env.BASE_URL),
	routes
})

export default router
