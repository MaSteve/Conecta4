package tp.pr1.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import tp.pr1.logica.test.*;

@RunWith(Suite.class) 
@Suite.SuiteClasses( { 
	TableroTest.class,
	PartidaTest.class,
	UndoTest.class,
	CuatroEnRayaTest.class
	})
public class AllTests {

}
