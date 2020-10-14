package com.bigb.vassal.formuled.element.trait;

import java.util.List;

import com.bigb.vassal.formuled.element.Expression;
import com.bigb.vassal.formuled.element.HotKey;

import lombok.NonNull;

/**
 * 
 */
public class TriggerAction extends AbstractTrait {
    public TriggerAction(@NonNull String description, String menuCommand, HotKey keyboardCommand, Expression trigger,
            List<HotKey> watchFor, List<HotKey> actions) {

        this(description, menuCommand, keyboardCommand, trigger, watchFor, actions, null, null, null, "counted", null,
                1, 1);
    }

    public TriggerAction(@NonNull String description, String menuCommand, HotKey keyboardCommand, Expression trigger,
            List<HotKey> watchFor, List<HotKey> actions, int loopCount, HotKey loopStart, HotKey loopEnd) {

        this(description, menuCommand, keyboardCommand, trigger, watchFor, actions, loopCount, loopStart, loopEnd, null,
                1, 1);
    }

    public TriggerAction(@NonNull String description, String menuCommand, HotKey keyboardCommand, Expression trigger,
            List<HotKey> watchFor, List<HotKey> actions, int loopCount, HotKey loopStart, HotKey loopEnd,
            String indexName, int indexStart, int indexEnd) {

        this(description, menuCommand, keyboardCommand, trigger, watchFor, actions, loopCount, loopStart, loopEnd,
                "counted", indexName, indexStart, indexEnd);
    }

    private TriggerAction(@NonNull String description, String menuCommand, HotKey keyboardCommand, Expression trigger,
            List<HotKey> watchFor, List<HotKey> actions, Integer loopCount, HotKey loopStart, HotKey loopEnd,
            String loopType, String indexName, int indexStart, int indexEnd) {

        super("macro", description, menuCommand, keyboardCommand, trigger, internalTraitParams(watchFor),
                internalTraitParams(actions), loopCount != null, loopStart, loopEnd, loopType, null, null, loopCount,
                indexName != null, indexName, indexStart, indexEnd);
    }
}
