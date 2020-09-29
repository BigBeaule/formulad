/*
 * Copyright © 2016-2020 Dell Inc. or its subsidiaries.
 * All Rights Reserved.
 */
package com.bigb.vassal.formuled.element.trait;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import com.bigb.vassal.formuled.element.Expression;
import com.bigb.vassal.formuled.element.HotKey;
import com.bigb.vassal.formuled.element.PositionnedElement.Position;

/**
 * 
 */
public class Layer extends AbstractTrait {
    private final String closingValue;

    private Layer(String closingValue, Object... options) {
        super(options);
        this.closingValue = closingValue;
    }

    @Override
    protected Object closeTrait() {
        return closingValue;
    }

    @RequiredArgsConstructor
    public static final class LayerBuilder {
        private final String name;
        private Integer resetToLevel;
        private Position offset = new Position(0, 0);

        private boolean loopLevel;
        private boolean underneathWhenHighlighted;

        private Expression expression;
        private Integer level1ExpressionValue;

        private HotKey[] actionHotKeys = new HotKey[5];
        private String[] actionMenuCommands = new String[5];

        private List<String> images = new ArrayList<>();
        private List<String> levelNames = new ArrayList<>();

        public LayerBuilder underneathWhenHighlighted() {
            this.underneathWhenHighlighted = true;
            return this;
        }

        public LayerBuilder offset(int x, int y) {
            this.offset = new Position(x, y);
            return this;
        }

        public LayerBuilder activateLayer(String menuCommand, HotKey hotKey) {
            this.actionMenuCommands[ACTION_ACTIVATE] = menuCommand;
            this.actionHotKeys[ACTION_ACTIVATE] = hotKey;
            return this;
        }

        public LayerBuilder increaseLevel(String menuCommand, HotKey hotKey) {
            this.actionMenuCommands[ACTION_INCREASE] = menuCommand;
            this.actionHotKeys[ACTION_INCREASE] = hotKey;
            return this;
        }

        public LayerBuilder decreaseLevel(String menuCommand, HotKey hotKey) {
            this.actionMenuCommands[ACTION_DECREASE] = menuCommand;
            this.actionHotKeys[ACTION_DECREASE] = hotKey;
            return this;
        }

        public LayerBuilder resetLevel(String menuCommand, HotKey hotKey, int resetToLevel) {
            this.actionMenuCommands[ACTION_RESET] = menuCommand;
            this.actionHotKeys[ACTION_RESET] = hotKey;
            this.resetToLevel = resetToLevel;
            return this;
        }

        public LayerBuilder randomizeLevel(String menuCommand, HotKey hotKey) {
            this.actionMenuCommands[ACTION_RANDOM] = menuCommand;
            this.actionHotKeys[ACTION_RANDOM] = hotKey;
            return this;
        }

        public LayerBuilder addLevel(String image) {
            this.levelNames.add(null);
            this.images.add(image);
            return this;
        }

        public LayerBuilder addLevel(String image, String levelName, boolean isPrefix) {
            this.levelNames.add(isPrefix ? ("+" + levelName) : (levelName + "+"));
            this.images.add(image);
            return this;
        }

        public LayerBuilder loopLevel() {
            this.loopLevel = true;
            return this;
        }

        public LayerBuilder followExpression(Expression expression, int level1Value) {
            this.level1ExpressionValue = level1Value;
            this.expression = expression;
            return this;
        }

        public Layer build(Integer closingValue) {
            // Still don't know what the magic number is used for. Seen a 2 and 128...
            int magicNumber = 2;

            String closing =
                    closingValue == null ? null : Traits.exportOptions(closingValue, closingValue, closingValue, false);

            return new Layer( //
                    closing, //
                    "emb2", //
                    actionMenuCommands[ACTION_ACTIVATE], //
                    magicNumber, //
                    null, //
                    actionMenuCommands[ACTION_INCREASE], //
                    magicNumber, //
                    null, //
                    actionMenuCommands[ACTION_DECREASE], //
                    magicNumber, //
                    null, //
                    actionMenuCommands[ACTION_RESET], //
                    actionHotKeys[ACTION_RESET], //
                    resetToLevel, //
                    underneathWhenHighlighted, //
                    offset == null ? null : offset.getX(), //
                    offset == null ? null : offset.getY(), //
                    StringUtils.join(images, ','), //
                    StringUtils.join(levelNames, ','), //
                    loopLevel, //
                    name, //
                    actionHotKeys[ACTION_RANDOM], //
                    actionMenuCommands[ACTION_RANDOM], //
                    expression != null, //
                    expression, //
                    level1ExpressionValue, //
                    1, //
                    actionHotKeys[ACTION_ACTIVATE] == null, //
                    actionHotKeys[ACTION_ACTIVATE], //
                    actionHotKeys[ACTION_INCREASE], //
                    actionHotKeys[ACTION_DECREASE]);
        }
    }

    private static final int ACTION_ACTIVATE = 0;
    private static final int ACTION_INCREASE = 1;
    private static final int ACTION_DECREASE = 2;
    private static final int ACTION_RESET = 3;
    private static final int ACTION_RANDOM = 4;
}
