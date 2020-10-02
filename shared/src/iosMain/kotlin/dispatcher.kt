import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import platform.darwin.dispatch_queue_t
import kotlin.coroutines.CoroutineContext

actual fun dispatcher(): CoroutineDispatcher = object : CoroutineDispatcher() {

    private val dispatchQueue: dispatch_queue_t by lazy { dispatch_get_main_queue() }

    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatchQueue) {
            block.run()
        }
    }
}