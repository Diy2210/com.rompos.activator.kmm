import SwiftUI
import shared

struct ContentView: View {
    
    @State var showSecondView = false
    
    var body: some View {
        NavigationView {
            VStack(alignment: .trailing) {
                List(Servers.serverList) { item in
                    NavigationLink(destination:
                        ServerDetailsView(item: item), isActive : self.$showSecondView) {
                        ListView(item: item)
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
