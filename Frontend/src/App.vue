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

  /*-------------------------
      The menu
  --------------------------*/
  nav{
    display:inline-block;
    position:relative;
    background-color: #005baa;
    width: 100%;
    height:50px;
    color: white;
  }
  .nav-link {
    display: inline;
    color:white;
  }

  .nav-link:hover {
    color:white;
  }
  nav router-link{
    display:inline-block;
    padding: 18px 30px;
    font-weight:lighter;
    font-size:12px;
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
    color:white;
    display:inline-block;
    padding:5px 10px;
    background-color:#c4d7e0;
    border-radius:2px;
    text-transform:uppercase;
    font-size:18px;
  }


</style>