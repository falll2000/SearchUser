package idv.jerry.searchuser.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import idv.jerry.searchuser.R

class GlideUtils{
    companion object {
        fun loadImage(context: Context, url: String, imageView: ImageView){
            Glide.with(context)
                    .load(url)
                    .centerCrop()
                    .dontAnimate()
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(imageView)
        }
    }

}