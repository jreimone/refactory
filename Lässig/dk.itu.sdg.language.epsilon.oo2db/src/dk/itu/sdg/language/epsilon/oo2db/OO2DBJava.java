package dk.itu.sdg.language.epsilon.oo2db;

import java.util.ArrayList;
import java.util.HashMap;

import oo.OO.Attribute;
import oo.OO.Classifier;
import oo.OO.Datatype;
import oo.OO.Reference;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

import com.google.common.collect.Iterables;

import db.DB.Column;
import db.DB.DBFactory;
import db.DB.Database;
import db.DB.ForeignKey;
import db.DB.Table;
import db.DB.impl.DBFactoryImpl;

public class OO2DBJava {
	
	private DBFactory factory = new DBFactoryImpl();		  
	private Database db;
		  
	private final HashMap<ArrayList<? extends Object>, Database> dbCache = CollectionLiterals.newHashMap();
	
	public Database transform(final oo.OO.Package p) {
		final ArrayList<?> cacheKey = CollectionLiterals.newArrayList(p);
		final Database db = this.factory.createDatabase();
		synchronized (dbCache) {
			if (dbCache.containsKey(cacheKey)) {
				return dbCache.get(cacheKey);
			}
			dbCache.put(cacheKey, db);
		}
		    
		Iterable<oo.OO.Class> classes = Iterables.<oo.OO.Class>filter(IteratorExtensions.<EObject>toIterable(p.eAllContents()), oo.OO.Class.class);
		this.db = db;
		
		for (final oo.OO.Class c : classes) {
			db.getContents().add(this.class2Table(c));
		}
		
		return db;
	}
		  
	private final HashMap<ArrayList<? extends Object>,Table> tableCache = CollectionLiterals.newHashMap();
	
	public Table class2Table(final oo.OO.Class c) {
		final ArrayList<?> cacheKey = CollectionLiterals.newArrayList(c);
		final Table t;
		synchronized (tableCache) {
			if (tableCache.containsKey(cacheKey)) {
				return tableCache.get(cacheKey);
			}
			t = this.factory.createTable();
			tableCache.put(cacheKey, t);
		}

		t.setName(c.getName());
		t.setDatabase(db);
		
		Column pk = factory.createColumn();
		pk.setName(this.primaryKeyName(c.getName()));
	    pk.setType("INT");
	    t.getColumns().add(pk);
	    t.getPrimaryKeys().add(pk);
	    
	    if (c.getExtends() != null) {
	      ForeignKey fk = this.factory.createForeignKey();
	      Column childFkCol = this.factory.createColumn();
	      Column parentFkCol = null;
	      Table parentTable = null;
	      
	      parentTable = this.class2Table(c.getExtends());
	      parentFkCol = parentTable.getPrimaryKeys().get(0);
	      
	      childFkCol.setName(parentFkCol.getName());
	      childFkCol.setType("INT");
	      childFkCol.setTable(t);
	      
	      fk.setDatabase(this.db);
	      fk.setParent(parentFkCol);
	      fk.setChild(childFkCol);
	      fk.setName(c.getName() + "Extends" + c.getExtends().getName());
	    }
	    
	    Iterable<Attribute> attributes = Iterables.<Attribute>filter(c.getFeatures(), Attribute.class);
	    for (final Attribute a : attributes) {
	    	Column col = this.singleValuedAttribute2Column(a);
	    	if(col != null) {
	    		t.getColumns().add(this.singleValuedAttribute2Column(a));
	    	}
	    	this.multiValuedAttribute2Table(a);
	    }

	    Iterable<Reference> references = Iterables.<Reference>filter(c.getFeatures(), Reference.class);
	    for (final Reference r : references) {
	      this.reference2ForeignKey(r);
	    }
	    
	    return t;
	}
		  
	public String primaryKeyName(String name) {
		return (StringExtensions.toFirstLower(name) + "Id");	
	}
	
	private final HashMap<ArrayList<? extends Object>,Column> columnCache = CollectionLiterals.newHashMap();
		  
	public Column singleValuedAttribute2Column(final Attribute a) {
		if(!a.getIsMany()) {	
			final ArrayList<?> cacheKey = CollectionLiterals.newArrayList(a);
			final Column c;
			synchronized (columnCache) {
				if (columnCache.containsKey(cacheKey)) {
					return columnCache.get(cacheKey);
				}
				c = this.factory.createColumn();
				columnCache.put(cacheKey, c);
			}

			c.setName(a.getName());
			c.setTable(class2Table(a.getOwner()));
			c.setType(this.toDbType(a.getType().getName()));
			return c;
		}
		
		return null;
	}
		  
	public String toDbType(String typeName) {
		//modification of the original transformation
		// we moved the mapping transformation from a model to this method
		if(typeName.equals("String")) {
			return "NVARCHAR";
		} else if(typeName.equals("Integer")) {
			return "INT";
		} else if(typeName.equals("Boolean")) {
			return "BIT";
		} else if(typeName.equals("Real")) {
			return "NUMBER";
		} 
		
		return  "NVARCHAR";
	}
			  
	public Table multiValuedAttribute2Table(final Attribute a) {
		if(a.getIsMany()) {
			
			final ArrayList<?> cacheKey = CollectionLiterals.newArrayList(a);
			final Table t;
			synchronized (tableCache) {
				if (tableCache.containsKey(cacheKey)) {
					return tableCache.get(cacheKey);
				}
				t = this.factory.createTable();
				tableCache.put(cacheKey, t);
			}

			// The table that stores the values 
			// has an "id" column and a "value" column
		    t.setName(this.valuesTableName(a));
		    t.setDatabase(this.db);
		    
		    Column pkCol = this.factory.createColumn();
		    pkCol.setName("id");
		    pkCol.setTable(t);
		    pkCol.setType("INT");
		    t.getPrimaryKeys().add(pkCol);
		    
		    Column valueCol = this.factory.createColumn();
		    valueCol.setName("value");
		    valueCol.setTable(t);
		    valueCol.setType(this.toDbType(a.getType().getName()));
		    t.getColumns().add(valueCol);
		    
			// Another column is added into the table
			// to link with the "id" column of the 
			// values table
		    Column fkCol = this.factory.createColumn();
		    fkCol.setName(a.getName() + "Id");
		    fkCol.setTable(this.class2Table(a.getOwner()));
		    fkCol.setType("INT");
		    
			// The foreign key that connects
			// the two columns is defined
		    ForeignKey fk = this.factory.createForeignKey();
		    fk.setParent(pkCol);
		    fk.setChild(fkCol);
		    fk.setDatabase(this.db);
		
		    return t;
		}
		return null;
	}
		  
	public String valuesTableName(Attribute a) {
		return a.getOwner().getName() + "_" + StringExtensions.toFirstUpper(a.getName()) + "Values";
	}
		  
	private final HashMap<ArrayList<? extends Object>,ForeignKey> referenceCache = CollectionLiterals.newHashMap();
	
	public ForeignKey reference2ForeignKey(final Reference r) {
		final ArrayList<?> cacheKey = CollectionLiterals.newArrayList(r);
		final ForeignKey fk;
		synchronized (referenceCache) {
			if (referenceCache.containsKey(cacheKey)) {
				return referenceCache.get(cacheKey);
			}
			ForeignKey _createForeignKey = this.factory.createForeignKey();
			fk = _createForeignKey;
			referenceCache.put(cacheKey, fk);
		}
		
		Column fkCol = this.factory.createColumn();
		fkCol.setTable(this.classifier2Table(r.getType()));
	    fkCol.setName(r.getName() + "Id");
	    fkCol.setType("INT");
	    
	    fk.setDatabase(this.db);
	    fk.setParent(this.class2Table(r.getOwner()).getPrimaryKeys().get(0));
	    fk.setChild(fkCol);
	    fk.setName(r.getName());
		
		return fk;
	}
		
	public Table datatype2Table(final Datatype d) {
		
		//TODO: implement me!!!
		InputOutput.<String>println("CONVERTING Datatype");
		
		return null;
	}
	
	public Table classifier2Table(final Classifier c) {
		Table t = null;
		
		//Das muss besser gehen -> check dispatch!!!
		if(c instanceof oo.OO.Class) {
			oo.OO.Class clazz = (oo.OO.Class) c;
			t = this.class2Table(clazz);
		} else if(c instanceof Datatype) {
			Datatype d = (Datatype) c;
			t = this.datatype2Table(d);
		}
		
		return t;
	}
}
