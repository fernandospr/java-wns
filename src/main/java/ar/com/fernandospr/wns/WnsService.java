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

public class WnsService {	
	private int retryPolicy = 5; // By default retry 5 times
	
	private final WnsClient client;
	private WnsResourceBuilder xmlResourceBuilder;
	private WnsResourceBuilder rawResourceBuilder;

    /**
     * @param client
     */
    public WnsService(WnsClient client) {
        this.client = client;
        this.xmlResourceBuilder = new WnsXmlResourceBuilder();
        this.rawResourceBuilder = new WnsRawResourceBuilder();
    }

    /**
	 * @param sid
	 * @param clientSecret
	 */
	public WnsService(String sid, String clientSecret) {
		this(sid, clientSecret, null, false);
	}
	
	/**
	 * @param sid
	 * @param clientSecret
	 * @param proxyProperties
	 */
	public WnsService(String sid, String clientSecret, WnsProxyProperties proxyProperties) {
		this(sid, clientSecret, proxyProperties, false);
	}
	
	/**
	 * @param sid
	 * @param clientSecret
	 * @param proxyProperties
	 * @param logging true if System.out logging is needed
	 */
	 public WnsService(String sid, String clientSecret, WnsProxyProperties proxyProperties, boolean logging) {
		this(new WnsClient(sid, clientSecret, proxyProperties, logging));
	}

	/**
	 * @param sid
	 * @param clientSecret
	 * @param logging true if System.out logging is needed
	 */
	public WnsService(String sid, String clientSecret, boolean logging) {
		this(sid, clientSecret, null, logging);
	}

	/**
	 * Pushes a tile to channelUri
	 * @param channelUri
	 * @param tile which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsTileBuilder}
	 * @return WnsNotificationResponse please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response"</a>
	 * @throws WnsException when authentication fails
	 */
	public WnsNotificationResponse pushTile(String channelUri, WnsTile tile) throws WnsException {
		return this.pushTile(channelUri, null, tile);
	}
	
	/**
	 * Pushes a tile to channelUri using optional headers
	 * @param channelUri
	 * @param optional
	 * @param tile which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsTileBuilder}
	 * @return WnsNotificationResponse please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 * @throws WnsException when authentication fails
	 */
	public WnsNotificationResponse pushTile(String channelUri, WnsNotificationRequestOptional optional, WnsTile tile) throws WnsException {
		return this.client.push(xmlResourceBuilder, channelUri, tile, this.retryPolicy, optional);
	}
	
	/**
	 * Pushes a tile to channelUris
	 * @param channelUris
	 * @param tile which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsTileBuilder}
	 * @return WnsNotificationResponse please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 * @throws WnsException when authentication fails
	 */
	public List<WnsNotificationResponse> pushTile(List<String> channelUris, WnsTile tile) throws WnsException {
		return this.pushTile(channelUris, null, tile);
	}
	
	/**
	 * Pushes a tile to channelUris using optional headers
	 * @param channelUris
	 * @param optional
	 * @param tile which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsTileBuilder}
	 * @return list of WnsNotificationResponse for each channelUri, please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 * @throws WnsException when authentication fails
	 */
	public List<WnsNotificationResponse> pushTile(List<String> channelUris, WnsNotificationRequestOptional optional, WnsTile tile) throws WnsException {
		return this.client.push(xmlResourceBuilder, channelUris, tile, this.retryPolicy, optional);
	}
	
	/**
	 * Pushes a toast to channelUri
	 * @param channelUri
	 * @param toast which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsToastBuilder}
	 * @return WnsNotificationResponse please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 * @throws WnsException when authentication fails
	 */
	public WnsNotificationResponse pushToast(String channelUri, WnsToast toast) throws WnsException {
		return this.pushToast(channelUri, null, toast);
	}
	
	/**
	 * Pushes a toast to channelUri using optional headers
	 * @param channelUri
	 * @param optional
	 * @param toast which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsToastBuilder}
	 * @return WnsNotificationResponse please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 * @throws WnsException when authentication fails
	 */
	public WnsNotificationResponse pushToast(String channelUri, WnsNotificationRequestOptional optional, WnsToast toast) throws WnsException {
		return this.client.push(xmlResourceBuilder, channelUri, toast, this.retryPolicy, optional);
	}
	
	/**
	 * Pushes a toast to channelUris
	 * @param channelUris
	 * @param toast which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsToastBuilder}
	 * @return list of WnsNotificationResponse for each channelUri, please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 * @throws WnsException when authentication fails
	 */
	public List<WnsNotificationResponse> pushToast(List<String> channelUris, WnsToast toast) throws WnsException {
		return this.pushToast(channelUris, null, toast);
	}
	
	/**
	 * Pushes a toast to channelUris using optional headers
	 * @param channelUris
	 * @param optional
	 * @param toast which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsToastBuilder}
	 * @return list of WnsNotificationResponse for each channelUri, please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 * @throws WnsException when authentication fails
	 */
	public List<WnsNotificationResponse> pushToast(List<String> channelUris, WnsNotificationRequestOptional optional, WnsToast toast) throws WnsException {
		return this.client.push(xmlResourceBuilder, channelUris, toast, this.retryPolicy, optional);
	}
	
	/**
	 * Pushes a badge to channelUri
	 * @param channelUri
	 * @param badge which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsBadgeBuilder}
	 * @return WnsNotificationResponse please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 * @throws WnsException when authentication fails
	 */
	public WnsNotificationResponse pushBadge(String channelUri, WnsBadge badge) throws WnsException {
		return this.pushBadge(channelUri, null, badge);
	}

	/**
	 * Pushes a badge to channelUri using optional headers
	 * @param channelUri
	 * @param optional
	 * @param badge which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsBadgeBuilder}
	 * @return WnsNotificationResponse please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 * @throws WnsException when authentication fails
	 */
	public WnsNotificationResponse pushBadge(String channelUri, WnsNotificationRequestOptional optional, WnsBadge badge) throws WnsException {
		return this.client.push(xmlResourceBuilder, channelUri, badge, this.retryPolicy, optional);
	}
	
	/**
	 * Pushes a badge to channelUris
	 * @param channelUris
	 * @param badge which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsBadgeBuilder}
	 * @return list of WnsNotificationResponse for each channelUri, please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 * @throws WnsException when authentication fails
	 */
	public List<WnsNotificationResponse> pushBadge(List<String> channelUris, WnsBadge badge) throws WnsException {
		return this.pushBadge(channelUris, null, badge);
	}

	/**
	 * Pushes a badge to channelUris using optional headers
	 * @param channelUris
	 * @param optional
	 * @param badge which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsBadgeBuilder}
	 * @return list of WnsNotificationResponse for each channelUri, please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 * @throws WnsException when authentication fails
	 */
	public List<WnsNotificationResponse> pushBadge(List<String> channelUris, WnsNotificationRequestOptional optional, WnsBadge badge) throws WnsException {
		return this.client.push(xmlResourceBuilder, channelUris, badge, this.retryPolicy, optional);
	}
	
	/**
	 * Pushes a badge to channelUri
	 * @param channelUri
	 * @param raw which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsBadgeBuilder}
	 * @return WnsNotificationResponse please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 * @throws WnsException when authentication fails
	 */
	public WnsNotificationResponse pushRaw(String channelUri, WnsRaw raw) throws WnsException {
		return this.pushRaw(channelUri, null, raw);
	}

	/**
	 * Pushes a raw message to channelUri using optional headers
	 * @param channelUri
	 * @param optional
	 * @param raw which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsRawBuilder}
	 * @return WnsNotificationResponse please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 * @throws WnsException when authentication fails
	 */
	public WnsNotificationResponse pushRaw(String channelUri, WnsNotificationRequestOptional optional, WnsRaw raw) throws WnsException {
		return this.client.push(rawResourceBuilder, channelUri, raw, this.retryPolicy, optional);
	}
	
	/**
	 * Pushes a raw message to channelUris
	 * @param channelUris
	 * @param raw which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsRawBuilder}
	 * @return list of WnsNotificationResponse for each channelUri, please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 * @throws WnsException when authentication fails
	 */
	public List<WnsNotificationResponse> pushRaw(List<String> channelUris, WnsRaw raw) throws WnsException {
		return this.pushRaw(channelUris, null, raw);
	}

	/**
	 * Pushes a raw message to channelUris using optional headers
	 * @param channelUris
	 * @param optional
	 * @param raw which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsRawBuilder}
	 * @return list of WnsNotificationResponse for each channelUri, please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 * @throws WnsException when authentication fails
	 */
	public List<WnsNotificationResponse> pushRaw(List<String> channelUris, WnsNotificationRequestOptional optional, WnsRaw raw) throws WnsException {
		return this.client.push(rawResourceBuilder, channelUris, raw, this.retryPolicy, optional);
	}
}
