package common.converter;

import java.util.Collection;
import java.util.List;

/**
 * @author Dmitry Tsydzik
 * @since Date: 23.11.13
 */
public interface Converter<FROM, TO> {

    TO convert(FROM from);

    List<TO> convertCollection(Collection<FROM> fromCollection);
}
