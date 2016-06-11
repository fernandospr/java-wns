package ar.com.fernandospr.wns.model.builders;

import ar.com.fernandospr.wns.model.WnsBinding;
import ar.com.fernandospr.wns.model.WnsTile;
import ar.com.fernandospr.wns.model.WnsVisual;
import ar.com.fernandospr.wns.model.types.WnsTileTemplate;

public class WnsTileBuilder extends WnsAbstractBuilder<WnsTileBuilder> {
	private WnsTile tile;
	
	public WnsTileBuilder() {
		this.tile = new WnsTile();
	}
	
	@Override
	public WnsTileBuilder getThis() {
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

	public WnsTileBuilder visualContentId(String contentId) {
		getVisual().contentId = contentId;
		return this;
	}

	public WnsTileBuilder bindigContentId(String contentId) {
		getBinding().contentId = contentId;
		return this;
	}
		
	public WnsTileBuilder bindingTemplateTileSquareBlock(String textField1, String textField2) {
		return this.bindingTemplate(WnsTileTemplate.TILESQUAREBLOCK)
					.setBindingTextFields(textField1, textField2);
	}
	
	public WnsTileBuilder bindingTemplateTileSquareText01(String textField1, String textField2, String textField3, String textField4) {
		return this.bindingTemplate(WnsTileTemplate.TILESQUARETEXT01)
					.setBindingTextFields(textField1, textField2, textField3, textField4);
	}
	
	public WnsTileBuilder bindingTemplateTileSquareText02(String textField1, String textField2) {
		return this.bindingTemplate(WnsTileTemplate.TILESQUARETEXT02)
					.setBindingTextFields(textField1, textField2);
	}
	
	public WnsTileBuilder bindingTemplateTileSquareText03(String textField1, String textField2, String textField3, String textField4) {
		return this.bindingTemplate(WnsTileTemplate.TILESQUARETEXT03)
					.setBindingTextFields(textField1, textField2, textField3, textField4);
	}

	public WnsTileBuilder bindingTemplateTileSquareText04(String textField1) {
		return this.bindingTemplate(WnsTileTemplate.TILESQUARETEXT04)
					.setBindingTextFields(textField1);
	}
	
	public WnsTileBuilder bindingTemplateTileSquareImage(String imgSrc1, String textField1) {
		return this.bindingTemplate(WnsTileTemplate.TILESQUAREIMAGE)
					.setBindingTextFields(textField1)
					.setBindingImages(imgSrc1);
	}
	
	public WnsTileBuilder bindingTemplateTileSquarePeekImageAndText01(String imgSrc1, String textField1, String textField2, String textField3, String textField4) {
		return this.bindingTemplate(WnsTileTemplate.TILESQUAREPEEKIMAGEANDTEXT01)
					.setBindingTextFields(textField1, textField2, textField3, textField4)
					.setBindingImages(imgSrc1);
	}
	
	public WnsTileBuilder bindingTemplateTileSquarePeekImageAndText02(String imgSrc1, String textField1, String textField2) {
		return this.bindingTemplate(WnsTileTemplate.TILESQUAREPEEKIMAGEANDTEXT02)
					.setBindingTextFields(textField1, textField2)
					.setBindingImages(imgSrc1);
	}
	
	public WnsTileBuilder bindingTemplateTileSquarePeekImageAndText03(String imgSrc1, String textField1, String textField2, String textField3, String textField4) {
		return this.bindingTemplate(WnsTileTemplate.TILESQUAREPEEKIMAGEANDTEXT03)
					.setBindingTextFields(textField1, textField2, textField3, textField4)
					.setBindingImages(imgSrc1);
	}
	
	public WnsTileBuilder bindingTemplateTileSquarePeekImageAndText04(String imgSrc1, String textField1) {
		return this.bindingTemplate(WnsTileTemplate.TILESQUAREPEEKIMAGEANDTEXT04)
					.setBindingImages(imgSrc1)
					.setBindingTextFields(textField1);
	}
	
	public WnsTileBuilder bindingTemplateTileWideText01(String textField1, String textField2, String textField3, String textField4, String textField5) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDETEXT01)
					.setBindingTextFields(textField1, textField2, textField3, textField4, textField5);
	}
	
	public WnsTileBuilder bindingTemplateTileWideText02(String textField1, String textField2, String textField3, String textField4, String textField5, String textField6, String textField7, String textField8, String textField9) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDETEXT02)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9);
	}
	
	public WnsTileBuilder bindingTemplateTileWideText03(String textField1) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDETEXT03)
				.setBindingTextFields(textField1);
	}
	
	public WnsTileBuilder bindingTemplateTileWideText04(String textField1) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDETEXT04)
				.setBindingTextFields(textField1);
	}
	
	public WnsTileBuilder bindingTemplateTileWideText05(String textField1, String textField2, String textField3, String textField4, String textField5) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDETEXT05)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5);
	}
	
	public WnsTileBuilder bindingTemplateTileWideText06(String textField1, String textField2, String textField3, String textField4, String textField5, String textField6, String textField7, String textField8, String textField9, String textField10) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDETEXT06)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9, textField10);
	}
	
	public WnsTileBuilder bindingTemplateTileWideText07(String textField1, String textField2, String textField3, String textField4, String textField5, String textField6, String textField7, String textField8, String textField9) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDETEXT07)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9);
	}
	
	public WnsTileBuilder bindingTemplateTileWideText08(String textField1, String textField2, String textField3, String textField4, String textField5, String textField6, String textField7, String textField8, String textField9, String textField10) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDETEXT08)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9, textField10);
	}
	
	public WnsTileBuilder bindingTemplateTileWideText09(String textField1, String textField2) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDETEXT09)
				.setBindingTextFields(textField1, textField2);
	}
	
	public WnsTileBuilder bindingTemplateTileWideText10(String textField1, String textField2, String textField3, String textField4, String textField5, String textField6, String textField7, String textField8, String textField9) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDETEXT10)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9);
	}
	
	public WnsTileBuilder bindingTemplateTileWideText11(String textField1, String textField2, String textField3, String textField4, String textField5, String textField6, String textField7, String textField8, String textField9, String textField10) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDETEXT11)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9, textField10);
	}
	
	public WnsTileBuilder bindingTemplateTileWideImage(String imgSrc1) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDEIMAGE)
				.setBindingImages(imgSrc1);
	}
	
	public WnsTileBuilder bindingTemplateTileWideImageCollection(String imgSrc1, String imgSrc2, String imgSrc3, String imgSrc4, String imgSrc5) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDEIMAGECOLLECTION)
				.setBindingImages(imgSrc1, imgSrc2, imgSrc3, imgSrc4, imgSrc5);
	}
	
	public WnsTileBuilder bindingTemplateTileWideImageAndText01(String imgSrc1, String textField1) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDEIMAGEANDTEXT01)
				.setBindingTextFields(textField1)
				.setBindingImages(imgSrc1);
	}
	
	public WnsTileBuilder bindingTemplateTileWideImageAndText02(String imgSrc1, String textField1, String textField2) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDEIMAGEANDTEXT02)
				.setBindingTextFields(textField1, textField2)
				.setBindingImages(imgSrc1);
	}

	public WnsTileBuilder bindingTemplateTileWideBlockAndText01(String textField1, String textField2, String textField3, String textField4, String textField5, String textField6) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDEBLOCKANDTEXT01)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5, textField6);
	}
	
	public WnsTileBuilder bindingTemplateTileWideBlockAndText02(String textField1, String textField2, String textField3) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDEBLOCKANDTEXT02)
				.setBindingTextFields(textField1, textField2, textField3);
	}
	
	public WnsTileBuilder bindingTemplateTileWideSmallImageAndText01(String imgSrc1, String textField1) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDESMALLIMAGEANDTEXT01)
				.setBindingTextFields(textField1)
				.setBindingImages(imgSrc1);
	}
	
	public WnsTileBuilder bindingTemplateTileWideSmallImageAndText02(String imgSrc1, String textField1, String textField2, String textField3, String textField4, String textField5) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDESMALLIMAGEANDTEXT02)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5)
				.setBindingImages(imgSrc1);
	}
	
	public WnsTileBuilder bindingTemplateTileWideSmallImageAndText03(String imgSrc1, String textField1) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDESMALLIMAGEANDTEXT03)
				.setBindingTextFields(textField1)
				.setBindingImages(imgSrc1);
	}
	
	public WnsTileBuilder bindingTemplateTileWideSmallImageAndText04(String imgSrc1, String textField1, String textField2) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDESMALLIMAGEANDTEXT04)
				.setBindingTextFields(textField1, textField2)
				.setBindingImages(imgSrc1);
	}
	
	public WnsTileBuilder bindingTemplateTileWideSmallImageAndText05(String imgSrc1, String textField1, String textField2) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDESMALLIMAGEANDTEXT05)
				.setBindingTextFields(textField1, textField2)
				.setBindingImages(imgSrc1);
	}
	
	public WnsTileBuilder bindingTemplateTileWidePeekImageCollection01(String imgSrc1, String imgSrc2, String imgSrc3, String imgSrc4, String imgSrc5, String textField1, String textField2) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDEPEEKIMAGECOLLECTION01)
				.setBindingImages(imgSrc1, imgSrc2, imgSrc3, imgSrc4, imgSrc5)
				.setBindingTextFields(textField1, textField2);
	}
	
	public WnsTileBuilder bindingTemplateTileWidePeekImageCollection02(String imgSrc1, String imgSrc2, String imgSrc3, String imgSrc4, String imgSrc5, String textField1, String textField2, String textField3, String textField4, String textField5) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDEPEEKIMAGECOLLECTION02)
				.setBindingImages(imgSrc1, imgSrc2, imgSrc3, imgSrc4, imgSrc5)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5);
	}
	
	public WnsTileBuilder bindingTemplateTileWidePeekImageCollection03(String imgSrc1, String imgSrc2, String imgSrc3, String imgSrc4, String imgSrc5, String textField1) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDEPEEKIMAGECOLLECTION03)
				.setBindingImages(imgSrc1, imgSrc2, imgSrc3, imgSrc4, imgSrc5)
				.setBindingTextFields(textField1);
	}
	
	public WnsTileBuilder bindingTemplateTileWidePeekImageCollection04(String imgSrc1, String imgSrc2, String imgSrc3, String imgSrc4, String imgSrc5, String textField1) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDEPEEKIMAGECOLLECTION04)
				.setBindingImages(imgSrc1, imgSrc2, imgSrc3, imgSrc4, imgSrc5)
				.setBindingTextFields(textField1);
	}
	
	public WnsTileBuilder bindingTemplateTileWidePeekImageCollection05(String imgSrc1, String imgSrc2, String imgSrc3, String imgSrc4, String imgSrc5, String imgSrc6, String textField1, String textField2) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDEPEEKIMAGECOLLECTION05)
				.setBindingImages(imgSrc1, imgSrc2, imgSrc3, imgSrc4, imgSrc5, imgSrc6)
				.setBindingTextFields(textField1, textField2);
	}
	
	public WnsTileBuilder bindingTemplateTileWidePeekImageCollection06(String imgSrc1, String imgSrc2, String imgSrc3, String imgSrc4, String imgSrc5, String imgSrc6, String textField1) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDEPEEKIMAGECOLLECTION06)
				.setBindingImages(imgSrc1, imgSrc2, imgSrc3, imgSrc4, imgSrc5, imgSrc6)
				.setBindingTextFields(textField1);
	}

	public WnsTileBuilder bindingTemplateTileWidePeekImageAndText01(String imgSrc1, String textField1) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDEPEEKIMAGEANDTEXT01)
				.setBindingTextFields(textField1)
				.setBindingImages(imgSrc1);
	}

	public WnsTileBuilder bindingTemplateTileWidePeekImageAndText02(String imgSrc1, String textField1, String textField2, String textField3, String textField4, String textField5) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDEPEEKIMAGEANDTEXT02)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5)
				.setBindingImages(imgSrc1);
	}
	
	public WnsTileBuilder bindingTemplateTileWidePeekImage01(String imgSrc1, String textField1, String textField2) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDEPEEKIMAGE01)
				.setBindingTextFields(textField1, textField2)
				.setBindingImages(imgSrc1);
	}

	public WnsTileBuilder bindingTemplateTileWidePeekImage02(String imgSrc1, String textField1, String textField2, String textField3, String textField4, String textField5) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDEPEEKIMAGE02)
				.setBindingTextFields(textField1, textField2, textField3, textField4, textField5)
				.setBindingImages(imgSrc1);
	}
	
	public WnsTileBuilder bindingTemplateTileWidePeekImage03(String imgSrc1, String textField1) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDEPEEKIMAGE03)
				.setBindingTextFields(textField1)
				.setBindingImages(imgSrc1);
	}
	
	public WnsTileBuilder bindingTemplateTileWidePeekImage04(String imgSrc1, String textField1) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDEPEEKIMAGE04)
				.setBindingTextFields(textField1)
				.setBindingImages(imgSrc1);
	}
	
	public WnsTileBuilder bindingTemplateTileWidePeekImage05(String imgSrc1, String imgSrc2, String textField1, String textField2) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDEPEEKIMAGE05)
				.setBindingTextFields(textField1, textField2)
				.setBindingImages(imgSrc1, imgSrc2);
	}
	
	public WnsTileBuilder bindingTemplateTileWidePeekImage06(String imgSrc1, String imgSrc2, String textField1) {
		return this.bindingTemplate(WnsTileTemplate.TILEWIDEPEEKIMAGE06)
				.setBindingTextFields(textField1)
				.setBindingImages(imgSrc1, imgSrc2);
	}
			
	public WnsTile build() {
		return this.tile;
	}
}
