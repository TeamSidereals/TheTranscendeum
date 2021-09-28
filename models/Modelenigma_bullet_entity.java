// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelenigma_bullet_entity extends EntityModel<Entity> {
	private final ModelRenderer arrow;

	public Modelenigma_bullet_entity() {
		textureWidth = 64;
		textureHeight = 64;

		arrow = new ModelRenderer(this);
		arrow.setRotationPoint(2.5F, 16.0F, 0.0F);
		setRotationAngle(arrow, 0.0F, 0.0F, -1.5708F);
		arrow.setTextureOffset(0, 15).addBox(-8.0F, -5.0F, -2.5F, 16.0F, 5.0F, 0.0F, 0.0F, false);
		arrow.setTextureOffset(0, 10).addBox(-8.0F, -5.0F, 2.5F, 16.0F, 5.0F, 0.0F, 0.0F, false);
		arrow.setTextureOffset(0, 20).addBox(-8.0F, -5.0F, -2.5F, 3.0F, 5.0F, 5.0F, 0.0F, false);
		arrow.setTextureOffset(0, 5).addBox(-8.0F, 0.0F, -2.5F, 16.0F, 0.0F, 5.0F, 0.0F, false);
		arrow.setTextureOffset(0, 0).addBox(-8.0F, -5.0F, -2.5F, 16.0F, 0.0F, 5.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		arrow.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}