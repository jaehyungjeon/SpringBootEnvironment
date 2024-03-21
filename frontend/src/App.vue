<template>
  <img alt="Vue logo" src="./assets/pepe.jpg">
  <HelloWorld msg="메인페이지 구성"/>
  <button v-on:click="ajaxMethod">버튼</button>
  <button v-on:click="requestMember">ajax</button>
  <ul>
    <li v-for="(item, index) in array" :key="index">
      {{ item.id }}
    </li>
  </ul>
</template>

<!--<script src="https://cdn.jsdelivr.net/npm/vue"></script>-->
<script>
import HelloWorld from './components/HelloWorld.vue';
import axios from 'axios';

let array = [{'id' : 'jaehyung!!!!'}];
export default {
  name: 'App',
  components: {
    HelloWorld
  },
  data() {
    return {
      array : array
    }
  },
  methods : {
    ajaxMethod : function () {
      axios.post("/main/initMain.action")
          .then((result) => {
            console.log(result);
            document.querySelector("#app").innerHTML = result.data;
            console.log(result.data);
            // el.innerHTML = result.data;
          })
    },
    requestMember : function() {
      axios.get("/main/ajaxSearchGridGet.action")
          .then((result) => {
            this.array = result.data;
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