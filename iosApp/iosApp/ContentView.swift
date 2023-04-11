import SwiftUI
import shared



struct ContentView: View {
    @ObservedObject private(set) var viewModel: ViewModel

    var body: some View {
        Text(viewModel.text)
    }
}

extension ContentView {
    class ViewModel: ObservableObject {
        @Published var text = "Loading..."
        init() {
            NetworkService().login { login, error in
                DispatchQueue.main.async {
                    if let login = login {
                        
                        self.text = login.username
                        let tokenFromApi : String = login.token
                        
                        NetworkService().getTasks(token: tokenFromApi) { getTasks, error in
                            
                            DispatchQueue.main.async {
                                
                                if let tasks = getTasks {
                                    
                                    self.text = tasks[0].title
                                    
                                } else {
                                    self.text = error?.localizedDescription ?? "error"
                                }
                            }
                        }
                        
                    } else {
                        self.text = error?.localizedDescription ?? "error"
                    }
                }
            }
        }
    }
}
