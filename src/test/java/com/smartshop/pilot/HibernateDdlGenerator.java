package com.smartshop.pilot;



import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.smartshop.catalog.Address;
import com.smartshop.catalog.Email;
import com.smartshop.catalog.Manufacturer;
import com.smartshop.catalog.PhoneNumber;
import com.smartshop.catalog.Product;
import com.smartshop.catalog.ProductCategory;
import com.smartshop.catalog.Supplier;



public class HibernateDdlGenerator {



	enum Dialect {
		MYSQL("org.hibernate.dialect.MySQL5InnoDBDialect"),
		ORACLE("org.unhcr.omss.db.oracle.OracleDialectDeferredFK"), 
		SYBASE("org.hibernate.dialect.SybaseAnywhereDialect");

		private String className;

		private Dialect(String className) {
			this.className = className;
		}

		public String getClassName() {
			return className;
		}
	}


	public static void main(String[] args) { new HibernateDdlGenerator().execute(Dialect.MYSQL,Address.class,Email.class,Manufacturer.class,PhoneNumber.class,Product.class,Supplier.class,Address.class,ProductCategory.class);
	}
	private void execute(Dialect dialect, Class<?>... classes) {
		Configuration configuration = new Configuration();
		configuration.setProperty(Environment.DIALECT, dialect.getClassName());
		for (Class<?> entityClass : classes) {
			configuration.addAnnotatedClass(entityClass);
		}

		SchemaExport schemaExport = new SchemaExport(configuration);
		schemaExport.setDelimiter(";");
		schemaExport.setOutputFile("/Users/sarat/src2/pilot/src/main/resources/sql/ddl.sql");
		boolean consolePrint = true;
		boolean exportInDatabase = false;
		schemaExport.create(consolePrint, exportInDatabase);
	}


}

