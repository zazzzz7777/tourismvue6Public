<template>
  <div>
    <div class="login_view">
      <div class="outTitle_view">
        <div class="outTilte">景区管理系统登录</div>
      </div>
      <el-form :model="loginForm" class="login_form">
        <div class="list_item" v-if="loginType == 1">
          <div class="list_label">账号：</div>
          <input
            class="list_inp"
            v-model="loginForm.username"
            placeholder="请输入账号"
          />
        </div>
        <div class="list_item" v-if="loginType == 1">
          <div class="list_label">密码：</div>
          <input
            class="list_inp"
            v-model="loginForm.password"
            type="password"
            placeholder="请输入密码"
            @keydown.enter.native="handleLogin"
          />
        </div>
        <div class="list_type" v-if="userList.length > 1">
          <div class="list_label">用户类型：</div>
          <el-select v-model="loginForm.role" placeholder="请选择用户类型">
            <el-option
              v-for="(item, index) in userList"
              :label="item.roleName"
              :value="item.roleName"
            ></el-option>
          </el-select>
        </div>
        <div class="remember_view" v-if="loginType == 1">
          <el-checkbox
            v-model="rememberPassword"
            label="记住密码"
            size="large"
            :true-label="true"
            :false-label="false"
          />
        </div>
        <div class="btn_view">
          <el-button
            class="login"
            v-if="loginType == 1"
            type="success"
            @click="handleLogin"
            >登录</el-button
          >
          <el-button
            class="register"
            type="primary"
            @click="handleRegister('yonghu')"
            >注册用户</el-button
          >
        </div>
      </el-form>
    </div>
  </div>
</template>
<script setup>
import { ref, getCurrentInstance, nextTick, onMounted } from 'vue'
import menu from '@/utils/menu'
const userList = ref([])
const menus = ref([])
const loginForm = ref({
  role: '',
  username: '',
  password: '',
})
const tableName = ref('')
const loginType = ref(1)
//是否记住密码
const rememberPassword = ref(true)
const context = getCurrentInstance()?.appContext.config.globalProperties
//注册
const handleRegister = (tableName) => {
  context?.$router.push(`/${tableName}Register`)
}
const handleLogin = () => {
  if (!loginForm.value.username) {
    context?.$toolUtil.message('请输入用户名', 'error')

    return
  }
  if (!loginForm.value.password) {
    context?.$toolUtil.message('请输入密码', 'error')

    return
  }
  if (userList.value.length > 1) {
    if (!loginForm.value.role) {
      context?.$toolUtil.message('请选择角色', 'error')
      verifySlider.reset()
      return
    }
    for (let i = 0; i < menus.value.length; i++) {
      if (menus.value[i].roleName == loginForm.value.role) {
        tableName.value = menus.value[i].tableName
      }
    }
  } else {
    tableName.value = userList.value[0].tableName
    loginForm.value.role = userList.value[0].roleName
  }
  login()
}
const login = () => {
  context
    ?.$http({
      url: `${tableName.value}/login?username=${loginForm.value.username}&password=${loginForm.value.password}`,
      method: 'post',
    })
    .then(
      (res) => {
        //是否保存当前账号密码至缓存
        if (rememberPassword.value) {
          let loginForm1 = JSON.parse(JSON.stringify(loginForm.value))
          delete loginForm1.code
          context?.$toolUtil.storageSet(
            'frontLoginForm',
            JSON.stringify(loginForm1)
          )
        } else {
          context?.$toolUtil.storageRemove('frontLoginForm')
        }
        context?.$toolUtil.storageSet('frontToken', res.data.token)
        context?.$toolUtil.storageSet('frontRole', loginForm.value.role)
        context?.$toolUtil.storageSet('frontSessionTable', tableName.value)
        let path = context?.$toolUtil.storageGet('toPath')
        if (path) {
          context?.$router.push(path)
          context?.$toolUtil.storageRemove('toPath')
          return
        }
        context?.$router.push(`/index/${tableName.value}Center`)
      },
      (err) => {
        verifySlider.value.reset()
      }
    )
}
//获取菜单
const getMenu = () => {
  let arr = menu.list()
  menus.value = arr
  for (let i = 0; i < menus.value.length; i++) {
    if (menus.value[i].hasFrontLogin == '是') {
      userList.value.push(menus.value[i])
    }
  }
}
//初始化
const init = () => {
  getMenu()
  //获取缓存是否有保存的账号密码
  let form = context?.$toolUtil.storageGet('frontLoginForm')
  if (form) {
    loginForm.value = JSON.parse(form)
  } else {
    loginForm.value.role = userList.value[0].roleName
  }
}
onMounted(() => {
  init()
})
</script>

<style lang="scss" scoped>
.login_view {
  background-repeat: no-repeat;
  flex-direction: column;
  background-size: 100% 100%;
  background: url(http://localhost:8080/tourismvue/file/de6094a8a941493f929c24d7394dd821.jpg);
  display: flex;
  min-height: 100vh;
  justify-content: center;
  align-items: center;
  position: relative;
  background-position: center center;
  // 标题盒子
  .outTitle_view {
    padding: 0 0 0px;
    margin: 20px 0 0;
    display: flex;
    align-items: center;
    .outTilte {
      border: 0px solid #fff;
      border-radius: 0px;
      padding: 10px 20px;
      color: #333;
      font-size: 30px;
    }
  }
  // 表单盒子
  .login_form {
    border-radius: 0;
    padding: 50px 50px 100px 0;
    margin: 20px 0;
    background: rgba(255, 255, 255, 0.96);
    display: flex;
    width: 35vw;
    justify-content: center;
    position: relative;
    flex-wrap: wrap;
  }
  // item盒子
  .list_item {
    margin: 10px 0;
    display: flex;
    width: 80%;
    justify-content: center;
    align-items: center;
    // label
    .list_label {
      width: 90px;
      font-size: 14px;
      text-align: right;
    }
    // 输入框
    .list_inp {
      border: 1px solid #ddd;
      border-radius: 0px;
      padding: 0 10px;
      width: 300px;
      line-height: 36px;
      height: 36px;
    }
  }
  .list_type {
    margin: 10px 0;
    display: flex;
    width: 80%;
    justify-content: center;
    align-items: center;
    .list_label {
      width: 90px;
      font-size: 14px;
      text-align: right;
    }
    // 下拉框样式
    :deep(.el-select) {
      border: 1px solid #ddd;
      border-radius: 0px;
      padding: 0 10px;
      color: #666;
      background: #fff;
      width: 300px;
      line-height: 36px;
      box-sizing: border-box;
      //去掉默认样式
      .select-trigger {
        height: 100%;
        .el-input {
          height: 100%;
          .el-input__wrapper {
            border: none;
            box-shadow: none;
            background: none;
            border-radius: 0;
            height: 100%;
            padding: 0;
          }
          .is-focus {
            box-shadow: none !important;
          }
        }
      }
    }
  }
  // 记住密码样式
  .remember_view {
    margin: 16px auto;
    width: 80%;
    text-align: center;

    // 未选中样式
    :deep(.el-checkbox) {
      margin: 0;
      display: flex;
      width: 82%;
      justify-content: center;
      align-items: center;
      // 复选框
      .el-checkbox__inner {
        border: 1px solid #dcdfe6;
        background: #fff;
      }
      // 提示文字
      .el-checkbox__label {
        color: #999;
      }
    }
    // 选中样式
    :deep(.is-checked) {
      //复选框
      .el-checkbox__inner {
        background-color: #cc0000;
        border-color: #cc0000;
      }
      // 提示文字
      .el-checkbox__label {
        color: #cc0000;
      }
    }
  }
  // 按钮盒子
  .btn_view {
    padding: 20px 0 0;
    display: flex;
    width: 80%;
    justify-content: center;
    align-items: center;
    flex-wrap: wrap;
    // 登录
    .login {
      border: 0;
      cursor: pointer;
      border-radius: 0px;
      padding: 0 24px;
      margin: 0 10px 10px 0;
      outline: none;
      color: #fff;
      background: #cc0000;
      width: auto;
      font-size: 16px;
      height: 36px;
    }
    // 注册
    .register {
      border: 1px solid #cc000030;
      cursor: pointer;
      border-radius: 0px;
      padding: 0 10px;
      margin: 0 10px 10px 0;
      outline: none;
      color: #cc0000;
      background: #fff;
      width: auto;
      font-size: 14px;
      height: 36px;
    }
  }
}
</style>
