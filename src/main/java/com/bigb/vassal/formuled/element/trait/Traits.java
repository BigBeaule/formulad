package com.bigb.vassal.formuled.element.trait;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * 
 */
@RequiredArgsConstructor
public class Traits {
    private final @Getter Integer uniqueId;

    private final String pieceImage;

    private final String pieceName;

    private Trait firstTrait;

    private Trait lastTrait;

    public Traits() {
        this(null, null, null);
    }

    public Traits addTrait(Trait trait) {
        if (firstTrait == null) {
            firstTrait = trait;
            lastTrait = trait;
        } else {
            ((AbstractTrait) lastTrait).setNextTrait(trait);
            lastTrait = trait;
        }

        return this;
    }

    @JsonValue
    public String exportTraits() {
        return "+/null/" + //
                firstTrait.startExport(0) + //
                Trait.SEP + //
                exportOptions("piece", null, null, StringUtils.defaultString(pieceImage),
                        StringUtils.defaultString(pieceName) + '/'
                                + Objects.toString(firstTrait.getClosingValue(), StringUtils.EMPTY))
                + firstTrait.endExport(0) + //
                Trait.SEP + //
                exportOptions("null", 0, 0, uniqueId);

        // TODO Need to understand the purpose of those values other than ID
        // Prototype Car_2 has 284, 38 instead of 0, 0...
        // Prototype Marker has 294, 0 instead of 0, 0...
        // Prototype DashBox has 310, 23 instead of 0, 0...
    }

    static String exportOptions(Object... options) {
        return StringUtils.join(options, ';');
    }
}
