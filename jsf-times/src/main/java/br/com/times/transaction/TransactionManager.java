package br.com.times.transaction;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@SuppressWarnings("serial")
@Transactional
@Interceptor
public class TransactionManager implements Serializable {

	@Inject
	private EntityManager em;

	@AroundInvoke
	public Object executeTransaction(InvocationContext context) throws Exception {

		em.getTransaction().begin();

		Object result = context.proceed();

		em.getTransaction().commit();

		return result;

	}

}
