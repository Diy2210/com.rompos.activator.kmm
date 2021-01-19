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
                    NavigationLink(destination: EditView(serverID: 0)) {
                        Image(systemName: "plus.circle.fill")
                }
            }
        }
    }
    
    func listView() -> AnyView {
        switch viewModel.loadableServers {
        case .loading:
            return AnyView(Text("Loading...").multilineTextAlignment(.center))
        case .result(let servers):
            return AnyView(List(servers) { item in
                NavigationLink(destination: ServerDetailsView(server: item), isActive : self.$showSecondView) {
                    ListView(server: item)
                        .contextMenu {
                            NavigationLink(destination: EditView()) {
                                Text("Edit")
                                Image(systemName: "pencil")
                            }
                            NavigationLink(destination: EditView()) {
                                Text("Delete")
                                Image(systemName: "trash")
                    }
                }
            }
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

extension Server: Identifiable { }
