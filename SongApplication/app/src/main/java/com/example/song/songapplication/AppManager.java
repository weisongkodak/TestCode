package com.example.song.songapplication;

import android.app.Activity;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author song
 * Manage activities and application
 */
public class AppManager {
	private final static String TAG = "AppManager";
	private static AppManager instance;
	private Stack<Activity> stack;
	
	private AppManager(){
		stack = new Stack<Activity>();
	}
	
	public static AppManager getInstance(){
		if(instance == null){
			instance = new AppManager();
		}
		return instance;
	}
	
	public Activity currentActivity(){
		return stack.peek();
	}
	
	public void addActivity(Activity activity){
		stack.push(activity);
	}
	
	public void removeActivity(Activity activity){
		stack.remove(activity);
	}
	
	public void setCurrentActivity(Activity activity){
		if(activity != stack.peek()){
			//move to top
			stack.remove(activity);
			stack.push(activity);
		}
	}
	public @NonNull
	<T extends Activity> List<T> findActivityInStack(Class<T> activityClz) {
		List<T> list = new ArrayList<T>();
		for (Activity activity : stack) {
			if (activity.getClass() == activityClz) {
				list.add((T) activity);
			}
		}
		return list;
	}
	
	public void finishAllActivity(){
		Stack<Activity> temp = (Stack<Activity>) stack.clone();
		for(Activity activity: temp){
			activity.finish();
		}
	}
	
	/**
	 * finish all activity except current activity
	 * @return current activity
	 */
	public Activity finishAllExceptCurrentActivity() {
		Activity current = currentActivity();
		Stack<Activity> temp = (Stack<Activity>) stack.clone();
		for(Activity activity: temp){
			if (current == activity) {
				continue;
			}
			activity.finish();
		}
		
		return current;
	}
	
	public void exitApp(){
		finishAllActivity();
		System.exit(0);
	}

	

	

	


}
