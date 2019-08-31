package idv.jerry.searchuser.model

import com.google.gson.Gson
import idv.jerry.searchuser.data.ResponseData
import idv.jerry.searchuser.data.UserData
import idv.jerry.searchuser.utils.GsonHelper
import idv.jerry.searchuser.utils.HttpUtils

class MainModel{

    fun getUserList(keyword: String): ArrayList<UserData>?{
        var userList= ArrayList<UserData>()

        var result: String = HttpUtils.getUserList(keyword);

        if (result.equals("Fail")){
            return null
        } else {
            var responseData: ResponseData<UserData> = GsonHelper.jsonToResponseData(result)

            if (responseData.items != null){
                return responseData.items;
            } else {
                return ArrayList<UserData>()
            }
        }

    }
}