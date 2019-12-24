package leetcode.algo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DesignInMemoryFileSystem {
	class FileSystem {

		Map<String, Map<String, String>> file;
		Map<String, String> directory;

		public FileSystem() {
			this.file = new TreeMap<>();
			this.directory = new TreeMap<>();
		}

		public List<String> ls(String path) {

		}

		public void mkdir(String path) {

		}

		public void addContentToFile(String filePath, String content) {

		}

		public String readContentFromFile(String filePath) {

		}
	}
}
