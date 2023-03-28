package javasoc;

public class Client implements App{
    public static void main(String[] args){
        Client client = new Client();
        client.demo();
    }
    
    public String demo(){
        Person p1 = new Person("http/shane", "Shane");
        Person p2 = new Person("http/bob", "Bob");
        System.out.println(p1);
        System.out.println(p2);

        return "hello";
    }
    public Outbox getOutbox() {
        return null;
    }
    
    public Inbox getInbox(){
        return null;
    }
}

/* the client App that handles inboxes and outboxes */
interface App {
    Inbox getInbox();
    Outbox getOutbox();
    String demo();
}


interface Activity {
    String getURI();
}

//inbox
interface ReceiveMessage {
    boolean receive(Activity act);
}

interface ReadNextMessage {
    Activity readNext();
}

interface Inbox extends ReceiveMessage, ReadNextMessage {
    int getCount();
}

//outbox
interface SendMessage {
    boolean send(Activity act);
}

interface DeliverNextMessage {
    Activity deliverNext();
}

interface Outbox extends SendMessage, DeliverNextMessage {
    int getCount();
}




// advanced content for urls
class Url{
    String type;
    String href;
    String media_type;
    // constructors
    Url(String type){
        setType(type);
    }

    Url(String type, String href, String media_type){
        setType(type);
        setHref(href);
        setMediaType(media_type);
    }

    //setters
    public void setType(String type){
        this.type = type;
    }

    public void setHref(String href){
        this.href = href;
    }
    
    public void setMediaType(String media_type){
        this.media_type = media_type;
    }
}
