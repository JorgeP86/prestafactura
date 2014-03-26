package com.prestafacturaService.mongo.util;

import java.lang.reflect.Field;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mapping.model.MappingException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.util.ReflectionUtils;

public class CascadingMongoEventListener extends AbstractMongoEventListener<Object> {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void onBeforeConvert(final Object source) {
        ReflectionUtils.doWithFields(source.getClass(), new ReflectionUtils.FieldCallback() {
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                ReflectionUtils.makeAccessible(field);

                if (field.isAnnotationPresent(DBRef.class) && field.isAnnotationPresent(CascadeSave.class)) {
                	final Object fieldValue = field.get(source);
                	if (fieldValue != null) {
                		
                		Class<?> fieldClass = fieldValue.getClass();
                		if (Collection.class.isAssignableFrom(field.getType())) {
                			fieldClass = getParameterType(field);
                		}

                		DbRefFieldCallback callback = new DbRefFieldCallback();

                		ReflectionUtils.doWithFields(fieldClass, callback);

                		if (!callback.isIdFound()) {
                			throw new MappingException("Cannot perform cascade save on child object without id set");
                		}
                		if (Collection.class.isAssignableFrom(field.getType())) {
                			@SuppressWarnings("unchecked")
                			Collection<Object> models = (Collection<Object>) fieldValue;
                			for (Object model : models) {
                				mongoTemplate.save(model);
                			}
                		} else {
                			mongoTemplate.save(fieldValue);
                		}
                	}
                }
            }

			private Class<?> getParameterType(Field field) {
				// TODO Auto-generated method stub
				return field.getType();
			}
        });
    }

    /**
     * *
     * if (field.isAnnotationPresent(DBRef.class) &&
     * field.isAnnotationPresent(CascadeSave.class)) { final Object fieldValue =
     * field.get(source); if (fieldValue != null) { Class fieldClass =
     * fieldValue.getClass(); if
     * (Collection.class.isAssignableFrom(field.getType())) { fieldClass =
     * getParameterType(field); }
     *
     * DbRefFieldCallback callback = new DbRefFieldCallback();
     *
     * ReflectionUtils.doWithFields(fieldClass, callback);
     *
     * if (!callback.isIdFound()) { throw new MappingException("Cannot perform
     * cascade save on child object without id set"); }
     *
     * if (Collection.class.isAssignableFrom(field.getType())) {
     *
     * @SuppressWarnings("unchecked") Collection<object> models =
     * (Collection<object>) fieldValue; for (Object model : models) {
     * mongoOperations.save(model); } } else { mongoOperations.save(fieldValue);
     * } } }
     */
    private static class DbRefFieldCallback implements ReflectionUtils.FieldCallback {

        private boolean idFound;

        public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
            ReflectionUtils.makeAccessible(field);

            if (field.isAnnotationPresent(Id.class)) {
                idFound = true;
            }
        }

        public boolean isIdFound() {
            return idFound;
        }
    }
}

