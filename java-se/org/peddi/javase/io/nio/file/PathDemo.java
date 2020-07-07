package org.peddi.javase.io.nio.file;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.lang.System.out;

import java.io.IOException;
import java.net.URI;

public class PathDemo {
	private final String base = System.getenv("HOME") + "/AppData/JavaFileIO/";
	String pstr = "Path1/Test.txt";
	URI uri1 = URI.create("File:///"+ base +"Path1/Hello.java");
	
	public void createPath() {
		
		out.println("\n\nPath.of()");
		
		Path p3 = Path.of(base, pstr);
		out.printf("Path from the String: %s%n" ,p3);
		Path p4 = Path.of(uri1);
		out.printf("Path from the URL: %s%n" ,p4);
		
		out.println("\n\nFileSystem.getPath()");
		FileSystem fs = FileSystems.getDefault();
		Path p5 = fs.getPath(base, pstr);
		out.printf("Path from the String: %s%n" ,p5);
		
		out.println("\nPaths.get()");
		
		Path p1 = Paths.get(base, pstr);
		out.printf("Path from the String: %s%n" ,p1);
		Path p2 =Paths.get(uri1);
		out.printf("Path from the URL: %s%n" ,p2);
		
		out.println();
		out.println(p5.getClass());
		out.println(p4.getClass());
		
	}
	
	public void getPathInfo() {
		
		Path fp = Path.of(base + pstr);
		
		out.println("Absolute Path Info");
		
		out.format("toString: %s%n", fp.toString());
		out.format("getFileName: %s%n", fp.getFileName());
		out.format("geteName(0): %s%n", fp.getName(0));
		out.format("getNameCount: %d%n",fp.getNameCount());
		out.format("subPath(0,2): %s%n", fp.subpath(0, 2));
		out.format("getParent: %s%n", fp.getParent());
		out.format("getRoot: %s%n", fp.getRoot());
		out.format("isAbsolute: %s%n",fp.isAbsolute());
		
		
		Path fp2 = Path.of( pstr);
		
		out.println("\nRelative Path Info");
		
		out.format("toString: %s%n", fp2.toString());
		out.format("getFileName: %s%n", fp2.getFileName());
		out.format("geteName(0): %s%n", fp2.getName(0));
		out.format("getNameCount: %d%n",fp2.getNameCount());
		out.format("subPath(0,2): %s%n", fp2.subpath(0, 2));
		out.format("getParent: %s%n", fp2.getParent());
		out.format("getRoot: %s%n", fp2.getRoot());
		out.format("isAbsolute: %s%n",fp2.isAbsolute());
	}
	
	public void removeRedundanciesWithNormalize() {
		// removing the redundancies with normalize()
		
		String sp1 = "/home/./joe/foo";
		String sp2 = "/home/sally/../joe/foo";
		
		Path p1 = Path.of(sp1);
		Path p2 = Path.of(sp2);
		
		Path np1 = p1.normalize();
		Path np2 = p2.normalize();
		
		out.println("removeRedundanciesWithNormalize");
		out.printf("Path: %s, NormalizedPath: %s%n", p1, np1);
		out.printf("Path: %s, NormalizedPath: %s%n", p2, np2);
		
	}
	
	public void convertPath() {
		
		out.println("convertPath");
		Path p1 = Path.of(base, pstr);
		URI uri = p1.toUri();
		out.printf("path: %s, toURI: %s%n", p1, uri);
		
		String sp2 = "Sample.txt";
		
		Path p2 = Path.of(sp2);
		Path absPath = p2.toAbsolutePath();
		out.printf("Path: %s, toAbsolutePath: %s%n", p2, absPath);
		
		String sp3 = "Temp.txt";
		Path p3 = Path.of(sp3);
		try {
			Path realPath = p3.toRealPath();
			out.printf("Path: %s, toRealPath: %s%n", p3, realPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void joinTwoPaths() {
		
		String sp1 = "/home/user/joe/";
		Path absPath = Path.of(sp1);
		Path file = Path.of("foo.txt");
		Path resolvedPath = absPath.resolve(file);
		out.println("joinTwoPaths()");
		out.printf("absPath.resolvePath(): %s%n", resolvedPath);
		
		
		Path p = file.resolve(absPath);
		out.printf("resolvePath(absPath): %s%n", p);
		
	}

	public void createPathBetweenTwoPaths() {
		Path p1 = Path.of("file1");
		Path p2 = Path.of("file2");
		
		Path p1_to_p2 = p1.relativize(p2);
		out.println("createPathBetweenTwoPaths");
		out.printf("relative path of file2 from file1: %s%n", p1_to_p2);
		Path p2_to_p1 = p2.relativize(p1);
		out.printf("relative path of file1 from file2: %s%n", p2_to_p1);
	}
	
	public void comparePaths() {
		out.println("comparePaths");
		Path p1 = Path.of("/home/user/test.txt");
		Path p2 = Path.of("/home/user/test.txt");
		
		System.out.printf( "p1 equals p2: %b%n",p1.equals(p2));
		System.out.printf( "p1.compareTo(p2): %d%n",p1.compareTo(p2));
		
		out.printf("startsWith: %b%n", p1.startsWith("/home"));
		out.printf("endsWith: %b%n", p1.endsWith("sample.txt"));
		
		out.println("\nPath Enumeration");
		for(Path p: p1) {
			out.println(p);
		}
	
		
	}
	public static void main(String[] args) {
		PathDemo app = new PathDemo();
		//app.createPath();
		//app.getPathInfo();
		//app.removeRedundanciesWithNormalize();
		//app.convertPath();
		//app.joinTwoPaths();
		//app.createPathBetweenTwoPaths();
		app.comparePaths();

	}

}
