import SwiftUI

struct ListView: View {
    
    @State private var showEditView = true
    
    var item: ServerModel
    
    var body: some View {
        HStack {
            VStack(alignment: .leading) {
                Text(item.title)
                    .font(.headline)
                    .fontWeight(.bold)
                Text(item.url)
                    .font(.subheadline)
                    .foregroundColor(Color.gray)
                    .lineLimit(2)
            }
        }
    }
}

struct ListView_Previews: PreviewProvider {
    static var previews: some View {
        ListView(item: ServerModel(title: "", url: "", token: ""))
    }
}
