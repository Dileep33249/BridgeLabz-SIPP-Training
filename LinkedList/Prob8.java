import java.util.*;

public class SocialMediaConnections {
    static class User {
        int userId;
        String name;
        int age;
        Set<Integer> friendIds;
        User next;

        User(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.friendIds = new HashSet<>();
        }
    }

    User head = null;

    public void addUser(int id, String name, int age) {
        User newUser = new User(id, name, age);
        newUser.next = head;
        head = newUser;
    }

    public User getUser(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addFriendConnection(int userId1, int userId2) {
        User user1 = getUser(userId1);
        User user2 = getUser(userId2);
        if (user1 != null && user2 != null && userId1 != userId2) {
            user1.friendIds.add(userId2);
            user2.friendIds.add(userId1);
        }
    }

    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = getUser(userId1);
        User user2 = getUser(userId2);
        if (user1 != null && user2 != null) {
            user1.friendIds.remove(userId2);
            user2.friendIds.remove(userId1);
        }
    }

    public void findMutualFriends(int userId1, int userId2) {
        User user1 = getUser(userId1);
        User user2 = getUser(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("Invalid User IDs.");
            return;
        }

        Set<Integer> mutual = new HashSet<>(user1.friendIds);
        mutual.retainAll(user2.friendIds);

        if (mutual.isEmpty()) {
            System.out.println("No mutual friends.");
        } else {
            System.out.println("Mutual Friends:");
            for (int id : mutual) {
                User user = getUser(id);
                System.out.println(user.name + " (ID: " + id + ")");
            }
        }
    }

    public void displayFriends(int userId) {
        User user = getUser(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println("Friends of " + user.name + ":");
        for (int id : user.friendIds) {
            User f = getUser(id);
            System.out.println(f.name + " (ID: " + id + ")");
        }
    }

    public void searchUser(String keyword) {
        User temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(keyword) || String.valueOf(temp.userId).equals(keyword)) {
                System.out.println("ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("User not found.");
    }

    public void countFriendsPerUser() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friends.");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SocialMediaConnections sm = new SocialMediaConnections();

        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 30);
        sm.addUser(3, "Charlie", 22);
        sm.addUser(4, "Diana", 28);

        sm.addFriendConnection(1, 2);
        sm.addFriendConnection(1, 3);
        sm.addFriendConnection(2, 3);
        sm.addFriendConnection(3, 4);

        System.out.println("--- Friends of Alice ---");
        sm.displayFriends(1);

        System.out.println("\n--- Mutual Friends between Alice and Bob ---");
        sm.findMutualFriends(1, 2);

        System.out.println("\n--- Search User by Name ---");
        sm.searchUser("Charlie");

        System.out.println("\n--- Friends Count ---");
        sm.countFriendsPerUser();

        System.out.println("\n--- Remove Friend Connection Alice & Charlie ---");
        sm.removeFriendConnection(1, 3);
        sm.displayFriends(1);
    }
}
