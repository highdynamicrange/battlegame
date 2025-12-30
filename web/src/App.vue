<template>
  <NavBar></NavBar>
  <router-view></router-view>
</template>

<script>
  import NavBar from './components/NavBar.vue';
  import "bootstrap/dist/css/bootstrap.min.css";
  import "bootstrap/dist/js/bootstrap";
  import $ from 'jquery';
  
  export default {
    components:{
      NavBar
    },
    setup(){
      $.ajax({
        url: "http://localhost:3000/user/account/token/",
        type:"post",
        data: {
          username: "hdr",
          password: "phdr",
        },
        success(resp) {
          console.log(resp);
        },
        error(resp){
          console.log(resp);
        }
      });

      $.ajax({
        url: "http://localhost:3000/user/account/info/",
        type:"get",
        headers: {
          Authorization: "Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxZWQzZWQ1YzgwYjY0MTUwOTRiMzk4ZDk5ZTg4YTA0MSIsInN1YiI6IjEiLCJpc3MiOiJzZyIsImlhdCI6MTc2NzExOTc0MSwiZXhwIjoxNzY4MzI5MzQxfQ.SZPlS_FH1JBc7iCmxXbqJZ-Ua4fh1WVSlQFtJdBbT2U"
        },
        success(resp){
          console.log(resp);
        },
        error(resp){
          console.log(resp);
        }
      });

      $.ajax({
        url: "http://localhost:3000/user/account/register/",
        type:"post",
        data: {
          username: "b",
          password: "pb",
          confirmedPassword: "pb"
        },
        success(resp){
          console.log(resp);
        },
        error(resp){
          console.log(resp);
        }
      });
      
    }
  }
</script>


<style>

  body{
    background-image: url("@/assets/images/background.png");
    background-size: cover;
  }
</style>
