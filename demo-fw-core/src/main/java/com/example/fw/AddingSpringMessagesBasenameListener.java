package com.example.fw;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.MapPropertySource;

public abstract class AddingSpringMessagesBasenameListener
		implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
	private final String newFile;

	public AddingSpringMessagesBasenameListener(String newFile) {
		this.newFile = newFile;
	}

	@Override
	public final void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {

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
			map.put("spring.messages.basename", "messages," + newFile);
		}
		else {
			map.put("spring.messages.basename", property + "," + newFile);
		}
	}
}
