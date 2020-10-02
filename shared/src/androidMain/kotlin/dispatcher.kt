import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

actual fun dispatcher(): CoroutineDispatcher = Dispatchers.Default