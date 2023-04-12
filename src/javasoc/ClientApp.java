package javasoc;


public class ClientApp implements App {
    public static void main(String[] args) {
        ClientApp client = new ClientApp();
        client.demo();
    }

    public String demo() {
        // print statements about each object are run inside the constructor
        // create some users
        Person p1 = new Person("http/user/shane", "Shane");
        Person p2 = new Person("http/user/bob", "Bob");
        Person p3 = new Person("http/user/james", "James");

        // cretae some objects
        Note NoteTest = new Note("Note", "SendNote", "http/note/1", "Hello");
        Image ImgTest = new Image("Image", "SendImage", "http/image/1", new Url("Image", "http/image/dog", "JPEG"));
        
        // create activites and add to p1 outbox
        p1.MakeCreate("http/created/note/2", "A note was created", p1, NoteTest);
        p1.MakeCreate("http.created/image/2", "An Image was created", p1, ImgTest);

        
        // get activity out of p1's outbox

        // p2 gets this activity into their inbox

        // p2 will now read this note and send it to p3




        return "hello";
    }

    public Outbox getOutbox() {
        return null;
    }

    public Inbox getInbox() {
        return null;
    }
}

/* Trash */
interface App {
    Inbox getInbox();

    Outbox getOutbox();

    String demo();
}

interface Activity {
    String getURI();
}

// inbox
interface ReceiveMessage {
    boolean receive(Activity act);
}

interface ReadNextMessage {
    Activity readNext();
}

interface Inbox extends ReceiveMessage, ReadNextMessage {
    int getCount();
}

// outbox
interface SendMessage {
    boolean send(Activity act);
}

interface DeliverNextMessage {
    Activity deliverNext();
}

interface Outbox extends SendMessage, DeliverNextMessage {
    int getCount();
}
