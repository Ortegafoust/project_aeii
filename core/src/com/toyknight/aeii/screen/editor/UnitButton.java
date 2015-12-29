package com.toyknight.aeii.screen.editor;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.toyknight.aeii.ResourceManager;
import com.toyknight.aeii.entity.Unit;
import com.toyknight.aeii.screen.MapEditorScreen;

/**
 * @author toyknight 7/9/2015.
 */
public class UnitButton extends Button {

    private final int ts;
    private final Unit unit;
    private final MapEditorScreen editor;

    public UnitButton(MapEditorScreen editor, Unit unit, int ts) {
        this.ts = ts;
        this.unit = unit;
        this.editor = editor;
        setStyle(new ButtonStyle());
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                getEditor().setSelectedUnit(UnitButton.this.unit);
            }
        });
    }

    public MapEditorScreen getEditor() {
        return editor;
    }

    @Override
    public float getPrefWidth() {
        return ts;
    }

    @Override
    public float getPrefHeight() {
        return ts;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (getEditor().getBrushType() == MapEditorScreen.TYPE_UNIT
                && getEditor().getSelectedUnit().getIndex() == unit.getIndex()) {
            batch.draw(
                    ResourceManager.getBorderLightColor(),
                    getX(), getY(), getWidth(), getHeight());
        }
        batch.draw(
                ResourceManager.getUnitTexture(editor.getSelectedTeam(), unit.getIndex(), 0, 0),
                getX(), getY(), getWidth(), getHeight());
        super.draw(batch, parentAlpha);
    }

}
