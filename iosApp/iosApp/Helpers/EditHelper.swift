import Foundation
import SwiftUI
import Combine
import shared

class EditHelper: ObservableObject {
    
//    @Published var serverID: Int = 0
//    @Published var serverFormViewModel = ServerFormViewModel()
    let sdk = ActivatorSDK(databaseDriverFactory: DatabaseDriverFactory())
//    @Published var server = ServerFormViewModel()
//    let sdk: ActivatorSDK
    
    func get(id: Int) {
    }
    
    func save(id: Int, model: ServerFormViewModel) {
//        sdk.saveServer(serverId: id, model: ServerFormViewModel, completionHandler: { })
    }
    
    func saveServer(title: String, url: String, token: String) {
//        sdk.saveServer(title: title, url: url, token: token, completionHandler: { }) in
            
    }
    
    func updateServer(title: String, url: String, token: String, id: Int) {
//        sdk.updateServer(title: title, url: url, token: token, id: id, completionHandler: { })
    }
    
    func delete(id: Int) {
//        sdk.deleteServer(id: id, completionHandler: { })
    }
}
