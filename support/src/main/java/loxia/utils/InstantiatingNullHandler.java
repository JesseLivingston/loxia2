/*
 * Copyright (c) 2002-2006 by OpenSymphony
 * All rights reserved.
 */
package loxia.utils;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ognl.NullHandler;
import ognl.Ognl;
import ognl.OgnlRuntime;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class InstantiatingNullHandler implements NullHandler {

    private static final Log LOG = LogFactory.getLog(InstantiatingNullHandler.class);
    
    @SuppressWarnings("unchecked")
	public Object nullMethodResult(Map context, Object target, String methodName, Object[] args) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Entering nullMethodResult ");
        }

        return null;
    }

    @SuppressWarnings("unchecked")
	public Object nullPropertyValue(Map context, Object target, Object property) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Entering nullPropertyValue [target="+target+", property="+property+"]");
        }
      
        if ((target == null) || (property == null)) {
            return null;
        }

        try {
            String propName = property.toString();            
            Class clazz = null;

            if (target != null) {
                PropertyDescriptor pd = OgnlRuntime.getPropertyDescriptor(target.getClass(), propName);
                if (pd == null) {
                    return null;
                }

                clazz = pd.getPropertyType();
            }

            if (clazz == null) {
                // can't do much here!
                return null;
            }

            Object param = createObject(clazz, target, propName, context);

            Ognl.setValue(propName, context, target, param);

            return param;
        } catch (Exception e) {
            LOG.error("Could not create and/or set value back on to object", e);
        }

        return null;
    }

    @SuppressWarnings("unchecked")
	private Object createObject(Class clazz, Object target, String property, Map context) throws Exception {
        if (Collection.class.isAssignableFrom(clazz)) {
            return new ArrayList();
        } else if (clazz == Map.class) {
            return new HashMap();
        }

        return clazz.newInstance();
    }
}