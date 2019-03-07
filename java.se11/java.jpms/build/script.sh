javac -d mods/come.greetngs/ src/com.greetings/module-info.java  src/com.greetings/com/greetings/Main.java
java  --module-path mods/ -m com.greetings/com.greetings.Main

javac -d mods/org.astro/ src/org.astro/module-info.java  src/org.astro/org/astro/World.java
javac --module-path mods/ -d mods/come.greetngs/ src/com.greetings/module-info.java  src/com.greetings/com/greetings/Main.java

#compiling multiple modules at a time
javac -d mods/ --module-source-path src $(find src -name "*.java")
#packaging
jar -c -f mlib/org.astro@1.0.jar --module-version 1.0 -C mods/org.astro/ .
jar -c -f mlib/com.greetings.jar --main-class=com.greetings.Main -C mods/com.greetings/ .
java -p mlib/ -m com.greetings
java -p mods/ -m com.greetings/com.greetings.Main
#services
javac -d mods/ --module-source-path src $(find src -name "*.java")
javac -d mods/com.greetings/ -p mods src/com.greetings//module-info.java src/com.greetings//com/greetings/Main.java
java -p mods/ -m com.greetings/com.greetings.Main
jar -c -f mlib/com.socket@1.0.jar --module-version=1.0 -C mods/com.socket/ .
jar -c -f mlib/org.fastsocket@1.0.jar --module-version=1.0 -C mods/org.fastsocket/ .
jar -c -f mlib/com.greetings.jar --main-class=com.greetings.Main -C mods/com.greetings/ .

#jlink custom run time image
jlink --module-path /Library/Java/JavaVirtualMachines/jdk-11.0.1.jdk/Contents/Home/jmods:mlib --add-modules com.greetings,org.fastsocket --output greetingsapp
jlink --module-path /Library/Java/JavaVirtualMachines/jdk-11.0.1.jdk/Contents/Home/jmods:mlib --add-modules com.greetings,org.fastsocket --compress 2 --output greetingsapp
#running java module from the custom runtime image(JRE)
greetingsappc/bin/java -m com.greetings
