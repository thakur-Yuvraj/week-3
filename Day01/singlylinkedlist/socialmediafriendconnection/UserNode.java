package singlylinkedlist.socialmediafriendconnection;

class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friendList;  // List of friend IDs
    UserNode next;

    // Constructor for UserNode
    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendList = null;
        this.next = null;
    }
}