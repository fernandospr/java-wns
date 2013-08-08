package ar.com.fernandospr.wns;

import java.util.List;

import ar.com.fernandospr.wns.client.WnsClient;
import ar.com.fernandospr.wns.client.WnsRawResourceBuilder;
import ar.com.fernandospr.wns.client.WnsResourceBuilder;
import ar.com.fernandospr.wns.client.WnsXmlResourceBuilder;
import ar.com.fernandospr.wns.exceptions.WnsException;
import ar.com.fernandospr.wns.model.WnsBadge;
import ar.com.fernandospr.wns.model.WnsNotificationRequestOptional;
import ar.com.fernandospr.wns.model.WnsNotificationResponse;
import ar.com.fernandospr.wns.model.WnsRaw;
import ar.com.fernandospr.wns.model.WnsTile;
import ar.com.fernandospr.wns.model.WnsToast;
import ar.com.fernandospr.wns.model.types.WnsNotificationType;

public class WnsService {	
	private int retryPolicy = 5; // By default retry 5 times
	
	private WnsClient client;
	private WnsResourceBuilder xmlResourceBuilder;
	private WnsResourceBuilder rawResourceBuilder;
	
	/**
	 * @param sid
	 * @param clientSecret
	 * @throws WnsException when authentication fails
	 */
	public WnsService(String sid, String clientSecret) throws WnsException {
		this(sid,clientSecret, false);
	}
	
	/**
	 * @param sid
	 * @param clientSecret
	 * @param logging true if System.out logging is needed
	 * @throws WnsException when authentication fails
	 */
	public WnsService(String sid, String clientSecret, boolean logging) throws WnsException {
		this.client = new WnsClient(sid, clientSecret, logging);
		this.xmlResourceBuilder = new WnsXmlResourceBuilder();
		this.rawResourceBuilder = new WnsRawResourceBuilder();
	}
	
	/**
	 * Pushes a tile to channelUri
	 * @param channelUri
	 * @param tile which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsTileBuilder}
	 * @return WnsNotificationResponse please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response"</a>
	 */
	public WnsNotificationResponse pushTile(String channelUri, WnsTile tile) {
		return this.pushTile(channelUri, null, tile);
	}
	
	/**
	 * Pushes a tile to channelUri using optional headers
	 * @param channelUri
	 * @param optional
	 * @param tile which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsTileBuilder}
	 * @return WnsNotificationResponse please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 */
	public WnsNotificationResponse pushTile(String channelUri, WnsNotificationRequestOptional optional, WnsTile tile) {
		return this.client.push(xmlResourceBuilder, channelUri, WnsNotificationType.TILE, tile, this.retryPolicy, optional);
	}
	
	/**
	 * Pushes a tile to channelUris
	 * @param channelUris
	 * @param tile which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsTileBuilder}
	 * @return WnsNotificationResponse please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 */
	public List<WnsNotificationResponse> pushTile(List<String> channelUris, WnsTile tile) {
		return this.pushTile(channelUris, null, tile);
	}
	
	/**
	 * Pushes a tile to channelUris using optional headers
	 * @param channelUris
	 * @param optional
	 * @param tile which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsTileBuilder}
	 * @return list of WnsNotificationResponse for each channelUri, please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 */
	public List<WnsNotificationResponse> pushTile(List<String> channelUris, WnsNotificationRequestOptional optional, WnsTile tile) {
		return this.client.push(xmlResourceBuilder, channelUris, WnsNotificationType.TILE, tile, this.retryPolicy, optional);
	}
	
	/**
	 * Pushes a toast to channelUri
	 * @param channelUri
	 * @param toast which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsToastBuilder}
	 * @return WnsNotificationResponse please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 */
	public WnsNotificationResponse pushToast(String channelUri, WnsToast toast) {
		return this.pushToast(channelUri, null, toast);
	}
	
	/**
	 * Pushes a toast to channelUri using optional headers
	 * @param channelUri
	 * @param optional
	 * @param toast which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsToastBuilder}
	 * @return WnsNotificationResponse please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 */
	public WnsNotificationResponse pushToast(String channelUri, WnsNotificationRequestOptional optional, WnsToast toast) {
		return this.client.push(xmlResourceBuilder, channelUri, WnsNotificationType.TOAST, toast, this.retryPolicy, optional);
	}
	
	/**
	 * Pushes a toast to channelUris
	 * @param channelUris
	 * @param toast which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsToastBuilder}
	 * @return list of WnsNotificationResponse for each channelUri, please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 */
	public List<WnsNotificationResponse> pushToast(List<String> channelUris, WnsToast toast) {
		return this.pushToast(channelUris, null, toast);
	}
	
	/**
	 * Pushes a toast to channelUris using optional headers
	 * @param channelUris
	 * @param optional
	 * @param toast which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsToastBuilder}
	 * @return list of WnsNotificationResponse for each channelUri, please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 */
	public List<WnsNotificationResponse> pushToast(List<String> channelUris, WnsNotificationRequestOptional optional, WnsToast toast) {
		return this.client.push(xmlResourceBuilder, channelUris, WnsNotificationType.TOAST, toast, this.retryPolicy, optional);
	}
	
	/**
	 * Pushes a badge to channelUri
	 * @param channelUri
	 * @param badge which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsBadgeBuilder}
	 * @return WnsNotificationResponse please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 */
	public WnsNotificationResponse pushBadge(String channelUri, WnsBadge badge) {
		return this.pushBadge(channelUri, null, badge);
	}

	/**
	 * Pushes a badge to channelUri using optional headers
	 * @param channelUri
	 * @param optional
	 * @param badge which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsBadgeBuilder}
	 * @return WnsNotificationResponse please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 */
	public WnsNotificationResponse pushBadge(String channelUri, WnsNotificationRequestOptional optional, WnsBadge badge) {
		return this.client.push(xmlResourceBuilder, channelUri, WnsNotificationType.BADGE, badge, this.retryPolicy, optional);
	}
	
	/**
	 * Pushes a badge to channelUris
	 * @param channelUris
	 * @param badge which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsBadgeBuilder}
	 * @return list of WnsNotificationResponse for each channelUri, please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 */
	public List<WnsNotificationResponse> pushBadge(List<String> channelUris, WnsBadge badge) {
		return this.pushBadge(channelUris, null, badge);
	}

	/**
	 * Pushes a badge to channelUris using optional headers
	 * @param channelUris
	 * @param optional
	 * @param badge which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsBadgeBuilder}
	 * @return list of WnsNotificationResponse for each channelUri, please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 */
	public List<WnsNotificationResponse> pushBadge(List<String> channelUris, WnsNotificationRequestOptional optional, WnsBadge badge) {
		return this.client.push(xmlResourceBuilder, channelUris, WnsNotificationType.BADGE, badge, this.retryPolicy, optional);
	}
	
	/**
	 * Pushes a badge to channelUri
	 * @param channelUri
	 * @param badge which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsBadgeBuilder}
	 * @return WnsNotificationResponse please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 */
	public WnsNotificationResponse pushRaw(String channelUri, WnsRaw raw) {
		return this.pushRaw(channelUri, null, raw);
	}

	/**
	 * Pushes a raw message to channelUri using optional headers
	 * @param channelUri
	 * @param optional
	 * @param raw which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsRawBuilder}
	 * @return WnsNotificationResponse please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 */
	public WnsNotificationResponse pushRaw(String channelUri, WnsNotificationRequestOptional optional, WnsRaw raw) {
		return this.client.push(rawResourceBuilder, channelUri, WnsNotificationType.RAW, raw, this.retryPolicy, optional);
	}
	
	/**
	 * Pushes a raw message to channelUris
	 * @param channelUris
	 * @param raw which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsRawBuilder}
	 * @return list of WnsNotificationResponse for each channelUri, please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 */
	public List<WnsNotificationResponse> pushRaw(List<String> channelUris, WnsRaw raw) {
		return this.pushRaw(channelUris, null, raw);
	}

	/**
	 * Pushes a raw message to channelUris using optional headers
	 * @param channelUris
	 * @param optional
	 * @param raw which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsRawBuilder}
	 * @return list of WnsNotificationResponse for each channelUri, please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 */
	public List<WnsNotificationResponse> pushRaw(List<String> channelUris, WnsNotificationRequestOptional optional, WnsRaw raw) {
		return this.client.push(rawResourceBuilder, channelUris, WnsNotificationType.RAW, raw, this.retryPolicy, optional);
	}
}
