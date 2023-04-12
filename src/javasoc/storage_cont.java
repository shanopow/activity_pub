package javasoc;


import java.util.Queue;
import java.util.LinkedList;


// inbox class
class InboxPhys implements Inbox {
    Queue<StreamActivity> holder = new LinkedList<>();

    
    // used when we recieve an activity and put it into the storage
    public boolean PutIn(StreamActivity toput){
        holder.add(toput);
        return true;
    }

    // send out outbox to another outbox
    public StreamActivity recieveNext(){
        return holder.poll();
    }
    
    public int getCount() {
        return holder.size();
    }
    
    // interface methods

    public boolean receive(Activity act) {
        return true;
    }

    public Activity readNext() {
        return holder.poll();
    }
}

// outbox
class OutboxPhys implements Outbox {
    Queue<StreamActivity> holder = new LinkedList<>();

    // used when we create an activity and add to out outbox
    public boolean PutIn(StreamActivity toput){
        holder.add(toput);
        return true;
    }

    // send out outbox to another outbox
    public StreamActivity sendNext(){
        return holder.poll();
    }
    
    public int getCount() {
        return holder.size();
    }
    
    // interface methods
    public boolean send(Activity act) {
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
