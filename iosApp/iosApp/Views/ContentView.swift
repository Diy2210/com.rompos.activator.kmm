import SwiftUI
import shared

struct ContentView: View {
    
    @ObservedObject private(set) var viewModel: ViewModel
    
    @State var showSecondView = false
    
    var body: some View {
        NavigationView {
                listView()
                .navigationTitle("Compoza.net")
                .toolbar {
                    NavigationLink(destination: EditView()) {
                        Image(systemName: "plus")
                }
            }
        }
    }
        
    private func listView() -> AnyView {
        switch viewModel.loadableServers {
            case .loading:
                return AnyView(Text("Loading...").multilineTextAlignment(.center))
            case .result(let servers):
                return AnyView(List(servers) { item in
                    ServerItem(server: item)
                })
            case .error(let description):
                return AnyView(Text(description).multilineTextAlignment(.center))
        }
    }
}

extension ContentView {
    
    enum LoadableServers {
        case loading
        case result([Server])
        case error(String)
    }
    
    class ViewModel: ObservableObject {
        let sdk: ActivatorSDK
        @Published var loadableServers = LoadableServers.loading

        init(sdk: ActivatorSDK) {
            self.sdk = sdk
            self.loadServers(forceReload: false)
        }

        func loadServers(forceReload: Bool) {
            self.loadableServers = .loading
            sdk.getServers(forceReload: forceReload, completionHandler: { servers, error in
                if let servers = servers {
                    self.loadableServers = .result(servers)
                } else {
                    self.loadableServers = .error(error?.localizedDescription ?? "error")
                }
            })
        }
    }
}

extension ServerViewModel: Identifiable { }
extension Server: Identifiable { }
