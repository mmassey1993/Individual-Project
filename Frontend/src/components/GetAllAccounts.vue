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
                        <td>{{ props.item.account_id }}</td>
                        <td>{{ props.item.forename }}</td>
                        <td>{{ props.item.surname }}</td>
                        <td>{{ props.item.accountNumber }}</td>
                        <td>Edit</td>
                        <td>Delete</td>
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
            headers: [
                {
                    text: 'Account id',
                    sortable: false,
                    value: 'accountid'
                },
                {
                    text: 'First Name',
                    sortable: false,
                    value: 'forename'
                },
                {
                    text: 'Last Name',
                    sortable: false,
                    value: 'surname'
                },
                {
                    text: 'Account Number',
                    sortable: false,
                    value: 'number'
                },
                {
                    text: 'Edit',
                    sortable: false,
                    value: 'edit account'
                },
                {
                    text: 'Delete',
                    sortable: false,
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
}
}
</script>

<style>

</style>