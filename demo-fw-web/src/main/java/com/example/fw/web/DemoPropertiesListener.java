package com.example.fw.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.MapPropertySource;

public class DemoPropertiesListener
		implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
	@Override
	public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {

		MapPropertySource properties = (MapPropertySource) event.getEnvironment()
				.getPropertySources().get("demoProperties");
		Map<String, Object> map;

		if (properties == null) {
			map = new HashMap<>();
			properties = new MapPropertySource("demoProperties", map);
			event.getEnvironment().getPropertySources().addFirst(properties);
		}
		else {
			map = properties.getSource();
		}

		Object property = event.getEnvironment().getProperty("spring.messages.basename");
		if (property == null) {
			map.put("spring.messages.basename", "messages,demo-web");
		}
		else {
			map.put("spring.messages.basename", property + ",demo-web");
		}
	}
}
