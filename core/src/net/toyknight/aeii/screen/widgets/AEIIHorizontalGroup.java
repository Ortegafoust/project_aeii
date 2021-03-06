package net.toyknight.aeii.screen.widgets;

import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import net.toyknight.aeii.GameContext;
import net.toyknight.aeii.ResourceManager;

/**
 * @author by toyknight 7/8/2016.
 */
public class AEIIHorizontalGroup extends HorizontalGroup {

    protected final int ts;

    private final GameContext context;

    public AEIIHorizontalGroup(GameContext context) {
        this.context = context;
        this.ts = context.getTileSize();
    }

    public GameContext getContext() {
        return context;
    }

    public ResourceManager getResources() {
        return getContext().getResources();
    }

}
