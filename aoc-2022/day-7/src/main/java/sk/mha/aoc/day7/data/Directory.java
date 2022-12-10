package sk.mha.aoc.day7.data;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public record Directory(Directory parent, Path path, Map<String, Directory> directories, List<File> files) {
    public Directory(Path path) {
        this(null, path);
    }

    private Directory(Directory parent, Path path) {
        this(parent, path, new HashMap<>(), new LinkedList<>());
    }

    public void addDirectory(String directoryName) {
        Directory directory = new Directory(this, path.resolve(directoryName));
        directories.put(directoryName, directory);
    }

    public Directory getDirectory(String directoryName) {
        return directories.get(directoryName);
    }

    public void addFile(File file) {
        files.add(file);
    }

    public long size() {
        return directories.values().stream().mapToLong(Directory::size).sum()
            + files.stream().mapToLong(File::size).sum();
    }
}
