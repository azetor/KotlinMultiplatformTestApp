import io.ktor.client.engine.*
import io.ktor.client.engine.ios.*

actual fun engine(): HttpClientEngine = Ios.create()