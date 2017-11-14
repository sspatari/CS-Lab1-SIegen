compile:
	javac *.java

start:
	rmiregistry &

deploy:
	java -classpath ./mysql-connector-java-3.0.10-stable-bin.jar:. StockExchangeServer &

clean:
	rm -f *.class

stop:
	killall rmiregistry java
