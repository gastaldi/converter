package javax.converter;

/**
 * For registering converters with a type conversion system.
 * 
 * @author George Gastaldi
 * @since 1.0
 */
public interface ConverterRegistry {

    /**
     * Add a plain converter to this registry. The convertible
     * sourceType/targetType pair is derived from the Converter's parameterized
     * types.
     * 
     * @throws IllegalArgumentException
     *             if the parameterized types could not be resolved
     */
    void addConverter(Converter<?, ?> converter);

    /**
     * Add a plain converter to this registry. The convertible
     * sourceType/targetType pair is specified explicitly. Allows for a
     * Converter to be reused for multiple distinct pairs without having to
     * create a Converter class for each pair.
     */
    void addConverter(Class<?> sourceType, Class<?> targetType, Converter<?, ?> converter);

    /**
     * Add a ranged converter factory to this registry. The convertible
     * sourceType/rangeType pair is derived from the ConverterFactory's
     * parameterized types.
     * 
     * @throws IllegalArgumentException
     *             if the parameterized types could not be resolved.
     */
    void addConverterFactory(ConverterFactory<?, ?> converterFactory);

    /**
     * Remove any converters from sourceType to targetType.
     * 
     * @param sourceType
     *            the source type
     * @param targetType
     *            the target type
     */
    void removeConvertible(Class<?> sourceType, Class<?> targetType);

}
