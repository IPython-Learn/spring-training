package com.innominds.spring.scopes;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 * <p>
 * Creating custom scope in Spring
 * <ul>
 *
 * <li><b>get :</b> it returns the bean from the given scope.
 * <li><b>remove :</b> it removes an object from the scope</li>
 * <li><b>registerDestructionCallback : </b> callback method and gets invoked when the object in this scope is destroyed</li>
 * <li><b>getConversationId :he exact meaning of the conversation ID depends on the underlying storage mechanism. In the case of session-scoped objects, the
 * conversation ID would typically be equal to (or derived from) the session ID; </b></li>
 * </ul>
 *
 * </p>
 *
 *
 * @author ThirupathiReddy V
 *
 */
@SuppressWarnings("all")
public class ThreadScope implements Scope {

    private final ThreadLocal<Object> threadScope = new ThreadLocal<Object>() {
        @Override
        protected Object initialValue() {
            return new HashMap<Object, Object>();
        }
    };

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        System.err.println("get method  " + name);

        final Map<Object, Object> scope = (Map<Object, Object>) threadScope.get();
        Object object = scope.get(name);
        if (object == null) {
            object = objectFactory.getObject();
            scope.put(name, object);
        }
        return object;

    }

    @Override
    public Object remove(String name) {
        System.err.println(" remove  " + name);
        final Map scope = (Map) threadScope.get();
        return scope.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

        System.err.println(" registerDestructionCallback ");
    }

    @Override
    public Object resolveContextualObject(String key) {

        System.err.println("resolveContextualObject " + key);
        return null;
    }

    @Override
    public String getConversationId() {

        System.err.println(" getConversationId ");
        return null;
    }
}
