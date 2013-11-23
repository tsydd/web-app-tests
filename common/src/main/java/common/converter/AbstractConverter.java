package common.converter;

/**
 * @author Dmitry Tsydzik
 * @since Date: 23.11.13
 */

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Dmitry Tsydzik
 * @since Date: 13.10.13
 */
public abstract class AbstractConverter<FROM, TO> implements Converter<FROM, TO> {

    @Override
    public List<TO> convertCollection(Collection<FROM> fromCollection) {
        List<TO> result = new LinkedList<>();
        for (FROM from : fromCollection) {
            result.add(convert(from));
        }
        return result;
    }
}
