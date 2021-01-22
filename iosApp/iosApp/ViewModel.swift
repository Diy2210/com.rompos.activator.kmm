import Foundation
import Combine
import shared

class ViewModel: ObservableObject {
    let sdk: ActivatorSDK
    
    init(sdk: ActivatorSDK) {
        self.sdk = sdk
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
