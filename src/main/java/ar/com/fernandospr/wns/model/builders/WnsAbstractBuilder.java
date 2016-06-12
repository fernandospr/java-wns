package ar.com.fernandospr.wns.model.builders;

import java.util.ArrayList;

import ar.com.fernandospr.wns.model.WnsBinding;
import ar.com.fernandospr.wns.model.WnsImage;
import ar.com.fernandospr.wns.model.WnsText;
import ar.com.fernandospr.wns.model.WnsVisual;

public abstract class WnsAbstractBuilder<T extends WnsAbstractBuilder<T>> {
	protected abstract T getThis();
	protected abstract WnsVisual getVisual();
	protected abstract WnsBinding getBinding();
	
	public T visualVersion(Integer version) {
		getVisual().version = version;
		return getThis();
	}
	
	public T visualLang(String lang) {
		getVisual().lang = lang;
		return getThis();
	}
	
	public T visualBaseUri(String baseUri) {
		getVisual().baseUri = baseUri;
		return getThis();
	}

	/**
	 * @param branding should be any of {@link ar.com.fernandospr.wns.model.types.WnsBrandingType}
	 */
	public T visualBranding(String branding) {
		getVisual().branding = branding;
		return getThis();
	}
	
	public T visualAddImageQuery(Boolean addImageQuery) {
		getVisual().addImageQuery = addImageQuery;
		return getThis();
	}
	
	public T bindingFallback(String fallback) {
		getBinding().fallback = fallback;
		return getThis();
	}
	
	public T bindingLang(String lang) {
		getBinding().lang = lang;
		return getThis();
	}
	
	public T bindingBaseUri(String baseUri) {
		getBinding().baseUri = baseUri;
		return getThis();
	}
	
	/**
	 * @param branding should be any of {@link ar.com.fernandospr.wns.model.types.WnsBrandingType}
	 */
	public T bindingBranding(String branding) {
		getBinding().branding = branding;
		return getThis();
	}

	public T bindingAddImageQuery(Boolean addImageQuery) {
		getBinding().addImageQuery = addImageQuery;
		return getThis();
	}

	// See https://msdn.microsoft.com/en-us/library/windows/apps/hh761491.aspx#versions
	// and
	// https://msdn.microsoft.com/en-us/library/windows/apps/br212854.aspx
	/**
	 * @param template 	<p>
	 * 					For tiles: should be any of {@link ar.com.fernandospr.wns.model.types.WnsTileTemplate}
	 * 					<p>
	 * 					For toasts: should be any of {@link ar.com.fernandospr.wns.model.types.WnsToastTemplate}
	 */
	protected T bindingTemplate(String template) {
		getBinding().template = template;
		getBinding().texts = null;
		getBinding().images = null;
		return getThis();
	}

	protected T setBindingTextFields(String ... textFields) {
		getBinding().texts = new ArrayList<WnsText>();
		for (int i = 0; i < textFields.length; i++) {
			WnsText txt = new WnsText();
			txt.id = i+1;
			txt.value = textFields[i] != null ? textFields[i] : "";
			getBinding().texts.add(txt);
		}
		return getThis();
	}
	
	protected T setBindingImages(String ... imgSrcs) {
		getBinding().images = new ArrayList<WnsImage>();
		for (int i = 0; i < imgSrcs.length; i++) {
			WnsImage img = new WnsImage();
			img.id = i+1;
			img.src = imgSrcs[i] != null ? imgSrcs[i] : "";
			getBinding().images.add(img);
		}
		return getThis();
	}
}
