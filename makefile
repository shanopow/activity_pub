project:
	javac -d classes src/javasoc/Client.java src/javasoc/Person.java src/javasoc/StreamActivity.java src/javasoc/StreamObject.java

other:
	javac -d ../classes src/javasoc/App.java src/javasoc/Person.java src/javasoc/ActivityParent.java

clean:
	rm -r classes/*