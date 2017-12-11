compile:
	idl Hello.idl
	javac *.java

start:
	ns &

deploy:
	jaco HelloServer &

run:
	jaco HelloClient

clean:
	rm -f *.class _nsdb_root *~
	rm -rf HelloWorld

stop:
	killall java

