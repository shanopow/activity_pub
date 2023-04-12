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

        // create some objects
        Note NoteTest = new Note("Note", "SendNote", "http/note/1", "Hello");
        Image ImgTest = new Image("Image", "SendImage", "http/image/1", new Url("Image", "http/image/dog", "JPEG"));
        
        // create activites for the objects (they belong to p1 and will be sent to p2)
        p1.MakeCreate("http/created/note/2", "A note was created", p1, p2, NoteTest, true);
        p1.MakeCreate("http.created/image/2", "An Image was created", p1, p2, ImgTest, false);

        p1.emptier();
        // these will now try to send to their destination




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
