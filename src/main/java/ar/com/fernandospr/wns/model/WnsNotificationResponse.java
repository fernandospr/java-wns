package ar.com.fernandospr.wns.model;

import javax.ws.rs.core.MultivaluedMap;

/**
 * From http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response
 */
public class WnsNotificationResponse {
	public final int code;
	
	public final String debugTrace;
	
	/**
	 * Should be any of {@link ar.com.fernandospr.wns.model.types.WnsDeviceConnectionStatusType}
	 */
	public final String deviceConnectionStatus;
	
	public final String errorDescription;
	
	public final String msgID;
	
	/**
	 * Should be any of {@link ar.com.fernandospr.wns.model.types.WnsNotificationStatusType}
	 */
	public final String notificationStatus;
	
	public WnsNotificationResponse(int responseCode, MultivaluedMap<String, String> headers) {
		this.code = responseCode;
		this.debugTrace = headers.get("X-WNS-Debug-Trace") != null ? headers.get("X-WNS-Debug-Trace").get(0) : null;
		this.deviceConnectionStatus = headers.get("X-WNS-DeviceConnectionStatus") != null ? headers.get("X-WNS-DeviceConnectionStatus").get(0) : null;
		this.errorDescription = headers.get("X-WNS-Error-Description") != null ? headers.get("X-WNS-Error-Description").get(0) : null;
		this.msgID = headers.get("X-WNS-Msg-ID") != null ? headers.get("X-WNS-Msg-ID").get(0) : null;
		this.notificationStatus = headers.get("X-WNS-NotificationStatus") != null ? headers.get("X-WNS-NotificationStatus").get(0) : null;
	}
}
