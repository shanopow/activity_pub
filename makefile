project:
	javac -d classes src/javasoc/*.java

run:
	cd classes/
	java javasoc.ClientApp
	cd ..

clean:
	rm -r classes/*
