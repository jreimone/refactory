/*
 * Javassist, a Java-bytecode translator toolkit.
 * Copyright (C) 1999-2006 Shigeru Chiba. All Rights Reserved.
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License.  Alternatively, the contents of this file may be used under
 * the terms of the GNU Lesser General Public License Version 2.1 or later.
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 */


package alice.tuprologx.pj.engine;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.security.ProtectionDomain;
import java.util.HashMap;
import java.util.WeakHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.lang.ref.WeakReference;

import javassist.CannotCompileException;
import javassist.bytecode.*;
import javassist.util.proxy.*;

/*
 * This class is impleme
 * <ul><pre>
 * ProxyFactory f = new ProxyFactory();
 * f.setSuperclass(Foo.class);
 * MethodHandler mi = new MethodHandler() {
 *     public Object invoke(Object self, Method m, Method proceed,
 *                          Object[] args) throws Throwable {
 *         System.out.println("Name: " + m.getName());
 *         return proceed.invoke(self, args);  // execute the original method.
 *     }
 * };
 * f.setFilter(new MethodFilter() {
 *     public boolean isHandled(Method m) {
 *         // ignore finalize()
 *         return !m.getName().equals("finalize");
 *     }
 * });
 * Class c = f.createClass();
 * Foo foo = (Foo)c.newInstance();
 * ((ProxyObject)foo).setHandler(mi);
 * </pre></ul>
 *
 * <p>Then, the following method call will be forwarded to MethodHandler
 * <code>mi</code> and prints a message before executing the originally called method
 * <code>bar()</code> in <code>Foo</code>.
 *
 * <ul><pre>
 * foo.bar();
 * </pre></ul>
 *
 * <p>The last three lines of the code shown above can be replaced with a call to
 * the helper method <code>create</code>, which generates a proxy class, instantiates
 * it, and sets the method handler of the instance:
 *
 * <ul><pre>
 *     :
 * Foo foo = (Foo)f.create(new Class[0], new Object[0], mi);
 * </pre></ul>
 *
 * <p>To change the method handler during runtime,
 * execute the following code:
 *
 * <ul><pre>
 * MethodHandler mi2 = ... ;    // another handler
 * ((ProxyObject)foo).setHandler(mi2);
 * </pre></ul>
 *
 * <p>You can also specify the default method handler:
 *
 * <ul><pre>
 * ProxyFactory f2 = new ProxyFactory();
 * f2.setSuperclass(Foo.class);
 * f2.setHandler(mi);            // set the default handler
 * Class c2 = f2.createClass();
 * </pre></ul>
 *
 * <p>The default handler is implicitly attached to an instance of the generated class
 * <code>c2</code>.   Calling <code>setHandler</code> on the instance is not necessary
 * unless another method handler must be attached to the instance. 
 *
 * <p>The following code is an example of method handler.  It does not execute
 * anything except invoking the original method:
 *
 * <ul><pre>
 * class SimpleHandler implements MethodHandler {
 *     public Object invoke(Object self, Method m,
 *                          Method proceed, Object[] args) throws Exception {
 *         return proceed.invoke(self, args);
 *     }
 * }
 * </pre></ul>
 *
 * <p>A proxy object generated by <code>ProxyFactory</code> is serializable
 * if its super class or interfaces implement a <code>java.io.Serializable</code>.
 * However, a serialized proxy object will not be compatible with future releases.
 * The serialization support should be used for short-term storage or RMI.
 *
 * @see MethodHandler
 * @since 3.1
 */
public class J2PProxyFactory extends ProxyFactory {
    private Class<?> superClass;
    private Class<?>[] interfaces;
    private MethodFilter methodFilter;
    private MethodHandler handler;
    private Class<?> thisClass;

    /**
	 * If the value of this variable is not null, the class file of the generated proxy class is written under the directory specified by this variable.  For example, if the value is  <code>"."</code>, then the class file is written under the current directory.  This method is for debugging. <p>The default value is null.
	 */
    public String writeDirectory;

    private static final Class<?> OBJECT_TYPE = Object.class;

    private static final String HOLDER = "_methods_";
    private static final String HOLDER_TYPE = "[Ljava/lang/reflect/Method;";
    private static final String METHOD_FILTER_FIELD = "_method_filter";
    private static final String HANDLER = "handler";
    private static final String NULL_INTERCEPTOR_HOLDER = "javassist.util.proxy.RuntimeSupport";
    private static final String DEFAULT_INTERCEPTOR = "default_interceptor";
    private static final String HANDLER_TYPE
        = 'L' + MethodHandler.class.getName().replace('.', '/') + ';';
    private static final String HANDLER_SETTER = "setHandler";
    private static final String HANDLER_SETTER_TYPE = "(" + HANDLER_TYPE + ")V";

    private static final String METACLASS_FIELD = "_meta$Prolog$Class";
    //private static final String METACLASS_TYPE = "Lalice/tuprologx/pj/meta/PrologMetaClass;";
    
    private static final String THEORY_FIELD = "_prolog$Theory";    
    
    //private static final String METACLASS_GETTER = "getMetaPrologClass";
    //private static final String METACLASS_GETTER_TYPE = "()" + METACLASS_TYPE;
    
    /**
     * If true, a generated proxy class is cached and it will be reused
     * when generating the proxy class with the same properties is requested.
     * The default value is true.
     *
     * @since 3.4
     */
    public static boolean useCache = true; 

    private static WeakHashMap<ClassLoader,Map<CacheKey,CacheKey>> proxyCache = new WeakHashMap<ClassLoader, Map<CacheKey,CacheKey>>();

    static class CacheKey {
        String classes;
        MethodFilter filter;
        private int hash;
        WeakReference<Class<?>> proxyClass;
        MethodHandler handler;

        public CacheKey(Class<?> superClass, Class<?>[] interfaces,
                        MethodFilter f, MethodHandler h)
        {
            classes = getKey(superClass, interfaces);
            hash = classes.hashCode();
            filter = f;
            handler = h;
            proxyClass = null;
        }

        public int hashCode() { return hash; }

        public boolean equals(Object obj) {
            if (obj instanceof CacheKey) {
                CacheKey target = (CacheKey)obj;
                return target.filter == filter && target.handler == handler
                       && target.classes.equals(classes);
            }
            else
                return false;
        }

        static String getKey(Class<?> superClass, Class<?>[] interfaces) {
            StringBuffer sbuf = new StringBuffer();
            if (superClass != null)
                sbuf.append(superClass.getName());
            sbuf.append(':');
            if (interfaces != null) {
                int len = interfaces.length;
                for (int i = 0; i < len; i++)
                    sbuf.append(interfaces[i].getName()).append(',');
            }

            return sbuf.toString();
        }
    }

    /**
     * Constructs a factory of proxy class.
     */
    public J2PProxyFactory() {
        superClass = null;
        interfaces = null;
        methodFilter = null;
        handler = null;
        thisClass = null;
        writeDirectory = null;
    }

    /**
     * Sets the super class of a proxy class.
     */
    public void setSuperclass(Class clazz) {
        superClass = clazz;
    }

    /**
     * Obtains the super class set by <code>setSuperclass()</code>.
     *
     * @since 3.4
     */
    public Class<?> getSuperclass() { return superClass; }

    /**
	 * Sets the interfaces of a proxy class.
	 */
    public void setInterfaces(Class[] ifs) {
        interfaces = ifs;
    }

    /**
     * Obtains the interfaces set by <code>setInterfaces</code>.
     *
     * @since 3.4
     */
    public Class<?>[] getInterfaces() { return interfaces; }

    /**
     * Sets a filter that selects the methods that will be controlled by a handler.
     */
    public void setFilter(MethodFilter mf) {
        methodFilter = mf;
    }

    /**
     * Generates a proxy class.
     */
    public Class<?> createClass() {
        if (thisClass == null) {
            ClassLoader cl = getClassLoader();
            synchronized (proxyCache) {
                if (useCache)
                    createClass2(cl);
                else 
                    createClass3(cl);
            }
        }

        return thisClass;
    }

    private void createClass2(ClassLoader cl) {
        CacheKey key = new CacheKey(superClass, interfaces, methodFilter, handler);
        /*
         * Excessive concurrency causes a large memory footprint and slows the
         * execution speed down (with JDK 1.5).  Thus, we use a jumbo lock for
         * reducing concrrency.
         */
        // synchronized (proxyCache) {
            Map<CacheKey,CacheKey> cacheForTheLoader = proxyCache.get(cl);
            if (cacheForTheLoader == null) {
                cacheForTheLoader = new HashMap<J2PProxyFactory.CacheKey, J2PProxyFactory.CacheKey>();
                proxyCache.put(cl, cacheForTheLoader);
                cacheForTheLoader.put(key, key);
            }
            else {
                CacheKey found = (CacheKey)cacheForTheLoader.get(key);
                if (found == null)
                    cacheForTheLoader.put(key, key);
                else {
                    key = found;
                    Class<?> c = isValidEntry(key);    // no need to synchronize
                    if (c != null) {
                        thisClass = c;
                        return;
                    }
                }
            }
        // }

        // synchronized (key) {
            Class<?> c = isValidEntry(key);
            if (c == null) {
                createClass3(cl);
                key.proxyClass = new WeakReference<Class<?>>(thisClass);
            }
            else
                thisClass = c; 
        // }
    }

    private Class<?> isValidEntry(CacheKey key) {
        WeakReference<Class<?>> ref = key.proxyClass;
        if (ref != null) {
            Class<?> c = ref.get();
            if(c != null)
                return c;
        }

        return null;
    }

    private void createClass3(ClassLoader cl) {
        try {
            ClassFile cf = make();
            if (writeDirectory != null)
                FactoryHelper.writeFile(cf, writeDirectory);

            thisClass = FactoryHelper.toClass(cf, cl, getDomain());
            setField(DEFAULT_INTERCEPTOR, handler);
            setField(METHOD_FILTER_FIELD, methodFilter);            
        }
        catch (CannotCompileException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

    }

    private void setField(String fieldName, Object value) {
        if (thisClass != null && value != null)
            try {
                Field f = thisClass.getField(fieldName);
                f.setAccessible(true);
                f.set(null, value);
                f.setAccessible(false);
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
    }

    static MethodFilter getFilter(Class<?> clazz) {
        return (MethodFilter)getField(clazz, METHOD_FILTER_FIELD);
    }

    static MethodHandler getHandler(Class<?> clazz) {
        return (MethodHandler)getField(clazz, DEFAULT_INTERCEPTOR);
    }

    private static Object getField(Class<?> clazz, String fieldName) {
        try {
            Field f = clazz.getField(fieldName);
            f.setAccessible(true);
            Object value = f.get(null);
            f.setAccessible(false);
            return value;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * A provider of class loaders.
     *
     * @see #classLoaderProvider
     * @since 3.4
     */
    public static interface ClassLoaderProvider {
        /**
         * Returns a class loader.
         *
         * @param pf    a proxy factory that is going to obtain a class loader.
         */
        public ClassLoader get(ProxyFactory pf);
    }

    /**
	 * A provider used by <code>createClass()</code> for obtaining a class loader. <code>get()</code> on this <code>ClassLoaderProvider</code> object is called to obtain a class loader. <p>The value of this field can be updated for changing the default implementation. <p>Example: <ul><pre> ProxyFactory.classLoaderProvider = new ProxyFactory.ClassLoaderProvider() { public ClassLoader get(ProxyFactory pf) { return Thread.currentThread().getContextClassLoader(); } }; </pre></ul>
	 * @since   3.4
	 */
    public ClassLoaderProvider classLoaderProvider
        = new ClassLoaderProvider() {
              public ClassLoader get(ProxyFactory pf) {
                  return ((J2PProxyFactory)pf).getClassLoader0();
              }
          };

    protected ClassLoader getClassLoader() {
        return classLoaderProvider.get(this);
    }

    protected ClassLoader getClassLoader0() {
        ClassLoader loader = null;
        if (superClass != null && !superClass.getName().equals("java.lang.Object"))
            loader = superClass.getClassLoader();
        else if (interfaces != null && interfaces.length > 0)
            loader = interfaces[0].getClassLoader();
 
        if (loader == null) {
            loader = getClass().getClassLoader();
             // In case javassist is in the endorsed dir
            if (loader == null) {
                loader = Thread.currentThread().getContextClassLoader();
                if (loader == null)
                    loader = ClassLoader.getSystemClassLoader();
            }
        }

        return loader;
    }

    protected ProtectionDomain getDomain() {
        Class<?> clazz;
        if (superClass != null && !superClass.getName().equals("java.lang.Object"))
            clazz = superClass;
        else if (interfaces != null && interfaces.length > 0)
            clazz = interfaces[0];
        else
            clazz = this.getClass();

        return clazz.getProtectionDomain();
    }

    /**
     * Creates a proxy class and returns an instance of that class.
     *
     * @param paramTypes    parameter types for a constructor.
     * @param args          arguments passed to a constructor.
     * @param mh            the method handler for the proxy class.
     * @since 3.4
     */
    public Object create(Class[] paramTypes, Object[] args, MethodHandler mh)
        throws NoSuchMethodException, IllegalArgumentException,
               InstantiationException, IllegalAccessException, InvocationTargetException
    {
        Object obj = create(paramTypes, args);
        ((ProxyObject)obj).setHandler(mh);
        return obj;
    }

    /**
     * Creates a proxy class and returns an instance of that class.
     *
     * @param paramTypes    parameter types for a constructor.
     * @param args          arguments passed to a constructor.
     */
    public Object create(Class[] paramTypes, Object[] args)
        throws NoSuchMethodException, IllegalArgumentException,
               InstantiationException, IllegalAccessException, InvocationTargetException
    {
        Class<?> c = createClass();
        Constructor<?> cons = c.getConstructor(paramTypes);
        return cons.newInstance(args);
    }

    /**
	 * Sets the default invocation handler.  This invocation handler is shared among all the instances of a proxy class unless another is explicitly specified.
	 */
    public void setHandler(MethodHandler mi) {
        handler = mi;
        setField(DEFAULT_INTERCEPTOR, handler);
    }

    private static int counter = 0;

    private static synchronized String makeProxyName(String classname) {
        return classname + "_$$_javassist_" + counter++;
    }

    private ClassFile make() throws CannotCompileException {
        String superName, classname;
        if (interfaces == null)
            interfaces = new Class[0];

        if (superClass == null) {
            superClass = OBJECT_TYPE;
            superName = superClass.getName();
            classname = interfaces.length == 0 ? superName
                                               : interfaces[0].getName(); 
        }
        else {
            superName = superClass.getName();
            classname = superName;
        }

        if (Modifier.isFinal(superClass.getModifiers()))
            throw new CannotCompileException(superName + " is final");

        classname = makeProxyName(classname);
        if (classname.startsWith("java."))
            classname = "org.javassist.tmp." + classname;

        ClassFile cf = new ClassFile(false, classname, superName);
        cf.setAccessFlags(AccessFlag.PUBLIC);
        setInterfaces(cf, interfaces);
        ConstPool pool = cf.getConstPool();
        FieldInfo finfo = new FieldInfo(pool, DEFAULT_INTERCEPTOR, HANDLER_TYPE);
        finfo.setAccessFlags(AccessFlag.PUBLIC | AccessFlag.STATIC);
        cf.addField(finfo);

        FieldInfo finfo2 = new FieldInfo(pool, HANDLER, HANDLER_TYPE);
        finfo2.setAccessFlags(AccessFlag.PRIVATE);
        cf.addField(finfo2);

        FieldInfo finfo3 = new FieldInfo(pool, METHOD_FILTER_FIELD,
                                            "Ljavassist/util/proxy/MethodFilter;");        
        
        finfo3.setAccessFlags(AccessFlag.PUBLIC | AccessFlag.STATIC);
        cf.addField(finfo3);
        
        FieldInfo finfo4 = new FieldInfo(pool, METACLASS_FIELD,
                                            "Lalice/tuprologx/pj/meta/PrologMetaClass;");
        
        FieldInfo finfo5 = new FieldInfo(pool, THEORY_FIELD,
                                            "Lalice/tuprologx/pj/model/Theory;");
        
        finfo4.setAccessFlags(AccessFlag.PUBLIC | AccessFlag.STATIC);
        cf.addField(finfo4);
        
        finfo5.setAccessFlags(AccessFlag.PUBLIC);
        cf.addField(finfo5);
        

        HashMap<String,Method> allMethods = getMethods(superClass, interfaces);
        //int size = allMethods.size();
        makeConstructors(classname, cf, pool, classname);
        int s = overrideMethods(cf, pool, classname, allMethods);
        addMethodsHolder(cf, pool, classname, s);
        addSetter(classname, cf, pool);
        
        //addGetter(classname, cf, pool);
        
        try {
            cf.addMethod(makeWriteReplace(pool));
        }
        catch (DuplicateMemberException e) {
            // writeReplace() is already declared in the super class/interfaces.
        }

        thisClass = null;          
        return cf;
    }

    private static void setInterfaces(ClassFile cf, Class<?>[] interfaces) {
        String setterIntf = ProxyObject.class.getName();
        String[] list;
        if (interfaces == null || interfaces.length == 0)
            list = new String[] { setterIntf };
        else {
            list = new String[interfaces.length + 1];
            for (int i = 0; i < interfaces.length; i++)
                list[i] = interfaces[i].getName();

            list[interfaces.length] = setterIntf;
        }

        cf.setInterfaces(list);
    }

    private static void addMethodsHolder(ClassFile cf, ConstPool cp,
                                         String classname, int size)
        throws CannotCompileException
    {
        FieldInfo finfo = new FieldInfo(cp, HOLDER, HOLDER_TYPE);
        finfo.setAccessFlags(AccessFlag.PRIVATE | AccessFlag.STATIC);
        cf.addField(finfo);
        MethodInfo minfo = new MethodInfo(cp, "<clinit>", "()V");
        Bytecode code = new Bytecode(cp, 0, 0);
        code.addIconst(size * 2);
        code.addAnewarray("java.lang.reflect.Method");
        code.addPutstatic(classname, HOLDER, HOLDER_TYPE);
        code.addOpcode(Bytecode.RETURN);
        minfo.setCodeAttribute(code.toCodeAttribute());
        cf.addMethod(minfo);
    }

    private static void addSetter(String classname, ClassFile cf, ConstPool cp)
        throws CannotCompileException
    {
        MethodInfo minfo = new MethodInfo(cp, HANDLER_SETTER,
                                          HANDLER_SETTER_TYPE);
        minfo.setAccessFlags(AccessFlag.PUBLIC);
        Bytecode code = new Bytecode(cp, 2, 2);
        code.addAload(0);
        code.addAload(1);
        code.addPutfield(classname, HANDLER, HANDLER_TYPE);
        code.addOpcode(Bytecode.RETURN);
        minfo.setCodeAttribute(code.toCodeAttribute());
        cf.addMethod(minfo);
    }
    /*
     * unused
     * 
    private static void addGetter(String classname, ClassFile cf, ConstPool cp)
        throws CannotCompileException
    {
        MethodInfo minfo = new MethodInfo(cp, METACLASS_GETTER,
                                          METACLASS_GETTER_TYPE);
        minfo.setAccessFlags(AccessFlag.PUBLIC);
        Bytecode code = new Bytecode(cp, 1, 1);
        code.addAload(0);
        code.addGetfield(classname,METACLASS_FIELD,METACLASS_TYPE);        
        addReturn(code, alice.tuprologx.pj.meta.PrologMetaClass.class);
        minfo.setCodeAttribute(code.toCodeAttribute());
        cf.addMethod(minfo);
    }
    */
    
    private int overrideMethods(ClassFile cf, ConstPool cp, String className,
                                HashMap<String,Method> allMethods)
        throws CannotCompileException
    {
        String prefix = makeUniqueName("_d", allMethods);
        int index = 0;
        for(Map.Entry<String,Method> e: allMethods.entrySet()){
            String key = e.getKey();
            Method meth = e.getValue();
            int mod = meth.getModifiers();
            if (!Modifier.isFinal(mod) && !Modifier.isStatic(mod)
                    && isVisible(mod, className, meth))
                if ((methodFilter == null || methodFilter.isHandled(meth)))
                    override(className, meth, prefix, index++,
                             keyToDesc(key), cf, cp);
        }

        return index;
    }

    private void override(String thisClassname, Method meth, String prefix,
                          int index, String desc, ClassFile cf, ConstPool cp)
        throws CannotCompileException
    {
        Class<?> declClass = meth.getDeclaringClass();
        String delegatorName = prefix + index + meth.getName();
        if (Modifier.isAbstract(meth.getModifiers()))
            delegatorName = null;
        else {
            MethodInfo delegator
                = makeDelegator(meth, desc, cp, declClass, delegatorName);
            // delegator is not a bridge method.  See Sec. 15.12.4.5 of JLS 3rd Ed.
            delegator.setAccessFlags(delegator.getAccessFlags() & ~AccessFlag.BRIDGE);
            cf.addMethod(delegator);
        }

        MethodInfo forwarder
            = makeForwarder(thisClassname, meth, desc, cp, declClass,
                            delegatorName, index);
        cf.addMethod(forwarder);
    }

    private void makeConstructors(String thisClassName, ClassFile cf,
            ConstPool cp, String classname) throws CannotCompileException
    {
        Constructor<?>[] cons = superClass.getDeclaredConstructors();
        for (int i = 0; i < cons.length; i++) {
            Constructor<?> c = cons[i];
            int mod = c.getModifiers();
            if (!Modifier.isFinal(mod) && !Modifier.isPrivate(mod)
                    && isVisible(mod, classname, c)) {
                MethodInfo m = makeConstructor(thisClassName, c, cp, superClass);
                cf.addMethod(m);
            }
        }
    }

    private static String makeUniqueName(String name, HashMap<String,?> hash) {
        Set<String> keys = hash.keySet();
        if (makeUniqueName0(name, keys.iterator()))
            return name;

        for (int i = 100; i < 999; i++) {
            String s = name + i;
            if (makeUniqueName0(s, keys.iterator()))
                return s;
        }

        throw new RuntimeException("cannot make a unique method name");
    }

    private static boolean makeUniqueName0(String name, Iterator<String> it) {
        while (it.hasNext()) {
            if (it.next().startsWith(name))
                return false;
        }

        return true;
    }

    /**
     * Returns true if the method is visible from the class.
     *
     * @param mod       the modifiers of the method. 
     */
    private static boolean isVisible(int mod, String from, Member meth) {
        if ((mod & Modifier.PRIVATE) != 0)
            return false;
        else if ((mod & (Modifier.PUBLIC | Modifier.PROTECTED)) != 0)
            return true;
        else {
            String p = getPackageName(from);
            String q = getPackageName(meth.getDeclaringClass().getName());
            if (p == null)
                return q == null;
            else
                return p.equals(q);
        }
    }

    private static String getPackageName(String name) {
        int i = name.lastIndexOf('.');
        if (i < 0)
            return null;
        else
            return name.substring(0, i);
    }

    private static HashMap<String,Method> getMethods(Class<?> superClass, Class<?>[] interfaceTypes) {
        HashMap<String,Method> hash = new HashMap<String, Method>();
        for (int i = 0; i < interfaceTypes.length; i++)
            getMethods(hash, interfaceTypes[i]);

        getMethods(hash, superClass);
        return hash;
    }

    private static void getMethods(HashMap<String,Method> hash, Class<?> clazz) {
        Class<?>[] ifs = clazz.getInterfaces();
        for (int i = 0; i < ifs.length; i++)
            getMethods(hash, ifs[i]);

        Class<?> parent = clazz.getSuperclass();
        if (parent != null)
            getMethods(hash, parent);

        Method[] methods = clazz.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++)
            if (!Modifier.isPrivate(methods[i].getModifiers())) {
                Method m = methods[i];
                String key = m.getName() + ':' + RuntimeSupport.makeDescriptor(m);
                hash.put(key, methods[i]);
            }
    }

    private static String keyToDesc(String key) {
        return key.substring(key.indexOf(':') + 1);
    }

    private static MethodInfo makeConstructor(String thisClassName, Constructor<?> cons,
                                              ConstPool cp, Class<?> superClass) {
        String desc = RuntimeSupport.makeDescriptor(cons.getParameterTypes(),
                                                    Void.TYPE);
        MethodInfo minfo = new MethodInfo(cp, "<init>", desc);
        minfo.setAccessFlags(Modifier.PUBLIC);      // cons.getModifiers() & ~Modifier.NATIVE
        setThrows(minfo, cp, cons.getExceptionTypes());
        Bytecode code = new Bytecode(cp, 0, 0);

        code.addAload(0);
        code.addGetstatic(thisClassName, DEFAULT_INTERCEPTOR, HANDLER_TYPE);
        code.addOpcode(Opcode.DUP);
        code.addOpcode(Opcode.IFNONNULL);
        code.addIndex(7);
        code.addOpcode(Opcode.POP);
        code.addGetstatic(NULL_INTERCEPTOR_HOLDER, DEFAULT_INTERCEPTOR, HANDLER_TYPE);
        code.addPutfield(thisClassName, HANDLER, HANDLER_TYPE);

        code.addAload(0);
        int s = addLoadParameters(code, cons.getParameterTypes(), 1);
        code.addInvokespecial(superClass.getName(), "<init>", desc);
        code.addOpcode(Opcode.RETURN);
        code.setMaxLocals(s + 1);
        minfo.setCodeAttribute(code.toCodeAttribute());
        return minfo;
    }

    private static MethodInfo makeDelegator(Method meth, String desc,
                ConstPool cp, Class<?> declClass, String delegatorName) {
        MethodInfo delegator = new MethodInfo(cp, delegatorName, desc);
        delegator.setAccessFlags(Modifier.FINAL | Modifier.PUBLIC
                | (meth.getModifiers() & ~(Modifier.PRIVATE
                                           | Modifier.PROTECTED
                                           | Modifier.ABSTRACT
                                           | Modifier.NATIVE
                                           | Modifier.SYNCHRONIZED)));
        setThrows(delegator, cp, meth);
        Bytecode code = new Bytecode(cp, 0, 0);
        code.addAload(0);
        int s = addLoadParameters(code, meth.getParameterTypes(), 1);
        code.addInvokespecial(declClass.getName(), meth.getName(), desc);
        addReturn(code, meth.getReturnType());
        code.setMaxLocals(++s);
        delegator.setCodeAttribute(code.toCodeAttribute());
        return delegator;
    }

    /**
     * @param delegatorName     null if the original method is abstract.
     */
    private static MethodInfo makeForwarder(String thisClassName,
                    Method meth, String desc, ConstPool cp,
                    Class<?> declClass, String delegatorName, int index) {
        MethodInfo forwarder = new MethodInfo(cp, meth.getName(), desc);
        forwarder.setAccessFlags(Modifier.FINAL
                    | (meth.getModifiers() & ~(Modifier.ABSTRACT
                                               | Modifier.NATIVE
                                               | Modifier.SYNCHRONIZED)));
        setThrows(forwarder, cp, meth);
        int args = Descriptor.paramSize(desc);
        Bytecode code = new Bytecode(cp, 0, args + 2);
        /*
         * if (methods[index * 2] == null) {
         *   methods[index * 2]
         *     = RuntimeSupport.findMethod(this, <overridden name>, <desc>);
         *   methods[index * 2 + 1]
         *     = RuntimeSupport.findMethod(this, <delegator name>, <desc>);
         *     or = null // the original method is abstract.
         * }
         * return ($r)handler.invoke(this, methods[index * 2],
         *                methods[index * 2 + 1], $args);
         */
        int origIndex = index * 2;
        int delIndex = index * 2 + 1;
        int arrayVar = args + 1;
        code.addGetstatic(thisClassName, HOLDER, HOLDER_TYPE);
        code.addAstore(arrayVar);
        code.addAload(arrayVar);
        code.addIconst(origIndex);
        code.addOpcode(Opcode.AALOAD);
        code.addOpcode(Opcode.IFNONNULL);
        int pc = code.currentPc();
        code.addIndex(0);

        callFindMethod(code, "findSuperMethod", arrayVar, origIndex, meth.getName(), desc);
        callFindMethod(code, "findMethod", arrayVar, delIndex, delegatorName, desc);

        code.write16bit(pc, code.currentPc() - pc + 1);
        code.addAload(0);
        code.addGetfield(thisClassName, HANDLER, HANDLER_TYPE);
        code.addAload(0);

        code.addAload(arrayVar);
        code.addIconst(origIndex);
        code.addOpcode(Opcode.AALOAD);

        code.addAload(arrayVar);
        code.addIconst(delIndex);
        code.addOpcode(Opcode.AALOAD);

        makeParameterList(code, meth.getParameterTypes());
        code.addInvokeinterface(MethodHandler.class.getName(), "invoke",
            "(Ljava/lang/Object;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;",
            5);
        Class<?> retType = meth.getReturnType();
        addUnwrapper(code, retType);
        addReturn(code, retType);

        forwarder.setCodeAttribute(code.toCodeAttribute());
        return forwarder;
    }

    private static void setThrows(MethodInfo minfo, ConstPool cp, Method orig) {
        Class<?>[] exceptions = orig.getExceptionTypes();
        setThrows(minfo, cp, exceptions);
    }

    private static void setThrows(MethodInfo minfo, ConstPool cp,
                                  Class<?>[] exceptions) {
        if (exceptions.length == 0)
            return;

        String[] list = new String[exceptions.length];
        for (int i = 0; i < exceptions.length; i++)
            list[i] = exceptions[i].getName();

        ExceptionsAttribute ea = new ExceptionsAttribute(cp);
        ea.setExceptions(list);
        minfo.setExceptionsAttribute(ea);
    }

    private static int addLoadParameters(Bytecode code, Class<?>[] params,
                                         int offset) {
        int stacksize = 0;
        int n = params.length;
        for (int i = 0; i < n; ++i)
            stacksize += addLoad(code, stacksize + offset, params[i]);

        return stacksize;
    }

    private static int addLoad(Bytecode code, int n, Class<?> type) {
        if (type.isPrimitive()) {
            if (type == Long.TYPE) {
                code.addLload(n);
                return 2;
            }
            else if (type == Float.TYPE)
                code.addFload(n);
            else if (type == Double.TYPE) {
                code.addDload(n);
                return 2;
            }
            else
                code.addIload(n);
        }
        else
            code.addAload(n);

        return 1;
    }

    private static int addReturn(Bytecode code, Class<?> type) {
        if (type.isPrimitive()) {
            if (type == Long.TYPE) {
                code.addOpcode(Opcode.LRETURN);
                return 2;
            }
            else if (type == Float.TYPE)
                code.addOpcode(Opcode.FRETURN);
            else if (type == Double.TYPE) {
                code.addOpcode(Opcode.DRETURN);
                return 2;
            }
            else if (type == Void.TYPE) {
                code.addOpcode(Opcode.RETURN);
                return 0;
            }
            else
                code.addOpcode(Opcode.IRETURN);
        }
        else
            code.addOpcode(Opcode.ARETURN);

        return 1;
    }

    private static void makeParameterList(Bytecode code, Class<?>[] params) {
        int regno = 1;
        int n = params.length;
        code.addIconst(n);
        code.addAnewarray("java/lang/Object");
        for (int i = 0; i < n; i++) {
            code.addOpcode(Opcode.DUP);
            code.addIconst(i);
            Class<?> type = params[i];
            if (type.isPrimitive())
                regno = makeWrapper(code, type, regno);
            else {
                code.addAload(regno);
                regno++;
            }

            code.addOpcode(Opcode.AASTORE);
        }
    }

    private static int makeWrapper(Bytecode code, Class<?> type, int regno) {
        int index = FactoryHelper.typeIndex(type);
        String wrapper = FactoryHelper.wrapperTypes[index]; 
        code.addNew(wrapper);
        code.addOpcode(Opcode.DUP);
        addLoad(code, regno, type);
        code.addInvokespecial(wrapper, "<init>",
                              FactoryHelper.wrapperDesc[index]);
        return regno + FactoryHelper.dataSize[index];
    }

    /**
     * @param methodName        might be null.
     */
    private static void callFindMethod(Bytecode code, String findMethod,
            int arrayVar, int index, String methodName, String desc) {
        String findClass = RuntimeSupport.class.getName();
        String findDesc
            = "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/reflect/Method;";

        code.addAload(arrayVar);
        code.addIconst(index);
        if (methodName == null)
            code.addOpcode(Opcode.ACONST_NULL);
        else {
            code.addAload(0);
            code.addLdc(methodName);
            code.addLdc(desc);
            code.addInvokestatic(findClass, findMethod, findDesc);
        }

        code.addOpcode(Opcode.AASTORE);
    }

    private static void addUnwrapper(Bytecode code, Class<?> type) {
        if (type.isPrimitive()) {
            if (type == Void.TYPE)
                code.addOpcode(Opcode.POP);
            else {
                int index = FactoryHelper.typeIndex(type);
                String wrapper = FactoryHelper.wrapperTypes[index];
                code.addCheckcast(wrapper);
                code.addInvokevirtual(wrapper,
                                      FactoryHelper.unwarpMethods[index],
                                      FactoryHelper.unwrapDesc[index]);
            }
        }
        else
            code.addCheckcast(type.getName());
    }

    private static MethodInfo makeWriteReplace(ConstPool cp) {
        MethodInfo minfo = new MethodInfo(cp, "writeReplace", "()Ljava/lang/Object;");
        String[] list = new String[1];
        list[0] = "java.io.ObjectStreamException";
        ExceptionsAttribute ea = new ExceptionsAttribute(cp);
        ea.setExceptions(list);
        minfo.setExceptionsAttribute(ea);
        Bytecode code = new Bytecode(cp, 0, 1);
        code.addAload(0);
        code.addInvokestatic("javassist.util.proxy.RuntimeSupport",
                             "makeSerializedProxy",
                             "(Ljava/lang/Object;)Ljavassist/util/proxy/SerializedProxy;");
        code.addOpcode(Opcode.ARETURN);
        minfo.setCodeAttribute(code.toCodeAttribute());
        return minfo;
    }
}
