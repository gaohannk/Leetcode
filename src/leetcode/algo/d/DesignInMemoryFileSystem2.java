package leetcode.algo.d;

import java.util.*;

public class DesignInMemoryFileSystem2 {
    static class FileSystem {
        // path, fileName, content
        Map<String, Map<String, String>> file;
        // path, folder
        Map<String, List<String>> directory;

        public FileSystem() {
            this.file = new TreeMap<>();
            this.directory = new TreeMap<>();
            directory.put("/", new LinkedList<>());
        }

        public List<String> ls(String path) {
            List<String> res = new LinkedList<>();
            if (file.containsKey(path)) {
                res.addAll(file.get(path).keySet());
            }
            // both file and folder should list
            if (directory.containsKey(path)) {
                res.addAll(directory.get(path));
            }

            String keyPath = "/";
            if(path.lastIndexOf("/") != 0){
                keyPath = path.substring(0, path.lastIndexOf("/"));
            }
            if (file.containsKey(keyPath) && file.get(keyPath).containsKey(path.substring(path.lastIndexOf("/")+1))) {
                res.add(path.substring(path.lastIndexOf("/")+1));
            }

            Collections.sort(res);
            return res;
        }

        public void mkdir(String path) {
            if (path.length() == 0 || path.length() == 1) {
                return;
            }
            String key = path.substring(0, path.lastIndexOf('/'));
            if(key.equals("")){
                key += "/";
            }
            String folder = path.substring(path.lastIndexOf('/') + 1);
            if (directory.containsKey(key)) {
                if (!directory.get(key).contains(folder)) {
                    directory.get(key).add(folder);
                }
            } else {
                directory.put(key, new LinkedList<>());
                directory.get(key).add(folder);
                mkdir(key);
            }
        }

        public void addContentToFile(String filePath, String content) {
            String fileName = filePath.substring(filePath.lastIndexOf('/') + 1);
            String keyPath = "/";
            if(filePath.lastIndexOf('/') != 0){
                keyPath = filePath.substring(0, filePath.lastIndexOf("/"));
            }
            mkdir(keyPath);
            if (file.get(keyPath) == null) {
                file.put(keyPath, new HashMap<>());
            }
            if (file.get(keyPath).containsKey(fileName)) {
                String newContent = file.get(keyPath).get(fileName) + content;
                file.get(keyPath).put(fileName, newContent);
            } else {
                file.get(keyPath).put(fileName, content);
            }
        }

        public String readContentFromFile(String filePath) {
            String fileName = filePath.substring(filePath.lastIndexOf('/') + 1);
            String keyPath = "/";
            if(filePath.lastIndexOf('/') != 0){
                keyPath = filePath.substring(0, filePath.lastIndexOf("/"));
            }
            if (file.get(keyPath) == null || !file.get(keyPath).containsKey(fileName)) {
                return null;
            }
            return file.get(keyPath).get(fileName);
        }
    }

	public static void main(String[] args) {
		FileSystem fs = new FileSystem();
		System.out.println(fs.ls("/"));
		fs.mkdir("/a/b/c");
		fs.addContentToFile("/a/b/c/d", "hello");
		System.out.println(fs.ls("/"));
		System.out.println(fs.readContentFromFile("/a/b/c/d"));
        System.out.println(fs.file);
        System.out.println(fs.directory);
	}
}