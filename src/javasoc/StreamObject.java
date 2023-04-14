
// stream objects
abstract class StreamObject {
    String name;
    String type;
    String uri;

    StreamObject(String name, String type, String uri) {
        setName(name);
        setType(type);
        setUri(uri);
    }

    // setters
    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    // this is used by our subclasses when they show their creation 
    public void CreateOver() {
        System.out.println("\nA new " + this.type + " has been created!");
        System.out.println("Name: " + this.name);
        System.out.println("Uri: " + this.uri);
    }

}

class Article extends StreamObject {
    String content;
    Person attributedTo;

    // constructor
    Article(String type, String name, String uri, String content, Person attributedTo) {
        super(name, type, uri);
        this.content = content;
        this.attributedTo = attributedTo;
    }

    public void Created() {
        CreateOver();
        System.out.println("Content: " + this.content);
        System.out.println("Attributed To: " + this.attributedTo.name);
    }
}

class Event extends StreamObject {
    String startTime;
    String endTime;

    Event(String type, String name, String uri, String startTime, String endTime) {
        super(name, type, uri);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void Created() {
        CreateOver();
        System.out.println("Start Time: " + this.startTime);
        System.out.println("End Time: " + this.endTime);
    }
}

class Note extends StreamObject {
    String content;

    Note(String type, String name, String uri, String content) {
        super(name, type, uri);
        this.content = content;
    }

    public void Created() {
        CreateOver();
        System.out.println("Content: " + this.content);
    }
}

class Document extends StreamObject {
    Url url;

    // constructor
    Document(String type, String name, String uri, Url url) {
        super(name, type, uri);
        this.url = url;
    }

    // setters
    void setUrl(Url url) {
        this.url = url;
    }

    public void Created() {
        CreateOver();
        System.out.println("Url:\n" + this.url);

    }
}

// Documents Classes
class Audio extends Document {
    // constructor
    Audio(String type, String name, String uri, Url url) {
        super(name, type, uri, url);
    }
}

class Image extends Document {
    // constuctor
    Image(String type, String name, String uri, Url url) {
        super(name, type, uri, url);
    }
}

class Page extends Document {
    // constructor
    Page(String type, String name, String uri, Url url) {
        super(name, type, uri, url);
    }
}