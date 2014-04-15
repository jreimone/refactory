/**
 * Copyright (c) 2010-2012, Zoltan Ujhelyi, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Zoltan Ujhelyi - initial API and implementation
 */
package org.eclipse.incquery.patternlanguage.scoping;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody;
import org.eclipse.incquery.patternlanguage.patternLanguage.Variable;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.MapBasedScope;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.scoping.LocalVariableScopeContext;
import org.eclipse.xtext.xbase.scoping.XbaseScopeProvider;

@SuppressWarnings("all")
public class PatternLanguageScopeProvider extends XbaseScopeProvider {
  public PatternBody getContainerBody(final EObject obj) {
    EObject current = obj;
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(current, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _not = (!(current instanceof PatternBody));
      _and = (_notEquals && _not);
    }
    boolean _while = _and;
    while (_while) {
      EObject _eContainer = current.eContainer();
      current = _eContainer;
      boolean _and_1 = false;
      boolean _notEquals_1 = (!Objects.equal(current, null));
      if (!_notEquals_1) {
        _and_1 = false;
      } else {
        boolean _not_1 = (!(current instanceof PatternBody));
        _and_1 = (_notEquals_1 && _not_1);
      }
      _while = _and_1;
    }
    boolean _notEquals_1 = (!Objects.equal(current, null));
    if (_notEquals_1) {
      return ((PatternBody) current);
    } else {
      return null;
    }
  }
  
  public IScope createLocalVarScope(final IScope parent, final LocalVariableScopeContext scopeContext) {
    final IScope parentScope = super.createLocalVarScope(parent, scopeContext);
    EObject _context = scopeContext.getContext();
    final EObject context = _context;
    boolean _matched = false;
    if (!_matched) {
      if (context instanceof PatternBody) {
        final PatternBody _patternBody = (PatternBody)context;
        _matched=true;
        EList<Variable> _variables = _patternBody.getVariables();
        final Function1<Variable,IEObjectDescription> _function = new Function1<Variable,IEObjectDescription>() {
            public IEObjectDescription apply(final Variable e) {
              IEObjectDescription _createIEObjectDescription = PatternLanguageScopeProvider.this.createIEObjectDescription(e);
              return _createIEObjectDescription;
            }
          };
        final List<IEObjectDescription> descriptions = ListExtensions.<Variable, IEObjectDescription>map(_variables, _function);
        IScope _createLocalVarScope = super.createLocalVarScope(parentScope, scopeContext);
        return MapBasedScope.createScope(_createLocalVarScope, descriptions);
      }
    }
    if (!_matched) {
      if (context instanceof Pattern) {
        final Pattern _pattern = (Pattern)context;
        _matched=true;
        EList<Variable> _parameters = _pattern.getParameters();
        final Function1<Variable,IEObjectDescription> _function = new Function1<Variable,IEObjectDescription>() {
            public IEObjectDescription apply(final Variable e) {
              IEObjectDescription _createIEObjectDescription = PatternLanguageScopeProvider.this.createIEObjectDescription(e);
              return _createIEObjectDescription;
            }
          };
        final List<IEObjectDescription> descriptions = ListExtensions.<Variable, IEObjectDescription>map(_parameters, _function);
        return MapBasedScope.createScope(parentScope, descriptions);
      }
    }
    if (!_matched) {
      PatternBody _containerBody = this.getContainerBody(context);
      boolean _notEquals = (!Objects.equal(_containerBody, null));
      if (_notEquals) {
        _matched=true;
        PatternBody _containerBody_1 = this.getContainerBody(context);
        EList<Variable> _variables = _containerBody_1.getVariables();
        final Function1<Variable,IEObjectDescription> _function = new Function1<Variable,IEObjectDescription>() {
            public IEObjectDescription apply(final Variable e) {
              IEObjectDescription _createIEObjectDescription = PatternLanguageScopeProvider.this.createIEObjectDescription(e);
              return _createIEObjectDescription;
            }
          };
        final List<IEObjectDescription> descriptions = ListExtensions.<Variable, IEObjectDescription>map(_variables, _function);
        IScope _createLocalVarScope = super.createLocalVarScope(parentScope, scopeContext);
        return MapBasedScope.createScope(_createLocalVarScope, descriptions);
      }
    }
    return parentScope;
  }
  
  public IEObjectDescription createIEObjectDescription(final Variable parameter) {
    IEObjectDescription _xblockexpression = null;
    {
      QualifiedName _xifexpression = null;
      String _name = parameter.getName();
      boolean _notEquals = (!Objects.equal(_name, null));
      if (_notEquals) {
        String _name_1 = parameter.getName();
        QualifiedName _create = QualifiedName.create(_name_1);
        _xifexpression = _create;
      } else {
        _xifexpression = QualifiedName.EMPTY;
      }
      QualifiedName name = _xifexpression;
      IEObjectDescription _create_1 = EObjectDescription.create(name, parameter, null);
      _xblockexpression = (_create_1);
    }
    return _xblockexpression;
  }
}
