package com.zhsy.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import com.zhsy.util.HibernateUtil;
import com.zhsy.vo.FoodVO;

public class Test3 {

	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		sessionFactory = HibernateUtil.getFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		// begin
		String sql = "select f.*, m.path from Food as f, Material as m where f.materialId = m.id";
		Query query = session.createSQLQuery(sql);
		query.setResultTransformer(Transformers.aliasToBean(FoodVO.class));
		// query.setParameter(0, "%m%");
		// query.setParameter("name", "%%");
		List<FoodVO> foodList = query.list();
		for (FoodVO fv : foodList) {
			System.out.println(fv.getName() + "," + fv.getPath());
		}
		System.out.println(foodList.size());

		// end
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
