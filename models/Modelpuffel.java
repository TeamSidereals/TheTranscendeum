// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelpuffel extends EntityModel<Entity> {
	private final ModelRenderer puffel;
	private final ModelRenderer head;
	private final ModelRenderer head_r1;
	private final ModelRenderer head_r2;
	private final ModelRenderer head_r3;
	private final ModelRenderer head_r4;
	private final ModelRenderer tentacle;
	private final ModelRenderer tentacle2;

	public Modelpuffel() {
		textureWidth = 64;
		textureHeight = 64;

		puffel = new ModelRenderer(this);
		puffel.setRotationPoint(0.0F, 36.0F, 0.0F);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -24.0F, 0.0F);
		puffel.addChild(head);
		head.setTextureOffset(22, 22).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		head_r1 = new ModelRenderer(this);
		head_r1.setRotationPoint(0.0F, 24.0F, 0.0F);
		head.addChild(head_r1);
		setRotationAngle(head_r1, 0.0F, -1.5708F, -0.3927F);
		head_r1.setTextureOffset(0, 10).addBox(-5.0F, -29.6F, -22.0F, 10.0F, 0.0F, 10.0F, 0.0F, false);

		head_r2 = new ModelRenderer(this);
		head_r2.setRotationPoint(0.0F, 24.0F, 0.0F);
		head.addChild(head_r2);
		setRotationAngle(head_r2, 0.0F, -1.5708F, 0.3927F);
		head_r2.setTextureOffset(0, 0).addBox(-5.0F, -29.6F, 12.0F, 10.0F, 0.0F, 10.0F, 0.0F, false);

		head_r3 = new ModelRenderer(this);
		head_r3.setRotationPoint(0.0F, 24.0F, 0.0F);
		head.addChild(head_r3);
		setRotationAngle(head_r3, 0.3927F, 0.0F, 0.0F);
		head_r3.setTextureOffset(0, 20).addBox(-5.0F, -29.6F, 12.0F, 10.0F, 0.0F, 10.0F, 0.0F, false);

		head_r4 = new ModelRenderer(this);
		head_r4.setRotationPoint(0.0F, 24.0F, 0.0F);
		head.addChild(head_r4);
		setRotationAngle(head_r4, -0.3927F, 0.0F, 0.0F);
		head_r4.setTextureOffset(20, 0).addBox(-5.0F, -29.6F, -22.0F, 10.0F, 0.0F, 10.0F, 0.0F, false);

		tentacle = new ModelRenderer(this);
		tentacle.setRotationPoint(-0.1F, -24.0F, -2.0F);
		puffel.addChild(tentacle);
		tentacle.setTextureOffset(30, 10).addBox(-2.9F, 0.0F, 0.0F, 6.0F, 12.0F, 0.0F, 0.0F, false);

		tentacle2 = new ModelRenderer(this);
		tentacle2.setRotationPoint(0.0F, -24.0F, 2.0F);
		puffel.addChild(tentacle2);
		tentacle2.setTextureOffset(0, 30).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 12.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		puffel.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}