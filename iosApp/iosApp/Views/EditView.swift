import SwiftUI

struct EditView: View {
    
    @State private var title: String = ""
    @State private var url: String = ""
    @State private var token: String = ""

    var body: some View {
//        NavigationView {
        VStack(alignment: .leading) {
            TextField(" Title", text: $title)
                .border(Color.black)
                .padding(Edge.Set.horizontal, 10)
            TextField(" URL", text: $url)
                .border(Color.black)
                .padding(Edge.Set.horizontal, 10)
            TextField(" Token", text: $token)
                .border(Color.black)
                .padding(Edge.Set.horizontal, 10)
            HStack(alignment: .center) {
                NavigationLink(destination: ContentView()) {
                    Text("cancel")
                        .padding(Edge.Set.vertical, 20)
                        .padding(Edge.Set.horizontal, 20)
                }
                NavigationLink(destination: ContentView()) {
                    Text("save")
                    .padding(Edge.Set.vertical, 20)
                    .padding(Edge.Set.horizontal, 20)
                }
            }.padding(Edge.Set.horizontal, 100)
        }
//        }.navigationBarItems(trailing: NavigationLink(
//        destination: EditView()) {
//            Text("save")
//            }
//        )
    }
}

struct EditView_Previews: PreviewProvider {
    static var previews: some View {
        EditView()
    }
}
