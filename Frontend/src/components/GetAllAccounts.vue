<template>
    <v-container>
        <v-layout row>
            <v-flex xs12 sm6 offset-sm3>
                <h4>Show all accounts page</h4>
            </v-flex>
        </v-layout>
        <v-layout>
            <v-flex sm12>
                <v-data-table
                    :headers="headers"
                    :items="items"
                    hide-actions
                >
                    <template slot="items" slot-scope="props">
                        <td id="accountID">{{ props.item.id }}</td>
                        <td>{{ props.item.forename }}</td>
                        <td>{{ props.item.surname }}</td>
                        <td>{{ props.item.accountNumber }}</td>
                        <td><router-link class="nav-link home" to="/edit"><v-icon color="blue" class="glyphicon glyphicon-pencil"></v-icon></router-link></td>
                        <td><v-btn flat v-on:click="deleteItem(props.item.id)"><v-icon color="red" class="glyphicon glyphicon-remove"></v-icon></v-btn></td>
                    </template>
                </v-data-table>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
import axios from 'axios'
export default {
    name: 'GetAllAccounts',
    data () {
        return {
            id: [],
            headers: [
                {
                    text: 'Account id',
                    sortable: false,
                    align: 'center',
                    value: 'accountid'
                },
                {
                    text: 'First Name',
                    sortable: false,
                    align: 'center',
                    value: 'forename'
                },
                {
                    text: 'Last Name',
                    sortable: false,
                    align: 'center',
                    value: 'surname'
                },
                {
                    text: 'Account Number',
                    sortable: false,
                    align: 'center',
                    value: 'number'
                },
                {
                    text: 'Edit',
                    sortable: false,
                    align: 'center',
                    value: 'edit account'
                },
                {
                    text: 'Delete',
                    sortable: false,
                    align: 'center',
                    value: 'delete'
                }
            ],
            items: [],
            errors: []
        }
    },
    created() {
        axios.get(`http://localhost:8081/accounts/getAll`)
        .then(response => {
            this.items = response.data
        })
        .catch(e => {
            this.errors.push(e)
        })
    },
    computed: {
      table() {
        return {
          id: document.getElementById('accountID').value
        }
      }
    },
    methods: {
        deleteItem(id) {
            console.log("here")
            console.log(id)
            axios.delete('http://localhost:8081/accounts/delete/' + id)
            .then(function (response) {
                    console.log(response.data)
                    window.alert("The account has been deleted. Please refresh page to see results.")
                    return "The account has been deleted!"
                })
                .catch(function (error){
                    console.log(error)
                })
        }
    }

}
</script>

<style scoped>
@import url("//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css");

v-btn {
    margin-left:auto;
    margin-right:auto;
}


</style>