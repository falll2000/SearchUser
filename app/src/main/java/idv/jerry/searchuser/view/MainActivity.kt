package idv.jerry.searchuser.view

import android.app.Activity
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import idv.jerry.searchuser.R
import idv.jerry.searchuser.adapter.UserAdapter
import idv.jerry.searchuser.data.UserData
import idv.jerry.searchuser.presenter.MainPresenter
import idv.jerry.searchuser.utils.NetworkUtils

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity(), MainActivityView{


    var userAdapter: UserAdapter ?= null
    var linearLayoutManager: LinearLayoutManager ?= null
    var userList: ArrayList<UserData> ?= null
    var mainPresenter: MainPresenter ?= null

    val pageItemCount = 10
    var nowPageCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userList = ArrayList<UserData>()
        mainPresenter = MainPresenter(this);

        setupRecycerView()
    }

    fun searchOnClick(view: View){

        if (NetworkUtils.getNetworkStatus(this@MainActivity)){
            var keyword = et_keyword.text.trim().toString()
            GetUserListTask().execute(keyword)
        } else {
            Toast.makeText(this@MainActivity, R.string.no_network, Toast.LENGTH_SHORT).show()
        }

    }

    fun setupRecycerView(){

        userAdapter = UserAdapter(this)
        linearLayoutManager = LinearLayoutManager(this@MainActivity)
        rv_user_list.layoutManager = linearLayoutManager
        rv_user_list.adapter = userAdapter
        rv_user_list.addOnScrollListener(DetectBottomScrollListener())
    }

    override fun refreshSearchUserList(userList: ArrayList<UserData>) {

        this@MainActivity.userList?.clear();
        this@MainActivity.userList?.addAll(userList);

        nowPageCount = 0
        nowPageCount += pageItemCount - 1;

        if (nowPageCount > userList.size){
            nowPageCount = userList.size - 1
        }

        var tmpList = ArrayList<UserData>()

        for (i in 0..nowPageCount){
            tmpList.add(userList.get(i))
        }

        runOnUiThread(object : Runnable{
            override fun run() {
                userAdapter?.updateUserList(true, tmpList)
            }
        })

    }

    override fun getUserListError() {
        runOnUiThread(object: Runnable{
            override fun run() {
                Toast.makeText(this@MainActivity, R.string.get_user_list_fail, Toast.LENGTH_SHORT ).show()
            }
        })
    }
    inner class GetUserListTask: AsyncTask<String, Void, Void>(){
        override fun doInBackground(vararg params: String?): Void? {
            mainPresenter?.getUserList(params[0]!!)
            return null
        }

    }

    inner class DetectBottomScrollListener: RecyclerView.OnScrollListener(){
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            if (linearLayoutManager?.findLastVisibleItemPosition() == linearLayoutManager?.itemCount!! - 1){

                var prevPageCount = nowPageCount + 1;
                nowPageCount += pageItemCount;

                if (nowPageCount > this@MainActivity.userList!!.size){
                    nowPageCount = this@MainActivity.userList!!.size - 1
                }

                var tmpList = ArrayList<UserData>()

                for (i in prevPageCount..nowPageCount){
                    tmpList.add(this@MainActivity.userList!!.get(i))
                }
                userAdapter?.updateUserList(false, tmpList)

                Toast.makeText(this@MainActivity, R.string.drag_to_the_bottom, Toast.LENGTH_SHORT ).show()
            }
        }
    }
}
