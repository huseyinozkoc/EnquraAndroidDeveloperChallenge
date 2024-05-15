import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.isActive
import com.example.enquraandroiddeveloperchallenge.common.isNetworkAvailable
import kotlinx.coroutines.channels.awaitClose

object NetworkStatusChecker {

    fun internetConnectionFlow(context: Context): Flow<Boolean> = callbackFlow {
        try {
            while (isActive) {
                val isConnected = isNetworkAvailable(context)
                this.trySend(isConnected).isSuccess
            }
        } catch (e: Exception) {

        }
        awaitClose { }
    }.flowOn(Dispatchers.IO)
}