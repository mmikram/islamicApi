package com.islamicinfo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.islamicinfo.model.DeviceId;
import com.islamicinfo.model.Maulana;
import com.islamicinfo.model.YuoTubeVideo;

/**
 * @author Dinesh Rajput
 *
 */
@Repository("employeeDao")
public class IslamicInfoDaoImpl implements IslamicInfoDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addEmployee(Maulana maulana) {
		sessionFactory.getCurrentSession().saveOrUpdate(maulana);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Maulana> listEmployeess() {
		return sessionFactory.getCurrentSession().createCriteria(Maulana.class)
				.list();
	}

	@Override
	public Maulana getEmployee(int empid) {
		return (Maulana) sessionFactory.getCurrentSession().get(Maulana.class,
				empid);
	}

	@Override
	public void deleteEmployee(Maulana maulana) {
		sessionFactory
				.getCurrentSession()
				.createQuery(
						"DELETE FROM Employee WHERE empid = "
								+ maulana.getmId()).executeUpdate();
	}

	@Override
	public void addDeviceId(DeviceId deviceId) {
		sessionFactory.getCurrentSession().saveOrUpdate(deviceId);
	}

	@Override
	public void addYouTubeVideo(YuoTubeVideo tubeVideo) {
		sessionFactory.getCurrentSession().saveOrUpdate(tubeVideo);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<YuoTubeVideo> listVideo() {
		return sessionFactory.getCurrentSession()
				.createCriteria(YuoTubeVideo.class).list();
	}

}
