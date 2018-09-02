<template>
    <v-container>
        <v-layout row>
            <v-flex xs12 sm6 offset-sm3>
                <h4 class="primary--text">Edit Account page</h4>
            </v-flex>
        </v-layout>
        <v-layout row>
            <v-flex xs12 sm6 offset-sm3>
                <v-text-field
                label="First Name"
                ref="forename"
                :rules="[rules.name]"
                v-model="forename"
                required>
                </v-text-field>
            </v-flex>
        </v-layout>
        <v-layout row>
            <v-flex xs12 sm6 offset-sm3>
                <v-text-field
                label="Last Name"
                ref="surname"
                :rules="[rules.name]"
                v-model="surname"
                required>
                </v-text-field>
            </v-flex>
        </v-layout>
        <v-layout row>
            <v-flex xs12 sm6 offset-sm3>
                <v-text-field
                label="Account Number"
                ref="accountNumber"
                v-model.number="accountNumber"
                type="number"
                :rules="[rules.account]"
                required>
                </v-text-field>
            </v-flex>
        </v-layout>
        <v-btn class="addbutton" color="#005baa" dark v-on:click="submit">Update Account</v-btn>
    </v-container>
</template>

<script>
import axios from 'axios'
export default {
    name: 'EditAccount'
}
</script>

<style>

</style>