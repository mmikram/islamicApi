package com.islamicinfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.islamicinfo.dao.IslamicInfoDao;
import com.islamicinfo.model.DeviceId;
import com.islamicinfo.model.Maulana;
import com.islamicinfo.model.YuoTubeVideo;

/**
 * @author Dinesh Rajput
 *
 */
@Service("employeeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class IslamicInfoServiceImpl implements IsalmicInfoService {

	@Autowired
	private IslamicInfoDao islamicInfoDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addEmployee(Maulana maulana) {
		islamicInfoDao.addEmployee(maulana);
	}

	@Override
	public List<Maulana> listEmployeess() {
		return islamicInfoDao.listEmployeess();
	}

	@Override
	public Maulana getEmployee(int empid) {
		return islamicInfoDao.getEmployee(empid);
	}

	@Override
	public void deleteEmployee(Maulana maulana) {
		islamicInfoDao.deleteEmployee(maulana);
	}

	@Override
	public void addDeviceId(DeviceId deviceId) {
		islamicInfoDao.addDeviceId(deviceId);

	}

	@Override
	public void addYouTubeVideo(YuoTubeVideo tubeVideo) {
		islamicInfoDao.addYouTubeVideo(tubeVideo);

	}

	@Override
	public List<YuoTubeVideo> listVideo() {

		return islamicInfoDao.listVideo();
	}

}
