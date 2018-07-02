package note.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import note.dao.ActivityDao;
import note.entity.Activity;
@Service("activityService")
public class ActivityServiceImpl implements ActivityService{

	@Resource
	private ActivityDao activityDao;
	public List<Activity> findAllActivity() {
			
		List<Activity> list=activityDao.findAllActivity();
		
		
		return list;
	}


}
