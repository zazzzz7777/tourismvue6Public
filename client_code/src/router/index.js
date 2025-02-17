import { createRouter, createWebHashHistory } from 'vue-router'
import index from '../views'
import home from '../views/pages/home.vue'
import login from '../views/pages/login.vue'
import yonghuList from '@/views/pages/yonghu/list'
import yonghuDetail from '@/views/pages/yonghu/formModel'
import yonghuAdd from '@/views/pages/yonghu/formAdd'
import yonghuRegister from '@/views/pages/yonghu/register'
import yonghuCenter from '@/views/pages/yonghu/center'
import daoyouList from '@/views/pages/daoyou/list'
import daoyouDetail from '@/views/pages/daoyou/formModel'
import daoyouAdd from '@/views/pages/daoyou/formAdd'
import jingdianmenpiaoList from '@/views/pages/jingdianmenpiao/list'
import jingdianmenpiaoDetail from '@/views/pages/jingdianmenpiao/formModel'
import jingdianmenpiaoAdd from '@/views/pages/jingdianmenpiao/formAdd'
import menpiaogoumaiList from '@/views/pages/menpiaogoumai/list'
import menpiaogoumaiDetail from '@/views/pages/menpiaogoumai/formModel'
import menpiaogoumaiAdd from '@/views/pages/menpiaogoumai/formAdd'
import jingdianjieshaoList from '@/views/pages/jingdianjieshao/list'
import jingdianjieshaoDetail from '@/views/pages/jingdianjieshao/formModel'
import jingdianjieshaoAdd from '@/views/pages/jingdianjieshao/formAdd'
import shenqingdaoyouList from '@/views/pages/shenqingdaoyou/list'
import shenqingdaoyouDetail from '@/views/pages/shenqingdaoyou/formModel'
import shenqingdaoyouAdd from '@/views/pages/shenqingdaoyou/formAdd'
import daoyouyuyanList from '@/views/pages/daoyouyuyan/list'
import daoyouyuyanDetail from '@/views/pages/daoyouyuyan/formModel'
import daoyouyuyanAdd from '@/views/pages/daoyouyuyan/formAdd'
import daoyoufenpeiList from '@/views/pages/daoyoufenpei/list'
import daoyoufenpeiDetail from '@/views/pages/daoyoufenpei/formModel'
import daoyoufenpeiAdd from '@/views/pages/daoyoufenpei/formAdd'
import menuList from '@/views/pages/menu/list'
import menuDetail from '@/views/pages/menu/formModel'
import menuAdd from '@/views/pages/menu/formAdd'

const routes = [{
		path: '/',
		redirect: '/index/home'
	},
	{
		path: '/index',
		component: index,
		children: [{
			path: 'home',
			component: home
		}
		, {
			path: 'yonghuList',
			component: yonghuList
		}, {
			path: 'yonghuDetail',
			component: yonghuDetail
		}, {
			path: 'yonghuAdd',
			component: yonghuAdd
		}
		, {
			path: 'yonghuCenter',
			component: yonghuCenter
		}
		, {
			path: 'daoyouList',
			component: daoyouList
		}, {
			path: 'daoyouDetail',
			component: daoyouDetail
		}, {
			path: 'daoyouAdd',
			component: daoyouAdd
		}
		, {
			path: 'jingdianmenpiaoList',
			component: jingdianmenpiaoList
		}, {
			path: 'jingdianmenpiaoDetail',
			component: jingdianmenpiaoDetail
		}, {
			path: 'jingdianmenpiaoAdd',
			component: jingdianmenpiaoAdd
		}
		, {
			path: 'menpiaogoumaiList',
			component: menpiaogoumaiList
		}, {
			path: 'menpiaogoumaiDetail',
			component: menpiaogoumaiDetail
		}, {
			path: 'menpiaogoumaiAdd',
			component: menpiaogoumaiAdd
		}
		, {
			path: 'jingdianjieshaoList',
			component: jingdianjieshaoList
		}, {
			path: 'jingdianjieshaoDetail',
			component: jingdianjieshaoDetail
		}, {
			path: 'jingdianjieshaoAdd',
			component: jingdianjieshaoAdd
		}
		, {
			path: 'shenqingdaoyouList',
			component: shenqingdaoyouList
		}, {
			path: 'shenqingdaoyouDetail',
			component: shenqingdaoyouDetail
		}, {
			path: 'shenqingdaoyouAdd',
			component: shenqingdaoyouAdd
		}
		, {
			path: 'daoyouyuyanList',
			component: daoyouyuyanList
		}, {
			path: 'daoyouyuyanDetail',
			component: daoyouyuyanDetail
		}, {
			path: 'daoyouyuyanAdd',
			component: daoyouyuyanAdd
		}
		, {
			path: 'daoyoufenpeiList',
			component: daoyoufenpeiList
		}, {
			path: 'daoyoufenpeiDetail',
			component: daoyoufenpeiDetail
		}, {
			path: 'daoyoufenpeiAdd',
			component: daoyoufenpeiAdd
		}
		, {
			path: 'menuList',
			component: menuList
		}, {
			path: 'menuDetail',
			component: menuDetail
		}, {
			path: 'menuAdd',
			component: menuAdd
		}
		]
	},
	{
		path: '/login',
		component: login
	}
	,{
		path: '/yonghuRegister',
		component: yonghuRegister
	}
]

const router = createRouter({
  history: createWebHashHistory(process.env.BASE_URL),
  routes
})

export default router
