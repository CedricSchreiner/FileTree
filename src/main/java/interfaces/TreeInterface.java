package interfaces;

import exceptions.NodeNotFoundException;
import java.util.Collection;
import java.util.List;

public interface TreeInterface {
    void clear();

    boolean addNode(NodeInterface iob_node);

    boolean addNodes(Collection<NodeInterface> ico_nodeCollection);

    NodeInterface getNode(String iva_path) throws NodeNotFoundException;

    NodeInterface getRoot();

    Collection<NodeInterface> getRootSubNodes();

    Collection<NodeInterface> getNodesByPath(Collection<String> ico_nodePaths) throws NodeNotFoundException;

    Collection<NodeInterface> getAllFiles();

    Collection<NodeInterface> gettAllDirectories();

    Collection<NodeInterface> gettAll();

    boolean removeNode(String iva_path) throws NodeNotFoundException;

    boolean removeNode(NodeInterface iob_node) throws NodeNotFoundException;

    boolean removeNodes(Collection<NodeInterface> ico_nodeCollection) throws NodeNotFoundException;

    boolean removeNodesByPath(Collection<String> ico_nodePaths) throws NodeNotFoundException;

    boolean removeDirectoryOnly(NodeInterface iob_node);

    boolean removeDirectoryOnly(String iva_path);

    List<NodeInterface> toList();

    NodeInterface[] toArray();

    void setNodeNotFoundExceptionStatus(boolean iva_exceptionStatus);

    boolean isExceptionActive();

    void moveNode(NodeInterface iob_node, NodeInterface iob_destinationNode);

}
