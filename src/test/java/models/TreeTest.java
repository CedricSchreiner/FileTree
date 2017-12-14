package models;

import interfaces.NodeInterface;
import interfaces.TreeInterface;
import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertEquals(firstLayerTextFile, tree.getRoot().getChild(firstLayerTextFile.getKey()));

        /*
         *  root
         *    |-firstLayerTextFile
         *    |-firstLayerDirectory
         */
        tree.addNode(firstLayerDirectory);
        Assert.assertEquals(firstLayerDirectory, tree.getRoot().getChild(firstLayerDirectory.getKey()));

        /*
         *  root
         *    |-firstLayerTextFile
         *    |-firstLayerDirectory
         *              |-secondLayerTextFile
         */
        tree.addNode(secondLayerTextFile);
        Assert.assertEquals(secondLayerTextFile, firstLayerDirectory.getChild(secondLayerTextFile.getKey()));

        /*
         *  root
         *    |-firstLayerTextFile
         *    |-firstLayerDirectory
         *              |-secondLayerTextFile
         *              |-secondLayerDirectory
         */
        tree.addNode(secondLayerDirectory);
        Assert.assertEquals(secondLayerDirectory, firstLayerDirectory.getChild(secondLayerDirectory.getKey()));



        //clear the tree
        tree.clear();
        tree.addNode(thirdLayerTextFile);
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
//         *    |-firstLayerDirectory <- gets updated
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
    public void addNodes() {
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