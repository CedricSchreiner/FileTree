package interfaces;

import exceptions.NodeNotFoundException;
import java.util.Collection;
import java.util.List;

public interface TreeInterface {
    void clear();

    void addNode(NodeInterface iob_node);

    void addNodes(Collection<NodeInterface> ico_nodeCollection);

    NodeInterface getNode(int iva_key) throws NodeNotFoundException;

    NodeInterface getNode(String iva_path) throws NodeNotFoundException;

    NodeInterface getRoot();

    Collection<NodeInterface> getRootSubNodes();

    Collection<NodeInterface> getNodesByKey(Collection<Integer> ico_nodeKeys) throws NodeNotFoundException;

    Collection<NodeInterface> getNodesByPath(Collection<String> ico_nodePaths) throws NodeNotFoundException;

    Collection<NodeInterface> getAllFiles();

    Collection<NodeInterface> gettAllDirectories();

    Collection<NodeInterface> gettAll();

    void removeNode(String iva_path) throws NodeNotFoundException;

    void removeNode(int iva_key) throws NodeNotFoundException;

    void removeNode(NodeInterface iob_node) throws NodeNotFoundException;

    void removeNodes(Collection<NodeInterface> ico_nodeCollection) throws NodeNotFoundException;

    void removeNodesByKey(Collection<Integer> ico_nodeKeys) throws NodeNotFoundException;

    void removeNodesByPath(Collection<String> ico_nodePaths) throws NodeNotFoundException;

    List<NodeInterface> toList();

    NodeInterface[] toArray();

    void setNodeNotFoundExceptionStatus(boolean iva_exceptionStatus);

    boolean isExceptionActive();

    void moveNode(NodeInterface iob_node, NodeInterface iob_destinationNode);

}
