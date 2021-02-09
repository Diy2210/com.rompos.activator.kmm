import Foundation
import SwiftUI
import Combine
import shared

class Helper: ObservableObject {
    
    let sdk = ActivatorSDK(databaseDriverFactory: DatabaseDriverFactory())
    
    //Save new server
    func saveServer(title: String, url: String, token: String) {
        sdk.saveServer(title: title, url: url, token: token, completionHandler: { title, error in
            if let title = title {
                print(title)
            } else {
                print(error?.localizedDescription ?? "error")
            }
        }) 
    }
    
    //Update server by id
    func updateServer(title: String, url: String, token: String, id: Int64) {
        sdk.updateServer(title: title, url: url, token: token, id: id, completionHandler: { title, error in
            if let title = title {
                print(title)
            } else {
                print(error?.localizedDescription ?? "error")
            }
        })
    }
    
    //Delete server by id
    func deleteServer(id: Int64) {
        sdk.deleteServer(id: id, completionHandler: { id, error in
            if let id = id {
                print(id)
            } else {
                print(error?.localizedDescription ?? "error")
            }
        })
    }
    
    //Get plugin list
    func getPluginList(server: Server) {
        sdk.getPluginList(server: server, completionHandler: { server, error in
            if let server = server {
                print(server)
            } else {
                print(error?.localizedDescription ?? "error")
            }
        })
    }
    
    //Update plugin status
    func updatePluginStatus(server: Server, pluginModel: PluginModel, state: Bool) {
        sdk.updatePluginStatus(server: server, pluginModel: pluginModel, state: state, completionHandler: { server, error in
            if let server = server {
                print(server)
            } else {
                print(error?.localizedDescription ?? "error")
            }
        })
    }
}
