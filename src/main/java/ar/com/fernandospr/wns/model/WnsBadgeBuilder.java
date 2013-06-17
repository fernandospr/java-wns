package ar.com.fernandospr.wns.model;

public class WnsBadgeBuilder {
	private WnsBadge badge;
	
	public WnsBadgeBuilder() {
		this.badge = new WnsBadge();
	}
	
	/**
	 * @param value should be between 1-99
	 */
	public WnsBadgeBuilder value(Integer value) {
		this.badge.value = String.valueOf(value);
		return this;
	}
	
	/**
	 * @param value should be any of {@link ar.com.fernandospr.wns.model.types.WnsBadgeType}
	 */
	public WnsBadgeBuilder value(String value) {
		this.badge.value = value;
		return this;
	}
	
	public WnsBadgeBuilder version(Integer version) {
		this.badge.version = version;
		return this;
	}
	
	public WnsBadge build() {
		return this.badge;
	}
}
