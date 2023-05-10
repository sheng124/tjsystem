<template>
    <el-row type="flex" class="row-bg" align="middle">
        <el-col :span="1"><img src="@/assets/tjsystem0.png" width="40" height="40" /></el-col>
        <el-col :span="22"><h1 style="font-weight: bold;">体检管理系统</h1></el-col>
        <el-col :span="1">
          <el-dropdown trigger="click">
            <span class="el-dropdown-link" style="font-size: larger;color: aliceblue;font-weight: bold;">
              User<i class="el-icon-arrow-down el-icon--right"></i>
            </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item icon="el-icon-user-solid">Profile</el-dropdown-item>
              <el-dropdown-item icon="el-icon-s-help" @click.native="logOut">Logout</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </el-col>
      </el-row>
</template>

<script>
  import { removeToken} from '@/utils/token'
  export default {
    name: 'MyHeader',
    methods:{
      logOut(){
        removeToken();
        this.$router.push('/login');
        this.$message.success("退出成功");
      }
    }
  }
</script>

<style>
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .row-bg {
    background-color: #43a7ef;
    height: 100%;
    width: 100%;
  }
</style>