package idv.jerry.searchuser.data

import kotlin.properties.Delegates

class ResponseData<T>{
    lateinit var total_count: String
    var incomplete_results: Boolean by Delegates.notNull<Boolean>()
    lateinit var items: ArrayList<T>
}