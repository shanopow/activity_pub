
import java.util.Queue;
import java.util.LinkedList;


// inbox class
class InboxPhys implements Inbox {
    // holds our activities
    Queue<StreamActivity> holder = new LinkedList<>();
    
    public int getCount() {
        return holder.size();
    }
    

    public boolean receive(Activity act) {
        // Cast as a StreamActivity
        StreamActivity toadd = (StreamActivity) act;
        holder.add(toadd);
        return true;
    }
    
    @Override
    public StreamActivity readNext() {
        return holder.poll();
    }
}

// outbox
class OutboxPhys implements Outbox {
    Queue<StreamActivity> holder = new LinkedList<>();
    
    public int getCount() {
        return holder.size();
    }
    
    // used when we create an activity and add to out outbox
    public boolean send(Activity act) {
        StreamActivity toadd = (StreamActivity) act;
        holder.add(toadd);
        return true;
    }

    // send item from outbox to another outbox
    @Override
    public StreamActivity deliverNext() {
        return holder.poll();
    }
}

// advanced content for urls, used in some StreamObjects
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

    // getters
    public String getType() {
        return this.type;
    }
    
    public String getHref() {
        return this.href;
    }
    
    public String getMediaType() {
        return this.media_type;
    }

    public String toString() {
        return "Type: " + this.type + "\nHref: " + this.href + "\nMediaType: " + this.media_type;
    }
}
