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
package edu.stanford.nlp.stats;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.stanford.nlp.math.ArrayMath;
import edu.stanford.nlp.math.SloppyMath;
import edu.stanford.nlp.util.MapFactory;
import edu.stanford.nlp.util.MutableDouble;
import edu.stanford.nlp.util.Pair;
import edu.stanford.nlp.util.StringUtils;

/**
 * A class representing a mapping between pairs of typed objects and double
 * values.
 * 
 * @author Teg Grenager
 */
public class TwoDimensionalCounter<K1, K2> implements TwoDimensionalCounterInterface<K1,K2>, Serializable {

  private static final long serialVersionUID = 1L;

  // the outermost Map
  @SuppressWarnings( { "NonSerializableFieldInSerializableClass" })
  private Map<K1, ClassicCounter<K2>> map;

  // the total of all counts
  private double total;

  // the MapFactory used to make new maps to counters
  private MapFactory<K1, ClassicCounter<K2>> outerMF;

  // the MapFactory used to make new maps in the inner counter
  private MapFactory<K2, MutableDouble> innerMF;

  private double defaultValue = 0.0;

  public void defaultReturnValue(double rv) {
    defaultValue = rv;
  }

  public double defaultReturnValue() {
    return defaultValue;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof TwoDimensionalCounter))
      return false;

    return ((TwoDimensionalCounter<?, ?>) o).map.equals(map);
  }

  @Override
  public int hashCode() {
    return map.hashCode() + 17;
  }

  /**
   * @return the inner Counter associated with key o
   */
  public ClassicCounter<K2> getCounter(K1 o) {
    ClassicCounter<K2> c = map.get(o);
    if (c == null) {
      c = new ClassicCounter<K2>(innerMF);
      c.setDefaultReturnValue(defaultValue);
      map.put(o, c);
    }
    return c;
  }

  public Set<Map.Entry<K1, ClassicCounter<K2>>> entrySet() {
    return map.entrySet();
  }

  /**
   * @return total number of entries (key pairs)
   */
  public int size() {
    int result = 0;
    for (K1 o : firstKeySet()) {
      ClassicCounter<K2> c = map.get(o);
      result += c.size();
    }
    return result;
  }

  public boolean containsKey(K1 o1, K2 o2) {
    if (!map.containsKey(o1))
      return false;
    ClassicCounter<K2> c = map.get(o1);
    return c.containsKey(o2);
  }

  /**
   */
  public void incrementCount(K1 o1, K2 o2) {
    incrementCount(o1, o2, 1.0);
  }

  /**
   */
  public void incrementCount(K1 o1, K2 o2, double count) {
    ClassicCounter<K2> c = getCounter(o1);
    c.incrementCount(o2, count);
    total += count;
  }

  /**
   */
  public void decrementCount(K1 o1, K2 o2) {
    incrementCount(o1, o2, -1.0);
  }

  /**
   */
  public void decrementCount(K1 o1, K2 o2, double count) {
    incrementCount(o1, o2, -count);
  }

  /**
   */
  public void setCount(K1 o1, K2 o2, double count) {
    ClassicCounter<K2> c = getCounter(o1);
    double oldCount = getCount(o1, o2);
    total -= oldCount;
    c.setCount(o2, count);
    total += count;
  }

  public double remove(K1 o1, K2 o2) {
    ClassicCounter<K2> c = getCounter(o1);
    double oldCount = getCount(o1, o2);
    total -= oldCount;
    c.remove(o2);
    if (c.size() == 0) {
      map.remove(o1);
    }
    return oldCount;
  }

  /**
   */
  public double getCount(K1 o1, K2 o2) {
    ClassicCounter<K2> c = getCounter(o1);
    if (c.totalCount() == 0.0 && !c.keySet().contains(o2)) {
      return defaultReturnValue();
    }
    return c.getCount(o2);
  }

  /**
   * Takes linear time.
   * 
   */
  public double totalCount() {
    return total;
  }

  /**
   */
  public double totalCount(K1 k1) {
    ClassicCounter<K2> c = getCounter(k1);
    return c.totalCount();
  }

  public Set<K1> firstKeySet() {
    return map.keySet();
  }

  /**
   * replace the counter for K1-index o by new counter c
   */
  public ClassicCounter<K2> setCounter(K1 o, Counter<K2> c) {
    ClassicCounter<K2> old = getCounter(o);
    total -= old.totalCount();
    if (c instanceof ClassicCounter) {
      map.put(o, (ClassicCounter<K2>) c);
    } else {
      map.put(o, new ClassicCounter<K2>(c));
    }
    total += c.totalCount();
    return old;
  }

  /**
   * Produces a new ConditionalCounter.
   * 
   * @return a new ConditionalCounter, where order of indices is reversed
   */
  @SuppressWarnings( { "unchecked" })
  public static <K1, K2> TwoDimensionalCounter<K2, K1> reverseIndexOrder(TwoDimensionalCounter<K1, K2> cc) {
    // they typing on the outerMF is violated a bit, but it'll work....
    TwoDimensionalCounter<K2, K1> result = new TwoDimensionalCounter<K2, K1>((MapFactory) cc.outerMF,
        (MapFactory) cc.innerMF);

    for (K1 key1 : cc.firstKeySet()) {
      ClassicCounter<K2> c = cc.getCounter(key1);
      for (K2 key2 : c.keySet()) {
        double count = c.getCount(key2);
        result.setCount(key2, key1, count);
      }
    }
    return result;
  }

  /**
   * A simple String representation of this TwoDimensionalCounter, which has the
   * String representation of each key pair on a separate line, followed by the
   * count for that pair. The items are tab separated, so the result is a
   * tab-separated value (TSV) file. Iff none of the keys contain spaces, it
   * will also be possible to treat this as whitespace separated fields.
   */
  @Override
  public String toString() {
    StringBuilder buff = new StringBuilder();
    for (K1 key1 : map.keySet()) {
      ClassicCounter<K2> c = getCounter(key1);
      for (K2 key2 : c.keySet()) {
        double score = c.getCount(key2);
        buff.append(key1).append("\t").append(key2).append("\t").append(score).append("\n");
      }
    }
    return buff.toString();
  }

  @SuppressWarnings( { "unchecked" })
  public String toMatrixString(int cellSize) {
    List<K1> firstKeys = new ArrayList<K1>(firstKeySet());
    List<K2> secondKeys = new ArrayList<K2>(secondKeySet());
    Collections.sort((List<? extends Comparable>) firstKeys);
    Collections.sort((List<? extends Comparable>) secondKeys);
    double[][] counts = toMatrix(firstKeys, secondKeys);
    return ArrayMath.toString(counts, cellSize, firstKeys.toArray(), secondKeys.toArray(), new DecimalFormat(), true);
  }

  /**
   * Given an ordering of the first (row) and second (column) keys, will produce
   * a double matrix.
   * 
   */
  public double[][] toMatrix(List<K1> firstKeys, List<K2> secondKeys) {
    double[][] counts = new double[firstKeys.size()][secondKeys.size()];
    for (int i = 0; i < firstKeys.size(); i++) {
      for (int j = 0; j < secondKeys.size(); j++) {
        counts[i][j] = getCount(firstKeys.get(i), secondKeys.get(j));
      }
    }
    return counts;
  }

  @SuppressWarnings( { "unchecked" })
  public String toCSVString(NumberFormat nf) {
    List<K1> firstKeys = new ArrayList<K1>(firstKeySet());
    List<K2> secondKeys = new ArrayList<K2>(secondKeySet());
    Collections.sort((List<? extends Comparable>) firstKeys);
    Collections.sort((List<? extends Comparable>) secondKeys);
    StringBuilder b = new StringBuilder();
    String[] headerRow = new String[secondKeys.size() + 1];
    headerRow[0] = "";
    for (int j = 0; j < secondKeys.size(); j++) {
      headerRow[j + 1] = secondKeys.get(j).toString();
    }
    b.append(StringUtils.toCSVString(headerRow)).append("\n");
    for (K1 rowLabel : firstKeys) {
      String[] row = new String[secondKeys.size() + 1];
      row[0] = rowLabel.toString();
      for (int j = 0; j < secondKeys.size(); j++) {
        K2 colLabel = secondKeys.get(j);
        row[j + 1] = nf.format(getCount(rowLabel, colLabel));
      }
      b.append(StringUtils.toCSVString(row)).append("\n");
    }
    return b.toString();
  }

  public Set<K2> secondKeySet() {
    Set<K2> result = new HashSet<K2>();
    for (K1 k1 : firstKeySet()) {
      for (K2 k2 : getCounter(k1).keySet()) {
        result.add(k2);
      }
    }
    return result;
  }

  public boolean isEmpty() {
    return map.isEmpty();
  }

  public ClassicCounter<Pair<K1, K2>> flatten() {
    ClassicCounter<Pair<K1, K2>> result = new ClassicCounter<Pair<K1, K2>>();
    result.setDefaultReturnValue(defaultValue);
    for (K1 key1 : firstKeySet()) {
      ClassicCounter<K2> inner = getCounter(key1);
      for (K2 key2 : inner.keySet()) {
        result.setCount(new Pair<K1, K2>(key1, key2), inner.getCount(key2));
      }
    }
    return result;
  }

  public void addAll(TwoDimensionalCounterInterface<K1, K2> c) {
    for (K1 key : c.firstKeySet()) {
      Counter<K2> inner = c.getCounter(key);
      ClassicCounter<K2> myInner = getCounter(key);
      Counters.addInPlace(myInner, inner);
      total += inner.totalCount();
    }
  }

  public void addAll(K1 key, Counter<K2> c) {
    ClassicCounter<K2> myInner = getCounter(key);
    Counters.addInPlace(myInner, c);
    total += c.totalCount();
  }

  public void subtractAll(K1 key, Counter<K2> c) {
    ClassicCounter<K2> myInner = getCounter(key);
    Counters.subtractInPlace(myInner, c);
    total -= c.totalCount();
  }

  public void subtractAll(TwoDimensionalCounterInterface<K1, K2> c, boolean removeKeys) {
    for (K1 key : c.firstKeySet()) {
      Counter<K2> inner = c.getCounter(key);
      ClassicCounter<K2> myInner = getCounter(key);
      Counters.subtractInPlace(myInner, inner);
      if (removeKeys)
        Counters.retainNonZeros(myInner);
      total -= inner.totalCount();
    }
  }

  /**
   * Returns the counters with keys as the first key and count as the
   * total count of the inner counter for that key
   *
   * @return counter of type K1
   */
  public Counter<K1> sumInnerCounter() {
    Counter<K1> summed = new ClassicCounter<K1>();
    for (K1 key : this.firstKeySet()) {
      summed.incrementCount(key, this.getCounter(key).totalCount());
    }
    return summed;
  }

  public void removeZeroCounts() {
    Set<K1> firstKeySet = new HashSet<K1>(firstKeySet());
    for (K1 k1 : firstKeySet) {
      ClassicCounter<K2> c = getCounter(k1);
      Counters.retainNonZeros(c);
      if (c.size() == 0)
        map.remove(k1); // it's empty, get rid of it!
    }
  }

  public void remove(K1 key) {
    ClassicCounter<K2> counter = map.get(key);
    if (counter != null) {
      total -= counter.totalCount();
    }
    map.remove(key);
  }

  public void clean() {
    for (K1 key1 : new HashSet<K1>(map.keySet())) {
      ClassicCounter<K2> c = map.get(key1);
      for (K2 key2 : new HashSet<K2>(c.keySet())) {
        if (SloppyMath.isCloseTo(0.0, c.getCount(key2))) {
          c.remove(key2);
        }
      }
      if (c.keySet().isEmpty()) {
        map.remove(key1);
      }
    }
  }

  public MapFactory<K1, ClassicCounter<K2>> getOuterMapFactory() {
    return outerMF;
  }

  public MapFactory<K2, MutableDouble> getInnerMapFactory() {
    return innerMF;
  }

  public TwoDimensionalCounter() {
    this(MapFactory.<K1, ClassicCounter<K2>> hashMapFactory(), MapFactory.<K2, MutableDouble> hashMapFactory());
  }

  public TwoDimensionalCounter(MapFactory<K1, ClassicCounter<K2>> outerFactory,
      MapFactory<K2, MutableDouble> innerFactory) {
    innerMF = innerFactory;
    outerMF = outerFactory;
    map = outerFactory.newMap();
    total = 0.0;
  }

  public static void main(String[] args) {
    TwoDimensionalCounter<String, String> cc = new TwoDimensionalCounter<String, String>();
    cc.setCount("a", "c", 1.0);
    cc.setCount("b", "c", 1.0);
    cc.setCount("a", "d", 1.0);
    cc.setCount("a", "d", -1.0);
    cc.setCount("b", "d", 1.0);
    System.out.println(cc);
    cc.incrementCount("b", "d", 1.0);
    System.out.println(cc);
    TwoDimensionalCounter<String, String> cc2 = TwoDimensionalCounter.reverseIndexOrder(cc);
    System.out.println(cc2);
  }

}
