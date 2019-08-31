package idv.jerry.searchuser.data

import kotlin.properties.Delegates

class UserData{
    lateinit var login: String
    var id: Long by Delegates.notNull<Long>()
    lateinit var node_id: String
    lateinit var avatar_url: String
    lateinit var gravatar_id: String
    lateinit var url: String
    lateinit var html_url: String
    lateinit var followers_url: String
    lateinit var following_url: String
    lateinit var gists_url: String
    lateinit var starred_url: String
    lateinit var subscriptions_url: String
    lateinit var organizations_url: String
    lateinit var repos_url: String
    lateinit var events_url: String
    lateinit var received_events_url: String
    lateinit var type: String
    var site_admin: Boolean by Delegates.notNull<Boolean>()
    var score: Double by Delegates.notNull<Double>()
}