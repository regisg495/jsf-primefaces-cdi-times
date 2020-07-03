package br.com.times.dao;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.times.modelo.Jogador;
import br.com.times.modelo.Posicao;
import br.com.times.modelo.Tecnico;
import br.com.times.modelo.Time;

public class PopulaBanco {
	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("times");
		
		EntityManager em = emf.createEntityManager();	
		
		
		Posicao p1 = new Posicao("Meio de Campo");
		Posicao p2 = new Posicao("Goleiro");
		Posicao p3 = new Posicao("Lateral Direito");
		Posicao p4 = new Posicao("Lateral Esquerdo");
		Posicao p5 = new Posicao("Volante");
		Posicao p6 = new Posicao("Centroavante");
		Posicao p7 = new Posicao("Zagueiro");

		Tecnico te1 = new Tecnico("Abel Braga", "99213444442");
		Tecnico te2 = new Tecnico("Felipao", "93123456781");
		Tecnico te3 = new Tecnico("Jorge Sampaoli", "91334555551");
		Tecnico te4 = new Tecnico("Murici Ramalho", "34567123451");
		
		Jogador j1 = new Jogador("Paolo Guerreiro", "2222555551", Arrays.asList(p1, p6));
		Jogador j2 = new Jogador("D'alessandro", "11111111111", Arrays.asList(p6, p1));
		Jogador j3 = new Jogador("Rodrigo Dourado", "83212324444", Arrays.asList(p5, p1));
		Jogador j4 = new Jogador("Rafael Sóbis", "99123123451", Arrays.asList(p6));
		Jogador j5 = new Jogador("Geromel", "12222222222", Arrays.asList(p5, p7));
		Jogador j6 = new Jogador("Jean Pyerre", "91345678911", Arrays.asList(p1));
		Jogador j7 = new Jogador("Julio Cesar", "67456654321", Arrays.asList(p2));
		Jogador j8 = new Jogador("Darlan", "84234534543", Arrays.asList(p4));
		
		Time t1 = new Time("Internacional", Arrays.asList(j1, j2, j3, j4), te1);
		Time t2 = new Time("Grêmio", Arrays.asList(j5, j6, j7, j8), te2);
		
		
		em.getTransaction().begin();
		
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.persist(p4);
		em.persist(p5);
		em.persist(p6);
		em.persist(p7);
		
		em.persist(te1);
		em.persist(te2);
		em.persist(te3);
		em.persist(te4);
		
		em.persist(j1);
		em.persist(j2);
		em.persist(j3);
		em.persist(j4);
		em.persist(j5);
		em.persist(j6);
		em.persist(j7);
		em.persist(j8);
		
		em.persist(t1);
		em.persist(t2);
		
		j1.setTime(t1);
		j2.setTime(t1);
		j3.setTime(t1);
		j4.setTime(t1);
		j5.setTime(t2);
		j6.setTime(t2);
		j7.setTime(t2);
		j8.setTime(t2);
		
		te1.setTime(t1);
		te2.setTime(t2);

		
		
		em.getTransaction().commit();
		
		em.close();
		

	}

}
