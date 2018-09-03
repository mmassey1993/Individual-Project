<template>
    <v-container>
        <v-layout row>
            <v-flex xs12 sm6 offset-sm3>
                <h2 class="primary--text text-xs-center">Add a new account</h2>
            </v-flex>
        </v-layout>
            <v-flex xs12 sm6 offset-sm3>
                <v-card id="form" ref="form">
                    <v-card-text>
                        <v-text-field
                            label="First Name"
                            ref="forename"
                            :rules="[rules.name]"
                            v-model="forename"
                            autofocus
                            required>
                        </v-text-field>
                        <v-text-field
                            label="Last Name"
                            ref="surname"
                            :rules="[rules.name]"
                            v-model="surname"
                            required>
                        </v-text-field>
                        <v-text-field
                            label="Account Number"
                            ref="accountNumber"
                            v-model="accountNumber"
                            type="number"
                            :rules="[rules.account]"
                            required>
                        </v-text-field>
                    </v-card-text>
                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-slide-x-reverse-transition>
                            <br>
                            <v-tooltip
                            v-if="formHasErrors"
                            left>
                            </v-tooltip>
                        </v-slide-x-reverse-transition>
                        <v-btn class="addbutton text-xs-center" color="#005baa" dark v-on:click="submit">Add Account</v-btn>
                    </v-card-actions>
                </v-card>
            </v-flex>
        </v-layout>
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
    computed: {
      form() {
        return {
          forename: this.forename,
          surname : this.surname,
          accountNumber: this.accountNumber
        }
      }
    },
    methods: {
        submit() {
            console.log("im here")
            this.formHasErrors = false;
            Object.keys(this.form).forEach(f => {
                if (!this.form[f]) this.formHasErrors = true
                this.$refs[f].validate(true)
            })
            if(!this.formHasErrors) {
                var obj = {forename: this.form.forename, surname: this.form.surname, accountNumber: this.form.accountNumber};
                axios.post('http://localhost:8081/accounts/add', obj)
                .then(function (response) {
                    console.log(response.data)
                    window.alert("The account has been added.")
                    window.location.href='http://localhost:8080/#/'
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
    position: relative;
    right: 200px;
}

</style>