import SwiftUI
import shared

struct ServerDetailsView: View {
    
    @Environment(\.presentationMode) var presentationMode
    
    @ObservedObject var helper = Helper()
    
//    var server: Server
    
    @State var isOn: Bool = false
    
    var title: String = ""
    
//    let listPlugins: [PluginItem]
    
//    var plugin: PluginModel
    
    var body: some View {
        NavigationView {
//            List(listPlugins, id: \.plugin.id) { item in
                //Action
//            }
            Text(title)
        }
    }
    
    func getPluginsList(server: Server) {
        //
        helper.getPluginList(server: server)
    }
}

extension PluginModel: Identifiable { }
//extension PluginItem: Identifiable { }
