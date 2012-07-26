/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
/**
 * @author Michael Muck
 *
 * This class is derived from EcoreUtil.Copier and does the same as the
 * original one but in addition it copies non-containment-references 
 * as well (which the original does not)
 *
 *
 */
package oclrefactoring;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;


public class ReferenceCopier extends Copier {



	private static final long serialVersionUID = 1L;

    /**
     * Whether proxies should be resolved during copying.
     */
    protected boolean resolveProxies = true;

    /**
     * Whether non-copied references should be used during copying.
     */
    protected boolean useOriginalReferences = true;

    /**
     * Creates an instance.
     */
    public ReferenceCopier()
    {
      super();
//      System.out.println("attribute copier instantiated");
    }
    
    /**
     * Creates an instance that resolves proxies or not as specified.
     * @param resolveProxies whether proxies should be resolved while copying.
     */
    public ReferenceCopier(boolean resolveProxies)
    {
      this.resolveProxies = resolveProxies;
    }

    /**
     * Creates an instance that resolves proxies or not and uses non-copied references or not as specified.
     * @param resolveProxies whether proxies should be resolved while copying.
     * @param useOriginalReferences whether non-copied references should be used while copying.
     */
    public ReferenceCopier(boolean resolveProxies, boolean useOriginalReferences)
    {
      this.resolveProxies = resolveProxies;
      this.useOriginalReferences = useOriginalReferences;
    }

    /**
     * Returns a collection containing a copy of each EObject in the given collection.
     * @param eObjects the collection of objects to copy.
     * @return the collection of copies.
     */
    public <T> Collection<T> copyAll(Collection<? extends T> eObjects)
    {
      Collection<T> result = new ArrayList<T>(eObjects.size());
      for (Object object : eObjects)
      {
        @SuppressWarnings("unchecked") T t = (T)copy((EObject)object);
        result.add(t);
      }
      return result;
    }

    /**
     * Returns a copy of the given eObject.
     * @param eObject the object to copy.
     * @return the copy.
     */
    public EObject copy(EObject eObject)
    {
      if (eObject == null)
      {
        return null;
      }
      else
      {
//    	  System.out.println("  copying "+eObject);
        EObject copyEObject = createCopy(eObject);
        put(eObject, copyEObject);
        EClass eClass = eObject.eClass();
        for (int i = 0, size = eClass.getFeatureCount(); i < size; ++i)
        {
//        	System.out.println("    feature count: "+eClass.getFeatureCount());
          EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(i);
          if (eStructuralFeature.isChangeable() && !eStructuralFeature.isDerived())
          {
            if (eStructuralFeature instanceof EAttribute)
            {
//            	System.out.println("    feature is an attribute");
              copyAttribute((EAttribute)eStructuralFeature, eObject, copyEObject);
            }
            else
            {
//            	System.out.println("    feature is an reference");
              EReference eReference = (EReference)eStructuralFeature;
              if (eReference.isContainment())
              {
//            	  System.out.println("      feature is an containment reference");
                copyContainment(eReference, eObject, copyEObject);
              }
              else {
//            	  System.out.println("      feature is NOT an containment reference!!!!!!!!!!");
//            	  System.out.println("      feature: "+eStructuralFeature);
            	  
            	  
            	  //this is not done by the standard EcoreUtil.Copier but is needed for attributes like names, typeNames etc.
            	  copyReference(eReference, eObject, copyEObject);
              }
            }
          }
        }
  
        copyProxyURI(eObject, copyEObject);
  
        return copyEObject;
      }
    }

    /**
     * Copies the proxy URI from the original to the copy, if present.
     * @param eObject the object being copied.
     * @param copyEObject the copy being initialized.
     */
    protected void copyProxyURI(EObject eObject, EObject copyEObject)
    {
      if (eObject.eIsProxy())
      {
        ((InternalEObject)copyEObject).eSetProxyURI(((InternalEObject)eObject).eProxyURI());
      }
    }

    /**
     * Returns a new instance of the object's target class.
     * @param eObject the object to copy.
     * @return a new instance of the target class.
     * @see #getTarget(EClass)
     * @see EcoreUtil#create(EClass)
     */
    protected EObject createCopy(EObject eObject)
    {
      return create(getTarget(eObject.eClass()));
    }
    
    /**
     * Creates an instance of the class.
     * @param eClass the class to instantiate.
     * @return an instance of the class.
     */
    public static EObject create(EClass eClass)
    {
      return eClass.getEPackage().getEFactoryInstance().create(eClass);
    }
    

    /**
     * Returns the target class used to create a copy instance for objects of the given source class.
     * @param eClass the source class.
     * @return the target class used to create a copy instance.
     * @see #getTarget(EStructuralFeature)
     */
    protected EClass getTarget(EClass eClass)
    {
      return eClass;
    }

    /**
     * Returns the target feature used to populate a copy instance from the given source feature.
     * @param eStructuralFeature the source feature.
     * @return the target feature used to populate a copy instance.
     * @see #getTarget(EClass)
     */
    protected EStructuralFeature getTarget(EStructuralFeature eStructuralFeature)
    {
      return eStructuralFeature;
    }

    /**
     * Called to handle the copying of a containment feature;
     * this adds a list of copies or sets a single copy as appropriate for the multiplicity.
     * @param eReference the feature to copy.
     * @param eObject the object from which to copy.
     * @param copyEObject the object to copy to.
     */
    protected void copyContainment(EReference eReference, EObject eObject, EObject copyEObject)
    {
      if (eObject.eIsSet(eReference))
      {
        if (eReference.isMany())
        {
          @SuppressWarnings("unchecked") List<EObject> source = (List<EObject>)eObject.eGet(eReference);
          @SuppressWarnings("unchecked") List<EObject> target = (List<EObject>)copyEObject.eGet(getTarget(eReference));
          if (source.isEmpty())
          {
            target.clear();
          }
          else
          {
            target.addAll(copyAll(source));
          }
        }
        else
        {
          EObject childEObject = (EObject)eObject.eGet(eReference);
          copyEObject.eSet(getTarget(eReference), childEObject == null ? null : copy(childEObject));
        }
      }
    }

    /**
     * Hooks up cross references; it delegates to {@link #copyReference copyReference}.
     */
    public void copyReferences()
    {
      for (Map.Entry<EObject, EObject> entry  : entrySet())
      {
        EObject eObject = entry.getKey();
        EObject copyEObject = entry.getValue();
        EClass eClass = eObject.eClass();
        for (int j = 0, size = eClass.getFeatureCount(); j < size; ++j)
        {
          EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(j);
          if (eStructuralFeature.isChangeable() && !eStructuralFeature.isDerived())
          {
            if (eStructuralFeature instanceof EReference)
            {
              EReference eReference = (EReference)eStructuralFeature;
              if (!eReference.isContainment() && !eReference.isContainer())
              {
                copyReference(eReference, eObject, copyEObject);
              }
            }
            else if (FeatureMapUtil.isFeatureMap(eStructuralFeature))
            {
              FeatureMap featureMap = (FeatureMap)eObject.eGet(eStructuralFeature);
              FeatureMap copyFeatureMap = (FeatureMap)copyEObject.eGet(getTarget(eStructuralFeature));
              int copyFeatureMapSize = copyFeatureMap.size();
              for (int k = 0, featureMapSize = featureMap.size(); k < featureMapSize; ++k)
              {
                EStructuralFeature feature = featureMap.getEStructuralFeature(k);
                if (feature instanceof EReference)
                {
                  Object referencedEObject = featureMap.getValue(k);
                  Object copyReferencedEObject = get(referencedEObject);
                  if (copyReferencedEObject == null && referencedEObject != null)
                  {
                    EReference reference = (EReference)feature;
                    if (!useOriginalReferences || reference.isContainment() || reference.getEOpposite() != null)
                    {
                      continue;
                    }
                    copyReferencedEObject = referencedEObject;
                  }
                  // If we can't add it, it must already be in the list so find it and move it to the end.
                  //
                  if (!copyFeatureMap.add(feature, copyReferencedEObject))
                  {
                    for (int l = 0; l < copyFeatureMapSize; ++l) 
                    {
                      if (copyFeatureMap.getEStructuralFeature(l) == feature && copyFeatureMap.getValue(l) == copyReferencedEObject)
                      {
                        copyFeatureMap.move(copyFeatureMap.size() - 1, l);
                        --copyFeatureMapSize;
                        break;
                      }
                    }
                  }
                }
                else
                {
                  copyFeatureMap.add(featureMap.get(k));
                }
              }
            }
          }
        }
      }
    }

    /**
     * Called to handle the copying of a cross reference;
     * this adds values or sets a single value as appropriate for the multiplicity
     * while omitting any bidirectional reference that isn't in the copy map.
     * @param eReference the reference to copy.
     * @param eObject the object from which to copy.
     * @param copyEObject the object to copy to.
     */
    protected void copyReference(EReference eReference, EObject eObject, EObject copyEObject)
    {
      if (eObject.eIsSet(eReference))
      {
        if (eReference.isMany())
        {
          @SuppressWarnings("unchecked") InternalEList<EObject> source = (InternalEList<EObject>)eObject.eGet(eReference);
          @SuppressWarnings("unchecked") InternalEList<EObject> target = (InternalEList<EObject>)copyEObject.eGet(getTarget(eReference));
          if (source.isEmpty())
          {
            target.clear();
          }
          else
          {
            boolean isBidirectional = eReference.getEOpposite() != null;
            int index = 0;
            for (Iterator<EObject> k = resolveProxies ? source.iterator() : source.basicIterator(); k.hasNext();)
            {
              EObject referencedEObject = k.next();
              EObject copyReferencedEObject = get(referencedEObject);
              if (copyReferencedEObject == null)
              {
                if (useOriginalReferences && !isBidirectional)
                {
                  target.addUnique(index, referencedEObject);
                  ++index;
                }
              }
              else
              {
                if (isBidirectional)
                {
                  int position = target.indexOf(copyReferencedEObject);
                  if (position == -1)
                  {
                    target.addUnique(index, copyReferencedEObject);
                  }
                  else if (index != position)
                  {
                    target.move(index, copyReferencedEObject);
                  }
                }
                else
                {
                  target.addUnique(index, copyReferencedEObject);
                }
                ++index;
              }
            }
          }
        }
        else
        {
          Object referencedEObject = eObject.eGet(eReference, resolveProxies);
          if (referencedEObject == null)
          {
            copyEObject.eSet(getTarget(eReference), null);
          }
          else
          {
            Object copyReferencedEObject = get(referencedEObject);
            if (copyReferencedEObject == null)
            {
              if (useOriginalReferences && eReference.getEOpposite() == null)
              {
                copyEObject.eSet(getTarget(eReference), referencedEObject);
              }
            }
            else
            {
              copyEObject.eSet(getTarget(eReference), copyReferencedEObject);
            }
          }
        }
      }
    }

	
	
	
	
	
	
	/**
     * Called to handle the copying of an attribute;
     * this adds a list of values or sets a single value as appropriate for the multiplicity.
     * @param eAttribute the attribute to copy.
     * @param eObject the object from which to copy.
     * @param copyEObject the object to copy to.
     */
    protected void copyAttribute(EAttribute eAttribute, EObject eObject, EObject copyEObject)
    {	
    	if(eAttribute != null) {
//    		System.out.println("    copying Attribute: "+eAttribute);
//    		System.out.println("      name: "+eAttribute.getName());
//    		System.out.println("      type: "+eAttribute.getEType());
    		
    	}
      if (eObject.eIsSet(eAttribute))
      {
        if (FeatureMapUtil.isFeatureMap(eAttribute))
        {
          FeatureMap featureMap = (FeatureMap)eObject.eGet(eAttribute);
//          System.out.println("copying a feature map with "+featureMap.size()+" elements.");
          for (int i = 0, size = featureMap.size(); i < size; ++i)
          {
            EStructuralFeature feature = featureMap.getEStructuralFeature(i);
//            System.out.println("  feature: "+feature);
            
            if (feature instanceof EReference && ((EReference)feature).isContainment())
            {
//            	System.out.println("    Feature is a containment reference");
              Object value = featureMap.getValue(i);
              if (value != null)
              {
                System.out.println("    value: "+value);
                copy((EObject)value);
              }
            }
          }
        }
        else if (eAttribute.isMany())
        {
          System.out.println("     Attribute is of type 'many'");
          List<?> source = (List<?>)eObject.eGet(eAttribute);
//          Iterator<?> sourceit = source.iterator();
//          while (sourceit.hasNext()) {
//       	  System.out.println("      Attribute from list: "+sourceit.next());
//          }
          @SuppressWarnings("unchecked") List<Object> target = (List<Object>)copyEObject.eGet(getTarget(eAttribute));
          if (source.isEmpty())
          {
            target.clear();
          }
          else
          {
            target.addAll(source);
          }
        }
        else
        {
//        	System.out.println("     Attribute is a 'single' attribute");
          copyEObject.eSet(getTarget(eAttribute), eObject.eGet(eAttribute));
        }
      }
    }
    
    
}
