package ar.com.fernandospr.wns.model.builders;

import ar.com.fernandospr.wns.model.WnsBinding;
import ar.com.fernandospr.wns.model.WnsTile;
import ar.com.fernandospr.wns.model.WnsVisual;
import ar.com.fernandospr.wns.model.types.WnsTileTemplate;
import ar.com.fernandospr.wns.model.types.WnsTileV2Template;

public class WnsTileV2Builder extends WnsAbstractBuilder<WnsTileV2Builder> {
	private WnsTile tile;

	public WnsTileV2Builder() {
		this.tile = new WnsTile();
	}

	@Override
	public WnsTileV2Builder getThis() {
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

	public WnsTileV2Builder visualContentId(String contentId) {
		getVisual().contentId = contentId;
		return this;
	}

	public WnsTileV2Builder bindigContentId(String contentId) {
		getBinding().contentId = contentId;
		return this;
	}

	@Override
	protected WnsTileV2Builder bindingTemplate(String template) {
		return super.bindingTemplate(template).visualVersion(2);
	}

	/**
	 * @param template tileTemplateNameV2. Should be any of {@link WnsTileV2Template}
	 * @param fallback tileTemplateNameV1. Should be any of {@link WnsTileTemplate}
	 * @return WnsTileV2Builder
	 */
	private WnsTileV2Builder bindingTemplate(String template, String fallback) {
		getBinding().fallback = fallback;
		return bindingTemplate(template);
	}

	public WnsTileV2Builder bindingTemplateTileSquare150x150Block(String textField1, String textField2) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE150X150BLOCK, WnsTileTemplate.TILESQUAREBLOCK)
				.setBindingTextFields(textField1, textField2);
	}

	public WnsTileV2Builder bindingTemplateTileSquare150x150Text01(String textField1, String textField2, String textField3, String textField4) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE150X150TEXT01, WnsTileTemplate.TILESQUARETEXT01)
					.setBindingTextFields(textField1, textField2, textField3, textField4);
	}

	public WnsTileV2Builder bindingTemplateTileSquare150x150Text02(String textField1, String textField2) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE150X150TEXT02, WnsTileTemplate.TILESQUARETEXT02)
					.setBindingTextFields(textField1, textField2);
	}
	
	public WnsTileV2Builder bindingTemplateTileSquare150x150Text03(String textField1, String textField2, String textField3, String textField4) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE150X150TEXT03, WnsTileTemplate.TILESQUARETEXT03)
					.setBindingTextFields(textField1, textField2, textField3, textField4);
	}

	public WnsTileV2Builder bindingTemplateTileSquare150x150Text04(String textField1) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE150X150TEXT04, WnsTileTemplate.TILESQUARETEXT04)
					.setBindingTextFields(textField1);
	}
	
	public WnsTileV2Builder bindingTemplateTileSquare150x150Image(String imgSrc1, String textField1) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE150X150IMAGE, WnsTileTemplate.TILESQUAREIMAGE)
					.setBindingTextFields(textField1)
					.setBindingImages(imgSrc1);
	}
	
	public WnsTileV2Builder bindingTemplateTileSquare150x150PeekImageAndText01(String imgSrc1, String textField1, String textField2, String textField3, String textField4) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE150X150PEEKIMAGEANDTEXT01, WnsTileTemplate.TILESQUAREPEEKIMAGEANDTEXT01)
					.setBindingTextFields(textField1, textField2, textField3, textField4)
					.setBindingImages(imgSrc1);
	}
	
	public WnsTileV2Builder bindingTemplateTileSquare150x150PeekImageAndText02(String imgSrc1, String textField1, String textField2) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE150X150PEEKIMAGEANDTEXT02, WnsTileTemplate.TILESQUAREPEEKIMAGEANDTEXT02)
					.setBindingTextFields(textField1, textField2)
					.setBindingImages(imgSrc1);
	}
	
	public WnsTileV2Builder bindingTemplateTileSquare150x150PeekImageAndText03(String imgSrc1, String textField1, String textField2, String textField3, String textField4) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE150X150PEEKIMAGEANDTEXT03, WnsTileTemplate.TILESQUAREPEEKIMAGEANDTEXT03)
					.setBindingTextFields(textField1, textField2, textField3, textField4)
					.setBindingImages(imgSrc1);
	}
	
	public WnsTileV2Builder bindingTemplateTileSquare150x150PeekImageAndText04(String imgSrc1, String textField1) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE150X150PEEKIMAGEANDTEXT04, WnsTileTemplate.TILESQUAREPEEKIMAGEANDTEXT04)
					.setBindingImages(imgSrc1)
					.setBindingTextFields(textField1);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150Text01(String textField1, String textField2, String textField3, String textField4, String textField5) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150TEXT01, WnsTileTemplate.TILEWIDETEXT01)
					.setBindingTextFields(textField1, textField2, textField3, textField4, textField5);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150Text02(String textField1, String textField2, String textField3, String textField4, String textField5, String textField6, String textField7, String textField8, String textField9) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150TEXT02, WnsTileTemplate.TILEWIDETEXT02)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150Text03(String textField1) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150TEXT03, WnsTileTemplate.TILEWIDETEXT03)
				.setBindingTextFields(textField1);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150Text04(String textField1) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150TEXT04, WnsTileTemplate.TILEWIDETEXT04)
				.setBindingTextFields(textField1);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150Text05(String textField1, String textField2, String textField3, String textField4, String textField5) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150TEXT05, WnsTileTemplate.TILEWIDETEXT05)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150Text01(String textField1, String textField2, String textField3, String textField4, String textField5, String textField6, String textField7, String textField8, String textField9, String textField10) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150TEXT06, WnsTileTemplate.TILEWIDETEXT06)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9, textField10);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150Text07(String textField1, String textField2, String textField3, String textField4, String textField5, String textField6, String textField7, String textField8, String textField9) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150TEXT07, WnsTileTemplate.TILEWIDETEXT07)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150Text08(String textField1, String textField2, String textField3, String textField4, String textField5, String textField6, String textField7, String textField8, String textField9, String textField10) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150TEXT08, WnsTileTemplate.TILEWIDETEXT08)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9, textField10);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150Text09(String textField1, String textField2) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150TEXT09, WnsTileTemplate.TILEWIDETEXT09)
				.setBindingTextFields(textField1, textField2);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150Text10(String textField1, String textField2, String textField3, String textField4, String textField5, String textField6, String textField7, String textField8, String textField9) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150TEXT10, WnsTileTemplate.TILEWIDETEXT10)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150Text11(String textField1, String textField2, String textField3, String textField4, String textField5, String textField6, String textField7, String textField8, String textField9, String textField10) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150TEXT11, WnsTileTemplate.TILEWIDETEXT11)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9, textField10);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150Image(String imgSrc1) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150IMAGE, WnsTileTemplate.TILEWIDEIMAGE)
				.setBindingImages(imgSrc1);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150ImageCollection(String imgSrc1, String imgSrc2, String imgSrc3, String imgSrc4, String imgSrc5) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150IMAGECOLLECTION, WnsTileTemplate.TILEWIDEIMAGECOLLECTION)
				.setBindingImages(imgSrc1, imgSrc2, imgSrc3, imgSrc4, imgSrc5);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150ImageAndText01(String imgSrc1, String textField1) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150IMAGEANDTEXT01, WnsTileTemplate.TILEWIDEIMAGEANDTEXT01)
				.setBindingTextFields(textField1)
				.setBindingImages(imgSrc1);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150ImageAndText02(String imgSrc1, String textField1, String textField2) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150IMAGEANDTEXT02, WnsTileTemplate.TILEWIDEIMAGEANDTEXT02)
				.setBindingTextFields(textField1, textField2)
				.setBindingImages(imgSrc1);
	}

	public WnsTileV2Builder bindingTemplateTileWide310x150BlockAndText01(String textField1, String textField2, String textField3, String textField4, String textField5, String textField6) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150BLOCKANDTEXT01, WnsTileTemplate.TILEWIDEBLOCKANDTEXT01)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150BlockAndText02(String textField1, String textField2, String textField3) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150BLOCKANDTEXT02, WnsTileTemplate.TILEWIDEBLOCKANDTEXT02)
				.setBindingTextFields(textField1, textField2, textField3);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150SmallImageAndText01(String imgSrc1, String textField1) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150SMALLIMAGEANDTEXT01, WnsTileTemplate.TILEWIDESMALLIMAGEANDTEXT01)
				.setBindingTextFields(textField1)
				.setBindingImages(imgSrc1);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150SmallImageAndText02(String imgSrc1, String textField1, String textField2, String textField3, String textField4, String textField5) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150SMALLIMAGEANDTEXT02, WnsTileTemplate.TILEWIDESMALLIMAGEANDTEXT02)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5)
				.setBindingImages(imgSrc1);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150SmallImageAndText03(String imgSrc1, String textField1) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150SMALLIMAGEANDTEXT03, WnsTileTemplate.TILEWIDESMALLIMAGEANDTEXT03)
				.setBindingTextFields(textField1)
				.setBindingImages(imgSrc1);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150SmallImageAndText04(String imgSrc1, String textField1, String textField2) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150SMALLIMAGEANDTEXT04, WnsTileTemplate.TILEWIDESMALLIMAGEANDTEXT04)
				.setBindingTextFields(textField1, textField2)
				.setBindingImages(imgSrc1);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150SmallImageAndText05(String imgSrc1, String textField1, String textField2) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150SMALLIMAGEANDTEXT05, WnsTileTemplate.TILEWIDESMALLIMAGEANDTEXT05)
				.setBindingTextFields(textField1, textField2)
				.setBindingImages(imgSrc1);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150PeekImageCollection01(String imgSrc1, String imgSrc2, String imgSrc3, String imgSrc4, String imgSrc5, String textField1, String textField2) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150PEEKIMAGECOLLECTION01, WnsTileTemplate.TILEWIDEPEEKIMAGECOLLECTION01)
				.setBindingImages(imgSrc1, imgSrc2, imgSrc3, imgSrc4, imgSrc5)
				.setBindingTextFields(textField1, textField2);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150PeekImageCollection02(String imgSrc1, String imgSrc2, String imgSrc3, String imgSrc4, String imgSrc5, String textField1, String textField2, String textField3, String textField4, String textField5) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150PEEKIMAGECOLLECTION02, WnsTileTemplate.TILEWIDEPEEKIMAGECOLLECTION02)
				.setBindingImages(imgSrc1, imgSrc2, imgSrc3, imgSrc4, imgSrc5)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150PeekImageCollection03(String imgSrc1, String imgSrc2, String imgSrc3, String imgSrc4, String imgSrc5, String textField1) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150PEEKIMAGECOLLECTION03, WnsTileTemplate.TILEWIDEPEEKIMAGECOLLECTION03)
				.setBindingImages(imgSrc1, imgSrc2, imgSrc3, imgSrc4, imgSrc5)
				.setBindingTextFields(textField1);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150PeekImageCollection04(String imgSrc1, String imgSrc2, String imgSrc3, String imgSrc4, String imgSrc5, String textField1) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150PEEKIMAGECOLLECTION04, WnsTileTemplate.TILEWIDEPEEKIMAGECOLLECTION04)
				.setBindingImages(imgSrc1, imgSrc2, imgSrc3, imgSrc4, imgSrc5)
				.setBindingTextFields(textField1);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150PeekImageCollection05(String imgSrc1, String imgSrc2, String imgSrc3, String imgSrc4, String imgSrc5, String imgSrc6, String textField1, String textField2) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150PEEKIMAGECOLLECTION05, WnsTileTemplate.TILEWIDEPEEKIMAGECOLLECTION05)
				.setBindingImages(imgSrc1, imgSrc2, imgSrc3, imgSrc4, imgSrc5, imgSrc6)
				.setBindingTextFields(textField1, textField2);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150PeekImageCollection06(String imgSrc1, String imgSrc2, String imgSrc3, String imgSrc4, String imgSrc5, String imgSrc6, String textField1) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150PEEKIMAGECOLLECTION06, WnsTileTemplate.TILEWIDEPEEKIMAGECOLLECTION06)
				.setBindingImages(imgSrc1, imgSrc2, imgSrc3, imgSrc4, imgSrc5, imgSrc6)
				.setBindingTextFields(textField1);
	}

	public WnsTileV2Builder bindingTemplateTileWide310x150PeekImageAndText01(String imgSrc1, String textField1) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150PEEKIMAGEANDTEXT01, WnsTileTemplate.TILEWIDEPEEKIMAGEANDTEXT01)
				.setBindingTextFields(textField1)
				.setBindingImages(imgSrc1);
	}

	public WnsTileV2Builder bindingTemplateTileWide310x150PeekImageAndText02(String imgSrc1, String textField1, String textField2, String textField3, String textField4, String textField5) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150PEEKIMAGEANDTEXT02, WnsTileTemplate.TILEWIDEPEEKIMAGEANDTEXT02)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5)
				.setBindingImages(imgSrc1);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150PeekImage01(String imgSrc1, String textField1, String textField2) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150PEEKIMAGE01, WnsTileTemplate.TILEWIDEPEEKIMAGE01)
				.setBindingTextFields(textField1, textField2)
				.setBindingImages(imgSrc1);
	}

	public WnsTileV2Builder bindingTemplateTileWide310x150PeekImage02(String imgSrc1, String textField1, String textField2, String textField3, String textField4, String textField5) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150PEEKIMAGE02, WnsTileTemplate.TILEWIDEPEEKIMAGE02)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5)
				.setBindingImages(imgSrc1);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150PeekImage03(String imgSrc1, String textField1) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150PEEKIMAGE03, WnsTileTemplate.TILEWIDEPEEKIMAGE03)
				.setBindingTextFields(textField1)
				.setBindingImages(imgSrc1);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150PeekImage04(String imgSrc1, String textField1) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150PEEKIMAGE04, WnsTileTemplate.TILEWIDEPEEKIMAGE04)
				.setBindingTextFields(textField1)
				.setBindingImages(imgSrc1);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150PeekImage05(String imgSrc1, String imgSrc2, String textField1, String textField2) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150PEEKIMAGE05, WnsTileTemplate.TILEWIDEPEEKIMAGE05)
				.setBindingTextFields(textField1, textField2)
				.setBindingImages(imgSrc1, imgSrc2);
	}
	
	public WnsTileV2Builder bindingTemplateTileWide310x150PeekImage06(String imgSrc1, String imgSrc2, String textField1) {
		return this.bindingTemplate(WnsTileV2Template.TILEWIDE310X150PEEKIMAGE06, WnsTileTemplate.TILEWIDEPEEKIMAGE06)
				.setBindingTextFields(textField1)
				.setBindingImages(imgSrc1, imgSrc2);
	}

	// V2 only

	public WnsTileV2Builder bindingTemplateTileSquare310x310Text01(String textField1, String textField2, String textField3, String textField4, String textField5, String textField6, String textField7, String textField8, String textField9, String textField10) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310TEXT01)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9, textField10);
	}

	public WnsTileV2Builder bindingTemplateTileSquare310x310Text02(String textField1, String textField2, String textField3, String textField4, String textField5, String textField6, String textField7, String textField8, String textField9, String textField10, String textField11, String textField12, String textField13, String textField14, String textField15, String textField16, String textField17, String textField18, String textField19) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310TEXT02)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9, textField10, textField11, textField12, textField13, textField14, textField15, textField16, textField17, textField18, textField19);
	}

	public WnsTileV2Builder bindingTemplateTileSquare310x310Text03(String textField1, String textField2, String textField3, String textField4, String textField5, String textField6, String textField7, String textField8, String textField9, String textField10, String textField11) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310TEXT03)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9, textField10, textField11);
	}

	public WnsTileV2Builder bindingTemplateTileSquare310x310Text04(String textField1, String textField2, String textField3, String textField4, String textField5, String textField6, String textField7, String textField8, String textField9, String textField10, String textField11, String textField12, String textField13, String textField14, String textField15, String textField16, String textField17, String textField18, String textField19, String textField20) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310TEXT04)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9, textField10, textField11, textField12, textField13, textField14, textField15, textField16, textField17, textField18, textField19, textField20);
	}

	public WnsTileV2Builder bindingTemplateTileSquare310x310Text05(String textField1, String textField2, String textField3, String textField4, String textField5, String textField6, String textField7, String textField8, String textField9, String textField10, String textField11, String textField12, String textField13, String textField14, String textField15, String textField16, String textField17, String textField18, String textField19) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310TEXT05)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9, textField10, textField11, textField12, textField13, textField14, textField15, textField16, textField17, textField18, textField19);
	}

	public WnsTileV2Builder bindingTemplateTileSquare310x310Text06(String textField1, String textField2, String textField3, String textField4, String textField5, String textField6, String textField7, String textField8, String textField9, String textField10, String textField11, String textField12, String textField13, String textField14, String textField15, String textField16, String textField17, String textField18, String textField19, String textField20, String textField21, String textField22) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310TEXT06)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9, textField10, textField11, textField12, textField13, textField14, textField15, textField16, textField17, textField18, textField19, textField20, textField21, textField22);
	}

	public WnsTileV2Builder bindingTemplateTileSquare310x310Text07(String textField1, String textField2, String textField3, String textField4, String textField5, String textField6, String textField7, String textField8, String textField9, String textField10, String textField11, String textField12, String textField13, String textField14, String textField15, String textField16, String textField17, String textField18, String textField19) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310TEXT07)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9, textField10, textField11, textField12, textField13, textField14, textField15, textField16, textField17, textField18, textField19);
	}

	public WnsTileV2Builder bindingTemplateTileSquare310x310Text08(String textField1, String textField2, String textField3, String textField4, String textField5, String textField6, String textField7, String textField8, String textField9, String textField10, String textField11, String textField12, String textField13, String textField14, String textField15, String textField16, String textField17, String textField18, String textField19, String textField20, String textField21, String textField22) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310TEXT08)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9, textField10, textField11, textField12, textField13, textField14, textField15, textField16, textField17, textField18, textField19, textField20, textField21, textField22);
	}

	public WnsTileV2Builder bindingTemplateTileSquare310x310Text09(String textField1, String textField2, String textField3, String textField4, String textField5) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310TEXT09)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5);
	}

	public WnsTileV2Builder bindingTemplateTileSquare310x310TextList01(String textField1, String textField2, String textField3, String textField4, String textField5, String textField6, String textField7, String textField8, String textField9) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310TEXTLIST01)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9);
	}

	public WnsTileV2Builder bindingTemplateTileSquare310x310TextList02(String textField1, String textField2, String textField3) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310TEXTLIST02)
				.setBindingTextFields(textField1, textField2, textField3);
	}

	public WnsTileV2Builder bindingTemplateTileSquare310x310TextList03(String textField1, String textField2, String textField3, String textField4, String textField5, String textField6) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310TEXTLIST03)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6);
	}

	public WnsTileV2Builder bindingTemplateTileSquare310x310BlockAndText01(String textField1, String textField2, String textField3, String textField4, String textField5, String textField6, String textField7, String textField8, String textField9) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310BLOCKANDTEXT01)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9);
	}

	public WnsTileV2Builder bindingTemplateTileSquare310x310Image(String imgSrc) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310IMAGE)
				.setBindingImages(imgSrc);
	}

	public WnsTileV2Builder bindingTemplateTileSquare310x310ImageCollection(String imgSrc1, String imgSrc2, String imgSrc3, String imgSrc4, String imgSrc5, String imgSrc6) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310IMAGECOLLECTION)
				.setBindingImages(imgSrc1, imgSrc2, imgSrc3, imgSrc4, imgSrc5, imgSrc6);
	}

	public WnsTileV2Builder bindingTemplateTileSquare310x310BlockAndText02(String imgSrc, String textField1, String textField2, String textField3, String textField4, String textField5, String textField6, String textField7) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310BLOCKANDTEXT02)
				.setBindingImages(imgSrc)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6, textField7);
	}

	public WnsTileV2Builder bindingTemplateTileSquare310x310ImageAndText01(String imgSrc, String textField) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310IMAGEANDTEXT01)
				.setBindingImages(imgSrc)
				.setBindingTextFields(textField);
	}

	public WnsTileV2Builder bindingTemplateTileSquare310x310ImageAndText02(String imgSrc, String textField1, String textField2) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310IMAGEANDTEXT02)
				.setBindingImages(imgSrc)
				.setBindingTextFields(textField1, textField2);
	}

	public WnsTileV2Builder bindingTemplateTileSquare310x310ImageAndTextOverlay01(String imgSrc, String textField) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310IMAGEANDTEXTOVERLAY01)
				.setBindingImages(imgSrc)
				.setBindingTextFields(textField);
	}

	public WnsTileV2Builder bindingTemplateTileSquare310x310ImageAndTextOverlay02(String imgSrc, String textField1, String textField2) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310IMAGEANDTEXTOVERLAY02)
				.setBindingImages(imgSrc)
				.setBindingTextFields(textField1, textField2);
	}

	public WnsTileV2Builder bindingTemplateTileSquare310x310ImageAndTextOverlay03(String imgSrc, String textField1, String textField2, String textField3, String textField4) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310IMAGEANDTEXTOVERLAY03)
				.setBindingImages(imgSrc)
				.setBindingTextFields(textField1, textField2, textField3, textField4);
	}

	public WnsTileV2Builder bindingTemplateTileSquare310x310ImageCollectionAndText01(String imgSrc1, String imgSrc2, String imgSrc3, String imgSrc4, String imgSrc5, String textField) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310IMAGECOLLECTIONANDTEXT01)
				.setBindingImages(imgSrc1, imgSrc2, imgSrc3, imgSrc4, imgSrc5)
				.setBindingTextFields(textField);
	}

	public WnsTileV2Builder bindingTemplateTileSquare310x310ImageCollectionAndText02(String imgSrc1, String imgSrc2, String imgSrc3, String imgSrc4, String imgSrc5, String textField1, String textField2) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310IMAGECOLLECTIONANDTEXT02)
				.setBindingImages(imgSrc1, imgSrc2, imgSrc3, imgSrc4, imgSrc5)
				.setBindingTextFields(textField1, textField2);
	}

	public WnsTileV2Builder bindingTemplateTileSquare310x310SmallImagesAndTextList01(String imgSrc1, String imgSrc2, String imgSrc3, String textField1, String textField2, String textField3, String textField4, String textField5, String textField6, String textField7, String textField8, String textField9) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310SMALLIMAGESANDTEXTLIST01)
				.setBindingImages(imgSrc1, imgSrc2, imgSrc3)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9);
	}

	public WnsTileV2Builder bindingTemplateTileSquare310x310SmallImagesAndTextList02(String imgSrc1, String imgSrc2, String imgSrc3, String textField1, String textField2, String textField3) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310SMALLIMAGESANDTEXTLIST02)
				.setBindingImages(imgSrc1, imgSrc2, imgSrc3)
				.setBindingTextFields(textField1, textField2, textField3);
	}

	public WnsTileV2Builder bindingTemplateTileSquare310x310SmallImagesAndTextList03(String imgSrc1, String imgSrc2, String imgSrc3, String textField1, String textField2, String textField3, String textField4, String textField5, String textField6) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310SMALLIMAGESANDTEXTLIST03)
				.setBindingImages(imgSrc1, imgSrc2, imgSrc3)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6);
	}

	public WnsTileV2Builder bindingTemplateTileSquare310x310SmallImagesAndTextList04(String imgSrc1, String imgSrc2, String imgSrc3, String textField1, String textField2, String textField3, String textField4, String textField5, String textField6) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310SMALLIMAGESANDTEXTLIST04)
				.setBindingImages(imgSrc1, imgSrc2, imgSrc3)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6);
	}

	public WnsTileV2Builder bindingTemplateTileSquare310x310SmallImagesAndTextList05(String imgSrc1, String imgSrc2, String imgSrc3, String textField1, String textField2, String textField3, String textField4, String textField5, String textField6, String textField7) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310SMALLIMAGESANDTEXTLIST05)
				.setBindingImages(imgSrc1, imgSrc2, imgSrc3)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6, textField7);
	}

	public WnsTileV2Builder bindingTemplateTileSquare310x310SmallImageAndText01(String imgSrc, String textField1, String textField2, String textField3) {
		return this.bindingTemplate(WnsTileV2Template.TILESQUARE310X310SMALLIMAGEANDTEXT01)
				.setBindingImages(imgSrc)
				.setBindingTextFields(textField1, textField2, textField3);
	}

	public WnsTile build() {
		return this.tile;
	}
}
