package idv.jerry.searchuser.adapter


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import idv.jerry.searchuser.R
import idv.jerry.searchuser.data.UserData
import idv.jerry.searchuser.utils.GlideUtils

class UserAdapter: RecyclerView.Adapter<UserAdapter.UserViewHolder>{
    lateinit var mUserList: ArrayList<UserData>
    lateinit var mContext: Context
    constructor(context: Context){
        mContext = context
        mUserList = ArrayList<UserData>()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false));
    }

    override fun getItemCount(): Int {
        return mUserList.size
    }

    override fun onBindViewHolder(viewHolder: UserViewHolder, position: Int) {
        var userData: UserData = mUserList.get(position)

        viewHolder.tvUserName.setText(userData.login)
        GlideUtils.loadImage(mContext, userData.avatar_url, viewHolder.ivAvastor)

    }

    fun updateUserList(clearList: Boolean, updateList: ArrayList<UserData>){
        if (clearList){
            mUserList.clear()
        }
        mUserList.addAll(updateList)
        notifyDataSetChanged()
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var ivAvastor: ImageView
        lateinit var tvUserName: TextView

        init{
            ivAvastor = itemView.findViewById(R.id.iv_avastor) as ImageView
            tvUserName = itemView.findViewById(R.id.tv_username) as TextView
        }
    }
}

