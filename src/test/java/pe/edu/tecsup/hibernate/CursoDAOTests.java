package pe.edu.tecsup.hibernate;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pe.edu.tecsup.hibernate.dao.CursoDAO;
import pe.edu.tecsup.hibernate.model.Curso;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CursoDAOTests {

    @Autowired
    CursoDAO cursoDAO;

    @Test
    public void verifyList() {

        List<Curso> cursos = cursoDAO.list();
        for (Curso curso : cursos) {
        	System.out.println(curso.getId());
            System.out.println(curso.getNombre());
        }
        Assert.assertTrue(cursos.size() > 0);
    }

    @Test
    public void verifyFind() {
    	Curso curso = cursoDAO.get(4l);
    	 System.out.println("ID ENCONTRADO");
    	 System.out.println(curso.getId());
        System.out.println(curso.getNombre());
        Assert.assertTrue(curso.getId() == 4l);
    }
    
    @Test
    public void verifylistBynNombre() {
    	
    	String nombre ="";
    	List<Curso> cursos = cursoDAO.getByNombre(nombre);
    	
    	for (Curso curso :cursos)
    	
    	 System.out.println("ID ENCONTRADO");
    	 System.out.println(curso.getId());
        System.out.println(curso.getNombre());
        System.out.println(curso.getPrograma().getNombre());
        Assert.assertTrue(curso.getId() == 4l);
    }
/*
@Test
public void verifyFind2() {
	Curso curso = cursoDAO.getcodigo("1020");
	 System.out.println("CODIGO ENCONTRADO");
	 System.out.println(curso.getId());
    System.out.println(curso.getNombre());
    Assert.assertTrue(curso.getCodigo() == "1020");
}
  */

    
    @Test
    public void verifySave() {

    	Curso curso = new Curso();
    	curso.setCodigo("1020");
    	curso.setNombre("PRUEBAAAAAAAA2");
    
    	cursoDAO.save(curso);
        Assert.assertTrue(curso.getId() != null);
    }

    @Test
    public void verifyUpdate() {

        // cambiar el código para validar
    	Curso curso = new Curso();
    	curso.setId(39l);
    	curso.setCodigo("999");
    	curso.setNombre("PRUEBAAAAAAAA");

    	cursoDAO.update(curso);
        Assert.assertTrue(cursoDAO.get(39l).getCodigo().equals("999"));
    }

    @Test
    public void verifyDelete() {

        Curso curso = new Curso();
        curso.setId(40l);
        cursoDAO.delete(curso);

        Assert.assertTrue(cursoDAO.get(40l) == null);
    }

}
