import SwiftUI

struct ServerDetailsView: View {
    
    var item: ServerModel
    
    var body: some View {
        VStack {
            Text(item.title).font(.title)
            Text(item.url).font(.body)
        }
        .navigationBarTitle(item.title, displayMode: .inline)
//        .navigationTitle(item.title)
    }
}

struct ServerDetailsView_Previews: PreviewProvider {
    static var previews: some View {
        ServerDetailsView(item: ServerModel(title: "", url: "", token: ""))
    }
}
