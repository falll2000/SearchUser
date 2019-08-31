package idv.jerry.searchuser.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import idv.jerry.searchuser.data.ResponseData
import idv.jerry.searchuser.data.UserData

class GsonHelper{
    companion object {

        private var gson: Gson = Gson()

        fun jsonToResponseData(json: String): ResponseData<UserData>{

            class Token : TypeToken<ResponseData<UserData>>()
            val responseData: ResponseData<UserData> = gson.fromJson(json, Token().type)
            return responseData
        }
    }
}