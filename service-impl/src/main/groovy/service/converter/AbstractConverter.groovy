package service.converter

/**
 * @author Dmitry Tsydzik
 * @since Date: 13.10.13
 */
abstract class AbstractConverter<FROM, TO> implements Converter<FROM, TO> {

    @Override
    Collection<TO> convertCollection(Collection<FROM> fromCollection) {
        fromCollection.collect { from -> convert(from) }
    }
}
