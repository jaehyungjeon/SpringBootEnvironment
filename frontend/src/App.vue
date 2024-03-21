<template>
  <img alt="Vue logo" src="./assets/pepe.jpg">
  <HelloWorld msg="메인페이지 구성"/>
  <button v-on:click="ajaxMethod">버튼</button>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue';
import axios from 'axios';

export default {
  name: 'App',
  components: {
    HelloWorld
  },
  methods : {
    ajaxMethod : function () {
      axios.post("/main/initMain.action")
          .then((result) => {
            console.log(document);
            document.querySelector("#app").innerHTML = result.data;
            console.log(result.data);
            // el.innerHTML = result.data;
          })
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
