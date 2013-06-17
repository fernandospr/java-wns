package ar.com.fernandospr.wns.model;

public class WnsTileBuilder {
	private WnsTile tile;
	
	public WnsTileBuilder() {
		this.tile = new WnsTile();
	}
	
	protected WnsVisual getVisual() {
		if (this.tile.visual == null) {
			this.tile.visual = new WnsVisual();
		}
		return this.tile.visual;
	}
	
	protected WnsBinding getBinding() {
		if (getVisual().binding == null) {
			getVisual().binding = new WnsBinding();
		}
		return this.tile.visual.binding;
	}
	
	public WnsTileBuilder visualVersion(Integer version) {
		getVisual().version = version;
		return this;
	}
	
	public WnsTileBuilder visualLang(String lang) {
		getVisual().lang = lang;
		return this;
	}
	
	public WnsTileBuilder visualBaseUri(String baseUri) {
		getVisual().baseUri = baseUri;
		return this;
	}

	public WnsTileBuilder visualBranding(String branding) {
		getVisual().branding = branding;
		return this;
	}
	
	public WnsTileBuilder visualAddImageQuery(Boolean addImageQuery) {
		getVisual().addImageQuery = addImageQuery;
		return this;
	}
	
	/**
	 * @param template should be any of {@link ar.com.fernandospr.wns.model.types.WnsTileTemplate}
	 */
	public WnsTileBuilder bindingTemplate(String template) {
		getBinding().template = template;
		return this;
	}
	
	public WnsTileBuilder bindingFallback(String fallback) {
		getBinding().fallback = fallback;
		return this;
	}
	
	public WnsTileBuilder bindingLang(String lang) {
		getBinding().lang = lang;
		return this;
	}
	
	public WnsTileBuilder bindingBaseUri(String baseUri) {
		getBinding().baseUri = baseUri;
		return this;
	}
	
	public WnsTileBuilder bindingBranding(String branding) {
		getBinding().branding = branding;
		return this;
	}

	public WnsTileBuilder bindingAddImageQuery(Boolean addImageQuery) {
		getBinding().addImageQuery = addImageQuery;
		return this;
	}
	
	public WnsTile build() {
		return this.tile;
	} 
}
