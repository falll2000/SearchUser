package idv.jerry.searchuser.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class NetworkUtils {
    companion object {
        @JvmStatic fun getNetworkStatus(context: Context): Boolean{
            var connectivity: ConnectivityManager? = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            if (connectivity == null || connectivity.activeNetworkInfo == null){
                return false
            } else {
                val networkInfo: NetworkInfo = connectivity.activeNetworkInfo;

                return networkInfo.isConnected;
            }
        }
    }

}