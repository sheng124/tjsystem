<template>
  <div v-if="loignJudge()">
    <el-container>
      <el-header>
        <HeaderView></HeaderView>
      </el-header>
      <el-container>
        <el-aside>
          <MenuTree></MenuTree>
        </el-aside>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
  <div id="app" v-else>
    <router-view></router-view>
  </div>
</template>

<script>
import HeaderView from "@/components/element/HeaderView.vue"
import MenuTree from "@/components/element/MenuTree.vue"
import {getToken} from '@/utils/token'
export default {
  components: { HeaderView,MenuTree },
  data(){
    return {
      "message":"hello world"
    }
  },
  methods:{
    loignJudge(){
      if(getToken()){
        this.$message=getToken();
        return true;
      }
      else{
        return false;
      }
    }
  }
}
</script>

<style>
  html,body{
    width: 100%;
    height: 100%;
    margin: 0;
  }
  /*铺满屏幕，没有边距*/
  .el-container {
    padding: 0px;
    margin: 0px;
    height: 100vh;
  }	
  .el-header {
  /* 顶部部分的高度(默认60px) */
    background-color: #43a7ef;
    color: #FFFFFF;
    display: flex;
    justify-content: space-between;
    align-items: center;
    height: 60px;
  }
  .el-aside {
    max-width: 200px;
    background-color: #32323a;
    /* background-image: url(assets/login.jpg); */
    min-height: calc(100vh - 60px);
  }
  
  .el-mian {
    background-color: #eaedf1;
    padding: 0px;
    margin: 0px;
    height:calc(100vh - 60px);
  }		
</style>
