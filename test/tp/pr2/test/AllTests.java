package tp.pr2.test;

import tp.pr2.logica.test.TableroTest;
import tp.pr2.logica.test.CuatroEnRayaTest;
import tp.pr2.logica.test.PartidaTest;
import tp.pr2.logica.test.UndoTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class) 
@Suite.SuiteClasses( { 
	TableroTest.class,
	PartidaTest.class,
	UndoTest.class,
	CuatroEnRayaTest.class
	})
public class AllTests {

}
