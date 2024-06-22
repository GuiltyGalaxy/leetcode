package top.L588;

import java.util.*;

class FileSystem {


    MyFile root;

    public FileSystem() {
        root = new MyFile();
    }

    /**
     * 取得路徑底下所有資料夾與檔案
     */
    public List<String> ls(String path) {
        MyFile node = getNode(path);
        List<String> result = new ArrayList<>();
        if (node.isFile) {
            result.add(getFileName(path));
        } else {
            result.addAll(node.children.keySet());
        }
        Collections.sort(result);
        return result;
    }

    // 創建資料夾
    public void mkdir(String path) {
        getNode(path);
    }

    /**
     * 創建檔案並新增內文
     */
    public void addContentToFile(String filePath, String content) {
        MyFile node = getNode(filePath);
        node.isFile = true;
        node.content += content;
    }

    /**
     * 讀取檔案內文
     */
    public String readContentFromFile(String filePath) {
        MyFile node = getNode(filePath);
        return node.content;
    }

    /**
     * 取得path
     * 如果不存在就建立
     */
    private MyFile getNode(String path) {
        String[] paths = path.split("/");
        MyFile node = root;
        for (String p : paths) {
            if (p.isEmpty()) continue;
            if (!node.children.containsKey(p)) {
                node.children.put(p, new MyFile());
            }
            node = node.children.get(p);
        }
        return node;
    }

    private String getFileName(String path) {
        String[] paths = path.split("/");
        return paths[paths.length - 1];
    }

    static class MyFile {
        boolean isFile = false;
        Map<String, MyFile> children = new HashMap<>();
        String content = "";
    }
}