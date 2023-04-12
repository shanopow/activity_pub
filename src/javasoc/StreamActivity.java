package javasoc;

public abstract class StreamActivity implements Activity{
    String uri;
    String summary;
    Person actor;
    // typically the subject of the activity
    StreamObject object;
    StreamActivity(String uri, String summary, Person actor, StreamObject object){
        setSummary(summary);
        setUri(uri);
        setActor(actor);
        setObject(object);
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

    // getters
    public String getURI(){
        return this.uri;
    };

    public void Created(){
        System.out.println("\nAn activity was sent to the outbox!");
        System.out.println("Uri: " + this.uri);
        System.out.println("Summary: " + this.summary);
        System.out.println("Object: " + this.object.uri);
    }
}

 class Like extends StreamActivity{
    Like(String uri, String summary, Person actor, StreamObject object){
        super(uri, summary, actor, object);
        Created();
    }
}

 class Follow extends StreamActivity{
    Follow(String uri, String summary, Person actor, StreamObject object){
        super(uri, summary, actor, object);
        Created();
    }
}

 class Unfollow extends StreamActivity{
    Unfollow(String uri, String summary, Person actor, StreamObject object){
        super(uri, summary, actor, object);
        Created();
    }
}

 class Create extends StreamActivity{
    Create(String uri, String summary, Person actor, StreamObject object){
        super(uri, summary, actor, object);
        Created();
    }
}

 class Delete extends StreamActivity{
    Delete(String uri, String summary, Person actor, StreamObject object){
        super(uri, summary, actor, object);
        Created();
    }
}
