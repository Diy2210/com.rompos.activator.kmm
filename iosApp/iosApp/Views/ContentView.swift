import SwiftUI
import shared

struct ContentView: View {
    
    var body: some View {
        NavigationView {
            VStack(alignment: .trailing) {
                List(Servers.serverList) { item in
                    NavigationLink(destination:
                        ServerDetailsView(item: item)) {
                            ListView(item: item)
                    }
                }
                .navigationTitle("Compoza.net")
                .toolbar {
                    NavigationLink(destination: EditView()) {
                        Image(systemName: "plus")
                    }
                }
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
