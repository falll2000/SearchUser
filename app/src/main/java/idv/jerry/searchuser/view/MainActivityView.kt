package idv.jerry.searchuser.view

import idv.jerry.searchuser.data.UserData

interface MainActivityView{
    //  更新 recyclerview
    fun refreshSearchUserList(userList: ArrayList<UserData>)
    fun getUserListError()
}