import SwiftUI
import shared

struct ServerDetailsView: View {
    
    @State private var serverId: Int64 = 0
    
    var server: Server
    
    var body: some View {
        VStack {
            Text(server.title!).font(.title)
        }
//        .navigationBarTitle(item.title, displayMode: .inline)
//        .navigationTitle(item.title)
    }
}

//struct ServerDetailsView_Previews: PreviewProvider {
//    static var previews: some View {
//        ServerDetailsView(server: Server(ID: 0, title: "", url: "", token: ""))
//    }
//}
