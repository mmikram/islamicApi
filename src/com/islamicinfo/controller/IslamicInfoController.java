package com.islamicinfo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.islamicinfo.bean.DevicesIdBean;
import com.islamicinfo.bean.MaulanaBean;
import com.islamicinfo.bean.YouTubeVideoBean;
import com.islamicinfo.model.DeviceId;
import com.islamicinfo.model.Maulana;
import com.islamicinfo.model.YuoTubeVideo;
import com.islamicinfo.service.IsalmicInfoService;

/**
 * @author Dinesh Rajput
 *
 */
@Controller
public class IslamicInfoController {

	@Autowired
	private IsalmicInfoService isalmicInfoService;

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public ModelAndView saveEmployee(
			@ModelAttribute("command") MaulanaBean maulanaBean,
			BindingResult result) {
		Maulana maulana = prepareModel(maulanaBean);
		isalmicInfoService.addEmployee(maulana);
		return new ModelAndView("redirect:/add.html");
	}

	@RequestMapping(value = "/saveid", method = RequestMethod.POST)
	public void saveDeviceId(@RequestBody DevicesIdBean devicesIdBean,
			BindingResult result) {
		final DeviceId deviceId = prepareDeviceModel(devicesIdBean);
		isalmicInfoService.addDeviceId(deviceId);
		// return devicesIdBean;
	}

	@RequestMapping(value = "/maulanas", method = RequestMethod.GET)
	public @ResponseBody List<MaulanaBean> listEmployees() {
		// Map<String, Object> model = new HashMap<String, Object>();
		// model.put("employees",
		// prepareListofBean(employeeService.listEmployeess()));
		return prepareListofBean(isalmicInfoService.listEmployeess());
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addMaulana(
			@ModelAttribute("command") MaulanaBean maulanaBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("maulanas",
				prepareListofBean(isalmicInfoService.listEmployeess()));
		return new ModelAndView("addMaulana", model);
	}

	@RequestMapping(value = "/vidoes", method = RequestMethod.GET)
	public @ResponseBody List<YouTubeVideoBean> listVideo() {
		// Map<String, Object> model = new HashMap<String, Object>();
		// model.put("employees",
		// prepareListofBean(employeeService.listEmployeess()));
		return prepareListofVideoBean(isalmicInfoService.listVideo());
	}

	@RequestMapping(value = "/addVideo", method = RequestMethod.GET)
	public ModelAndView addVideo(
			@ModelAttribute("command") YouTubeVideoBean bean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("videos",
				prepareListofVideoBean(isalmicInfoService.listVideo()));
		return new ModelAndView("addVideo", model);
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/saveVideo", method = RequestMethod.GET)
	public ModelAndView saveYouTubeVideo(
			@ModelAttribute("command") YouTubeVideoBean videoBean,
			BindingResult result) {
		final YuoTubeVideo tubeVideo = prepareYouTube(videoBean);
		isalmicInfoService.addYouTubeVideo(tubeVideo);
		return new ModelAndView("redirect:/addVideo.html");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editEmployee(
			@ModelAttribute("command") MaulanaBean maulanaBean,
			BindingResult result) {
		isalmicInfoService.deleteEmployee(prepareModel(maulanaBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("maulana", null);
		model.put("maulanas",
				prepareListofBean(isalmicInfoService.listEmployeess()));
		return new ModelAndView("addMaulana", model);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(
			@ModelAttribute("command") MaulanaBean maulanaBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("maulana", prepareEmployeeBean(isalmicInfoService
				.getEmployee(maulanaBean.getmId())));
		model.put("maulanas",
				prepareListofBean(isalmicInfoService.listEmployeess()));
		return new ModelAndView("addMaulana", model);
	}

	private Maulana prepareModel(MaulanaBean maulanaBean) {
		Maulana maulana = new Maulana();
		maulana.setmId(maulanaBean.getmId());
		maulana.setmName(maulanaBean.getmName());
		maulana.setImageLink(maulanaBean.getImageLink());

		return maulana;
	}

	private List<MaulanaBean> prepareListofBean(List<Maulana> maulanas) {
		List<MaulanaBean> beans = null;
		if (maulanas != null && !maulanas.isEmpty()) {
			beans = new ArrayList<MaulanaBean>();
			MaulanaBean bean = null;
			if (null != maulanas) {
				for (Maulana maulana : maulanas) {
					bean = new MaulanaBean();
					if (null != maulana) {
						bean.setmId(maulana.getmId());
						bean.setmName(maulana.getmName());
						bean.setImageLink(maulana.getImageLink());
						beans.add(bean);
					}
				}
			}
		}
		return beans;
	}

	private List<YouTubeVideoBean> prepareListofVideoBean(
			List<YuoTubeVideo> tubeVideos) {
		List<YouTubeVideoBean> beans = null;
		if (tubeVideos != null && !tubeVideos.isEmpty()) {
			beans = new ArrayList<YouTubeVideoBean>();
			YouTubeVideoBean bean = null;
			if (null != tubeVideos) {
				for (YuoTubeVideo video : tubeVideos) {
					bean = new YouTubeVideoBean();
					if (null != video) {
						bean.setvKey(video.getvKey());
						bean.setTitle(video.getTitle());
						bean.setMaulanaName(video.getMaulanaName());
						bean.setvId(video.getvId());
						bean.setDate(video.getDate());
						beans.add(bean);
					}
				}
			}
		}
		return beans;
	}

	private MaulanaBean prepareEmployeeBean(Maulana maulana) {
		MaulanaBean bean = new MaulanaBean();
		bean.setmId(maulana.getmId());
		bean.setmName(maulana.getmName());
		bean.setImageLink(maulana.getImageLink());
		return bean;
	}

	private DeviceId prepareDeviceModel(final DevicesIdBean bean) {
		final DeviceId deviceId = new DeviceId();
		deviceId.setDeviceId(bean.getDeviceId());
		deviceId.setGcmId(bean.getGcmId());
		return deviceId;

	}

	private YuoTubeVideo prepareYouTube(final YouTubeVideoBean bean) {
		final YuoTubeVideo tubeVideo = new YuoTubeVideo();
		tubeVideo.setvKey(bean.getvKey());
		tubeVideo.setMaulanaName(bean.getMaulanaName());
		tubeVideo.setTitle(bean.getTitle());
		tubeVideo.setDate(bean.getDate());
		return tubeVideo;
	}
}
