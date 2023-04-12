package javasoc;


import java.util.List;
import java.util.ArrayList;


public class Person implements App{
    // the current activity that this person is handling
    StreamActivity currentHeld;
    
    String uri;
    String name;
    String preferredUsername;
    String summary;
    InboxPhys inbox = new InboxPhys();
    OutboxPhys outbox = new OutboxPhys();

    List <Person> followers = new ArrayList<Person>();
    List <Person> following = new ArrayList<Person>();

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

    // this will empty my outbox and then send the objects to their targets
    // will return true if empties or if we have delivered 50 items
    public boolean emptier(){
        
        while (outbox.getCount() > 0){
            StreamActivity todeliver = outbox.sendNext();
            // send to all of our followers
            if (todeliver.followsend){
                for (Person follow_target: followers){
                    follow_target.inbox.PutIn(todeliver);
                }
            }
            // send to the target
            todeliver.target.inbox.PutIn(todeliver);
            System.out.println("Left the outbox!");
        }
        return true;
    }

    // Used when creating objects for the outbox
    // All activities cretaed here are automatically added to the persons outbox, they cannot exist outside of there
    void MakeLike(String uri, String summary, Person actor, Person target, StreamObject object){
        Like tosend = new Like(uri, summary, actor, target, object);
        if (outbox.PutIn(tosend)){
            System.out.println("\nSent to outbox: " + tosend.uri);
        }
    }
    
    void MakeFollow(String uri, String summary, Person actor, Person target, StreamObject object){
        Follow tosend = new Follow(uri, summary, actor, target, object);
        if (outbox.PutIn(tosend)){
            System.out.println("\nSent to outbox: " + tosend.uri);
        }
    }
    
    void MakeUnFollow(String uri, String summary, Person actor, Person target, StreamObject object){
        Unfollow tosend = new Unfollow(uri, summary, actor, target, object);
        if (outbox.PutIn(tosend)){
            System.out.println("\nSent to outbox: " + tosend.uri);
        }
    }
    
    void MakeCreate(String uri, String summary, Person actor, Person target, StreamObject object, boolean followsend){
        Create tosend = new Create(uri, summary, actor, target, object, followsend);
        if (outbox.PutIn(tosend)){
            System.out.println("\nSent to outbox: " + tosend.uri);
        }
    }
    
    void MakeDelete(String uri, String summary, Person actor, Person target, StreamObject object, boolean followsend){
        Delete tosend = new Delete(uri, summary, actor, target, object, followsend);
        if (outbox.PutIn(tosend)){
            System.out.println("\nSent to outbox: " + tosend.uri);
        }
    }
}