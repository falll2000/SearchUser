package idv.jerry.searchuser.utils

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import java.lang.Exception

class HttpUtils {


    companion object {
//        var url: String = "https://api.github.com/search/users?q=tom+repos"


        private var url: String = "https://api.github.com/search/users"
        private var okhttpClient : OkHttpClient = OkHttpClient();

        @JvmStatic fun getUserList(keyword: String): String{
            var requestUrl = url + "?q=$keyword"
            var request: Request =
                    Request.Builder()
                            .url(requestUrl)
                            .build()

            try {
                var response: Response = okhttpClient.newCall(request).execute()
                return response.body!!.string()
            } catch (e: Exception){
                e.printStackTrace()
                return "Fail"
            }


        }
    }

}