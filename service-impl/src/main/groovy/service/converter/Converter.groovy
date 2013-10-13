package service.converter

/**
 * @author Dmitry Tsydzik
 * @since Date: 13.10.13
 */
public interface Converter<FROM, TO> {

    TO convert(FROM from)

    List<TO> convertCollection(Collection<FROM> fromCollection)
}