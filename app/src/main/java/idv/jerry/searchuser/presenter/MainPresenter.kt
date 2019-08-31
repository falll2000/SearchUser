package idv.jerry.searchuser.presenter

import android.graphics.ColorSpace
import idv.jerry.searchuser.data.UserData
import idv.jerry.searchuser.view.MainActivityView
import idv.jerry.searchuser.model.MainModel

class MainPresenter {
    var callback: MainActivityView
    var mainModel: MainModel = MainModel()

    constructor(mainActivityView: MainActivityView){
        callback = mainActivityView;
    }

    fun getUserList(keyword: String) {

        var userList:  ArrayList<UserData>?= null

        if (keyword.isEmpty()){
            userList = ArrayList<UserData>()
        } else {
            userList = mainModel.getUserList(keyword)
        }

        if (userList == null){
            callback?.getUserListError()
        } else {
            callback?.refreshSearchUserList(userList)
        }

    }
}