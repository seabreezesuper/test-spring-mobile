package com.bill;

import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DevicePlatform;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@GetMapping("/")
	public String greeting(Device device) {

		String deviceType = "";
		String platform = "";

		// 设备类型
		if (device.isNormal()) {
			deviceType = "desktop";
		} else if (device.isMobile()) {
			deviceType = "mobile";
		} else if (device.isTablet()) {
			deviceType = "tablet";
		}

		// 如果是手机的话，还可以取得手机操作系统平台
		if (device != null) {
			DevicePlatform dp = device.getDevicePlatform();
			switch (dp) {
			case ANDROID:
				platform = "android";
				break;
			case IOS:
				platform = "ios";
				break;
			case UNKNOWN:
				platform = "unknown";
				break;
			}
		}

		return deviceType + "," + platform;
	}
}
