package singlylinkedlist.socialmediafriendconnection;

public class Main {
    public static void main(String[] args) {
        SocialMediaSystem sms = new SocialMediaSystem();

        // Add users
        sms.addUser(1, "Sahil", 21);
        sms.addUser(2, "Shivam", 24);
        sms.addUser(3, "Vishal", 22);
        sms.addUser(4, "Yuvraj", 22);

        // Add friends
        sms.addFriend(1, 4);
        sms.addFriend(1, 2);
        sms.addFriend(2, 3);
        sms.addFriend(3, 4);

        // Display all users
        sms.displayUsers();

        // Display friends of a specific user
        sms.displayFriends(1);

        // Find mutual friends
        sms.findMutualFriends(1, 2);

        // Count the number of friends
        sms.countFriends(3);

        // Remove a friend
        sms.removeFriend(1, 2);

        // Display friends after removing a friend
        sms.displayFriends(1);
    }
}