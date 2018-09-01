<template>
    <v-container>
        <v-layout row>
            <v-flex xs12 sm6 offset-sm3>
                <h4 class="primary--text">Add Account page</h4>
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
        <v-btn class="addbutton" color="#005baa" dark v-on:click="submit">Add Account</v-btn>
    </v-container>
</template>

<script>
import axios from 'axios'
export default {
    name: 'AddAccount',
    data () {
        return {
            formHasErrors: false,
            forename: '',
            surname: '',
            accountNumber: '',
            rules: {
                account: v => v.length > 5 && v.length < 7 || '6 characters',
                name: v => !!v || 'Name is required'
            }
        }
    },
    methods: {
        submit() {
            this.formHasErrors = false;
            Object.keys(this.form).forEach(f => {
                if (!this.form[f]) this.formHasErrors = true
                this.$refs[f].validate(true)
            })
            if(!this.formHasErrors) {
                var obj = {forename: this.form.forename, surname: this.form.surname, accountNumber: this.form.accountNumber};
                var json = JSON.stringify(obj);
                console.log(json)
                axios.post('http://localhost:8081/accounts/add', json)
                .then(function (response) {
                    console.log(response.data)
                    return "The account has been added!"
                })
                .catch(function (error){
                    console.log(error)
                })
            } else {
                window.alert("Please fill the form in coreectly to add an account!");
            }
        }
    }
}
</script>

<style>
.addbutton {
    text-color: white;
}

</style>