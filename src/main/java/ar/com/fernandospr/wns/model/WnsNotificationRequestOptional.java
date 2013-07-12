package ar.com.fernandospr.wns.model;

/**
 * Optional headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_request">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_request</a>
 */
public class WnsNotificationRequestOptional {
	/**
	 * Should be any of {@link ar.com.fernandospr.wns.model.types.WnsCachePolicyType}
	 */
	public String cachePolicy;
	
	/**
	 * Should be any of {@link ar.com.fernandospr.wns.model.types.WnsRequestForStatusType}
	 */
	public String requestForStatus;
	
	public String tag;
	
	public String ttl;
}
