<template>
	<div class="home_view">
		<div class="projectTitle">欢迎使用 {{projectName}}</div>
		<div class="count_list">
			<el-collapse-transition v-if="btnAuth('menpiaogoumai','首页总数')">
				<el-card v-show="countTypeList.closemenpiaogoumaiCountType" class="card_view">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								门票购买
							</div>
							<div class="card_head_right">
								<el-icon @click="countTypeClick('hiddenmenpiaogoumaiCountType')" class="showIcons"
									:class="countTypeList.hiddenmenpiaogoumaiCountType?'showIcons1':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="countTypeClick('closemenpiaogoumaiCountType')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
							
						</div>
					</template>
					<el-collapse-transition>
						<div class="count_item" v-show="countTypeList.hiddenmenpiaogoumaiCountType">
							<div class="count_title">门票购买总数</div>
							<div class="count_num">{{menpiaogoumaiCount}}</div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
			<el-collapse-transition v-if="btnAuth('daoyoufenpei','首页总数')">
				<el-card v-show="countTypeList.closedaoyoufenpeiCountType" class="card_view">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								导游分配
							</div>
							<div class="card_head_right">
								<el-icon @click="countTypeClick('hiddendaoyoufenpeiCountType')" class="showIcons"
									:class="countTypeList.hiddendaoyoufenpeiCountType?'showIcons1':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="countTypeClick('closedaoyoufenpeiCountType')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
							
						</div>
					</template>
					<el-collapse-transition>
						<div class="count_item" v-show="countTypeList.hiddendaoyoufenpeiCountType">
							<div class="count_title">导游分配总数</div>
							<div class="count_num">{{daoyoufenpeiCount}}</div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
		</div>
		<div class="card_list">
			<el-collapse-transition v-if="btnAuth('menpiaogoumai','首页统计')">
				<el-card v-show="cardTypeList.closemenpiaogoumaiChartType1" class="card_view">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								门票购买
							</div>
							<div class="card_head_right">
								<el-icon @click="cardTypeClick('hiddenmenpiaogoumaiChartType1')" class="showIcons"
									:class="cardTypeList.hiddenmenpiaogoumaiChartType1?'showIcons1':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="cardTypeClick('closemenpiaogoumaiChartType1')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
						</div>
					</template>
					<el-collapse-transition>
						<div class="card_item" v-show="cardTypeList.hiddenmenpiaogoumaiChartType1">
							<div id="menpiaogoumaidingdanjineEchart1" style="width: 100%;height: 400px;"></div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
			<el-collapse-transition v-if="btnAuth('menpiaogoumai','首页统计')">
				<el-card v-show="cardTypeList.closemenpiaogoumaiChartType2" class="card_view">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								门票购买
							</div>
							<div class="card_head_right">
								<el-icon @click="cardTypeClick('hiddenmenpiaogoumaiChartType2')" class="showIcons"
									:class="cardTypeList.hiddenmenpiaogoumaiChartType2?'showIcons1':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="cardTypeClick('closemenpiaogoumaiChartType2')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
						</div>
					</template>
					<el-collapse-transition>
						<div class="card_item" v-show="cardTypeList.hiddenmenpiaogoumaiChartType2">
							<div id="menpiaogoumaidingdanjineEchart2" style="width: 100%;height: 400px;"></div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
			<el-collapse-transition v-if="btnAuth('daoyoufenpei','首页统计')">
				<el-card v-show="cardTypeList.closedaoyoufenpeiChartType1" class="card_view">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								导游分配
							</div>
							<div class="card_head_right">
								<el-icon @click="cardTypeClick('hiddendaoyoufenpeiChartType1')" class="showIcons"
									:class="cardTypeList.hiddendaoyoufenpeiChartType1?'showIcons1':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="cardTypeClick('closedaoyoufenpeiChartType1')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
						</div>
					</template>
					<el-collapse-transition>
						<div class="card_item" v-show="cardTypeList.hiddendaoyoufenpeiChartType1">
							<div id="daoyoufenpeijiageEchart1" style="width: 100%;height: 400px;"></div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
		</div>
	</div>
</template>

<script setup>
	import {
		inject,
		nextTick,
		ref,
		getCurrentInstance
	} from 'vue';
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const projectName = context.$project.projectName
	const countTypeList = ref({
	})
	const getCountList=()=>{
		countTypeList.value.closemenpiaogoumaiCountType = true
		countTypeList.value.hiddenmenpiaogoumaiCountType = true
		if(btnAuth('menpiaogoumai','首页总数')){
			getmenpiaogoumaiCount()
		}
		countTypeList.value.closedaoyoufenpeiCountType = true
		countTypeList.value.hiddendaoyoufenpeiCountType = true
		if(btnAuth('daoyoufenpei','首页总数')){
			getdaoyoufenpeiCount()
		}
	}
	const menpiaogoumaiCount = ref(0)
	const getmenpiaogoumaiCount = () => {
		context?.$http({
			url:'menpiaogoumai/count',
			method: 'get'
		}).then(res=>{
			menpiaogoumaiCount.value = res.data.data
		})
	}
	const daoyoufenpeiCount = ref(0)
	const getdaoyoufenpeiCount = () => {
		context?.$http({
			url:'daoyoufenpei/count',
			method: 'get'
		}).then(res=>{
			daoyoufenpeiCount.value = res.data.data
		})
	}
	const countTypeClick = (e) => {
		countTypeList.value[e] = !countTypeList.value[e]
	}
	const init=()=>{
		getCountList()
		getCardList()
	}
	//权限验证
	const btnAuth = (e,a)=>{
		return context?.$toolUtil.isAuth(e,a)
	}
	let echarts = inject("echarts")
	const cardTypeClick = (e) =>{
		cardTypeList.value[e] = !cardTypeList.value[e]
		setTimeout(()=>{
			getCardList()
		},1000)
	}
	const cardTypeList = ref({
		closemenpiaogoumaiChartType1: true,
		hiddenmenpiaogoumaiChartType1: true,
		closemenpiaogoumaiChartType2: true,
		hiddenmenpiaogoumaiChartType2: true,
		closedaoyoufenpeiChartType1: true,
		hiddendaoyoufenpeiChartType1: true,
	})
	const getCardList = () => {
		if(btnAuth('menpiaogoumai','首页统计')){
			getmenpiaogoumaiChart1()
		}
		if(btnAuth('menpiaogoumai','首页统计')){
			getmenpiaogoumaiChart2()
		}
		if(btnAuth('daoyoufenpei','首页统计')){
			getdaoyoufenpeiChart1()
		}
	}
	const getmenpiaogoumaiChart1 = () => {
		nextTick(()=>{
			var dingdanjineEchart1 = echarts.init(document.getElementById("menpiaogoumaidingdanjineEchart1"),'macarons');
			context?.$http({
				url: `menpiaogoumai/value/goumaishijian/dingdanjine/日`,
				method: "get",
			}).then(obj=>{
				let res = obj.data.data
				let xAxis = [];
				let yAxis = [];
				let pArray = []
				for(let i=0;i<res.length;i++){
				    xAxis.push(res[i].goumaishijian);
				    yAxis.push(parseFloat((res[i].total)));
				    pArray.push({
				        value: parseFloat((res[i].total)),
				        name: res[i].goumaishijian
				    })
				}
				var option = {};
                option = {
                    title: {
                        text: '日销售额',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        data: xAxis,
                        axisLabel: {
                            rotate: 40
                        }
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'bar'
                    }]
                };
				dingdanjineEchart1.clear()
				// 使用刚指定的配置项和数据显示图表。
				dingdanjineEchart1.setOption(option);
				//根据窗口的大小变动图表
				dingdanjineEchart1.resize();
			})
		})
	}
	const getmenpiaogoumaiChart2 = () => {
		nextTick(()=>{
			var dingdanjineEchart2 = echarts.init(document.getElementById("menpiaogoumaidingdanjineEchart2"),'macarons');
			context?.$http({
				url: `menpiaogoumai/value/goumaishijian/dingdanjine/月`,
				method: "get",
			}).then(obj=>{
				let res = obj.data.data
				let xAxis = [];
				let yAxis = [];
				let pArray = []
				for(let i=0;i<res.length;i++){
				    xAxis.push(res[i].goumaishijian);
				    yAxis.push(parseFloat((res[i].total)));
				    pArray.push({
				        value: parseFloat((res[i].total)),
				        name: res[i].goumaishijian
				    })
				}
				var option = {};
                option = {
                    title: {
                        text: '月销售额',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        data: xAxis,
                        axisLabel: {
                            rotate: 40
                        }
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'bar'
                    }]
                };
				// 使用刚指定的配置项和数据显示图表。
				dingdanjineEchart2.clear()
				dingdanjineEchart2.setOption(option);
				//根据窗口的大小变动图表
				dingdanjineEchart2.resize();
			})
		})
	}
	const getdaoyoufenpeiChart1 = () => {
		nextTick(()=>{
			var jiageEchart1 = echarts.init(document.getElementById("daoyoufenpeijiageEchart1"),'macarons');
			context?.$http({
				url: `daoyoufenpei/value/daoyouxingming/jiage`,
				method: "get",
			}).then(obj=>{
				let res = obj.data.data
				let xAxis = [];
				let yAxis = [];
				let pArray = []
				for(let i=0;i<res.length;i++){
				    xAxis.push(res[i].daoyouxingming);
				    yAxis.push(parseFloat((res[i].total)));
				    pArray.push({
				        value: parseFloat((res[i].total)),
				        name: res[i].daoyouxingming
				    })
				}
				var option = {};
                option = {
                    title: {
                        text: '导游收入统计',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        data: xAxis,
                        axisLabel: {
                            rotate: 40
                        }
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'bar'
                    }]
                };
				jiageEchart1.clear()
				// 使用刚指定的配置项和数据显示图表。
				jiageEchart1.setOption(option);
				//根据窗口的大小变动图表
				jiageEchart1.resize();
			})
		})
	}
	init()
</script>
<style lang="scss">
	.projectTitle{
		padding: 0 0 20px;
		font-weight: bold;
		display: flex;
		width: 100%;
		font-size: 30px;
		justify-content: center;
		align-items: center;
		height: 50%;
	}

	.showIcons {
		transition: transform 0.3s;
		margin-right: 10px;
	}

	.showIcons1 {
		transform: rotate(-180deg);
	}
	
	// 总数盒子
	.count_list{
		padding: 0 0 20px;
		display: flex;
		width: 100%;
		justify-content: center;
		align-items: flex-start;
		flex-wrap: wrap;
		// 总数card
		.card_view {
			border: 1px solid #e4e7ed;
			box-shadow: 0px 0px 12px rgba(0,0,0,.12);
			padding: 0 0 50px;
			margin: 0 10px 10px;
			flex: 1;
			background: rgba(0,123,213,1);
			width: 100%;
			position: relative;
			box-sizing: border-box;
			height: auto;
			// card头部
			.el-card__header {
				border: 1px solid #e4e7ed;
				padding: 10px;
				left: 0;
				bottom: 0;
				width: 100%;
				border-width: 1px 0 0;
				position: absolute;
				// 头部盒子
				.index_card_head {
					display: flex;
					width: 100%;
					justify-content: space-between;
					align-items: center;
					// 标题
					.card_head_title {
						color: #fff;
						font-size: 14px;
					}
					// 按钮盒子
					.card_head_right {
						display: flex;
						align-items: center;
						// 按钮
						.el-icon {
							cursor: pointer;
							color: #fff;
							font-size: 20px;
						}
					}
				}
			}
			// body
			.el-card__body {
				padding: 0;
				// body盒子
				.count_item{
					padding: 30px;
					display: flex;
					align-items: center;
					text-align: center;
					// 总数标题
					.count_title{
						padding: 0 10px 0 0;
						color: #fff;
						font-weight: bold;
						font-size: 20px;
						line-height: 3;
					}
					// 总数数字
					.count_num{
						color: #fff;
						font-weight: bold;
						font-size: 24px;
						line-height: 3;
					}
				}
			}
		}
	}
	// 首页盒子
	.home_view {
		padding: 30px 0;
	}
	// 统计图盒子
	.card_list {
		padding: 0 0 20px;
		display: flex;
		width: 100%;
		flex-wrap: wrap;
		// 统计图card
		.card_view {
			border: 0px solid #e4e7ed;
			box-shadow: none;
			margin: 0 10px 20px;
			background: #fff;
			width: 32%;
			box-sizing: border-box;
			height: auto;
			// 头部
			.el-card__header {
				border: 1px solid #e4e7ed;
				display: none;
				width: 100%;
				border-width: 0 0 1px;
				// 头部盒子
				.index_card_head {
					display: flex;
					width: 100%;
					justify-content: space-between;
					align-items: center;
					// 标题
					.card_head_title {
						color: #f00;
						font-size: 14px;
					}
					// 按钮盒子
					.card_head_right {
						display: flex;
						align-items: center;
						// 按钮
						.el-icon{
							cursor: pointer;
							color: #aaa;
							font-size: 20px;
						}
					}
				}
			}
			// body
			.el-card__body {
				padding: 0;
				width: 100%;
				// body盒子
				.card_item{
					padding: 30px;
					text-align: center;
				}
			}
		}
	}
</style>
