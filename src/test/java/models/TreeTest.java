package models;

import interfaces.NodeInterface;
import interfaces.TreeInterface;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

public class TreeTest {

    private TreeInterface tree = new Tree();

    @Test
    public void clear() {
    }

    @Test
    public void addNode() {
        NodeInterface firstLayerTextFile = new Node("", "C:\\Users\\Darth-Vader\\Documents\\Fileserver\\root\\TestTextDatei.txt");
        NodeInterface firstLayerDirectory = new Node("","C:\\Users\\Darth-Vader\\Documents\\Fileserver\\root\\parentDirectory");
        firstLayerDirectory.setDirectory(true);
        NodeInterface secondLayerTextFile = new Node("","C:\\Users\\Darth-Vader\\Documents\\Fileserver\\root\\parentDirectory\\childFile.txt");
        NodeInterface secondLayerDirectory = new Node("","C:\\Users\\Darth-Vader\\Documents\\Fileserver\\root\\parentDirectory\\SecondParentDirectory");
        secondLayerDirectory.setDirectory(true);
        NodeInterface thirdLayerTextFile = new Node("", "C:\\Users\\Darth-Vader\\Documents\\Fileserver\\root\\parentDirectory\\SecondParentDirectory\\ThirdFile.txt");

        /*
         *  root
         *    |-firstLayerTextFile
         */
        tree.addNode(firstLayerTextFile);
        Assert.assertEquals(firstLayerTextFile, tree.getRoot().getChild(firstLayerTextFile.getPath()));

        /*
         *  root
         *    |-firstLayerTextFile
         *    |-firstLayerDirectory
         */
        tree.addNode(firstLayerDirectory);
        Assert.assertEquals(firstLayerDirectory, tree.getRoot().getChild(firstLayerDirectory.getPath()));

        /*
         *  root
         *    |-firstLayerTextFile
         *    |-firstLayerDirectory
         *              |-secondLayerTextFile
         */
        tree.addNode(secondLayerTextFile);
        Assert.assertEquals(secondLayerTextFile, firstLayerDirectory.getChild(secondLayerTextFile.getPath()));

        /*
         *  root
         *    |-firstLayerTextFile
         *    |-firstLayerDirectory
         *              |-secondLayerTextFile
         *              |-secondLayerDirectory
         */
        tree.addNode(secondLayerDirectory);
        Assert.assertEquals(secondLayerDirectory, firstLayerDirectory.getChild(secondLayerDirectory.getPath()));

        tree.addNode(thirdLayerTextFile);

        Assert.assertEquals(firstLayerDirectory, tree.getNode(firstLayerDirectory.getPath()));
        Assert.assertEquals(firstLayerTextFile, tree.getNode(firstLayerTextFile.getPath()));
        Assert.assertEquals(secondLayerDirectory, tree.getNode(secondLayerDirectory.getPath()));
        Assert.assertEquals(secondLayerTextFile, tree.getNode(secondLayerTextFile.getPath()));
        Assert.assertEquals(thirdLayerTextFile, tree.getNode(thirdLayerTextFile.getPath()));

        tree.removeDirectoryOnly(firstLayerDirectory);

        //clear the tree
        tree.clear();
        tree.addNode(thirdLayerTextFile);

        tree.addNode(secondLayerDirectory);
//        /*
//         *  root
//         *    |-firstLayerDirectory <-- this folder is not inserted yes, so it has to be auto generated
//         *              |-secondLayerTextFile
//         */
//        tree.addNode(secondLayerTextFile);
//        Assert.assertEquals("C:\\Users\\Cedric\\Documents\\BaseDirectory\\testDirectory", tree.getRoot().getChild("C:\\Users\\Cedric\\Documents\\BaseDirectory\\testDirectory").getPath());
//        Assert.assertEquals(secondLayerTextFile, tree.getRoot().getChild("C:\\Users\\Cedric\\Documents\\BaseDirectory\\testDirectory").getChild(secondLayerTextFile.getKey()));
//
//        /*
//         *  root
//         *    |-firstLayerDirectory
//         *              |-secondLayerTextFile
//         *              |-secondLayerDirectory
//         */
//        tree.addNode(secondLayerDirectory);
//        Assert.assertEquals(secondLayerDirectory, tree.getRoot().getChild(secondLayerDirectory.getKey()));
//
//        /*
//         *  root
//         *    |-firstLayerDirectory <- gets ignored
//         *              |-secondLayerTextFile
//         *              |-secondLayerDirectory
//         */
//        tree.addNode(firstLayerDirectory);
//        Assert.assertEquals(firstLayerDirectory, tree.getRoot().getChild(firstLayerDirectory.getKey()));
//        Assert.assertEquals(1, tree.getRoot().getChildren().size());
//        Assert.assertEquals(secondLayerTextFile, firstLayerDirectory.getChild(secondLayerTextFile.getKey()));
//        Assert.assertEquals(secondLayerDirectory, firstLayerDirectory.getChild(secondLayerDirectory.getKey()));
    }

    @Test
    public void compareTrees() {
        TreeInterface tree = new Tree();
        TreeInterface tree2 = new Tree();
        TreeDifference difference = new TreeDifference();

        NodeInterface node1 = new Node("node1", "C:\\Users\\Darth-Vader\\Documents\\Fileserver\\root\\TextFile.txt", false, 2);
        NodeInterface node2 = new Node("node2", "C:\\Users\\Darth-Vader\\Documents\\Fileserver\\root\\Directory", true, 0);
        NodeInterface node3 = new Node("node3", "C:\\Users\\Darth-Vader\\Documents\\Fileserver\\root\\Directory\\AnotherTextFile", false, 100);
        NodeInterface node4 = new Node("node4", "C:\\Users\\Darth-Vader\\Documents\\Fileserver\\root\\Dir", true, 0);
        NodeInterface node5 = new Node("node5", "C:\\Users\\Darth-Vader\\Documents\\Fileserver\\root\\Dir\\text.txt", false, 30);
        NodeInterface node6 = new Node("node6", "C:\\Users\\Darth-Vader\\Documents\\Fileserver\\root\\testText.txt", false, 19);
        NodeInterface node7 = new Node("node7", "C:\\Users\\Darth-Vader\\Documents\\Fileserver\\root\\testPDF.pdf", false, 1367);
        NodeInterface node8 = new Node("node8", "C:\\Users\\Darth-Vader\\Documents\\Fileserver\\root\\Directory\\DIR", true, 0);
        tree.addNode(node1);
        tree.addNode(node2);
        tree.addNode(node3);
        tree.addNode(node4);
        tree.addNode(node5);
        tree.addNode(node6);
        tree.addNode(node7);
        tree.addNode(node8);

        NodeInterface node11 = new Node("ndoe11", "C:\\Users\\Darth-Vader\\Documents\\Fileserver\\root\\TextFile.txt", false, 3);
        NodeInterface node12 = new Node("node12", "C:\\Users\\Darth-Vader\\Documents\\Fileserver\\root\\Directory", true, 0);
        NodeInterface node13 = new Node("node13", "C:\\Users\\Darth-Vader\\Documents\\Fileserver\\root\\Directory\\RenamedTextFile", false, 100);
        NodeInterface node14 = new Node("node14", "C:\\Users\\Darth-Vader\\Documents\\Fileserver\\root\\Dir");

        tree2.addNode(node11);
        tree2.addNode(node12);
        tree2.addNode(node13);
        tree2.addNode(node14);


        difference = tree.compareTrees(tree2);
    }

    @Test
    public void getNode() {
    }

    @Test
    public void getNode1() {
    }

    @Test
    public void getRoot() {
    }

    @Test
    public void getRootSubNodes() {
    }

    @Test
    public void getNodesByKey() {
    }

    @Test
    public void getNodesByPath() {
    }

    @Test
    public void getAllFiles() {
    }

    @Test
    public void gettAllDirectories() {
    }

    @Test
    public void gettAll() {
    }

    @Test
    public void removeNode() {
    }

    @Test
    public void removeNode1() {
    }

    @Test
    public void removeNode2() {
    }

    @Test
    public void removeNodes() {
    }

    @Test
    public void removeNodesByKey() {
    }

    @Test
    public void removeNodesByPath() {
    }

    @Test
    public void toList() {
    }

    @Test
    public void toArray() {
    }

    @Test
    public void setNodeNotFoundExceptionStatus() {
    }

    @Test
    public void isExceptionActive() {
    }
}