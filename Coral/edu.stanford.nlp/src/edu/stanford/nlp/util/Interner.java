/*******************************************************************************
 * Copyright (C) 2012
 * The Stanford Natural Language Processing Group 
 * http://nlp.stanford.edu/
 * This Eclipse plugin matches the Stanford CoreNLP version 1.3.3
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 ******************************************************************************/
package edu.stanford.nlp.util;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;

/**
 * For interning (canonicalizing) things.
 * <p/>
 * It maps any object to a unique interned version which .equals the
 * presented object.  If presented with a new object which has no
 * previous interned version, the presented object becomes the
 * interned version.  You can tell if your object has been chosen as
 * the new unique representative by checking whether o == intern(o).
 * The interners use WeakHashMap, meaning that if the only pointers
 * to an interned item are the interners' backing maps, that item can
 * still be garbage collected.  Since the gc thread can silently
 * remove things from the backing map, there's no public way to get
 * the backing map, but feel free to add one at your own risk.
 * <p/>
 * Note that in general it is just as good or better to use the
 * static Interner.globalIntern() method rather than making an
 * instance of Interner and using the instance-level intern().
 * <p/>
 * Author: Dan Klein
 * Date: 9/28/03
 *
 * @author Dan Klein
 */
public class Interner<T> {

  protected static Interner<Object> interner = Generics.newInterner();

  /**
   * For getting the instance that global methods use.
   */
  public static Interner<Object> getGlobal() {
    return interner;
  }

  /**
   * For supplying a new instance for the global methods to use.
   * 
   * @return the previous global interner.
   */
  public static Interner<Object> setGlobal(Interner<Object> interner) {
    Interner<Object> oldInterner = Interner.interner;
    Interner.interner = interner;
    return oldInterner;
  }

  /**
   * Returns a unique object o' that .equals the argument o.  If o
   * itself is returned, this is the first request for an object
   * .equals to o.
   */
  @SuppressWarnings("unchecked")
  public static <T> T globalIntern(T o) {
    return (T) getGlobal().intern(o);
  }


  protected Map<T,WeakReference<T>> map = Generics.newWeakHashMap();

  public void clear() { map = Generics.newWeakHashMap(); }
  
  /**
   * Returns a unique object o' that .equals the argument o.  If o
   * itself is returned, this is the first request for an object
   * .equals to o.
   */
  public T intern(T o) {
    WeakReference<T> ref = map.get(o);
    if (ref == null) {
      ref = Generics.newWeakReference(o);
      map.put(o, ref);
    }
//    else {
//      System.err.println("Found dup for " + o);
//    }
    return ref.get();
  }

  /**
   * Returns a <code>Set</code> such that each element in the returned set
   * is a unique object e' that .equals the corresponding element e in the
   * original set.
   */
  public Set<T> internAll(Set<T> s) {
    Set<T> result = Generics.newHashSet();
    for (T o : s) {
      result.add(intern(o));
    }
    return result;
  }

  public int size() {
    return map.size();
  }

  /**
   * Test method: interns its arguments and says whether they == themselves.
   */
  public static void main(String[] args) {
    for (int i = 0; i < args.length; i++) {
      String str = args[i];
      System.out.println(Interner.globalIntern(str) == str);
    }
  }
}
