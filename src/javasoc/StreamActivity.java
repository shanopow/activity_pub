
public abstract class StreamActivity implements Activity{
    String uri;
    String summary;
    Person actor;
    Person target;
    boolean followsend; // this is to determine whether to send to our followers or not
    // typically the subject of the activity
    StreamObject object;
    
    // standard constructor
    StreamActivity(String uri, String summary, Person actor, Person target, StreamObject object, boolean followsend){
        setSummary(summary);
        setUri(uri);
        setActor(actor);
        setTarget(target);
        setObject(object);
        setFollowSend(followsend);
    }
    
    // constructor for Lik, Follow and Unfollow (They need no object attached)
    StreamActivity(String uri, String summary, Person actor, Person target){
        setSummary(summary);
        setUri(uri);
        setActor(actor);
        setTarget(target);
        setFollowSend(false);
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
        System.out.println("\nAn Activity was created!");
        System.out.println("Uri: " + this.uri);
        System.out.println("Summary: " + this.summary);
        System.out.println("Target: " + this.target.uri);
        
        // follows unfollows and likes done use this field
        if (this.object != null){
            System.out.println("Object: " + this.object.uri);
        }
    }
}

 class Like extends StreamActivity{
    Like(String uri, String summary, Person actor, Person target){
        super(uri, summary, actor, target);
        Created();
    }
}

 class Follow extends StreamActivity{
    Follow(String uri, String summary, Person actor, Person target){
        super(uri, summary, actor, target);
        Created();
    }
}

 class Unfollow extends StreamActivity{
    Unfollow(String uri, String summary, Person actor, Person target){
        super(uri, summary, actor, target);
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
