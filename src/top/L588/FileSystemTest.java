package top.L588;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class FileSystemTest {

    @Test
    public void case1() {
        FileSystem fs = new FileSystem();
        Assertions.assertIterableEquals(List.of(), fs.ls("/"));
        fs.mkdir("/a/b/c");
        fs.addContentToFile("/a/b/c/d", "hello");
        Assertions.assertIterableEquals(List.of("a"), fs.ls("/"));
        Assertions.assertIterableEquals(List.of("b"), fs.ls("/a"));
        Assertions.assertIterableEquals(List.of("c"), fs.ls("/a/b"));
        Assertions.assertIterableEquals(List.of("d"), fs.ls("/a/b/c"));
        Assertions.assertEquals("hello", fs.readContentFromFile("/a/b/c/d"));
    }


}