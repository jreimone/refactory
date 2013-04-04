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
