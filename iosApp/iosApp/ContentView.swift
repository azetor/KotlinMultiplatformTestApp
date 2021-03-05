import SwiftUI
import shared

struct ContentView: View {

    @State private var info = "LOADING..."
    
    var body: some View {
        GithubApi()
            .users { (result: String) in
                DispatchQueue.main.async {
                    info = "PLATFORM:" + CurrentPlatformKt.currentPlatform() + "\n" + result
                }
            }
        return ScrollView() {
            Text(info)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
