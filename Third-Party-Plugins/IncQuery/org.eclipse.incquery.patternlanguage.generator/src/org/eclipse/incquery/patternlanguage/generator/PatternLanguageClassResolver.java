/*******************************************************************************
 * Copyright (c) 2010-2012, Zoltan Ujhelyi, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Zoltan Ujhelyi - initial API and implementation
 *******************************************************************************/
package org.eclipse.incquery.patternlanguage.generator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

public class PatternLanguageClassResolver {

    public static EClass getVariableType() {
        EPackage corePackage = EPackage.Registry.INSTANCE
                .getEPackage("http://www.eclipse.org/incquery/patternlanguage/PatternLanguage");
        return (EClass) corePackage.getEClassifier("Variable");
    }

    public static EClass getVariableReferenceType() {
        EPackage corePackage = EPackage.Registry.INSTANCE
                .getEPackage("http://www.eclipse.org/incquery/patternlanguage/PatternLanguage");
        return (EClass) corePackage.getEClassifier("VariableReference");
    }
}
