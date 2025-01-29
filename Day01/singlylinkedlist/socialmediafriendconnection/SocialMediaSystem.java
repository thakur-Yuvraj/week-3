package singlylinkedlist.socialmediafriendconnection;

class SocialMediaSystem {
    private UserNode head;

    // Constructor
    public SocialMediaSystem() {
        this.head = null;
    }

    // Add a user to the system
    public void addUser(int userId, String name, int age) {
        UserNode newUser = new UserNode(userId, name, age);
        newUser.next = head;
        head = newUser;
    }

    // Add a friend connection between two users (bi-directional)
    public void addFriend(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);
        if (user1 != null && user2 != null) {
            addFriendToUser(user1, userId2);
            addFriendToUser(user2, userId1);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Add a friend ID to a user's friend list
    private void addFriendToUser(UserNode user, int friendId) {
        FriendNode newFriend = new FriendNode(friendId);
        if (user.friendList == null) {
            user.friendList = newFriend;
        } else {
            FriendNode temp = user.friendList;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newFriend;
        }
    }

    // Remove a friend connection between two users (bi-directional)
    public void removeFriend(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);
        if (user1 != null && user2 != null) {
            removeFriendFromUser(user1, userId2);
            removeFriendFromUser(user2, userId1);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Remove a friend ID from a user's friend list
    private void removeFriendFromUser(UserNode user, int friendId) {
        if (user.friendList == null) return;
        if (user.friendList.friendId == friendId) {
            user.friendList = user.friendList.next;
            return;
        }
        FriendNode temp = user.friendList;
        while (temp.next != null && temp.next.friendId != friendId) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);
        if (user1 != null && user2 != null) {
            FriendNode friendsUser1 = user1.friendList;
            FriendNode friendsUser2 = user2.friendList;
            System.out.print("Mutual Friends: ");
            boolean found = false;
            while (friendsUser1 != null) {
                while (friendsUser2 != null) {
                    if (friendsUser1.friendId == friendsUser2.friendId) {
                        System.out.print(friendsUser1.friendId + " ");
                        found = true;
                        break;
                    }
                    friendsUser2 = friendsUser2.next;
                }
                friendsUser2 = user2.friendList;  // Reset friendsUser2 to the start of the second user's list
                friendsUser1 = friendsUser1.next;
            }
            if (!found) {
                System.out.println("No mutual friends found.");
            }
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Display all friends of a specific user
    public void displayFriends(int userId) {
        UserNode user = findUserById(userId);
        if (user != null) {
            System.out.print("Friends of " + user.name + " (ID: " + userId + "): ");
            FriendNode temp = user.friendList;
            if (temp == null) {
                System.out.println("No friends.");
                return;
            }
            while (temp != null) {
                System.out.print(temp.friendId + " ");
                temp = temp.next;
            }
            System.out.println();
        } else {
            System.out.println("User not found.");
        }
    }

    // Search for a user by ID
    public UserNode findUserById(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;  // User not found
    }

    // Search for a user by Name
    public UserNode findUserByName(String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;  // User not found
    }

    // Count the number of friends for a specific user
    public void countFriends(int userId) {
        UserNode user = findUserById(userId);
        if (user != null) {
            int count = 0;
            FriendNode temp = user.friendList;
            while (temp != null) {
                count++;
                temp = temp.next;
            }
            System.out.println(user.name + " (ID: " + userId + ") has " + count + " friends.");
        } else {
            System.out.println("User not found.");
        }
    }

    // Display all users in the system
    public void displayUsers() {
        UserNode temp = head;
        if (temp == null) {
            System.out.println("No users found.");
            return;
        }
        while (temp != null) {
            System.out.println("User ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
            temp = temp.next;
        }
    }
}