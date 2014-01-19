package common.converter;

/**
 * @author Dmitry Tsydzik
 * @since Date: 23.11.13
 */

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Dmitry Tsydzik
 * @since Date: 13.10.13
 */
public abstract class AbstractConverter<FROM, TO> implements Converter<FROM, TO> {

    @Override
    public List<TO> convertCollection(Collection<? extends FROM> fromCollection) {
        return fromCollection.stream()
                .map((Function<FROM, TO>) this::convert)
                .collect(Collectors.toList());
    }
}
