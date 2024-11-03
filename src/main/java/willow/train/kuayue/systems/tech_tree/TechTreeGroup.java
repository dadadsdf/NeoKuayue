package willow.train.kuayue.systems.tech_tree;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kasuga.lib.core.util.ComponentHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

public class TechTreeGroup {
    public final TechTree tree;

    public final String identifier;
    private final String descriptionTranslationKey, nameTranslationKey;
    private final ItemContext icon;
    private final NodeLocation root;
    private final HashMap<NodeLocation, TechTreeNode> nodes;
    public TechTreeGroup(TechTree tree, String identifier, JsonObject json) {
        this.tree = tree;
        this.identifier = identifier;
        this.nameTranslationKey = json.get("name").getAsString();
        this.descriptionTranslationKey = json.get("description").getAsString();
        this.icon = new ItemContext(new ResourceLocation(json.get("icon").getAsString()));
        this.root = new NodeLocation(this.tree.namespace, this.identifier, json.get("root").getAsString());

        nodes = new HashMap<>();
        if (!json.has("nodes") || !json.get("nodes").isJsonObject()) {
            return;
        }
        JsonObject nodesJson = json.getAsJsonObject("nodes");
        for (Map.Entry<String, JsonElement> entry : nodesJson.entrySet()) {
            TechTreeNode node = new TechTreeNode(this, entry.getKey(), entry.getValue().getAsJsonObject());
            nodes.put(node.getLocation(), node);
        }
    }

    public Component getTitle() {
        return ComponentHelper.translatable(nameTranslationKey);
    }

    public Component getDescription() {
        return ComponentHelper.translatable(descriptionTranslationKey);
    }

    public ItemStack getIcon() {
        return icon.getAsLogo();
    }

    public NodeLocation getRootLocation() {
        return root;
    }

    public TechTreeNode getNode(NodeLocation location) {
        return nodes.getOrDefault(location, null);
    }

    public boolean containsNode(NodeLocation location) {
        return getNode(location) != null;
    }
}
