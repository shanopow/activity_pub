package javasoc;
// stream objects
abstract class StreamObject{
    String name;
    String type;
    StreamObject(String name, String type){
        setName(name);
        setType(type);
    }
    // setters
    public void setType(String type){
        this.type = type;
    }
    
    public void setName(String name){
        this.name = name;
    }
}

class Article extends StreamObject{
    String content;
    Person attributedTo;
    // constructor
    Article(String type, String name, String uri, String content, Person attributedTo){
        super(name, type);
        this.content = content;
        this.attributedTo = attributedTo;
    }
}


class Event extends StreamObject{
    String startTime;
    String endTime;
    Event(String type, String name, String startTime, String endTime){
        super(name, type);
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

class Note extends StreamObject{
    String content;
    Note(String type, String name, String content){
        super(name, type);
        this.content = content;
    }
}

class Document extends StreamObject{
    Url url;   
    // constructor
    Document(String type, String name, Url url){
        super(name, type);
        this.url = url;
    }
    // setters
    void setUrl(Url url){
        this.url = url;
    }
}

// Documents Classes
class Audio extends Document{
    // constructors
    Audio(String type, String name, Url url){
        super(name, type, url);
    }
}

class Image extends Document{
    // constuctors
    Image(String type, String name, Url url){
        super(name, type, url);
    }
}


class Page extends Document{
    Page(String type, String name, Url url){
        super(name, type, url);
    }
}