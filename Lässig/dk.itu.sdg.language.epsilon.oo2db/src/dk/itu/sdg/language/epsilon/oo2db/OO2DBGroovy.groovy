package dk.itu.sdg.language.epsilon.oo2db

import java.util.ArrayList
import java.util.HashMap
import java.util.Iterator

import oo.OO.Attribute
import oo.OO.Classifier
import oo.OO.Datatype
import oo.OO.Reference

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.xbase.lib.CollectionLiterals
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions

import com.google.common.collect.Iterables

import db.DB.Column
import db.DB.DBFactory
import db.DB.Database
import db.DB.ForeignKey
import db.DB.Table
import db.DB.impl.DBFactoryImpl

class OO2DBGroovy {
	
	def factory = new DBFactoryImpl()
	def db
	
	
	def private final HashMap<ArrayList<? extends Object>, Database> dbCache = CollectionLiterals.newHashMap()	
	
	def public Database transform(oo.OO.Package p) {
		
		def final ArrayList<?> cacheKey = CollectionLiterals.newArrayList(p)
		def final Database db = this.factory.createDatabase()
		synchronized (dbCache) {
			if (dbCache.containsKey(cacheKey)) {
				return dbCache.get(cacheKey)
			}
			dbCache.put(cacheKey, db)
		}
		
		this.db = db
		Iterable<EObject> classes = IteratorExtensions.<EObject>toIterable(p.eAllContents()).grep(oo.OO.Class)
		
		for (c in classes) {
			db.contents.add(this.class2Table(c))
		}
		
		return this.db
	}
	
	
	def private final HashMap<ArrayList<? extends Object>,Table> tableCache = CollectionLiterals.newHashMap()

	def public Table class2Table(oo.OO.Class c) {
		
		def ArrayList<?> cacheKey = CollectionLiterals.newArrayList(c)
		def final Table t
		synchronized (tableCache) {
			if (tableCache.containsKey(cacheKey)) {
				return tableCache.get(cacheKey)
			}
			t = this.factory.createTable()
			tableCache.put(cacheKey, t)
		}
		
		t.name = c.name
		t.database = this.db
		
		def Column pk = factory.createColumn()
		pk.name = this.primaryKeyName(c.name)
		pk.type = "INT"
		t.columns.add(pk)
		t.primaryKeys.add(pk)
		
		if (c.extends != null) {
			
			def ForeignKey fk = factory.createForeignKey()
			def Column childFkCol = factory.createColumn()
			def Column parentFkCol
			def Table parentTable
			
			parentTable = this.class2Table(c.extends)
			parentFkCol = parentTable.primaryKeys.get(0)
			
			childFkCol.name = parentFkCol.name
			childFkCol.type = "INT"
			childFkCol.table = t
		
			fk.database = db
			fk.parent = parentFkCol
			fk.child = childFkCol
			fk.name = c.name + "Extends" + c.extends.name
		}
		
		def attributes = c.features.grep(Attribute)
		for (a in attributes) {
			def col = this.singleValuedAttribute2Column(a)
			if(col != null) {
				t.columns.add(col)
			}
			this.multiValuedAttribute2Table(a)			
		}
		
		def references = c.features.grep(Reference)
		for (r in references) {
			this.reference2ForeignKey(r)
		}
		
		return t
	}
	
	def public String primaryKeyName(String name) {
		return (StringExtensions.toFirstLower(name) + "Id")
	}
	
	def private final HashMap<ArrayList<? extends Object>,Column> columnCache = CollectionLiterals.newHashMap()
	 
	// Transforms a single-valued attribute
	// to a column
	def public Column singleValuedAttribute2Column(oo.OO.Attribute a) {
		if(!a.isMany) {
			
			def final ArrayList<?> cacheKey = CollectionLiterals.newArrayList(a)
			def final Column c
			synchronized (columnCache) {
				if (columnCache.containsKey(cacheKey)) {
					return columnCache.get(cacheKey)
				}
				c = this.factory.createColumn()
				columnCache.put(cacheKey, c)
			}
		
		
			c.name = a.name
			c.table = this.class2Table(a.owner)
			c.type = this.toDbType(a.type.name)
			
			return c
		}
		return null
	}
	
	def public String toDbType(String typeName) {
		//modification of the original transformation
		// we moved the mapping transformation from a model to this method
		if(typeName.equals("String")) {
			return "NVARCHAR"
		} else if(typeName.equals("Integer")) {
			return "INT"
		} else if(typeName.equals("Boolean")) {
			return "BIT"
		} else if(typeName.equals("Real")) {
			return "NUMBER"
		}
		
		return  "NVARCHAR"
	}
		  	
	// Transforms a multi-valued attribute
	// to a table where its values are stored
	// and a foreign key
	def public Table multiValuedAttribute2Table(Attribute a) {
		if(a.isMany) {
			def final ArrayList<?> cacheKey = CollectionLiterals.newArrayList(a)
			final Table t
			synchronized (tableCache) {
				if (tableCache.containsKey(cacheKey)) {
					return tableCache.get(cacheKey)
				}
				t = this.factory.createTable()
				tableCache.put(cacheKey, t)
			}		
		
			// The table that stores the values
			// has an "id" column and a "value" column
			t.name = this.valuesTableName(a)
			t.database = db
			
			def Column pkCol = factory.createColumn()
			pkCol.name = "id"
			pkCol.table = t
			pkCol.type = "INT"
			t.primaryKeys.add(pkCol)
			
			def Column valueCol = factory.createColumn()
			valueCol.name = "value"
			valueCol.table = t
			valueCol.type = this.toDbType(a.type.name)
			t.columns.add(valueCol)
			
			// Another column is added into the table
			// to link with the "id" column of the 
			// values table
			def Column fkCol = factory.createColumn()
			fkCol.name = a.name
			fkCol.table = this.class2Table(a.owner)
			fkCol.type = "INT"
			
			// The foreign key that connects
			// the two columns is defined
			def ForeignKey fk = factory.createForeignKey()
			fk.parent = pkCol
			fk.child = fkCol
			fk.database = db
			
			return t
		}
		
		return null
	}
	
	public String valuesTableName(Attribute a) {
		return a.owner.name + "_" + StringExtensions.toFirstUpper(a.name) + "Values"
	}
	
	def private final HashMap<ArrayList<? extends Object>,ForeignKey> foreignKeyCache = CollectionLiterals.newHashMap()
	
	// Transforms a reference into a foreign key
	def public ForeignKey reference2ForeignKey(Reference r) {
		
		final ArrayList<?> cacheKey = CollectionLiterals.newArrayList(r)
		final ForeignKey fk
		synchronized (foreignKeyCache) {
			if (foreignKeyCache.containsKey(cacheKey)) {
				return foreignKeyCache.get(cacheKey)
			}
			fk = this.factory.createForeignKey()
			foreignKeyCache.put(cacheKey, fk);
		}
	
		def Column fkCol = factory.createColumn()
		fkCol.table = this.classifier2Table(r.type)
		fkCol.name = r.name + "Id"
		fkCol.type = "INT"
		
		fk.database = db
		fk.parent = this.class2Table(r.owner).primaryKeys.get(0)
		fk.child = fkCol	
		fk.name = r.name
		
		return fk
	}
	
	public Table datatype2Table(Datatype d) {
		
		//TODO: implement me!!!
		println("CONVERTING Datatype")
		return null
	}
	
	public Table classifier2Table(Classifier c) {
		
		Table t = null
		//Das muss besser gehen -> check dispatch!!!
		if(c instanceof oo.OO.Class) {
			oo.OO.Class clazz = (oo.OO.Class) c
			t = this.class2Table(clazz)
		} else if(c instanceof Datatype) {
			Datatype d = (Datatype) c
			t = this.datatype2Table(d)
		}
		
		return t
	}

}
