<template>
  <div id="app">
    <img id="qa" src="./assets/QA.jpg">
    <h1>{{ msg }}</h1>
    <ul>
      <li><a href="http://localhost:8080/home " target="_blank" v-on:click="makeActive('home')">Enter</a></li>
    </ul>
    
  </div>
</template>

<script>
export default {
  name: 'app',
  data () {
    return {
      msg: 'Welcome to the QA Account Management System'
    }
  },
  methods: {
    makeActive: function (item) {
      router.push(item)
      this.active = item
    }
  }
}
</script>

<style lang="scss">
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
#qa {
  height:300px;
  width:300px;
}
</style>
