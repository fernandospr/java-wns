package ar.com.fernandospr.wns.model.types;

/**
 *  From http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response
 */
public final class WnsNotificationStatusType {
	public static final String RECEIVED = "received";
	public static final String DROPPED = "dropped";
	public static final String CHANNELTHROTTLED = "channelthrottled";
}
