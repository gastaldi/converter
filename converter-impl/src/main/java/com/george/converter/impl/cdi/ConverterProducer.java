/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package com.george.converter.impl.cdi;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.converter.Converter;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import com.george.converter.impl.ConverterRegistryImpl;

public class ConverterProducer
{

   @Produces
   @Default
   @SuppressWarnings("unchecked")
   public <S, T> Converter<S, T> produceConverter(InjectionPoint injectionPoint)
   {
      ParameterizedType ptype = (ParameterizedType) injectionPoint.getType();
      Type[] actualTypeArguments = ptype.getActualTypeArguments();
      return ConverterRegistryImpl.INSTANCE.getConverter((Class<S>) actualTypeArguments[0],
               (Class<T>) actualTypeArguments[1]);
   }
}
