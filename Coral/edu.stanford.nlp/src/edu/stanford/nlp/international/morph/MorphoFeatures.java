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
package edu.stanford.nlp.international.morph;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.stanford.nlp.international.morph.MorphoFeatureSpecification.MorphoFeatureType;

/**
 * Holds a set of morphosyntactic features for a given surface form.
 * 
 * @author Spence Green
 *
 */
public class MorphoFeatures implements Serializable {
  
  private static final long serialVersionUID = -3893316324305154940L;

  public static final String KEY_VAL_DELIM = ":";
  
  protected final Map<MorphoFeatureType,String> fSpec;
  protected String altTag;
  
  public MorphoFeatures() {
    fSpec = new HashMap<MorphoFeatureType,String>();
  }
  
  public MorphoFeatures(MorphoFeatures other) {
    this();
    for(Map.Entry<MorphoFeatureType, String> entry : other.fSpec.entrySet())
      this.fSpec.put(entry.getKey(), entry.getValue());
    this.altTag = other.altTag;
  }
  
  public void addFeature(MorphoFeatureType feat, String val) {
    fSpec.put(feat, val);
  }
  
  public boolean hasFeature(MorphoFeatureType feat) {
    return fSpec.containsKey(feat);
  }
  
  public String getValue(MorphoFeatureType feat) {
    return hasFeature(feat) ? fSpec.get(feat) : "";
  }
  
  public int numFeatureMatches(MorphoFeatures other) {
    int nMatches = 0;
    for(Map.Entry<MorphoFeatureType, String> fPair : fSpec.entrySet()) {
      if(other.hasFeature(fPair.getKey()) && other.getValue(fPair.getKey()).equals(fPair.getValue()))
        nMatches++;
    }
    
    return nMatches;
  }
  
  public int numActiveFeatures() { return fSpec.keySet().size(); }
  
  /**
   * Build a POS tag consisting of a base category plus inflectional features.
   * 
   * @param baseTag
   * @return the tag
   */
  public String getTag(String baseTag) {
    return baseTag + toString();
  }
  
  public void setAltTag(String tag) { altTag = tag; }
  
  
  /**
   * An alternate tag form than the one produced by getTag(). Subclasses
   * may want to use this form to implement someone else's tagset (e.g., CC, ERTS, etc.)
   * 
   * @return the tag
   */
  public String getAltTag() {
    return altTag;
  }
  
  /**
   * Assumes that the tag string has been formed using a call to getTag(). As such,
   * it removes the basic category from the feature string.
   * <p>
   * Note that this method returns a <b>new</b> MorphoFeatures object. As a result, it
   * behaves like a static method, but is non-static so that subclasses can override
   * this method.
   * 
   * @param str
   */
  public MorphoFeatures fromTagString(String str) {
    List<String> feats = Arrays.asList(str.split("\\-"));
    MorphoFeatures mFeats = new MorphoFeatures();
    for(String fPair : feats) {
      String[] keyValue = fPair.split(KEY_VAL_DELIM);
      if(keyValue.length != 2)//Manual state split annotations
        continue;
      MorphoFeatureType fName = MorphoFeatureType.valueOf(keyValue[0].trim());
      mFeats.addFeature(fName, keyValue[1].trim());
    }
    
    return mFeats;
  }
  
  /**
   * values() returns the values in the order in which they are declared. Thus we will not have
   * the case where two feature types can yield two strings:
   *    -feat1:A-feat2:B
   *    -feat2:B-feat1:A
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for(MorphoFeatureType feat : MorphoFeatureType.values()) {
      if(fSpec.containsKey(feat)) {
        sb.append(String.format("-%s%s%s",feat.toString(),KEY_VAL_DELIM,fSpec.get(feat)));
      }
    }
    return sb.toString();
  }
}
