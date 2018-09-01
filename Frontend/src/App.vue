<template>
  <div id="app">
    <div id="main">
      <nav v-bind:class="active" v-on:click.prevent>
        <img id="logo" src="./assets/QA.jpg">
        <router-link class="nav-link home" to="/">Dashboard</router-link>
        <router-link class="nav-link home" to="/getall">Get All Accounts</router-link>
        <router-link class="nav-link home" to="/add">Add Account</router-link>
      </nav>
    </div>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'App',  
  data () {
    return {
      active: '',
      showModal: false
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
  *{
    margin:0;
    padding:0;
  }
  #logo {
    height: 50px;
    width: auto;
    float: left;
  }
  #cont {
    min-height: 100vh;
    position: relative;
  }

  body{
    font:15px/1.3 'Open Sans', sans-serif;
    color: #000000;
    text-align:center;    
  }
  
  /*-------------------------
      The menu
  --------------------------*/
  nav{
    display:inline-block;
    // position:relative;
    // float: bottom;
    background-color: #005baa;
    border-radius:0px;
    width: 100%;
    z-index: 1;
  }
  nav a{
    display:inline-block;
    padding: 18px 30px;
    color:#fff !important;
    font-weight:lighter;
    font-size:12px;
    float:left;
    text-decoration:none !important;
    line-height:1;
    text-transform: uppercase;
    background-color:transparent;
    -webkit-transition:background-color 0.25s;
    -moz-transition:background-color 0.25s;
    transition:background-color 0.25s;
  }
  
  p{
    font-size:22px;
    font-weight:bold;
    color:#7d9098;
  }
  p b{
    color:#ffffff;
    display:inline-block;
    padding:5px 10px;
    background-color:#c4d7e0;
    border-radius:2px;
    text-transform:uppercase;
    font-size:18px;
  }
  #topBanner {
    width: 100%;
    height: 110px;
    background: black;
  }

</style>