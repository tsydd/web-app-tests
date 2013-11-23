package common.converter;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author Dmitry Tsydzik
 * @since Date: 23.11.13
 */
public class ReflectionConverter<FROM, TO> extends AbstractConverter<FROM, TO> {

    @SuppressWarnings("UnusedDeclaration")
    private Class<FROM> fromClass;
    private Class<TO> toClass;

    @SuppressWarnings("unchecked")
    protected ReflectionConverter() {
        Type[] types = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
        fromClass = (Class<FROM>) types[0];
        toClass = (Class<TO>) types[1];
    }

    public ReflectionConverter(Class<FROM> fromClass, Class<TO> toClass) {
        this.fromClass = fromClass;
        this.toClass = toClass;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TO convert(FROM from) {
        try {
            TO to = toClass.newInstance();
            BeanUtils.copyProperties(to, from);
            return to;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new UnsupportedOperationException("unable to convert bean", e);
        }
    }
}
