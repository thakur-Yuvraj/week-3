package singlylinkedlist.socialmediafriendconnection;

class FriendNode {
    int friendId;
    FriendNode next;

    // Constructor for FriendNode
    public FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}
