package models;

import exceptions.InvalidNodeKeyException;
import exceptions.InvalidPathException;
import interfaces.NodeInterface;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class NodeTest {

    @Test
    public void isDirectory() {
        NodeInterface node = new Node("node","Path");
        node.setDirectory(false);

        Assert.assertFalse(node.isDirectory());

        node.setDirectory(true);

        Assert.assertTrue(node.isDirectory());
    }

    @Test
    public void isAvailable(){

        NodeInterface node = new Node("node", "Path");

        Assert.assertFalse(node.isAvailable("Path"));
        Assert.assertTrue(node.isAvailable("PathFalse"));
    }

    @Test
    public void setKey() {
        NodeInterface node = new Node("node","Path");
        Assert.assertEquals(0, node.getKey());

        node.setKey(1);

        Assert.assertEquals(1, node.getKey());
    }

    @Test(expected = InvalidNodeKeyException.class)
    public void setInvalidKey(){
        NodeInterface node = new Node("node","Path");
        node.setKey(-1);
    }

    @Test
    public void setPath() {
        NodeInterface node = new Node("node","Path");

        Assert.assertEquals("Path", node.getPath());

        node.setPath("Test");

        Assert.assertEquals("Test", node.getPath());
    }

    @Test(expected = InvalidPathException.class)
    public void setInvalidPath() {
        NodeInterface node = new Node("node","");
    }

    @Test
    public void addChild() {
        NodeInterface node = new Node("node","Path");
        NodeInterface child = new Node ("node","Child");
        node.addChild(child);

        Assert.assertEquals(child, node.getChild("Child"));
    }

    @Test
    public void addChildren() {
        NodeInterface node = new Node("node","Path");
        NodeInterface child1 = new Node ("node","Child1");
        NodeInterface child2 = new Node ("node","Child2");
        NodeInterface child3 = new Node ("node","Child3");

        Collection<NodeInterface> collection = new ArrayList<>();
        collection.add(child1);
        collection.add(child2);
        collection.add(child3);

        node.addChildren(collection);

        Assert.assertEquals(child1, node.getChild("Child1"));
        Assert.assertEquals(child2, node.getChild("Child2"));
        Assert.assertEquals(child3, node.getChild("Child3"));
    }

    @Test
    public void getChild() {
    }

    @Test
    public void getChild1() {
    }

    @Test
    public void getChildren() {
    }

    @Test
    public void removeChild() {
    }

    @Test
    public void removeChild1() {
    }

    @Test
    public void removeChild2() {
    }

    @Test
    public void removeChildren() {
    }

    @Test
    public void removeChildrenByKeys() {
    }

    @Test
    public void removeAllChildren() {
    }

    @Test
    public void setParent() {
    }

    @Test
    public void getParent() {
    }

    @Test
    public void setNodeNotFoundExceptionStatus() {
    }

    @Test
    public void isExceptionActive() {
    }


}