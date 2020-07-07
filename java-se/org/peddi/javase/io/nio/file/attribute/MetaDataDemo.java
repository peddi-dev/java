package org.peddi.javase.io.nio.file.attribute;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermissions;
import java.time.Instant;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class MetaDataDemo {
	private final String base = System.getenv("HOME") + "/AppData/JavaFileIO/";
	String pstr = "Path1/Test.txt";
	Path path = Path.of(base + pstr);
	
	public void readAttriibutesFromAllFileAttributeViews() {
		
		String[] fileAttributeViewNames = new String[] { "basic", "posix", "dos", "acl"};
		// "dos", "acl"
		
		for(String viewName: fileAttributeViewNames) {
			readAttributesByFileAttributeViewName(viewName);
		}
		
	}
	
	public void readAttributesByFileAttributeViewName(String fileAttributeViewName) {
		
		
		out.println("\n*** Attributes From View: " + fileAttributeViewName);
		// "*" also works because default default view-name is "basic"
		String attributeNames = fileAttributeViewName + ":*"; 
		
		try {
			Map<String, Object> basicAttrMap = Files.readAttributes(path, attributeNames);
			
			basicAttrMap.entrySet().stream().forEach(e -> out.println(e));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (java.lang.UnsupportedOperationException e) {
			System.out.println(e.getMessage());
		}
		
	}

	
	public void basicAttributes() {
		out.println("BasicFileAttributes");
		try {
			BasicFileAttributes bfAttrs = Files.readAttributes(path, BasicFileAttributes.class);
			
			printBasicFileAttributes(bfAttrs);
			
			
			//Setting Last Modified Time
			FileTime fileTime = FileTime.from(Instant.now());
			//Files.setLastModifiedTime(path, fileTime);
			String attrName = "basic:lastModifiedTime";
			Files.setAttribute(path, attrName, fileTime );
			out.printf("%nlastModifiedTime: %s%n", Files.getLastModifiedTime(path));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void printBasicFileAttributes(BasicFileAttributes bfAttrs) {
		out.printf("creationTime: %s%n", bfAttrs.creationTime());
		out.printf("lastModifiedTime: %s%n", bfAttrs.lastModifiedTime());
		out.printf("lastAccessTime: %s%n", bfAttrs.lastAccessTime());
		
		out.printf("%nsize: %s%n", bfAttrs.size());
		
		out.printf("%nisRegularFile: %b%n", bfAttrs.isRegularFile());
		out.printf("isDirectory: %b%n", bfAttrs.isDirectory());
		out.printf("isSymbolicLink: %b%n", bfAttrs.isSymbolicLink());
		out.printf("isOther: %b%n", bfAttrs.isOther());
		
		out.printf("%nfileKey: %s%n", bfAttrs.fileKey());
	}
	

	
	public void basicFileAttributeView(){
		
		out.println("*****BasicFileAttributeView");
		
		BasicFileAttributeView basicFAV = Files.getFileAttributeView(path, BasicFileAttributeView.class);
		
		try {
			BasicFileAttributes basicAttrs =  basicFAV.readAttributes();
			printBasicFileAttributes(basicAttrs);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}


	public void posixFileAttributes() {
		
		out.println("PosixFileAttributes");
		try {
			
			PosixFileAttributes posixAttrs = Files.readAttributes(path, PosixFileAttributes.class);
			
			out.printf("Owner: %s%n", posixAttrs.owner());
			out.printf("Group: %s%n", posixAttrs.group());
			String permissions = PosixFilePermissions.toString(posixAttrs.permissions());
			out.printf("FilePermissions: %s%n", permissions);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void aclFileAttributeView() {
		//ACL = AccessControlLists
		
		AclFileAttributeView ACLfav = Files.getFileAttributeView(path, AclFileAttributeView.class);
		if ( ACLfav == null) {
			out.println("AclFileAttributeView object is null");
			return;
		}
		try {
			List<AclEntry> aclEntries = ACLfav.getAcl();
			out.println(aclEntries);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void fileStore() {
		out.println("***FileStore");
		try {
			FileStore fs = Files.getFileStore(path);
			out.printf("name: %s%n", fs.name());
			out.printf("type: %s%n", fs.type());
			out.printf("ReadOnly: %s%n", fs.isReadOnly());
			out.printf("TotalSpace: %d%n", fs.getTotalSpace()/1024);
			out.printf("UnallocatedSpace: %d%n", fs.getUnallocatedSpace()/1024);
			
			out.printf("UsableSpace: %d%n", fs.getUsableSpace()/1024);
			out.printf("BlockSize: %s%n", fs.getBlockSize());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

	public static void main(String[] args) {
		MetaDataDemo app  = new MetaDataDemo();
		app.readAttriibutesFromAllFileAttributeViews();
		//app.basicAttributes();
		//app.posixFileAttributes();
		//app.fileStore();
		//app.aclFileAttributeView();
		//app.basicFileAttributeView();
		

	}

}
