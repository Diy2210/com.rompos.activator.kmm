import SwiftUI
import shared

struct ServerItem: View {
    
    @State private var showEditView = true
    
    var server: Server
    
    var body: some View {
        HStack {
            VStack(alignment: .leading) {
                Text(server.title!)
                    .font(.headline)
                    .fontWeight(.bold)
                Text(server.url!)
                    .font(.subheadline)
                    .foregroundColor(Color.gray)
                    .lineLimit(2)
            }
        }
    }
}
