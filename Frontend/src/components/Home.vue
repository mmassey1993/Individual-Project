<template>
    <v-container>
        <v-layout row>
            <v-flex xs12 sm6 offset-sm3>
                <h1 class="primary--text text-xs-center">Welcome to the QA Account Management System</h1>
                <br>
            </v-flex>
        </v-layout>
        <v-layout>
            <v-flex xs12 sm12>
                <p class="text">In this application, you can add, update and delete numerous accounts.
                    All accounts can be viewed on the 'Get All Accounts' page, whilst you can add an account using the 'Add Account' page
                </p>
                <p class="text">This application was created using two main technologies; Vue js and Spring Boot. Vue js allowed for the creation of a simple and stylish front end, with Axios being used to send API to the backend.
                     The backend was set up using Java and the Spring Boot framework. Domain, service and controller packages were created to cleanly send
                     request data through the backend and into an H2 console database, where the data would be stored, or updated depending on the request sent.
                </p>
            </v-flex>
        </v-layout>
        <v-layout row>
            <v-flex xs12 sm6 offset-sm3 >
                <carousel :perPageCustom="[[768, 1], [1024, 1]]" :autoplay="true" :unagile="true" :autoplayTimeout="3000" autoplayHoverPause=true :loop="true" paginationActiveColor="#005caa">
                    <slide>
                        <img src="../assets/GetAll.jpg"/>
                    </slide>
                    <slide>
                        <img src="../assets/Add.jpg"/>
                    </slide>
                </carousel>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
import { Carousel, Slide } from 'vue-carousel'
export default {
    name: 'Home',
    components: {
        Carousel,
        Slide
    }
}
</script>

<style scoped>
.text {
    color: blue;
    font-size: 20px;
    text-align: center;
}

img {
  height: 300px;
  width: 100%;
}

</style>