package willow.train.kuayue.systems.tech_tree.server;

import willow.train.kuayue.systems.tech_tree.NodeLocation;
import willow.train.kuayue.systems.tech_tree.json.TechTreeData;

import java.util.HashMap;

public class TechTree {

    public final TechTreeData data;
    private final HashMap<String, TechTreeGroup> groups;
    private final HashMap<NodeLocation, TechTreeNode> nodes;
    public TechTree(TechTreeData data) {
        this.data = data;
        this.groups = new HashMap<>();
        this.nodes = new HashMap<>();
        collectGroups();
    }

    protected void collectGroups() {
        data.getGroups().forEach((name, dat) -> {
            groups.put(name, new TechTreeGroup(this, dat));
        });
    }

    protected void compileConnections() {
        nodes.forEach((loc, node) -> {
            node.compileConnections();
        });
    }

    protected void grepNodes(HashMap<NodeLocation, TechTreeNode> grepNodes) {
        nodes.putAll(grepNodes);
    }

    public String getNamespace() {
        return data.namespace;
    }

    public HashMap<NodeLocation, TechTreeNode> getNodes() {
        return nodes;
    }

    public HashMap<String, TechTreeGroup> getGroups() {
        return groups;
    }
}
