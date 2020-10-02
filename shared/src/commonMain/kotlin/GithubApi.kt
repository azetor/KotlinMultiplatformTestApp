import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.request.*
import io.ktor.utils.io.core.*
import kotlinx.coroutines.*

expect fun engine(): HttpClientEngine

class GithubApi {

    fun users(block: (String) -> Unit) {
        HttpClient(engine())
            .use { client ->
                GlobalScope.launch(dispatcher()) {
                    block(client.get("https://api.github.com/users/azetor"))
                }
            }
    }
}