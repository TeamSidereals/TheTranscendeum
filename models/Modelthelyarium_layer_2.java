// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelthelyarium_layer_2 extends EntityModel<Entity> {
	private final ModelRenderer rightleg;
	private final ModelRenderer leftleg;
	private final ModelRenderer bb_main;

	public Modelthelyarium_layer_2() {
		textureWidth = 64;
		textureHeight = 32;

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(-1.9F, 13.0F, 0.0F);
		rightleg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, 0.5F, false);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(1.9F, 13.0F, 0.0F);
		leftleg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, 0.5F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(16, 23).addBox(-4.0F, -17.0F, -2.0F, 8.0F, 5.0F, 4.0F, 0.51F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
		leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}