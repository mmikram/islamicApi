package com.islamicinfo.dao;

import java.util.List;

import com.islamicinfo.model.DeviceId;
import com.islamicinfo.model.Maulana;
import com.islamicinfo.model.YuoTubeVideo;

/**
 * @author Dinesh Rajput
 *
 */
public interface IslamicInfoDao {

	public void addEmployee(Maulana maulana);

	public List<Maulana> listEmployeess();

	public Maulana getEmployee(int empid);

	public void deleteEmployee(Maulana maulana);

	public void addDeviceId(final DeviceId deviceId);

	public void addYouTubeVideo(final YuoTubeVideo tubeVideo);

	public List<YuoTubeVideo> listVideo();
}
