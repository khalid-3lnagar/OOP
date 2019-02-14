public class ContactManger {
    int myFriendsCount;
    Contact[] myFrindes;

    public ContactManger() {

        myFriendsCount = 0;
        this.myFrindes = new Contact[500];
    }

    public void addContact(Contact newFriend) {
        if (myFriendsCount < 500) {
            myFrindes[myFriendsCount] = newFriend;
            myFriendsCount++;
        }

    }

    public Contact searchContact(String friendName) {
        for (int i = 0; i < myFriendsCount; i++) {
            if (friendName.equals(myFrindes[i].name))
                return myFrindes[i];

        }
        return null;
    }
}
