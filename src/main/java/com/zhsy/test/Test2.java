package com.zhsy.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zhsy.model.Food;
import com.zhsy.util.HibernateUtil;

public class Test2 {

	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		sessionFactory = HibernateUtil.getFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		// begin
		String sql = "select f.* from Food as f, Material as m where f.materialId = m.id and f.name like :name";
		Query query = session.createSQLQuery(sql).addEntity(Food.class);
		// query.setParameter(0, "%m%");
		query.setParameter("name", "%%");
		List<Food> foodList = query.list();
		System.out.println(foodList.size());

		// end
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
