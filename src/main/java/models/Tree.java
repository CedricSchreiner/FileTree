package models;

import exceptions.NodeNotFoundException;
import interfaces.NodeInterface;
import interfaces.TreeInterface;

import java.util.Collection;
import java.util.List;

public class Tree implements TreeInterface {

    private static final String BASE_DIRECTORY = "C:\\\\Users\\\\Cedric\\\\Documents\\\\";
    private static final String GC_ROOT_PATH = "C:\\Users\\Cedric\\Documents\\BaseDirectory";
    private static final int GC_ROOT_KEY = 0;
    private static final String GC_ROOT_NAME = "<ROOT>";

    private NodeInterface gob_root;
    private int gva_nodeKey;
    private boolean gva_nodeNotFoundExceptionStatus;

    public Tree() {
        this.gva_nodeKey = 1;
        this.gob_root = new Node(GC_ROOT_KEY, GC_ROOT_NAME, GC_ROOT_PATH, false, 0);
        this.gva_nodeNotFoundExceptionStatus = true;
    }

    @Override
    public void clear() {
        //this.gco_treeAsList.clear();
        this.gob_root.removeAllChildren();
        this.gva_nodeKey = 1;
    }

    @Override
    public void addNode(NodeInterface iob_node) {
        //---------------Variables---------------
        NodeInterface lob_parent;
        //---------------------------------------

        setNodeKey(iob_node);

        lob_parent = addNodeRekursiv(gob_root, iob_node, 0);

        //set the parent of the new node
        iob_node.setParent(lob_parent);

        //add the new node as child to his parent
        lob_parent.addChild(iob_node);
    }

    @Override
    public void addNodes(Collection<NodeInterface> ico_nodeCollection) {
        for (NodeInterface lob_node : ico_nodeCollection) {
            addNode(lob_node);
        }
    }

    @Override
    public NodeInterface getNode(int iva_key) throws NodeNotFoundException {
        return null;
    }

    @Override
    public NodeInterface getNode(String iva_path) throws NodeNotFoundException {
        return null;
    }

    @Override
    public NodeInterface getRoot() {
        return this.gob_root;
    }

    @Override
    public Collection<NodeInterface> getRootSubNodes() {
        return this.gob_root.getChildren();
    }

    @Override
    public Collection<NodeInterface> getNodesByKey(Collection<Integer> ico_nodeKeys) throws NodeNotFoundException {
        return null;
    }

    @Override
    public Collection<NodeInterface> getNodesByPath(Collection<String> ico_nodePaths) throws NodeNotFoundException {
        return null;
    }

    @Override
    public Collection<NodeInterface> getAllFiles() {
        return null;
    }

    @Override
    public Collection<NodeInterface> gettAllDirectories() {
        return null;
    }

    @Override
    public Collection<NodeInterface> gettAll() {
        return null;
    }

    @Override
    public void removeNode(String iva_path) throws NodeNotFoundException {

    }

    @Override
    public void removeNode(int iva_key) throws NodeNotFoundException {

    }

    @Override
    public void removeNode(NodeInterface iob_node) throws NodeNotFoundException {

    }

    @Override
    public void removeNodes(Collection<NodeInterface> ico_nodeCollection) throws NodeNotFoundException {

    }

    @Override
    public void removeNodesByKey(Collection<Integer> ico_nodeKeys) throws NodeNotFoundException {

    }

    @Override
    public void removeNodesByPath(Collection<String> ico_nodePaths) throws NodeNotFoundException {

    }

    @Override
    public List<NodeInterface> toList() {
        //return (List<NodeInterface>) this.gco_treeAsList;
        return null;
    }

    @Override
    public NodeInterface[] toArray() {
        return null;
    }

    @Override
    public void setNodeNotFoundExceptionStatus(boolean iva_exceptionStatus) {
        this.gva_nodeNotFoundExceptionStatus = iva_exceptionStatus;
    }

    @Override
    public boolean isExceptionActive() {
        return gva_nodeNotFoundExceptionStatus;
    }

    @Override
    public void moveNode(NodeInterface iob_node, NodeInterface iob_destinationNode) {

    }

    private void setNodeKey(NodeInterface iob_node) {
        iob_node.setKey(this.gva_nodeKey);
        this.gva_nodeKey++;
    }

    private NodeInterface addNodeRekursiv(NodeInterface iob_parent, NodeInterface iob_nodeToInsert, int depth) {
        //------------------------------------Variables---------------------------------------------------------
        String[] lar_childNodePath;
        String[] lar_parentNodePath;
        String[] lar_nodeToInsertPath = convertPathToArray(iob_nodeToInsert.getPath());
        NodeInterface lob_newDirectory;
        StringBuilder lob_newDirectoryPath = new StringBuilder(GC_ROOT_PATH + "\\");
        int lva_loopCounter;
        //------------------------------------------------------------------------------------------------------

        //loop over all children of the current parent node
        for (NodeInterface lob_childNode : iob_parent.getChildren()) {
            if (lob_childNode.isDirectory()) {
                lar_childNodePath = convertPathToArray(lob_childNode.getPath());
                if (lar_nodeToInsertPath[depth].equals(lar_childNodePath[depth])) {
                    return addNodeRekursiv(lob_childNode, iob_nodeToInsert, ++depth);
                }
            }
        }

        lar_parentNodePath = convertPathToArray(iob_parent.getPath());

        //the parent directory of the file that we want to insert does not exist yet
        if (lar_nodeToInsertPath.length > (lar_parentNodePath.length + 1)) {
            lva_loopCounter = 1;
            //build the path for the parent directory
            do {
                lob_newDirectoryPath.append(lar_nodeToInsertPath[lva_loopCounter]).append("\\");
                lva_loopCounter++;
            } while (lva_loopCounter < depth + 2);
            //remove the last '\' from the directory path
            lob_newDirectoryPath.delete(lob_newDirectoryPath.lastIndexOf("\\"), lob_newDirectoryPath.length());
            //create the new directory
            lob_newDirectory = createNewDirectory(lob_newDirectoryPath.toString());
            setNodeKey(lob_newDirectory);
            //set the current node as parent for the new directory
            lob_newDirectory.setParent(iob_parent);
            //add the new directory as child to the current node
            iob_parent.addChild(lob_newDirectory);
            return addNodeRekursiv(lob_newDirectory, iob_nodeToInsert, ++depth);
        }

        return iob_parent;
    }

    private String removeBasePath(String iva_path) {
        return iva_path.replaceFirst(BASE_DIRECTORY, "");
    }

    private String[] convertPathToArray(String iva_path) {
        iva_path = removeBasePath(iva_path);
        return iva_path.split("\\\\");
    }

    private NodeInterface createNewDirectory(String iva_path) {
        //-------------------Variables-------------------------
        String[] lva_directoryPath = convertPathToArray(iva_path);
        String lva_directoryName = lva_directoryPath[lva_directoryPath.length - 1];
        //-----------------------------------------------------
        NodeInterface rob_directory = new Node(lva_directoryName, iva_path);
        rob_directory.setDirectory(true);
        return rob_directory;
    }
}
