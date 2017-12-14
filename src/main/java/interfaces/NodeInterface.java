package interfaces;

import exceptions.InvalidNodeKeyException;
import exceptions.InvalidPathException;
import exceptions.NodeNotFoundException;
import java.util.Collection;

public interface NodeInterface {

    /**
     * @return if the node is a directory it return true, otherwise false
     */
    boolean isDirectory();

    /**
     * Set the name of a node
     * @param iva_name set this as name of the node
     */
    void setName(String iva_name);

    /**
     * @return the name of the node
     */
    String getName();

    /**
     * @param iva_isDirectory set this to determine if the node is a directory (true) or a file(false)
     */
    void setDirectory(boolean iva_isDirectory);

    /**
     *
     * @param iva_key the key the node later has
     * @throws InvalidNodeKeyException key cant be negative
     */
    void setKey(int iva_key) throws InvalidNodeKeyException;

    /**
     * @return the key the node has
     */
    int getKey();

    /**
     *
     * @param iva_path the path where the file is stored
     * @throws InvalidPathException the path cant be empty
     */
    void setPath(String iva_path) throws InvalidPathException;

    /**
     * @return the path where the node is stored
     */
    String getPath();

    /**
     * @param iob_node adds this node as child of the current node
     */
    void addChild(NodeInterface iob_node);

    /**
     * @param ico_nodeCollection add all nodes as children in this collection to the current node
     */
    void addChildren(Collection<NodeInterface> ico_nodeCollection);

    /**
     * Search a child with the provided path
     * @param iva_path a child with this path
     * @return the found child with this path.
     * @throws NodeNotFoundException the current node has nod child with this path
     */
    NodeInterface getChild(String iva_path) throws NodeNotFoundException;

    /**
     * Search a child with the provided key
     * @param iva_key a child with this key
     * @return the found child with this key.
     * @throws NodeNotFoundException the current node has nod child with this key
     */
    NodeInterface getChild(int iva_key) throws NodeNotFoundException;

    /**
     * @return all children of the current node
     */
    Collection<NodeInterface> getChildren();

    /**
     *
     * @param iob_node
     * @throws NodeNotFoundException
     */
    void removeChild(NodeInterface iob_node) throws NodeNotFoundException;

    void removeChild(String iva_path) throws NodeNotFoundException;

    void removeChild(int iva_key) throws NodeNotFoundException;

    void removeChildren(Collection<String> ico_nodePaths) throws NodeNotFoundException;

    void removeChildrenByKeys(Collection<Integer> ico_nodeKeys) throws NodeNotFoundException;

    void removeAllChildren();

    void setParent(NodeInterface iob_parent);

    NodeInterface getParent();

    void setNodeNotFoundExceptionStatus(boolean iva_exceptionStatus);

    boolean isExceptionActive();

    void setSize(long iva_size);

    long getSize();

    long calculateSize();
}
