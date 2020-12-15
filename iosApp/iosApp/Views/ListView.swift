import SwiftUI

struct ListView: View {
    
    var item: ServerModel
    
    var body: some View {
        HStack {
            VStack(alignment: .leading) {
                Text(item.title)
                    .font(.headline)
                    .fontWeight(.bold)
                    .contextMenu {
                        menuItems
                }
                Text(item.url)
                    .font(.subheadline)
                    .foregroundColor(Color.gray)
                    .lineLimit(2)
            }
        }
    }
    
    var menuItems: some View {
        Group {
            NavigationLink(destination: EditView()) {
                Text("Edit")
            }
            NavigationLink(destination: EditView()) {
                Text("Delete")
            }
        }
    }
}

struct ListView_Previews: PreviewProvider {
    static var previews: some View {
        ListView(item: ServerModel(title: "", url: "", token: ""))
    }
}
