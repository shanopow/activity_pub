package javasoc;

public abstract class StreamActivity implements Activity{
    String uri;
    String summary;
    Person actor;
    Person target;
    boolean followsend; // this is to determine whether to send to our followers or not
    // typically the subject of the activity
    StreamObject object;
    StreamActivity(String uri, String summary, Person actor, Person target, StreamObject object, boolean followsend){
        setSummary(summary);
        setUri(uri);
        setActor(actor);
        setTarget(target);
        setObject(object);
        setFollowSend(followsend);
    }
    
    // setters
    void setSummary(String summary){
        this.summary = summary;
    }
    void setActor(Person actor){
        this.actor = actor;
    }
    void setObject(StreamObject object){
        this.object = object;
    }
    void setUri(String uri){
        this.uri = uri;
    }
    void setTarget(Person target){
        this.target = target;
    }
    void setFollowSend(boolean followsend){
        this.followsend = followsend;
    }

    // getters
    public String getURI(){
        return this.uri;
    };

    public void Created(){
        System.out.println("\nAn created!");
        System.out.println("Uri: " + this.uri);
        System.out.println("Summary: " + this.summary);
        System.out.println("Target: " + this.target.uri);
        System.out.println("Object: " + this.object.uri);
    }
}

 class Like extends StreamActivity{
    Like(String uri, String summary, Person actor, Person target, StreamObject object){
        super(uri, summary, actor, target, object, false);
        Created();
    }
}

 class Follow extends StreamActivity{
    Follow(String uri, String summary, Person actor, Person target, StreamObject object){
        super(uri, summary, actor, target, object, false);
        Created();
    }
}

 class Unfollow extends StreamActivity{
    Unfollow(String uri, String summary, Person actor, Person target, StreamObject object){
        super(uri, summary, actor, target, object, false);
        Created();
    }
}

 class Create extends StreamActivity{
    Create(String uri, String summary, Person actor,Person target, StreamObject object, boolean followsend){
        super(uri, summary, actor, target, object, followsend);
        Created();
    }
}

 class Delete extends StreamActivity{
    Delete(String uri, String summary, Person actor, Person target, StreamObject object, boolean followsend){
        super(uri, summary, actor, target, object, followsend);
        Created();
    }
}
