javac -d mods --module-source-path src/main/java  $(find src/main/java -name '*.java')

java -p mods -m org.peddi.java.se11/org.peddi.java.se11.App
