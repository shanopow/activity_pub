package javasoc;

public abstract class StreamActivity implements Activity{
    String uri;
    String summary;
    Person actor;
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
}

 class Like extends StreamActivity{
    Like(String uri, String summary, Person actor, StreamObject object){
        super(uri, summary, actor, object);
    }
}

 class Follow extends StreamActivity{
    Follow(String uri, String summary, Person actor, StreamObject object){
        super(uri, summary, actor, object);
    }
}

 class Unfollow extends StreamActivity{
    Unfollow(String uri, String summary, Person actor, StreamObject object){
        super(uri, summary, actor, object);
    }
}

 class Create extends StreamActivity{
    Create(String uri, String summary, Person actor, StreamObject object){
        super(uri, summary, actor, object);
    }
}

 class Delete extends StreamActivity{
    Delete(String uri, String summary, Person actor, StreamObject object){
        super(uri, summary, actor, object);
    }
}
