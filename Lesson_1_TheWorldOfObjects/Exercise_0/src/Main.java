
public class Main {

    public static void main(String[] args) {
        // write your code here
        ContactManger myContactManger = new ContactManger();
        Contact[] myNewFriends = new Contact[5];
        myNewFriends[0] = new Contact("ahmed", "0101484548");
        myNewFriends[1] = new Contact("khalid", "0415321542");
        myNewFriends[2] = new Contact("yousef", "10542401251");
        myNewFriends[3] = new Contact("afify", "0423287");
        myNewFriends[4] = new Contact("ammar", "011215841");
        for (Contact contact :
                myNewFriends) {
            myContactManger.addContact(contact);
        }
        for (Contact contact :
                myNewFriends) {
            String phoneNumber = myContactManger.searchContact(contact.name).phoneNumber;
            System.out.println(phoneNumber);
        }
    }
}
