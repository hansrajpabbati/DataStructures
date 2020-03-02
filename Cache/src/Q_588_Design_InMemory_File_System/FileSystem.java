package Q_588_Design_InMemory_File_System;
//Design an in-memory file system to simulate the following functions:
//
//ls: Given a path in string format. If it is a file path, return a list that only contains this file's name. 
//If it is a directory path, return the list of file and directory names in this directory. 
//Your output (file and directory names together) should in lexicographic order.
//
//mkdir: Given a directory path that does not exist, you should make a new directory according to the path.
//If the middle directories in the path don't exist either, you should create them as well.
//This function has void return type.
//
//addContentToFile: Given a file path and file content in string format. 
//If the file doesn't exist, you need to create that file containing given content. 
//If the file already exists, you need to append given content to original content. This function has void return type.
//
//readContentFromFile: Given a file path, return its content in string format.
//
// 
//
//Example:
//
//Input: 
//["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
//[[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
//
//Output:
//[null,[],null,null,["a"],"hello"]
//
//Explanation:
//filesystem



import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class FileSystem {
	
	HashMap<String, TreeSet<String>> directories;
	HashMap<String, StringBuilder> files;

    public FileSystem() {
    	directories = new HashMap<>();
    	files = new HashMap<>();
    	directories.put("/", new TreeSet<>());
        
    }
    
    public List<String> ls(String path) {
    	if(directories.containsKey(path))
    	{
    		
    	}
    	
    	return null;
        
    }
    
    public void mkdir(String path) {
        
    }
    
    public void addContentToFile(String filePath, String content) {
        
    }
    
    public String readContentFromFile(String filePath) {
        return null;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    
//    public static void main(String[] args) {
//		// TODO Auto-generated method stub
////
////    	FileSystem fs = new FileSystem();
////    	fs.ls("/");
////    	fs.mkdir("/a/b/c");
////    	fs.ls("/");
//	}
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */


