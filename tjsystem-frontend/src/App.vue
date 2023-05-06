<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  components: {  },
  data(){
    return {
      "message":"hello world"
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
</style>
