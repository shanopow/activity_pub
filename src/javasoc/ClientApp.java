package javasoc;

import java.util.Queue;
import java.util.LinkedList;

public class ClientApp implements App {
    public static void main(String[] args) {
        ClientApp client = new ClientApp();
        client.demo();
    }

    public String demo() {
        // print statements about each object are run inside the constructor
        // create some users
        Person p1 = new Person("http/shane", "Shane");
        Person p2 = new Person("http/bob", "Bob");
        Person p3 = new Person("http/james", "James");

        // going to create a note and an image and send it from p1 to p2 and from p1 to p3
        Note NoteTest = new Note("Note", "SendNote", "http/note", "Hello");
        // image takes a cusotm url attribute
        Image ImgTest = new Image("Image", "SendImage", "http/image", new Url("Image", "http/image/dog", "JPEG"));
        
        // first add to p1's outbox
        p1.MakeCreate("http/created/note", "A note was created", p1, NoteTest);
        p1.MakeCreate("http.created/image", "An Image was created", p1, ImgTest);

        // get activity out of p1's outbox
        Activity blah2 = p1.outbox.deliverNext();

        // p2 gets this activity into their inbox
        p2.inbox.receive(blah2);

        // p2 will now read this note and send it to p3
        Activity blah3 = p2.inbox.readNext();
        p2.OutPut(blah3);



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

// inbox class
class InboxPhys implements Inbox {
    Queue<Activity> holder = new LinkedList<>();

    public int getCount() {
        return holder.size();
    }

    public boolean receive(Activity act) {
        if (getCount() >= 0) {
            System.out.println("\nReceived: " + act.getURI());
            holder.add(act);
            return true;
        }
        return false;
    }

    public Activity readNext() {
        return holder.poll();
    }
}

// outbox
class OutboxPhys implements Outbox {
    Queue<Activity> holder = new LinkedList<>();

    public int getCount() {
        return holder.size();
    }

    public boolean send(Activity act) {
        holder.add(act);
        return true;

    }

    public Activity deliverNext() {
        return holder.poll();
    }
}

// advanced content for urls
class Url {
    String type;
    String href;
    String media_type;

    // constructors
    Url(String type) {
        setType(type);
    }

    Url(String type, String href, String media_type) {
        setType(type);
        setHref(href);
        setMediaType(media_type);
    }

    // setters
    public void setType(String type) {
        this.type = type;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void setMediaType(String media_type) {
        this.media_type = media_type;
    }

    public String toString() {
        return "Type: " + this.type + "\nHref: " + this.href + "\nMediaType: " + this.media_type;
    }
}
