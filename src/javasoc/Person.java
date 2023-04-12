package javasoc;

public class Person implements App{
    // the current activity that this person is handling
    StreamActivity currentHeld;
    
    String uri;
    String name;
    String preferredUsername;
    String summary;
    InboxPhys inbox = new InboxPhys();
    OutboxPhys outbox = new OutboxPhys();

    Person followers[];
    Person following[];

    Person(String uri, String name){
        this.uri = uri;
        this.name = name;
        System.out.println(this);
    }

    //setters
    void setpreferredUsername(String preferredUsername){
        this.preferredUsername = preferredUsername;
    }
    void setSummary(String summary){
        this.summary = summary;
    }
    
    public Inbox getInbox(){ 
        return this.inbox;
    }
    
    public Outbox getOutbox(){
        return this.outbox;
    }
    
    // misc
    public String demo(){
        return "hello";
    }
    
    public String toString(){
        return "\nA Person was created!\n" + "Name: "  + this.name + "\nUri: " + this.uri;
    }

    //activity creation, puts into out outbox for delivery
    // Used when we already hav an object to put in the outbox
    void OutPut(Activity tosend){
        if (outbox.send(tosend)){
            System.out.println("\nSent to outbox: " + tosend.uri);
        }
    }
    // Used when creating objects for the outbox
    void MakeLike(String uri, String summary, Person actor, StreamObject object){
        Like tosend = new Like(uri, summary, actor, object);
        if (outbox.send(tosend)){
            System.out.println("\nSent to outbox: " + tosend.uri);
        }
    }
    
    void MakeFollow(String uri, String summary, Person actor, StreamObject object){
        Follow tosend = new Follow(uri, summary, actor, object);
        if (outbox.send(tosend)){
            System.out.println("\nSent to outbox: " + tosend.uri);
        }    }
    
    void MakeUnFollow(String uri, String summary, Person actor, StreamObject object){
        Unfollow tosend = new Unfollow(uri, summary, actor, object);
        if (outbox.send(tosend)){
            System.out.println("\nSent to outbox: " + tosend.uri);
        }    }
    
    void MakeCreate(String uri, String summary, Person actor, StreamObject object){
        Create tosend = new Create(uri, summary, actor, object);
        if (outbox.send(tosend)){
            System.out.println("\nSent to outbox: " + tosend.uri);
        }    }
    
    void MakeDelete(String uri, String summary, Person actor, StreamObject object){
        Delete tosend = new Delete(uri, summary, actor, object);
        if (outbox.send(tosend)){
            System.out.println("\nSent to outbox: " + tosend.uri);
        }    }
}