<template>
  <div>
    <div class="home_box">
      <!-- 景点门票首页展示 -->
      <div class="homeList_view">
        <div class="homeList_title">景点门票展示</div>
        <div class="home_list_one">
          <div
            class="home_item1 animation_box"
            v-if="jingdianmenpiaoHomeList.length > 0"
            @click="
              detailClick('jingdianmenpiao', jingdianmenpiaoHomeList[0].id)
            "
          >
            <div class="home_img_box">
              <img
                class="home_img"
                v-if="isHttp(jingdianmenpiaoHomeList[0].jingdiantupian)"
                :src="jingdianmenpiaoHomeList[0].jingdiantupian.split(',')[0]"
                alt=""
              />
              <img
                class="home_img"
                v-else
                :src="
                  jingdianmenpiaoHomeList[0].jingdiantupian
                    ? $config.url +
                      jingdianmenpiaoHomeList[0].jingdiantupian.split(',')[0]
                    : ''
                "
                alt=""
              />
            </div>
            <div class="home_content">
              <div class="home_title">
                {{ jingdianmenpiaoHomeList[0].jingdianmingcheng }}
              </div>
              <div class="home_title">
                门票价格：{{ jingdianmenpiaoHomeList[0].menpiaojiage }}
              </div>
            </div>
          </div>
          <div class="home_item2">
            <div
              class="item2_top animation_box"
              v-if="jingdianmenpiaoHomeList.length > 1"
              @click="
                detailClick('jingdianmenpiao', jingdianmenpiaoHomeList[1].id)
              "
            >
              <div class="home_img_box">
                <img
                  class="home_img"
                  v-if="isHttp(jingdianmenpiaoHomeList[1].jingdiantupian)"
                  :src="jingdianmenpiaoHomeList[1].jingdiantupian.split(',')[0]"
                  alt=""
                />
                <img
                  class="home_img"
                  v-else
                  :src="
                    jingdianmenpiaoHomeList[1].jingdiantupian
                      ? $config.url +
                        jingdianmenpiaoHomeList[1].jingdiantupian.split(',')[0]
                      : ''
                  "
                  alt=""
                />
              </div>
              <div class="home_content">
                <div class="home_title">
                  {{ jingdianmenpiaoHomeList[1].jingdianmingcheng }}
                </div>
                <div class="home_title">
                  门票价格：{{ jingdianmenpiaoHomeList[1].menpiaojiage }}
                </div>
              </div>
            </div>
            <div
              class="item2_bottom animation_box"
              v-if="jingdianmenpiaoHomeList.length > 2"
              @click="
                detailClick('jingdianmenpiao', jingdianmenpiaoHomeList[2].id)
              "
            >
              <div class="home_img_box">
                <img
                  class="home_img"
                  v-if="isHttp(jingdianmenpiaoHomeList[2].jingdiantupian)"
                  :src="jingdianmenpiaoHomeList[2].jingdiantupian.split(',')[0]"
                  alt=""
                />
                <img
                  class="home_img"
                  v-else
                  :src="
                    jingdianmenpiaoHomeList[2].jingdiantupian
                      ? $config.url +
                        jingdianmenpiaoHomeList[2].jingdiantupian.split(',')[0]
                      : ''
                  "
                  alt=""
                />
              </div>
              <div class="home_content">
                <div class="home_title">
                  {{ jingdianmenpiaoHomeList[2].jingdianmingcheng }}
                </div>
                <div class="home_title">
                  门票价格：{{ jingdianmenpiaoHomeList[2].menpiaojiage }}
                </div>
              </div>
            </div>
          </div>
          <div
            class="home_item3 animation_box"
            v-if="jingdianmenpiaoHomeList.length > 3"
            @click="
              detailClick('jingdianmenpiao', jingdianmenpiaoHomeList[3].id)
            "
          >
            <div class="home_img_box">
              <img
                class="home_img"
                v-if="isHttp(jingdianmenpiaoHomeList[3].jingdiantupian)"
                :src="jingdianmenpiaoHomeList[3].jingdiantupian.split(',')[0]"
                alt=""
              />
              <img
                class="home_img"
                v-else
                :src="
                  jingdianmenpiaoHomeList[3].jingdiantupian
                    ? $config.url +
                      jingdianmenpiaoHomeList[3].jingdiantupian.split(',')[0]
                    : ''
                "
                alt=""
              />
            </div>
            <div class="home_content">
              <div class="home_title">
                {{ jingdianmenpiaoHomeList[3].jingdianmingcheng }}
              </div>
              <div class="home_title">
                门票价格：{{ jingdianmenpiaoHomeList[3].menpiaojiage }}
              </div>
            </div>
          </div>
          <div class="home_item4">
            <div
              class="item4_top animation_box"
              v-if="jingdianmenpiaoHomeList.length > 4"
              @click="
                detailClick('jingdianmenpiao', jingdianmenpiaoHomeList[4].id)
              "
            >
              <div class="home_img_box">
                <img
                  class="home_img"
                  v-if="isHttp(jingdianmenpiaoHomeList[4].jingdiantupian)"
                  :src="jingdianmenpiaoHomeList[4].jingdiantupian.split(',')[0]"
                  alt=""
                />
                <img
                  class="home_img"
                  v-else
                  :src="
                    jingdianmenpiaoHomeList[4].jingdiantupian
                      ? $config.url +
                        jingdianmenpiaoHomeList[4].jingdiantupian.split(',')[0]
                      : ''
                  "
                  alt=""
                />
              </div>
              <div class="home_content">
                <div class="home_title">
                  {{ jingdianmenpiaoHomeList[4].jingdianmingcheng }}
                </div>
                <div class="home_title">
                  门票价格：{{ jingdianmenpiaoHomeList[4].menpiaojiage }}
                </div>
              </div>
            </div>
            <div
              class="item4_bottom animation_box"
              v-if="jingdianmenpiaoHomeList.length > 5"
              @click="
                detailClick('jingdianmenpiao', jingdianmenpiaoHomeList[5].id)
              "
            >
              <div class="home_img_box">
                <img
                  class="home_img"
                  v-if="isHttp(jingdianmenpiaoHomeList[5].jingdiantupian)"
                  :src="jingdianmenpiaoHomeList[5].jingdiantupian.split(',')[0]"
                  alt=""
                />
                <img
                  class="home_img"
                  v-else
                  :src="
                    jingdianmenpiaoHomeList[5].jingdiantupian
                      ? $config.url +
                        jingdianmenpiaoHomeList[5].jingdiantupian.split(',')[0]
                      : ''
                  "
                  alt=""
                />
              </div>
              <div class="home_content">
                <div class="home_title">
                  {{ jingdianmenpiaoHomeList[5].jingdianmingcheng }}
                </div>
                <div class="home_title">
                  门票价格：{{ jingdianmenpiaoHomeList[5].menpiaojiage }}
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="homeList_more_view" @click="moreClick('jingdianmenpiao')">
          <span class="homeList_more_text">LEARN MORE</span>
        </div>
      </div>
      <!-- 景点介绍首页展示 -->
      <div class="homeList_view">
        <div class="homeList_title">景点介绍展示</div>
        <div class="home_list_one">
          <div
            class="home_item1 animation_box"
            v-if="jingdianjieshaoHomeList.length > 0"
            @click="
              detailClick('jingdianjieshao', jingdianjieshaoHomeList[0].id)
            "
          >
            <div class="home_img_box">
              <img
                class="home_img"
                v-if="isHttp(jingdianjieshaoHomeList[0].jingdiantupian)"
                :src="jingdianjieshaoHomeList[0].jingdiantupian.split(',')[0]"
                alt=""
              />
              <img
                class="home_img"
                v-else
                :src="
                  jingdianjieshaoHomeList[0].jingdiantupian
                    ? $config.url +
                      jingdianjieshaoHomeList[0].jingdiantupian.split(',')[0]
                    : ''
                "
                alt=""
              />
            </div>
            <div class="home_content">
              <div class="home_title">
                {{ jingdianjieshaoHomeList[0].jingdianmingcheng }}
              </div>
            </div>
          </div>
          <div class="home_item2">
            <div
              class="item2_top animation_box"
              v-if="jingdianjieshaoHomeList.length > 1"
              @click="
                detailClick('jingdianjieshao', jingdianjieshaoHomeList[1].id)
              "
            >
              <div class="home_img_box">
                <img
                  class="home_img"
                  v-if="isHttp(jingdianjieshaoHomeList[1].jingdiantupian)"
                  :src="jingdianjieshaoHomeList[1].jingdiantupian.split(',')[0]"
                  alt=""
                />
                <img
                  class="home_img"
                  v-else
                  :src="
                    jingdianjieshaoHomeList[1].jingdiantupian
                      ? $config.url +
                        jingdianjieshaoHomeList[1].jingdiantupian.split(',')[0]
                      : ''
                  "
                  alt=""
                />
              </div>
              <div class="home_content">
                <div class="home_title">
                  {{ jingdianjieshaoHomeList[1].jingdianmingcheng }}
                </div>
              </div>
            </div>
            <div
              class="item2_bottom animation_box"
              v-if="jingdianjieshaoHomeList.length > 2"
              @click="
                detailClick('jingdianjieshao', jingdianjieshaoHomeList[2].id)
              "
            >
              <div class="home_img_box">
                <img
                  class="home_img"
                  v-if="isHttp(jingdianjieshaoHomeList[2].jingdiantupian)"
                  :src="jingdianjieshaoHomeList[2].jingdiantupian.split(',')[0]"
                  alt=""
                />
                <img
                  class="home_img"
                  v-else
                  :src="
                    jingdianjieshaoHomeList[2].jingdiantupian
                      ? $config.url +
                        jingdianjieshaoHomeList[2].jingdiantupian.split(',')[0]
                      : ''
                  "
                  alt=""
                />
              </div>
              <div class="home_content">
                <div class="home_title">
                  {{ jingdianjieshaoHomeList[2].jingdianmingcheng }}
                </div>
              </div>
            </div>
          </div>
          <div
            class="home_item3 animation_box"
            v-if="jingdianjieshaoHomeList.length > 3"
            @click="
              detailClick('jingdianjieshao', jingdianjieshaoHomeList[3].id)
            "
          >
            <div class="home_img_box">
              <img
                class="home_img"
                v-if="isHttp(jingdianjieshaoHomeList[3].jingdiantupian)"
                :src="jingdianjieshaoHomeList[3].jingdiantupian.split(',')[0]"
                alt=""
              />
              <img
                class="home_img"
                v-else
                :src="
                  jingdianjieshaoHomeList[3].jingdiantupian
                    ? $config.url +
                      jingdianjieshaoHomeList[3].jingdiantupian.split(',')[0]
                    : ''
                "
                alt=""
              />
            </div>
            <div class="home_content">
              <div class="home_title">
                {{ jingdianjieshaoHomeList[3].jingdianmingcheng }}
              </div>
            </div>
          </div>
          <div class="home_item4">
            <div
              class="item4_top animation_box"
              v-if="jingdianjieshaoHomeList.length > 4"
              @click="
                detailClick('jingdianjieshao', jingdianjieshaoHomeList[4].id)
              "
            >
              <div class="home_img_box">
                <img
                  class="home_img"
                  v-if="isHttp(jingdianjieshaoHomeList[4].jingdiantupian)"
                  :src="jingdianjieshaoHomeList[4].jingdiantupian.split(',')[0]"
                  alt=""
                />
                <img
                  class="home_img"
                  v-else
                  :src="
                    jingdianjieshaoHomeList[4].jingdiantupian
                      ? $config.url +
                        jingdianjieshaoHomeList[4].jingdiantupian.split(',')[0]
                      : ''
                  "
                  alt=""
                />
              </div>
              <div class="home_content">
                <div class="home_title">
                  {{ jingdianjieshaoHomeList[4].jingdianmingcheng }}
                </div>
              </div>
            </div>
            <div
              class="item4_bottom animation_box"
              v-if="jingdianjieshaoHomeList.length > 5"
              @click="
                detailClick('jingdianjieshao', jingdianjieshaoHomeList[5].id)
              "
            >
              <div class="home_img_box">
                <img
                  class="home_img"
                  v-if="isHttp(jingdianjieshaoHomeList[5].jingdiantupian)"
                  :src="jingdianjieshaoHomeList[5].jingdiantupian.split(',')[0]"
                  alt=""
                />
                <img
                  class="home_img"
                  v-else
                  :src="
                    jingdianjieshaoHomeList[5].jingdiantupian
                      ? $config.url +
                        jingdianjieshaoHomeList[5].jingdiantupian.split(',')[0]
                      : ''
                  "
                  alt=""
                />
              </div>
              <div class="home_content">
                <div class="home_title">
                  {{ jingdianjieshaoHomeList[5].jingdianmingcheng }}
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="homeList_more_view" @click="moreClick('jingdianjieshao')">
          <span class="homeList_more_text">LEARN MORE</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, getCurrentInstance } from 'vue'
import { useRouter } from 'vue-router'
const context = getCurrentInstance()?.appContext.config.globalProperties
const router = useRouter()
//景点门票首页展示
const jingdianmenpiaoHomeList = ref([])
const getjingdianmenpiaoHomeList = () => {
  context
    ?.$http({
      url: 'jingdianmenpiao/list',
      method: 'get',
      params: {
        page: 1,
        limit: 6,
      },
    })
    .then((res) => {
      jingdianmenpiaoHomeList.value = res.data.data.list
    })
}
//景点介绍首页展示
const jingdianjieshaoHomeList = ref([])
const getjingdianjieshaoHomeList = () => {
  context
    ?.$http({
      url: 'jingdianjieshao/list',
      method: 'get',
      params: {
        page: 1,
        limit: 6,
      },
    })
    .then((res) => {
      jingdianjieshaoHomeList.value = res.data.data.list
    })
}
//判断图片链接是否带http
const isHttp = (str) => {
  return str && str.substr(0, 4) == 'http'
}
//跳转详情
const detailClick = (table, id) => {
  router.push(`/index/${table}Detail?id=${id}`)
}
const moreClick = (table) => {
  router.push(`/index/${table}List`)
}
const init = () => {
  //景点门票首页展示
  getjingdianmenpiaoHomeList()
  //景点介绍首页展示
  getjingdianjieshaoHomeList()
}
init()
</script>

<style lang="scss">
.home_box {
  padding: 0;
  margin: 0 auto;
  display: flex;
  width: 100%;
  justify-content: space-between;
  align-items: flex-start;
  flex-wrap: wrap;
}

// 推荐
.recomList_view {
  padding: 0;
  margin: 20px 0 0;
  width: 100%;
  order: 0;
  .recomList_title {
    margin: 20px auto 20px;
    color: #434343;
    font-weight: 600;
    width: 550px;
    font-size: 30px;
    text-align: center;
  }
  // list
  .recommend_list_four {
    padding: 0 18%;
    margin: 40px 0 0;
    display: flex;
    width: 100%;
    justify-content: space-between;
    align-items: flex-start;
    flex-wrap: wrap;
    height: 520px;

    .recommend_item:nth-of-type(2n - 1) {
      margin: 200px 0px 0;
      width: calc(100% / 4 - 0px);
      position: relative;

      .recommend_img_box {
        width: 100%;
        font-size: 0;
        height: 300px;
        .recommend_img {
          object-fit: cover;
          width: 100%;
          height: 100%;
        }
      }
      .recommend_content {
        border: 1px solid #eee;
        padding: 20px 0;
        bottom: 100%;
        display: flex;
        transition: all 0.3s;
        flex-wrap: wrap;
        box-shadow: 0 0px 0px rgba(0, 0, 0, 0.3);
        overflow: hidden;
        left: 0;
        width: 100%;
        justify-content: center;
        align-items: center;
        position: absolute;
        height: 200px;
        .recommend_title1 {
          margin: 0 0 10px;
          width: 100%;
          line-height: 1;
          text-align: center;
        }
        .recommend_title2 {
          margin: 0 0 10px;
          width: 100%;
          line-height: 1;
          text-align: center;
        }
        .recommend_title3 {
          margin: 0 0 10px;
          width: 100%;
          line-height: 1;
          text-align: center;
        }
        .recommend_title4 {
          margin: 0 0 10px;
          width: 100%;
          line-height: 1;
          text-align: center;
        }
        .recommend_title5 {
          margin: 0 0 10px;
          width: 100%;
          line-height: 1;
          text-align: center;
        }
        .recommend_price {
          color: #f00;
          width: 100%;
          line-height: 1;
          text-align: center;
        }
        .recommend_four_bottom {
          margin: 10px 0 0;
          display: flex;
          justify-content: center;
          align-items: center;
          .recommend_like {
            margin: 0 10px 0 0;
            color: #0266b5;
            display: flex;
            font-size: 14px;
            align-items: center;
            .like_icon {
              margin: 0 4px 0 0;
              color: inherit;
            }
            .like_num {
              color: inherit;
            }
          }
          .recommend_collect {
            margin: 0 10px 0 0;
            color: #ee7810;
            display: flex;
            font-size: 14px;
            align-items: center;
            .el-icon {
              margin: 0 4px 0 0;
              color: inherit;
            }
            .collect_num {
              color: inherit;
            }
          }
          .recommend_clickNum {
            margin: 0 10px 0 0;
            color: #4aac26;
            display: flex;
            font-size: 14px;
            align-items: center;
            .el-icon {
              margin: 0 4px 0 0;
              color: inherit;
            }
            .clickNum_num {
              color: inherit;
            }
          }
        }
      }
    }
    .recommend_item:nth-of-type(2n) {
      margin: 0 0px 300px;
      width: calc(100% / 4 - 0px);
      position: relative;

      .recommend_img_box {
        width: 100%;
        font-size: 0;
        height: 300px;
        .recommend_img {
          object-fit: cover;
          width: 100%;
          height: 100%;
        }
      }
      .recommend_content {
        border: 1px solid #eee;
        padding: 20px 0;
        display: flex;
        transition: all 0.3s;
        flex-wrap: wrap;
        box-shadow: 0 0px 0px rgba(0, 0, 0, 0.3);
        top: 100%;
        left: 0;
        width: 100%;
        justify-content: center;
        align-items: center;
        position: absolute;
        height: 200px;
        .recommend_title1 {
          margin: 0 0 10px;
          width: 100%;
          line-height: 1;
          text-align: center;
        }
        .recommend_title2 {
          margin: 0 0 10px;
          width: 100%;
          line-height: 1;
          text-align: center;
        }
        .recommend_title3 {
          margin: 0 0 10px;
          width: 100%;
          line-height: 1;
          text-align: center;
        }
        .recommend_title4 {
          margin: 0 0 10px;
          width: 100%;
          line-height: 1;
          text-align: center;
        }
        .recommend_title5 {
          margin: 0 0 10px;
          width: 100%;
          line-height: 1;
          text-align: center;
        }
        .recommend_price {
          color: #f00;
          width: 100%;
          line-height: 1;
          text-align: center;
        }
        .recommend_four_bottom {
          margin: 10px 0 0;
          display: flex;
          justify-content: center;
          align-items: center;
          .recommend_like {
            margin: 0 10px 0 0;
            color: #0266b5;
            display: flex;
            font-size: 14px;
            align-items: center;
            .like_icon {
              margin: 0 4px 0 0;
              color: inherit;
            }
            .like_num {
              color: inherit;
            }
          }
          .recommend_collect {
            margin: 0 10px 0 0;
            color: #ee7810;
            display: flex;
            font-size: 14px;
            align-items: center;
            .el-icon {
              margin: 0 4px 0 0;
              color: inherit;
            }
            .collect_num {
              color: inherit;
            }
          }
          .recommend_clickNum {
            margin: 0 10px 0 0;
            color: #4aac26;
            display: flex;
            font-size: 14px;
            align-items: center;
            .el-icon {
              margin: 0 4px 0 0;
              color: inherit;
            }
            .clickNum_num {
              color: inherit;
            }
          }
        }
      }
    }
    .recommend_item:nth-of-type(2n - 1):hover {
      cursor: inherit;

      .recommend_img_box {
        .recommend_img {
        }
      }
      .recommend_content {
        box-shadow: none;
        background: #fff;
        bottom: 100%;
        position: absolute;
        height: 200px;
        .recommend_title1 {
        }
        .recommend_title2 {
        }
        .recommend_title3 {
        }
        .recommend_title4 {
        }
        .recommend_title5 {
        }
        .recommend_price {
        }
        .recommend_four_bottom {
          .recommend_like {
            .like_icon {
            }
            .like_num {
            }
          }
          .recommend_collect {
            .el-icon {
            }
            .collect_num {
            }
          }
          .recommend_clickNum {
            .el-icon {
            }
            .clickNum_num {
            }
          }
        }
      }
    }
    .recommend_item:nth-of-type(2n):hover {
      cursor: inherit;

      .recommend_img_box {
        .recommend_img {
        }
      }
      .recommend_content {
        box-shadow: none;
        top: 100%;
        background: #fff;
        position: absolute;
        height: 200px;
        .recommend_title1 {
        }
        .recommend_title2 {
        }
        .recommend_title3 {
        }
        .recommend_title4 {
        }
        .recommend_title5 {
        }
        .recommend_price {
        }
        .recommend_four_bottom {
          .recommend_like {
            .like_icon {
            }
            .like_num {
            }
          }
          .recommend_collect {
            .el-icon {
            }
            .collect_num {
            }
          }
          .recommend_clickNum {
            .el-icon {
            }
            .clickNum_num {
            }
          }
        }
      }
    }
  }
  // list
  // animation
  .animation_box {
    transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
    z-index: initial;
  }
  .animation_box:hover {
    transform: rotate(0deg) scale(1) skew(0deg, 0deg)
      translate3d(0px, -10px, 0px);
    -webkit-perspective: 1000px;
    perspective: 1000px;
    transition: 0.3s;
  }
  .animation_box img {
    transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
    z-index: initial;
  }
  .animation_box img:hover {
    transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
    -webkit-perspective: 1000px;
    perspective: 1000px;
    transition: 0.3s;
  }
  // animation
  // 更多
  .recommend_more_view {
    cursor: pointer;
    border: 1px solid #ddd;
    border-radius: 30px;
    padding: 8px 0;
    margin: 20px auto 0;
    color: #999;
    background: #f6f6f6;
    width: 120px;
    text-align: center;
    .recommend_more_text {
    }
  }
}
// 推荐
// 新闻资讯
.newsList_view {
  padding: 40px 0 20px;
  margin: 40px auto 0;
  background: url(http://localhost:8080/tourismvue/file/a3f21953391c4421b93f577413183cb6.jpg)
    no-repeat center top / cover;
  width: 100%;
  order: 3;

  .newsList_title {
    margin: 0 auto 20px;
    color: #fff;
    background: none;
    font-weight: 600;
    width: 550px;
    font-size: 32px;
    text-align: center;
  }
  // list
  .news_list_one {
    padding: 0 18%;
    margin: 40px auto 0;
    display: flex;
    width: 100%;
    flex-wrap: wrap;
    .news_item {
      cursor: pointer;
      margin: 0 10px 20px;
      background: #fff;
      display: flex;
      width: calc(48% - 20px);
      align-items: center;
      .news_img_box {
        width: 50%;
        font-size: 0;
        .news_img {
          object-fit: cover;
          width: 100%;
          height: 200px;
        }
      }
      .news_content {
        margin: 0 0 0 20px;
        width: calc(50% - 20px);
        .news_title {
          margin: 0 0 10px;
          overflow: hidden;
          white-space: nowrap;
          font-weight: bold;
          width: 100%;
          font-size: 20px;
          text-overflow: ellipsis;
          text-align: center;
        }
        .news_text {
          overflow: hidden;
          font-size: 14px;
          line-height: 24px;
          height: 72px;
        }
        .news_time {
          color: #999;
          display: none;
          width: 100%;
          text-align: right;
        }
      }
    }
  }
  // list
  // animation
  .animation_box {
    transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
    z-index: initial;
  }
  .animation_box:hover {
    transform: rotate(0deg) scale(1) skew(0deg, 0deg)
      translate3d(0px, -10px, 0px);
    -webkit-perspective: 1000px;
    perspective: 1000px;
    transition: 0.3s;
  }
  .animation_box img {
    transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
    z-index: initial;
  }
  .animation_box img:hover {
    transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
    -webkit-perspective: 1000px;
    perspective: 1000px;
    transition: 0.3s;
  }
  // animation
  // 更多
  .news_more_view {
    cursor: pointer;
    border: 1px solid #ddd;
    border-radius: 30px;
    padding: 8px 0;
    margin: 20px auto;
    color: #999;
    background: #f6f6f6;
    width: 120px;
    text-align: center;
    .news_more_text {
    }
  }
}
// 新闻资讯
// 首页展示
.homeList_view {
  padding: 0;
  margin: 40px 0 0;
  width: 100%;
  order: 5;

  .homeList_title {
    margin: 0px auto 20px;
    color: #333;
    background: none;
    font-weight: 600;
    width: 550px;
    font-size: 32px;
    text-align: center;
  }
  // list
  .home_list_one {
    padding: 0 18%;
    margin: 40px auto;
    display: flex;
    width: 100%;
    align-items: flex-start;
    flex-wrap: wrap;
    .home_item1 {
      cursor: pointer;
      border: 1px solid #ddd;
      padding: 12px 12px 0;
      margin: 0 20px 20px 0;
      width: calc(34% - 20px);
      position: relative;
      .home_img_box {
        width: 100%;
        font-size: 0;
        .home_img {
          object-fit: cover;
          width: 100%;
          height: 220px;
        }
      }
      .home_content {
        color: #000;
        background: rgba(0, 0, 0, 0);
        width: 100%;
        line-height: 30px;
        text-align: center;
        .home_title {
          font-size: 14px;
        }
      }
    }
    .home_item2 {
      margin: 0;
      width: 66%;
      .item2_top {
        cursor: pointer;
        border: 1px solid #ddd;
        padding: 12px 12px 0;
        margin: 0px;
        width: calc(50% - 10px);
        position: relative;
        float: left;
        .home_img_box {
          width: 100%;
          .home_img {
            object-fit: cover;
            width: 100%;
            height: 220px;
          }
        }
        .home_content {
          color: #000;
          background: rgba(0, 0, 0, 0);
          width: 100%;
          line-height: 30px;
          text-align: center;
          .home_title {
            font-size: 14px;
          }
        }
      }
      .item2_bottom {
        cursor: pointer;
        border: 1px solid #ddd;
        padding: 12px 12px 0;
        width: calc(50% - 10px);
        position: relative;
        float: right;
        .home_img_box {
          width: 100%;
          .home_img {
            object-fit: cover;
            width: 100%;
            height: 220px;
          }
        }
        .home_content {
          color: #000;
          background: rgba(0, 0, 0, 0);
          width: 100%;
          line-height: 30px;
          text-align: center;
          .home_title {
            font-size: 14px;
          }
        }
      }
    }
    .home_item3 {
      cursor: pointer;
      border: 1px solid #ddd;
      padding: 12px 12px 0;
      margin: 0 20px 0 0;
      width: calc(34% - 20px);
      position: relative;
      .home_img_box {
        width: 100%;
        font-size: 0;
        .home_img {
          object-fit: cover;
          width: 100%;
          height: 220px;
        }
      }
      .home_content {
        color: #000;
        background: rgba(0, 0, 0, 0);
        width: 100%;
        line-height: 30px;
        text-align: center;
        .home_title {
          font-size: 14px;
        }
      }
    }
    .home_item4 {
      margin: 0 0 0 0;
      width: 66%;
      .item4_top {
        cursor: pointer;
        border: 1px solid #ddd;
        padding: 12px 12px 0;
        margin: 0;
        width: calc(50% - 10px);
        position: relative;
        float: left;
        .home_img_box {
          width: 100%;
          .home_img {
            object-fit: cover;
            width: 100%;
            height: 220px;
          }
        }
        .home_content {
          color: #000;
          background: rgba(0, 0, 0, 0);
          width: 100%;
          line-height: 30px;
          text-align: center;
          .home_title {
            font-size: 14px;
          }
        }
      }
      .item4_bottom {
        cursor: pointer;
        border: 1px solid #ddd;
        padding: 12px 12px 0;
        width: calc(50% - 10px);
        position: relative;
        float: right;
        .home_img_box {
          width: 100%;
          .home_img {
            object-fit: cover;
            width: 100%;
            height: 220px;
          }
        }
        .home_content {
          color: #000;
          background: rgba(0, 0, 0, 0);
          width: 100%;
          line-height: 30px;
          text-align: center;
          .home_title {
            font-size: 14px;
          }
        }
      }
    }
  }
  // list
  // animation
  .animation_box {
    transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
    z-index: initial;
  }
  .animation_box:hover {
    transform: rotate(0deg) scale(1) skew(0deg, 0deg)
      translate3d(0px, -10px, 0px);
    -webkit-perspective: 1000px;
    perspective: 1000px;
    transition: 0.3s;
  }
  .animation_box img {
    transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
    z-index: initial;
  }
  .animation_box img:hover {
    transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
    -webkit-perspective: 1000px;
    perspective: 1000px;
    transition: 0.3s;
  }
  // animation
  // 更多
  .homeList_more_view {
    cursor: pointer;
    border: 1px solid #ddd;
    border-radius: 30px;
    padding: 8px 0;
    margin: 20px auto 40px;
    color: #999;
    background: #f6f6f6;
    width: 120px;
    text-align: center;
    .homeList_more_text {
    }
  }
}
// 首页展示
</style>
