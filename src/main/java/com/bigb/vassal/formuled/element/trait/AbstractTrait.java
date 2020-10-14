package com.bigb.vassal.formuled.element.trait;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

/**
 * 
 */
public abstract class AbstractTrait implements Trait {
    private final Object[] options;

    private @Setter Trait nextTrait;

    /**
     * 
     */
    public AbstractTrait(Object... options) {
        this.options = options;
    }

    @Override
    public Object getClosingValue() {
        return null;
    }

    @Override
    public final String startExport(int level) {
        String export = Traits.exportOptions(options) + StringUtils.repeat('\\', level);

        if (nextTrait != null) {
            export += '\t' + nextTrait.startExport(level + 1);
        }

        return export;
    }

    @Override
    public final String endExport(int level) {
        String export = level == 0 ? StringUtils.EMPTY : Objects.toString(closeTrait(), StringUtils.EMPTY);
        export += StringUtils.repeat('\\', level);

        if (nextTrait != null) {
            export += '\t' + nextTrait.endExport(level + 1);
        }

        return export;
    }

    protected Object closeTrait() {
        return StringUtils.EMPTY;
    }

    @SuppressWarnings("unchecked")
    protected static <P> InternalTraitParameters<P> internalTraitParams(P... parameters) {
        return new InternalTraitParameters<P>(parameters);
    }

    protected static <P> InternalTraitParameters<P> internalTraitParams(List<P> parameters) {
        return new InternalTraitParameters<P>(parameters);
    }

    @RequiredArgsConstructor
    private static class InternalTraitParameters<P> {
        private final List<P> parameters;

        @SuppressWarnings("unchecked")
        public InternalTraitParameters(P... parameters) {
            this(Arrays.asList(parameters));
        }

        @Override
        public String toString() {
            if (parameters == null) {
                return StringUtils.EMPTY;
            }
            
            return parameters.stream().map(p -> p == null ? null : StringUtils.replace(p.toString(), ",", "\\,"))
                    .collect(Collectors.joining(","));
        }
    }
}
