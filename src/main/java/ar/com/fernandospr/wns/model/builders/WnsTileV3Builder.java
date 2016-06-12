package ar.com.fernandospr.wns.model.builders;

import ar.com.fernandospr.wns.model.WnsBinding;
import ar.com.fernandospr.wns.model.WnsTile;
import ar.com.fernandospr.wns.model.WnsVisual;
import ar.com.fernandospr.wns.model.types.WnsTileV3Template;

public class WnsTileV3Builder extends WnsAbstractBuilder<WnsTileV3Builder> {
	private WnsTile tile;

	public WnsTileV3Builder() {
		this.tile = new WnsTile();
	}

	@Override
	public WnsTileV3Builder getThis() {
		return this;
	}

	@Override
	protected WnsVisual getVisual() {
		if (this.tile.visual == null) {
			this.tile.visual = new WnsVisual();
		}
		return this.tile.visual;
	}

	@Override
	protected WnsBinding getBinding() {
		if (getVisual().binding == null) {
			getVisual().binding = new WnsBinding();
		}
		return this.tile.visual.binding;
	}

	public WnsTileV3Builder visualContentId(String contentId) {
		getVisual().contentId = contentId;
		return this;
	}

	public WnsTileV3Builder bindigContentId(String contentId) {
		getBinding().contentId = contentId;
		return this;
	}

	@Override
	protected WnsTileV3Builder bindingTemplate(String template) {
		return super.bindingTemplate(template).visualVersion(3);
	}

	public WnsTileV3Builder bindingTemplateTileSquare71x71Image(String imgSrc) {
		return this.bindingTemplate(WnsTileV3Template.TILESQUARE71X71IMAGE)
				.setBindingImages(imgSrc);
	}

	public WnsTileV3Builder bindingTemplateTileSquare71x71IconWithBadge(String imgSrc) {
		return this.bindingTemplate(WnsTileV3Template.TILESQUARE71X71ICONWITHBADGE)
				.setBindingImages(imgSrc);
	}

	public WnsTileV3Builder bindingTemplateTileSquare150x150IconWithBadge(String imgSrc) {
		return this.bindingTemplate(WnsTileV3Template.TILESQUARE150X150ICONWITHBADGE)
				.setBindingImages(imgSrc);
	}

	public WnsTileV3Builder bindingTemplateTileWide310x150IconWithBadgeAndText(String imgSrc, String textField1, String textField2, String textField3) {
		return this.bindingTemplate(WnsTileV3Template.TILEWIDE310X150ICONWITHBADGEANDTEXT)
				.setBindingImages(imgSrc)
				.setBindingTextFields(textField1, textField2, textField3);
	}

	public WnsTile build() {
		return this.tile;
	}
}
