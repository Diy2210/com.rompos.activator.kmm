import Foundation

struct ServerModel: Identifiable {
    var id = UUID()
    var title: String
    var url: String
    var token: String
}
