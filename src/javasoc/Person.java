package javasoc;
import java.util.Queue;
import java.util.LinkedList;

public class Person implements App{
    String uri;
    String name;
    String preferredUsername;
    String summary;
    Inbox inbox_inter;
    Outbox outbox_inter;
    Queue<Activity> wait_in = new LinkedList<>();
    Queue<Activity> inbox = new LinkedList<>();
    Queue<Activity> outbox = new LinkedList<>();

    Person followers[];
    Person following[];

    Person(String uri, String name){
        this.uri = uri;
        this.name = name;
        // make users inbox
        inbox_inter = new Inbox() {
            public int getCount(){
                return inbox.size();
            }
            
            //add to inbox
            public boolean receive(Activity act){
                if (wait_in.size() > 0){
                    inbox.add(wait_in.peek());
                    wait_in.remove();
                    return true;
                }
                return false;
            }
            
            // read and take out of inbox
            public Activity readNext(){
                Activity read_out = inbox.poll();
                return new Activity(){
                    public String getURI(){
                        return uri;
                    }
                };
            }
        };
        
        // make users outbox
        outbox_inter = new Outbox(){
            public int getCount(){
                return outbox.size();
            }        
            // creates activity and puts in outbox
            public boolean send(Activity act){
                    outbox.add(act);
                    return true;
            }
            
            // remove and deliver next message from outbox
            public Activity deliverNext(){
                Activity send_out = outbox.poll();
                return new Activity(){
                    public String getURI(){
                        return uri;
                    }
                };
            }
        };
    }

    //setters
    void setpreferredUsername(String preferredUsername){
        this.preferredUsername = preferredUsername;
    }
    void setSummary(String summary){
        this.summary = summary;
    }
    
    public Inbox getInbox(){ 
        return this.inbox_inter;
    }
    
    public Outbox getOutbox(){
        return this.outbox_inter;
    }
    
    public String demo(){
        return "hello";
    }
    public String toString(){
        return "Person was created!\n" + "Name: "  + this.name + "\nUri: " + this.uri;
    }

    //object creation
}