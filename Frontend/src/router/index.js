import Vue from 'vue'
import Router from 'vue-router'
import Home from '../components/Home'
import GetAllAccounts from '../components/GetAllAccounts'
import AddAccount from '../components/AddAccount'
import EditAccount from '../components/EditAccount'

Vue.use(Router)
export default new Router({
  routes: [
    {
      path: '',
      name: 'Home',
      component: Home
    },
    {
      path: '/getall',
      name: 'GetAllAccounts',
      component: GetAllAccounts
    },
    {
      path: '/add',
      name: 'AddAccount',
      component: AddAccount
    },
    {
      path: '/edit',
      name: 'EditAccount',
      component: EditAccount
    }
  ]
})